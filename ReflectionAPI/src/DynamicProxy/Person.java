package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface Person {
    void introduce(String name);
    void sayAddress(String city, String country);
    void sayCareer(String career);
}
class Man implements Person{
    private String name;
    private String city;
    private String country;
    private String career;

    public Man(String name, String city, String country, String career) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.career = career;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    @Override
    public void introduce(String name) {
        System.out.printf("My name is %s.", name);
    }
    @Override
    public void sayAddress(String city, String country) {
        System.out.printf("I am coming from %s in %s.", city, country);
    }
    @Override
    public void sayCareer(String career) {
        System.out.printf("My career is %s", career);
    }
}
class invoker implements InvocationHandler {
    Person person;
    public invoker(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Hello!");
        return method.invoke(person, args);
    }
}
class Main{
    public static void main(String[] args) {
        Man yerf = new Man("Yerf", "Kisumu", "Kenya", "Software Engineer");
        ClassLoader yerfClassLoader = yerf.getClass().getClassLoader();
        Class<?>[] interfaces = yerf.getClass().getInterfaces();
        Person proxyYerf = (Person) Proxy.newProxyInstance(yerfClassLoader, interfaces, new invoker(yerf));
        proxyYerf.introduce(yerf.getName());
    }
}