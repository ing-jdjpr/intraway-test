package co.intraway.api.fizzbuzz.model.validator;

import co.intraway.api.fizzbuzz.exceptions.BadRequestException;

public class RequestValidator {
	
	public static Integer[] validate(String p1, String p2) throws BadRequestException {
		Integer[] numbers = new Integer[2];
		try {
			Integer n1 = Integer.valueOf(p1);
			Integer n2 = Integer.valueOf(p2);
			
			numbers[0] = n1;
			numbers[1] = n2;
			
			if(n2 < n1)
				throw new BadRequestException("Los parámetros enviados son incorrectos");			
			
		} catch (Exception ex) {			
			throw new BadRequestException("Los parámetros enviados son incorrectos", ex.getCause());
		}
		return numbers;
	}

}
