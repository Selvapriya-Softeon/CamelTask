package NettyTcpClient1;

import org.apache.camel.spring.Main;

public class MainApp {

    public static void main(String... args) throws Exception {
    	Main m = new Main();

		m.setApplicationContextUri("META-INF/spring/camel-context.xml");
		
		m.start();
//			Thread.sleep(100000);
//		m.stop();
    }

}

