package Model.Protocol;

import Model.Agents.Agent;
import Model.Keys.Key;
import Model.Terms.BasicTerm;
import Model.Terms.Nonce;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Ștefan Stan on 08.05.2014.
 */
public class Protocol implements Serializable {

    private String protocolDescription;
    private int currentAction;

    private HashMap<String, Agent> honestAgents;
    private HashMap<String, BasicTerm> basicTerms;
    private HashMap<String, Nonce> nonces;
    private HashMap<String, Key> shortTermKeys;
    private HashMap<String, Key> longTermKeys;

    /**
     * Private constructor. We can only instantiate a protocol using the methods provided by the API, for security reasons
     */
    private Protocol(String protocolDescription) {

        this.protocolDescription = protocolDescription;
        currentAction = -1;

        honestAgents = new HashMap<>();
        basicTerms = new HashMap<>();
        nonces = new HashMap<>();
        shortTermKeys = new HashMap<>();
        longTermKeys = new HashMap<>();
    }
}
