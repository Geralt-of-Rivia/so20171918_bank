package so20171918.foundation.bank.so20171918_bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import so20171918.foundation.bank.so20171918_bank.model.CustomerModel;
import so20171918.foundation.bank.so20171918_bank.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	public void addCustomer(CustomerModel customer)
	{
		repo.save(customer);
	}
	public void updateCustomer(CustomerModel customer)
	{
		repo.save(customer);
	}
	public CustomerModel findCustomer(int id)
	{
		return repo.findById(id).get();
	}
	public List<CustomerModel> allCustomer()
	{
		List<CustomerModel> al = new ArrayList<CustomerModel>();
		repo.findAll().forEach(a->al.add(a));
		return al;
	}
	public void deleteCustomer(int id)
	{
		repo.deleteById(id);
	}
	public void deleteAllCustomer()
	{
		repo.deleteAll();
	}
	public boolean checkCustomer(int id)
	{
		return repo.existsById(id);
	}

}
