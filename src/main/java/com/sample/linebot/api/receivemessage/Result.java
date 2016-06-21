package com.sample.linebot.api.receivemessage;

public class Result {
	Content content;
	Long createdTime;
	String eventType;
	String from;
	Long fromChannel;
	String id;
	String[] to;
	Long toChannel;

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Long getFromChannel() {
		return fromChannel;
	}

	public void setFromChannel(Long fromChannel) {
		this.fromChannel = fromChannel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public Long getToChannel() {
		return toChannel;
	}

	public void setToChannel(Long toChannel) {
		this.toChannel = toChannel;
	}

}