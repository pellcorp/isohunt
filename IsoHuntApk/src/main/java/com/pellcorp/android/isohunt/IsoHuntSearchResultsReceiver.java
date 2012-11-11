package com.pellcorp.android.isohunt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class IsoHuntSearchResultsReceiver extends BroadcastReceiver {
	public static final String SEARCH_RESULTS_DOWNLOADED =
		      "com.pellcorp.android.transact.action.SEARCH_RESULTS_DOWNLOADED";
	
	private final Receiver receiver;
	
	public IsoHuntSearchResultsReceiver(final Receiver receiver) {
		super();
		
		this.receiver = receiver;
	}
	
	public interface Receiver {
		void onReceive(PageResults results);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		@SuppressWarnings("unchecked")
		PageResults results = (PageResults) intent.getSerializableExtra(IsoHuntSearchService.SEARCH_RESULTS);
		receiver.onReceive(results);
	}
}
