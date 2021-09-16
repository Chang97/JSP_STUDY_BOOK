package article.service;

import java.util.Map;

import article.model.Writer;

public class WriteRequest {
	private Writer wirter;
	private String title;
	private String content;
	public WriteRequest(Writer wirter, String title, String content) {
		this.wirter = wirter;
		this.title = title;
		this.content = content;
	}
	public Writer getWirter() {
		return wirter;
	}
	public void setWirter(Writer wirter) {
		this.wirter = wirter;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}
	
}
