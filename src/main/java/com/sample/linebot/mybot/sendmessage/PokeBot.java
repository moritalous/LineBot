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

		if (location.getTitle() != null && !location.getTitle().equals("位置情報") && !location.getTitle().equals("")) {
			if (location.getTitle().contains("堺筋本町")) {
				PokemonGet pokemonGet = new PokemonGet();
				Pokemon pokemon = pokemonGet.requestDetail(150);

				manager.sendImageContent(to, pokemon.getLargeImageUrl(), pokemon.getLargeImageUrl());

				String text = new StringBuilder().append(location.getTitle()).append("には").append(pokemon.getName())
						.append("がいるよ。").toString();

				manager.sendTextContent(to, text);
				return;
			} else {
				int hash = location.getTitle().hashCode();
				hash = Math.abs(hash);
				System.out.println("hash : " + hash);

				if ((hash % 10) > 8) {
					StringBuilder sb = new StringBuilder().append(location.getTitle()).append("はポケストップだよ。")
							.append("\r\n");

					switch ((int) (Math.random() * 100 % 3)) {
					case 1: {
						sb.append("モンスターボールを手に入れた！");
					}
						break;
					case 2: {
						sb.append("キズぐすりを手に入れた！");
					}
						break;
					case 3:
					default: {
						sb.append("ポケモンのタマゴを手に入れた！");
					}
						break;
					}
					manager.sendTextContent(to, sb.toString());
					return;
				}
				{
					PokemonGet pokemonGet = new PokemonGet();
					Pokemon pokemon = pokemonGet.requestDetail(getPokeNo(hash));

					manager.sendImageContent(to, pokemon.getLargeImageUrl(), pokemon.getLargeImageUrl());

					String text = new StringBuilder().append(location.getTitle()).append("の").append(pokemon.getName())
							.append("をゲットだぜ").toString();

					manager.sendTextContent(to, text);
					return;
				}
			}

		}

		int myPokeNo = getPokeNo(location.getLatitude() * 10000);
		int yourPokeNo = getPokeNo(location.getLongitude() * 10000);

		if ((myPokeNo + yourPokeNo) % 2 == 0) {
			// ジム戦
			{
				manager.sendTextContent(to, "ジム！！");
			}

			PokemonGet pokemonGet = new PokemonGet();

			Pokemon myPoke = pokemonGet.requestDetail(myPokeNo);
			myPoke.setHitPoint(createHitPoint(location.getLatitude()));
			{
				manager.sendImageContent(to, myPoke.getLargeImageUrl(), myPoke.getLargeImageUrl());
				String text = new StringBuilder().append("きみのポケモン：").append("\r\n").append(myPoke.getName())
						.append("\r\n").append(" HP:").append(myPoke.getHitPoint()).toString();
				manager.sendTextContent(to, text);
			}

			Pokemon yourPoke = pokemonGet.requestDetail(yourPokeNo);
			yourPoke.setHitPoint(createHitPoint(location.getLongitude()));
			{
				manager.sendImageContent(to, yourPoke.getLargeImageUrl(), yourPoke.getLargeImageUrl());
				String text = new StringBuilder().append("ジムリーダーのポケモン：").append("\r\n").append(yourPoke.getName())
						.append("\r\n").append(" HP:").append(yourPoke.getHitPoint()).toString();
				manager.sendTextContent(to, text);
			}

			// バトルスタート
			int loopFlg = 0;
			while (true) {

				boolean ret = battle(manager, to, "きみ", "ジムリーダー", yourPoke);
				if (ret) {
					return;
				}
				ret = battle(manager, to, "ジムリーダー", "きみ", myPoke);
				if (ret) {
					return;
				}
				loopFlg++;
				if (loopFlg >= 3) {
					String text = new StringBuilder().append("ジムリーダーの").append(yourPoke.getName()).append("は逃げ出した！")
							.toString();
					manager.sendTextContent(to, text);
					return;
				}
			}

		} else {
			// 見つけるだけ
			int pokeNo = getPokeNo(location);

			PokemonGet pokemonGet = new PokemonGet();
			Pokemon pokemon = pokemonGet.requestDetail(pokeNo);

			manager.sendImageContent(to, pokemon.getLargeImageUrl(), pokemon.getLargeImageUrl());

			String text = new StringBuilder().append(pokemon.getName() + " ゲットだぜ！").toString();

			manager.sendTextContent(to, text);
		}
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

	private int getPokeNo(double inputNo) {
		return (int) (inputNo % 151);
	}

	private int createHitPoint(double input) {
		return (int) (input % 100);

	}

	private int damage() {
		double val1 = Math.random() * 100 % 10;
		double val2 = Math.random() * 100 % 10;
		return (int) (val1 * val2);
	}

	/**
	 * バトル
	 * 
	 * @param manager
	 * @param to
	 * @param attackName
	 * @param attackPokemon
	 * @param defenseName
	 * @param defensePokemon
	 * @return 試合終了かどうか
	 */
	private boolean battle(SendMessageManager manager, String to, String attackName, String defenseName,
			Pokemon defensePokemon) {
		manager.sendTextContent(to, attackName + "のこうげき");
		int damage = damage();
		manager.sendTextContent(to, damage + "のダメージ！");
		int hp = defensePokemon.hit(damage);
		if (hp <= 0) {
			manager.sendTextContent(to, attackName + "のかち!");
			return true;
		} else {
			String text = new StringBuilder().append(defenseName).append("の").append(defensePokemon.getName())
					.append("\r\n").append(" のこりHP:").append(hp).toString();
			manager.sendTextContent(to, text);
		}
		return false;
	}

}
