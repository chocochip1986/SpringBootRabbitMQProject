THIS IS AN EXAMPLE OF USING SPRING BOOT WITH RABBITMQ INTEGRATION

PREREQUISTE
====================
1. You need to download and install rabbitmq-server
```
brew install rabbitmq-server
```
2. Oracle db


Rabbitmq-server
====================
The broker resides in this rabbitmq server
The queues reside in this rabbitmq server
The publishers and consumers also reside in the rabbitmq server
The exchanges reside in the rabbitmq server

Rabbitmq command line tool
====================


Rabbitmq exchanges
====================
These exchanges are the smart brokers where messages are published. The broker will decide which queue the messages will go to depending on the binding
that is tied to the queue.
There are 3 kinds of exchanges (Direct, Topic and Fanout)
Direct Exchange - The simplest of brokers. It'll simply push the messages to the appropriate queue depending on the binding. Note that there can be more than 1 queue tied to a Direct Exchange
Topic Exchange - Topic exchanges route messages to queues based on wildcard matches between the routing key and the routing pattern, which is specified by the queue binding. Messages are routed to one or many queues based on a matching between a message routing key and this pattern.
Fanout Exchange - A fanout exchange copies and routes a received message to all queues that are bound to it regardless of routing keys or pattern matching as with direct and topic exchanges. The keys provided will simply be ignored.

Rabbitmq binding
====================
Bindings act as a method to specify routing information for the Exchange to act on in order to route the messages to the correct queue

Rabbitmq Publisher
====================
Publishers are simply agents which can push messages to the Exchanges

Rabbitmq Consumer
====================
Consumers are agents which consume messages. You have to tie the consumer to a queue. A consumer can be bounded to multiple queues.

Rabbitmq queues
====================
The credits that a queue process is given by the message store.
By default, a queue process is given 4000 message store credits, and then 800 for every 800 messages that it processes.

Messages which need to be paged out due to memory pressure will also use this credit.


There are 2 kinds of queues (Default and Lazy)
Default queues keep messages in memory for longer periods of times
Lazy queues will write out their messages to disk as soon as possible


Rabbitmq Batch Messages
====================
You can batch messages together before sending the messages to the exchange.
These messages will be unbatched before it hits the listener, which can be further batched if needed.
