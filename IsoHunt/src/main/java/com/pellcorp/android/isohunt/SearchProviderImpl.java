package com.pellcorp.android.isohunt;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SearchProviderImpl implements SearchProvider {
	public static final String HOST_NAME = "isohunt.com";
	public static final String SEARCH_LOCATION = "/torrents/";
	public static final String DOWNLOAD_LOCATION = "/torrents/";
	
	@Override
	public Document searchResults(PageQuery query) throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("ihq", query.getQuery()));
		params.add(new BasicNameValuePair("ihp", query.getPage() + ""));
		return getHtmlPage(SEARCH_LOCATION, params);
	}

	private static Document getHtmlPage(String virtualLocation, 
			List<NameValuePair> params) throws IOException {
		HttpClient httpClient = new DefaultHttpClient();

		try {
			URI uri = URIUtils.createURI("http", HOST_NAME, -1, virtualLocation, 
				    URLEncodedUtils.format(params, "UTF-8"), null);
			
			HttpGet get = new HttpGet(uri);

			HttpResponse response = httpClient.execute(get);
			
			return Jsoup.parse(EntityUtils.toString(response.getEntity()));
		} catch(IOException e) {
			throw e;
		} catch(Exception e) {
			throw new IOException(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
}
