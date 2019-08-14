package cn.ac.dicp.group1809.utilities.mascot_result_parser.csv.model;

import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.*;
import cn.ac.dicp.group1809.utilities.proteomics_toolkit.TitleParser;

import java.util.List;

/**
 * A model of a peptide hit of mascot search result.
 *
 * @author ZhengFang 2018/1/15
 * @since V1.0
 */
public class PeptideHit extends PSM {
	private static final long serialVersionUID = -1031640682811256463L;
	/**
	 * Ordinal number of the protein hit (or protein family when grouping enabled)
	 */
	private int prot_hit_num;
	/**
	 * Ordinal number of the protein family member when grouping enabled
	 */
	private int prot_family_member;
	/**
	 * Protein accession string
	 */
	private String prot_acc;
	/**
	 * Protein description taken from Fasta title line.
	 */
	private String prot_desc;
	/**
	 * Protein Mascot score
	 */
	private int prot_score;
	/**
	 * Threshold score for a significant protein match (PMF only)
	 */
	private String prot_thresh;
	/**
	 * Expectation value of the protein match (PMF only)
	 */
	private String prot_expect;
	/**
	 * Protein mass
	 */
	private int prot_mass;
	/**
	 * Count of PSMs
	 */
	private int prot_matches;
	/**
	 * Count of PSMs that have significant scores
	 */
	private int prot_matches_sig;
	/**
	 * Count of distinct sequences
	 */
	private int prot_sequences;
	/**
	 * Count of distinct sequences that have significant scores
	 */
	private int prot_sequences_sig;
	/**
	 * Protein sequence coverage
	 */
	private String prot_cover;
	/**
	 * Protein length in residues
	 */
	private int prot_len;
	/**
	 * Calculated protein isoelectric point
	 */
	private String prot_pi;
	/**
	 * Protein taxonomy as string
	 */
	private String prot_tax_str;
	/**
	 * Protein taxonomy as Tax ID
	 */
	private String prot_tax_id;
	/**
	 * Protein sequence in 1 letter code
	 */
	private String prot_seq;
	/**
	 * Protein emPAI value (spectral counting)
	 */
	private String prot_empai;
	/**
	 * Ordinal number of query after sorting by Mr
	 */
	private int pep_query;
	/**
	 * PeptideHit sequence match (PSM) rank. If two PSMs have same score they have the same rank.
	 */
	private int pep_rank;
	/**
	 * If grouping enabled, then a significant PSM. Otherwise, indicates this is the highest scoring protein that contains a match to this query.
	 */
	private boolean pep_isbold;
	/**
	 * PeptideHit sequence is unique to hit (grouping off) or family member (grouping on)
	 */
	private boolean pep_isunique;
	/**
	 * pep_exp_mr – pep_calc_mr
	 */
	private double pep_delta;
	/**
	 * Count of missed cleavage sites in peptide
	 */
	private int pep_miss;
	/**
	 * Homology threshold score for PSM
	 */
	private double pep_homol;
	/**
	 * Identity threshold score for PSM
	 */
	private double pep_ident;
	/**
	 * Expectation value for PSM
	 */
	private double pep_expect;
	/**
	 * Translation frame number (only for NA sequence databases)
	 */
	private String pep_frame;
	/**
	 * Variable modifications from all sources as list of names
	 */
	private String pep_var_mod;
	/**
	 * Variable modifications as a string of digits, e.g. ’0.0001000.0′. Non-zero digits identify mods according to key in export header. First and last positions are for terminus mods.
	 */
	private String pep_var_mod_pos;
	/**
	 * When two variable modifications occur at the same site, a string of digits defining the second mod
	 */
	private String pep_summed_mod_pos;
	/**
	 * Query-level variable modifications as a string of digits. The names of the mods will be listed in pep_var_mod
	 */
	private String pep_local_mod_pos;
	/**
	 * Percent confidence from site analysis for the variable modification_table sites
	 */
	private String pep_var_mod_conf;
	/**
	 * Count of fragment ion matches in ion series used to calculate the score
	 */
	private int pep_num_match;
	/**
	 * OrganismNameTypeEnum of database (AA, NA, XA, or SL)
	 */
	private String pep_source;

	public int getProt_hit_num() {
		return prot_hit_num;
	}

	public void setProt_hit_num(int prot_hit_num) {
		this.prot_hit_num = prot_hit_num;
	}

	public int getProt_family_member() {
		return prot_family_member;
	}

	public void setProt_family_member(int prot_family_member) {
		this.prot_family_member = prot_family_member;
	}

	public String getProt_acc() {
		return this.prot_acc;
	}

	public void setProt_acc(String prot_acc) {
		this.prot_acc = prot_acc;
	}

	public String getProt_desc() {
		return prot_desc;
	}

	public void setProt_desc(String prot_desc) {
		this.prot_desc = prot_desc;
	}

	public int getProt_score() {
		return prot_score;
	}

	public void setProt_score(int prot_score) {
		this.prot_score = prot_score;
	}

	public String getProt_thresh() {
		return prot_thresh;
	}

	public void setProt_thresh(String prot_thresh) {
		this.prot_thresh = prot_thresh;
	}

	public String getProt_expect() {
		return prot_expect;
	}

	public void setProt_expect(String prot_expect) {
		this.prot_expect = prot_expect;
	}

	public int getProt_mass() {
		return prot_mass;
	}

	public void setProt_mass(int prot_mass) {
		this.prot_mass = prot_mass;
	}

	public int getProt_matches() {
		return prot_matches;
	}

	public void setProt_matches(int prot_matches) {
		this.prot_matches = prot_matches;
	}

	public int getProt_matches_sig() {
		return prot_matches_sig;
	}

	public void setProt_matches_sig(int prot_matches_sig) {
		this.prot_matches_sig = prot_matches_sig;
	}

	public int getProt_sequences() {
		return prot_sequences;
	}

	public void setProt_sequences(int prot_sequences) {
		this.prot_sequences = prot_sequences;
	}

	public int getProt_sequences_sig() {
		return prot_sequences_sig;
	}

	public void setProt_sequences_sig(int prot_sequences_sig) {
		this.prot_sequences_sig = prot_sequences_sig;
	}

	public String getProt_cover() {
		return prot_cover;
	}

	public void setProt_cover(String prot_cover) {
		this.prot_cover = prot_cover;
	}

	public int getProt_len() {
		return prot_len;
	}

	public void setProt_len(int prot_len) {
		this.prot_len = prot_len;
	}

	public String getProt_pi() {
		return prot_pi;
	}

	public void setProt_pi(String prot_pi) {
		this.prot_pi = prot_pi;
	}

	public String getProt_tax_str() {
		return prot_tax_str;
	}

	public void setProt_tax_str(String prot_tax_str) {
		this.prot_tax_str = prot_tax_str;
	}

	public String getProt_tax_id() {
		return prot_tax_id;
	}

	public void setProt_tax_id(String prot_tax_id) {
		this.prot_tax_id = prot_tax_id;
	}

	public String getProt_seq() {
		return prot_seq;
	}

	public void setProt_seq(String prot_seq) {
		this.prot_seq = prot_seq;
	}

	public String getProt_empai() {
		return prot_empai;
	}

	public void setProt_empai(String prot_empai) {
		this.prot_empai = prot_empai;
	}

	public int getPep_query() {
		return pep_query;
	}

	public void setPep_query(int pep_query) {
		this.pep_query = pep_query;
	}

	public int getPep_rank() {
		return pep_rank;
	}

	public void setPep_rank(int pep_rank) {
		this.pep_rank = pep_rank;
	}

	public boolean isPep_isbold() {
		return pep_isbold;
	}

	public void setPep_isbold(boolean pep_isbold) {
		this.pep_isbold = pep_isbold;
	}

	public boolean isPep_isunique() {
		return pep_isunique;
	}

	public void setPep_isunique(boolean pep_isunique) {
		this.pep_isunique = pep_isunique;
	}

	public double getPep_exp_mz() {
		return super.getPrecursor().getMz();
	}

	public void setPep_exp_mz(double pep_exp_mz) {
		Precursor precursor = super.getPrecursor();
		if (precursor == null) {
			precursor = new Precursor();
		}
		precursor.setMz(pep_exp_mz);
		super.setPrecursor(precursor);
	}

	public double getPep_exp_mr() {
		return super.getPeptideExpMW();
	}

	public void setPep_exp_mr(double pep_exp_mr) {
		super.setPeptideExpMW(pep_exp_mr);
	}

	public int getPep_exp_z() {
		return super.getPrecursor().getCharge();
	}

	public void setPep_exp_z(int pep_exp_z) {
		Precursor precursor = super.getPrecursor();
		precursor.setCharge(pep_exp_z);
	}

	public double getPep_calc_mr() {
		return super.getPeptide().getMonoisotopicMW();
	}

	public void setPep_calc_mr(double pep_calc_mr) {
		Peptide peptide = super.getPeptide();
		peptide.setMonoisotopicMW(pep_calc_mr);
	}

	public double getPep_delta() {
		return this.pep_delta;
	}

	public void setPep_delta(double pep_delta) {
		this.pep_delta = pep_delta;
	}

	public int getPep_start() {
		return super.getPeptide().getPeptideEvidenceList().get(0).getStart();
	}

	public void setPep_start(int pep_start) {
		Peptide peptide = super.getPeptide();
		List<PeptideEvidence> peptideEvidenceList = peptide.getPeptideEvidenceList();
		if (peptideEvidenceList.size() == 0) {
			PeptideEvidence peptideEvidence = new PeptideEvidence();
			peptideEvidenceList.add(peptideEvidence);
			peptide.setPeptideEvidenceList(peptideEvidenceList);
		}
		peptide.getPeptideEvidenceList().get(0).setStart(pep_start);
	}

	public int getPep_end() {
		return super.getPeptide().getPeptideEvidenceList().get(0).getEnd();
	}

	public void setPep_end(int pep_end) {
		Peptide peptide = super.getPeptide();
		List<PeptideEvidence> peptideEvidenceList = peptide.getPeptideEvidenceList();
		if (peptideEvidenceList.size() == 0) {
			PeptideEvidence peptideEvidence = new PeptideEvidence();
			peptideEvidenceList.add(peptideEvidence);
			peptide.setPeptideEvidenceList(peptideEvidenceList);
		}
		peptide.getPeptideEvidenceList().get(0).setEnd(pep_end);
	}

	public int getPep_miss() {
		return pep_miss;
	}

	public void setPep_miss(int pep_miss) {
		this.pep_miss = pep_miss;
	}

	public double getPep_score() {
		return super.getPSMScore();
	}

	public void setPep_score(double pep_score) {
		super.setPSMScore(pep_score);
	}

	public double getPep_homol() {
		return pep_homol;
	}

	public void setPep_homol(double pep_homol) {
		this.pep_homol = pep_homol;
	}

	public double getPep_ident() {
		return pep_ident;
	}

	public void setPep_ident(double pep_ident) {
		this.pep_ident = pep_ident;
	}

	public double getPep_expect() {
		return pep_expect;
	}

	public void setPep_expect(double pep_expect) {
		this.pep_expect = pep_expect;
	}

	public char getPep_res_before() {
		return super.getPeptide().getPeptideEvidenceList().get(0).getBeforeResidue();
	}

	public void setPep_res_before(char pep_res_before) {
		Peptide peptide = super.getPeptide();
		List<PeptideEvidence> peptideEvidenceList = peptide.getPeptideEvidenceList();
		if (peptideEvidenceList.size() == 0) {
			PeptideEvidence peptideEvidence = new PeptideEvidence();
			peptideEvidenceList.add(peptideEvidence);
			peptide.setPeptideEvidenceList(peptideEvidenceList);
		}
		peptide.getPeptideEvidenceList().get(0).setBeforeResidue(pep_res_before);
	}

	public String getPep_seq() {
		return super.getPeptide().getSequence();
	}

	public void setPep_seq(String pep_seq) {
		Peptide peptide = super.getPeptide();
		peptide.setSequence(pep_seq);
	}

	public char getPep_res_after() {
		return super.getPeptide().getPeptideEvidenceList().get(0).getAfterResidue();
	}

	public void setPep_res_after(char pep_res_after) {
		Peptide peptide = super.getPeptide();
		List<PeptideEvidence> peptideEvidenceList = peptide.getPeptideEvidenceList();
		if (peptideEvidenceList.size() == 0) {
			PeptideEvidence peptideEvidence = new PeptideEvidence();
			peptideEvidenceList.add(peptideEvidence);
			peptide.setPeptideEvidenceList(peptideEvidenceList);
		}
		peptide.getPeptideEvidenceList().get(0).setAfterResidue(pep_res_after);
	}

	public String getPep_frame() {
		return pep_frame;
	}

	public void setPep_frame(String pep_frame) {
		this.pep_frame = pep_frame;
	}

	public String getPep_var_mod() {
		return pep_var_mod;
	}

	public void setPep_var_mod(String pep_var_mod) {
		this.pep_var_mod = pep_var_mod;
	}

	public String getPep_var_mod_pos() {
		return this.pep_var_mod_pos;
	}

	public void setPep_var_mod_pos(String pep_var_mod_pos) {
		this.pep_var_mod_pos = pep_var_mod_pos;
	}

	public String getPep_summed_mod_pos() {
		return pep_summed_mod_pos;
	}

	public void setPep_summed_mod_pos(String pep_summed_mod_pos) {
		this.pep_summed_mod_pos = pep_summed_mod_pos;
	}

	public String getPep_local_mod_pos() {
		return pep_local_mod_pos;
	}

	public void setPep_local_mod_pos(String pep_local_mod_pos) {
		this.pep_local_mod_pos = pep_local_mod_pos;
	}

	public String getPep_var_mod_conf() {
		return pep_var_mod_conf;
	}

	public void setPep_var_mod_conf(String pep_var_mod_conf) {
		this.pep_var_mod_conf = pep_var_mod_conf;
	}

	public int getPep_num_match() {
		return pep_num_match;
	}

	public void setPep_num_match(int pep_num_match) {
		this.pep_num_match = pep_num_match;
	}

	public String getPep_scan_title() {
		return super.getTitle();
	}

	public void setPep_scan_title(String pep_scan_title) {
		MsnSpectrum msnSpectrum = new MsnSpectrum();
		msnSpectrum.setTitle(pep_scan_title);
		msnSpectrum.setScanNumber(TitleParser.getScanNumber(pep_scan_title));
		super.setSpectrum(msnSpectrum);
	}

	public String getPep_source() {
		return pep_source;
	}

	public void setPep_source(String pep_source) {
		this.pep_source = pep_source;
	}

	@Override
	public int hashCode() {
		return this.getPep_seq().length();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PeptideHit)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		PeptideHit peptideHit = (PeptideHit) obj;
		String pep_seq = peptideHit.getPep_seq();
		if (this.getPep_seq().equals(pep_seq)) {
			String pep_var_mod_pos = peptideHit.getPep_var_mod_pos();
			return this.getPep_var_mod_pos().equals(pep_var_mod_pos);
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(prot_hit_num == 0 ? "" : prot_hit_num).append(",");
		stringBuilder.append(prot_family_member == 0 ? "" : prot_family_member).append(",");
		stringBuilder.append(getProt_acc() == null ? "" : getProt_acc()).append(",");
//		stringBuilder.append(getProt_desc() == null ? "" : getProt_desc()).append(",");
		stringBuilder.append(prot_score == 0 ? "" : prot_score).append(",");
//		stringBuilder.append(getProt_thresh() == null ? "" : getProt_thresh()).append(",");
//		stringBuilder.append(getProt_expect() == null ? "" : getProt_expect()).append(",");
		stringBuilder.append(prot_mass == 0 ? "" : prot_mass).append(",");
		stringBuilder.append(prot_matches == 0 ? "" : prot_matches).append(",");
		stringBuilder.append(prot_matches_sig == 0 ? "" : prot_matches_sig).append(",");
		stringBuilder.append(prot_sequences == 0 ? "" : prot_sequences).append(",");
		stringBuilder.append(prot_sequences_sig == 0 ? "" : prot_sequences_sig).append(",");
//		stringBuilder.append(getProt_cover() == null ? "" : getProt_cover()).append(",");
//		stringBuilder.append(prot_len == 0 ? "" : prot_len).append(",");
//		stringBuilder.append(getProt_pi() == null ? "" : getProt_pi()).append(",");
//		stringBuilder.append(getProt_tax_str() == null ? "" : getProt_tax_str()).append(",");
//		stringBuilder.append(getProt_tax_id() == null ? "" : getProt_tax_id()).append(",");
//		stringBuilder.append(getProt_seq() == null ? "" : getProt_seq()).append(",");
//		stringBuilder.append(getProt_empai() == null ? "" : getProt_empai()).append(",");
		stringBuilder.append(pep_query == 0 ? "" : pep_query).append(",");
		stringBuilder.append(pep_rank == 0 ? "" : pep_rank).append(",");
		stringBuilder.append(pep_isbold ? "1" : "0").append(",");
		stringBuilder.append(pep_isunique ? "1" : "0").append(",");
		stringBuilder.append(getPep_exp_mz() == 0 ? "" : getPep_exp_mz()).append(",");
		stringBuilder.append(super.getPeptideExpMW() == 0 ? "" : super.getPeptideExpMW()).append(",");
		stringBuilder.append(getPep_exp_z() == 0 ? "" : getPep_exp_z()).append(",");
		stringBuilder.append(getPep_calc_mr() == 0 ? "" : getPep_calc_mr()).append(",");
		stringBuilder.append(pep_delta == 0 ? "" : pep_delta).append(",");
		stringBuilder.append(getPep_start() == 0 ? "" : getPep_start()).append(",");
		stringBuilder.append(getPep_end() == 0 ? "" : getPep_end()).append(",");
		stringBuilder.append(pep_miss == 0 ? "" : pep_miss).append(",");
		stringBuilder.append(getPep_score() == 0 ? "" : getPep_score()).append(",");
//		stringBuilder.append(pep_homol == 0 ? "" : pep_homol).append(",");
//		stringBuilder.append(pep_ident == 0 ? "" : pep_ident).append(",");
		stringBuilder.append(pep_expect == 0 ? "" : pep_expect).append(",");
		stringBuilder.append(getPep_res_before() == 0 ? "" : getPep_res_before()).append(",");
		stringBuilder.append(getPep_seq() == null ? "" : getPep_seq()).append(",");
		stringBuilder.append(getPep_res_after() == 0 ? "" : getPep_res_after()).append(",");
//		stringBuilder.append(pep_frame == null ? "" : pep_frame).append(",");
		stringBuilder.append(pep_var_mod == null ? "" : pep_var_mod).append(",");
		stringBuilder.append(pep_var_mod_pos == null ? "" : pep_var_mod_pos).append(",");
		stringBuilder.append(pep_summed_mod_pos == null ? "" : pep_summed_mod_pos).append(",");
		stringBuilder.append(pep_local_mod_pos == null ? "" : pep_local_mod_pos).append(",");
//		stringBuilder.append(pep_var_mod_conf == null ? "" : pep_var_mod_conf).append(",");
//		stringBuilder.append(pep_num_match == 0 ? "" : pep_num_match).append(",");
		stringBuilder.append(getPep_scan_title() == null ? "" : getPep_scan_title());
//		stringBuilder.append(pep_source == null ? "" : pep_source).append(",");
		return stringBuilder.toString();
	}
}
