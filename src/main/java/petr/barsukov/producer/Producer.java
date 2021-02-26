package petr.barsukov.producer;

import petr.barsukov.parent.CommonAbstract;

import javax.jms.JMSException;
import java.util.Objects;

public class Producer extends CommonAbstract implements ProducerSender {
    public static final String DEFAULT_QUEUE = "default";

    @Override
    public void sendMessage() throws JMSException {
        if (Objects.nonNull(textMessage)) {
            producer.send(textMessage);
        }
    }
}
