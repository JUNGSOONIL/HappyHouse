package com.ssafy.happyhouse.dto;

public class UserDto {
	private int userSeq;
	private String userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	
	public UserDto() { }
	public UserDto(int userSeq, String userId, String userName, String userPassword, String userEmail) {
		super();
		this.userSeq = userSeq;
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "UserDto [userSeq=" + userSeq + ", userId=" + userId + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userEmail=" + userEmail + "]";
	}
}
