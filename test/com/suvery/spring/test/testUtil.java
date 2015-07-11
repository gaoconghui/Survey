package com.suvery.spring.test;
import java.util.HashSet;

import org.junit.Test;

import com.survey.model.Page;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.util.App;
import com.survey.util.LogUtil;
import com.survey.util.StringUtil;

public class testUtil {

	@Test
	public void testDeeplyCopy(){
		Page page = new Page();
		page.setTitle("a");
		
		Question question1 = new Question();
		question1.setTitle("q1");
		Question question2 = new Question();
		question2.setTitle("q2");
		
		Survey survey = new Survey();
		survey.setTitle("s");
		
		page.setSurvey(survey);
		HashSet<Question> questions = new HashSet<Question>();
		questions.add(question1);
		questions.add(question2);
		page.setQuestions(questions);
		
		question1.setPage(page);
		question2.setPage(page);
		
		System.out.println(page);
		System.out.println(page.getQuestions());
		System.out.println("-----------deeplyCopy-----------------");
		
		page = (Page) App.deeplyCopy(page);
		System.out.println(page);
		System.out.println(page.getQuestions());
		
	}
	
	@Test
	public void testStringUtil(){
		String[] values = {"a","b","c"};
		System.out.println(StringUtil.arr2Str(values));
		String key = "q113_1";
		System.out.println(key.substring(1, key.indexOf("_")));
	}
	
	@Test
	public void testStrArray(){
		String[][] s =  new String[1][1];
		s[0][0] = "s";
		s[0][1] = "01";
		System.out.println(s[0][1]);
	}
	
	@Test
	public void testLogUtil(){
		System.out.println(LogUtil.generateLogTableName(-1));;
	}
}
