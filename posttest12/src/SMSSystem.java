public class SMSSystem implements SMSNotifier {

    @Override
    public void sendSMS(String message) {
        System.out.println("SMS : " + message);
    }
}