import java.util.Scanner;

public class Calculator {
    public int num1, num2, op;

    public int addNums(int n1, int n2)
    {
        return n1 + n2;
    }
    public int subtractNums(int n1, int n2)
    {
        return n1 - n2; 
    }
    public int multiplyNums(int n1, int n2)
    {
        return n1 * n2; 
    }
    public float divideNums(int n1, int n2)
    {
        return n1/n2; 
    }

    public int calcMod(int n1, int n2)
    {
        return n1%n2; 
    }
    public static void main (String[] args) {
        Calculator c = new Calculator();

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the calculator!");
        do {
            System.out.println("0. Exit 1.Addition 2. Subtraction 3.Multiplication 4.Division 5.Remainder ");
            System.out.println("Chose an operation(1-5): ");
            c.op = scan.nextInt();

            if (c.op == 0){
                System.out.println("Exiting.");
                break;
            } else{
                System.out.println("enter first number: ");
                c.num1 = scan.nextInt();
                System.out.println("enter second number: ");
                c.num2 = scan.nextInt();

                float result = 0;

            switch(c.op){
                case 1:
                    result = c.addNums(c.num1, c.num2);
                    break;
                case 2:
                    result = c.subtractNums(c.num1, c.num2);
                    break;
                case 3:
                    result = c.multiplyNums(c.num1, c.num2);
                    break;
                case 4:
                    result = c.divideNums(c.num1, c.num2);
                    break;
                case 5:
                    result = c.calcMod(c.num1, c.num2);
                    break;
                default:
                    System.out.println("Invalid operation");
                    continue;
            }

            System.out.println("result: " + result);
            }
            
        } while (c.op != 0);
        
        scan.close();

    } 
        
    
}
