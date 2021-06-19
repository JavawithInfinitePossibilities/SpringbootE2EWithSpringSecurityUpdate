/**
 * 
 */
package com.sid.e2e.springboot.locationdetails.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class ReportUtilImpl implements ReportUtil {

	@Override
	public void generatePieChart(String path, List<Object[]> data) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		data.stream().forEach(chatData -> {
			dataset.setValue(chatData[0].toString(), Double.parseDouble(chatData[1].toString()));
		});
		JFreeChart chart3D = ChartFactory.createPieChart3D("Location Type Report", dataset);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/pieChart.jpeg"), chart3D, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
