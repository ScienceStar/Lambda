package service;

/**
 * @author lxc
 * @Title: ICompare
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/14 13:38
 */
@FunctionalInterface
public interface ICompare {
//    public int compare(int a,int b);
    public boolean test(String str);
    public static boolean compare(String str){
        if (str.equals("http://")){
            return true;
        }else {
            return false;
        }
    }
    public static boolean startsWith(String str){
        if (str.equals("http://")){
            return true;
        }else {
            return false;
        }
    }
}
