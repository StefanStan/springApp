package Model.Agents;

import Model.Terms.Term;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ștefan Stan on 08.05.2014.
 */
public class State implements Serializable {

    private Agent owner;
    private ArrayList<Term> messages;
}
