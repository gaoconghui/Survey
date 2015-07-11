package com.survey.struts.action;

import javax.annotation.Resource;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.OptionStatisticsModel;
import com.survey.model.Page;
import com.survey.model.QuestionStatisticsModel;
import com.survey.service.StatisticsService;

/**
 * 输出图表
 */
@Controller
@Scope("prototype")
public class ChartOutputAction extends BaseAction<Page> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 652569759351420444L;
	@Resource
	private StatisticsService statisticsService;

	private int qid;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String execute() throws Exception {
		return "success";
	}

	public JFreeChart getChart() {
		QuestionStatisticsModel qsm = statisticsService.statistice(qid);
		DefaultPieDataset ds = new DefaultPieDataset();
		for(OptionStatisticsModel osm : qsm.getOsms()){
			ds.setValue(osm.getOptionLable(), osm.getCount());
		}
		
		JFreeChart chart = ChartFactory.createPieChart(qsm.getQuestion().getTitle(), ds, true, false, false);
		return chart;
	}

}
