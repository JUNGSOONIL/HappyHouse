package com.ssafy.happyhouse.dto;

import java.util.List;

public class BoardResultDto {
	private int result;
	private BoardDto dto;
	private List<BoardDto> list;
	private int count;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public BoardDto getDto() {
		return dto;
	}
	public void setDto(BoardDto dto) {
		this.dto = dto;
	}
	public List<BoardDto> getList() {
		return list;
	}
	public void setList(List<BoardDto> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public BoardResultDto() {}
	public BoardResultDto(int result, BoardDto dto, List<BoardDto> list, int count) {
		super();
		this.result = result;
		this.dto = dto;
		this.list = list;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "BoardResultDto [result=" + result + ", dto=" + dto + ", list=" + list + ", count=" + count + "]";
	}
}
