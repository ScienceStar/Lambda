package father;

public class Father {

    private String userName;
    private Integer userAge;

    public void func1(){
        func2();
    }

    public void func2(){
        System.out.println("AAAAAAAAA");
    }
    public void say(){
        System.out.println(userName+"is sayIng.......");
    }

    public void sayVoice(){
        System.out.println("父亲在说话............");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
