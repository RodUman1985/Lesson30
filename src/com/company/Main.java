package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
	// подготовка к карновалу
        //работа со строками (как с набором символов) (изменять код символа в строке)
        //
        Test test=new Test();
        test.start();
        test.join();
        String s= "hello";
        for(char c: s.toCharArray()) {
            System.out.println((int)c);
        }
        System.out.println(s);
        System.out.println("For the Imperor!!!");
        System.out.println(toUpperCase("For the Imperor!!!"));
     //алгоритмы + массивы
        // сортировка путем пузырька
        // Buble sort

      int[] arr={3,17,28,11,-8,0};
      sort(arr);
      for(int e:arr){
          System.out.println(e);
      }
      // потоки и фаилы(чтение+запись)
        FileWriter fw=new FileWriter("1.txt");
      Thread t1=new Thread(()->{
          try {
              synchronized (fw){
              fw.write(" hello ");}
          } catch (IOException e) {
              e.printStackTrace();
          }
      });
        Thread t2=new Thread(()->{
            try {
                synchronized (fw) {
                    fw.write(" World!!! ");}
                } catch(IOException e){
                    e.printStackTrace();

            }

        });
     // fw.write("hello!!");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
      fw.flush();
      fw.close();
        FileReader fr=new FileReader("1.txt");
        char[]data=new char[7];
        fr.read(data);
        fr.close();
        String s2=new String(data);
        System.out.println(s2);
        char first= s2.charAt(0);
        char last= s2.charAt(s2.length()-1);
        System.out.println(first+ "  "+last);
        Random rand=new Random();
        rand.nextInt(101);//0..100


    }
    public static String toUpperCase(String s) {
        //s [a..z..'' ...A...Z]
        int offSet='a'-'A';
        /*if (offSet<0){
            offSet*=-1;
        }*/
        StringBuilder sb=new StringBuilder(s.length());
        for(char c:s.toCharArray()){
            if(c>='a'&& c<='z'){
                c-=offSet;
            }
            sb.append(c);
        }
        return sb.toString();
    }
    public static void sort(int[]toSort){
        for(int i=0;i<toSort.length-1;i++){
            for (int j =i+1;j<toSort.length;j++){
                if(toSort[i]>toSort[j]){
                    int tmp=toSort[i];
                    toSort[i]=toSort[j];
                    toSort[j]=tmp;
                }
            }
        }
    }
}
