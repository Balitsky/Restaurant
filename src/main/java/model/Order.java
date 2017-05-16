package model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private  int idOrder;
    private Customer customer;
    private int total;
    private boolean confirm;
    private Map<Product, Integer> accountProduct;

    public Order(){
        accountProduct = new HashMap<>();
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public Map<Product, Integer> getAccountProduct() {
        return accountProduct;
    }

    public void setAccountProduct(Map<Product, Integer> accountProduct) {
        this.accountProduct = accountProduct;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountProduct == null) ? 0 : accountProduct.hashCode());
        result = prime * result + (confirm ? 1231 : 1237);
        result = prime * result
                + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((total == 0) ? 0 : total);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (accountProduct == null) {
            if (other.accountProduct != null)
                return false;
        } else if (!accountProduct.equals(other.accountProduct))
            return false;
        if (confirm != other.confirm)
            return false;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        if (total == 0) {
            if (other.total != 0)
                return false;
        } else if (total != other.total)
            return false;
        return true;
    }
}
