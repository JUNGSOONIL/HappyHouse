package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FriendDao {
	public int friendInsert(@Param("userId") String userId, @Param("friendId")String friendId);
	public int friendDelete(@Param("userId") String userId, @Param("friendId") String friendId);
	public List<String> friendList(String userId);
}
