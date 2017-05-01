package org.natsna.domain;

public class SearchCriteria extends Criteria {

	private String searchType;
	private String keyword;

	public final String getSearchType() {
		return searchType;
	}

	public final void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public final String getKeyword() {
		return keyword;
	}

	public final void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
