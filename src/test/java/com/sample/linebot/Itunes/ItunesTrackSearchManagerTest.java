package com.sample.linebot.Itunes;

import org.junit.BeforeClass;
import org.junit.Test;

public class ItunesTrackSearchManagerTest {

	public static ItunesTrackSearchManager manager;

	@BeforeClass
	public static void createManager() {
		manager = new ItunesTrackSearchManager();
	}

	@Test
	public void getSearchResult() {

		// {
		// String keyword = "GLAY";
		// SearchResult result = manager.getSearchResult(keyword);
		// Assert.assertEquals(keyword,
		// result.getResults().get(0).getArtistName());
		// }
		// {
		// String keyword = "コブクロ";
		// SearchResult result = manager.getSearchResult(keyword);
		// Assert.assertEquals(keyword,
		// result.getResults().get(0).getArtistName());
		// }
		// {
		// String keyword = "桜";
		// SearchResult result = manager.getSearchResult(keyword);
		// Assert.assertEquals(keyword,
		// result.getResults().get(0).getArtistName());
		// }

	}

}
