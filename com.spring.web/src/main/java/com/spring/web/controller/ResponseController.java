package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.model.UserVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	@GetMapping("/res-ex01")
	public void resEx01() {
		
	}
	
	/*
	//1. Model객체를 사용하여 화면에 데이터 전송하기.
	@GetMapping("/test")
	public void test(@RequestParam("age") int age, Model model) {
		model.addAttribute("nick", "멍멍이");
		model.addAttribute("age", age);
	}
	*/
	
	//2. @ModelAttribute를 사용한 화면에 데이터 전송 처리.
	//@RequestParam + model.addAttribute
	@GetMapping("/test")
	public void test(@ModelAttribute("age") int age, Model model) {
		model.addAttribute("nick", "멍멍이");
		//model.addAttribute("age", age);
	}
	
	//3. ModelAndView객체를 활용한 처리.
	//비동기통신을 사용하면 뷰리졸버가 객체를 전달하지 못할 때가 있는데 그럴 때 씀!
	@GetMapping("/test2")
	public ModelAndView test2() {
		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("userName", "김철수");
//		mv.setViewName("/response/test2");
		
		//생성자의 매개값으로 값을 바로 채워주기!
		return new ModelAndView("/response/test2", "userName", "홍길동");
	}
	
	////////////////////////////////////////////////////////////////////////
	
	//res-ex02.jsp파일을 열람하는 요청 메서드 작성
	@GetMapping("/res-ex02")
	public void resEx02() {
		
	}
	
//	@PostMapping("/join")
//	public String join(UserVO user, Model model) {
//		model.addAttribute("user", user);
//		return "response/test3";
//	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute("user") UserVO user) {
		return "response/test3";
	}
	
	////////////////////////////////////////////////////////////////////////
	
	//퀴즈
	
	//퀴즈 화면 처리
	@GetMapping("/res-quiz")
	public void loginForm() {}
	
	//커맨드 객체와 Model을 사용한 방식
	/*
	@PostMapping("/res-login")
	public String login(UserVO user, Model model) {
		if(user.getUserId().equals("kim123") && user.getUserPw().equals("kkk1234")) {
			model.addAttribute("userId", user.getUserId());
			return "response/res-quiz-success";
		} else {
			model.addAttribute("userId", user.getUserId());
			return "response/res-quiz-fail";
		}
	}
	*/
	
	//ModelAttribute를 사용한 방식
	@PostMapping("/res-login")
	public String login(@ModelAttribute("userId") String id, @RequestParam("userPw") String pw) {
		if(id.equals("kim123") && pw.equals("kkk1234")) {
			return "response/res-quiz-success";
		} else {
			return "response/res-quiz-fail";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
