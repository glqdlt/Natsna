package org.natsna.domain;

public class Criteria {

	private int page;
	private int perPageNum;
	
	
	// method for Mybatis sql
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	public final int getPage() {
		return page;
	}

	public final void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;

		}

		this.page = page;
	}

	// method for Mybatis sql
	public final int getPerPageNum() {
		return perPageNum;
	}

	public final void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 10) {
			this.perPageNum = 10;
			return;

		}

		this.perPageNum = perPageNum;
	}

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

}
