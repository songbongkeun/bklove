package com.skcc.springserver.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
public class HelloWorldTestInterfase {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainHelloWorld() {
		return "Hello World";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXmlHelloWorld() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello World" + "</hello>";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHelloWorld() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html>";
	}
}