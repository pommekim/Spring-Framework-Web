package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.model.BoardVO;
import com.spring.web.repository.IBoardDAO;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardDAO dao;

	@Override
	public List<BoardVO> getArticles() {
		return dao.getArticles();
	}

	@Override
	public void insertArticle(BoardVO article) {
		dao.insertArticle(article);
	}

	@Override
	public void deleteArticle(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO getContent(int index) {
		return dao.getContent(index-1);
	}

	@Override
	public void modifyArticle(BoardVO article, int index) {
		// TODO Auto-generated method stub

	}

}
