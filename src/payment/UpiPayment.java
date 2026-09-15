package src.payment;

public class UpiPayment extends PaymentMethod{
    boolean pay(double amoutn){
        System.out.println("Paid " + amoutn + " via UPI");
        return true;
    }
}