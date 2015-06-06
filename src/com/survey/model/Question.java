package com.survey.model;

public class Question {

	private Page page;
	
	private int id;
	
	//题型
	private String questionType;
	
	//选项
	private String options;
	private String optionArr;
	
	//其他项
	private boolean other;
	
	//其他项样式：0-无 1-文本框 2-下拉列表
	private int otherStyle;
	
	//其他项下拉选项
	private String otherSelectOptions;
	
	//矩阵式题集
	private String matrixRowTitle;
	
	//矩阵列标题集
	private String matrixColTitle;
	 
	//矩阵式下拉选项集
	private String matrixSelectOptions;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getOptionArr() {
		return optionArr;
	}

	public void setOptionArr(String optionArr) {
		this.optionArr = optionArr;
	}

	public boolean isOther() {
		return other;
	}

	public void setOther(boolean other) {
		this.other = other;
	}

	public int getOtherStyle() {
		return otherStyle;
	}

	public void setOtherStyle(int otherStyle) {
		this.otherStyle = otherStyle;
	}

	public String getOtherSelectOptions() {
		return otherSelectOptions;
	}

	public void setOtherSelectOptions(String otherSelectOptions) {
		this.otherSelectOptions = otherSelectOptions;
	}

	public String getMatrixRowTitle() {
		return matrixRowTitle;
	}

	public void setMatrixRowTitle(String matrixRowTitle) {
		this.matrixRowTitle = matrixRowTitle;
	}

	public String getMatrixColTitle() {
		return matrixColTitle;
	}

	public void setMatrixColTitle(String matrixColTitle) {
		this.matrixColTitle = matrixColTitle;
	}

	public String getMatrixSelectOptions() {
		return matrixSelectOptions;
	}

	public void setMatrixSelectOptions(String matrixSelectOptions) {
		this.matrixSelectOptions = matrixSelectOptions;
	}

	@Override
	public String toString() {
		return "Question [page=" + page + ", id=" + id + ", questionType="
				+ questionType + ", options=" + options + ", optionArr="
				+ optionArr + ", other=" + other + ", otherStyle=" + otherStyle
				+ ", otherSelectOptions=" + otherSelectOptions
				+ ", matrixRowTitle=" + matrixRowTitle + ", matrixColTitle="
				+ matrixColTitle + ", matrixSelectOptions="
				+ matrixSelectOptions + "]";
	}
	
	
}
