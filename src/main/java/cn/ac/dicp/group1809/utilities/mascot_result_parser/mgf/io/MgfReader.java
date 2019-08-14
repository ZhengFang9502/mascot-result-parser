package cn.ac.dicp.group1809.utilities.mascot_result_parser.mgf.io;

import cn.ac.dicp.group1809.utilities.mascot_result_parser.mgf.model.MGF;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.MsnSpectrum;
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

	private MgfReader() {
	}

	public static MgfReader getInstance() {
		return instance;
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

	public MGF read(String mgfPath) throws JMzReaderException {
		MGF mgf = new MGF();
		List<MsnSpectrum> msnSpectrumList = new ArrayList<>();
		File file = new File(mgfPath);
		MgfFile mgfFile = new MgfFile(file);
		int ms2QueryCount = mgfFile.getMs2QueryCount();
		for (int i = 0; i < ms2QueryCount; i++) {
			MsnSpectrum msnSpectrum = new MsnSpectrum();
			Ms2Query ms2Query = mgfFile.getMs2Query(i);
			List<Peak> peakList = getPeakList(ms2Query.getPeakList());
			msnSpectrum.setPeakList(peakList);
			Precursor precursor = new Precursor();
			precursor.setMz(ms2Query.getPeptideMass());
			precursor.setIntensity(ms2Query.getPeptideIntensity());
			msnSpectrum.setPrecursor(precursor);
			msnSpectrum.setTitle(ms2Query.getTitle());
			msnSpectrum.setRTinSec(Double.valueOf(ms2Query.getRetentionTime()));
			msnSpectrumList.add(msnSpectrum);
		}
		mgf.setMsnSpectrumList(msnSpectrumList);
		return mgf;
	}
}
