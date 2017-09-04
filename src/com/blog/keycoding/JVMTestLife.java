package com.blog.keycoding;

public class JVMTestLife {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.currentThread().sleep(i * 10000);
						System.out.println("睡了" + i * 10 + "秒");
					} catch (InterruptedException e) {
						System.out.println("干嘛吵醒我");
					}
				}
			}
		}).start();

		for (int i = 0; i < 50; i++) {
			System.out.print(i);
		}
	}
}
