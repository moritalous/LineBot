package com.sample.linebot.mokomichi;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import okhttp3.OkHttpClient;

public class MokomichiManager {

	public List<Recipe> getRecipeList() {
		return parseHtml(getHtml());
	}

	protected String getHtml() {
		String result = "";

		try {
			OkHttpClient client = new OkHttpClient();
			okhttp3.Request request = new okhttp3.Request.Builder().url(getRequestUrl()).build();
			okhttp3.Response response = client.newCall(request).execute();
			result = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	protected String getRequestUrl() {
		return "http://www.ntv.co.jp/zip/mokomichi/";
	}

	protected List<Recipe> parseHtml(String html) {
		Document document = Jsoup.parse(html);
		Elements entry = document.getElementsByClass("entry");

		return entry.stream().map(e -> {
			Elements a = e.getElementsByTag("a");
			String href = a.first().attributes().get("href").toString();

			Elements h3 = e.getElementsByTag("h3");
			String name = h3.first().text();

			String url = String.join("", getRequestUrl(), href);

			return new Recipe(name, url);
		}).filter(r -> r.getName() != null && r.getUrl() != null).collect(Collectors.toList());
	}

}
