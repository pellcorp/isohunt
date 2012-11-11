package com.pellcorp.android.isohunt;

import java.io.Serializable;

public class Rating implements Serializable {
	private final String rating;
	private final int commentCount;
	
	public Rating(String rating, int commentCount) {
		this.rating = rating;
		this.commentCount = commentCount;
	}

	public String getRating() {
		return rating;
	}

	public int getCommentCount() {
		return commentCount;
	}
}
