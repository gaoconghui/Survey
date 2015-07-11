package com.survey.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.BaseDao;
import com.survey.model.Answer;
import com.survey.model.OptionStatisticsModel;
import com.survey.model.Question;
import com.survey.model.QuestionStatisticsModel;
import com.survey.service.StatisticsService;

@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService{
	
	@Resource(name="questionDao")
	private BaseDao<Question> questionDao;;
	
	@Resource(name="answerDao")
	private BaseDao<Answer> answerDao;;

	@Override
	public QuestionStatisticsModel statistice(Integer qid) {
		Question question = questionDao.getEntity(qid);
		QuestionStatisticsModel qsm = new QuestionStatisticsModel();
		qsm.setQuestion(question);
		
		String hql = "select count(*) from Answer a where a.questionId = ?";
		Long count = (Long) questionDao.uniqueResult(hql, qid);
		qsm.setCount(count.intValue());
		
		
		String questionType = question.getQuestionType();
		OptionStatisticsModel osm;
		long ocount;
		
		switch (questionType) {
		//非矩阵式问题
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
			String[] arr = question.getOptionArr();
			for(int i = 0 ; i < arr.length ; i++){
				osm = new OptionStatisticsModel();
				osm.setOptionIndex(i);
				osm.setOptionLable(arr[i]);
				String ohql = "select count(*) from Answer a where a.questionId = ? and concat(',',a.answerIds,',') like ?";
				ocount = (long) questionDao.uniqueResult(ohql, question.getId(),"%,"+i+",%");
				osm.setCount(ocount);
				qsm.getOsms().add(osm);
			}
			//other
			if(question.isOther()){
				osm = new OptionStatisticsModel();
				osm.setOptionLable("other");
				String ohql = "select count(*) from Answer a where a.questionId = ? and concat(',',a.answerIds,',') like ?";
				ocount = (long) questionDao.uniqueResult(ohql, question.getId(),"%,other,%");
				osm.setCount(ocount);
				qsm.getOsms().add(osm);
			}
			break;
		//矩阵式问题
		case "5":
		case "6":
		case "7":
		case "8":
			String[] rowArr = question.getMatrixRowTitleArr();
			String[] colArr = question.getMatrixColTitleArr();
			String[] selectArr = question.getMatrixSelectOptionArr();
			for(int i = 0 ; i < rowArr.length ; i++){
				for(int j = 0 ; j < colArr.length ; j++){
					if(!questionType.equals("8")){
						osm = new OptionStatisticsModel();
						osm.setMatrixRowIndex(i);
						osm.setMatrixRowLable(colArr[i]);
						osm.setMatrixColIndex(j);
						osm.setMatrixColLable(colArr[j]);
						String ohql = "select count(*) from Answer a where a.questionId = ? and concat(',',a.answerIds,',') like ?";
						ocount = (long) questionDao.uniqueResult(ohql, question.getId(),"%," + i + "_" + j + ",%");
						osm.setCount(ocount);
						qsm.getOsms().add(osm);
					}else{
						for(int k = 0 ; k <selectArr.length ; k++){
							osm = new OptionStatisticsModel();
							osm.setMatrixRowIndex(i);
							osm.setMatrixRowLable(colArr[i]);
							osm.setMatrixColIndex(j);
							osm.setMatrixColLable(colArr[j]);
							osm.setMatrixSelectIndex(k);
							osm.setMatrixRowLable(selectArr[k]);
							String ohql = "select count(*) from Answer a where a.questionId = ? and concat(',',a.answerIds,',') like ?";
							ocount = (long) questionDao.uniqueResult(ohql, question.getId(),"%," + i + "_" + j + "_" + k + ",%");
							osm.setCount(ocount);
							qsm.getOsms().add(osm);
						}
					}
				}
			}
			break;
		}
		return qsm;
	}

}
