package Spliter2;

import org.apache.camel.spring.Main;

public class MyApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Main m = new Main();

		m.setApplicationContextUri("META-INF/spring/camel-context.xml");
		
		m.start();
		Thread.sleep(100000);
		m.stop();
}
	

	

}
