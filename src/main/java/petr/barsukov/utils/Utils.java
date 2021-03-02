package petr.barsukov.utils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class Utils {
    private Utils() {
    }

    public static String getDecodeMessageOrException(Message msg) throws JMSException {
        String result = "";
        if (msg instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) msg;
            String decodeMessage = decodeBase64(textMessage.getText());
            if (!decodeMessage.isBlank()) {
                result = decodeMessage;
            } else {
                throw new JMSException(Constant.MESSAGE_IS_EMPTY);
            }
        }
        return result;
    }

    public static String encodeBase64(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    public static String decodeBase64(String message) {
        return new String(Base64.getDecoder().decode(message.getBytes()), StandardCharsets.UTF_8);
    }
}
