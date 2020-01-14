package bank;

/**
 * @author lxc
 * @Title: RunableFunction
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/21 10:37
 */
public final class RunableFunction implements java.io.Serializable, Comparable<String>, CharSequence {

    public  char value[];

    public RunableFunction(char[] value) {
        this.value = value;
    }

    public RunableFunction() {
    }

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

    public String show(String str){
        return str+"Hello";
    }

    public boolean matchStr(String str1,String str2){
        if(str1.equals(str2)){
            return true;
        }else {
            return false;
        }
    }

    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
                return true;
        }
        return false;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
