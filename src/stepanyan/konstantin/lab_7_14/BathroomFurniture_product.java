package stepanyan.konstantin.lab_7_14;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class BathroomFurniture_product extends Product implements Recyclable {
    private String material;

    private double length; //обработать исключение
    private double height; 
    private double width;


    public BathroomFurniture_product(String name, String countryOfOrigin, double purchasePrice, double retailPrice, 
    String arrivalDateString, String material, String purpose,
    double length, double height, double width, boolean utilized
    ) {
        super(name, countryOfOrigin, purchasePrice, retailPrice, arrivalDateString);
        this.material = material;
        this.purpose = purpose;

        setLength(length); // Используем сеттер для проверки значения
        setHeight(height);
        setWidth(width);

        setRetailPrice(retailPrice);
        setPurchasePrice(purchasePrice);
        utilize(utilized);
    }


    public BathroomFurniture_product(String name, String countryOfOrigin, double purchasePrice, double retailPrice, 
    String arrivalDateString, String material, String purpose,
    double length, double height, double width
    ) {
        super(name, countryOfOrigin, purchasePrice, retailPrice, arrivalDateString);
        this.material = material;
        this.purpose = purpose;

        setLength(length); // Используем сеттер для проверки значения
        setHeight(height);
        setWidth(width);

        setRetailPrice(retailPrice);
        setPurchasePrice(purchasePrice);
    }

    public BathroomFurniture_product(String name, String countryOfOrigin, double purchasePrice, double retailPrice,
                                     String arrivalDateString, String material, String purpose
    ) {
        super(name, countryOfOrigin, purchasePrice, retailPrice, arrivalDateString);
        this.material = material;
        this.purpose = purpose;

        setLength(length); // Используем сеттер для проверки значения
        setHeight(height);
        setWidth(width);
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    
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


    @Override
    public void printDetails(int productNumber) {
        System.out.println("Товар #" + productNumber + ";");
        System.out.println("Наименование: " + getName() + ";");
        System.out.println("Розничная цена: " + getRetailPrice() + "р;");
        System.out.println("Страна производства: " + getCountryOfOrigin() + ";");
        System.out.println("Дата поступления: " + getArrivalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ";");
        System.out.println("Материал: " + getMaterial() + ";");
        System.out.println("Категория: " + getPurpose() + ";");
        System.out.println("Скидка: " + getDiscount() + "%:");
        System.out.println("Стоимость со скидкой: " + getDiscountedPrice(getDiscount()) + "р;");
        System.out.println("*Товар утилизируемый");
        System.out.println("_____");
    }

    @Override
    public void askDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер скидки (в процентах) для товара: " + getName() + ", Категория: " + getPurpose());
        System.out.println("Размер скидки не более 20%: ");
        int discount = scanner.nextInt();
        if (discount > 20) {
            System.out.println("Скидка не может быть больше 20%!");
            discount = 20;
        }
        setDiscount(discount);
        System.out.println("_________");
    }



    //Переопределяем методы интерфейса Утилизируемый
    //метод, генерирующий утилизированную стоимость товара (от 70 до 90%)
    @Override public double getRecycledPrice() {
        return getRetailPrice() * (0.7 + Math.random() * 0.2); // генерация утилизированной стоимости товара от 70% до 90%
    }


    @Override public String getNewPriceInfo() {
        double recycledPrice = getRecycledPrice();
        Date expirationDate = new Date(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000L); // цена действительна 30 дней
        return String.format("Цена товара после утилизации: %.2f руб., действительна до %tc", recycledPrice, expirationDate);
    }

    @Override public void utilize(boolean utilized) {
        try{
            if (utilized) {
                throw new DuplicateUtilizationException(this);
            }
        } catch (DuplicateUtilizationException e) {
            System.out.println("Ошибка: товар: "+this.getName()+" уже утилизирован");
            utilized = true;
        }
   }
}
