package com.model;

/**
 * TChengji generated by MyEclipse Persistence Tools
 */

public class TChengji implements java.io.Serializable {

	private Integer id;
	private Integer userId;
	private int kechengId;
	private String xueqi;

	private int fenshu;

	private TUser user;
	private TKecheng kecheng;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getXueqi() {
		return xueqi;
	}

	public void setXueqi(String xueqi) {
		this.xueqi = xueqi;
	}

	public int getFenshu() {
		return fenshu;
	}

	public void setFenshu(int fenshu) {
		this.fenshu = fenshu;
	}

	public TKecheng getKecheng() {
		return kecheng;
	}

	public void setKecheng(TKecheng kecheng) {
		this.kecheng = kecheng;
	}

	public int getKechengId() {
		return kechengId;
	}

	public void setKechengId(int kechengId) {
		this.kechengId = kechengId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

}