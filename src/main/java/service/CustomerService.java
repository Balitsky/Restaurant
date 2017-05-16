package service;

import dao.mysqlFactories.MySQLFactory;
import model.Customer;

import java.util.List;

public class CustomerService {

    public List<Customer> getAllCustomers(){
        return MySQLFactory.getInstance().getCustomerDao()
                .getAllCustomers();
    }

    public Customer getCustomer(int idCustomer){
        return MySQLFactory.getInstance().getCustomerDao()
                .getCustomer(idCustomer);
    }

    public Customer getCustomer(String login){
        return MySQLFactory.getInstance().getCustomerDao()
                .getCustomer(login);
    }

    public Customer getCustomer(String login, String password){
        return MySQLFactory.getInstance().getCustomerDao()
                .getCustomer(login, password);
    }

    public void addCustomer(Customer customer){
        MySQLFactory.getInstance().getCustomerDao()
                .addCustomer(customer);
    }
}
