package bank;

/**
 * @author lxc
 * @Title: Bank2
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/21 10:27
 */
public class Bank2 {
    private int count =0;//账户余额

    //存钱
    public  synchronized void addMoney(int money){
        count +=money;
        System.out.println(System.currentTimeMillis()+"存进："+money);
    }

    /**
     * @MethodName: subMoney
     * @Description: TODO 取钱
     * @Param [money]
     * @Return void
     * @Throws
     * @Author lxc
     * @Date 2021/1/12 11:49
     */
    public  synchronized void subMoney(int money){
        if(count-money < 0){
            System.out.println("余额不足");
            return;
        }
        count -=money;
        System.out.println(+System.currentTimeMillis()+"取出："+money);
    }

    //查询
    public void lookMoney(){
        System.out.println("账户余额："+count);
    }
}
