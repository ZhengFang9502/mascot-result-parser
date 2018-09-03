package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model;

/**
 * @author ZhengFang 2018/5/1
 * @since V1.0
 */
public class Decoy {
	private int NumberOfMatchesAboveIdentityThresholdInSearchOfRealDatabase = 0;
	private int NumberOfMatchesAboveIdentityThresholdInSearchOfDecoyDatabase = 0;
	private int NumberOfMatchesAboveHomologyThresholdInSearchOfRealDatabase = 0;
	private int NumberOfMatchesAboveHomologyThresholdInSearchOfDecoyDatabase = 0;

	public int getNumberOfMatchesAboveIdentityThresholdInSearchOfRealDatabase() {
		return NumberOfMatchesAboveIdentityThresholdInSearchOfRealDatabase;
	}

	public void setNumberOfMatchesAboveIdentityThresholdInSearchOfRealDatabase(int numberOfMatchesAboveIdentityThresholdInSearchOfRealDatabase) {
		NumberOfMatchesAboveIdentityThresholdInSearchOfRealDatabase = numberOfMatchesAboveIdentityThresholdInSearchOfRealDatabase;
	}

	public int getNumberOfMatchesAboveIdentityThresholdInSearchOfDecoyDatabase() {
		return NumberOfMatchesAboveIdentityThresholdInSearchOfDecoyDatabase;
	}

	public void setNumberOfMatchesAboveIdentityThresholdInSearchOfDecoyDatabase(int numberOfMatchesAboveIdentityThresholdInSearchOfDecoyDatabase) {
		NumberOfMatchesAboveIdentityThresholdInSearchOfDecoyDatabase = numberOfMatchesAboveIdentityThresholdInSearchOfDecoyDatabase;
	}

	public int getNumberOfMatchesAboveHomologyThresholdInSearchOfRealDatabase() {
		return NumberOfMatchesAboveHomologyThresholdInSearchOfRealDatabase;
	}

	public void setNumberOfMatchesAboveHomologyThresholdInSearchOfRealDatabase(int numberOfMatchesAboveHomologyThresholdInSearchOfRealDatabase) {
		NumberOfMatchesAboveHomologyThresholdInSearchOfRealDatabase = numberOfMatchesAboveHomologyThresholdInSearchOfRealDatabase;
	}

	public int getNumberOfMatchesAboveHomologyThresholdInSearchOfDecoyDatabase() {
		return NumberOfMatchesAboveHomologyThresholdInSearchOfDecoyDatabase;
	}

	public void setNumberOfMatchesAboveHomologyThresholdInSearchOfDecoyDatabase(int numberOfMatchesAboveHomologyThresholdInSearchOfDecoyDatabase) {
		NumberOfMatchesAboveHomologyThresholdInSearchOfDecoyDatabase = numberOfMatchesAboveHomologyThresholdInSearchOfDecoyDatabase;
	}
}
