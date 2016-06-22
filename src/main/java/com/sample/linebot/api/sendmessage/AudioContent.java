package com.sample.linebot.api.sendmessage;

public class AudioContent implements Content {

	public String originalContentUrl;
	public ContentMetadata contentMetadata;

	public long getContentType() {
		return 4L;
	}

	public long getToType() {
		return 1L;
	}

	public String getOriginalContentUrl() {
		return originalContentUrl;
	}

	public void setOriginalContentUrl(String originalContentUrl) {
		this.originalContentUrl = originalContentUrl;
	}

	public ContentMetadata getContentMetadata() {
		return contentMetadata;
	}

	public void setContentMetadata(ContentMetadata contentMetadata) {
		this.contentMetadata = contentMetadata;
	}

	public class ContentMetadata {
		public String AUDLEN;

		public String getAUDLEN() {
			return AUDLEN;
		}

		public void setAUDLEN(String aUDLEN) {
			AUDLEN = aUDLEN;
		}

	}
}
