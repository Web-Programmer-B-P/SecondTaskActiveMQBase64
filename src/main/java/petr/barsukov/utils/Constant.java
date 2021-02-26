package petr.barsukov.utils;

public class Constant {
    public final static String MAIN_QUEUE = "DISPATCHER_QUEUE";
    public final static String ANOTHER_QUEUE = "QUEUE1";
    public final static String TEST_MESSAGE = "Hello world!";
    public final static String EMPTY_MESSAGE = " ";
    public final static String CREATE_PRODUCER = "Билдим отправителя...";
    public final static String PRODUCER_SENT_MESSAGE_SUCCESS = "Отправитель успешно отправил сообщение!";
    public final static String CREATE_CONSUMER = "Билдим получателя...";
    public final static String CONSUMER_RECEIVED_MESSAGE = "Получатель вычитал сообщение успешно!";
    public final static String MESSAGE_VALIDATED_SUCCESS = "Сообщение прошло валидацию успешно!";
    public final static String MESSAGE_SENT_DESTINATIONS = "Сообщение отправлено в обе очереди успешно!";
    public final static String MESSAGE_IS_EMPTY = "Сообщение пустое!";
    public final static String MESSAGE_ENCODED = "Сообщение %s закодированно в %s";

    private Constant() {
    }
}
