package stepanyan.konstantin.lab_7_14;

import java.util.*;


class UtilizeList extends OnlineStore {
    protected String storeName;
    private List<Product> utilizeList;

    public UtilizeList(String name) {super(name);this.utilizeList = new ArrayList<>();}
    public UtilizeList(String name, List<Product> utilizeList) {super(name); this.utilizeList = utilizeList; }

    public void addProducts(Product product) {utilizeList.add(product);}

    public Product[] getProductsArray(String order) {
        List<Product> sortedList = new ArrayList<>(utilizeList);
        switch (order) {
            case "По дате прибытия":
                // Сортируем список товаров по дате поступления
                Collections.sort(sortedList, new Comparator<Product>() {
                    @Override
                    public int compare(Product product1, Product product2) {
                        return product1.getArrivalDate().compareTo(product2.getArrivalDate());   }  });

                // Преобразуем отсортированный список в массив товаров
                Product[] orderSortedArray = sortedList.toArray(new Product[0]);
                return orderSortedArray;

            case "По названию":
                Collections.sort(sortedList, new Comparator<Product>() {
                    @Override
                    public int compare(Product product1, Product product2) {
                        return product1.getName().compareTo(product2.getName());   }   });
                Product[] titleSortedArray = sortedList.toArray(new Product[0]);
                return titleSortedArray;

            default:
                Product[] array = utilizeList.toArray(new Product[0]);
                return array;
        }
    }

    public void loopThroughProducts(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            int c = i + 1;
            product.printDetails(c);
        }
    }

    public void printUtilizeList(String order) {
        // Преобразование массива в список
        List<Product> utilizeList = Arrays.asList(getProductsArray(order));

        loopThroughProducts(utilizeList);
    }

    public int size() {
        return this.utilizeList.size();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String newStoreName) {
        this.storeName = newStoreName;
    }
}
