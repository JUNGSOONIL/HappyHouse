package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.UserResultDto;
import com.ssafy.happyhouse.service.UserService;

@CrossOrigin(
        origins = "http://localhost:5500",
        allowCredentials = "true",
        allowedHeaders ="*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
                   RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS }
        )
@RestController  // == > @Controller + @ResponseBody ==> 여기는 다 json 으로 넘어간다!! // 값자체를 리턴
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final int SUCCESS = 1;
	
	@PostMapping(value ="/users")
	public ResponseEntity<UserResultDto> register(@RequestBody UserDto userDto) { //restapi를 이용해서 http 상태코드를 성공 실패여부로 같이 넘겨준다.
		System.out.println(userDto);
		UserResultDto userResultDto = userService.userRegister(userDto);
		if(userResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value ="/users/{userId}")
	public ResponseEntity<UserDto> select(@PathVariable String userId) { //restapi를 이용해서 http 상태코드를 성공 실패여부로 같이 넘겨준다.
		UserDto userDto = userService.userSelect(userId);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	@PutMapping(value ="/users")
	public ResponseEntity<UserResultDto> update(@RequestBody UserDto userDto) { //restapi를 이용해서 http 상태코드를 성공 실패여부로 같이 넘겨준다.
		UserResultDto userResultDto = userService.userUpdate(userDto);
		if(userResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value ="/users/{userId}")
	public ResponseEntity<UserResultDto> delete(@PathVariable String userId) { //restapi를 이용해서 http 상태코드를 성공 실패여부로 같이 넘겨준다.
		System.out.println(userId);
		UserResultDto userResultDto = userService.userDelete(userId);
		System.out.println("삭제 결과"+userResultDto.getResult());
		System.out.println(userResultDto.getResult());
		if(userResultDto.getResult() == SUCCESS) {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
