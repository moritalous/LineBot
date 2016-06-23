package com.sample.linebot.mybot.sendmessage;

import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;
import com.sample.linebot.randomuser.RandomUser;
import com.sample.linebot.randomuser.RandomuserManager;

public class RepeatBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		return true;
	}

	@Override
	public void execute(Result result) {
		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		RandomuserManager randomuserManager = new RandomuserManager();
		RandomUser users = randomuserManager.getRandomUser();
		com.sample.linebot.randomuser.Result user = users.getResults().get(0);

		manager.sendImageContent(to, user.getPicture().getLarge(), users.getResults().get(0).getPicture().getLarge());

		String text = new StringBuilder().append(result.getContent().getText()).append("\r\n")
				.append("わたしは" + user.getName().getFirst() + " " + user.getName().getLast() + "です").toString();

		manager.sendTextContent(to, text);
	}
}
