package com.test;

import org.junit.Test;

import com.qxn.spring.beans.ImplementsA;

public class TestImplementsA extends ReadBeans{
	//读取实现类A对象
	@Test
	public void testImplementsA() {
		ImplementsA cache1 = ctx.getBean("implementsA",ImplementsA.class);
		System.out.println(cache1);
		ImplementsA cache2 = ctx.getBean(ImplementsA.class);
		System.out.println(cache1==cache2);
	}
}
