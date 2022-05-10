package com.ssafy.happyhouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//페이지 이동
@Controller //html, jsp 반환
public class HomeController {
	
	@GetMapping(value="/")
	private String index() {
		return "index.html";
	}
}
