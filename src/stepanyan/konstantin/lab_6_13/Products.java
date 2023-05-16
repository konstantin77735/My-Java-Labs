package stepanyan.konstantin.lab_6_13;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//класс Товар
abstract class Product implements Discountable{
    //Переменные из условия:
    //Название товара, страна производитель, Цена, дата поступления
    protected String name, countryOfOrigin;
    protected double purchasePrice; // оптовая цена
    protected double retailPrice; // закупочная  цена
    protected LocalDate arrivalDate;

    //Переменные не из условия
    protected String purpose;
    protected int discount; //размер скидки из интерфейса Discountable

    private double length; //обработать исключение
    private double height;
    private double width;

    public Product(String name, String countryOfOrigin, double purchasePrice, double retailPrice, String arrivalDateString,

    double length, double height, double width) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;

        /* 1. Конструктор должен выбрасывать исключение, если retailedPrice <0 || purchaisedPrice <)
        * Поэтому в конструкторе устанавливаем эти переменные через сеттер,
        * в котором прописано условие и обработка этого исключения.  */

        /* ... */

        this.arrivalDate = LocalDate.parse(arrivalDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.discount = 0;

        setLength(length); // Используем сеттер для проверки значения
        setHeight(height);
        setWidth(width);

        setRetailPrice(retailPrice);
        setPurchasePrice(purchasePrice);
    }

    public Product(String name, String countryOfOrigin, double purchasePrice, double retailPrice, String arrivalDateString){
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;

        setRetailPrice(retailPrice);
        setPurchasePrice(purchasePrice);

        this.arrivalDate = LocalDate.parse(arrivalDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.discount = 0;
    }


    public Product(String name, String countryOfOrigin, double purchasePrice, double retailPrice, String arrivalDateString, String purpose){
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.purpose=purpose;

        setRetailPrice(retailPrice);
        setPurchasePrice(purchasePrice);

        this.arrivalDate = LocalDate.parse(arrivalDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.discount = 0;

    }

    public double getLength() {return length;}
    public void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Отрицательное значение длины недопустимо");
        } this.length = length; }

    public double getHeight() {return height;}
    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Отрицательное значение высоты недопустимо");
        } this.height = height; }

    public double getWidth() { return width;}
    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Отрицательное значение ширины недопустимо");
        }  this.width = width; }

    public String getName() { return name; }
    public void setName(String name) {this.name = name;}

    public String getCountryOfOrigin() { return countryOfOrigin; }
    public void setCountryOfOrigin(String countryOfOrigin) {this.countryOfOrigin = countryOfOrigin;}

    public double getRetailPrice() {return retailPrice;}
    public void setRetailPrice(double retailPrice) {
        try {
            if (retailPrice < 0) {
                throw new IllegalArgumentException("Розничная цена не может быть отрицательной.");
            }
            if (retailPrice < purchasePrice) {
                throw new TooLowPriceException(purchasePrice, retailPrice);
            }
            this.retailPrice = retailPrice;
        } catch (TooLowPriceException e) {
            // Обработка исключения
            System.out.println("Ошибка: розничная цена ниже закупочной.");
            System.out.println("Закупочная цена: " + e.getPurchasePrice());
            System.out.println("Розничная цена: " + e.getRetailPrice());
            System.exit(1);
        }
    }


    public double gerPurchasePrice() {return purchasePrice;}
    public void setPurchasePrice(double purchasePrice) {
        if (purchasePrice < 0) { throw new IllegalArgumentException("Закупочная цена не может быть отрицательной.");}
        this.purchasePrice = purchasePrice;
    }



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
    @Override public double getDiscountedPrice(int discount) { return purchasePrice - (purchasePrice/100 * discount);  }
}
