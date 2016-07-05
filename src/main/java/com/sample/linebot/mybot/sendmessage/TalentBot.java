package com.sample.linebot.mybot.sendmessage;

import java.util.Collections;

import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;
import com.sample.linebot.talent.AbstractTalentManager;
import com.sample.linebot.talent.Talent;
import com.sample.linebot.talent.TalentList;
import com.sample.linebot.talent.TalentSearchManager;

public class TalentBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		String text = result.getContent().getText();
		if (text.endsWith("さん")) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(Result result) {

		String text = result.getContent().getText();
		text = text.substring(0, text.length() - 2);
		System.out.println(text);

		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		AbstractTalentManager talentManager = new TalentSearchManager(text);
		TalentList talentList = talentManager.getTalentList();

		Collections.shuffle(talentList);
		Talent talent = talentList.stream().findFirst().orElse(null);
		if (talent == null) {
			manager.sendTextContent(to, "誰？？");
		} else {
			sendTalent(talent, manager, result);
		}
	}

	private void sendTalent(Talent talent, SendMessageManager manager, Result result) {
		String to = result.getContent().getFrom();

		manager.sendImageContent(to, talent.getImgSrc(), talent.getImgSrc());

		String text = "呼んだ？　(" + talent.getName() + ")";
		manager.sendTextContent(to, text);
	}

	@Override
	public String keyword() {
		return "×××さん";
	}

	@Override
	public String descryption() {
		return "有名人検索";
	}

}
