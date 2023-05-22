package stepanyan.konstantin.lab_7_14;

import java.util.*;

/*
 * Реализовать класс для хранения списка товаров с методом добавления нового
товара и методом печати списка товаров:
 */
class ProductList extends OnlineStore {
    protected String storeName;
    private List<Product> productList;

    public ProductList(String name) {
        super(name);
        this.productList = new ArrayList<>();}

    public ProductList(String name, List<Product> productList) {
        super(name);
        this.productList = productList;}

    public void addProducts(Product product) { productList.add(product);}

    public Product[] getProductsArray(String order) {
        List<Product> sortedList = new ArrayList<>(productList);
        switch (order){
            case "По дате прибытия":
            // Создаем копию списка товаров для сортировки
            
            // Сортируем список товаров по дате поступления
            Collections.sort(sortedList, new Comparator<Product>() {
                @Override
                public int compare(Product product1, Product product2) {
                    return product1.getArrivalDate().compareTo(product2.getArrivalDate());
                }
            });

            // Преобразуем отсортированный список в массив товаров
            Product[] orderSortedArray = sortedList.toArray(new Product[0]);
            return orderSortedArray;

            case "По названию":
                Collections.sort(sortedList, new Comparator<Product>() {
                    @Override
                    public int compare(Product product1, Product product2) {
                        return product1.getName().compareTo(product2.getName());
                    }
                });
            Product[] titleSortedArray = sortedList.toArray(new Product[0]);
            return titleSortedArray;


            default:
            Product[] array = productList.toArray(new Product[0]);
            return array;
        }
    }

    public void loopThroughProducts(List<Product> products){
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            int c = i+1;
            product.printDetails(c);
        }
    }

    public void printProductsList(String order) {
            // Преобразование массива в список
            List<Product> productsList = Arrays.asList(getProductsArray(order));

            loopThroughProducts(productsList);
    }

    public int size(){
        return this.productList.size();
    }

    public String getStoreName() {return storeName;}
    public void setStoreName(String newStoreName) {this.storeName = newStoreName;}
}
