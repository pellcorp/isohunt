package com.pellcorp.android.isohunt;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class IsoHuntSearchTest {
	@Test
	public void testSearch() throws Exception {
		SearchProvider provider = new MockSearchProvider();
		IsoHuntSearch search = new IsoHuntSearch(provider, "doctor who season 5");
		assertTrue(search.hasNext());
		PageResults pageOne = search.nextPage();
		assertTrue(search.hasNext());
		PageResults pageTwo = search.nextPage();
		assertTrue(search.hasNext());
		PageResults pageThree = search.nextPage();
		assertTrue(search.hasNext());
		PageResults pageFour = search.nextPage();
		assertTrue(search.hasNext());
		PageResults pageFive = search.nextPage();
		assertTrue(search.hasNext());
		PageResults pageSix = search.nextPage();
		assertTrue(search.hasNext());
		PageResults pageSeven = search.nextPage();
		assertTrue(search.hasNext());
		PageResults pageEight = search.nextPage();
		assertFalse(search.hasNext());
	}
}

class MockSearchProvider implements SearchProvider {
	@Override
	public Document searchResults(String query, int page) throws IOException {
		return Jsoup.parse(ResourceUtils.loadResourceAsString("/search-results-p" + page + ".html"));
	}
}