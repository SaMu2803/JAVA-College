import java.util.*;

class MyDate {
    private int dd, mm, yy;

    public MyDate() {
        this.dd = 1;
        this.mm = 1;
        this.yy = 2000;
    }

    public MyDate(int dd, int mm, int yy) {
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }

    public void displayDate() {
        System.out.printf("%02d-%02d-%02d\n", dd, mm, yy);
    }
}

class MyNumber {
    private int number;

    public MyNumber() {
        this.number = 0;
    }

    public MyNumber(int number) {
        this.number = number;
    }

    public boolean isNegative() {
        return number < 0;
    }

    public boolean isPositive() {
        return number > 0;
    }

    public boolean isOdd() {
        return number % 2 != 0;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class Account {
    private int accno;
    private String accname;
    private double balance;

    public Account(int accno, String accname, double balance) {
        this.accno = accno;
        this.accname = accname;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("Acc No: " + accno + ", Acc Name: " + accname + ", Balance: " + balance);
    }

    // Static method to sort Account objects based on balance
    public static void sortAccounts(Account[] accounts) {
        Arrays.sort(accounts, Comparator.comparingDouble(Account::getBalance));
    }
}

class Person {
    private int id;
    private String name;
    private MyDate dob;
    private static int cnt = 1;

    public Person() {
        this.id = cnt++;
        this.name = "Unknown";
        this.dob = new MyDate();
    }

    public Person(String name, MyDate dob) {
        this.id = cnt++;
        this.name = name;
        this.dob = dob;
    }

    public void displayPersonDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Date of Birth: ");
        dob.displayDate();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Problem 1: Multiplication Table
        System.out.print("Enter a number for multiplication table: ");
        int num = sc.nextInt();
        System.out.println("Multiplication table for " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }

        // Problem 2: Reverse a Number
        System.out.print("Enter a number to reverse: ");
        num = sc.nextInt();
        int rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        System.out.println("Reversed Number: " + rev);

        // Problem 3: Sum of Elements of Array
        System.out.print("Enter number of elements in the array: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        int sum = 0;
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }
        System.out.println("Sum of array elements: " + sum);

        // Problem 4: MyDate Class
        MyDate date1 = new MyDate(25, 12, 2023);
        System.out.print("Default date: ");
        date1.displayDate();

        MyDate date2 = new MyDate();
        System.out.print("Enter date (dd mm yy): ");
        date2 = new MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.print("Entered date: ");
        date2.displayDate();

        // Problem 5: MyNumber Class
        System.out.print("Enter a number to perform tests: ");
        int number = sc.nextInt();
        MyNumber myNum = new MyNumber(number);
        System.out.println("isNegative: " + myNum.isNegative());
        System.out.println("isPositive: " + myNum.isPositive());
        System.out.println("isOdd: " + myNum.isOdd());
        System.out.println("isEven: " + myNum.isEven());

        // Problem 6: Employee Class
        Employee[] employees = new Employee[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter name and salary for Employee " + (i + 1) + ": ");
            employees[i] = new Employee(sc.next(), sc.nextDouble());
        }
        System.out.println("Employee Details:");
        for (Employee e : employees) {
            System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary());
        }

        // Problem 7: Account Class
        System.out.print("Enter number of accounts: ");
        int accountCount = sc.nextInt();
        Account[] accounts = new Account[accountCount];
        for (int i = 0; i < accountCount; i++) {
            System.out.print("Enter account no, name, balance for Account " + (i + 1) + ": ");
            accounts[i] = new Account(sc.nextInt(), sc.next(), sc.nextDouble());
        }
        Account.sortAccounts(accounts);
        System.out.println("Sorted Account Details:");
        for (Account acc : accounts) {
            acc.displayAccountDetails();
        }

        // Problem 8: Person Class
        System.out.print("Enter number of persons: ");
        int personCount = sc.nextInt();
        Person[] persons = new Person[personCount];
        for (int i = 0; i < personCount; i++) {
            System.out.print("Enter name and date of birth (dd mm yy) for Person " + (i + 1) + ": ");
            String personName = sc.next();
            MyDate personDob = new MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
            persons[i] = new Person(personName, personDob);
        }
        System.out.println("Person Details:");
        for (Person p : persons) {
            p.displayPersonDetails();
        }
    }
}
