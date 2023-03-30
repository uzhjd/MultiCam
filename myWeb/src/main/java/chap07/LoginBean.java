package chap07;

public class LoginBean {
	
	private String id;
	private String pw;
	
	public LoginBean() {
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPw() {
		return this.pw;
	}
	
	public Boolean checkLogin() {
		 final String ID = "longlee";
		 final String PW = "6789";
		 boolean result = false;

		 if(this.id != null && this.id.equals(ID) && this.pw != null && this.pw.equals(PW)) {
				 result = true;
		 }

		 return result;
	}
}
