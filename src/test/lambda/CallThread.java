package test.lambda;

import org.junit.Test;
import thread.MyCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lxc
 * @Title: CallThread
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/25 9:38
 */
public class CallThread {

    @Test
    public void callThreadTest() {
        Callable<Integer> myCallable = new MyCallable( );    // 创建MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable); //使用FutureTask来包装MyCallable对象

        Thread thread = new Thread(ft);  //FutureTask对象作为Thread对象的target创建新的线程
        thread.start( );  //线程进入到就绪状态

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace( );
        }

        System.out.println("主线程在执行任务");

        try {
            int sum = ft.get( ); //取得新创建的线程中的call()方法返回的结果
            System.out.println("task运行结果,sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace( );
        } catch (ExecutionException e) {
            e.printStackTrace( );
        }

        System.out.println("所有任务执行完毕");
    }
}
