package domain;


/**
 * 需要测试的类，里面有加减乘除四个方法
 */
public class Calculator {

    @Chek
    public void add(){
        System.out.println("1 + 0 = "+(1+0));
    }
    @Chek
    public void sub(){
        System.out.println("1 - 0 = "+(1-0));
    }
    @Chek
    public void mul(){
        System.out.println("1 * 0 = "+(1*0));
    }
    @Chek
    public void div(){
        System.out.println("1 / 0 = "+(1/0));
    }


    public void show(){
        System.out.println("永无bug.........");
    }
}
