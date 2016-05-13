package Model.Terms;

import Model.Keys.Key;

/**
 * Created by Ștefan Stan on 08.05.2014.
 */
public class EncryptedTerm extends Term implements EncryptionInterface {

    //<editor-fold desc="Static (fields, methods, and blocks)">
    public static final String encryptedTerm = CompoundTerm.compoundTerm + "(" + Key.key + ")";

    private Term term;
    private Key key;

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    @Override
    public void doSmth() {

        System.out.println("I do smth");
    }
}
