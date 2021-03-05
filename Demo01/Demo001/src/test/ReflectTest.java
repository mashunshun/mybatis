package test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，执行任意方法
        /*
        在家配置文件
         */

        //1.创建配置文件对象
        Properties properties = new Properties();
        //加载配置文件，转换为一个集合
        ClassLoader classLoader = ReflectTest.class.getClassLoader();//获取ReflectTest类的类加载器
        InputStream is = classLoader.getResourceAsStream("pro.properties");//获取配置文件的输入流对象
        properties.load(is);

        //获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //加载该类进内存
        Class cls = Class.forName(className);

        //创建对象
        Object obj = cls.newInstance();

        //获取方法
        Method method = cls.getMethod(methodName);

        //执行方法
        method.invoke(obj);

    }
}
