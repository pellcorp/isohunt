package com.pellcorp.android.isohunt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageResults implements Serializable {
	private List<Result> searchResults = new ArrayList<Result>();
	private int currentPage = 0;
	private int numberOfPages = 0;
	
	public PageResults() {
	}
	
	void addResult(Result result) {
		searchResults.add(result);
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public List<Result> getSearchResults() {
		return Collections.unmodifiableList(searchResults);
	}
}
