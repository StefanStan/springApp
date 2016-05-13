package Model.Agents;

import Model.Protocol.Protocol;

import java.util.HashMap;

/**
 * Created by Ștefan Stan on 31.07.2014.
 */
public class Intruder extends Agent {

    private Protocol masterProtocol;
    private IntruderKnowledge masterKnowledge;

    private HashMap<Protocol, IntruderKnowledge> intruderKnowledge;

    //<editor-fold desc="Singleton methods">
    private static Intruder instance;

    /**
     * Constructor
     * @param name The name of the agent
     */
    private Intruder(String name){

        currentState = null;
        intruderKnowledge = new HashMap<>();
    }

    public static Intruder getInstance(){

        if(instance == null){

            synchronized (Intruder.class){

                if(instance == null){

                    instance = new Intruder("I");
                }
            }
        }

        return instance;
    }
    //</editor-fold>
}
