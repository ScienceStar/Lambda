package bank;

/**
 * @author lxc
 * @Title: RunableFunction
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/21 10:37
 */
public class RunableFunction {

    public static void runRunable(){
        Bank2 bank2 = new Bank2();
        while (true) {
            System.out.println("--------------2------------");
            bank2.subMoney(100);
            bank2.lookMoney( );
            System.out.println("\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace( );
            }
        }
    }
}
