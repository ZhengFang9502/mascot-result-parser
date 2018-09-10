package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.input;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.Header;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author ZhengFang 2018/5/1
 * @since V1.0
 */
class HeaderReader {
	private Logger logger = LoggerFactory.getLogger(HeaderReader.class);
	private int rowNum;

	HeaderReader() {
	}

	Header read(List<CSVRecord> recordList, Integer index) {
		logger.info("Try to read header section.");
		Header header = new Header();
		for (; index < recordList.size(); index++) {
			CSVRecord record = recordList.get(index);
			String value = record.get(1);
			if (value.contains("--------")) {
				break;
			}
			String name = record.get(0);
			switch (name) {
				case "Search title":
					header.setSearchTitle(value);
					break;
				case "Timestamp":
					header.setTimeStamp(value);
					break;
				case "User":
					header.setUser(value);
					break;
				case "Email":
					header.setEmail(value);
					break;
				case "Report URI":
					try {
						header.setReportURI(new URI(value));
					} catch (URISyntaxException e) {
						throw new IllegalArgumentException(e.getMessage());
					}
					break;
				case "Peak list data path":
					header.setPeakListDataPath(value);
					break;
				case "Peak list format":
					header.setPeakListFormat(value);
					break;
				case "Search type":
					header.setSearchType(value);
					break;
				case "Mascot version":
					header.setMascotVersion(value);
					break;
				case "Database":
					header.setDatabase(value);
					break;
				case "Fasta file":
					header.setFastaFile(value);
					break;
				case "Total sequences":
					header.setTotalSequences(Integer.valueOf(value));
					break;
				case "Total residues":
					header.setTotalResidues(Integer.valueOf(value));
					break;
				case "Sequences after taxonomy filter":
					header.setSequencesAfterTaxonomyFilter(Integer.valueOf(value));
					break;
				case "Number of queries":
					header.setNumberOfQueries(Integer.valueOf(value));
					break;
				case "Target false discovery rate":
					header.setTargetFalseDiscoveryRate(Double.valueOf(value));
					break;
				default:
					logger.error("Failed to read header section: Unknown title of csv file in Header section: " + name);
					throw new IllegalArgumentException("Unknown title of csv file in Header section: " + name);
			}
		}
		rowNum = index;
		return header;
	}

	int getRowNum() {
		return rowNum;
	}
}
