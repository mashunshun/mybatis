package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 *
 * 主方法执行后自动执行加了Chek注解的所有方法
 */
public class TestChek {

    public static void main(String[] args) throws IOException {
        //创建需要测试类的对象
        Calculator c = new Calculator();

        //获取该类的字节码文件对象
        Class cls = c.getClass();

        //通过字节码文件获取到类中的所有方法
        Method[] methods = cls.getMethods();

        //出现异常的次数变量
        int count =  0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        //判断每个方法是否有Chek注解，有的，就执行
        for (Method method: methods) {//遍历所有的方法
            //判断方法上是否有Chek注解
            if (method.isAnnotationPresent(Chek.class)){
                //有Chek，执行
                try {//捕获异常
                    method.invoke(c);
                } catch (Exception e) {
                    //e.printStackTrace();
                    count++;
                    bw.write("---------------------"+method.getName()+"第"+count+"次异常-----------------------");
                    bw.newLine();
                    bw.write(method.getName()+"出异常了");
                    bw.newLine();
                    bw.write("异常名字是："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    //bw.write("---------------------");
                }
            }
        }

        bw.write("本次测试共"+methods.length+"个方法,共出现"+count+"次异常");
        bw.flush();
        bw.close();
    }
}
