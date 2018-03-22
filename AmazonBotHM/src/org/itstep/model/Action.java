package org.itstep.model;

public class Action {

	private String asin;
	private String login;
	private String add;
	private long time;
	
	
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	
	public Action(String asin, String login, String add, long time) {
		
		this.asin = asin;
		this.login = login;
		this.add = add;
		this.time = time;
	}
	
	
	public Action() {
		// TODO Auto-generated constructor stub
	}
	
	
}
