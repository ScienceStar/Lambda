package service;

/**
 * @author lxc
 * @Title: IMatch
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/15 10:22
 */
@FunctionalInterface
public interface IMatch {
    public boolean match(String str1,String str2);
}
