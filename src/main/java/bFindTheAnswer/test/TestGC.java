package bFindTheAnswer.test;

/**
 * Created by drudg on 2017/6/19.
 */
public class TestGC {
    public Object instance=null;
    private static final int _1MB=1024*1024;

    private byte[] bigSize=new byte[2*_1MB];


    public static void testGC(){
        TestGC tA=new TestGC();
        TestGC tB=new TestGC();
        tA.instance=tB;
        tB.instance=tA;

        tA=null;
        tB=null;
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
