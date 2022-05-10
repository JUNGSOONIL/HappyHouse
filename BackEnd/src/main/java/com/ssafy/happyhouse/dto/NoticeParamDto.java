package com.ssafy.happyhouse.dto;

public class NoticeParamDto {
	private int limit;
	private int offset;
	private String searchWord;
	
	private int noticeId;
	private int userSeq;
	

	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	public NoticeParamDto() {}
	public NoticeParamDto(int limit, int offset, String searchWord, int noticeId, int userSeq) {
		super();
		this.limit = limit;
		this.offset = offset;
		this.searchWord = searchWord;
		this.noticeId = noticeId;
		this.userSeq = userSeq;
	}
	
	@Override
	public String toString() {
		return "NoticeParamDto [limit=" + limit + ", offset=" + offset + ", searchWord=" + searchWord + ", noticeId="
				+ noticeId + ", userSeq=" + userSeq + "]";
	}
}
