package co.intraway.api.fizzbuzz.model.services;

import co.intraway.api.fizzbuzz.model.dtos.OperationDto;
import co.intraway.api.fizzbuzz.model.entities.Operation;

public interface IOperationService {
	public Long save(OperationDto dto);
}
