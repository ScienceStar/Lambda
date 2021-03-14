package lambda;

import bean.Dog;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName InstanceInit
 * @Description: TODO 实例初始化
 * @Author lxc
 * @Date 2021/2/16 10:26
 * @Version V1.0
 **/
public class InstanceInit {

    /**
     * @MethodName: pathCreate
     * @Description: TODO 根据路径创建对象
     * @Param []
     * @Return void
     * @Throws
     * @Author lxc
     * @Date 2021/2/16 11:16
     */
    @Test
    public void pathCreate(){
        String className="bean.Dog";
        try {
            Class clz=Class.forName(className);
            Object instance = clz.newInstance();
            Dog dog= (Dog) instance;
            dog.setHeight(21);
            dog.setWeight(28);
            System.out.println(dog.getHeight()+"    "+dog.getWeight());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * @MethodName: constructorInstance
     * @Description: TODO 构造器创建对象
     * @Param []
     * @Return void
     * @Throws
     * @Author lxc
     * @Date 2021/2/16 11:16
     */
    @Test
    public void constructorInstance(){
        Constructor<Dog> dogConstructor;

        try {
            dogConstructor = Dog.class.getConstructor();
            try {
                Dog dog=dogConstructor.newInstance();
                dog.setWeight(98);
                dog.setHeight(32);
                System.out.println(dog.getWeight()+"   "+dog.getHeight());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * @MethodName: serializationInstance
     * @Description: TODO 反序列化创建对象
     * @Param []
     * @Return void
     * @Throws
     * @Author lxc
     * @Date 2021/2/16 11:26
     */
    @Test
    public void serializationInstance(){
        String filePath="dog.txt";

        Dog dog = new Dog(21,76);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(dog);
            outputStream.flush();
            outputStream.close();

            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            Dog dog1 = (Dog) inputStream.readObject();

            inputStream.close();

            System.out.println("Height:"+dog1.getHeight()+", Weight:"+dog1.getWeight());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
