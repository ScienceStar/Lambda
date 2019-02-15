package service;

/**
 * @author lxc
 * @Title: Supplier
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/15 10:11
 */
@FunctionalInterface
public interface Supplier<T> {
    T getEntity();
}
