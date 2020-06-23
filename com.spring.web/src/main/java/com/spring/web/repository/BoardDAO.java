package com.spring.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.web.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
	
	//게시글을 저장할 리스트: DB 대용
	private List<BoardVO> articles = new ArrayList<>();

	@Override
	public List<BoardVO> getArticles() {
		return articles;
	}

	@Override
	public void insertArticle(BoardVO article) {
		articles.add(article);
		System.out.println(article);
		System.out.println("게시글 저장 완료!");
	}

	@Override
	public void deleteArticle(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO getContent(int index) {
		return articles.get(index);
	}

	@Override
	public void modifyArticle(BoardVO article, int index) {
		// TODO Auto-generated method stub

	}

}
