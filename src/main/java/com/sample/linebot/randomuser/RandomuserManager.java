package com.sample.linebot.randomuser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

public class RandomuserManager {

	public RandomUser getRandomUser() {
		RandomUser user = null;
		try {
			user = createResult(getHttpResponseBody());
		} catch (IOException e) {
			user = new RandomUser();
		}

		return user;
	}

	protected String getRequestUrl() {
		return "http://api.randomuser.me/?gender=female";
	}

	protected RandomUser createResult(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, RandomUser.class);
	}

	protected String getHttpResponseBody() throws IOException {
		OkHttpClient client = new OkHttpClient();

		okhttp3.Request request = new okhttp3.Request.Builder().url(getRequestUrl()).build();

		okhttp3.Response response = client.newCall(request).execute();
		return response.body().string();
	}

}
