package stepanyan.konstantin.lab_5_12;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*  Для
класса Продажи определить следующие дочерние классы:
 «Мебель для гостиных» (название, тип мебели, производитель);
 «Мебель для кухни» (название, длина, высота, ширина, материал);
 «Мебель для ванн» (название, габариты, назначение). ↓
 */
// Мебель для гостиных
class LivingRoomFurniture_sale extends Sales {
    private String furnitureType;

    private double purchaseAmount;
    protected String paymentType;
    private LocalDate saleDate;
    private int quantity;
    private String customerName; //покупатель

    public LivingRoomFurniture_sale(String name,
                               String countryOfOrigin,
                               double price,
                               int discount,
                               String paymentType,
                               double purchaseAmount,
                               String arrivalDateString,
                               String saleDateString,
                               int quantity,
                               String customerName,
                               String purpose,

                               String furnitureType) {
        super(name,
              countryOfOrigin,
              price,
              discount,
              paymentType,
              purchaseAmount,
              arrivalDateString,
              saleDateString,
              quantity,
              customerName,
              purpose
        );
        this.discount=discount;
        this.paymentType=paymentType;
        this.quantity = quantity; this.customerName=customerName;
        this.saleDate = LocalDate.parse(saleDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        this.furnitureType = furnitureType;
    }

    public String getFurnitureType() {return furnitureType;}
    public void setFurnitureType(String furnitureType) {this.furnitureType = furnitureType;}

    public String getPurpose() {return purpose;}
    public void setPurpose(String purpose) {this.purpose = purpose;}

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
    @Override //это значит что метод перезаписан
    public void printDetails(int productNumber) {
        // О товаре ↓
        System.out.println(productNumber+" продажа. Детали о товаре:");
        System.out.println("Название товара: "+getName()
                                   +"; Страна (производитель): "+getCountryOfOrigin()
                                   +"; Категория товара: "+getPurpose()+";");
        System.out.println("Тип мебели: "+getFurnitureType()+";");
        System.out.println("Дата поступления: " + getArrivalDate()+ "; Дата продажи: " + getSaleDate()
                                   +"; Количество проданных: " + getQuantity()+";");

        // Об оплате ↓
        System.out.println(productNumber+" продажа. Детали об оплате:");
        System.out.println("Цена: "+getPrice()+" р;"+" Скидка: "+getDiscount()
                                   + "%; В итоге оплачено: " + getDiscountedPrice(discount)+" р; Способ оплаты: "+getPaymentType()+";");
        System.out.println("Покупатель: " + getCustomerName()+";");
        System.out.println("_____");
    }
    // Реализация методов интерфейса Discountable
    @Override public void askDiscount() { // метод для получения размера скидки от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер скидки (в процентах) для товара: "+getName() +", Категория: "+getPurpose());
        System.out.println("Размер скидки не более 15%: ");
        int discount = scanner.nextInt();
        setDiscount(discount);
        System.out.println("_________");
    }
    @Override public int getDiscount(){return discount;}
    @Override public void setDiscount(int discount) {
        if (discount <= 15) { // ограничение на размер скидки до 15%
            this.discount = discount;
            System.out.println("Размер скидки установлен на " + discount + "%");
        } else {
            Random random = new Random();
            int randomDiscount = random.nextInt(16); // случайное число от 0 до 20
            System.out.println("Нельзя установить скидку больше 15%."+"\n"
                                       +"Будет установлена скидка, сгенерированная случайным образом, равная: "+randomDiscount+"%");
            this.discount = randomDiscount;
        }
    }
    @Override public void removeDiscount() {
        this.discount = 0;
        System.out.println("Скидка удалена");}
}
