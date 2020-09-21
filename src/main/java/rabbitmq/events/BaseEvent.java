package rabbitmq.events;

import lombok.experimental.SuperBuilder;

public abstract class BaseEvent {

    public BaseEvent() {

    }

    protected void process() {

    }
}
