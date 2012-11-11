package com.pellcorp.android.isohunt;

public class Rating {
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
