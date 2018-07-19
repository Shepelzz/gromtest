package lesson25;

public class Demo {
    public static void main(String[] args) throws Exception{
        GeneralDAO generalDAO = new GeneralDAO();
        Order order = new Order(1);

        generalDAO.validate(order);

        TestClass<String, String, Long> testClass = new TestClass<>();
        System.out.println(testClass.doSomething1("rrr"));

    }
}
