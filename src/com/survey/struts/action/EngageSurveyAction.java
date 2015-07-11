package com.survey.struts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.datasource.SurveyToken;
import com.survey.model.Answer;
import com.survey.model.Page;
import com.survey.model.Survey;
import com.survey.service.SurveyService;
import com.survey.util.StringUtil;
import com.survey.util.VaildateUtil;

@Controller
@Scope("prototype")
public class EngageSurveyAction extends BaseAction<Survey> implements
		SessionAware, ParameterAware {

	private static final long serialVersionUID = 3425180383129701642L;

	private final String CURRENT_SURVEY = "current_survey";
	private final String ALL_PARAMS_MAP = "all_survey";

	@Resource
	SurveyService surveyService;

	List<Survey> mySurveys;

	private int sid;

	private Page currentPage;

	private int currPid;

	public int getCurrPid() {
		return currPid;
	}

	public void setCurrPid(int currPid) {
		this.currPid = currPid;
	}

	public Page getCurrentPage() {
		return currentPage;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getSid() {
		return sid;
	}

	// 接收sessionMap
	private Map<String, Object> sessionMap;

	private Map<String, String[]> paramMap;

	public List<Survey> getMySurveys() {
		return mySurveys;
	}

	// 跳转到参与调查页面
	public String toEngageSurveyPage() {
		mySurveys = surveyService.getAllOpenSurveys();
		return "toEngageSurveyPage";
	}

	// 转到问卷的第一页
	public String doEngageSurvey() {
		this.currentPage = surveyService.getFirstPage(sid);
		sessionMap.put(CURRENT_SURVEY, currentPage.getSurvey());
		// 存放所有答案的大map
		sessionMap.put(ALL_PARAMS_MAP,
				new HashMap<Integer, Map<String, String[]>>());

		return "doEngageSurvey";
	}

	// 回答问题
	public String doSurvey() {
		String btnName = this.getSubBtn();
		if (btnName.endsWith("pre")) {
			mergeParamsIntoSession();
			currentPage = surveyService.getPrePage(currPid);
			return "doEngageSurvey";

		} else if (btnName.endsWith("next")) {
			mergeParamsIntoSession();
			currentPage = surveyService.getNextPage(currPid);
			return "doEngageSurvey";

		} else if (btnName.endsWith("done")) {
			mergeParamsIntoSession();
			
			SurveyToken surveyToken = new SurveyToken();
			surveyToken.setSurvey(getCurrentSurvey());
			SurveyToken.bindToken(surveyToken);
			
			surveyService.saveAnswers(processSurvey());
			clearSessionMap();
			return "engageSuveryAction";
		}
		return null;
	}

	private ArrayList<Answer> processSurvey() {
		Map<Integer, String> matrixMap = new HashMap<Integer, String>();
		String key;
		String[] value;
		Answer answer = null;
		ArrayList<Answer> answers = new ArrayList<Answer>();
		HashMap<Integer, Map<String, String[]>> allMap = getAllParamsMap();
		for (Map<String, String[]> map : allMap.values()) {
			for (Entry<String, String[]> entry : map.entrySet()) {
				key = entry.getKey();
				value = entry.getValue();
				if (key.startsWith("q")) {
					if (!key.contains("_") && !key.contains("other")) {
						answer = new Answer();
						answer.setAnswerIds(StringUtil.arr2Str(value));
						answer.setOtherAnswer(StringUtil.arr2Str(map.get(key
								+ "other")));
						answer.setQuestionId(getQID(key));
						answer.setSurveyId(getCurrentSurvey().getId());
						answers.add(answer);
					} else if (key.contains("_")) {
						Integer id = getMatrixId(key);
						String oldValue = matrixMap.get(id);
						if (VaildateUtil.isVaild(oldValue)) {
							oldValue = oldValue + ","
									+ StringUtil.arr2Str(value);
						} else {
							matrixMap.put(id, StringUtil.arr2Str(value));
						}
					}
				}
			}
		}
		processMatrix(matrixMap, answers);
		return answers;
	}

	private void processMatrix(Map<Integer, String> matrixMap,
			ArrayList<Answer> answers) {
		Answer answer;
		int key;
		String value;
		for (Entry<Integer, String> entry : matrixMap.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			answer = new Answer();
			answer.setAnswerIds(value);
			answer.setQuestionId(key);
			answer.setSurveyId(getCurrentSurvey().getId());
			answers.add(answer);
		}
	}

	/*
	 * 获取矩阵式单选的id q12_0 ---> 12
	 */
	private Integer getMatrixId(String key) {
		return Integer.parseInt(key.substring(1, key.indexOf("_")));
	}

	private Survey getCurrentSurvey() {
		Survey survey = (Survey) sessionMap.get(CURRENT_SURVEY);
		return survey;
	}

	private Integer getQID(String key) {
		return Integer.parseInt(key.substring(1));
	}

	/*
	 * 清除Session数据
	 */
	private void clearSessionMap() {
		sessionMap.remove(CURRENT_SURVEY);
		sessionMap.remove(ALL_PARAMS_MAP);
	}

	private void mergeParamsIntoSession() {
		getAllParamsMap().put(currPid, paramMap);
	}

	@SuppressWarnings("unchecked")
	private HashMap<Integer, Map<String, String[]>> getAllParamsMap() {
		return (HashMap<Integer, Map<String, String[]>>) sessionMap
				.get(ALL_PARAMS_MAP);
	}

	private String getSubBtn() {
		for (String s : paramMap.keySet()) {
			if (s.startsWith("submit"))
				return s;
		}
		return null;
	}

	/*
	 * 确定是否被选中
	 */
	public String setTag(String name, String value, String tag) {
		if (StringUtil.contains(
				getAllParamsMap().get(currentPage.getId()).get(name), value))
			return tag;
		return "";
	}

	/*
	 * 确定是否有text
	 */
	public String setText(String name) {
		String[] values = getAllParamsMap().get(currentPage.getId()).get(name);
		return "value = '" + values[0] + "'";
	}

	/*
	 * 注入sessionMap
	 */
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		this.paramMap = arg0;
	}
}
