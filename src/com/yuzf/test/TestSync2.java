package com.yuzf.test;

public class TestSync2 implements Runnable {
	int b = 100;

	synchronized void m1() throws InterruptedException {
		b = 1000;
		Thread.sleep(500); // 6
		System.out.println("b=" + b);
	}

	synchronized void m2() throws InterruptedException {
		Thread.sleep(250); // 5
		b = 2000;
	}

	public static void main(String[] args) throws InterruptedException {
		TestSync2 tt = new TestSync2();
		Thread t = new Thread(tt); // 1
		t.start(); // 2  有一个准备过程

		tt.m2(); // 3   这一步方法比  2方法调用的线程要先执行！！！！
		System.out.println("main thread b=" + tt.b); // 4   谁先获得b的赋值权，输出就不一样
	}

	@Override
	public void run() {
		try {
			m1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
