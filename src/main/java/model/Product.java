package model;

public class Product {
    private int idProduct;
    private String name;
    private int price;
    private int amount;
    private int idCategory;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amount == 0) ? 0 : amount);
        result = prime * result
                + ((idCategory == 0) ? 0 : idCategory);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == 0) ? 0 : price);
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
        Product other = (Product) obj;
        if (amount == 0) {
            if (other.amount != 0)
                return false;
        } else if (amount != other.amount)
            return false;
        if (idCategory == 0) {
            if (other.idCategory != 0)
                return false;
        } else if (idCategory != other.idCategory)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price == 0) {
            if (other.price != 0)
                return false;
        } else if (price != other.price)
            return false;
        return true;
    }
}
