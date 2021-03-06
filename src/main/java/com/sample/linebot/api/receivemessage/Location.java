package com.sample.linebot.api.receivemessage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
	String title;
	String address;
	Double latitude;
	Double longitude;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append(String.format("Title : %s", getTitle())).append("\r\n")
				.append(String.format("Address : %s", getAddress())).append("\r\n")
				.append(String.format("Latitude : %f", getLatitude())).append("\r\n")
				.append(String.format("Longitude : %f", getLongitude()));

		return builder.toString();
	}
}