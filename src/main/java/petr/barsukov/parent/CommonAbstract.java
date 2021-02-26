package petr.barsukov.parent;

import lombok.Getter;
import lombok.Setter;

import javax.jms.*;

@Getter
@Setter
public abstract class CommonAbstract {
    protected Session session;
    protected Destination destination;
    protected MessageProducer producer;
    protected MessageConsumer consumer;
    protected TextMessage textMessage;
    protected Message message;
}
