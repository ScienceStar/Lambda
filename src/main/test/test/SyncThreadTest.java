package test;

import bank.Bank;
import bank.Bank2;
import bank.RunableFunction;

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

        RunableFunction runableFunction = new RunableFunction();
        Runnable runnable = RunableFunction::runRunable;
        Thread tbdd = new Thread(runnable);
        tbdd.start();

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
