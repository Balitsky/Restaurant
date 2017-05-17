package service;

import dao.factories.AccountProductDao;
import dao.mysqlFactories.MySQLFactory;
import model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountProductServiceTest {

    @Test
    public void getAllAccountProductsByOrder() throws Exception {
        Map<Product, Integer> map = new HashMap<>();
        map.put(new Product(){{setPrice(1);}}, 1);
        map.put(new Product(){{setPrice(2);}}, 1);
        map.put(new Product(){{setPrice(3);}}, 3);

        AccountProductService accountProductService = mock(AccountProductService.class);
        when(accountProductService.getAllAccountProductsByOrder(1)).thenReturn(map);

        Assert.assertEquals(3, accountProductService
        .getAllAccountProductsByOrder(1).size());
    }



}