package chap03.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import chap03.Exception.DuplicateMemberException;
import chap03.Exception.MemberNotFoundException;
import chap03.Exception.WrongIdPasswordException;
import chap03.Service.ChangePasswordService;
import chap03.Service.MemberRegisterService;
import chap03.assembler.Assembler;
import chap03.model.RegisterRequest;

public class MainForAssembler {

	private static Assembler assembler = new Assembler();
	
	private void printHelp() {
		System.out.println("\n잘못된 명령입니다. 아래 사용법을 확인하세요.");
		System.out.println("\n ### 명령어 사용법 ###");
		System.out.println("\n 명령어를 입력하세요: new 이메일 이름 암호 암호확인");
		System.out.println("\n 명령어를 입력하세요: change 이메일 현재암호 변경암호");
		System.out.println("\n 명령어를 입력하세요: exit \n \n");
	}
	
	private void processNewCommnad(String[] args) {
		if(args.length != 5) {
			this.printHelp();
			return;
		}

		MemberRegisterService regSvc = assembler.getRegSvc();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println(" 암호와 암호 확인이 일치하지 않습니다!");
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println(" 회원 정보를 등록했습니다.");
			
		} catch(DuplicateMemberException e) {
			System.out.println(" 이미 존재하는 이메일 입니다.");
		}
		
	}
	
	private void processChangeCommand(String[] args) {
		if(args.length != 4) {
			this.printHelp();
			return;
		}

		ChangePasswordService pwdSvc = assembler.getPwdSvc();
		
		try {
			pwdSvc.changedPassword(args[1], args[2], args[3]);
			System.out.println(" 회원 정보를 등록했습니다.");
			
		} catch(MemberNotFoundException e) {
			System.out.println(" 존재하지 않는 이메일입니다.");
		} catch(WrongIdPasswordException e) {
			System.out.println(" 잘못된 아이디 또는 패스워드입니다.");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		MainForAssembler main = new MainForAssembler();
		String command = "";


		System.out.println("\n ### 회원관리 프로그램 ###\n");
		
		while(true) {
			System.out.print("명령어를  입력하세요.");
			command = reader.readLine(); // 사용자 입력전체를 하나의 문자로 받아옴.
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("\n 프로그램을 종료합니다. \n");
				break;
			} else if(command.startsWith("new ")) {
				main.processNewCommnad(command.split(" "));
				continue;
			} else if(command.startsWith("change ")) {
				main.processChangeCommand(command.split(" "));
				continue;
			} 
			
			main.printHelp();
		}
	}

}
