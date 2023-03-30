package chap11;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitialMember implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent sce) {
		 ServletContext context = sce.getServletContext();
		 ArrayList<Member> members = new ArrayList<Member>();
		 
		 for(int i = 0; i < 8 ; i++) {
			 members.add(new Member("박찬호"+i,"park"+i+"@daum.net"));
		 }
		 
		 members.add(new Member("김연아",null));
		 members.add(new Member("김연경",null));
		
		 context.setAttribute("members", members);
		 context.setAttribute("member",new Member());
		 
		 System.out.println("InitialMember Start!");
		 //시작 시 자동 시행되는 매서드
		 }
	
		 public void contextDestroyed(ServletContextEvent sce) {
			 System.out.println("InitialMember Destroy!");
			 //종료 시 자동 시행되는 매서드
		 }
			
}