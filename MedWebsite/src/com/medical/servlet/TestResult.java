package com.medical.servlet;

import java.util.Date;

public class TestResult {
	int resultId;
	int testId;
	Date d2;
	String normalRange;
	String actualResult;
	String testResultsNote;
	
	

	public TestResult() {
		super();
		
	}



	



	public TestResult(int resultId, int testId, Date d2, String normalRange, String actualResult,
			String testResultsNote) {
		super();
		this.resultId = resultId;
		this.testId = testId;
		this.d2 = d2;
		this.normalRange = normalRange;
		this.actualResult = actualResult;
		this.testResultsNote = testResultsNote;
	}







	public int getResultId() {
		return resultId;
	}



	public void setResultId(int resultId) {
		this.resultId = resultId;
	}



	public int getTestId() {
		return testId;
	}



	public void setTestId(int testId) {
		this.testId = testId;
	}



	public Date getD2() {
		return d2;
	}



	public void setD2(Date d2) {
		this.d2 = d2;
	}



	public String getNormalRange() {
		return normalRange;
	}



	public void setNormalRange(String normalRange) {
		this.normalRange = normalRange;
	}



	public String getActualResult() {
		return actualResult;
	}



	public void setActualResult(String actualResult) {
		this.actualResult = actualResult;
	}

public String getTestResultsNote() {
		return testResultsNote;
	}

public void setTestResultsNote(String testResultsNote) {
		this.testResultsNote = testResultsNote;
	}







@Override
public String toString() {
	return "TestResult [resultId=" + resultId + ", testId=" + testId + ", d2=" + d2 + ", normalRange=" + normalRange
			+ ", actualResult=" + actualResult + ", testResultsNote=" + testResultsNote + "]";
}







	
	
	

}
