package com.qxn.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//自动注入
@Service
public class ServiceA implements ServiceInterface{	
	//@Autowired可以修饰属性，set方法，构造方法等
	@Autowired
	//按照属性名找
	//配合@Autowired，指定注入对象
	@Qualifier("implementsA")
	private InterfaceA interfaceA;
//	@Autowired
	//按照方法参数名找
//	public void setXxx(InterfaceA interfaceA) {
//		this.xxx = interfaceA;
//	}

	@Override
	public String toString() {
		return "DefaultSearchService [cache=" + interfaceA + "]";
	}
	
}
