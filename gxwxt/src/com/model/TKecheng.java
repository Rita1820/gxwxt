package com.model;

/**
 * TKecheng generated by MyEclipse Persistence Tools
 */

public class TKecheng implements java.io.Serializable {

	private Integer id;
	private String mingcheng;
	private String del;

	/** default constructor */
	public TKecheng() {
	}

	/** full constructor */
	public TKecheng(String mingcheng, String del) {
		this.mingcheng = mingcheng;
		this.del = del;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMingcheng() {
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}