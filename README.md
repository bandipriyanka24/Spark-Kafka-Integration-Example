# Spark-Kafka-Integration-Example
It contains an example of Spark program that integrates with Kafka to read the data and perform analysis on it.

Cluster: Cloudera QuickStart VM

Technologies: Kafka, Spark

Programming Language: Scala

We don't have the Kafka installed in this VM.

We need to install it manually with the help of below commands

$ sudo yum clean all

$ sudo yum install kafka

$ sudo yum install kafka-server

#Start the Kafka server

$ sudo service kafka-server start

#Check if Kafka is installed properly or not

kafka-topics --list --zookeeper localhost:2181
