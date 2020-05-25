package project2;

public class CreateServerData {
	private int port;
	private int timeout;
	
	public CreateServerData(int port, int timeout) {
		this.port = port;
		this.timeout = timeout;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public int getTimeout() {
		return this.timeout;
	}
}
