package com.nitish.spring.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nitish.spring.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private Map<String, Customer> customerMap = new HashMap<>();

	public CustomerDAOImpl() {

		customerMap.put("1", new Customer("1", "Vibhav", "bhangale", "vib@gmail.com", "vibhavbhangale", "Webhy"));
		customerMap.put("2", new Customer("2", "Prabhu", "Sivamoorthy", "prabhu@gmail.com", "prabhu", "phymun"));
		customerMap.put("3", new Customer("3", "Sandeep", "sharma", "sandeep@gmail.com", "sandeep", "numphy"));
		customerMap.put("4",
				new Customer("4", "Siddharth", "Ramachandra", "siddharth@gmail.com", "siddharth", "pitfall"));
		customerMap.put("5", new Customer("5", "Harman", "Singh", "harman@gmail.com", "harman", "lolla"));
	}

	@Override
	public boolean addCustomer(Customer customer) {
		try {
			if (customer.getCustomerID() != null) {

				customerMap.put(customer.getCustomerID(), customer);
				for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
					System.out.println(entry.getValue());
				}
				return true;
			}
		} catch (Exception e) {
			new CustomerInputException("No ID");
		}
		return false;
	}

	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(String id) {
		return customerMap.remove(id) != null ? true : false;

	}

	@Override
	public boolean updateCustomer(Customer customer) {
		if (customerMap.containsKey(customer.getCustomerID())) {
			customerMap.replace(customer.getCustomerID(), customer);
			for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
				System.out.println(entry.getValue());
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Customer> loadCustomers() {
		List<Customer> customerList = new ArrayList<>(customerMap.values());
		return customerList;
	}

}
