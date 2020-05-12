package xyz.csga.entity;

public class OrderInfo {
    private String name;
    private String phone_number;
    private String email;
    private ShoppingAddress shopping_address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ShoppingAddress getShopping_address() {
        return shopping_address;
    }

    public void setShopping_address(ShoppingAddress shopping_address) {
        this.shopping_address = shopping_address;
    }
}
