package com.sample.linebot.api.sendmessage;

public class ImageContent implements Content {

	String originalContentUrl;
	String previewImageUrl;

	public Long getContentType() {
		return 2L;
	}

	public Long getToType() {
		return 1L;
	}

	public String getOriginalContentUrl() {
		return originalContentUrl;
	}

	public void setOriginalContentUrl(String originalContentUrl) {
		this.originalContentUrl = originalContentUrl;
	}

	public String getPreviewImageUrl() {
		return previewImageUrl;
	}

	public void setPreviewImageUrl(String previewImageUrl) {
		this.previewImageUrl = previewImageUrl;
	}

}
