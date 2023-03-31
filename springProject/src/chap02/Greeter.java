package chap02;

public class Greeter {
	private String format;
	
	
	public Greeter() {
	}
	
	public String greet(String guest) {
		return String.format(this.format, guest);
	}
	
	public void setFormate(String format) {
		this.format = format;
	}
	
}
