package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a model of MascotCSV.
 *
 * @author ZhengFang 2018/1/17
 * @since V1.0
 */
public class MascotCSV {
	private Header Header = new Header();
	private Decoy Decoy = new Decoy();
	private FixedModificationTable FixedModifications = new FixedModificationTable();
	private VariableModificationTable VariableModifications = new VariableModificationTable();
	private SearchParameters SearchParameters = new SearchParameters();
	private FormatParameters FormatParameters = new FormatParameters();
	private List<PeptideHit> PeptideHitList = new ArrayList<>();

	public Header getHeader() {
		return Header;
	}

	public void setHeader(Header header) {
		this.Header = header;
	}

	public Decoy getDecoy() {
		return Decoy;
	}

	public void setDecoy(Decoy decoy) {
		this.Decoy = decoy;
	}

	public FixedModificationTable getFixedModifications() {
		return FixedModifications;
	}

	public void setFixedModifications(FixedModificationTable fixedModifications) {
		this.FixedModifications = fixedModifications;
	}

	public VariableModificationTable getVariableModifications() {
		return VariableModifications;
	}

	public void setVariableModifications(VariableModificationTable variableModifications) {
		this.VariableModifications = variableModifications;
	}

	public SearchParameters getSearchParameters() {
		return SearchParameters;
	}

	public void setSearchParameters(SearchParameters searchParameters) {
		this.SearchParameters = searchParameters;
	}

	public FormatParameters getFormatParameters() {
		return FormatParameters;
	}

	public void setFormatParameters(FormatParameters formatParameters) {
		this.FormatParameters = formatParameters;
	}

	public List<PeptideHit> getPeptideHitList() {
		return PeptideHitList;
	}

	public void setPeptideHitList(List<PeptideHit> peptideHitList) {
		this.PeptideHitList = peptideHitList;
	}
}
