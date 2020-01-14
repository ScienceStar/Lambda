package service;

/**
 * @author lxc
 * @Title: ICaculate
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/14 9:14
 */
@FunctionalInterface
public interface ICaculate {
    public int getResult(int a,int b,int c,int d);

    public static int getResult1(int a,int b,int c,int d){
        int result = a+b+c+d;
        return result;
    }

    public static int getResult2(int a,int b,int c,int d){
        int result = a+b+2*c+d;
        System.out.println(result );
        return result;
    }

    public static int getResult3(int a,int b,int c,int d){
        int result = 2*a+b+2*c+d;
        System.out.println(result );
        return result;
    }

    public static void print(String s){
        System.out.println(s);
    }
}
