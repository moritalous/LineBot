package com.sample.linebot.api.sendmessage;

public class TextContent implements Content {

	String text;

	public Long getContentType() {
		return (long) 1;
	}

	public Long getToType() {
		return (long) 1;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
