package stepanyan.konstantin.lab_5_12;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        ProductList products_list_1 = new ProductList("Магазин №2"); //для обоих нужно передавать название магазина
        //создаём список продаж (проданных товаров) для магазина №2 ↓
        SalesList sales_list_1 = new SalesList("Магазин №2"); //для обоих нужно передавать название магазина
        Sales sale_1 = new Sales("ПК","Китай", 10000.0,
                                 //скидка была (5%) ↓
                                 5,"Перевод по карте", 10000.0, "01.01.2023",
                                 "01.01.2024", 1, "Алексеев Святослав", "Техника");
        BathroomFurniture_sale bathroom_furniture_sale__store_1 = new BathroomFurniture_sale("Стул", "Китай",
                 1000.0, 10, "Перевод по карте", 900.0, "01.01.2023",
                "02.05.2023", 1, "Петров Евгений", "Для ванных комнат", 1.5);
        KitchenFurniture_sale kitchen_furniture_sale__store_1 = new KitchenFurniture_sale("Стол", "Германия",
                100.0, 2, "Наличные", 98, "01.01.2021",
                "02.05.2022", 1,"Иванов Сергей", "Для кухни",
                10, 20, 10, "Красное дерево");
        LivingRoomFurniture_sale living_room_furniture_sale__store_1 =
                new LivingRoomFurniture_sale("Шкаф", "Италия", 10, 3, "Оплата по карте", 7,
                "05.07.2020", "09.09.2020", 1, "Иванов Сергей", "Для гостинной", "Шкаф-купе");

        sales_list_1.addSales(sale_1);
        sales_list_1.addSales(bathroom_furniture_sale__store_1);
        sales_list_1.addSales(kitchen_furniture_sale__store_1);
        sales_list_1.addSales(living_room_furniture_sale__store_1);

        //Список продаж (проданных товаров) магазина №3 ↓
        SalesList sales_list_2 = new SalesList("Магазин №3");
        BathroomFurniture_sale bathroom_furniture_sale__store_2 = new BathroomFurniture_sale("Стул", "Китай", 10.0,
                10, "Перевод по карте", 10.0, "01.01.2023", "02.05.2023",
                1, "Иванов Иван", "Для ванных комнат", 1.5);
        KitchenFurniture_sale kitchen_furniture_sale__store_2 = new KitchenFurniture_sale(
                "Стол", "Германия", 100.0, 2, "Наличные",
                100.0, "01.01.2021", "02.05.2022", 1,
                "Иванов Сергей", "Для кухни", 10, 20, 10, "Красное дерево");
        LivingRoomFurniture_sale living_room_furniture_sale__store_2 = new LivingRoomFurniture_sale("Шкаф", "Италия",
                50, 3, "Оплата по карте", 50, "05.07.2020", "09.09.2020",
                1, "Иванов Алексей", "Для гостинной", "Шкаф-купе");

        sales_list_2.addSales(bathroom_furniture_sale__store_2);
        sales_list_2.addSales(kitchen_furniture_sale__store_2);
        sales_list_2.addSales(living_room_furniture_sale__store_2);

        //Список Товаров (проданных товаров) магазина №3 ↓
        ProductList products_list_2 = new ProductList("Магазин №3");
        LivingRoomFurniture_product sofa = new LivingRoomFurniture_product("Мягкий диван", "Австралия", 350.0,
                "01.05.2023", "Искуственная кожа", "Для гостиной");
        products_list_2.addProducts(sofa);
        KitchenFurniture_product table = new KitchenFurniture_product("Стол обеденный", "Германия", 250.0,
                "15.04.2023", "Дерево", "Для кухни");
        BathroomFurniture_product mirror = new BathroomFurniture_product("Зеркало", "Италия", 120.0,
                "01.05.2023","Стекло", "Для ванной комнаты");
        products_list_2.addProducts(sofa);
        products_list_2.addProducts(table);
        products_list_2.addProducts(mirror);

        OnlineStore[] stores = new OnlineStore[3]; // Создаем массив из двух магазинов
        // Заполняем массив объектами OnlineStore:
        stores[0] = new OnlineStore("Магазин №1", "Пётр Иванов", "2468910562", "www.store_number_1.com");
        stores[1] = new OnlineStore("Магазин №2", "Александр Петров", "1375911975", "www.store_number_2.com");
        stores[2] = new OnlineStore("Магазин №3", "Пётр Иванов", "1375911975", "www.store_number_3.com");

        stores[1].setProducts_list_of_store(products_list_1);
        stores[2].setProducts_list_of_store(products_list_2);
        stores[2].setSales_list_of_store(sales_list_2);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != -1) {
            System.out.println("______________________________");
            System.out.println("1. Показать магазины");
            System.out.println("2. Посмотреть товары в магазине");
            System.out.println("3. Посмотреть продажи (проданные товары) в магазине");
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
                    System.out.println("1. Выбрать магазин");
                    System.out.println("0. Вернуться назад");
                    int subchoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (subchoice) {
                        case 1:
                            System.out.println("Введите название магазина:");
                            String name = scanner.nextLine();
                            boolean storeFound = false;
                            for(int i = 0; i < stores.length; i++){
                                if(stores[i]!=null && name.equals(stores[i].name)){
                                    stores[i].printProducts();
                                    storeFound = true;
                                    break;
                                }
                            }
                            if(!storeFound)
                                System.out.println("Такого магазина не существует.");
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Введите название магазина:");
                    String name = scanner.nextLine();
                    boolean storeFound = false;
                    for(int i = 0; i < stores.length; i++){
                        if(stores[i]!=null && name.equals(stores[i].name)){
                            stores[i].printSales();
                            storeFound = true;
                            break;
                        }
                    }
                    if(!storeFound)
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
