package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.input;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.MascotCSV;
import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.PeptideHit;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.common.Composition;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Modification;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.ModificationSite;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.enumeration.AminoAcid;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.enumeration.Constant;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author ZhengFang 2018/5/2
 * @since V1.0
 */
class ProteinHitReader {
	private Logger logger = LoggerFactory.getLogger(ProteinHitReader.class);
	private TreeMap<Integer, Modification> fixedModificationTable;
	private TreeMap<Integer, Modification> variableModificationTable;

	ProteinHitReader(MascotCSV mascotCSVFile) {
		fixedModificationTable = mascotCSVFile.getFixedModifications().getModificationTable();
		variableModificationTable = mascotCSVFile.getVariableModifications().getModificationTable();
	}

	/**
	 * Generate a list of {@link PeptideHit PeptideHit} in which each item's attribute been set.
	 *
	 * @param recordList a list of {@link CSVRecord CSVRecord}
	 * @param index      the row number of first title row.
	 * @return a list of peptide.
	 */
	List<PeptideHit> read(List<CSVRecord> recordList, int index) {
		logger.info("Try to read protein hits.");
		CSVRecord titleRecord = recordList.get(index);
		List<PeptideHit> peptideHitList = new ArrayList<>();
		for (index = index + 1; index < recordList.size(); index++) {
			CSVRecord record = recordList.get(index);
			PeptideHit peptideHit = new PeptideHit();
			for (int j = 0; j < record.size(); j++) {
				String name = titleRecord.get(j);
				String value = record.get(j);
				if (value.isEmpty()) continue;
				switch (name) {
					case "prot_hit_num":
						peptideHit.setProt_hit_num(Integer.valueOf(value));
						break;
					case "prot_family_member":
						peptideHit.setProt_family_member(Integer.valueOf(value));
						break;
					case "prot_acc":
						peptideHit.setProt_acc(value);
						break;
					case "prot_desc":
						peptideHit.setProt_desc(value);
						break;
					case "prot_score":
						peptideHit.setProt_score(Integer.valueOf(value));
						break;
					case "prot_thresh":
						peptideHit.setProt_thresh(value);
						break;
					case "prot_expect":
						peptideHit.setProt_expect(value);
						break;
					case "prot_mass":
						peptideHit.setProt_mass(Integer.valueOf(value));
						break;
					case "prot_matches":
						peptideHit.setProt_matches(Integer.valueOf(value));
						break;
					case "prot_matches_sig":
						peptideHit.setProt_matches_sig(Integer.valueOf(value));
						break;
					case "prot_sequences":
						peptideHit.setProt_sequences(Integer.valueOf(value));
						break;
					case "prot_sequences_sig":
						peptideHit.setProt_sequences_sig(Integer.valueOf(value));
						break;
					case "prot_cover":
						peptideHit.setProt_cover(value);
						break;
					case "prot_len":
						peptideHit.setProt_len(Integer.valueOf(value));
						break;
					case "prot_pi":
						peptideHit.setProt_pi(value);
						break;
					case "prot_tax_str":
						peptideHit.setProt_tax_str(value);
						break;
					case "prot_tax_id":
						peptideHit.setProt_tax_id(value);
						break;
					case "prot_seq":
						peptideHit.setProt_seq(value);
						break;
					case "prot_empai":
						peptideHit.setProt_empai(value);
						break;
					case "pep_query":
						peptideHit.setPep_query(Integer.valueOf(value));
						break;
					case "pep_rank":
						peptideHit.setPep_rank(Integer.valueOf(value));
						break;
					case "pep_isbold":
						peptideHit.setPep_isbold(value.equals("1"));
						break;
					case "pep_isunique":
						peptideHit.setPep_isunique(value.equals("1"));
						break;
					case "pep_exp_mz":
						peptideHit.setPep_exp_mz(Double.valueOf(value));
						break;
					case "pep_exp_mr":
						peptideHit.setPep_exp_mr(Double.valueOf(value));
						break;
					case "pep_exp_z":
						peptideHit.setPep_exp_z(Integer.valueOf(value));
						break;
					case "pep_calc_mr":
						peptideHit.setPep_calc_mr(Double.valueOf(value));
						break;
					case "pep_delta":
						peptideHit.setPep_delta(Double.valueOf(value));
						break;
					case "pep_start":
						peptideHit.setPep_start(Integer.valueOf(value));
						break;
					case "pep_end":
						peptideHit.setPep_end(Integer.valueOf(value));
						break;
					case "pep_miss":
						peptideHit.setPep_miss(Integer.valueOf(value));
						break;
					case "pep_score":
						peptideHit.setPep_score(Double.valueOf(value));
						break;
					case "pep_homol":
						peptideHit.setPep_homol(Double.valueOf(value));
						break;
					case "pep_ident":
						peptideHit.setPep_ident(Double.valueOf(value));
						break;
					case "pep_expect":
						peptideHit.setPep_expect(Double.valueOf(value));
						break;
					case "pep_res_before":
						peptideHit.setPep_res_before(value.charAt(0));
						break;
					case "pep_seq":
						peptideHit.setPep_seq(value);
						break;
					case "pep_res_after":
						peptideHit.setPep_res_after(value.charAt(0));
						break;
					case "pep_frame":
						peptideHit.setPep_frame(value);
						break;
					case "pep_var_mod":
						peptideHit.setPep_var_mod(value);
						break;
					case "pep_var_mod_pos":
						peptideHit.setPep_var_mod_pos(value);
						break;
					case "pep_summed_mod_pos":
						peptideHit.setPep_summed_mod_pos(value);
						break;
					case "pep_local_mod_pos":
						peptideHit.setPep_local_mod_pos(value);
						break;
					case "pep_var_mod_conf":
						peptideHit.setPep_var_mod_conf(value);
						break;
					case "pep_num_match":
						peptideHit.setPep_num_match(Integer.valueOf(value));
						break;
					case "pep_scan_title":
						peptideHit.setPep_scan_title(value);
						break;
					case "pep_source":
						peptideHit.setPep_source(value);
						break;
					default:
						logger.error("Failed to read protein hits: Unknown title of csv file in Protein hits section: " + name);
						throw new IllegalArgumentException("Unknown title of csv file in Protein hits section: " + name);
				}
			}
			setProperty(peptideHit);
			peptideHitList.add(peptideHit);
		}
		return peptideHitList;
	}

	private void setProperty(PeptideHit peptideHit) {
		char beforeResidue = peptideHit.getBeforeResidue();
		String sequence = peptideHit.getSequence();
		char afterResidue = peptideHit.getAfterResidue();
		char[] sequenceAAs = sequence.toCharArray();
		int length = sequenceAAs.length;
		AminoAcid firstAA = AminoAcid.forOneLetter(sequenceAAs[0]);
		AminoAcid lastAA = AminoAcid.forOneLetter(sequenceAAs[length - 1]);
		TreeMap<Integer, Modification> modificationPosition = new TreeMap<>();
		for (Integer fixedId : fixedModificationTable.keySet()) {
			Modification fixedModification = fixedModificationTable.get(fixedId);
			TreeSet<ModificationSite> modificationSites = fixedModification.getModificationSites();
			for (ModificationSite modificationSite : modificationSites) {
				AminoAcid aminoAcid = modificationSite.getAminoAcid();
				ModificationSite.Position position = modificationSite.getPosition();
				switch (position) {
					case AnyNTerm:
						if (aminoAcid == null || firstAA.equals(aminoAcid)) {
							modificationPosition.put(0, fixedModification);
						}
						break;
					case AnyCTerm:
						if (aminoAcid == null || lastAA.equals(aminoAcid)) {
							modificationPosition.put(length - 1, fixedModification);
						}
						break;
					case ProteinNTerm:
						if (beforeResidue == '\0') {
							if (aminoAcid == null || firstAA.equals(aminoAcid)) {
								modificationPosition.put(0, fixedModification);
							}
						}
						break;
					case ProteinCTerm:
						if (afterResidue == '\0') {
							if (aminoAcid == null || lastAA.equals(aminoAcid)) {
								modificationPosition.put(length - 1, fixedModification);
							}
						}
						break;
					case Anywhere:
						char aa = aminoAcid.getOneLetter();
						for (int i = 0; i < length - 1; i++) {
							char sequenceAA = sequenceAAs[i];
							if (sequenceAA == aa) {
								modificationPosition.put(i, fixedModification);
							}
						}
						break;
				}
			}
		}
		String pep_var_mod_pos = peptideHit.getPep_var_mod_pos();
		if (pep_var_mod_pos != null) {
			String[] split = pep_var_mod_pos.split("\\.");
			char[] chars = split[1].toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] != '0') {
					int id = chars[i] - 48;
					modificationPosition.put(i, variableModificationTable.get(id));
				}
			}
		}
		peptideHit.setModificationPosition(modificationPosition);
		Composition composition = new Composition();
		for (char sequenceAA : sequenceAAs) {
			AminoAcid aminoAcid = AminoAcid.forOneLetter(sequenceAA);
			composition.add(aminoAcid.getResidueComposition());
		}
		composition.add(Constant.Water.getComposition());
		for (Modification modification : modificationPosition.values()) {
			composition.add(modification.getComposition());
		}
		peptideHit.setComposition(composition);
	}
}
