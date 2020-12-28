import bean.Car;
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

    PrintStream ps = System.out;

    @Test
    public void testLambda() {
        //静态方法引用
        ICaculate caculate = getCacuLate()::getResult;

        int num = caculate.getResult(3, 4, 5, 3);
        ps.println(num);
    }

    public ICalResult getCacuLate(){
        return (a,b,c,d)->{
            return a+b+c+d;
        };
    }

    @Test
    public void testList() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        players.forEach((x) -> {
            ps.println(x);
        });

        ps.println("--------------------");
        players.forEach(ps::println);
    }

    @Test
    public void testFunction2() {
        Arrays.asList("aa", "bb", "cc").forEach(ICaculate::print);
    }

    @Test
    public void testFunction3() {
        //1  为了更好理解，将ps声明出来
        //2  传入的参数用来打印到控制台
        Consumer<String> con = (str) -> ps.print(str);
        //3  调用方法
        con.accecpt("Hello World\n");
        //4  上面是一个简单的例子，下面我们换个写法
        ps.println("--------------------------------");
        //5  ps为PrintStream对象，println为实例方法
        Consumer<String> con2 = ps::print;
        //6  调用方法
        con2.accecpt("Hello Java8！");
        //7  所以也可换成这种写法
        //Consumer<String> con3 = ps::println;
    }

    @Test
    public void testFunction4() {
        ICaculate caculate = ICaculate::getResult3;
        caculate.getResult(3, 4, 14, 3);
        ps.println("--------------------------");
        ICompare compare = ICompare::startsWith;
        boolean flag = compare.test("http://");
        ps.println(flag);
    }

    @Test
    public void testFunction5() {
        Supplier<Dog> dogSupplier = Dog::new;
        Dog d = dogSupplier.getEntity( );
        d.getWeight( );
        ps.println("---------------------------------");
        Supplier<Integer> dog = Dog::getAge;
        int age = dog.getEntity( );
        ps.println(age);
    }

    @Test
    public void testFunction6() {
        IMatch match = String::equals;
        boolean flag = match.match("Hello", "Hello");
        ps.println(flag);
    }

    @Test
    public void testFunction7() {
        Dog dog = new Dog( );
        dog.setWeight(32);
        Supplier<Integer> supplier = () -> dog.getWeight( );
        Supplier<Integer> supplier2 = supplier::getEntity;
        ps.println("--------------111-------------" + supplier2.getEntity());
        supplier = dog::getWeight;
        supplier.getEntity( );
        ps.println("---------------------------");
        supplier = Dog::getHeight;
        Integer height = supplier.getEntity( );
        ps.println("Height->" + height);
    }

    @Test
    public void testFunction8() {
        //数组引用
        IStream<Integer,String[]> stream = String[]::new;
        String[] strings = stream.getStrings(5);
        strings[0] = "hello1";
        strings[1] = "hello2";
        strings[2] = "hello3";
        strings[3] = "hello4";
        strings[4] = "hello5";

        IFunction<String> iFunction = IFunction::printStrem;
        for (String s : strings) {
            iFunction.getStrings(s,"hello");
        }
    }

    @Test
    public void testFunction9(){
        Supplier<Dog> dogSupplier = Dog::new;
        Dog dog = dogSupplier.getEntity();
        dog.setWeight(15);
        //实例方法引用
        Supplier<Integer> weight = dog::getWeight;
        ps.println(weight.getEntity());
    }

    @Test
    public void testFunction10(){
        IEntity<Integer,Integer,Dog> dogIEntity = (x,y)->{
            return new Dog(x,y);
        };
        Dog dog = dogIEntity.getEntity(22,32);
        ps.println(dog.getWeight());
        ps.println("---------------------------------");
        //构造引用
        IEntity<Integer,Integer,Dog> dogIEntity1 = Dog::new;
        Dog dog1 = dogIEntity1.getEntity(32,21);
        ps.println(dog1.getWeight());
    }

    @Test
    public void testFunction11(){
        final Car car = Car.create(Car::new);
        car.setCarColor("黑色");
        car.setCarPrice("50");
        final List<Car> cars = Arrays.asList(car);
        //Consumer<Car> carConsumer = Car::repair;
        for(Car car1 : cars){
            ps.println(car1.getCarColor()+"  "+car1.getCarPrice() );
        }

        //类方法引用
        IFunction<Car> carIFunction = Car::repair;
        carIFunction.getStrings(car,"--->hello");
        ps.println("----------------------------");
        cars.forEach(Car::repair2);
    }

    @Test
    public void testCal(){
        ICalResult calResult = (x1,x2,x3,x4) ->{
            return x1+x2+x3+x4+3;
        };

        System.out.printf("%s%d!\n","The result is:",calResult.getResult(5,8,2,4));
    }
}

@FunctionalInterface
interface ICalResult{
    int getResult(int i, int i1, int i2, int i3);
}
