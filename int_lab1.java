public class Int{
    private int number = 0;

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

    public String toString(){
        return Integer.toString(number);
    }
}

public class int_lab1{
    public static void main (String args[]){
        Int a = new Int();
        Int b = new Int();
        Int c = new Int();

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
    }
}