package com.sample.linebot.api.profile;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sample.linebot.api.profile.response.Contact;
import com.sample.linebot.api.profile.response.Response;

public class GetProfileManagerTest {

	GetProfileManager manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		manager = new GetProfileManager();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		String[] mids = { "XXXXX" };

		try {
			Response response = manager.requestProfile(mids);

			List<Contact> contacts = response.getContacts();
			for (Contact contact : contacts) {
				contact.getDisplayName();
				contact.getPictureUrl();
				contact.getStatusMessage();
			}
			System.out.println(response.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
