package com.sample.linebot.mybot.sendmessage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sample.linebot.api.receivemessage.Content;
import com.sample.linebot.api.receivemessage.Result;

public class MyBotManagerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMyBot() {
		{
			Result result = createMusicResult();
			IMyBot mybot = MyBotManager.getMyBot(result);
			Assert.assertEquals(true, mybot instanceof MusicBot);
		}
		{
			Result result = createRepeatResult();
			IMyBot mybot = MyBotManager.getMyBot(result);
			Assert.assertEquals(true, mybot instanceof RepeatBot);
		}
	}

	@Test
	public void testGetHelpMessage() {

		String[] str = new String[] { "「ヘルプ」→ヘルプを表示", "「妖怪メダル セットオン！」→召喚", "「×××さん」→有名人検索", "「×××がききたい」→ミュージック検索",
				"「ミュージック」→ミュージックランキング" };
		String expected = String.join("\r\n", str);

		Assert.assertEquals(expected, MyBotManager.getHelpMessage());
	}

	private Result createMusicResult() {
		return createResult("ミュージック");
	}

	private Result createRepeatResult() {
		return createResult("こんにちは。");
	}

	private Result createResult(String text) {
		Result result = new Result();

		Content content = new Content();
		content.setText(text);
		result.setContent(content);

		return result;
	}

}
