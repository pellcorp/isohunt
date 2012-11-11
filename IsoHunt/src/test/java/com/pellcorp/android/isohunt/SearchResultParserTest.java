package com.pellcorp.android.isohunt;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class SearchResultParserTest {
	@Test
	public void testResults() throws Exception {
		SearchResultParser parser = new SearchResultParser();
		Document doc = Jsoup.parse(ResourceUtils.loadResourceAsString("/search-results.html"));
		PageResults pageResults = parser.parseResults(doc);
		assertEquals(1, pageResults.getCurrentPage());
		assertEquals(8, pageResults.getNumberOfPages());
		assertEquals(20, pageResults.getSearchResults().size());
	}
}
