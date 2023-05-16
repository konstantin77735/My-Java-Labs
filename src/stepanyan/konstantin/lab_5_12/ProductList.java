package stepanyan.konstantin.lab_5_12;
import java.util.*;

/*
 * Реализовать класс для хранения списка товаров с методом добавления нового
товара и методом печати списка товаров:
 */
class ProductList extends OnlineStore{
    protected String storeName;
    private List<Products> productList;

    public ProductList(String name) {
        super(name);
        this.productList = new ArrayList<>();}

    public ProductList(String name, List<Products> productList) {
        super(name);
        this.productList = productList;}

    public void addProducts(Products product) { productList.add(product);}

    public void printProductsList() {
        for (int i = 0; i < productList.size(); i++) {
            Products product = productList.get(i);
            int c = i+1;
            product.printDetails(c);
        }
    }
    public int size(){
        return this.productList.size();
    }

    public String getStoreName() {return storeName;}
    public void setStoreName(String newStoreName) {this.storeName = newStoreName;}
}
