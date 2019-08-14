package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.input;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.Decoy;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

/**
 * @author ZhengFang 2018/5/1
 * @since V1.0
 */
class DecoyReader {
	private int rowNum;

	DecoyReader() {
	}

	Decoy read(List<CSVRecord> recordList, int index) {
		Decoy decoy = new Decoy();
		for (; index < recordList.size(); index++) {
			CSVRecord record = recordList.get(index);
			String value = record.get(1);
			if (value.contains("-----------------------")) {
				break;
			}
			String name = record.get(0);
			switch (name) {
				case "Number of matches above identity threshold in search of real database":
					decoy.setNumberOfMatchesAboveIdentityThresholdInSearchOfRealDatabase(Integer.valueOf(value));
					break;
				case "Number of matches above identity threshold in search of decoy database":
					decoy.setNumberOfMatchesAboveIdentityThresholdInSearchOfDecoyDatabase(Integer.valueOf(value));
					break;
				case "Number of matches above homology threshold in search of real database":
					decoy.setNumberOfMatchesAboveHomologyThresholdInSearchOfRealDatabase(Integer.valueOf(value));
					break;
				case "Number of matches above homology threshold in search of decoy database":
					decoy.setNumberOfMatchesAboveHomologyThresholdInSearchOfDecoyDatabase(Integer.valueOf(value));
					break;
				default:
					throw new IllegalArgumentException("Unknown title of csv file in Decoy section: " + name);
			}
		}
		rowNum = index;
		return decoy;
	}

	int getRowNum() {
		return rowNum;
	}
}
