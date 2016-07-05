package com.sample.linebot.mybot.sendmessage;

import java.util.Collections;
import java.util.List;

import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;
import com.sample.linebot.mokomichi.MokomichiManager;
import com.sample.linebot.mokomichi.Recipe;

public class MokomichiBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		String text = result.getContent().getText();
		if (text.contains("空いた") || text.contains("すいた")) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(Result result) {
		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		MokomichiManager mokomichiManager = new MokomichiManager();
		List<Recipe> recipes = mokomichiManager.getRecipeList();

		Collections.shuffle(recipes);

		String message = createMessage(recipes.stream().findFirst().get());

		manager.sendTextContent(to, message);
	}

	private String createMessage(Recipe recipe) {
		return String.format("%sとかどう？\r\nby MOCO'Sキッチン\r\n%s", recipe.getName(), recipe.getUrl());
	}

	@Override
	public String keyword() {
		return "お腹すいた";
	}

	@Override
	public String descryption() {
		return "MOCO'Sキッチン";
	}

}
