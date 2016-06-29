package com.sample.linebot.mybot.sendmessage;

import com.sample.linebot.api.receivemessage.Result;

public class MyBotManager {

	public static IMyBot getMyBot(Result result) {

		IMyBot myBot = null;

		myBot = new HelpBot();
		if (myBot.match(result)) {
			return myBot;
		}

		myBot = new YokaiBot();
		if (myBot.match(result)) {
			return myBot;
		}

		myBot = new TalentBot();
		if (myBot.match(result)) {
			return myBot;
		}
		myBot = new MusicSearchBot();
		if (myBot.match(result)) {
			return myBot;
		}

		myBot = new MusicBot();
		if (myBot.match(result)) {
			return myBot;
		}

		return new RepeatBot();
	}

}
