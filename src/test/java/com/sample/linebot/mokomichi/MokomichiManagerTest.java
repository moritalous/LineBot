package com.sample.linebot.mokomichi;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MokomichiManagerTest {

	static MokomichiManager manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		manager = new MokomichiManager();
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
	public void testGetRecipeList() {
		List<Recipe> recipes = manager.getRecipeList();

		recipes.forEach(r -> System.out.println(String.join("\t", r.getName(), r.getUrl())));
	}

}
