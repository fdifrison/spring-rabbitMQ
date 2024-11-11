# Spring RabbitMQ

Official tutorial from https://www.rabbitmq.com/tutorials/tutorial-one-spring-amqp

## Configurations

* **Basic**: a simple hello world with a producer and a consumer, no exchange and no bindings
* **Work**: simulating a time-consuming task with two consumers subscribed; round-robin workload distribution and
  automatic
  retry on exception
* **Fanout**: pub/sub configuration; 2 anonymous queue are created and bound to a FanoutExchange that will blindly
  publish
  to all the subscribed consumers
* **Direct**: with a DirectExchange consumers are bound to queues with an additional **key** which serves as
  discriminant for the publisher to know to whom deliver the message
* **Topic**: enhance the routing capability of DirectExchange by giving the possibility to specify additional parameters
and wildcards
  *  (star) can substitute for exactly one word.
  *  (hash) can substitute for zero or more words.