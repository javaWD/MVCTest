package bFindTheAnswer.test;

/**
 * Created by drudg on 2017/10/20.
 */
public class TestInit {
    static{
        if(true){
            System.out.println(Thread.currentThread()+"init TestInit");
            while(true){

            }
        }
    }

    public static void main(String[] args) {
        Runnable script=new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"start");
                TestInit ti=new TestInit();
                System.out.println(Thread.currentThread()+"run over");
            }
        };
        Thread thread1=new Thread(script);
        Thread thread2=new Thread(script);
        thread1.start();
        thread2.start();
    }
}
