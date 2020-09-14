package rabbitmq.constants;

public class RabbitMQConstants {
    //ROUTING KEYS
    public static final String QUEUE_ONE_ROUTING_KEY = "route.queue_one";
    public static final String QUEUE_TWO_ROUTING_KEY = "route.queue_two";
    public static final String QUEUE_FIVE_ROUTING_KEY = "route.queue_five";
    public static final String QUEUE_SIX_ROUTING_KEY = "route.queue_six";
    public static final String QUEUE_SIX_GENRIC_ROUTING_KEY = "route.#";
    public static final String QUEUE_EIGHT_ROUTING_KEY = "route.queue_eight";

    //QUEUE NAMES
    public static final String QUEUE_ONE = "queue_one";
    public static final String QUEUE_TWO = "queue_two";
    public static final String QUEUE_THREE = "queue_three";
    public static final String QUEUE_FOUR = "queue_four";
    public static final String QUEUE_FIVE = "queue_five";
    public static final String QUEUE_SIX = "queue_six";
    public static final String QUEUE_SEVEN = "queue_seven";
    public static final String QUEUE_EIGHT = "queue_eight";

    //EXCHANGE NAMES
    public static final String DIRECT_EXCHANGE_ONE = "DIRECT_EXCHANGE_ONE";
    public static final String FANOUT_EXCHANGE_ONE = "FANOUT_EXCHANGE_ONE";
    public static final String TOPIC_EXCHANGE_ONE = "TOPIC_EXCHANGE_ONE";

    //Batch Rabbitmq
    public static final int BATCH_SIZE = 10;
    public static final int BUFFER_LIMIT = 1024; //Bytes
    public static final int BATCH_TIMEOUT = 10000; //Milliseconds
}
