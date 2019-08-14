package cn.ac.dicp.group1809.utilities.mascot_result_parser.mgf.model;

import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.MsnSpectrum;

import java.util.List;

/**
 * @author ZhengFang 2019/1/15
 * @since V1.0
 */
public class MGF {
	private List<MsnSpectrum> msnSpectrumList;

	public List<MsnSpectrum> getMsnSpectrumList() {
		return msnSpectrumList;
	}

	public void setMsnSpectrumList(List<MsnSpectrum> msnSpectrumList) {
		this.msnSpectrumList = msnSpectrumList;
	}
}
