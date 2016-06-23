package com.sample.linebot.mybot.sendmessage;

import java.util.List;

import com.sample.linebot.Itunes.ItunesMusicManager;
import com.sample.linebot.Itunes.topchart.Entry;
import com.sample.linebot.Itunes.topchart.Music;
import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;

public class MusicBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		String text = result.getContent().getText();
		if (text.contains("ミュージック")) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(Result result) {
		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		ItunesMusicManager musicManager = new ItunesMusicManager();
		Music music = musicManager.getMusic();

		String message = createMessage(music);

		manager.sendTextContent(to, message);

	}

	private String createMessage(Music music) {
		StringBuilder sb = new StringBuilder();

		try {
			List<Entry> entries = music.getFeed().getEntry();
			if (entries.size() == 0) {
				throw new Exception();
			}

			for (int i = 0; i < entries.size(); i++) {
				Entry entry = entries.get(i);

				String title = entry.getImName().getLabel();
				String artist = entry.getImArtist().getLabel();
				String message = String.format("%s)%s / %s", Integer.toString(i + 1), title, artist);

				sb.append(message).append("\r\n");
			}
			sb.insert(0, "トップチャート10\r\n");
		} catch (Exception e) {
			sb = new StringBuilder().append("あれれ？");
		}

		return sb.toString();
	}
}
