package com.sample.linebot;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.linebot.api.receivemessage.ReceiveMessageRequest;
import com.sample.linebot.api.receivemessage.Result;
import com.sample.linebot.mybot.sendmessage.IMyBot;
import com.sample.linebot.mybot.sendmessage.MyBotManager;

/**
 * DynamoDBへのデータ登録をトリガーに起動し、 メッセージの解析と返信メッセージの送信を行う。
 *
 */
public class SendMessageHandler implements RequestHandler<DynamodbEvent, Response> {

	@Override
	public Response handleRequest(DynamodbEvent event, Context context) {

		List<DynamodbStreamRecord> records = event.getRecords();

		for (DynamodbStreamRecord record : records) {

			System.out.println(record.toString());

			Map<String, AttributeValue> image = record.getDynamodb().getNewImage();
			if (image == null) {
				return null;
			}

			AttributeValue value = image.get("json");
			String s = value.getS();

			System.out.println(s);

			try {
				ReceiveMessageRequest input = createRequest(s);

				for (Result result : input.getResult()) {

					IMyBot bot = MyBotManager.getMyBot(result);
					bot.execute(result);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	private ReceiveMessageRequest createRequest(String json)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, ReceiveMessageRequest.class);
	}

}
