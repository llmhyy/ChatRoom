package chatroom.bean;

import java.sql.Timestamp;

public class Message {
	private Chatter fromChatter;
	private String content;
	private Timestamp date;

	public Message(Chatter fromChatter, String content, Timestamp date) {
		super();
		this.fromChatter = fromChatter;
		this.content = content;
		this.date = date;
	}

	public Chatter getFromChatter() {
		return fromChatter;
	}

	public void setFromChatter(Chatter fromChatter) {
		this.fromChatter = fromChatter;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}
