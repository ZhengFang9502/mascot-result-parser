package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.input;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.*;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Peptide;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.PeptideEvidence;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Protein;
import cn.ac.dicp.group1809.utilities.proteomics_toolkit.PeptideEvidenceUtils;
import cn.ac.dicp.group1809.utilities.uniprot_reader.fasta.FastaParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Generate a {@link MascotCSV MascotCSV} with necessary information defined depended on the csv file.
 *
 * @author ZhengFang 2018/1/15
 * @since V1.0
 */
public class MascotCSVReader {
	private static final MascotCSVReader INSTANCE = new MascotCSVReader();
	private static final Logger LOGGER = getLogger(MascotCSVReader.class);
	private FastaParser fastaParser = new FastaParser();

	private MascotCSVReader() {
	}

	public static MascotCSVReader getInstance() {
		return INSTANCE;
	}

	/**
	 * Read a csv file generated from <i>Mascot</i> search engine, and generate a {@link MascotCSV MascotCSV}.
	 *
	 * @param path the file location of a csv file.
	 */
	public MascotCSV read(String path) throws IOException {
		LOGGER.debug("Reading mascot identification result file: {}.", path);
		if (!path.endsWith(".csv")) {
			throw new IllegalArgumentException("Invalid File Format: " + path);
		}

		FileReader fileReader = new FileReader(path);
		CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
		List<CSVRecord> recordList = csvParser.getRecords();
		MascotCSV mascotCSV = new MascotCSV();

		int i = 0;
		loop:
		for (; i < recordList.size(); ) {
			CSVRecord record = recordList.get(i);
			String name = record.get(0);
			switch (name) {
				case "Header":
					HeaderReader headerReader = new HeaderReader();
					Header header = headerReader.read(recordList, i + 1);
					mascotCSV.setHeader(header);
					i = headerReader.getRowNum();
					break;
				case "Decoy":
					DecoyReader decoyReader = new DecoyReader();
					mascotCSV.setDecoy(decoyReader.read(recordList, i + 1));
					i = decoyReader.getRowNum();
					break;
				case "Fixed modifications":
					if (record.get(1).contains("-----------")) {
						FixedModificationTable fixed_modificationTable;
						ModificationTableReader modificationTableReader = new ModificationTableReader();
						fixed_modificationTable = (FixedModificationTable) modificationTableReader.readModificationTable(recordList, i + 1, true);
						i = modificationTableReader.getRowNum();
						mascotCSV.setFixedModifications(fixed_modificationTable);
					}
					break;
				case "Variable modifications":
					if (record.get(1).contains("-----------")) {
						VariableModificationTable variable_modifications;
						ModificationTableReader modificationTableReader = new ModificationTableReader();
						variable_modifications = (VariableModificationTable) modificationTableReader.readModificationTable(recordList, i + 1, false);
						i = modificationTableReader.getRowNum();
						mascotCSV.setVariableModifications(variable_modifications);
					}
					break;
				case "Search Parameters":
					SearchParameterReader searchParameterReader = new SearchParameterReader();
					mascotCSV.setSearchParameters(searchParameterReader.read(recordList, i + 1));
					i = searchParameterReader.getRowNum();
					break;
				case "Format parameters":
					FormatParameterReader formatParameterReader = new FormatParameterReader();
					mascotCSV.setFormatParameters(formatParameterReader.read(recordList, i + 1));
					i = formatParameterReader.getRowNum();
					break;
				case "Protein hits":
					List<PeptideHit> peptideHitList = new ProteinHitReader(mascotCSV).read(recordList, i + 1);
					mascotCSV.setPeptideHitList(peptideHitList);
					break loop;
				default:
					throw new IllegalArgumentException("Invalid Title Name: " + name);
			}
		}
		csvParser.close();
		fileReader.close();
		setPeptideEvidence(mascotCSV);
		LOGGER.debug("Finish reading mascot identification result csv file: {}, and get {} peptide hits.", path, mascotCSV.getPeptideHitList().size());
		return mascotCSV;
	}

	private void setPeptideEvidence(MascotCSV mascotCSV) throws IOException {
		String fastaFile = mascotCSV.getHeader().getFastaFile();
		HashMap<String, Protein> proteinMap = fastaParser.read(fastaFile);
		List<PeptideHit> peptideHitList = mascotCSV.getPeptideHitList();
		for (PeptideHit peptideHit : peptideHitList) {
			Peptide peptide = peptideHit.getPeptide();
			String sequence = peptide.getSequence();
			String prot_acc = peptideHit.getProt_acc();
			if (!proteinMap.containsKey(prot_acc)) {
				throw new IllegalArgumentException("The Database Does Not Contain the Protein: " + prot_acc);
			}
			Protein protein = proteinMap.get(prot_acc);
			List<PeptideEvidence> peptideEvidence = PeptideEvidenceUtils.querySingleProtein(sequence, protein);
			if (peptideEvidence != null) {
				peptide.setPeptideEvidenceList(peptideEvidence);
			}
		}
	}
}
