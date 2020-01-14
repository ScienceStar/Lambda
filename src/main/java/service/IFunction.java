package service;

/**
 * @author lxc
 * @Title: IFunction
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/15 11:09
 */
@FunctionalInterface
public interface IFunction<T> {
    public void getStrings(T t,String mess);
    public static void printStrem(String str,String str2){
        System.out.println(str);
    };
}
