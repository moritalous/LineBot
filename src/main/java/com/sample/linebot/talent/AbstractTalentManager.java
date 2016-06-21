package com.sample.linebot.talent;

import java.io.IOException;

import okhttp3.OkHttpClient;

public abstract class AbstractTalentManager {

	public TalentList getTalentList() {
		TalentList talentList = null;

		try {
			String html = getHtml();
			talentList = parseHtml(html);
		} catch (Exception e) {
			talentList = new TalentList();
		}
		return talentList;
	}

	protected String getHtml() throws IOException {
		OkHttpClient client = new OkHttpClient();

		okhttp3.Request request = new okhttp3.Request.Builder().url(getRequestUrl()).build();

		okhttp3.Response response = client.newCall(request).execute();
		return response.body().string();
	}

	protected abstract String getRequestUrl();

	protected abstract TalentList parseHtml(String html);

}
