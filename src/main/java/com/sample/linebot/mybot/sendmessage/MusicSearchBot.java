package com.sample.linebot.mybot.sendmessage;

import java.util.Collections;
import java.util.List;

import com.sample.linebot.Itunes.ItunesTrackSearchManager;
import com.sample.linebot.Itunes.tracksearch.SearchResult;
import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.api.sendmessage.SendMessageManager;

public class MusicSearchBot implements IMyBot {

	@Override
	public boolean match(Result result) {
		String text = result.getContent().getText();
		if (text.endsWith("がききたい") || text.endsWith("が聞きたい") || text.endsWith("が聴きたい")) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(Result result) {
		String text = result.getContent().getText();
		text = text.substring(0, text.length() - 5);

		SendMessageManager manager = new SendMessageManager();
		String to = result.getContent().getFrom();

		ItunesTrackSearchManager searchManager = new ItunesTrackSearchManager();
		SearchResult searchResults = searchManager.getSearchResult(text);
		if (searchResults.getResultCount() == 0) {
			manager.sendTextContent(to, "みつからなかった。。。");
			return;
		}

		com.sample.linebot.Itunes.tracksearch.Result searchResult = choiceTrack(searchResults);

		String title = searchResult.getTrackName();
		String artist = searchResult.getArtistName();
		String image = searchResult.getArtworkUrl100();

		int duration = searchResult.getTrackTimeMillis() / 10;

		String previewUrl = searchResult.getPreviewUrl();

		String message = String.format("%s / %s", title, artist);

		manager.sendTextContent(to, "どうぞ。");
		manager.sendImageContent(to, image, image);
		manager.sendTextContent(to, message);
		manager.sendAudioContent(to, previewUrl, Integer.toString(duration));
	}

	private com.sample.linebot.Itunes.tracksearch.Result choiceTrack(SearchResult searchResult) {
		List<com.sample.linebot.Itunes.tracksearch.Result> results = searchResult.getResults();
		Collections.shuffle(results);
		return results.get(0);
	}

	@Override
	public String keyword() {
		return "×××がききたい";
	}

	@Override
	public String descryption() {
		return "ミュージック検索";
	}

}
