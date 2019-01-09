# Apache Kafka 
![kafka logo](../resource/logo.png)

分布式**流式**平台

## INTRODUCTION 

### 分布式流式平台究竟意味什么？

#### 三个关键能力
1. 发布或订阅流记录
2. 高容错存储流记录
3. 流记录出现时进行处理

#### 大体上用于两大类的应用
1. 构建实时的流式数据管道，用于在系统或者应用之间获取数据。
2. 用于构建实时的流式应用，转换或者消费流数据。

#### 关键的 concepts
* kafka集群运行在1台或多台服务器上，可以横跨多个数据中心
* kafka集群按照Topic分类存储记录流
* 每条记录包含一个Key， 一个Value，和一个时间戳

#### 4个核心的API
1. Producer API： 允许一个应用发布流式记录到一个或多个Kafka  topic  
2. Consumer API： 允许一个应用订阅一个或者多个Kafka Topic，并处理流式记录。
3. Stream API： 允许一个应用作为一个流处理器，从一个或多个Topic消费输入流，并产生输出流到到一个或多个输出Topic，高效的将输入流转换成输出流。
3. Connector API： 允许构建一个应用来连接Kafka Topic和已存在的应用或者数据系统（Data System）

在Kafka中，客户端和服务端之间的通信使用TCP协议

### 

