package stepanyan.konstantin.lab_5_12;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KitchenFurniture_product extends Products {
    private String material;
    private String purpose;

    public KitchenFurniture_product(String name, String countryOfOrigin, double price, String arrivalDateString, String material, String purpose) {
        super(name, countryOfOrigin, price, arrivalDateString);
        this.material = material;
        this.purpose = purpose;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public void printDetails(int productNumber) {
        System.out.println("Товар #" + productNumber+";");
        System.out.println("Наименование: " + getName()+";");
        System.out.println("Цена: " + getPrice()+"р;");
        System.out.println("Страна производства: " + getCountryOfOrigin()+";");
        System.out.println("Дата поступления: " + getArrivalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+";");
        System.out.println("Материал: " + getMaterial()+";");
        System.out.println("Категория: " + getPurpose()+";");
        System.out.println("Скидка: " + getDiscount() + "%:");
        System.out.println("Стоимость со скидкой: " + getDiscountedPrice(getDiscount())+"р;");
        System.out.println("_____");
    }

    @Override
    public void askDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер скидки (в процентах) для товара: " + getName() + ", Категория: " + getPurpose());
        System.out.println("Размер скидки не более 25%: ");
        int discount = scanner.nextInt();
        if (discount > 25) {
            System.out.println("Скидка не может быть больше 25%!");
            discount = 25;
        }
        setDiscount(discount);
        System.out.println("_________");
    }
    @Override public int getDiscount(){return discount;}
    // реализация методов интерфейса Discountable
    @Override public void setDiscount(int discount) {
        if (discount <= 25) { // ограничение на размер скидки до 25%
            this.discount = discount;
            System.out.println("Размер скидки установлен на " + discount + "%");
        } else {
            Random random = new Random();
            int randomDiscount = random.nextInt(26) ; // случайное число до 25 (включая 0, поэтому передаём аргументом 26)
            System.out.println("Нельзя установить скидку больше 25%."+"\n"
                                       +"Будет установлена скидка, сгенерированная случайным образом, равная: "+randomDiscount+"%");
            this.discount = randomDiscount;
        }
    }
    @Override public void removeDiscount() {
        this.discount = 0;
        System.out.println("Скидка удалена");
    }
}
