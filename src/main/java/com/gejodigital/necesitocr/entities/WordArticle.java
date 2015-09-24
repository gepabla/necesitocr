package com.gejodigital.necesitocr.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="word_articles")
@NamedQuery(name="WordArticle.findAll", query="SELECT w FROM WordArticle w")
public class WordArticle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="word_articles_id")
	private Integer wordArticlesId;	
	
	@Column(name="word_article")
	private String wordArticle;
	
	public Integer getWordArticlesId() {
		return wordArticlesId;
	}
	public void setWordArticlesId(Integer wordArticlesId) {
		this.wordArticlesId = wordArticlesId;
	}
		
	public String getWordArticle() {
		return wordArticle;
	}
	public void setWordArticle(String wordArticle) {
		this.wordArticle = wordArticle;
	}
	
	@Override
	public String toString() {
		return "WordArticle [wordArticlesId=" + wordArticlesId
				+ ", wordArticle=" + wordArticle + "]";
	}
	
}
