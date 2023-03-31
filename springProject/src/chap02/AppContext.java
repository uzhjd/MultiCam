package chap02;

import org.springframework.context.annotation.*;

@Configuration
public class AppContext {
	
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormate("%s, 안녕하세요.");
		
		return g;
	}
}
