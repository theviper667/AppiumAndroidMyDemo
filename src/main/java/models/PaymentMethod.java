package models;

public class PaymentMethod {
    private final String nameOnCard;
    private final String cardNumber;
    private final String expirationDate;
    private final String cvv;

    public PaymentMethod(String nameOnCard, String cardNumber, String expirationDate, String cvv) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }
}
