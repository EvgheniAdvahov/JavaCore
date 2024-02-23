package org.example;

import java.util.Arrays;
import java.util.Iterator;

public class WorkerList implements Iterable<BasicWorker> {
    private BasicWorker[] myWorkerLists = {
            new Freelancer("Alexandr", 45, "Cahul", 500),
            new Worker("Gregory", 35, "London", 85000),
            new Freelancer("Sergey", 19, "Moscow", 450),
            new Worker("Evgheni", 36, "Seatle", 300000)
    };


    @Override
    public Iterator<BasicWorker> iterator() {
        return Arrays.asList(myWorkerLists).iterator();
    }
}
