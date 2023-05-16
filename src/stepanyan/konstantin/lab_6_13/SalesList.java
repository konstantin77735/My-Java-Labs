package stepanyan.konstantin.lab_6_13;
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

    public Sales[] getSalesArray(String order) {
        switch (order){
            case "По дате прибытия:":

                // Создаем копию списка товаров для сортировки
            List<Sales> sortedList = new ArrayList<>(salesList);

            // Сортируем список товаров по дате поступления
            Collections.sort(sortedList, new Comparator<Product>() {
                @Override
                public int compare(Product sales1, Product sales2) {
                    return sales1.getArrivalDate().compareTo(sales2.getArrivalDate());
                }
            });

            // Преобразуем отсортированный список в массив товаров
            Sales[] sortedArray = sortedList.toArray(new Sales[0]);

            return sortedArray;

            default:
            Sales[] array = salesList.toArray(new Sales[0]);
            return array;
        }
    }

    public void loopThroughProducts(List<Sales> sales){
        for (int i = 0; i < sales.size(); i++) {
            Sales sale = sales.get(i);
            int c = i+1;
            sale.printDetails(c);
        }
    }

    public void printProductsList(String order) {
            // Преобразование массива в список
            List<Sales> salesList = Arrays.asList(getSalesArray(order));

            loopThroughProducts(salesList);
    }

/////
    
    public int size(){
        return this.salesList.size();
    }

    
    public String getStoreName() {return storeName;}
    public void setStoreName(String newStoreName) {this.storeName = newStoreName;}

}
