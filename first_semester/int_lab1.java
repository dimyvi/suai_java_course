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
        Int a = new Int(0);
        Int b = new Int(0);
        Int c = new Int(0);

        b.increment();

        for (int i = 0; i < 10; i++) {
            b.add(b);
        }

        a.add(b);

        for (int i = 0; i < 24; i++){
            c.increment();
        }

        a.substract(c);

        System.out.println("first" + "=" + a);



        Int x = new Int(1011);
        Int y = new Int(53);

        x.MyMethod(y);
        System.out.println("second" + "=" + x);
    }
}