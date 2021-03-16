package org.bana.myblog.model;

public class Pagination {
	private String pageNumber;
	private String className;

	public Pagination() {
		// TODO Auto-generated constructor stub
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Pagination(String pageNumber, String className) {
		super();
		this.pageNumber = pageNumber;
		this.className = className;
	}

}
