package test;

import bean.Dog;
import org.junit.Test;
import service.*;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author lxc
 * @Title: FunctionTest
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/14 9:16
 */
public class FunctionTest {

    @Test
    public void testLambda(){
        ICaculate caculate = ICaculate::getResult1;

        int num = caculate.getResult(3,4,5,3);
        System.out.println(num);
    }

    @Test
    public void testList(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        players.forEach((player)->{
            System.out.println(player);
        });

        System.out.println("--------------------");
        players.forEach(System.out::println);
    }

    @Test
    public void testFunction2(){
        Arrays.asList("aa","bb","cc").forEach(ICaculate::print);
    }

    @Test
    public void testFunction3(){
        //1  为了更好理解，将ps声明出来
        PrintStream ps = System.out;
         //2  传入的参数用来打印到控制台
        Consumer<String> con = (str) -> ps.print(str);
        //3  调用方法
        con.accecpt("Hello World\n");
        //4  上面是一个简单的例子，下面我们换个写法
        System.out.println("--------------------------------");
        //5  ps为PrintStream对象，println为实例方法
        Consumer<String> con2 = ps::print;
        //6  调用方法
        con2.accecpt("Hello Java8！");
        //7  所以也可换成这种写法
        //Consumer<String> con3 = System.out::println;
    }

    @Test
    public void testFunction4(){
        ICaculate caculate = ICaculate::getResult3;
        caculate.getResult(3,4,14,3);
        System.out.println("--------------------------");
        ICompare compare = ICompare::startsWith;
        boolean flag = compare.test("http:");
        System.out.println(flag );
    }

    @Test
    public void testFunction5(){
        Supplier<Dog> dogSupplier = Dog::new;
        Dog d = dogSupplier.getEntity();
        d.getWeight();
    }

    @Test
    public void testFunction6(){
        IMatch match = String::equals;
        boolean flag = match.match("hello","world");
        System.out.println(flag);
    }
}
