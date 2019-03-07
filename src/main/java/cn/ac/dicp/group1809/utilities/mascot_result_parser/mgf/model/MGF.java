package cn.ac.dicp.group1809.utilities.mascot_result_parser.mgf.model;

import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Ms2Spectrum;

import java.util.List;

/**
 * @author ZhengFang 2019/1/15
 * @since V1.0
 */
public class MGF {
	private List<Ms2Spectrum> ms2SpectrumList;

	public List<Ms2Spectrum> getMs2SpectrumList() {
		return ms2SpectrumList;
	}

	public void setMs2SpectrumList(List<Ms2Spectrum> ms2SpectrumList) {
		this.ms2SpectrumList = ms2SpectrumList;
	}
}
