package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model;

/**
 * @author ZhengFang 2018/5/1
 * @since V1.0
 */
public class SearchParameters {
	private String TaxonomyFilter;
	private String Enzyme;
	private int MaximumMissedCleavages;
	private String FixedModifications;
	private String VariableModifications;
	private double PeptideMassTolerance;
	private String PeptideMassToleranceUnits;
	private double FragmentMassTolerance;
	private String FragmentMassToleranceUnits;
	private String MassValues;
	private String InstrumentType;
	private boolean DecoyDatabaseAlsoSearched = false;

	public String getTaxonomyFilter() {
		return TaxonomyFilter;
	}

	public void setTaxonomyFilter(String taxonomyFilter) {
		TaxonomyFilter = taxonomyFilter;
	}

	public String getEnzyme() {
		return Enzyme;
	}

	public void setEnzyme(String enzyme) {
		Enzyme = enzyme;
	}

	public int getMaximumMissedCleavages() {
		return MaximumMissedCleavages;
	}

	public void setMaximumMissedCleavages(int maximumMissedCleavages) {
		MaximumMissedCleavages = maximumMissedCleavages;
	}

	public String getFixedModifications() {
		return FixedModifications;
	}

	public void setFixedModifications(String fixedModifications) {
		FixedModifications = fixedModifications;
	}

	public String getVariableModifications() {
		return VariableModifications;
	}

	public void setVariableModifications(String variableModifications) {
		VariableModifications = variableModifications;
	}

	public double getPeptideMassTolerance() {
		return PeptideMassTolerance;
	}

	public void setPeptideMassTolerance(double peptideMassTolerance) {
		PeptideMassTolerance = peptideMassTolerance;
	}

	public String getPeptideMassToleranceUnits() {
		return PeptideMassToleranceUnits;
	}

	public void setPeptideMassToleranceUnits(String peptideMassToleranceUnits) {
		PeptideMassToleranceUnits = peptideMassToleranceUnits;
	}

	public double getFragmentMassTolerance() {
		return FragmentMassTolerance;
	}

	public void setFragmentMassTolerance(double fragmentMassTolerance) {
		FragmentMassTolerance = fragmentMassTolerance;
	}

	public String getFragment_Mass_Tolerance_Units() {
		return FragmentMassToleranceUnits;
	}

	public void setFragment_Mass_Tolerance_Units(String fragment_Mass_Tolerance_Units) {
		FragmentMassToleranceUnits = fragment_Mass_Tolerance_Units;
	}

	public String getMassValues() {
		return MassValues;
	}

	public void setMassValues(String massValues) {
		MassValues = massValues;
	}

	public String getInstrumentType() {
		return InstrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		InstrumentType = instrumentType;
	}

	public boolean isDecoyDatabaseAlsoSearched() {
		return DecoyDatabaseAlsoSearched;
	}

	public void setDecoyDatabaseAlsoSearched(boolean decoyDatabaseAlsoSearched) {
		DecoyDatabaseAlsoSearched = decoyDatabaseAlsoSearched;
	}
}
