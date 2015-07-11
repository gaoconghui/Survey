package com.survey.struts.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.survey.model.Answer;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.service.SurveyService;

/**
 * 输出图表
 */
@Controller
@Scope("prototype")
public class CollectionAction extends BaseAction<Survey> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3872535460485442279L;

	@Resource
	private SurveyService surveyService;

	private int sid;

	private InputStream inputStream;

	public void setSid(int sid) {
		this.sid = sid;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String execute() throws Exception {

		List<Question> questions = surveyService.getQuestions(sid);
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("统计分析");
		HSSFRow row0 = sheet.createRow(0);
		
		//标题部分
		for(int i = 0 ; i < questions.size() ; i ++){
			row0.createCell(i).setCellValue(questions.get(i).getTitle());
			indexMap.put(questions.get(i).getId(), i);
		}
		
		List<Answer> answers = surveyService.getAnswers(sid);
		
		int index = 0 ;
		String oldUuid = "";
		String newUuid = "";
		HSSFRow row = null ;
		
		for(int i = 0 ; i < answers.size() ; i ++){
			newUuid = answers.get(i).getUuid();
			if(!newUuid.equalsIgnoreCase(oldUuid)){
				index ++;
				oldUuid = newUuid;
				row = sheet.createRow(index);
			}
			row.createCell(indexMap.get(answers.get(i).getQuestionId())).setCellValue(answers.get(i).getAnswerIds());
		}
		
		
		ByteOutputStream outStream = new ByteOutputStream();
		wb.write(outStream);
		inputStream = new ByteArrayInputStream(outStream.toByteArray());
		
		return "success";
	}

}
