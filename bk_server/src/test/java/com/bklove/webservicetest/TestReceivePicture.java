package com.bklove.webservicetest;

import java.io.File;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class TestReceivePicture {

	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		
		final File fileToUpload = new File("C:/Desert.jpg"); 
		final FormDataMultiPart multiPart = new FormDataMultiPart();
		if (fileToUpload != null) {
			multiPart.bodyPart(new FileDataBodyPart("file", fileToUpload, MediaType.APPLICATION_OCTET_STREAM_TYPE));
		}
		final ClientResponse clientResp = service.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class,multiPart);
		System.out.println("Response: " + clientResp.getClientResponseStatus());
		
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/bk_server/").build();
	}

}
