package com.sample.linebot.talent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TalentManager extends AbstractTalentManager {

	@Override
	protected final String getRequestUrl() {
		return "http://talent.yahoo.co.jp/";
	}

	@Override
	protected final TalentList parseHtml(String html) {
		TalentList talentList = new TalentList();

		Document document = Jsoup.parse(html);
		Element subElement = document.getElementById("sub");
		Elements liElements = subElement.getElementsByTag("li");

		for (Element element : liElements) {
			Talent talent = new Talent();

			talent.setAnchor(element.getElementsByTag("a").get(0).attributes().get("href").toString());
			talent.setImgSrc(element.getElementsByTag("img").get(0).attributes().get("src").toString());
			talent.setName(element.getElementsByClass("name").get(0).text());

			talentList.add(talent);
		}

		return talentList;
	}

}
