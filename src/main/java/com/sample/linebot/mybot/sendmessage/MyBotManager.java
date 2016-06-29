package com.sample.linebot.mybot.sendmessage;

import com.sample.linebot.api.receivemessage.Result;

public class MyBotManager {

	@SuppressWarnings("unchecked")
	private static Class<? extends IMyBot>[] classArray = new Class[] { HelpBot.class, YokaiBot.class, TalentBot.class,
			MusicSearchBot.class, MusicBot.class };

	public static IMyBot getMyBot(Result result) {
		for (int i = 0; i < classArray.length; i++) {
			try {
				Class<? extends IMyBot> clazz = classArray[i];
				IMyBot myBot = clazz.newInstance();
				if (myBot.match(result)) {
					return myBot;
				}
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return new RepeatBot();
	}

	public static String getHelpMessage() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < classArray.length; i++) {
			try {
				Class<? extends IMyBot> clazz = classArray[i];
				IMyBot myBot = clazz.newInstance();
				builder.append(String.format("「%s」→%s", myBot.keyword(), myBot.descryption())).append("\r\n");
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return builder.toString();
	}
}
