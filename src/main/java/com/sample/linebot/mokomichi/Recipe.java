package com.sample.linebot.mokomichi;

public class Recipe {

	private String url;
	private String name;

	public Recipe(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
