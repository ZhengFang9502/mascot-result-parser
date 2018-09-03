package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model;

/**
 * @author ZhengFang 2018/5/1
 * @since V1.0
 */
public class FormatParameters {
	private double SignificanceThreshold;
	private int MaxNumberOfHits;
	private boolean UseMudPITProteinScoring;
	private double IonsScoreCutOff;
	private boolean IncludeSameSetProteins;
	private boolean IncludeSubsetProteins;
	private boolean IncludeUnassigned;
	private boolean RequireBoldRed;
	private boolean UseHomologyThreshold;
	private boolean GroupProteinFamilies;
	private boolean RescoreUsingPercolator;
	private boolean ShowDuplicatePeptides;

	public double getSignificanceThreshold() {
		return SignificanceThreshold;
	}

	public void setSignificanceThreshold(double significanceThreshold) {
		SignificanceThreshold = significanceThreshold;
	}

	public int getMaxNumberOfHits() {
		return MaxNumberOfHits;
	}

	public void setMaxNumberOfHits(int maxNumberOfHits) {
		MaxNumberOfHits = maxNumberOfHits;
	}

	public boolean isUseMudPITProteinScoring() {
		return UseMudPITProteinScoring;
	}

	public void setUseMudPITProteinScoring(boolean useMudPITProteinScoring) {
		UseMudPITProteinScoring = useMudPITProteinScoring;
	}

	public double getIonsScoreCutOff() {
		return IonsScoreCutOff;
	}

	public void setIonsScoreCutOff(double ionsScoreCutOff) {
		IonsScoreCutOff = ionsScoreCutOff;
	}

	public boolean isIncludeSameSetProteins() {
		return IncludeSameSetProteins;
	}

	public void setIncludeSameSetProteins(boolean includeSameSetProteins) {
		IncludeSameSetProteins = includeSameSetProteins;
	}

	public boolean isIncludeSubsetProteins() {
		return IncludeSubsetProteins;
	}

	public void setIncludeSubsetProteins(boolean includeSubsetProteins) {
		IncludeSubsetProteins = includeSubsetProteins;
	}

	public boolean isIncludeUnassigned() {
		return IncludeUnassigned;
	}

	public void setIncludeUnassigned(boolean includeUnassigned) {
		IncludeUnassigned = includeUnassigned;
	}

	public boolean isRequireBoldRed() {
		return RequireBoldRed;
	}

	public void setRequireBoldRed(boolean requireBoldRed) {
		RequireBoldRed = requireBoldRed;
	}

	public boolean isUseHomologyThreshold() {
		return UseHomologyThreshold;
	}

	public void setUseHomologyThreshold(boolean useHomologyThreshold) {
		UseHomologyThreshold = useHomologyThreshold;
	}

	public boolean isGroupProteinFamilies() {
		return GroupProteinFamilies;
	}

	public void setGroupProteinFamilies(boolean groupProteinFamilies) {
		GroupProteinFamilies = groupProteinFamilies;
	}

	public boolean isRescoreUsingPercolator() {
		return RescoreUsingPercolator;
	}

	public void setRescoreUsingPercolator(boolean rescoreUsingPercolator) {
		RescoreUsingPercolator = rescoreUsingPercolator;
	}

	public boolean isShowDuplicatePeptides() {
		return ShowDuplicatePeptides;
	}

	public void setShowDuplicatePeptides(boolean showDuplicatePeptides) {
		ShowDuplicatePeptides = showDuplicatePeptides;
	}
}
