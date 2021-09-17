package com.sbs.untact.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.DTO.Article;
import com.sbs.untact.DTO.ResultData;
import com.sbs.untact.service.ArticleService;
import com.sbs.untact.util.Util;

@Controller
public class UsrArticleController {
	@Autowired
	private ArticleService articleService;	
	
	@RequestMapping("/usr/article/detail")
	@ResponseBody
	public Article showDetail(int id) {
		Article article = articleService.getArticle(id);
		
		return article; 
	}
	
	@RequestMapping("/usr/article/list")
	@ResponseBody
	public List<Article> showList() {
		return articleService.getArticle();
	}
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public ResultData doAdd(String title, String body) {
		if (title != null ) {
			return new ResultData("F-1", "title을 입력해주세요.");
		}
		if (body != null ) {
			return new ResultData("F-1", "body를 입력해주세요.");
		}
		
		return articleService.add(title, body);
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(int id) {
		Article article = articleService.getArticle(id);
		
		if ( article == null ) {
			return new ResultData("F-1", "해당 게시물은 존재하지않습니다.");
		}
		
		return articleService.deleteArticle(id);
		
	}

	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData doModify(int id, String title, String body) {
Article article = articleService.getArticle(id);
		
		if ( article == null ) {
			return new ResultData("F-1", "해당 게시물은 존재하지않습니다.");
		}
		
		return articleService.modify(id, title, body);

	}
}
