package src.payment;

abstract  class PaymentMethod {
    abstract boolean pay(double amount);

    void printReceipt(double amount){
        System.out.println("Receipt: " + amount + " processed");
    }
}


