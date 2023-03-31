package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = context.getBean("greeter", Greeter.class);
		Greeter g2 = context.getBean("greeter", Greeter.class);
		

		System.out.println("g1 == g2 : 541" + (g1 == g2));
		/*
		String msg = g.greet("스프링");
		System.out.println(msg);
		*/
		
		context.close();
	}

}
