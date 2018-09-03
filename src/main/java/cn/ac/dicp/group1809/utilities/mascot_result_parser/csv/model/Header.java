package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model;

import java.net.URI;

/**
 * @author ZhengFang 2018/5/1
 * @since V1.0
 */
public class Header {
	private String SearchTitle;
	private String TimeStamp;
	private String User;
	private String Email;
	private URI ReportURI;
	private String PeakListDataPath;
	private String PeakListFormat;
	private String SearchType;
	private String MascotVersion;
	private String Database;
	private String FastaFile;
	private int TotalSequences;
	private int TotalResidues;
	private int SequencesAfterTaxonomyFilter;
	private int NumberOfQueries;
	private double TargetFalseDiscoveryRate;

	public String getSearchTitle() {
		return SearchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		SearchTitle = searchTitle;
	}

	public String getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public URI getReportURI() {
		return ReportURI;
	}

	public void setReportURI(URI reportURI) {
		ReportURI = reportURI;
	}

	public String getPeakListDataPath() {
		return PeakListDataPath;
	}

	public void setPeakListDataPath(String peakListDataPath) {
		PeakListDataPath = peakListDataPath;
	}

	public String getPeakListFormat() {
		return PeakListFormat;
	}

	public void setPeakListFormat(String peakListFormat) {
		PeakListFormat = peakListFormat;
	}

	public String getSearchType() {
		return SearchType;
	}

	public void setSearchType(String searchType) {
		SearchType = searchType;
	}

	public String getMascotVersion() {
		return MascotVersion;
	}

	public void setMascotVersion(String mascotVersion) {
		MascotVersion = mascotVersion;
	}

	public String getDatabase() {
		return Database;
	}

	public void setDatabase(String database) {
		Database = database;
	}

	public String getFastaFile() {
		return FastaFile;
	}

	public void setFastaFile(String fastaFile) {
		FastaFile = fastaFile;
	}

	public int getTotalSequences() {
		return TotalSequences;
	}

	public void setTotalSequences(int totalSequences) {
		TotalSequences = totalSequences;
	}

	public int getTotalResidues() {
		return TotalResidues;
	}

	public void setTotalResidues(int totalResidues) {
		TotalResidues = totalResidues;
	}

	public int getSequencesAfterTaxonomyFilter() {
		return SequencesAfterTaxonomyFilter;
	}

	public void setSequencesAfterTaxonomyFilter(int sequencesAfterTaxonomyFilter) {
		SequencesAfterTaxonomyFilter = sequencesAfterTaxonomyFilter;
	}

	public int getNumberOfQueries() {
		return NumberOfQueries;
	}

	public void setNumberOfQueries(int numberOfQueries) {
		NumberOfQueries = numberOfQueries;
	}

	public double getTargetFalseDiscoveryRate() {
		return TargetFalseDiscoveryRate;
	}

	public void setTargetFalseDiscoveryRate(double targetFalseDiscoveryRate) {
		TargetFalseDiscoveryRate = targetFalseDiscoveryRate;
	}
}
