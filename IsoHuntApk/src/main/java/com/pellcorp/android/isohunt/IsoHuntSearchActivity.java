package com.pellcorp.android.isohunt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.pellcorp.android.isohunt.IsoHuntSearchResultsReceiver.Receiver;

public class IsoHuntSearchActivity extends Activity implements Receiver {
	private final Logger logger = LoggerFactory.getLogger(getClass().getName());
	private IsoHuntSearchResultsReceiver receiver;
	private ProgressDialog progressDialog;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		logger.info("Starting onCreate");

		setContentView(R.layout.main);
		
		IntentFilter filter = new IntentFilter(
				IsoHuntSearchResultsReceiver.ACTION_SEARCH_RESULTS_DOWNLOADED);
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		receiver = new IsoHuntSearchResultsReceiver(this);
		registerReceiver(receiver, filter);
	}
	
	private void doSearch() {
		progressDialog = ProgressDialog.show(this, getString(R.string.please_wait), 
				getString(R.string.loading_results));
		
		Intent intent = new Intent(this, IsoHuntSearchService.class);
		startService(intent);
	}
	
	@Override
	public void onReceive(PageResults results) {
		progressDialog.dismiss();
		
		
	}
}
