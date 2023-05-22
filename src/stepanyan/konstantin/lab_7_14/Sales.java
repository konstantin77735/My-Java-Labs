package stepanyan.konstantin.lab_7_14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Sales extends Product {
    private String paymentType, customerName;
    private double purchaseAmount;
    private LocalDate saleDate;
    private int quantity; //покупатель

    private double length; //обработать исключение
    private double height; 
    private double width;

    public Sales(String name, String countryOfOrigin,
    double purchasePrice, double retailPrice, int discount, String paymentType, double purchaseAmount,
    String arrivalDateString, String saleDateString,
    int quantity, 
    String customerName, 
    String purpose,

    double length, double height, double width) {
        super(name, countryOfOrigin, purchasePrice, retailPrice, arrivalDateString, purpose);
        this.discount = discount;

        this.paymentType = paymentType;
        this.purchaseAmount = purchaseAmount;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.saleDate = LocalDate.parse(saleDateString, formatter);
        this.quantity = quantity;
        this.customerName = customerName;

        setLength(length); // Используем сеттер для проверки значения
        setHeight(height);
        setWidth(width);

        setRetailPrice(retailPrice);
        setPurchasePrice(purchasePrice);
    }

    public Sales(String name, String countryOfOrigin,
                 double purchasePrice, double retailPrice, int discount, String paymentType, double purchaseAmount,
                 String arrivalDateString, String saleDateString,
                 int quantity,
                 String customerName,
                 String purpose) {
        super(name, countryOfOrigin, purchasePrice, retailPrice, arrivalDateString, purpose);
        this.discount = discount;

        this.paymentType = paymentType;
        this.purchaseAmount = purchaseAmount;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.saleDate = LocalDate.parse(saleDateString, formatter);
        this.quantity = quantity;
        this.customerName = customerName;
    }

    public Sales(String name, String countryOfOrigin, double purchasePrice, double retailPrice, String arrivalDateString, String purpose,
             String paymentType, double purchaseAmount) {
    super(name, countryOfOrigin, purchasePrice, retailPrice, arrivalDateString, purpose);
    this.paymentType = paymentType;
    this.purchaseAmount = purchaseAmount;
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


    public String getPaymentType() {return paymentType;}
    public void setPaymentType(String paymentType) {this.paymentType = paymentType;}

    public double getPurchaseAmount() {return purchaseAmount;}
    public void setPurchaseAmount(double purchaseAmount) {this.purchaseAmount = purchaseAmount;}

    public LocalDate getSaleDate() {return saleDate;}
    public void setSaleDate(String saleDateString) {DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.saleDate = LocalDate.parse(saleDateString, formatter);}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}


    public String getCustomerName() {return customerName;}
    public void setCustomerName(String newCustomerName) {this.customerName = newCustomerName;}

    @Override public void printDetails(int productNumber) {
        // О товаре ↓
        System.out.println(productNumber+" продажа. Детали о товаре:");
        System.out.println("Название товара: "+getName()
        +"; Страна (производитель): "+getCountryOfOrigin()
        +"; Категория товара: "+getPurpose()+";");
        System.out.println("Дата поступления: " + getArrivalDate()+ "; Дата продажи: " + getSaleDate()
        +"; Количество проданных: " + getQuantity()+";");

        // Об оплате ↓
        System.out.println(productNumber+" продажа. Детали об оплате:");
        System.out.println("Цена: "+getRetailPrice()+" р;"+" Скидка: "+getDiscount()
        + "%; В итоге оплачено: " + getDiscountedPrice(discount)+" р; Способ оплаты: "+getPaymentType()+";");
        System.out.println("Покупатель: " + getCustomerName()+";");
        System.out.println("_____");
    }
}

