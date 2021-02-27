package petr.barsukov.utils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class Utils {
    private Utils() {
    }

    public static boolean validateMessage(String message) throws JMSException {
        return !message.isBlank();
    }

    public static String transformMessageToString(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        return textMessage.getText();
    }

    public static String encodeBase64(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    public static String decodeBase64(String message) {
        return new String(Base64.getDecoder().decode(message.getBytes()), StandardCharsets.UTF_8);
    }
}
