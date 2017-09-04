package com.sxt.gaoqi;

public class Demo1 {
	static {
		System.out.println("静态初始化Demo1");
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Demo1的main方法");
		// A a = new A();
		// System.out.println(a.width);
		// A a2 = new A();

		// 主动引用
		// new A();
		// System.out.println(A.width);
		// Class.forName("com.sxt.gaoqi.A");

		// 被动引用
		// System.out.println(A.MAX);
		// A[] as = new A[10];
		System.out.println(A_son.width);
	}
}

class A_son extends A {
	static {
		System.out.println("静态初始化类A_son");
		width = 30;
	}

	public A_son() {
		System.out.println("创建A_son类的对象");
	}
}

class A extends A_Father {
	public static int width = 100;// 静态变量,静态域,Field

	public static final int MAX = 100;

	static {
		System.out.println("静态初始化类A");
		width = 300;
	}

	public A() {
		System.out.println("创建A类的对象");
	}
}

class A_Father {
	public static int width = 200;// 静态变量,静态域,Field

	static {
		System.out.println("静态初始化类A_Father");
		width = 400;
	}

	public A_Father() {
		System.out.println("创建A_Father类的对象");
	}
}