package day001;

import java.io.File;

public class Demofile0 {
    public static void main(String[] args) {
        File dir = new File("D:\\ruanjian\\javaURL\\JavaInstallbag");
        getAllFile(dir);
    }

    private static void getAllFile(File dir) {
        //System.out.println(dir);

        //System.out.println("===========================================");

        File[] files = dir.listFiles();

        for (File file:files) {
            if (file.isDirectory()){
                //System.out.println("=============================================");
                getAllFile(file);
            }else {
                if (file.getName().toLowerCase().endsWith(".txt")){
                    System.out.println(file);
                }
            }
        }

    }


}
