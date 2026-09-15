package src.payment;

public abstract class PaymentMethod {
    public abstract boolean pay(double amount);

    public void printReceipt(double amount){
        System.out.println("Receipt: " + amount + " processed");
    }
}


