package so20171918.foundation.bank.so20171918_bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import so20171918.foundation.bank.so20171918_bank.model.CustomerModel;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, Integer> {

}
