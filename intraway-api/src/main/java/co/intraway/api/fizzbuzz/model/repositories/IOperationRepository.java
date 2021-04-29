package co.intraway.api.fizzbuzz.model.repositories;

import org.springframework.data.repository.CrudRepository;

import co.intraway.api.fizzbuzz.model.entities.Operation;

public interface IOperationRepository extends CrudRepository<Operation, Long> {

}
