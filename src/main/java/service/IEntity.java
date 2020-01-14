package service;

/**
 * @author lxc
 * @Title: IEntity
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/16 9:28
 */
@FunctionalInterface
public interface IEntity<K,T,P> {
    public P getEntity(K k,T t);
}
