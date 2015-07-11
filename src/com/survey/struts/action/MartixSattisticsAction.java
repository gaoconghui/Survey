package com.survey.struts.action;

import javax.annotation.Resource;

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
public class MartixSattisticsAction extends BaseAction<Page> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 652569759351420444L;
	@Resource
	private StatisticsService statisticsService;

	private int qid;

	private QuestionStatisticsModel qsm;

	String[][] optionStr ;

	public void setOptionStr(String[][] optionStr) {
		this.optionStr = optionStr;
	}

	public String[][] getOptionStr() {
		return optionStr;
	}

	public void setQsm(QuestionStatisticsModel qsm) {
		this.qsm = qsm;
	}

	public QuestionStatisticsModel getQsm() {
		return qsm;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String execute() throws Exception {
		qsm = statisticsService.statistice(qid);
		
		optionStr = new String[qsm.getQuestion().getMatrixRowTitleArr().length+1][qsm.getQuestion().getMatrixColTitleArr().length+1];
		
		float scale ;
		long count = qsm.getCount();
		
		for(OptionStatisticsModel osm : qsm.getOsms()){
			scale =(float) osm.getCount()/count;
			optionStr[osm.getMatrixRowIndex()][osm.getMatrixColIndex()] = osm.getCount()+"("+ scale*100 +"%)";
		}

		
		
		return "success";
	}

}
