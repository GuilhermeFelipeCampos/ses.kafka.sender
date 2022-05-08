package br.com.ses.kafka.sender.Util;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

public class SESCredentialsUtil {

	public static  AwsCredentialsProvider getCredentials() {
		AwsCredentialsProvider credentials = new AwsCredentialsProvider() {
			
			public AwsCredentials resolveCredentials() {
				return new AwsCredentials() {
					
					@Override
					public String secretAccessKey() {
						
						return System.getenv("AWS_SECRET_KEY");
					}
					
					@Override
					public String accessKeyId() {
						
						return System.getenv("AWS_ACCESS_KEY");
					}
				};
			}
		};
		return credentials;
	}
}
