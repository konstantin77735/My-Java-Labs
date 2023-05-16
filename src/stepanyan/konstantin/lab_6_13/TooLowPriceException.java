package stepanyan.konstantin.lab_6_13;

public class TooLowPriceException extends Exception {
    private double purchasePrice;
    private double retailPrice;

    public TooLowPriceException(double purchasePrice, double retailPrice) {
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }
}
