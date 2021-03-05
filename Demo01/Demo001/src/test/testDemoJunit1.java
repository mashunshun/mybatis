package test;


import day001.DemoJunit1;
import org.junit.Assert;
import org.junit.Test;

/*
测试类
 */
public class testDemoJunit1 {
    /*
    定义测试方法
     */
    @Test
    public void testadd(){
        //创建DemoJunit1对象
        DemoJunit1 demoJunit1 = new DemoJunit1();
        //调用add方法
        //int result = demoJunit1.add(2,1);
        int result = demoJunit1.sub(2,1);
        //断言
        Assert.assertEquals(3,result);

    }
}
