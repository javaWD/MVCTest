package bFindTheAnswer.test;

import org.junit.Test;

/**
 * Created by drudg on 2017/6/12.
 */
public class CountTicket {

    @Test
    public void testCountTicket(){
        double money=0;
        double discount=0;
        for (int i = 0; i <44; i++) {
            if(money<=100){
                discount=1;
            }
            else if(money>100&&money<=150){
                discount=0.8;
            }
            else if(money>150){
                discount=0.5;
            }
            money=money+6*discount;
        }

        System.out.println("计算一个月上下班地铁钱："+money);
    }

    @Test
    public void testCountTicket2(){
        double money=0;
        int dayOfWork=44;
        double discount=0;
        int nowCount=0;
        int temp=100%6;
        double mine=0;



        nowCount+=(100-temp+6)/6;

        if(nowCount<44){
            nowCount+=(150-(100-temp+6))/4.8;
        }
        System.out.println(150-(100-temp+6));
        System.out.println(nowCount);

//        for(int i=nowCount;i<=44;i++){
//            money=150
//            nowCount++;
//        }


    }

    @Test
    public void testGetCount(){
        String str="1,2,3,4,5,,7";
        String[] st1=str.split(",");
        System.out.println(st1[6]);
    }
}
