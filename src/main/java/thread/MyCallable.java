package thread;

import java.util.concurrent.Callable;

/**
 * @author lxc
 * @Title: MyCallable
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/25 9:36
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        /*for (int i = 0; i < 100; i++) {
            //System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;*/
        while (true){
            sum+=1;
        }
    }
}
