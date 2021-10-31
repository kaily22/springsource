package com.company.business.board;

//�����ڰ� �����ϴ� ��� Ŭ������ �ֻ��� Ŭ������ Object Ŭ�����κ��� ����� �޴´�.
//�׷��Ƿ� Object Ŭ������ ��� �޼ҵ�� BoardDO �ڽ� Ŭ�������� @Override �� �������Ͽ� ����� �� �ִ�.
import java.util.Date;

public class BoardDO {

	
	//�������
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	
	//������� �ϳ��� getter, setter �޼ҵ�
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override //������
	public String toString() {
		return "BoardDO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + "]";
	}
	
}
