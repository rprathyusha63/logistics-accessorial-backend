package com.logisticsportal.demo.customers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.logisticsportal.demo.products.AddResponse;
import com.logisticsportal.demo.customers.Customer;

import com.logisticsportal.demo.repositories.CustomerRepository;

@Component
@Service
public class CustomerService {
	
		@Autowired
		CustomerRepository customerrep;
		
		public List<Customer> getAllCustomers() {
			return customerrep.findAll();
		}
		
		public Customer getCustomerbyID(int customerID) {
			return customerrep.findById(customerID).get();
		}
//		public Customer getCustomerbyName(String customerName) {
//			List<Customer> customers=customerrep.findAll();
//			Customer customer = null;
//			
//			for(Customer pro:customers) {
//				if(pro.getCustomerName().equalsIgnoreCase(customerName))
//					customer=pro;
//			}
//			return customer;
		
//		}
		public Customer addCustomer(Customer customer) {
			customer.setCustID(getMaxId());
			customerrep.save(customer);
			return customer;
		}
		public int getMaxId()
		{
			return customerrep.findAll().size()+1;
		}
		public Customer updateCustomer(Customer customer) {
			customerrep.save(customer);
			return customer;
		}
		public AddResponse deleteCustomer(int customerID)
		{
			customerrep.deleteById(customerID);
			AddResponse res=new AddResponse();
			res.setMsg("Customer Deleted");
			res.setId(customerID);
			return res;
		}
		
}


//static HashMap<Integer,Customer> customerMap;
//
//public CustomerService() {
//	customerMap=new HashMap<Integer,Customer>();
//	
//	Customer appleCustomer=new Customer(1,"Jennifer","Lawrence");
//	Customer nikeCustomer=new Customer(2,"Mark","Sheldon");
//	Customer adidasCustomer=new Customer(3,"Henry","Greggory");
//	
//	customerMap.put(1, appleCustomer);
//	customerMap.put(2, nikeCustomer);
//	customerMap.put(3, adidasCustomer);
//}
//
//public List getAllCustomers() {
//	List customers=new ArrayList(customerMap.values());
//	return customers;
//}
//public Customer getCustomerbyID(int id) {
//	Customer customer=customerMap.get(id);
//	return customer;
//
//}
//public Customer getCustomerbyName(String customerName)
//{
//	Customer customer = null;
//	for(int i:customerMap.keySet())
//	{
//		if(customerMap.get(i).getCustomerName().equals(customerName))
//			customer=customerMap.get(i);
//	}
//	return customer;
//	
//}
//public Customer addCustomer(Customer customer)
//{
//	customer.setCustID(getMaxId());
//	customerMap.put(customer.getCustID(), customer);
//	return customer;
//}
//public static int getMaxId()
//{
//	int max=0;
//	for(int id:customerMap.keySet())
//		if(max<=id)
//			max=id;
//	return max+1;
//
//}
//public Customer updateCustomer(Customer customer)
//{
//	if(customer.getCustID()>0)
//		customerMap.put(customer.getCustID(), customer);
//		return customer;
//}
//public AddResponse deleteCustomer(int id)
//{
//	customerMap.remove(id);
//	AddResponse res=new AddResponse();
//	res.setMsg("Customer Deleted");
//	res.setId(id);
//	return res;
//}
