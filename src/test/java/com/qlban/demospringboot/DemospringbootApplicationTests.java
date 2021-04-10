package com.qlban.demospringboot;

import com.qlban.demospringboot.Service.Valid.CheckedService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemospringbootApplicationTests {

	@Test
	void contextLoads() {
		String passTest = "Quang1405$@123";
		String numberTest = "031234990";

		Assert.assertEquals( true, new CheckedService().validNumberPhone(numberTest));
		Assert.assertEquals(true, new CheckedService().validPassWord(passTest));
	}

	@Test
	void testBookListByauthor(){

	}
}
