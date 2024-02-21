package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<BasicWorker> workerList = new ArrayList<>();
        BasicWorker worker = new Freelancer("Alexandr", 45, "Cahul", 500);
        BasicWorker worker1 = new Worker("Gregory", 35, "London", 85000);
        BasicWorker worker2 = new Freelancer("Sergey", 19, "Moscow", 450);
        BasicWorker worker3 = new Worker("Evgheni", 36, "Seatle", 300000);

        workerList.add(worker);
        workerList.add(worker1);
        workerList.add(worker2);
        workerList.add(worker3);


        System.out.println(workerList);
        //Sort by age
        Collections.sort(workerList);
        System.out.println(workerList);


        //Iterable
        WorkerList listIterable = new WorkerList();
        for (BasicWorker basicWorker : listIterable) {
            System.out.println(basicWorker);
        }


    }
}