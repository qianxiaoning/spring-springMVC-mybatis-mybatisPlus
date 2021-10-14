package com.qxn.spring.beans;

import org.springframework.stereotype.Component;
//和自动注入的属性名相同
//实现类B
@Component("implementsB")
public class ImplementsB implements InterfaceA{

}
