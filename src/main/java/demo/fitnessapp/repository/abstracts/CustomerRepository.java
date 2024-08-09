package demo.fitnessapp.repository.abstracts;

import demo.fitnessapp.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);
}
