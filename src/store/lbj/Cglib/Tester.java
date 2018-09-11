package store.lbj.Cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//cglib代理要求类不能使用final，代理对象继承目标对象
public class Tester {
	public static void main(String[] args) {
		UserDAO	target = new UserDAO();
		Enhancer enhancer = new Enhancer();
		//设置代理对象的父类
		enhancer.setSuperclass(target.getClass());
		//设置回调
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				System.out.println("在代理对象中拦截到"+arg1.getName());
				Object o  = arg1.invoke(target, arg2);
				return o;
			}
		});
		UserDAO proxy = (UserDAO)enhancer.create();
		proxy.add();
	}
}
