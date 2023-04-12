package kr.kh.spring.vo;

import lombok.Data;

@Data
public class A {
	int a_num;
	String a_table;
	int a_target_num;
	B b;
	C c;
}
