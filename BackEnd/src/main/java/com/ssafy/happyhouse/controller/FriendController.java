package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.FriednDto;
import com.ssafy.happyhouse.service.FriendService;

@CrossOrigin(
        origins = "http://localhost:5500",
        allowCredentials = "true",
        allowedHeaders ="*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
                   RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS }
        )
@RestController // 값자체를 리턴
public class FriendController {

	@Autowired
	FriendService service;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;

	@PostMapping(value ="/friends")
	public ResponseEntity<Integer> insert(String userId, String friendId) {
		if(service.friendInsert(userId, friendId) == SUCCESS) {
			return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
		}else {
			return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value ="/friends/{userId}")
	public ResponseEntity<FriednDto> select(@PathVariable String userId) { 
		FriednDto friend = new FriednDto();
		friend.setFriends(service.friendList(userId));
		return new ResponseEntity<FriednDto>(friend, HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"/friends/{userId}/{friendId}"})
	public ResponseEntity<Integer> delete(@PathVariable String userId,@PathVariable String friendId) {
		System.out.println(userId+"-"+friendId);
		if(service.friendDelete(userId, friendId) == SUCCESS) { 
			return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
		}else {
			return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
