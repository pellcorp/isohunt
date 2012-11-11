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
		IsoHuntSearch search = new IsoHuntSearch(provider);
		PageResults pageOne = search.search(new PageQuery("doctor who season 5", 1));
		PageResults pageTwo = search.search(new PageQuery("doctor who season 5", 2));
		PageResults pageThree = search.search(new PageQuery("doctor who season 5", 3));
		PageResults pageFour = search.search(new PageQuery("doctor who season 5", 4));
		PageResults pageFive = search.search(new PageQuery("doctor who season 5", 5));
		PageResults pageSix = search.search(new PageQuery("doctor who season 5", 6));
		PageResults pageSeven = search.search(new PageQuery("doctor who season 5", 7));
		PageResults pageEight = search.search(new PageQuery("doctor who season 5", 8));
		PageResults pageNine = search.search(new PageQuery("doctor who season 5", 9));

		assertEquals(0, pageNine.getCurrentPage());
		assertEquals(0, pageNine.getNumberOfPages());
		assertEquals(0, pageNine.getSearchResults().size());
	}
}

class MockSearchProvider implements SearchProvider {
	@Override
	public Document searchResults(PageQuery query) throws IOException {
		return Jsoup.parse(ResourceUtils.loadResourceAsString("/search-results-p" + query.getPage() + ".html"));
	}
}