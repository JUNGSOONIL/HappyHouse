package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.FriendDao;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	FriendDao dao;
	
	
	
	@Override
	public int friendInsert(String userId, String friendId) {
		return dao.friendInsert(userId,friendId);
	}

	@Override
	public int friendDelete(String userId, String friendId) {
		return dao.friendDelete(userId, friendId);
	}

	@Override
	public List<String> friendList(String userId) {
		return dao.friendList(userId);
	}

}
