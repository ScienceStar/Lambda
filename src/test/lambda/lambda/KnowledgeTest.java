package lambda.lambda;

import bean.Car;
import org.junit.Test;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class KnowledgeTest {

    static Object strongRef = new Object();

    //强引用
    @Test
    public void testStrongRef() {
        Object object = strongRef;
        strongRef = null;
        object = null;
        System.gc();
        System.out.println("GC之后:" + object);
    }

    //软引用
    @Test
    public void testSoftRef() {
        String str = "hello";
        Object softRef = new Object();
        SoftReference softReference = new SoftReference(str);
        softRef = null;
        str = null;
        System.out.println(softReference.get());
    }

    //弱引用
    @Test
    public void testWeakRef() {
        Object weakObject = new Object();
        WeakReference weakReference = new WeakReference(weakObject);
        System.gc();
        System.out.println("After:" + weakReference.get());
    }

    //虚引用
    @Test
    public void testPhantomRef() throws InterruptedException {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        Object phantomObj = new Object();
        PhantomReference phantomReference = new PhantomReference(phantomObj, referenceQueue);
        System.out.println(phantomReference.get());

        phantomObj = null;
        System.gc();
        System.out.println(phantomReference.get());

        Thread.sleep(2000);
        System.out.println(referenceQueue.poll());
    }

    /**
     * @MethodName: testInteger
     * @Description: TODO Integer 测试
     * @Param: []
     * @Return: void
     * @Author: lxc
     * @Date: 2020/2/5 15:30
     **/
    @Test
    public void testInteger() throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1, b = 2;
        System.out.println("Before:a=" + a + ",b=" + b);
        swap(a, b);
        System.out.println("After:a=" + a + ",b=" + b);
    }

    /**
     * @MethodName: swap
     * @Description: TODO 交换数据
     * @Param: [i1, i2]
     * @Return: void
     * @Author: lxc
     * @Date: 2020/2/5 15:26
     **/
    public static void swap(Integer i1, Integer i2) throws NoSuchFieldException, IllegalAccessException {
//        i1 = i1+i2;//i1=1+2=3
//        i2 = i1-i2;//i2=3-2=1
//        i1 = i1-i2;//i1=3-1=2
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
//        int tmp = i1.intValue();
        Integer tmp = new Integer(i1.intValue());
        field.setInt(i1, i2.intValue());
        field.setInt(i2, tmp);
    }

    /**
     * @MethodName: adjectiveClone
     * @Description: TODO 浅克隆
     * @Param: []
     * @Return: void
     * @Author: lxc
     * @Date: 2020/2/6 13:42
     **/
    @Test
    public void adjectiveClone() throws CloneNotSupportedException {
        Car car = new Car();
        car.setCarColor("red");

        Car car1 = (Car) car.clone();
        System.out.println(car1);
    }

    /**
     * @MethodName: deepClone
     * @Description: TODO 深克隆
     * @Param: []
     * @Return: void
     * @Author: lxc
     * @Date: 2020/2/6 14:04
     **/
    @Test
    public void deepClone() throws IOException, ClassNotFoundException {
        Car car = new Car();
        car.setCarColor("read");
        car.setCarPrice("21");

        Car car1 = car.deepClone();
        System.out.println(car1.getCarColor() + "->" + car1.getCarPrice());
    }

    /**
     * @MethodName: testEquals
     * @Description: TODO == 与 equals 比较
     * @Param: []
     * @Return: void
     * @Author: lxc
     * @Date: 2020/2/6 17:55
     **/
    @Test
    public void testEquals() {
        String a = "x", b = "x";
        String c = new String("x");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a == c);
    }

    @Test
    public void testCal() {
        int a = 3;
        System.out.println(++a);
    }

    @Test
    public void testMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("1", "jack");
        map.put("2", "tom");
        map.put("3", "tina");

        System.out.println(map.get("1").hashCode());
    }

    private static int i;
    private volatile boolean isStop = false;

    /**
     * @MethodName: testThread
     * @Description: TODO 多线程测试
     * @Param []
     * @Return void
     * @Throws
     * @Author mac
     * @Date 2021/2/21 10:05 pm
     */
    @Test
    public void testThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!isStop) {
                i++;
                System.out.println("num:->" + i);
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(2);
        isStop = true;
        System.out.println("Thread is stoped!");
    }

    /**
     * @MethodName: testFloat
     * @Description: TODO  浮点数据测试
     * @Param []
     * @Return void
     * @Throws
     * @Author mac
     * @Date 2021/2/25 1:49 pm
     */
    @Test
    public void testFloat() {
        System.out.println(Math.round(11.5) + "   " + Math.round(-11.5));
    }

    /**
     * @MethodName: testAssert
     * @Description: TODO 断言测试
     * @Param []
     * @Return void
     * @Throws
     * @Author mac
     * @Date 2021/2/25 1:49 pm
     */
    @Test
    public void testAssert() {
        int age = -21;
        this.testAssert(age);
    }

    /**
     * @MethodName: testAssert
     * @Description: TODO 断言测试
     * @Param [arg]
     * @Return void
     * @Throws
     * @Author mac
     * @Date 2021/2/21 10:33 pm
     */
    public void testAssert(int arg) {
        assert arg > 0 : "The age is ilegale";
        System.out.println("continue: Your age is:" + arg);
    }

    @Test
    public void testBoolean() {
        int a = 8, b = 4, c = 2 << 3;

        String str = a == c || b < 5 ? "true" : "false";
        System.out.println(str);
    }

    /**
     * @MethodName: testLable
     * @Description: TODO label标签测试
     * @Param []
     * @Return void
     * @Throws
     * @Author mac
     * @Date 2021/2/21 10:06 pm
     */
    @Test
    public void testLable() {
        first:
        // 标签与循环直接不可以加语句
        for (int i = 0; i < 3; ++i) {
            System.out.println("\nfirst: " + (i + 1) + " times start");

            second:
            for (int j = 0; j < 2; ++j) {
                System.out.println("\tsecond: " + (j + 1) + " times start");
                if (i == 1 && j == 1) {
                    System.out.println("\t----break----");
                    break;
                }

                third:
                for (int k = 0; k < 2; ++k) {
                    System.out.println("\t\tthird: " + (k + 1) + " times start");
                    if (i == 1 && j == 0 && k == 0) {
                        System.out.println("\t\t----continue----");
                        continue;
                    }
                    if (i == 2 && j == 0) {
                        System.out.println("\t\t----continue second----");
                        continue second;
                    }
                    if (i == 2 && j == 1 && k == 1) {
                        System.out.println("\t\t----break first----");
                        break first;
                    }

                    System.out.println("\t\tthird: " + (k + 1) + " times end");
                }
                System.out.println("\tsecond: " + (j + 1) + " times end");
            }
            System.out.println("first: " + (i + 1) + " times end");
        }
    }

    /**
     * @MethodName: testGoTo
     * @Description: TODO java跳转测试
     * @Param []
     * @Return void
     * @Throws
     * @Author mac
     * @Date 2021/2/21 10:06 pm
     */
    @Test
    public void testGoTo(){
        //打印101~150之间的所有质数
        //质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。
        int count = 0;
        outer:for (int i = 101; i < 150; i++) {
            for (int j = 2; j < i/2; j++){
                if (i % j == 0){
                    continue outer;
                }
            }
            System.out.println(i+"");
        }
    }


    public static void main(String[] args) throws IOException {
        char a;
        outer:
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j <10; j++)
            {
                a =(char) System.in.read();
                if(a == 'b')
                    break outer;
                if(a == 'c'){
                    System.out.println(j);
                    if(j%2==0){
                        continue outer;
                    }
                }
            }
        }
    }
}
