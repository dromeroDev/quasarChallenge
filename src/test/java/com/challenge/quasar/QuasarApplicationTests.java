package com.challenge.quasar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.quasar.controllers.CommunicationController;

@SpringBootTest
class QuasarApplicationTests {
	@Autowired CommunicationController communicationController;

	@Test
	void contextLoads() {
		assertThat(communicationController).isNotNull();
	}

}
