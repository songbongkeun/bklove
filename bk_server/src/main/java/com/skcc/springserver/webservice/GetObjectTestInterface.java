package com.skcc.springserver.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.skcc.springserver.vo.TestObject;

@Path("/getObjectTest")
public class GetObjectTestInterface {
	@POST
	@Path("/getName")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public TestObject getName(TestObject param) {
		TestObject testObject = new TestObject();
		testObject.setAge(param.getAge());
		testObject.setEmpNo(param.getEmpNo());
		testObject.setName("BKLOVE");
		return testObject;
	}
}
