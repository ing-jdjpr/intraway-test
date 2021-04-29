package co.intraway.api.fizzbuzz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.intraway.api.fizzbuzz.exceptions.BadRequestException;
import co.intraway.api.fizzbuzz.model.dtos.*;
import co.intraway.api.fizzbuzz.model.services.IOperationService;
import co.intraway.api.fizzbuzz.model.validator.RequestValidator;
import co.intraway.api.fizzbuzz.util.Utils;

@RestController
@RequestMapping(value = {"/intraway/api/v1/fizzbuzz"})
@CrossOrigin(origins = {"*","/*","*/*"}, methods = {RequestMethod.GET, RequestMethod.OPTIONS})
public class IntrawayApiController {
	
	@Autowired
	IOperationService operationService;
	
	@GetMapping("/{param1}/{param2}")
	public ResponseEntity<?> getOperation(@PathVariable("param1") String param1, @PathVariable("param2") String param2) {
		String timestamp = String.valueOf(Utils.getTimeStamp());
		String path = "/intraway/api/v1/fizzbuzz/"+param1+"/"+param2;
		
		OperationDto opDto = new OperationDto();
		opDto.setPath(path);
		opDto.setTimestamp(timestamp);
		
		try {			
			
			Integer[] numbers = RequestValidator.validate(param1, param2);
			Utils.setResults(numbers[0], numbers[1], opDto);
			Long id = operationService.save(opDto);
			ResponseOkDto ok = new ResponseOkDto(timestamp, 
					Utils.getCode(id), 
					opDto.getDescription(), 
					opDto.getResult());
			return new ResponseEntity<>(ok, HttpStatus.OK);
			
		} catch(BadRequestException bre) {
			opDto.setResult(bre.getSource());
			opDto.setDescription(bre.getMessage());
			operationService.save(opDto);
			ResponseErrorDto err = new ResponseErrorDto(
					timestamp,
					HttpStatus.BAD_REQUEST.value(),
					bre.getSource(),
					bre.getMessage(),
					path
					);
			return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		}
		
	}
}
