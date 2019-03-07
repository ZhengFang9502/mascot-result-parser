package cn.ac.dicp.group1809.utilities.mascot_result_parser.mgf.io;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.mgf.model.MGF;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Ms2Spectrum;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Peak;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Precursor;
import uk.ac.ebi.pride.tools.jmzreader.JMzReaderException;
import uk.ac.ebi.pride.tools.mgf_parser.MgfFile;
import uk.ac.ebi.pride.tools.mgf_parser.model.Ms2Query;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2019/1/15
 * @since V1.0
 */
public class MgfReader {
	private static MgfReader instance = new MgfReader();

	public static MgfReader getInstance() {
		return instance;
	}

	private MgfReader() {
	}

	public MGF read(String mgfPath) throws JMzReaderException {
		MGF mgf = new MGF();
		List<Ms2Spectrum> ms2SpectrumList = new ArrayList<>();
		File file = new File(mgfPath);
		MgfFile mgfFile = new MgfFile(file);
		int ms2QueryCount = mgfFile.getMs2QueryCount();
		for (int i = 0; i < ms2QueryCount; i++) {
			Ms2Spectrum ms2Spectrum = new Ms2Spectrum();
			Ms2Query ms2Query = mgfFile.getMs2Query(i);
			List<Peak> peakList = getPeakList(ms2Query.getPeakList());
			ms2Spectrum.setPeakList(peakList);
			Precursor precursor = new Precursor();
			precursor.setMz(ms2Query.getPeptideMass());
			precursor.setIntensity(ms2Query.getPeptideIntensity());
			ms2Spectrum.setPrecursor(precursor);
			ms2Spectrum.setTitle(ms2Query.getTitle());
			ms2Spectrum.setRTinSec(Double.valueOf(ms2Query.getRetentionTime()));
			ms2SpectrumList.add(ms2Spectrum);
		}
		mgf.setMs2SpectrumList(ms2SpectrumList);
		return mgf;
	}


	private static List<Peak> getPeakList(Map<Double, Double> peakMap) {
		List<Peak> peakList = new ArrayList<>();
		for (Double mz : peakMap.keySet()) {
			Double intensity = peakMap.get(mz);
			Peak peak = new Peak(mz, intensity);
			peakList.add(peak);
		}
		Collections.sort(peakList);
		return peakList;
	}
}
