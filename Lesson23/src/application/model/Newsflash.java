package application.model;

public class Newsflash {

	private String Header = "";
	private String Context = "";
	private int version = 1;
	
	public Newsflash(String head, String cont) {
		Header = head;
		Context = cont;
	}
	
	public void setHeader(String head) {
		Header = head;
	}
	
	public void setContext(String cont) {
		Context = cont;
	}
	
	public String getHeader() {
		return Header;
	}
	
	public String getContext() {
		return Context;
	}
	
	public String toString() {
		return Header+" "+version;
	}
	
}
