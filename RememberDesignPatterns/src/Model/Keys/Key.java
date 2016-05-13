package Model.Keys;

import Model.Terms.Term;

/**
 * Created by Ștefan Stan on 08.05.2014.
 */
public abstract class Key extends Term {

    //<editor-fold desc="Static (fields, methods, and blocks)">
    public static final String key = PublicKey.publicKey + "|"
                                   + PrivateKey.privateKey + "|"
                                   + SharedKey.sharedKey + "|"
                                   + ShortTermKey.shortTermKey ;
}
