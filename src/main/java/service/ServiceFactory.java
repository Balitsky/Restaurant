package service;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    private AccountProductService accountProductService = new AccountProductService();
    private AdminService adminService = new AdminService();
    private CategoryService categoryService = new CategoryService();
    private CustomerService customerService = new CustomerService();
    private OrderService orderService = new OrderService();
    private ProductService productService = new ProductService();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AccountProductService getAccountProductService() {
        return accountProductService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public ProductService getProductService() {
        return productService;
    }
}
