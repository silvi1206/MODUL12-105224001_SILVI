public class EmailSystem implements EmailNotifier {

    @Override
    public void sendEmail(String message) {
        System.out.println("EMAIL : " + message);
    }
}