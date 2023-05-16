package stepanyan.konstantin.lab_5_12;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//класс Товары
abstract class Products implements Discountable{
    //Переменные из условия:
    //Название товара, страна производитель, Цена, дата поступления
    protected String name, countryOfOrigin;
    protected double price;
    protected LocalDate arrivalDate;

    //Переменные не из условия
    protected String purpose;
    protected int discount; //размер скидки из интерфейса Discountable

    public Products(String name, String countryOfOrigin, double price, String arrivalDateString) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.arrivalDate = LocalDate.parse(arrivalDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.discount = 0;
    }
    
    public Products(String name, String countryOfOrigin, double price, String arrivalDateString, String purpose) {
        this(name, countryOfOrigin, price, arrivalDateString);
        this.purpose = purpose;
    }

    public String getName() { return name; }
    public void setName(String name) {this.name = name;}

    public String getCountryOfOrigin() { return countryOfOrigin; }
    public void setCountryOfOrigin(String countryOfOrigin) {this.countryOfOrigin = countryOfOrigin;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public LocalDate getArrivalDate() {return arrivalDate;}
    public void setArrivalDate(String arrivalDateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.arrivalDate = LocalDate.parse(arrivalDateString, formatter);}

    public String getPurpose() {return purpose;}
    public void setPurpose(String purpose) {this.purpose = purpose;}
    public abstract void printDetails(int productNumber); //абстрактный метод описания деталей

    /*  Переопределяем методы интерфейса Скидка для товаров:

      Если товар принадлежит к категориям: для кухни, для гостинной, для ванной,
          то будут вызываться переопределённые методы интерфейса Скидка в их классах.

      Если товар принадлежит к другой категории,
          то будут вызываться эти переопредлённые методы интерфейса Скидка ↓↓↓     */

    @Override public void askDiscount(){Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер скидки (в процентах) для товара: "+getName() +", Категория: "+getPurpose());
        System.out.println("Размер скидки не более 30%: ");
        int discount = scanner.nextInt();
        setDiscount(discount);
        System.out.println("_________");};

    @Override public int getDiscount(){return discount;}
    @Override public void setDiscount(int newDiscount) {this.discount = newDiscount; }
    @Override public void removeDiscount() {this.discount = 0;}
    @Override public double getDiscountedPrice(int discount) { return price - (price/100 * discount);  }
}
