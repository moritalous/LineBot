package com.sample.linebot.pokemon;

public class Pokemon {

	private int no;
	private String name;
	private String captorId;
	private String profilePhto;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaptorId() {
		return captorId;
	}

	public void setCaptorId(String captorId) {
		this.captorId = captorId;
	}

	public void setProfilePhto(String profilePhto) {
		this.profilePhto = profilePhto;
	}

	public String getSmallImageUrl() {
		return new StringBuilder().append("http://www.pokemon.jp/zukan/images/s/")
				.append(profilePhto.replace("/zukan/images/l/", "")).toString();
	}

	public String getMiddleImageUrl() {
		return new StringBuilder().append("http://www.pokemon.jp/zukan/images/m/")
				.append(profilePhto.replace("/zukan/images/l/", "")).toString();
	}

	public String getLargeImageUrl() {
		return new StringBuilder().append("http://www.pokemon.jp/zukan/images/l/")
				.append(profilePhto.replace("/zukan/images/l/", "")).toString();
	}

}
