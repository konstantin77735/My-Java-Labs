package stepanyan.konstantin.lab_7_14;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        ProductList products_list_1 = new ProductList("Магазин №2");
        SalesList sales_list_1 = new SalesList("Магазин №2");

        Sales sale_1 = new Sales("ПК", "Китай", 1000.0, 8000.0,
                                 5, "Перевод по карте", 10000.0, "01.01.2023",
                                 "01.01.2024", 1, "Алексеев Святослав", "Техника",
                                 12, 13, 14);
        BathroomFurniture_sale bathroom_furniture_sale__store_1 = new BathroomFurniture_sale("Стул", "Китай",
                                                                                             1000.0, 1500.0, 10, "Перевод по карте", 900.0, "01.01.2023",
                                                                                             "02.05.2023", 1, "Петров Евгений", "Для ванных комнат",
                                                                                             12, 13, 14);

        KitchenFurniture_sale kitchen_furniture_sale__store_1 = new KitchenFurniture_sale("Стол", "Германия",
                                                                                          100.0, 200.0, 2, "Наличные", 98, "01.01.2021",
                                                                                          "02.05.2022", 1, "Иванов Сергей", "Для кухни",
                                                                                          12, 13, 14);
        /* ... */
        LivingRoomFurniture_sale living_room_furniture_sale__store_1 =
                new LivingRoomFurniture_sale("Шкаф", "Италия", 10, 15,3, "Оплата по карте", 7,
                "05.07.2020", "09.09.2020", 1, "Иванов Сергей", "Для гостинной", "Шкаф-купе",
                12, 13, 14);

        sales_list_1.addSales(sale_1);
        sales_list_1.addSales(bathroom_furniture_sale__store_1);
        sales_list_1.addSales(kitchen_furniture_sale__store_1);
        sales_list_1.addSales(living_room_furniture_sale__store_1);

        //Список продаж (проданных товаров) магазина №3 ↓
        SalesList sales_list_2 = new SalesList("Магазин №3");
        KitchenFurniture_sale kitchen_furniture_sale__store_2 = new KitchenFurniture_sale("Стул", "Германия",
                                                                                          200.0, 200.0, 2, "Наличные", 98, "01.01.2023",
                                                                                          "02.05.2023", 1, "Иванов Сергей", "Для кухни",
                                                                                          12, 13, 14);
        BathroomFurniture_sale bathroom_furniture_sale__store_2 = new BathroomFurniture_sale("Стул", "Китай", 150.0, 150.0,
                                                                                             10, "Перевод по карте", 10.0, "01.01.2022", "02.05.2022",
                                                                                             1, "Иванов Иван", "Для ванных комнат",
                                                                                             12, 13, 14);
        LivingRoomFurniture_sale living_room_furniture_sale__store_2 = new LivingRoomFurniture_sale("Шкаф", "Италия",
                500, 500, 3, "Оплата по карте", 500, "05.07.2021", "09.09.2021",
                1, "Иванов Алексей", "Для гостинной", "Шкаф-купе",
                12, 13, 14);

        sales_list_2.addSales(bathroom_furniture_sale__store_2);
        sales_list_2.addSales(kitchen_furniture_sale__store_2);
        sales_list_2.addSales(living_room_furniture_sale__store_2);

        //sales_list_2.printCustomersList("По названию");

        //Список Товаров (проданных товаров) магазина №3 ↓
        ProductList products_list_2 = new ProductList("Магазин №3");
        LivingRoomFurniture_product sofa = new LivingRoomFurniture_product("Мягкий диван", "Австралия", 350.0, 375.0,
                                                                           "01.01.2023", "Искуственная кожа", "Для гостиной",
                                                                           12, 13, 14);
        
        KitchenFurniture_product table = new KitchenFurniture_product("Стол обеденный", "Германия", 250.0, 310.0,
                                                                      "01.01.2022", "Дерево", "Для кухни",
                                                                      12, 13, 14, false);
        BathroomFurniture_product mirror = new BathroomFurniture_product("Зеркало", "Италия", 120.0, 195.0,
                                                                         "01.01.2021", "Стекло", "Для ванной комнаты",
                                                                         12, 13, 14, false);
        products_list_2.addProducts(sofa);
        products_list_2.addProducts(table);
        products_list_2.addProducts(mirror);


        /* ... */
        UtilizeList utilize_list_2 = new UtilizeList("Магазин №3");
        utilize_list_2.addProducts(table);
        utilize_list_2.addProducts(mirror);


        OnlineStore[] stores = new OnlineStore[3]; // Создаем массив из трёх магазинов
        // Заполняем массив объектами OnlineStore:
        stores[0] = new OnlineStore("Магазин №1", "Пётр Иванов", "2468910562", "www.store_number_1.com");
        stores[1] = new OnlineStore("Магазин №2", "Александр Петров", "1375911975", "www.store_number_2.com");
        stores[2] = new OnlineStore("Магазин №3", "Пётр Иванов", "1375911975", "www.store_number_3.com");

        // первый магазин - пустой, во 2-ом - товары, в 3-ем - продажи и товары
        stores[1].setProducts_list_of_store(products_list_1);

        stores[2].setProducts_list_of_store(products_list_2);
        stores[2].setSales_list_of_store(sales_list_2);
        stores[2].setUtilizableProducts_list_of_store(utilize_list_2);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        
        while (choice != -1) {
            System.out.println("______________________________");
            System.out.println("1. Показать магазины");
            System.out.println("2. Посмотреть товары в магазине");
            System.out.println("3. Посмотреть продажи (проданные товары) в магазине");
            System.out.println("4. Посмотреть список утилизируемых товаров в магазине");
            System.out.println("5. Посмотреть список покупателей в магазине");
            System.out.println("6. Посмотреть список стран-производителей");
            System.out.println("0. Выйти из меню");

            System.out.print("Введите ваш выбор: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            

            switch (choice) {
                case 1:
                    for(int c=0; c<stores.length; c++){
                        System.out.println(stores[c].name);
                    }
                    break;
                    case 2:
                    System.out.println("Введите название магазина:");
                    String store_with_products = scanner.nextLine();
                    boolean store_with_products_found = false;
                    for(int i = 0; i < stores.length; i++){
                        if(stores[i]!=null && store_with_products.equals(stores[i].name)){
                            stores[i].printProducts("По дате прибытия");
                            store_with_products_found = true;
                            break;
                        }
                    }
                    if(!store_with_products_found)
                        System.out.println("Такого магазина не существует.");
                    break;
                case 3:
                    System.out.println("Введите название магазина:");
                    String store_with_sales = scanner.nextLine();
                    boolean store_with_sales_found = false;
                    for(int i = 0; i < stores.length; i++){
                        if(stores[i]!=null && store_with_sales.equals(stores[i].name)){
                            stores[i].printSales("По дате прибытия");
                            store_with_sales_found = true;
                            break;
                        }
                    }
                    if(!store_with_sales_found)
                        System.out.println("Такого магазина не существует.");
                break;

                case 4:
                    System.out.println("Введите название магазина:");
                    String storeWithUtilizableProducts = scanner.nextLine();
                    boolean storeWithUtilizableProductsFound = false;
                    for (int i = 0; i < stores.length; i++) {
                        if (stores[i] != null && storeWithUtilizableProducts.equals(stores[i].name)) {
                            stores[i].printUtilizableProducts("По дате прибытия");
                            storeWithUtilizableProductsFound = true;
                            break;
                        }
                    }
                    if (!storeWithUtilizableProductsFound)
                        System.out.println("Такого магазина не существует.");
                    break;

               case 5:
                    System.out.println("Введите название магазина:");
                    String storeWithCustomers = scanner.nextLine();
                    boolean storeWithCustomersFound = false;
                    for (int i = 0; i < stores.length; i++) {
                        if (stores[i] != null && storeWithCustomers.equals(stores[i].name)) {
                            stores[i].printСustomers("По дате прибытия");
                            storeWithCustomersFound = true;
                            break;
                        }
                    }
                    if (!storeWithCustomersFound)
                        System.out.println("Такого магазина не существует.");
                    break;

                case 6:
                    System.out.println("Введите название магазина:");
                    String storeWithCountries = scanner.nextLine();
                    boolean storeWithCountriesFound = false;
                    for (int i = 0; i < stores.length; i++) {
                        if (stores[i] != null && storeWithCountries.equals(stores[i].name)) {
                            stores[i].printСountries("По дате прибытия");
                            storeWithCountriesFound = true;
                            break;
                        }
                    }
                    if (!storeWithCountriesFound)
                        System.out.println("Такого магазина не существует.");
                    break;    
                    
                case 0:
                    // выход из меню
                    choice = -1;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }
}
