package com.sample.linebot.mybot.sendmessage;

import java.util.List;

import com.sample.linebot.Itunes.ItunesMusicManager;
import com.sample.linebot.ItunesMusic.Entry;
import com.sample.linebot.ItunesMusic.Music;
import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;

public class MusicBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		String text = result.getContent().getText();
		if (text.contains("ミュージック")) {
			return true;
		}
		return true;
	}

	@Override
	public void execute(Result result) {
		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		ItunesMusicManager musicManager = new ItunesMusicManager();
		Music music = musicManager.getMusic();

		Entry entry = choiceEntry(music.getFeed().getEntry());

		String title = entry.getImName().getLabel();
		String artist = entry.getImArtist().getLabel();
		String image = entry.getImImage().get(2).getLabel();

		String duration = entry.getLink().get(1).getImDuration().getLabel();
		int iDuration = 30;
		try {
			iDuration = Integer.parseInt(duration) / 10;
		} catch (NumberFormatException e) {
		}
		String href = entry.getLink().get(1).getAttributes().getHref();

		String message = String.format("%s / %s", title, artist);

		manager.sendImageContent(to, image, image);

		manager.sendTextContent(to, message);

		manager.sendAudioContent(to, href, Integer.toString(iDuration));
	}

	private Entry choiceEntry(List<Entry> entries) {

		int size = entries.size();
		int num = (int) (Math.random() * 1000) % size;

		return entries.get(num);
	}

}
