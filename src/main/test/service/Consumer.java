package service;

/**
 * @author lxc
 * @Title: Consumer
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/14 11:06
 */
@FunctionalInterface
public interface Consumer<T> {

    public void accecpt(T t);
}
