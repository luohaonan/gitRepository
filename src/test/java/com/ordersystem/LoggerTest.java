package com.ordersystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
//日志锁定为当前类
@Slf4j
//@Data
public class LoggerTest {

	//private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

	@Test
	public void test1(){
		log.debug("debug");
		log.info("info");
		log.error("error");
		//logger.error("error");
	}
}
