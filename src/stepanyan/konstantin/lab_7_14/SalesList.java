package stepanyan.konstantin.lab_7_14;

import java.util.*;

/*
 * Реализовать класс для хранения списка товаров с методом добавления нового
товара и методом печати списка товаров:
 */
class SalesList extends OnlineStore {
    protected String storeName;
    private List<Sales> salesList;

    private List<Sales> customersList;

    private List<Sales> countriesList;

    public SalesList(String name) {
        super(name);
        this.salesList = new ArrayList<>();}

    public SalesList(String name, List<Sales> salesList) {
        super(name);
        this.salesList = salesList;}

    public void addSales(Sales sale) { salesList.add(sale);}

    public Sales[] getSalesArray(String order) {
        List<Sales> sortedList = new ArrayList<>(salesList);

        switch (order){
            case "По дате прибытия":
            // Сортируем список товаров по дате поступления
            Collections.sort(sortedList, new Comparator<Product>() {
                @Override
                public int compare(Product sales1, Product sales2) {
                    return sales1.getArrivalDate().compareTo(sales2.getArrivalDate());
                }
            });

            // Преобразуем отсортированный список в массив товаров
            Sales[] orderSortedArray = sortedList.toArray(new Sales[0]);
            return orderSortedArray;

        
            case "По названию":
                Collections.sort(sortedList, new Comparator<Product>() {
                    @Override
                    public int compare(Product sales1, Product sales2) {
                        return sales1.getName().compareTo(sales2.getName());
                    }
                });
            Sales[] titleSortedArray = sortedList.toArray(new Sales[0]);
            return titleSortedArray;

            default:
            Sales[] array = salesList.toArray(new Sales[0]);
            return array;

        }
    }



    public void loopThroughProducts(List<Sales> sales, String listType){
        double maxPrice = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;
        String buyerWithMaxPrice = null;
        String buyerWithMinPrice = null;

        for (int i = 0; i < sales.size(); i++) {
            Sales sale = sales.get(i);
            int c = i+1;

            if(listType == "Список покупателей"){ 
                double price = sale.getRetailPrice();

                if (price > maxPrice) {
                    maxPrice = price;
                    buyerWithMaxPrice = sale.getCustomerName();
                }

                if (price < minPrice) {
                    minPrice = price;
                    buyerWithMinPrice = sale.getCustomerName();
                }
                
                sale.printCustomers(); }
            if(listType == "Список стран-производителей"){ sale.printCountries(); }
            if(listType == "Список продаж"){sale.printDetails(c); }
        }

        if (buyerWithMaxPrice != null) {
            System.out.println("Покупатель с самой большой ценой покупки: "+buyerWithMaxPrice);
        }
    
        if (buyerWithMinPrice != null) {
            System.out.println("Покупатель с самой низкой ценой покупки: "+buyerWithMinPrice);
        }
    
    }

    public void printProductsList(String order) {
            // Преобразование массива в список
            List<Sales> salesList = Arrays.asList(getSalesArray(order));loopThroughProducts(salesList, "Список продаж");}

            
    public void printCustomersList(String order) {
            // создаём коллекцию "из покупателей", 
            // проходим по ней циклом (loopThroughProducts)
            // Выводим
            List<Sales> customersList = Arrays.asList(getSalesArray(order)); 

            loopThroughProducts(customersList, "Список покупателей");
        }     

     public void printCountriesList(String order) {
            List<Sales> countriesList = Arrays.asList(getSalesArray(order)); loopThroughProducts(countriesList, "Список стран-производителей");
        }
    


    public int size(){ return this.salesList.size();}
    public String getStoreName() {return storeName;}
    public void setStoreName(String newStoreName) {this.storeName = newStoreName;}}