package com.skcc.springserver.launcher;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class StartServer {

	public static void main(String[] args) {
		Server server = createJettyServer();
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected static Server createJettyServer() {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/skcc_server");
		server.setHandler(context);
		ServletHolder holder = new ServletHolder(ServletContainer.class);
		holder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
				"com.sun.jersey.api.core.PackagesResourceConfig");
		holder.setInitParameter("com.sun.jersey.config.property.packages", "com.skcc.springserver.webservice");

		holder.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
		context.addServlet(holder, "/*");
		return server;
	}
}
