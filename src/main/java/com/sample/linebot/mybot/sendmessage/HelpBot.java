package com.sample.linebot.mybot.sendmessage;

import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;

public class HelpBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		String text = result.getContent().getText();
		if (text.equals("ヘルプ")) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(Result result) {
		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();
		manager.sendTextContent(to, MyBotManager.getHelpMessage());
	}

	@Override
	public String keyword() {
		return "ヘルプ";
	}

	@Override
	public String descryption() {
		return "ヘルプを表示";
	}

}
