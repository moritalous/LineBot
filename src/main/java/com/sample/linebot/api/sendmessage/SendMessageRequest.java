package com.sample.linebot.api.sendmessage;

public class SendMessageRequest {

	String[] to;
	Content content;

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public Long getToChannel() {
		return 1383378250L;
	}

	public String getEventType() {
		return "138311608800106203";
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

}
