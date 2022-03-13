package lab3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Queue<T> {
    final int maxSize = 45;
    LinkedList<T> queueList = new LinkedList<>();

    public void add(T obj){
        if (queueList.size() < maxSize){
            queueList.add(obj);
        }
        else {
            System.out.println("Очередь переполнена");
        }

    }

    public T get() throws QueueEmpty {
        T queueReturn;

        if (queueList.size() > 0) {
            queueReturn = queueList.get(0);
            queueList.remove(0);
            return queueReturn;
        }
        else {
            throw new QueueEmpty();
        }
    }

    public Queue<? extends CountryRussia> produce(){
        Queue<CountryRussia> queueUpperBound = new Queue<>();
        for (int i = 0; i <= queueList.size() - 1; i++){
            if(queueList.get(i) instanceof CountryRussia){
                queueUpperBound.add((CountryRussia) queueList.get(i));
            }
        }
        return queueUpperBound;
    }

    public static Queue<? super ClubCska> consume(Queue<? extends CountryRussia> queueUpperBound){
        Queue<CountryRussia> queueLowerBound = new Queue<>();
        Class<? extends CountryRussia> tmp;
        ArrayList<Class<? super ClubCska>> arrayClasses = new ArrayList<>();
        Class<ClubCska> clubCskaClass = ClubCska.class;
        Class<? super ClubCska> tmpClass = clubCskaClass.getSuperclass();

        while(!(tmpClass.equals(ConfUefa.class))){
            arrayClasses.add(tmpClass);
            tmpClass = tmpClass.getSuperclass();
        }
        arrayClasses.add(tmpClass);

        for (int i = 0; i < queueUpperBound.queueList.size(); i++){
            tmp = queueUpperBound.queueList.get(i).getClass();
            if(arrayClasses.contains(tmp)){
                queueLowerBound.add(queueUpperBound.queueList.get(i));
            }
        }
        return queueLowerBound;
    }
}