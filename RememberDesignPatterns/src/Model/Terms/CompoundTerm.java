package Model.Terms;

import Model.Container;
import Model.Iterator;

import java.util.ArrayList;

/**
 * Created by Ștefan Stan on 08.05.2014.
 */
public class CompoundTerm extends Term implements Container {

    //<editor-fold desc="Static (fields, methods, and blocks)">
    static final String compoundTerm = "\\{(.*)\\}";

    private ArrayList<Term> components;

    @Override
    public Iterator createIterator() {

        return new CompoundTermIterator();
    }

    private class CompoundTermIterator implements Iterator {

        private int index;

        CompoundTermIterator() {

            this.index = 0;
        }

        @Override
        public boolean hasNext() {

            return index < components.size();
        }

        @Override
        public Object next() {

            if(this.hasNext()) {

                return components.get(index);
            }

            return null;
        }
    }
}
