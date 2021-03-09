package lambda;

import bank.Bank2;
import bank.RunableFunction;
import service.IFunction2;

/**
 * @author lxc
 * @Title: SyncThreadTest
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/21 10:25
 */
public class SyncThreadTest {
    public static void main(String args[]) {
        final Bank2 bank = new Bank2( );

        Thread tadd = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("--------------1------------");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace( );
                }
                bank.addMoney(100);
                bank.lookMoney( );
                System.out.println("\n");

            }
        });

        /*RunableFunction runableFunction = new RunableFunction();
        Runnable runnable = RunableFunction::runRunable;
        IFunction2<String,String> iFunction2 = String::equals;
        System.out.println(iFunction2.getStrings("Mike") );
        Thread tbdd = new Thread(runnable);
        tbdd.start();*/

        IFunction2<String,String> iFunction2 =new RunableFunction()::matchStr;
        System.out.println(iFunction2.getStrings("hello","world"));

        Thread tsub = new Thread(() -> {
            while (true) {
                System.out.println("--------------3------------");
                bank.subMoney(100);
                bank.lookMoney( );
                System.out.println("\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace( );
                }
            }
        });
        tsub.start( );

        tadd.start( );
    }

}
