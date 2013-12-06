package chatroom.bean;

public class Chatter {
	private String ipAddress;
	private String nickName;

	public Chatter(String ipAddress, String nickName) {
		super();
		this.ipAddress = ipAddress;
		this.nickName = nickName;
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
