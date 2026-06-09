public class Main {
    public static void main(String[] args) throws Exception {

        PaymentMethod payment = new OVO();

        EmailNotifier notifier = new EmailSystem();

        OrderService orderService =
                new OrderService(payment, notifier);

        orderService.createOrder(500000);
    }
}
