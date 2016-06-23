package com.sample.linebot.api.sendmessage;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.linebot.api.sendmessage.AudioContent.ContentMetadata;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class SendMessageManager {

	public void sendTextContent(String to, String text) {
		sendTextContent(new String[] { to }, text);
	}

	public void sendTextContent(String[] to, String text) {
		SendMessageRequest message = new SendMessageRequest();
		message.setTo(to);
		TextContent content = new TextContent();
		content.setText(text);
		message.setContent(content);
		sendMessage(createPostBody(message));
	}

	public void sendImageContent(String to, String originalContentUrl, String previewImageUrl) {
		sendImageContent(new String[] { to }, originalContentUrl, previewImageUrl);
	}

	public void sendImageContent(String[] to, String originalContentUrl, String previewImageUrl) {
		SendMessageRequest message = new SendMessageRequest();
		message.setTo(to);
		ImageContent imageContent = new ImageContent();
		imageContent.setOriginalContentUrl(originalContentUrl);
		imageContent.setPreviewImageUrl(previewImageUrl);
		message.setContent(imageContent);
		sendMessage(createPostBody(message));
	}

	public void sendAudioContent(String to, String originalContentUrl, String AUDLEN) {
		sendAudioContent(new String[] { to }, originalContentUrl, AUDLEN);
	}

	public void sendAudioContent(String[] to, String originalContentUrl, String AUDLEN) {
		SendMessageRequest message = new SendMessageRequest();
		message.setTo(to);
		AudioContent audioContent = new AudioContent();
		audioContent.setOriginalContentUrl(originalContentUrl);
		ContentMetadata metadata = audioContent.new ContentMetadata();
		metadata.setAUDLEN(AUDLEN);
		audioContent.setContentMetadata(metadata);
		message.setContent(audioContent);
		sendMessage(createPostBody(message));
	}

	private void sendMessage(String postBody) {
		OkHttpClient client = new OkHttpClient();

		System.out.println(postBody);

		RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), postBody);

		okhttp3.Request request = new okhttp3.Request.Builder().url("https://trialbot-api.line.me/v1/events")
				.header("Content-Type", "application/json; charser=UTF-8")
				.addHeader("X-Line-ChannelID", SendMessageConstants.LINE_CHANNELID)
				.addHeader("X-Line-ChannelSecret", SendMessageConstants.LINE_CHANNELSECRET)
				.addHeader("X-Line-Trusted-User-With-ACL", SendMessageConstants.LINE_TRUSTED_USER_WITH_ACL).post(body)
				.build();

		try {
			okhttp3.Response response = client.newCall(request).execute();

			System.out.println(response.isSuccessful());
			System.out.println(response.message());
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String createPostBody(SendMessageRequest message) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String str = mapper.writeValueAsString(message);
			return str;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
