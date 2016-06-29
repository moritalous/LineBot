package com.sample.linebot.mybot.sendmessage;

import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;

public class YokaiBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		String text = result.getContent().getText();
		if (text.contains("セットオン") || text.indexOf("セットオン") > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(Result result) {
		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		String text = "プリチー 俺っち友達 福は内！";
		manager.sendTextContent(to, text);

		sleep(1000);

		text = "ジバニャン！！！";
		manager.sendTextContent(to, text);

		sleep(1000);

		String originalContentUrl = "http://yw.b-boys.jp/member/images/items/list/medal/1/img_medal93.png";
		String previewImageUrl = "http://yw.b-boys.jp/member/images/items/list/medal/1/img_medal93.png";

		manager.sendImageContent(to, originalContentUrl, previewImageUrl);
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public String keyword() {
		return "妖怪メダル セットオン！";
	}

	@Override
	public String descryption() {
		return "召喚";
	}
}
