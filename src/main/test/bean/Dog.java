package bean;

/**
 * @author lxc
 * @Title: Dog
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/14 10:40
 */
public class Dog {

    private Integer weight;
    private Integer height;

    public static void crary(){
        System.out.println("The dog is crarying");
    }

    public Integer getWeight() {
        System.out.println(21+"kg");
        weight = 30;
        return weight;
    }

    public static int getAge(){
        return 21;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
