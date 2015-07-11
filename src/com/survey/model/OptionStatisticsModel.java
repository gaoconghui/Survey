package com.survey.model;

public class OptionStatisticsModel {

	// 选项标签，用于显示
	private String optionLable;
	// 选项索引
	private int optionIndex;

	private String matrixRowLable;
	private int matrixRowIndex;

	private String matrixColLable;
	private int matrixColIndex;

	private String matrixSelectLable;
	private int matrixSelectIndex;

	private long count;

	public long getCount() {
		return count;
	}

	public void setCount(long ocount) {
		this.count = ocount;
	}

	public String getOptionLable() {
		return optionLable;
	}

	public void setOptionLable(String optionLable) {
		this.optionLable = optionLable;
	}

	public int getOptionIndex() {
		return optionIndex;
	}

	public void setOptionIndex(int optionIndex) {
		this.optionIndex = optionIndex;
	}

	public String getMatrixRowLable() {
		return matrixRowLable;
	}

	public void setMatrixRowLable(String matrixRowLable) {
		this.matrixRowLable = matrixRowLable;
	}

	public int getMatrixRowIndex() {
		return matrixRowIndex;
	}

	public void setMatrixRowIndex(int matrixRowIndex) {
		this.matrixRowIndex = matrixRowIndex;
	}

	public String getMatrixColLable() {
		return matrixColLable;
	}

	public void setMatrixColLable(String matrixColLable) {
		this.matrixColLable = matrixColLable;
	}

	public int getMatrixColIndex() {
		return matrixColIndex;
	}

	public void setMatrixColIndex(int matrixColIndex) {
		this.matrixColIndex = matrixColIndex;
	}

	public String getMatrixSelectLable() {
		return matrixSelectLable;
	}

	public void setMatrixSelectLable(String matrixSelectLable) {
		this.matrixSelectLable = matrixSelectLable;
	}

	public int getMatrixSelectIndex() {
		return matrixSelectIndex;
	}

	public void setMatrixSelectIndex(int matrixSelectIndex) {
		this.matrixSelectIndex = matrixSelectIndex;
	}

}
