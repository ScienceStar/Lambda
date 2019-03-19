package service;

/**
 * @author lxc
 * @Title: IFunction
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/15 11:09
 */
@FunctionalInterface
public interface IStream<T,K> {
    public K getStrings(T t);
    public static void printStrem(String str){
        System.out.println(str);
    };
}
