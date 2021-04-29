package co.intraway.api.fizzbuzz.util;

import java.text.DecimalFormat;
import java.time.Instant;

import co.intraway.api.fizzbuzz.model.dtos.OperationDto;

public class Utils {
	
	public static Long getTimeStamp() {
		return Instant.now().toEpochMilli();
	}
	
	public static void setResults(int num1, int num2, OperationDto dto) {
		StringBuilder result = new StringBuilder();
		boolean multiplos3 = false;
		boolean multiplos5 = false;
		String str = "";
		
		for(int i=num1; i<=num2; i++, result.append(",")) {
			str = "";
			if(i % 3 == 0) {				
				multiplos3 = true;
				str = str.concat("Fizz");
			}
			if(i % 5 == 0) {				
				multiplos5 = true;
				str = str.concat("Buzz");
			}
			
			if(str.isEmpty()) {
				str = String.valueOf(i);
			}
			result.append(str);
		}
		str = result.toString();
		str = str.substring(0,str.length()-1);
		dto.setResult(str);
		
		if(multiplos3 && multiplos5) {
			dto.setDescription("se encontraron múltiplos de 3 y de 5");
		} else {
			if(multiplos3)
				dto.setDescription("se encontraron múltiplos de 3");
			if(multiplos5)
				dto.setDescription("se encontraron múltiplos de 5");
		}
	}
	
	public static String getCode(Long num) {
		DecimalFormat formatter = new DecimalFormat("000");
		try {
			return formatter.format(num);
		} catch(Exception ex) {
			return num.toString();
		}
	}

}
