package test;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        //里面自带 猫列表 和 顾客列表
        MyCatCafe myCatCafe = new MyCatCafe(500);
        Customer zs=new Customer(3,"张三", LocalDate.now());
        //测试没有猫的时候CatNotFoundException
        try {
            myCatCafe.pleaseCustomer(zs);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        OrangeCat orangeCat = new OrangeCat("小橘", 4, "男", 400);
        myCatCafe.cat(orangeCat);
        BlackCat blackCat = new BlackCat("小黑", 5, "女", 500);
        //测试InsufficientBalanceException
        try {
            myCatCafe.cat(blackCat);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        /**
         * 给余额充值，方便后续测试
         */
        myCatCafe.moneyLeft+=100000;


        myCatCafe.pleaseCustomer(zs);
        Customer ls = new Customer(6, "李四", LocalDate.now());
        myCatCafe.pleaseCustomer(ls);
        myCatCafe.close();
    }
}
