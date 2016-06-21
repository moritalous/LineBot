package com.sample.linebot.api.receivemessage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
	Long toType;
	Long createdTime;
	String from;
	Location location;
	String id;
	String[] to;
	String text;
	ContentMetadata contentMetadata;
	Long deliveredTime;
	Long contentType;
	String seq;

	public Long getToType() {
		return toType;
	}

	public void setToType(Long toType) {
		this.toType = toType;
	}

	public Long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ContentMetadata getContentMetadata() {
		return contentMetadata;
	}

	public void setContentMetadata(ContentMetadata contentMetadata) {
		this.contentMetadata = contentMetadata;
	}

	public Long getDeliveredTime() {
		return deliveredTime;
	}

	public void setDeliveredTime(Long deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	public Long getContentType() {
		return contentType;
	}

	public void setContentType(Long contentType) {
		this.contentType = contentType;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

}