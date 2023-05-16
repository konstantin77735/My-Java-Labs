package stepanyan.konstantin.lab_5_12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BathroomFurniture_product extends Products {
    private String material;

    public BathroomFurniture_product(String name, String countryOfOrigin, double price, String arrivalDateString, String material, String purpose) {
        super(name, countryOfOrigin, price, arrivalDateString);
        this.material = material;
        this.purpose = purpose;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public void printDetails(int productNumber) {
        System.out.println("Товар #" + productNumber + ";");
        System.out.println("Наименование: " + getName() + ";");
        System.out.println("Цена: " + getPrice() + "р;");
        System.out.println("Страна производства: " + getCountryOfOrigin() + ";");
        System.out.println("Дата поступления: " + getArrivalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ";");
        System.out.println("Материал: " + getMaterial() + ";");
        System.out.println("Категория: " + getPurpose() + ";");
        System.out.println("Скидка: " + getDiscount() + "%:");
        System.out.println("Стоимость со скидкой: " + getDiscountedPrice(getDiscount()) + "р;");
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
}
