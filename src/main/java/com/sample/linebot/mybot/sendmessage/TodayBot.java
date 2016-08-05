package com.sample.linebot.mybot.sendmessage;

import java.util.Calendar;
import java.util.Locale;

import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;
import com.sample.linebot.today.Today;
import com.sample.linebot.today.TodayManager;

public class TodayBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		String text = result.getContent().getText();
		if (text.contains("今日はなんの日") || text.contains("今日は何の日")) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(Result result) {
		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		TodayManager todayManager = new TodayManager();
		Today today = todayManager.requestToday();
		if (today.getTitle() != null) {
			{
				manager.sendTextContent(to, text);
				if (today.getDetail() != null && !today.getDetail().equals("")) {
					manager.sendTextContent(to, today.getDetail());
				}
			}
			{
				Calendar nowCalendar = Calendar.getInstance(Locale.JAPAN);

				if (nowCalendar.get(Calendar.MONTH) == Calendar.AUGUST && nowCalendar.get(Calendar.DAY_OF_MONTH) == 5) {
					String text = "そして、久保田くんの誕生日だよ。";
					manager.sendTextContent(to, text);

					text = "おめでとう！！";
					manager.sendTextContent(to, text);
				}
			}
		} else {
			manager.sendTextContent(to, "しらん");
		}
	}

	@Override
	public String keyword() {
		return "今日は何の日";
	}

	@Override
	public String descryption() {
		return "今日は何の記念日かな";
	}
}
