/**
 * ThreadLocal线程局部变量
 *
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中session就存在与ThreadLocal中，避免synchronized的使用
 *
 * 运行下面的程序，理解ThreadLocal
 * 
 * @author 马士兵
 */
package com.mashibing.juc.c_022_RefTypeAndThreadLocal;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ThreadLocal2 {
	//volatile static Person p = new Person();
//	static ThreadLocal<Object> tl = new ThreadLocal<>();
//	static ThreadLocal<Object> tt = new ThreadLocal<>();
	
	public static void main(String[] args) {

		new Thread(()->{
			ThreadLocal<Object> tl = new ThreadLocal<>();
			HashMap<Object,Object> map = new HashMap<>();
			tl.set("asd");
			tl.set("asd");
			tl.set("qwe");
			System.out.println(tl.get());
			new Thread(()->{
				tl.set(123);
				System.out.println(tl.get());
			}).start();
		}).start();

		new Thread(()->{
			ThreadLocal<Object> tl = new ThreadLocal<>();

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(tl.get());
		}).start();
		ThreadLocal2 t = new ThreadLocal2();
		t.a();

	}
	static ThreadLocal<Integer> tt = new ThreadLocal<>();
	public void a(){

		tt.set(432);
		System.out.println(tt.get());
		b();
	}

	public void b(){
		System.out.println(tt.get());
	}
	
	static class Person {
		String name = "zhangsan";
	}
}


