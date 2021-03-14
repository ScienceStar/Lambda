package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProgram {
    List<String> list = new ArrayList<String>();
    Stream stream = list.stream();

    /**
     * @MethodName: testStream
     * @Description: TODO 流式编程
     * @Param []
     * @Return void
     * @Throws
     * @Author mac
     * @Date 2021/2/26 5:15 pm
     */
    @Test
    public void testStream() {
        list.add("apple");
        list.add("orange");
        list.add("peach");
        list.add("pear");
        list.stream().filter(e -> e.length() > 2).forEach(System.out::println);

        //filter  条件过滤，仅保留流中满足指定条件的数据，其他不满足的数据都会被删除
        list.stream().filter(e -> e.length() > 3).forEach(System.out::println);

//distinct  去重集合中重复的元素。这个方法没有参数。去重的规则与HashSet相同
        list.stream().distinct().forEach(System.out::println);

//sorted  将流中的数据进行排序
// Comparable 接口方法实现排序
        list.stream().sorted().forEach(System.out::println);
// 指定规则排序
        list.stream().sorted((e1, e2) -> e1.length() - e2.length()).forEach(System.out::println);

//limit  截取流中指定数量的元素
        list.stream().limit(2).forEach(System.out::println);

//skip  跳过流中的指定数量的元素
        list.stream().skip(2).forEach(System.out::println);

//map  对流中的数据进行映射，用新的数据替换旧的数据
        list.stream().map(e -> e + "添加").forEach(System.out::println);
    }


    /**
     * @MethodName: testFinalStream
     * @Description: TODO 流式编程
     * @Param []
     * @Return void
     * @Throws
     * @Author mac
     * @Date 2021/2/26 5:14 pm
     */
    @Test
    public void testFinalStream() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(8);
        list.add(7);
        list.add(12);
        list.add(2);

        //collect  将流中的数据收集到一起进行处理
//将list转成set
        Set<Integer> result = list.stream().collect(Collectors.toSet());
        System.out.println(result);

//reduce  将流中的数据按照一定的规则聚合起来
        int result2 = list.stream().reduce((e1, e2) -> e1 + e2).get();
        System.out.println(result2);

//count  统计流中的元素数量
        long result3 = list.stream().count();
        System.out.println(result3);

//forEach  迭代流中的数据
        list.stream().forEach(System.out::println);

//max  获取流中的最大元素
        int result4 = list.stream().max(Integer::compareTo).get();
        System.out.println(result4);

//min  获取流中的最小元素
        int result5 = list.stream().min(Integer::compareTo).get();
        System.out.println(result5);
    }
}
