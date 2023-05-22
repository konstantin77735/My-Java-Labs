package stepanyan.konstantin.lab_7_14;
/*
 * Создайте интерфейс «Возможность получения скидки». Добавьте в
него методы для назначения (удаления) скидки на товар):
 */
interface Discountable {
    void askDiscount();
    int getDiscount();
    void setDiscount(int discount);
    void removeDiscount();
    double getDiscountedPrice(int discount);
}
