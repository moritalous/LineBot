package com.sample.linebot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.sample.linebot.dynamodb.DynamoTableManager;

public class ReceiveMessageHandler implements RequestStreamHandler {

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		StringBuilder builder = getRequestString(input);

		DynamoTableManager tableManager = new DynamoTableManager();
		tableManager.insertData(builder.toString());
	}

	private StringBuilder getRequestString(InputStream input) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input, "UTF-8"));

		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}

		return stringBuilder;
	}

}
