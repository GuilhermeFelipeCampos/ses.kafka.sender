package br.com.ses.kafka.sender.Services;


import java.io.IOException;

import javax.mail.MessagingException;


import br.com.ses.kafka.sender.Util.SESCreateEmailUtil;
import br.com.ses.kafka.sender.Util.SESCredentialsUtil;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;


public class SESService {
	
	public static void sendMessage(String message) {
		
		Region region = Region.US_EAST_1;
		SesClient client = SesClient.builder()
				.credentialsProvider(SESCredentialsUtil.getCredentials())
				.region(region)
				.build();
		
		 try {
			 	SESCreateEmailUtil sender = new SESCreateEmailUtil();
			 	sender.setSender("guilherme,campos@ifood.com.br");
			 	sender.setRecipent("guilherme.campos@ifood.com.br");
			 	sender.setSubject("Envio de mensagem");
	            SESCreateEmailUtil.send(client, sender.getSender(), sender.getRecipent(), sender.getSubject(), message);
	            System.out.println("Email enviado.");
	            client.close();

	          

	        } catch (IOException | MessagingException e) {
	            e.getStackTrace();
	        }
		
	
		
	}
	
	

}
