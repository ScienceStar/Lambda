package service;

/**
 * @author lxc
 * @Title: IFunction
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/15 11:09
 */
@FunctionalInterface
public interface IFunction2<K,T>{
    public boolean getStrings(K k,T t);
}
