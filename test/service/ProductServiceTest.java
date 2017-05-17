package service;

import model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    @Test
    public void getProductsByCategory() throws Exception {
        ProductService productService = mock(ProductService.class);
        List<Product> list = new ArrayList<>();
        list.add(new Product());
        list.add(new Product());
        list.add(new Product());
        when(productService.getProductsByCategory(1)).thenReturn(list);

        Assert.assertEquals(3, productService.getProductsByCategory(1).size());
    }

}