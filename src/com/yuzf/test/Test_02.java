package com.yuzf.test;

public class Test_02 {

	public static void main(String[] args) {
		Test_02 test = new Test_02();
		test.first();
	}
	
	private void first() {
		int i = 5;
		Value v = new Value();
		v.i = 25;
		second(v,i);
	}
	
	private void second(Value v,int i) {
		i = 0;
		v.i = 20;
		Value val = new Value();
		v = val;
		System.out.println(v.i+""+i);
				
	}
}

class Value {
	public int i;
}
