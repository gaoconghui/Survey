package com.survey.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.survey.model.Survey;

/**
 * 数据源路由器，用于分布式数据库
 */
public class SurveyDatasourceRouter extends AbstractRoutingDataSource {

	/**
	 * 检测当前的key
	 */
	protected Object determineCurrentLookupKey() {
		SurveyToken surveyToken = SurveyToken.getCurrentToken();
		if (surveyToken != null) {
			Survey survey = surveyToken.getSurvey();
			Integer id = survey.getId();
			surveyToken.unbindToken();
			return (id % 2 != 0) ? "odd":"even" ;
		}
		return null;
	}

}
