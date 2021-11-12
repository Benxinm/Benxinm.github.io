package ThreadTest;

public class ThreadTest {
    static int[]  arr1 = {1, 3, 5, 7, 9};
    static int[] arr2={2, 4, 6, 8, 10};
    static volatile int num = 0;
    static volatile boolean flag = false;
    public static void main(String[] args) {
        output();
    }
    public static void output(){
        Thread t1=new Thread(()->{
            while(num<9){
                if(!flag&&(num==0||++num%2==0)){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(arr1[num/2]);
                    flag=true;
                }
            }
            });
        Thread t2=new Thread(()->{
            while (num<9){
                if (flag&&++num%2==1){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(arr2[(num-1)/2]);
                    flag=false;
                }
            }
            });
        t1.start();
        t2.start();
    }
}
