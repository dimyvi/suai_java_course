class Int{
    private int number = 0;

    public Int(int number){
        this.number = number;
    }

    public void increment(){
        number += 1;
    }

    public void decrement(){
        number -= 1;
    }

    public void add(Int n){
        number += n.number;
    }


    public void substract(Int n){
        number -= n.number;
    }

    public void MyMethod(Int n){
        int t = this.number;

        for (int i = 1; i < n.number; i++){
            this.number += t;
        }
    }

    @Override
    public String toString(){
        return Integer.toString(number);
    }
}

public class int_lab1{
    public static void main (String args[]){
        Int a = new Int(1);
        Int b = new Int(1);
        Int c = new Int(1);

        b.increment();

        for (int i = 0; i < 10; i++) {
            b.add(b);
        }

        a.add(b);

        for (int i = 0; i < 24; i++){
            c.increment();
        }

        a.substract(c);

        System.out.println(a);



        Int x = new Int(10);
        Int y = new Int(5);

        x.MyMethod(y);
        System.out.println(x);
    }
}