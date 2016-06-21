package com.sample.linebot.talent;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TalentSearchManager extends AbstractTalentManager {

	private String keyword = null;

	public TalentSearchManager(String keyword) {
		this.keyword = keyword;
	}

	@Override
	protected String getRequestUrl() {
		String encodedKeyword = "";
		try {
			encodedKeyword = URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return String.format("http://talent.search.yahoo.co.jp/search?p=%s&aq=-1&oq=&ei=UTF-8", encodedKeyword);
	}

	@Override
	protected TalentList parseHtml(String html) {
		TalentList talentList = new TalentList();

		Document document = Jsoup.parse(html);
		Element hS2mElement = document.getElementById("HS2m");
		Elements liElements = hS2mElement.getElementsByTag("li");

		for (Element element : liElements) {
			Talent talent = new Talent();

			talent.setAnchor(element.getElementsByTag("a").get(0).attributes().get("href").toString());
			talent.setImgSrc(element.getElementsByTag("img").get(0).attributes().get("src").toString());
			talent.setName(element.getElementsByTag("img").get(0).attributes().get("alt").toString());

			talentList.add(talent);
		}
		return talentList;
	}
}
