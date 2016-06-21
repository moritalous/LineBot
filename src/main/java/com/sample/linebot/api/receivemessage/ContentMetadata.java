package com.sample.linebot.api.receivemessage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentMetadata {
	String STKPKGID;
	String STKID;
	String STKVER;
	String STKTXT;
	String mid;
	String displayName;

	public String getSTKPKGID() {
		return STKPKGID;
	}

	public void setSTKPKGID(String sTKPKGID) {
		STKPKGID = sTKPKGID;
	}

	public String getSTKID() {
		return STKID;
	}

	public void setSTKID(String sTKID) {
		STKID = sTKID;
	}

	public String getSTKVER() {
		return STKVER;
	}

	public void setSTKVER(String sTKVER) {
		STKVER = sTKVER;
	}

	public String getSTKTXT() {
		return STKTXT;
	}

	public void setSTKTXT(String sTKTXT) {
		STKTXT = sTKTXT;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}