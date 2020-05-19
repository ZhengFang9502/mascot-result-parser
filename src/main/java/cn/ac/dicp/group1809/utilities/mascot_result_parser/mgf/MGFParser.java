package cn.ac.dicp.group1809.utilities.mascot_result_parser.mgf;

import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.common.Decimal;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.MsnSpectrum;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Peak;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Precursor;
import cn.ac.dicp.group1809.utilities.proteomics_toolkit.PeakUtils;
import uk.ac.ebi.pride.tools.jmzreader.JMzReaderException;
import uk.ac.ebi.pride.tools.jmzreader.model.Spectrum;
import uk.ac.ebi.pride.tools.jmzreader.model.impl.CvParam;
import uk.ac.ebi.pride.tools.jmzreader.model.impl.ParamGroup;
import uk.ac.ebi.pride.tools.mgf_parser.MgfFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Zheng Fang 3/1/2020
 * @since V1.0.0
 */
public class MGFParser {
	private static final String LINE_SEPARATOR = System.lineSeparator();

	public static TreeMap<Integer, MsnSpectrum> getSpectrumMap(String path) {
		TreeMap<Integer, MsnSpectrum> spectrumMap = new TreeMap<>();
		List<MsnSpectrum> msnSpectrumList = getSpectrumList(path);
		for (MsnSpectrum msnSpectrum : msnSpectrumList) {
			int scanNumber = msnSpectrum.getScanNumber();
			spectrumMap.put(scanNumber, msnSpectrum);
		}
		return spectrumMap;
	}

	public static List<MsnSpectrum> getSpectrumList(String path) {
		List<MsnSpectrum> msnSpectrumList = new ArrayList<>();
		File file = new File(path);
		MgfFile mgfFile;
		try {
			mgfFile = new MgfFile(file);
		} catch (JMzReaderException e) {
			throw new RuntimeException(e);
		}
		Iterator<Spectrum> spectrumIterator = mgfFile.getSpectrumIterator();
		while (spectrumIterator.hasNext()) {
			Spectrum spectrum = spectrumIterator.next();
			MsnSpectrum msnSpectrum = spectrumConverter(spectrum);
			msnSpectrumList.add(msnSpectrum);
		}
		return msnSpectrumList;
	}

	private static MsnSpectrum spectrumConverter(Spectrum mgfSpectrum) {
		Map<Double, Double> peakMap = mgfSpectrum.getPeakList();
		List<Peak> peakList = new ArrayList<>();
		for (Double mz : peakMap.keySet()) {
			Double intensity = peakMap.get(mz);
			peakList.add(new Peak(mz, intensity));
		}
		Collections.sort(peakList);
		MsnSpectrum msnSpectrum = new MsnSpectrum();
		msnSpectrum.setPeakList(peakList);
		msnSpectrum.setTotalIonCurrent(PeakUtils.getIntensitySum(peakList));
		Precursor precursor = new Precursor();
		Double precursorMZ = mgfSpectrum.getPrecursorMZ();
		precursor.setMz(precursorMZ);
		precursor.setCharge(mgfSpectrum.getPrecursorCharge());
		msnSpectrum.setPrecursor(precursor);
		ParamGroup additional = mgfSpectrum.getAdditional();
		List<CvParam> cvParams = additional.getCvParams();
		for (CvParam cvParam : cvParams) {
			String name = cvParam.getName();
			if (name.equals("peak list scans")) {
				msnSpectrum.setScanNumber(Integer.parseInt(cvParam.getValue().replaceAll("_\\d+", "")));
			}
		}
		return msnSpectrum;
	}

	public static void write(Collection<MsnSpectrum> msnSpectrums, String path) {
		File file = new File(path);
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(file);
			String title = "MASS=Monoisotopic" + LINE_SEPARATOR;
			fileOutputStream.write(title.getBytes());
			for (MsnSpectrum msnSpectrum : msnSpectrums) {
				String msnSpectrumStr = getMsnSpectrumStr(msnSpectrum);
				fileOutputStream.write(msnSpectrumStr.getBytes());
			}
			fileOutputStream.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getMsnSpectrumStr(MsnSpectrum msnSpectrum) {
		DecimalFormat df1 = Decimal.DF_1;
		DecimalFormat df5 = Decimal.DF_5;
		int scanNumber = msnSpectrum.getScanNumber();
		Precursor precursor = msnSpectrum.getPrecursor();
		int precursorCharge = precursor.getCharge();
		double precursorMz = precursor.getMz();
		List<Peak> peakList = msnSpectrum.getPeakList();
		StringBuilder sB = new StringBuilder();
		String spectrumTitle = msnSpectrum.getTitle();
		String pepMass = "PEPMASS=" + df5.format(precursorMz) + LINE_SEPARATOR;
		String cha = "CHARGE=" + precursorCharge + "+" + LINE_SEPARATOR;
		String rt = "RTINSECONDS=" + df5.format(msnSpectrum.getRTinSec()) + LINE_SEPARATOR;
		String scan = "SCANS=" + scanNumber + LINE_SEPARATOR;
		spectrumTitle = "TITLE=" + spectrumTitle + LINE_SEPARATOR;
		sB.append("BEGIN IONS").append(LINE_SEPARATOR).append(spectrumTitle).append(pepMass).append(cha).append(rt).append(scan);
		for (Peak peak : peakList) {
			double mz = peak.getMz();
			double intensity = peak.getIntensity();
			sB.append(df5.format(mz)).append(" ").append(df1.format(intensity)).append(LINE_SEPARATOR);
		}
		sB.append("END IONS").append(LINE_SEPARATOR);
		return sB.toString();
	}
}
