package co.intraway.unittest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.intraway.api.fizzbuzz.IntrawayApiApplication;
import co.intraway.api.fizzbuzz.controllers.IntrawayApiController;
import co.intraway.api.fizzbuzz.model.dtos.ResponseErrorDto;
import co.intraway.api.fizzbuzz.model.dtos.ResponseOkDto;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IntrawayApiApplication.class)
@WebAppConfiguration
class UnitTestIntrawayApi {
	
	@Autowired
	private IntrawayApiController restController;
	
	@Test
	void contextLoads() {
	}

	@Test
	void testGetOperation() {
		ResponseEntity<?> response = restController.getOperation("1","15");
		if(response != null) {
				
		if(response.getStatusCode() == HttpStatus.OK) {
			ResponseOkDto result = (ResponseOkDto)response.getBody();
			assertThat(result.getList()).isEqualTo("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz");
		} else
			fail("Fail test for /intraway/api/v1/fizzbuzz/1/15");
		} else {
			fail("Fail test for /intraway/api/v1/fizzbuzz/1/15 -> NULL");
		}
	}
	
	@Test
	void testGetOperationBad() {
		ResponseEntity<?> response = restController.getOperation("15","1");
		if(response != null) {
				
		if(response.getStatusCode() == HttpStatus.BAD_REQUEST) {
			ResponseErrorDto result = (ResponseErrorDto)response.getBody();			
			assertThat(result.getMessage()).isEqualTo("Los parámetros enviados son incorrectos");
		} else
			fail("Fail test for /intraway/api/v1/fizzbuzz/15/1");
		} else {
			fail("Fail test for /intraway/api/v1/fizzbuzz/15/1 -> NULL");
		}
	}

}
