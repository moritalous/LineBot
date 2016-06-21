package com.sample.linebot.dynamodb;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;

public class DynamoTableManager {
	private static final String TABLE_NAME = "line_bot_table";

	public void insertData(String data) {

		AmazonDynamoDBClient dynamoDB = new AmazonDynamoDBClient();
		dynamoDB.withRegion(Regions.US_EAST_1);

		Map<String, AttributeValue> item = new HashMap<>();
		item.put("pkey", new AttributeValue(UUID.randomUUID().toString()));
		item.put("json", new AttributeValue(data));

		PutItemRequest putItemRequest = new PutItemRequest(TABLE_NAME, item);

		dynamoDB.putItem(putItemRequest);
	}

}
