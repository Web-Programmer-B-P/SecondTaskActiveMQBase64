package petr.barsukov.consumer;

import petr.barsukov.parent.ParentProducerConsumer;

import javax.jms.JMSException;
import javax.jms.Message;

public class Consumer extends ParentProducerConsumer implements ConsumerReceiver {

    @Override
    public Message receiveMessage() throws JMSException {
        return consumer.receive();
    }
}
