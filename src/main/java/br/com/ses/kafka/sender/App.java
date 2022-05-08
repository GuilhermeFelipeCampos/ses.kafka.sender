package br.com.ses.kafka.sender;

//import java.util.Scanner;
//import java.util.UUID;
import java.util.concurrent.ExecutionException;

import br.com.ses.kafka.sender.Services.KafkaConsumerService;
//import br.com.ses.kafka.sender.Services.KafkaProducerService;
import br.com.ses.kafka.sender.Services.SESService;

public class App {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Entre com a mensagem que deseja enviar");
//		
//		String mensagem;
//		
//		mensagem = sc.nextLine();
//		
//		KafkaProducerService.sendMessage("Guilherme- enviando mensagem de teste" + UUID.randomUUID().toString(),mensagem);
//		sc.close();
		
		KafkaConsumerService.readMessage(System.getenv("KAFKA_GROUP_ID_READER"));
		
		

	}

}
