package chap5.inheritance.challenge;

public class Test{
    public static void main(String[] args) {
        Employee kim = new Employee("김철수", "11/11/1985", "01/01/2020");

        System.out.println(kim);
        System.out.println("Age = " + kim.getAge());
        System.out.println("pay = " + kim.collectPay());

        SalariedEmployee joe = new SalariedEmployee("조영희", "12/12/1986", "01/01/2020", 35000);
        System.out.println(joe);
        System.out.println("Joe's paycheck = $" + joe.collectPay());

        joe.retire();
        System.out.println("Joe's Pension check = $" + joe.collectPay());

        HourlyEmployee lee = new HourlyEmployee("이영희", "12/12/1986", "01/01/2020", 15);
        System.out.println(lee);
        System.out.println("Lee's paycheck = $" + lee.collectPay());
        System.out.println("Lee's holiday paycheck = $" + lee.getDoublePay());
    }
}
