package com.it_item_server.model;

import java.util.ArrayList;

import org.json.JSONObject;

public class Sample {

	private String seq;
	private String title;
	private String text;
	private String writer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public static void main(String[] args) {
		JSONObject s = new JSONObject();

		ArrayList<JSONObject> n = new ArrayList<>();
		
		for(int i=0; i<3; i++) {
			JSONObject vv = new JSONObject();
			vv.put("key", "A"+1);
			
			n.add(vv);
		}

		s.put("top", n);
		
		System.out.println(s);
	}
}
