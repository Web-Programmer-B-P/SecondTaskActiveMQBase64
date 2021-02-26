package petr.barsukov.consumer;

import petr.barsukov.parent.CommonAbstract;

import javax.jms.JMSException;
import javax.jms.Message;

public class Consumer extends CommonAbstract implements ConsumerReceiver {

    @Override
    public Message receiveMessage() throws JMSException {
        return consumer.receive();
    }
}
