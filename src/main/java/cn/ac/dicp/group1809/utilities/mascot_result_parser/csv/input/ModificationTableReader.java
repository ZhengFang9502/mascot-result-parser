package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.input;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.FixedModificationTable;
import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.ModificationTable;
import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.VariableModificationTable;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Modification;
import cn.ac.dicp.group1809.utilities.proteomics_toolkit.ModificationParser;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

/**
 * @author ZhengFang 2018/5/1
 * @since V1.0
 */
class ModificationTableReader {
	private ModificationParser modificationParser = new ModificationParser();
	private int rowNum;

	ModificationTableReader() {
	}

	ModificationTable readModificationTable(List<CSVRecord> recordList, int index, boolean fixed) {
		ModificationTable modificationTable;
		if (fixed) {
			modificationTable = new FixedModificationTable();
		} else {
			modificationTable = new VariableModificationTable();
		}
		for (index = index + 1; index < recordList.size(); index++) {
			CSVRecord record = recordList.get(index);
			String value = record.get(1);
			if (value.contains("----------------")) {
				break;
			}
			int identifier = Integer.valueOf(record.get(0));
			value = value.replace(" (", "(");
			Modification modification = getModification(value, fixed);
			modification.setId(identifier);
			if (identifier == 0) {
				throw new IllegalArgumentException("Invalid Modification Table Identifier: 0!");
			}
			modificationTable.addModification(identifier, modification);
		}
		rowNum = index;
		return modificationTable;
	}

	private Modification getModification(String s, boolean fixed) {
		String[] ss = {s};
		modificationParser.setModificationTable(ss, true);
		Modification modification = modificationParser.getFixedModificationTable().get(1);
		modification.setFixed(fixed);
		return modification;
	}

	int getRowNum() {
		return rowNum;
	}
}
