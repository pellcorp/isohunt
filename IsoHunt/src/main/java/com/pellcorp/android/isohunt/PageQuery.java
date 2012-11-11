package com.pellcorp.android.isohunt;

import java.io.Serializable;

public class PageQuery implements Serializable {
	private final String query;
	private final int page;
	
	public PageQuery(String query, int page) {
		this.query = query;
		this.page = page;
	}

	public String getQuery() {
		return query;
	}

	public int getPage() {
		return page;
	}
	
	
}
