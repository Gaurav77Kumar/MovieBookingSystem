package src.payment;

class CardPayment extends PaymentMethod{
    boolean pay(double amount){
        System.out.println("Paid " + amount + " via card");
        return true;
    }
}







