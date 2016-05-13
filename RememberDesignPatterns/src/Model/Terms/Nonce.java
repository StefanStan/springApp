package Model.Terms;

import Model.Agents.Agent;

/**
 * Created by Ștefan Stan on 08.05.2014.
 */
public class Nonce extends Term {

    //<editor-fold desc="Static (fields, methods, and blocks)">
    public static final String nonce = "N_[A-Z]_[1-9][0-9]*";

    private Agent agent;
    private int nr;
}
