package com.skcc.springserver.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestObject {
	private String name;
	private String age;
	private int empNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	@Override
	public String toString() {
		return "TestObject [name=" + name + ", age=" + age + ", empNo=" + empNo
				+ "]";
	}
}
