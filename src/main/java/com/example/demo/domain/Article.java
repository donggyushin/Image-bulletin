package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Article {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	@Column(length=500, nullable = false)
	String fileName;
	@Column(length=500, nullable = false)
	String fileOriName;
	@Column(length=500, nullable = false)
	String fileUrl;
	
	@Lob
	String content;
	
	
	
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article() {
		
	}
	
	public Article(String fileName, String fileOriName, String fileUrl, String content) {
		this.fileName = fileName;
		this.fileOriName = fileOriName;
		this.fileUrl = fileUrl;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileOriName() {
		return fileOriName;
	}

	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", fileName=" + fileName + ", fileOriName=" + fileOriName + ", fileUrl=" + fileUrl
				+ ", content=" + content + "]";
	}
	
	
	
	
	
}
