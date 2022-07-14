- 无法连接RabbitMQ的问题

问题现象：spring-boot(rabbitmq) Failed to check/redeclare auto-delete queue(s)
解决方案：vhost配置不对，hfn.properties参数配置成mq.vhost=vhost
