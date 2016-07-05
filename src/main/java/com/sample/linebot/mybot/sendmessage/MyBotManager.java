package com.sample.linebot.mybot.sendmessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sample.linebot.api.receivemessage.Result;

public class MyBotManager {

	@SuppressWarnings("unchecked")
	private static Class<? extends IMyBot>[] classArray = new Class[] { HelpBot.class, YokaiBot.class, TalentBot.class,
			MusicSearchBot.class, MusicBot.class, MokomichiBot.class, RepeatBot.class };

	public static IMyBot getMyBot(Result result) {
		return Arrays.asList(classArray).stream().map(clazz -> {
			try {
				return clazz.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new RepeatBot();
		}).distinct().filter(bot -> bot.match(result)).findFirst().get();
	}

	public static String getHelpMessage() {
		List<String> list = Arrays.asList(classArray).stream().map(clazz -> {
			try {
				return clazz.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new RepeatBot();
		}).distinct().filter(bot -> (bot.keyword() != null && bot.descryption() != null))
				.map(myBot -> String.format("「%s」→%s", myBot.keyword(), myBot.descryption()))
				.collect(Collectors.toList());

		return String.join("\r\n", list);
	}
}
