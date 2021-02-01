package com.challenge.quasar;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.quasar.exceptions.MessageException;
import com.challenge.quasar.services.ResolveCommunicationService;


@SpringBootTest
public class ResolveCommunicationServiceTest {
	@Autowired
    private ResolveCommunicationService resolveCommunicationService;
	
	@Test
	public void givenThreeIndeterminateMessagesGetExpectedMessage () throws MessageException{
        String message = String.join(" ", resolveCommunicationService.getMessage(getMockTest()));
        String expectedMsg = "hi satellites this is a test message";
        assertEquals(message,expectedMsg);
    }
	
	@Test
	public void givenThreeIndeterminateMessagesWithDiferentSizeGetException() {
		assertThrows(Exception.class,
	            ()->{
	            	String.join(" ", resolveCommunicationService.getMessage(getMockFail()));
	            });
	}
	
	private List<List<String>> getMockTest() {
		List<List<String>> messages = new ArrayList<List<String>>();
    	List<String> messageSat1 = Arrays.asList("hi", "", "this", "", "a", "test", "message");
    	List<String> messageSat2 = Arrays.asList("", "satellites", "this", "is", "a", "", "");
    	List<String> messageSat3 = Arrays.asList("hi", "", "", "is", "a", "", "message");
        messages.add(messageSat1);
        messages.add(messageSat2);
        messages.add(messageSat3);
        return messages;
	}
	
	private List<List<String>> getMockFail() {
		List<List<String>> messages = new ArrayList<List<String>>();
		List<String> messageSat1 = Arrays.asList("hi", "", "");
    	List<String> messageSat3 = Arrays.asList("hi", "", "this", "", "a", "test", "message");
    	List<String> messageSat2 = Arrays.asList("", "satellites", "this", "is");
    	messages.add(messageSat1);
        messages.add(messageSat2);
        messages.add(messageSat3);
        return messages;
	}
}
