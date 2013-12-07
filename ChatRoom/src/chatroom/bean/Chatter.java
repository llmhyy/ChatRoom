package chatroom.bean;

import java.io.Serializable;

public class Chatter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8254942212660582272L;
	
	private String ipAddress;
	private String nickName;

	public Chatter(String ipAddress, String nickName) {
		super();
		this.ipAddress = ipAddress;
		this.nickName = nickName;
	}
	
	public String toString(){
		return nickName + "@" + ipAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
