package Model.Agents;

import Model.Terms.Term;

/**
 * Created by Ștefan Stan on 08.05.2014.
 */
public class Agent extends Term {

    //<editor-fold desc="Static (fields, methods, and blocks)">
    public static final String agent = "[A-Z]";

    protected String name;
    protected State currentState;
}
