package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class HumanList<BasicWorker> implements Iterable {
    List<BasicWorker> myList = new ArrayList<>();

    public void addToMyList(BasicWorker worker) {
        myList.add(worker);
    }

    class IteratorHelper implements Iterator<BasicWorker> {
        int current = 0;

        @Override
        public boolean hasNext() {
            if (current < HumanList.this.myList.size()) {
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
            return myList.get(current++);
        }
    }


    @Override
    public Iterator iterator() {
        return new IteratorHelper();
    }
}
