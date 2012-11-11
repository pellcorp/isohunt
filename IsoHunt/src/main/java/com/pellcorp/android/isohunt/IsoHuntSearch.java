package com.pellcorp.android.isohunt;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.jsoup.nodes.Document;

public class IsoHuntSearch {
	private final SearchProvider searchProvider;
	private final SearchResultParser searchResultParser = new SearchResultParser();
	public int totalPages = -1;
	private int currentPage = 0;
	private String query;
	
	public IsoHuntSearch(
			final SearchProvider searchProvider,
			String query) throws IOException {
		this.searchProvider = searchProvider;
	}
	
	public PageResults nextPage() throws IOException {
		if ( hasNext()) {
			currentPage++;
			return doSearch();
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public boolean hasNext() {
		// remember next page will be currentPage + 1
		return totalPages == -1 || currentPage < totalPages;
	}
	
	private PageResults doSearch() throws IOException {
		Document doc = searchProvider.searchResults(query, currentPage);
		PageResults pageResults = searchResultParser.parseResults(doc);
		totalPages = pageResults.getNumberOfPages();
		currentPage = pageResults.getCurrentPage();
		return pageResults;
	}
}
