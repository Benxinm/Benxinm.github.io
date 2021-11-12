package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class MyCatCafe implements CatCafe{
    double moneyLeft;
    double profit=15;
    int record=0;
    public MyCatCafe(){}
    public MyCatCafe(double moneyLeft) {
        this.moneyLeft = moneyLeft;
    }

    ArrayList<Cat> catList= new ArrayList<>();
    ArrayList<Customer> customerRecorder=new ArrayList<>();
    HashMap accountBook =new HashMap<LocalDate,Integer>();//记录不同时间，rua猫的总次数
    @Override
    public void cat(Cat cat) {
        moneyLeft-=cat.getPrice();
        if (moneyLeft<0){throw new InsufficientBalanceException("没钱啦，倒闭啦！");}
        if(cat instanceof BlackCat){
            catList.add((BlackCat)cat);
        }else if(cat instanceof OrangeCat){
            catList.add((OrangeCat)cat);
        }
    }

    @Override
    public void pleaseCustomer(Customer customer) {
        if(catList.size()==0){
            throw new CatNotFoundException("客官，本店各位猫大人都去服侍其他主子了，请稍等片刻");
        }
        System.out.println("客官，想要rua什么🐱呢");
        System.out.println(catList.get((int)Math.floor(Math.random()*catList.size())));
        customerRecorder.add(customer);
        moneyLeft+=profit*customer.rua;
        accountBook.put(customer.time,record+=customer.rua);
    }

    @Override
    public void close() {
        System.out.println("本店就此关门，请各位下次再来");
        System.out.println(LocalDate.now());
        for (Customer customer :customerRecorder) {
            System.out.println(customer);
        }
        System.out.println("今天盈利"+(int)accountBook.get(LocalDate.now())*profit+"元");
    }
}
