import java.util.*;

class SortedIntegerList{
    private LinkedList<Integer> list;
    private boolean Dublicate;

    public SortedIntegerList(boolean Dublicate){
        this.list = new LinkedList<>();
        this.Dublicate = Dublicate;
    }

    public void add(int number) {
        ListIterator<Integer> iter = list.listIterator();

        while (iter.hasNext()){
            int current = iter.next();

            if (current > number) { 
                iter.previous(); 
                iter.add(number);
                return;    
            }
            if (!Dublicate && current == number){
                return;
            }
            
            }
        iter.add(number);
        }
    


    public void remove(int value){
        ListIterator<Integer> iter = list.listIterator();

        while (iter.hasNext()){
            int current = iter.next();

            if (current == value){
                iter.remove();
                return;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        ListIterator<Integer> iter = list.listIterator();

        if (this == obj){
            return true;
        }

        if (!(obj instanceof SortedIntegerList)){
            return false;
        }

        SortedIntegerList other = (SortedIntegerList) obj; 
        
        Iterator<Integer> iter1 = this.list.iterator();
        Iterator<Integer> iter2 = this.list.iterator(); 
        
        while (iter1.hasNext() && iter2.hasNext()) {
            if (!iter1.next().equals(iter2.next())) {
                return false;
            }
        }

        return true;
    }

        public void print() {
        System.out.println(list);
    }
}


public class LinkedList_lab3{
    public static void main (String args[]){
          SortedIntegerList list1 = new SortedIntegerList(true);
        list1.add(5);
        list1.add(3);
        list1.add(5);
        list1.add(1);
        System.out.print("С дубликатами: ");
        list1.print();

        SortedIntegerList list2 = new SortedIntegerList(false);
        list2.add(5);
        list2.add(3);
        list2.add(5);
        list2.add(1);
        System.out.print("Без дубликатов: ");
        list2.print();


        list2.remove(3);
        System.out.print("После удаления 3: ");
        list2.print();

        SortedIntegerList list3 = new SortedIntegerList(true);
        list3.add(1);
        list3.add(5);
        System.out.println(list2.equals(list3));
    }
}