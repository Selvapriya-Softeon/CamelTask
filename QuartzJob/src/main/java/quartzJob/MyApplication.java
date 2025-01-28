	package quartzJob;

import org.apache.camel.spring.Main;

public class MyApplication {

	public static void main(String[] args) throws InterruptedException {
		
		
		Main m = new Main();

		m.setApplicationContextUri("META-INF/spring/camel-context.xml");
		
		m.start();
	//	Thread.sleep(600000);
	//	m.stop();
		
	}

}
