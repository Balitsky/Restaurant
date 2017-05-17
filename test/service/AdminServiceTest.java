package service;

import model.Admin;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AdminServiceTest {
    @Test
    public void getAdmin() throws Exception {
        AdminService adminService = mock(AdminService.class);
        Admin admin = new Admin(){{
            setIdAdmin(1);
            setLogin("Alex");
            setPassword("123");
        }};
        when(adminService.getAdmin("Alex", "123")).thenReturn(admin);

        Assert.assertEquals(1, adminService.getAdmin("Alex", "123").getIdAdmin());

    }
}