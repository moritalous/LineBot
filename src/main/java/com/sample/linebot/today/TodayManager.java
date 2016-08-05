package com.sample.linebot.today;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import okhttp3.OkHttpClient;

public class TodayManager {

	public Today requestToday() {
		Today today = null;

		try {
			today = parseHtml(getHtml());
		} catch (IOException e) {
			today = new Today();
		}
		return today;
	}

	private String getRequestUrl() {
		return "http://kids.yahoo.co.jp/today/";
	}

	private String getHtml() throws IOException {
		OkHttpClient client = new OkHttpClient();

		okhttp3.Request request = new okhttp3.Request.Builder().url(getRequestUrl()).build();

		okhttp3.Response response = client.newCall(request).execute();
		return response.body().string();
	}

	private Today parseHtml(String html) {
		Today today = new Today();

		// //*[@id="dateDtl"]/dt/span
		Document document = Jsoup.parse(html);

		Element dateDtrElement = document.getElementById("dateDtl");
		Element dtElement = dateDtrElement.getElementsByTag("dt").stream().findFirst().get();
		Element spanElement = dtElement.getElementsByTag("span").stream().findFirst().get();
		Element ddElement = dateDtrElement.getElementsByTag("dd").stream().findFirst().get();

		today.setTitle(spanElement.html());
		today.setDetail(ddElement.html());

		return today;
	}
}
