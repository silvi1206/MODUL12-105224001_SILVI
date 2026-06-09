public class WhatsAppSystem implements WhatsAppNotifier {

    @Override
    public void sendWhatsApp(String message) {
        System.out.println("WHATSAPP : " + message);
    }
}