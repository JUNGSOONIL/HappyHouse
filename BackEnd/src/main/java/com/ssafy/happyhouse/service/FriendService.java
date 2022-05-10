package com.ssafy.happyhouse.service;

import java.util.List;

public interface FriendService {
	public int friendInsert(String userId, String friendId);
	public int friendDelete(String userId, String friendId);
	public List<String> friendList(String userId);
}
