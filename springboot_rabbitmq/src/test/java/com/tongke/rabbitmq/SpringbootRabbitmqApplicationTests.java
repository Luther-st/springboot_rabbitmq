package com.tongke.rabbitmq;

import com.tongke.rabbitmq.mukewang.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

	@Test
	public void contextLoads() {
	}

//	@Autowired
//	private Sender sender;
//
//	@Test
//	public void testSend() throws Exception{
//		Order order = new Order();
//
//		order.setId("1231");
//		order.setName("2341");
//		order.setMessageId("3451");
//		sender.sendOrder(order);
//	}

}
