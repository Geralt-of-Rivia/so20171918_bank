package so20171918.foundation.bank.so20171918_bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import so20171918.foundation.bank.so20171918_bank.exception.MyException;
import so20171918.foundation.bank.so20171918_bank.model.CustomerModel;
import so20171918.foundation.bank.so20171918_bank.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;
	 
	@GetMapping("/")
	public String display()
	{
		return "Welcome to Micro Services";
	}
	@GetMapping("/customer")
	public List<CustomerModel> displayAllCus()
	{
		return service.allCustomer();
	}
	@GetMapping("/customer/{id}")
	public CustomerModel displayCus(@PathVariable int id) throws MyException
	{
		if(!service.checkCustomer(id))
		{
			throw new MyException("Customer Not Found");
		}
		return service.findCustomer(id);
	}
	@PostMapping("/customer")
	public CustomerModel addCus(@RequestBody CustomerModel customer)
	{
		service.addCustomer(customer);
		return customer;
	}
	@PutMapping("/customer")
	public CustomerModel updatecus(@RequestBody CustomerModel customer)
	{
		service.updateCustomer(customer);
		return customer;
	}
	@DeleteMapping("/customer/{id}")
	public String deleteCus(@PathVariable int id) throws MyException
	{
		if(!service.checkCustomer(id))
		{
			throw new MyException("Customer Not Found");
		}
		service.deleteCustomer(id);
		return ""+id;
	}
	@DeleteMapping("/customer")
	public String deleteallcus()
	{
		service.deleteAllCustomer();
		return "All Deteted";
	}
	@PutMapping("/customer/{debit_id}/{credit_id}/{ammount}")
	public String fundTransfer(@PathVariable int debit_id,@PathVariable int credit_id, @PathVariable double ammount) throws MyException
	{
		if(!service.checkCustomer(debit_id))
		{
			throw new MyException("Debit Customer Not Found");
		}
		if(!service.checkCustomer(credit_id))
		{
			throw new MyException("Credit Customer Not Found");
		}
		CustomerModel customer1 = service.findCustomer(debit_id);
		CustomerModel customer2 = service.findCustomer(credit_id);
		if(customer1.getAccbalance() < ammount)
		{
			return "Insufficient Ammount in the Debit account";
		}
		CustomerModel new1 = new CustomerModel();
		CustomerModel new2 = new CustomerModel();
		new1.setCustomerid(customer1.getCustomerid());
		new1.setCustomername(customer1.getCustomername());
		new1.setCustomerage(customer1.getCustomerage());
		new1.setAcctype(customer1.getAcctype());
		new1.setCustomeradd(customer1.getCustomeradd());
		new1.setAccbalance(customer1.getAccbalance() - ammount);
		new2.setCustomerid(customer2.getCustomerid());
		new2.setCustomername(customer2.getCustomername());
		new2.setCustomerage(customer2.getCustomerage());
		new2.setAcctype(customer2.getAcctype());
		new2.setCustomeradd(customer2.getCustomeradd());
		new2.setAccbalance(customer2.getAccbalance() + ammount);
		service.updateCustomer(new1);
		service.updateCustomer(new2);
		return "Fund Transfered";
	}

}
