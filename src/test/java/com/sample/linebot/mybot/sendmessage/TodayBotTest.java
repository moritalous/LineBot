package com.sample.linebot.mybot.sendmessage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sample.linebot.api.receivemessage.Content;
import com.sample.linebot.api.receivemessage.Result;

public class TodayBotTest {

	static TodayBot bot;
	static Result result;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bot = new TodayBot();
		result = new Result();

		Content content = new Content();
		content.setText("今日は何の日?");
		content.setFrom("u66eb058a543de3ae204047c8f4795d29");

		result.setContent(content);
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
	public void test() {
		bot.execute(result);
	}

}
