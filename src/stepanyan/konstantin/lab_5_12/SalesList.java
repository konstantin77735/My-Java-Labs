package stepanyan.konstantin.lab_5_12;
import java.util.*;

/*
 * Реализовать класс для хранения списка товаров с методом добавления нового
товара и методом печати списка товаров:
 */
class SalesList extends OnlineStore{
    protected String storeName;
    private List<Sales> salesList;

    public SalesList(String name) {
        super(name);
        this.salesList = new ArrayList<>();}

    public SalesList(String name, List<Sales> salesList) {
        super(name);
        this.salesList = salesList;}

    public void addSales(Sales sale) { salesList.add(sale);}

    public void printSalesList() {
        for (int i = 0; i < salesList.size(); i++) {
            Products product = salesList.get(i);
            int c = i+1;
            product.printDetails(c);
        }
    }
    public int size(){
        return this.salesList.size();
    }

    
    public String getStoreName() {return storeName;}
    public void setStoreName(String newStoreName) {this.storeName = newStoreName;}

}
