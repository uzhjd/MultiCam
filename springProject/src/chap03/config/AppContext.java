package chap03.config;

import org.springframework.context.annotation.*;
import chap03.Service.*;
import chap03.model.MemberDao;

@Configuration
public class AppContext {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
		
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(this.memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(this.memberDao());
		
		return pwdSvc;
	}
}
