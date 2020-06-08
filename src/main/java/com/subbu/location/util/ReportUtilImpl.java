package com.subbu.location.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilImpl implements ReportUtil {

	@Override
	public void generatePieChart(String path, List<Object[]> data) {

/*PieDataset is an interface,but for some additional methods we are using DefaultPieDataset */
		DefaultPieDataset dataset = new DefaultPieDataset();

		for (Object[] objects : data) {
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));   //we are copying the data we got into dataset
		}

		JFreeChart chart = ChartFactory.createPieChart3D("Location type report", dataset); 
		/*It creates a Jfreechart using ChartFactory, which is an object representation.To convert this into a image we use ChartUtilities */
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/piechart.jpeg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
