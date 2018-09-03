package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model;

import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Modification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

/**
 * @author ZhengFang 2018/5/2
 * @since V1.0
 */
public class ModificationTable {
	private Logger logger = LoggerFactory.getLogger(ModificationTable.class);
	private TreeMap<Integer, Modification> modificationTable = new TreeMap<>();

	public void addModification(int identifier, Modification modification) {
		if (this.modificationTable.containsKey(identifier)) {
			logger.error("Failed to add modification_table to modification_table table cause duplicate identifier: " + identifier);
			throw new IllegalArgumentException("The variable modification_table have contained the identifier: " + identifier);
		}
		this.modificationTable.put(identifier, modification);
	}

	public void setModificationTable(TreeMap<Integer, Modification> modificationTable) {
		this.modificationTable = modificationTable;
	}

	public TreeMap<Integer, Modification> getModificationTable() {
		return modificationTable;
	}
}
