package com.sample.linebot.api.profile;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.linebot.api.profile.response.Contact;
import com.sample.linebot.api.profile.response.Response;
import com.sample.linebot.api.sendmessage.SendMessageConstants;

import okhttp3.OkHttpClient;

public class GetProfileManager {

	public Contact requestProfile(String mid) {
		Contact contact = null;

		Response response;
		try {
			response = requestProfile(new String[] { mid });
			List<Contact> contacts = response.getContacts();
			if (contacts.size() > 0) {
				contact = contacts.get(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contact;
	}

	public Response requestProfile(String[] mids) throws JsonParseException, JsonMappingException, IOException {
		return convertJsonToResponse(requestProfileToServer(mids));
	}

	private String requestProfileToServer(String[] mids) throws IOException {
		OkHttpClient client = new OkHttpClient();

		String param = String.join(",", mids);

		String url = String.format("https://trialbot-api.line.me/v1/profiles?mids=%s", param);

		okhttp3.Request request = new okhttp3.Request.Builder().url(url)
				.header("Content-Type", "application/json; charser=UTF-8")
				.addHeader("X-Line-ChannelID", SendMessageConstants.LINE_CHANNELID)
				.addHeader("X-Line-ChannelSecret", SendMessageConstants.LINE_CHANNELSECRET)
				.addHeader("X-Line-Trusted-User-With-ACL", SendMessageConstants.LINE_TRUSTED_USER_WITH_ACL).get()
				.build();
		okhttp3.Response response = client.newCall(request).execute();

		// System.out.println(response.isSuccessful());
		// System.out.println(response.message());
		// System.out.println(response.body().string());

		return response.body().string();
	}

	private Response convertJsonToResponse(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		return mapper.readValue(json, Response.class);
	}
}
