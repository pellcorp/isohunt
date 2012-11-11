package com.pellcorp.android.isohunt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.app.IntentService;
import android.content.Intent;

public class IsoHuntSearchService extends IntentService {
	public static final String SEARCH_RESULTS = "com.pellcorp.android.isohun.SEARCH_RESULTS";
	public static final String SEARCH_QUERY = "com.pellcorp.android.isohun.SEARCH_QUERY";
	
	private final Logger logger = LoggerFactory.getLogger(getClass().getName());
	private SearchProvider searchProvider;
	
	public IsoHuntSearchService() {
		super("IsoHuntSearchService");
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		searchProvider = new SearchProviderImpl();
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		Intent broadcastIntent = new Intent();
		broadcastIntent.setAction(IsoHuntSearchResultsReceiver.ACTION_SEARCH_RESULTS_DOWNLOADED);
		broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
		
		try {
			PageQuery pageQuery = (PageQuery) intent.getSerializableExtra(SEARCH_QUERY);
			IsoHuntSearch search = new IsoHuntSearch(searchProvider);
			PageResults results = search.search(pageQuery);
			broadcastIntent.putExtra(SEARCH_RESULTS, results);
		} catch (IOException e) {
			// FIXME - pass error messages back!
			broadcastIntent.putExtra(SEARCH_RESULTS, new PageResults());
		}
		sendBroadcast(broadcastIntent);
	}
}
