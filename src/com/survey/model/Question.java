package com.survey.model;

import com.survey.util.StringUtil;

public class Question {

	private static final String RN ="\r\n";
	
	private Page page;

	private int id;

	private String title;

	// 题型
	private String questionType;

	// 选项
	private String options;
	private String[] optionArr;

	// 其他项
	private boolean other;

	// 其他项样式：0-无 1-文本框 2-下拉列表
	private int otherStyle;

	// 其他项下拉选项
	private String otherSelectOptions;
	private String[] otherSelectOptionArr;

	// 矩阵式题集
	private String matrixRowTitle;
	private String[] matrixRowTitleArr;

	// 矩阵列标题集
	private String matrixColTitle;
	private String[] matrixColTitleArr;

	// 矩阵式下拉选项集
	private String matrixSelectOptions;
	private String[] matrixSelectOptionArr;

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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
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
		setOptionArr(StringUtil.str2arr(options, RN));
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
		setOtherSelectOptionArr(StringUtil.str2arr(otherSelectOptions, RN));

	}

	public String getMatrixRowTitle() {
		return matrixRowTitle;
	}

	public void setMatrixRowTitle(String matrixRowTitle) {
		this.matrixRowTitle = matrixRowTitle;
		setMatrixRowTitleArr(StringUtil.str2arr(matrixRowTitle, RN));
	}

	public String getMatrixColTitle() {
		return matrixColTitle;
	}

	public void setMatrixColTitle(String matrixColTitle) {
		this.matrixColTitle = matrixColTitle;
		setMatrixColTitleArr(StringUtil.str2arr(matrixColTitle, RN));
	}

	public String getMatrixSelectOptions() {
		return matrixSelectOptions;
	}

	public void setMatrixSelectOptions(String matrixSelectOptions) {
		this.matrixSelectOptions = matrixSelectOptions;
		setMatrixSelectOptionArr(StringUtil.str2arr(matrixSelectOptions, RN));
	}

	public String[] getOptionArr() {
		return optionArr;
	}

	public void setOptionArr(String[] optionArr) {
		this.optionArr = optionArr;
	}

	public String[] getOtherSelectOptionArr() {
		return otherSelectOptionArr;
	}

	public void setOtherSelectOptionArr(String[] otherSelectOptionArr) {
		this.otherSelectOptionArr = otherSelectOptionArr;
	}

	public String[] getMatrixRowTitleArr() {
		return matrixRowTitleArr;
	}

	public void setMatrixRowTitleArr(String[] matrixRowTitleArr) {
		this.matrixRowTitleArr = matrixRowTitleArr;
	}

	public String[] getMatrixColTitleArr() {
		return matrixColTitleArr;
	}

	public void setMatrixColTitleArr(String[] matrixColTitleArr) {
		this.matrixColTitleArr = matrixColTitleArr;
	}

	public String[] getMatrixSelectOptionArr() {
		return matrixSelectOptionArr;
	}

	public void setMatrixSelectOptionArr(String[] matrixSelectOptionArr) {
		this.matrixSelectOptionArr = matrixSelectOptionArr;
	}

	@Override
	public String toString() {
		return "Question [page=" + page.getId() + ", id=" + id
				+ ", questionType=" + questionType + ", options=" + options
				+ ", optionArr=" + optionArr + ", other=" + other
				+ ", otherStyle=" + otherStyle + ", otherSelectOptions="
				+ otherSelectOptions + ", matrixRowTitle=" + matrixRowTitle
				+ ", matrixColTitle=" + matrixColTitle
				+ ", matrixSelectOptions=" + matrixSelectOptions + "]";
	}

}
