package stepanyan.konstantin.lab_7_14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
//Мебель для ванн:
class BathroomFurniture_sale extends Sales implements Recyclable {
    private double purchaseAmount;
    protected String paymentType;
    private LocalDate saleDate;
    private int quantity;
    private String customerName; //покупатель

    private double length; //обработать исключение
    private double height; 
    private double width;

    public BathroomFurniture_sale(String name,String countryOfOrigin,
                                  double purchasePrice, double retailPrice,
                                  int discount,
                                  String paymentType,
                                  double purchaseAmount,
                                  String arrivalDateString,
                                  String saleDateString,
                                  int quantity,
                                  String customerName,
                                  String purpose,
                                  double length, double height, double width,

                                  boolean utilized) {
        super(name,countryOfOrigin, purchasePrice, retailPrice,discount,
              paymentType,purchaseAmount,arrivalDateString,saleDateString,
              quantity,customerName,purpose);
        this.discount=discount;
        this.paymentType=paymentType;
        this.quantity = quantity; this.customerName=customerName;
        this.saleDate = LocalDate.parse(saleDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        setLength(length); // Используем сеттер для проверки значения
        setHeight(height);
        setWidth(width);

        setRetailPrice(retailPrice);
        setPurchasePrice(purchasePrice);

        utilize(utilized);
    }

    public BathroomFurniture_sale(String name,
                             String countryOfOrigin,
                             double purchasePrice, double retailPrice,
                             int discount,
                             String paymentType,
                             double purchaseAmount,
                             String arrivalDateString,
                             String saleDateString,
                             int quantity,
                             String customerName,
                             String purpose,

                             double length, double height, double width) {
        super(name,
              countryOfOrigin,
              purchasePrice, retailPrice,
              discount,
              paymentType,
              purchaseAmount,
              arrivalDateString,
              saleDateString,
              quantity,
              customerName,
              purpose);
        this.discount=discount;
        this.paymentType=paymentType;
        this.quantity = quantity; this.customerName=customerName;
        this.saleDate = LocalDate.parse(saleDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        setLength(length); // Используем сеттер для проверки значения
        setHeight(height);
        setWidth(width);

        setRetailPrice(retailPrice);
        setPurchasePrice(purchasePrice);
    }

    public BathroomFurniture_sale(String name,
                                  String countryOfOrigin,
                                  double purchasePrice, double retailPrice,
                                  int discount,
                                  String paymentType,
                                  double purchaseAmount,
                                  String arrivalDateString,
                                  String saleDateString,
                                  int quantity,
                                  String customerName,
                                  String purpose) {
        super(name,
              countryOfOrigin,
              purchasePrice, retailPrice,
              discount,
              paymentType,
              purchaseAmount,
              arrivalDateString,
              saleDateString,
              quantity,
              customerName,
              purpose);
        this.discount=discount;
        this.paymentType=paymentType;
        this.quantity = quantity; this.customerName=customerName;
        this.saleDate = LocalDate.parse(saleDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));


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

    // В каждом из дочерних классов реализуйте описанный ранее метод (абстрактный printDetails)
    @Override public void printDetails(int productNumber) {
        // О товаре ↓
        System.out.println(productNumber+" продажа. Детали о товаре:");
        System.out.println("Название товара: "+getName()
                                   +"; Страна (производитель): "+getCountryOfOrigin()
                                   +"; Категория товара: "+getPurpose()+";");
        System.out.println("Высота: "+getHeight()+"см; Ширина: "+getWidth()+
                                            "см; Длина: "+getLength() + "см;");
        System.out.println("Дата поступления: " + getArrivalDate()+ "; Дата продажи: " + getSaleDate()
                                   +"; Количество проданных: " + getQuantity()+";");

        // Об оплате ↓
        System.out.println(productNumber+" продажа. Детали об оплате:");
        System.out.println("Розничная цена: "+getRetailPrice()+" р;"+" Скидка: "+getDiscount()
                                   + "%; В итоге оплачено: " + getDiscountedPrice(discount)+" р; Способ оплаты: "+getPaymentType()+";");
        System.out.println("Покупатель: " + getCustomerName()+";");
        System.out.println("_____");
    }
    // реализация методов интерфейса Discountable
    @Override public void askDiscount() {  // метод для получения размера скидки от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер скидки (в процентах) для товара: "+getName() +", Категория: "+getPurpose());
        System.out.println("Размер скидки не более 15%: ");
        int discount = scanner.nextInt();
        setDiscount(discount);
        System.out.println("_________");
    }
    @Override public int getDiscount(){return discount;}
    // реализация методов интерфейса Discountable
    @Override public void setDiscount(int discount) {
        if (discount <= 15) { // ограничение на размер скидки до 15%
            this.discount = discount;
            System.out.println("Размер скидки установлен на " + discount + "%");
        } else {
            Random random = new Random();
            int randomDiscount = random.nextInt(16) ; // случайное число до 15 (включая 0, поэтому передаём аргументом 16)
            System.out.println("Нельзя установить скидку больше 15%."+"\n"
                                       +"Будет установлена скидка, сгенерированная случайным образом, равная: "+randomDiscount+"%");
            this.discount = randomDiscount;
        }
    }
    @Override public void removeDiscount() {
        this.discount = 0;
        System.out.println("Скидка удалена");
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

    /* ... */
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
