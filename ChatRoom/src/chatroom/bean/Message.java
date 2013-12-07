package chatroom.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3297052638608942387L;
	
	private Chatter fromChatter;
	private String content;
	private Timestamp date;

	public Message(Chatter fromChatter, String content, Timestamp date) {
		super();
		this.fromChatter = fromChatter;
		this.content = content;
		this.date = date;
	}
	
	public String toString(){
		String chatterString = this.fromChatter.toString();
		return content + "\n" + 
				"  --" + chatterString + " send at " + date.toString() + "\n";
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
