package com.sxt.gaoqi;

/**
 * 自定义文件系统类加载器
 * 
 * @author ywx
 *
 */
public class FileSystemClassLoader extends ClassLoader {

	// com\sxt\gaoqi\User
	// -->F:\MyTest\spring-boot-in-action\JVM\src\com\sxt\gaoqi\User.class
	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);

		// 应该先查询有没有加载过这个类，如果已经加载，则直接返回加载好的类。如果没有，则加载的类
		if (c != null) {
			return c;
		} else {
			ClassLoader parent = this.getParent();
			c = parent.loadClass(name);// 委派给父类加载
			if (c != null) {
				return c;
			} else {
				byte[] classData = getClassData(name);
				if (classData == null) {

				}
			}
		}
	}
}
