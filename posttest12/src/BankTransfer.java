public class BankTransfer implements PaymentMethod, Refundable {

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran Transfer Bank: Rp" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund Transfer Bank: Rp" + amount);
    }
}