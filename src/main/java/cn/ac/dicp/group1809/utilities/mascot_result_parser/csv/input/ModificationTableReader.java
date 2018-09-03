package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.input;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.FixedModificationTable;
import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.ModificationTable;
import cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model.VariableModificationTable;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Modification;
import cn.ac.dicp.group1809.utilities.proteomics_toolkit.ModificationParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author ZhengFang 2018/5/1
 * @since V1.0
 */
class ModificationTableReader {
	private Logger logger = LoggerFactory.getLogger(ModificationTableReader.class);
	private ModificationParser modificationParser = new ModificationParser();
	private int rowNum;

	ModificationTableReader() {
	}

	ModificationTable readModificationTable(List<CSVRecord> recordList, int index, boolean fixed) {
		ModificationTable modificationTable;
		if (fixed) {
			modificationTable = new FixedModificationTable();
			logger.info("Try to read fixed modification_table section.");
		} else {
			modificationTable = new VariableModificationTable();
			logger.info("Try to read variable modification_table section.");
		}
		for (index = index + 1; index < recordList.size(); index++) {
			CSVRecord record = recordList.get(index);
			String value = record.get(1);
			if (value.contains("----------------")) {
				break;
			}
			int identifier = Integer.valueOf(record.get(0));
			value=value.replace(" (","(");
			Modification modification = getModification(value,fixed);
			modification.setId(identifier);
			if (identifier == 0) {
				logger.error("Failed to generate modification table: Invalid modification table identifier: 0!");
				throw new IllegalArgumentException("Invalid modification table identifier: 0!");
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
