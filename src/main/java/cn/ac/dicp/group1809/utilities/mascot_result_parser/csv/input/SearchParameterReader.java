package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.input;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.SearchParameters;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

/**
 * @author ZhengFang 2018/5/2
 * @since V1.0
 */
class SearchParameterReader {
	private int rowNum = -1;

	SearchParameters read(List<CSVRecord> recordList, int index) {
		SearchParameters search_parameters = new SearchParameters();
		for (; index < recordList.size(); index++) {
			CSVRecord record = recordList.get(index);
			String name = record.get(0);
			String value = record.get(1);
			if (value.contains("-----------------")) {
				break;
			}
			switch (name) {
				case "Taxonomy filter":
					search_parameters.setTaxonomyFilter(value);
					break;
				case "Enzyme":
					search_parameters.setEnzyme(value);
					break;
				case "Maximum Missed Cleavages":
					search_parameters.setMaximumMissedCleavages(Integer.valueOf(value));
					break;
				case "Fixed modifications":
					search_parameters.setFixedModifications(value);
					break;
				case "Variable modifications":
					search_parameters.setVariableModifications(value);
					break;
				case "Peptide Mass Tolerance":
					search_parameters.setPeptideMassTolerance(Double.valueOf(value));
					break;
				case "Peptide Mass Tolerance Units":
					search_parameters.setPeptideMassToleranceUnits(value);
					break;
				case "Fragment Mass Tolerance":
					search_parameters.setFragmentMassTolerance(Double.valueOf(value));
					break;
				case "Fragment Mass Tolerance Units":
					search_parameters.setFragment_Mass_Tolerance_Units(value);
					break;
				case "Mass values":
					search_parameters.setMassValues(value);
					break;
				case "Instrument type":
					search_parameters.setInstrumentType(value);
					break;
				case "Decoy database also searched":
					search_parameters.setDecoyDatabaseAlsoSearched(value.equals("1"));
					break;
				default:
					throw new IllegalArgumentException("Unknown Title of CSV File in Search Parameters Section: " + name);
			}
		}
		rowNum = index;
		return search_parameters;
	}

	int getRowNum() {
		return rowNum;
	}
}
