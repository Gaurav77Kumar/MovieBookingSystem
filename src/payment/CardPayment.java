package src.payment;

class CardPayment extends PaymentMethod{
    public boolean pay(double amount){
        System.out.println("Paid " + amount + " via card");
        return true;
    }
}







