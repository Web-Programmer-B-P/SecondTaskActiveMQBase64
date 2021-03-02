package petr.barsukov;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import petr.barsukov.consumer.Consumer;
import petr.barsukov.consumer.ConsumerBuilderImpl;
import petr.barsukov.parent.ActiveMQSession;
import petr.barsukov.producer.Producer;
import petr.barsukov.producer.ProducerBuilderImpl;
import petr.barsukov.utils.Constant;
import petr.barsukov.utils.Utils;

import javax.jms.*;

public class Starter {
    private static final Logger LOG = LogManager.getLogger(Starter.class.getName());

    public static void main(String[] args) {
        ActiveMQSession activeMQSession = new ActiveMQSession();
        try {
            String encodeMessage = Utils.encodeBase64(Constant.TEST_MESSAGE);
//            String encodeMessage = Utils.encodeBase64(Constant.EMPTY_MESSAGE);
//            LOG.info(String.format(Constant.MESSAGE_ENCODED, Constant.EMPTY_MESSAGE, encodeMessage));
            LOG.info(String.format(Constant.MESSAGE_ENCODED, Constant.TEST_MESSAGE, encodeMessage));
            LOG.info(Constant.CREATE_PRODUCER);

            Producer producer = new ProducerBuilderImpl()
                    .createSession(activeMQSession)
                    .createDestinationQueue(Constant.MAIN_QUEUE)
                    .createProducer()
                    .createNonPersistentMode()
                    .setMessage(encodeMessage)
//                    .setMessage(encodeMessage)
                    .build();
            producer.sendMessage();

            LOG.info(Constant.PRODUCER_SENT_MESSAGE_SUCCESS);
            LOG.info(Constant.CREATE_CONSUMER);
            Consumer consumer = new ConsumerBuilderImpl()
                    .createSession(activeMQSession)
                    .createDestinationQueue(Constant.MAIN_QUEUE)
                    .createConsumer()
                    .build();
            Message message = consumer.receiveMessage();
            LOG.info(Constant.CONSUMER_RECEIVED_MESSAGE);

            String validMessage = Utils.getDecodeMessageOrException(message);

            LOG.info(Constant.MESSAGE_VALIDATED_SUCCESS);
            producer = new ProducerBuilderImpl()
                    .createSession(activeMQSession)
                    .createDestinationQueue(Constant.ANOTHER_QUEUE)
                    .createProducer()
                    .createNonPersistentMode()
                    .setMessage(validMessage)
                    .build();
            producer.sendMessage();
            LOG.info(Constant.MESSAGE_SENT_DESTINATIONS);

            activeMQSession.closeSession();
            activeMQSession.closeConnection();
        } catch (JMSException jmsException) {
            LOG.trace(jmsException.getMessage());
        }
    }
}
