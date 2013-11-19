package com.skcc.springserver.webservicetest;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.skcc.springserver.vo.TestObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TestGetTestObject {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		// Get Name Case
		TestObject testObject = new TestObject();
		testObject.setAge("31");
		testObject.setEmpNo(6733);
		System.out.println(service.path("getObjectTest").path("getName").accept(MediaType.APPLICATION_JSON).post(TestObject.class, testObject));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/skcc_server/").build();
	}
}
