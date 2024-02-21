package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EmployeeList<BasicWorker> implements Iterable<BasicWorker> {
    BasicWorker[] workersList;

    public EmployeeList(BasicWorker[] workersList) {
        this.workersList = workersList;
    }

    class EmployeeListIterator implements Iterator<BasicWorker> {
        int current = 0;

        @Override
        public boolean hasNext() {
            if (current < EmployeeList.this.workersList.length) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public BasicWorker next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return workersList[current++];
        }
    }

    public BasicWorker get(int index) {
        return workersList[index];
    }

    public void set(int index, BasicWorker value) {
        workersList[index] = value;
    }

    public int length() {
        return workersList.length;
    }


    @Override
    public Iterator<BasicWorker> iterator() {
        return new EmployeeListIterator();
    }
}
