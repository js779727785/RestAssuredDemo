package JavaConcepts;

/**
 * https://blog.csdn.net/wumingxiaoyao/article/details/119714528
 * 静态成员只跟类相关，跟类实例对象不相关。
 * 使用静态成员不用初始化类（创建一个类的实例对象）
 * 这是因为所有的静态成员会随着该类加载到内存时一并加载到内存中，而非静态成员是在类实例化对象时才加载到内存。
**/

public class StaticMembers {

    // Static variable
    public static String name = "Selenium";

    // Non static variable
    public int version = 3;

    // Static method
    public static void printName()
    {
        System.out.println("Name is :"+name);
    }

    // Non static method
    public void printVersion()
    {
        System.out.println("Version is : "+version);
    }


    public static void main(String[] args) {

        // Can call static members with class name
        System.out.println(StaticMembers.name);
        StaticMembers.printName();

        // Can not call non static members with class name
        //System.out.println(StaticMembers.version);
        //StaticMembers.printVersion();

        // Creating an object of class. We can call members using object name
        StaticMembers sm = new StaticMembers();

        // Calling static member with object is not recommended
        System.out.println(sm.name);
        sm.printName();

        // Object name should be used to call non static members of class
        System.out.println(sm.version);
        sm.printVersion();

    }
}
