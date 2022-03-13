package lab3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<ConfUefa> queueTest = new Queue<>();
        Queue<? extends CountryRussia> queueUpperBound;
        Queue<? super ClubCska> queueLowerBound = new Queue<>();
        ArrayList<ConfUefa> arrayClasses;

        arrayClasses = getArrayClasses();


        for (ConfUefa obj : arrayClasses){
            queueTest.add(obj);
        }

        queueTest.add(new Gassaniga());
        queueTest.add(new Gassaniga());
        queueTest.add(new Gassaniga());
        System.out.println();

        queueUpperBound = queueTest.produce();
        queueLowerBound = Queue.consume(queueUpperBound);

        for (int i = 0; i <= 45; i++){
            try{
                System.out.println((queueTest.get()));
            }
            catch (QueueEmpty e){
                System.out.println(e);
            }
        }

        System.out.println("==================================\n\n");

        while (queueUpperBound.queueList.size() > 0) {
            try{
                System.out.println((queueUpperBound.get()));
            }
            catch (QueueEmpty e){
                System.out.println(e);
            }
        }
        System.out.println("==================================\n\n");

        while (queueLowerBound.queueList.size() > 0) {
            try{
                System.out.println((queueLowerBound.get()));
            }
            catch (QueueEmpty e){
                System.out.println(e);
            }
        }
    }


    public static ArrayList<ConfUefa> getArrayClasses(){
        ArrayList<ConfUefa> arrayClasses = new ArrayList<>();
        arrayClasses.add(new ConfUefa());

        arrayClasses.add(new CountryRussia());
        arrayClasses.add(new CountryEngland());

        arrayClasses.add(new LeagueEngPremiere());
        arrayClasses.add(new LeagueEngChamp());
        arrayClasses.add(new LeagueRusPremiere());
        arrayClasses.add(new LeagueRusOne());

        arrayClasses.add(new ClubChelsea());
        arrayClasses.add(new ClubLiverpool());
        arrayClasses.add(new ClubFulham());
        arrayClasses.add(new ClubCska());
        arrayClasses.add(new ClubZenit());
        arrayClasses.add(new ClubEnisey());

        arrayClasses.add(new PlayersChelsea());
        arrayClasses.add(new PlayersLiverpool());
        arrayClasses.add(new PlayersFulham());
        arrayClasses.add(new PlayersCska());
        arrayClasses.add(new PlayersZenit());
        arrayClasses.add(new PlayersEnisey());

        arrayClasses.add(new GkEnisey());
        arrayClasses.add(new GkCska());
        arrayClasses.add(new GkLiverpool());
        arrayClasses.add(new GkChelsea());
        arrayClasses.add(new GkFulham());
        arrayClasses.add(new GkZenit());

        arrayClasses.add(new MidfieldEnisey());
        arrayClasses.add(new MidfieldCska());
        arrayClasses.add(new MidfieldLiverpool());
        arrayClasses.add(new MidfieldChelsea());
        arrayClasses.add(new MidfieldFulham());
        arrayClasses.add(new MidfieldZenit());

        arrayClasses.add(new Akinfeev());
        arrayClasses.add(new Alisson());
        arrayClasses.add(new Gassaniga());
        arrayClasses.add(new Kritsyuk());
        arrayClasses.add(new Torop());
        arrayClasses.add(new Kepa());
        arrayClasses.add(new Oparin());

        arrayClasses.add(new Wilson());
        arrayClasses.add(new Tiago());
        arrayClasses.add(new Kuzyaev());
        arrayClasses.add(new Kante());
        arrayClasses.add(new Dzagoev());
        arrayClasses.add(new Lomakin());

        return arrayClasses;
    }
}
