package Model.Keys;

import Model.Agents.Agent;

/**
 * Created by Ștefan Stan on 08.05.2014.
 */
public class SharedKey extends Key {

    //<editor-fold desc="Static (fields, methods, and blocks)">
    public static final String sharedKey = "K\\(([A-Z])\\.([A-Z])\\)";

    private Agent firstAgent;
    private Agent secondAgent;
}
