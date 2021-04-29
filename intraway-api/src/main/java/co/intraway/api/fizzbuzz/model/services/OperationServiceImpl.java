package co.intraway.api.fizzbuzz.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.intraway.api.fizzbuzz.model.dtos.OperationDto;
import co.intraway.api.fizzbuzz.model.entities.Operation;
import co.intraway.api.fizzbuzz.model.repositories.IOperationRepository;

@Service
public class OperationServiceImpl implements IOperationService {
	
	@Autowired
	private IOperationRepository dao;

	@Override
	public Long save(OperationDto dto) {
		Operation op = new Operation();
		op.setPath(dto.getPath());
		op.setDescription(dto.getDescription());
		op.setResult(dto.getResult());
		op.setTimestamp(dto.getTimestamp());
		
		op = dao.save(op);
		return op!=null?op.getId():0;
	}

}
