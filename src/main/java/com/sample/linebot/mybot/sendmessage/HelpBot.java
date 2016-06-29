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
		manager.sendTextContent(to, createMessage());
	}

	private String createMessage() {
		StringBuilder builder = new StringBuilder();

		builder.append("キーワードはこちら").append("\r\n").append("×××さん").append("\r\n").append("ミュージック").append("\r\n")
				.append("○○○がききたい").append("\r\n").append("妖怪メダル セットオン！").append("\r\n");

		return builder.toString();
	}

}
