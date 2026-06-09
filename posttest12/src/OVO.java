public class OVO implements PaymentMethod, Refundable {

    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran OVO: Rp" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund OVO: Rp" + amount);
    }
}