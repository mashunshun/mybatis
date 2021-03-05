package day001;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    复制文件从c盘到D盘


    1、创建一个字节输入流，构造方法中绑定要复制的数据源
    2、创建一个字节输出流，构造方法中绑定要复制数据的目的地
    3、使用字节输入流的read方法读取数据源到内存
    4、使用字节输出流的write方法把read方法读取到的数据写到目的地
    5、释放资源
 */
public class DemoFile1 {
    public static void main(String[] args) throws IOException {
        //1、创建一个字节输入流，构造方法中绑定要复制的数据源
        FileInputStream fis = new FileInputStream("C:\\1.jpg");
        //2、创建一个字节输出流，构造方法中绑定要复制数据的目的地
        FileOutputStream fos = new FileOutputStream("D:\\1.jpg");
        //3、使用字节输入流的read方法读取数据源到内存
        int len = 0;
        byte[] bytes = new byte[1024];
//        while ((len = fis.read()) != -1){
//            //4、使用字节输出流的write方法把read方法读取到的数据写到目的地
//            fos.write(len);
//        }

        while ((len = fis.read(bytes)) != -1){
                //4、使用字节输出流的write方法把read方法读取到的数据写到目的地
                fos.write(bytes,0,len);
        }
        //5、释放资源
        fos.close();
        fis.close();
    }
}
