package stepanyan.konstantin.lab_6_13;

import java.util.*;
/*
 Учет продаж через Интернет-магазин. Создать следующие
классы «Интернет-магазин» (Название магазина, Владелец, ИНН и т.д.), «Товары»
(Название товара, Страна производитель, Цена, Дата поступления) и «Продажи»
(Вид оплаты, Сумма покупки, Дата продажи, Количество единиц, ФИО
покупателя). Классы образуют следующую иерархию: Товары -> Продажи.
 */
public class OnlineStore {
    protected String name;
    protected String owner;
    protected String inn;
    protected String domen;
    protected ProductList products_list_of_store;
    protected SalesList sales_list_of_store;

    //конструктор создаёт магазин без изначальныйх товаров
    public OnlineStore(String name, String owner, String inn, String domen) {
        this.name = name;
        this.owner = owner;
        this.inn = inn;
        this.domen = domen;  }

    //конструктор создаёт магазин уже со списком товаров и без списка проданных товаров (не ведут учёт проданных)
    public OnlineStore(String name, String owner, String inn, String domen,
                       SalesList sales_list_of_store) {
        this.name = name;
        this.owner = owner;
        this.inn = inn;
        this.domen = domen;
        this.products_list_of_store = products_list_of_store;
    }

    //конструктор создаёт магазин уже со списком товаров и списком проданных товаров
    public OnlineStore(String name, String owner, String inn, String domen,
                       SalesList sales_list_of_store,
                       ProductList products_list_of_store) {
        this.name = name;
        this.owner = owner;
        this.inn = inn;
        this.domen = domen;
        this.products_list_of_store = products_list_of_store;
        this.sales_list_of_store = sales_list_of_store;
    }


    public OnlineStore(String name, String owner) {this.name = name; this.owner = owner; }

    public OnlineStore(String name) {
        this.name = name;
    }

    public String getName() { return name;}
    public void setName(String newName) {this.name = newName;;}

    public String getOwner() { return owner; }
    public void setOwner(String newOwner) {this.owner = newOwner;}

    public String getInn() {return inn;}
    public void setInn(String newInn) {this.inn = newInn;}

    public String getDomen() {return domen;}
    public void setDomen(String newDomen) {this.domen = newDomen;}


    public ProductList getProducts_list_of_store() {return this.products_list_of_store;}
    public void setProducts_list_of_store(ProductList newList) {this.products_list_of_store = newList;}

    public SalesList getSales_list_of_store() {return this.sales_list_of_store;}
    public void setSales_list_of_store(SalesList newList) {this.sales_list_of_store = newList;}

    public void printSales() {
        if(this.sales_list_of_store!=null && this.sales_list_of_store.size()!=0) {


            System.out.println("Список продаж (проданных товаров): "+"\n");
            sales_list_of_store.printProductsList("По дате прибытия:");

            
        } else {System.out.println("Список продаж (уже проданных товаров) пуст.");System.out.println("_____");}
    }

    public void printProducts() {
        if(this.products_list_of_store!=null && this.products_list_of_store.size()!=0) {


            System.out.println("Список товаров: "+"\n");
            products_list_of_store.printProductsList("По дате прибытия:");


        } else {System.out.println("Список товаров пуст."+"\n");}
    }

    public void printFullInfo() {
        System.out.println("Интернет-магазин: " + this.getName());
        System.out.println("Владелец: "  + this.getOwner());
        System.out.println("Инн: " + this.getInn());
        System.out.println("Домен: " + this.getDomen());
        System.out.println("_______________");

        if(this.sales_list_of_store!=null && this.sales_list_of_store.size()!=0) {
            //System.out.println(this.sales_list_of_store.getClass().getSimpleName());  //эти методы работают ТОЛЬКО если не null
            //System.out.println(this.sales_list_of_store.size()); //эти методы работают ТОЛЬКО если не null
            System.out.println("Список продаж (проданных товаров): "+"\n");
            sales_list_of_store.printProductsList("По дате прибытия:");
        } else {System.out.println("Список продаж (уже проданных товаров) пуст.");System.out.println("_____");}

        if(this.products_list_of_store!=null && this.products_list_of_store.size()!=0) {
            //System.out.println(this.products_list_of_store.getClass().getSimpleName()); //эти методы работают ТОЛЬКО если не null
            //System.out.println(this.products_list_of_store.size()); //эти методы работают ТОЛЬКО если не null
            System.out.println("Список товаров: "+"\n");
            products_list_of_store.printProductsList("По дате прибытия:");
        } else {System.out.println("Список товаров пуст."+"\n");}
    }
}