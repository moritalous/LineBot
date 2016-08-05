package com.sample.linebot.mybot.sendmessage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sample.linebot.api.receivemessage.Content;
import com.sample.linebot.api.receivemessage.Location;
import com.sample.linebot.api.receivemessage.Result;

public class PokeBotTest {

	static PokeBot target;
	static Result result;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		target = new PokeBot();
		result = new Result();
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
		{
			Content content = new Content();
			Location location = new Location();
			location.setTitle("堺筋本町駅");
			location.setLatitude(12345.12345);
			location.setLongitude(55555.55555);
			content.setLocation(location);
			content.setFrom("u66eb058a543de3ae204047c8f4795d29");
			result.setContent(content);

			target.execute(result);

		}
	}

}
