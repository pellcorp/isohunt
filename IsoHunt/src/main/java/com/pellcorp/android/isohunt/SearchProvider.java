package com.pellcorp.android.isohunt;

import java.io.IOException;

import org.jsoup.nodes.Document;

public interface SearchProvider {
	Document searchResults(PageQuery query) throws IOException;
}
