package store.lbj.JdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Tester {
	public static void main(String[] args) {
		DAOInterface userDAO = new UserDAO();
		DAOInterface proxy = (DAOInterface)Proxy.newProxyInstance(
				userDAO.getClass().getClassLoader(),
				userDAO.getClass().getInterfaces(), 
				new InvocationHandler() {
					 //回调方法 拦截到目标对象的时候执行
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("在大理对象中拦截到"+method.getName());
						Object o = method.invoke(userDAO, args);
						return o;
					}
				});
		proxy.delete();
	}
}
