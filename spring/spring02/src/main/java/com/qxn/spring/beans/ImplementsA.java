package com.qxn.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//不在启动时创建，延迟加载
@Lazy
//实例的单例和多例
@Scope("singleton")
//@Scope("prototype")
//自己写的类，@Component交给spring管理
@Component
public class ImplementsA implements InterfaceA{
	public ImplementsA() {
		System.out.println("ImplementsA()");
	}
	//生命周期方法
	//初始化
	@PostConstruct
	public void init() {
		System.out.println("init()");
	}
	//即将关闭
	@PreDestroy
	public void close() {
		System.out.println("close()");
	}
}
