package br.com.ses.kafka.sender.Services;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerService {
	
	public static void readMessage(String groupId) {
		
		
		KafkaConsumer <String,String> consumer = new KafkaConsumer <String,String>(properties(groupId));
		consumer.subscribe(Collections.singletonList(System.getenv("KAFKA_TOPIC")));
		
		
		while (true) {
			
			var records = consumer.poll(Duration.ofMillis(100));
			
			for(ConsumerRecord<String,String> registro : records) {
				
				System.out.println(registro.value());
				SESServiceClass.sendMessage(registro.value());
				//SESService.sendMessage(registro.value());
			}
		}
	}
	
	private static Properties properties(String groupId) {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, System.getenv("KAFKA_HOST"));
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId); 
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, UUID.randomUUID().toString()); 
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1"); 
        return properties;
    }

}
