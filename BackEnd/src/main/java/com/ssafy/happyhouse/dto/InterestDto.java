package com.ssafy.happyhouse.dto;

public class InterestDto {
	private int userSeq;
	private int houseNo;
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public InterestDto() {}
	public InterestDto(int userSeq, int houseNo) {
		super();
		this.userSeq = userSeq;
		this.houseNo = houseNo;
	}
	@Override
	public String toString() {
		return "InterestDto [userSeq=" + userSeq + ", houseNo=" + houseNo + "]";
	}
}
