package demo.fitnessapp.service.concretes;

import demo.fitnessapp.entities.concretes.Customer;
import demo.fitnessapp.repository.abstracts.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setEmail(customerDetails.getEmail());
            customer.setPassword(customerDetails.getPassword());
            customer.setPhoneNumber(customerDetails.getPhoneNumber());
            customer.setSteps(customerDetails.getSteps());
            customer.setHeartRate(customerDetails.getHeartRate());
            return customerRepository.save(customer);
        }
        return null;
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
