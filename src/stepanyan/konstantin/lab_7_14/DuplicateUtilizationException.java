package stepanyan.konstantin.lab_7_14;

public class DuplicateUtilizationException extends RuntimeException {
    private Product product;
    private String name;

    public DuplicateUtilizationException(Product product) {this.product = product;}

    public Product getProduct() { return product;}
    public String getName() { return name;}
}