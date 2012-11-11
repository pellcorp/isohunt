package com.pellcorp.android.isohunt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageResults {
	private List<Result> searchResults = new ArrayList<Result>();
	private int currentPage;
	private int numberOfPages;
	
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
