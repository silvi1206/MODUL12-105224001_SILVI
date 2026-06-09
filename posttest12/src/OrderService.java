public class OrderService {

    private PaymentMethod paymentMethod;
    private EmailNotifier notifier;

    public OrderService(
            PaymentMethod paymentMethod,
            EmailNotifier notifier) {

        this.paymentMethod = paymentMethod;
        this.notifier = notifier;
    }

    public void createOrder(double amount) {

        System.out.println("=== PESANAN DIBUAT ===");

        paymentMethod.pay(amount);

        notifier.sendEmail(
                "Pembayaran berhasil. Resi telah dibuat.");

        System.out.println("=== PESANAN SELESAI ===");
    }
}