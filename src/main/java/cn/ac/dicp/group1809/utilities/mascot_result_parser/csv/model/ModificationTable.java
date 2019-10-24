package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model;

import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Modification;

import java.util.TreeMap;

/**
 * @author ZhengFang 2018/5/2
 * @since V1.0
 */
public class ModificationTable {
	private TreeMap<Integer, Modification> modificationTable = new TreeMap<>();

	public void addModification(int identifier, Modification modification) {
		if (this.modificationTable.containsKey(identifier)) {
			throw new IllegalArgumentException("The Variable Modification_table Have Contained the Identifier: " + identifier);
		}
		this.modificationTable.put(identifier, modification);
	}

	public TreeMap<Integer, Modification> getModificationTable() {
		return modificationTable;
	}

	public void setModificationTable(TreeMap<Integer, Modification> modificationTable) {
		this.modificationTable = modificationTable;
	}
}
