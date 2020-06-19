package com.spring.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.UserVO;

//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하는 아노테이션.
@Controller
@RequestMapping("/request")
public class RequestController {
	
	public RequestController() {
		System.out.println("RequestCon 작동!");
	}
	
	//RequestMapping은 어떤 URI로 이 메서드를 동작시킬 것인가에 대한 설정입니다.
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴!");
		return "test";
	}
	
	/*
	 만약 /request/req 요청이 들어왔을 때
	 views폴더 아래에 있는 request폴더 아래에
	 req-ex01.jsp파일을 열도록 메서드를 구성해 보세요.
	 */
	@RequestMapping("/req")
	public String req() {
		System.out.println("request/req 요청이 들어옴!");
		return "request/req-ex01";
	}
	
	
	//@RequestMapping(value="/request/basic01", method=RequestMethod.GET)
	@GetMapping("/basic01")
	public String basicGet() {
		System.out.println("/request/basic01 요청이 들어옴: GET");
		return "request/req-ex01";
	}
	
	//@RequestMapping(value="/request/basic01", method=RequestMethod.POST)
	@PostMapping("/basic01")
	public String basicPost() {
		System.out.println("/request/basic01 요청이 들어옴: POST");
		return "request/req-ex01";
	}
	
	
	//컨트롤러의 요청메서드를 void 리턴 타입으로 지정.
	@GetMapping("/req-ex02")
	public void reqEx02() {
		System.out.println("/request/req-ex02 요청!");
	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join : GET");
	}
	
	/*
	 1. 전통적인 jsp/servlet 방식의 파라미터 읽기 처리 방법.
	 - HttpServletRequest 객체를 이용.
	 
	@PostMapping("/join")
	public String register(HttpServletRequest request) {
		System.out.println("/request/join : POST");
		System.out.println("ID: " + request.getParameter("userId"));
		System.out.println("PW: " + request.getParameter("userPw"));
		System.out.println("NAME: " + request.getParameter("userName"));
		System.out.println("HOBBY: " + Arrays.toString(request.getParameterValues("hobby")));
		return "request/join";
	}
	*/
	
	/*
	 2. @RequestParam 아노테이션을 이용한 요청 파라미터 처리.
	 
	@PostMapping("/join")
	public void register(@RequestParam("userId") String id,
						 @RequestParam("userPw") String pw,
						 @RequestParam(value="hobby", required=false, defaultValue="no hobby person") List<String> hobbys) {
		
		System.out.println("ID: " + id);
		System.out.println("PW: " + pw);
		System.out.println("HOBBY: " + hobbys.toString());
	}
	*/
	
	/*
	 3. 커맨드 객체를 활용한 파라미터 처리.
	 객체의 멤버변수명과 파라미터변수명의 이름이 똑같아야 함!!!
	 */
	
	@PostMapping("/join")
	public void register(UserVO user) {
		System.out.println("ID: " + user.getUserId());
		System.out.println("PW: " + user.getUserPw());
		System.out.println("NAME: " + user.getUserName());
		System.out.println("HOBBY: " + user.getHobby());
		
	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	//req-quiz 정답
	@GetMapping("/quiz")
	public String quiz() {
		return "request/req-quiz";
	}
	
	@PostMapping("/quiz")
	public String quiz(UserVO user) {
		if(user.getUserId().equals("abc1234") && user.getUserPw().equals("aaa1111")) {
			return "request/login-success";
		} else {
			return "request/login-fail";
		}
	}
	
	
	
	
	
	
	
	
	

}
