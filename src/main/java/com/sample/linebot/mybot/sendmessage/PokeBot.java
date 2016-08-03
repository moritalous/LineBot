package com.sample.linebot.mybot.sendmessage;

import com.sample.linebot.api.receivemessage.Location;
import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;
import com.sample.linebot.pokemon.Pokemon;
import com.sample.linebot.pokemon.PokemonGet;

public class PokeBot implements IMyBot {

	@Override
	public boolean match(Result result) {

		if (result == null) {
			return false;
		}

		if (result.getContent() == null) {
			return false;
		}

		if (result.getContent().getLocation() == null) {
			return false;
		}

		Location location = result.getContent().getLocation();
		System.out.println(location.toString());

		return true;
	}

	@Override
	public void execute(Result result) {
		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		Location location = result.getContent().getLocation();
		int pokeNo = getPokeNo(location);

		PokemonGet pokemonGet = new PokemonGet();
		Pokemon pokemon = pokemonGet.requestDetail(pokeNo);

		manager.sendImageContent(to, pokemon.getLargeImageUrl(), pokemon.getLargeImageUrl());

		String text = new StringBuilder().append(pokemon.getName() + " ゲットだぜ！").toString();

		manager.sendTextContent(to, text);
	}

	@Override
	public String keyword() {
		return "ロケーションで検索";
	}

	@Override
	public String descryption() {
		return "ポケモンGoo";
	}

	private int getPokeNo(Location location) {
		Double latitude = location.getLatitude();
		Double longitude = location.getLongitude();

		long rLatitude = Math.round(latitude * 10000);
		long rLongitude = Math.round(longitude * 10000);

		return getPokeNo(rLatitude + rLongitude);
	}

	private int getPokeNo(long inputNo) {
		return (int) (inputNo % 151);
	}

}
