package com.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.model.BoardVO;
import com.spring.web.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	//글 작성 화면 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	
	//글 작성 처리 요청
	@PostMapping("/write")
	public String write(BoardVO article) {
		System.out.println("/board/write: POST");
		//작성된 글을 리스트에 등록 후 /board/list.jsp파일로 응답할 수 있도록
		//(글 목록 보여달라는 요청이 다시 들어올 수 있도록) 적절하게 처리해 보세요.
		service.insertArticle(article);
		return "redirect:/board/list";
	}
	
	//글 목록 화면 요청
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list: GET");
		//DB 대용 리스트에서 가지고 온 글 목록을 list.jsp파일로 전달해서
		//브라우저에 글 목록을 띄워주시면 되겠습니다.
		model.addAttribute("bList", service.getArticles());
	}
	
	//글 내용보기 요청
	@GetMapping("/content")
	public void content(@ModelAttribute("boardNo") int boardNo, Model model) {
		System.out.println("/board/content?boardNo=" + boardNo + ": GET");
		model.addAttribute("article", service.getContent(boardNo));
	}
	
	
	
	
	
	
	
	
	
	

}
