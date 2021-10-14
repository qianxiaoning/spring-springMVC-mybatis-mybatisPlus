package com.test;

import org.junit.Test;

import com.qxn.spring.beans.ServiceA;

public class TestServiceA extends ReadBeans{
	@Test
	public void testServiceA() {
		ServiceA ds = ctx.getBean("serviceA",ServiceA.class);
		System.out.println(ds);
	}
}
