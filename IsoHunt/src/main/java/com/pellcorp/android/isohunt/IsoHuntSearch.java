package com.pellcorp.android.isohunt;

import java.io.IOException;

import org.jsoup.nodes.Document;

public class IsoHuntSearch {
	private final SearchProvider searchProvider;
	private final SearchResultParser searchResultParser = new SearchResultParser();
	
	public IsoHuntSearch(
			final SearchProvider searchProvider) throws IOException {
		this.searchProvider = searchProvider;
	}
	
	public PageResults search(PageQuery query) throws IOException {
		Document doc = searchProvider.searchResults(query);
		return searchResultParser.parseResults(doc);
	}
}
