package com.aethercoder.misc.Test;

public class Demo {
    //单线程
//    private static Demo instance =null;
//
//    private Demo(){
//
//    }
//
////    public static synchronized Demo getInstance(){
////        if(instance == null){
////            instance = new Demo();
////        }
////        return  instance;
////    }

    //多线程（懒汉式，不好）
//    private static Demo instance =null;
//
//    private Demo(){
//
//    }
//
////    public static synchronized Demo getInstance(){
////        if(instance == null){
////            instance = new Demo();
////        }
////        return  instance;
////    }
//

    //多线程（可行）
//    private static Demo instance =null;
//
//    private Demo(){
//
//    }
//
//    public static Demo getInstance(){
//        if(instance == null){
//            synchronized (Demo.class){
//                if (instance == null){
//                    instance = new Demo();
//                }
//            }
//        }
//
//        return instance;
//    }

    //多线程（饿汉式）
//    private static Demo instance = new Demo();
//
//    private Demo(){
//
//    }
//
//    public static Demo getInstance(){
//        return instance;
//    }

    // 静态内部
      private Demo(){

      }

      private static class DemoHolder{
          private final static Demo instance = new Demo();
      }

      public static Demo getInstance(){
          return DemoHolder.instance;
      }
}
