package chap03.Service;

import chap03.Exception.*;
import chap03.model.*;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService() {
		
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changedPassword(String email, String oldPassword, String newPassword) {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotFoundException();
			
		}
		
		if(oldPassword.equals(newPassword)) {
			throw new WrongIdPasswordException();
		}
		
		member.changePassword(oldPassword, newPassword);
		memberDao.update(member);
	}
}
