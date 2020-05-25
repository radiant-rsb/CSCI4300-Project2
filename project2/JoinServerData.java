package project2;

import java.io.Serializable;

public class JoinServerData implements Serializable {
	private String host;
	private int port;
	
	public JoinServerData(String host, int port) {
		this.port = port;
		this.host = host;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
}
