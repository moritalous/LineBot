package com.sample.linebot.mybot.sendmessage;

import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;

public class RepeatBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		return true;
	}

	@Override
	public void execute(Result result) {
		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		String text = result.getContent().getText();
		manager.sendTextContent(to, text);
	}
}
