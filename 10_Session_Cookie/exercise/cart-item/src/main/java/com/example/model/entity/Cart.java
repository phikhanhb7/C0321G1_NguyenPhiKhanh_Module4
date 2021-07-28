package com.example.model.entity;



import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product,Integer> products) {
        this.products = products;
    }

    public Map<Product,Integer> getProducts() {
        return products;
    }
//check xem sản phẩm này đã có trong giỏ hay chưa
    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }
// lấy tất cả sản phẩm hiện có và số lượng trong giỏ
    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }
// thêm vào giỏ hàng
    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);// chuyển sang map mới
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);// thay đổi map
        }
    }
// các thay đổi trong cart , thêm bớt ,
    public void changeCount(Product product, String action){
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        Integer newQuantity;
        if(action.equals("+")){
            newQuantity = itemEntry.getValue() + 1;
        }else {
            newQuantity = itemEntry.getValue() - 1;
        }
        if(newQuantity == 0){// bớt đến 0 thì tự xóa
            removeProduct(product);
        }else {
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    // xóa sản phẩm trong giỏ
    public void removeProduct(Product product){
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        this.products.remove(itemEntry.getKey());
    }
// số lượng mổi sản phẩm
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }
// số lượng toàn bộ
    public Integer countItemQuantity(){
        return products.size();
    }
// tổng tiền
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}