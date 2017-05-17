package service;

import model.Customer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {
    @Test
    public void getCustomer() throws Exception {
        CustomerService customerService = mock(CustomerService.class);
        Customer cust = new Customer(){{
           setIdCustomer(1);
           setLogin("Alex");
        }};
        when(customerService.getCustomer("Alex")).thenReturn(cust);

        Assert.assertEquals(1, customerService.getCustomer("Alex").getIdCustomer());
    }

}