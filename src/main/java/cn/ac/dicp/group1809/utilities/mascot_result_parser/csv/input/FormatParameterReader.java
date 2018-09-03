package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.input;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.FormatParameters;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author ZhengFang 2018/5/2
 * @since V1.0
 */
class FormatParameterReader {
	private Logger logger = LoggerFactory.getLogger(FormatParameterReader.class);
	private int rowNum;

	FormatParameterReader() {
	}

	FormatParameters read(List<CSVRecord> recordList, int index) {
		logger.info("Try to read format parameter section.");
		FormatParameters format_parameters = new FormatParameters();
		for (; index < recordList.size(); index++) {
			CSVRecord record = recordList.get(index);
			String value = record.get(1);
			if (value.contains("-----------------------")) {
				break;
			}
			String name = record.get(0);
			switch (name) {
				case "Significance threshold":
					format_parameters.setSignificanceThreshold(Double.valueOf(value));
					break;
				case "Max. number of hits":
					format_parameters.setMaxNumberOfHits(Integer.valueOf(value));
					break;
				case "Use MudPIT protein scoring":
					format_parameters.setUseMudPITProteinScoring(value.equals("1"));
					break;
				case "Ions score cut-off":
					format_parameters.setIonsScoreCutOff(Double.valueOf(value));
					break;
				case "Include same-set proteins":
					format_parameters.setIncludeSameSetProteins(value.equals("1"));
					break;
				case "Include sub-set proteins":
					format_parameters.setIncludeSubsetProteins(value.equals("1"));
					break;
				case "Include unassigned":
					format_parameters.setIncludeUnassigned(value.equals("1"));
					break;
				case "Require bold red":
					format_parameters.setRequireBoldRed(value.equals("1"));
					break;
				case "Use homology threshold":
					format_parameters.setUseHomologyThreshold(value.equals("1"));
					break;
				case "Group protein families":
					format_parameters.setGroupProteinFamilies(value.equals("1"));
					break;
				case "Re-score using Percolator":
					format_parameters.setRescoreUsingPercolator(value.equals("1"));
					break;
				case "Show duplicate peptides":
					format_parameters.setShowDuplicatePeptides(value.equals("1"));
					break;
				default:
					logger.error("Failed to read format parameter section: Unknown title of csv file in format parameters section: " + name);
					throw new IllegalArgumentException("Unknown title of csv file in format parameters section: " + name);
			}
		}
		rowNum = index;
		return format_parameters;
	}

	public int getRowNum() {
		return rowNum;
	}
}
