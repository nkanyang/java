# A project use RabbitMQ to send and recieve messages

# RabbitMQ  在docker启动命令
`docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:management`

访问管理界面的地址就是 http://[宿主机IP]:15672，可以使用默认的账户登录，用户名和密码都guest

# RabbitMQ queue  配置

- exchange name:first
- queue name: demo
- routingkey: ""
- binding type: direct
