package com.skcc.springserver.webservicetest;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TestHelloWorld {

	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		// Get Hello World
		System.out.println(service.path("helloworld").accept(MediaType.TEXT_PLAIN).get(String.class));
		System.out.println(service.path("helloworld").accept(MediaType.TEXT_XML).get(String.class));
		System.out.println(service.path("helloworld").accept(MediaType.TEXT_HTML).get(String.class));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/skcc_server/").build();
	}
}