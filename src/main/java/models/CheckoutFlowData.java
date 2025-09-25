package models;

public class CheckoutFlowData {
    private final Product product;
    private final ShippingAddress shippingAddress;
    private final PaymentMethod paymentMethod;

    public CheckoutFlowData(Product product, ShippingAddress shippingAddress, PaymentMethod paymentMethod) {
        this.product = product;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
    }

    public Product getProduct() {
        return product;
    }
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
