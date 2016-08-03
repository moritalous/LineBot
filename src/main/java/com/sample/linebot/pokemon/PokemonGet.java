package com.sample.linebot.pokemon;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PokemonGet {
	private static final String baseUrl = "http://www.pokemon.jp/zukan/detail/%03d.html";

	public Pokemon requestDetail(int no) {

		Document document;
		try {
			document = Jsoup.connect(createUrl(no)).get();
			return createPokemon(document);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	private String createUrl(int no) {
		return String.format(baseUrl, no);
	}

	private Pokemon createPokemon(Document document) {
		Pokemon pokemon = new Pokemon();

		String no = document.getElementsByClass("pokemon-page").get(0).getElementsByClass("num").get(0).text();

		pokemon.setNo(Integer.parseInt(no.replace("No.", "")));

		pokemon.setName(document.getElementsByClass("pokemon-page").get(0).getElementsByClass("name").get(0).text());

		String profilePhto = document.getElementsByClass("profile-phto").get(0).getElementsByTag("img").get(0)
				.attributes().get("src");
		pokemon.setProfilePhto(profilePhto);

		return pokemon;
	}
}
