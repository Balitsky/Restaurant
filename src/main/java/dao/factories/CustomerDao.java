package dao.factories;

import model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomers();

    Customer getCustomer(String login);

    Customer getCustomer(int idCustomer);

    boolean addCustomer(Customer customer);

    Customer getCustomer(String login, String password);
}
