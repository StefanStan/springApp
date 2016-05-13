package Model.Terms;

/**
 * Created by StefanS on 13.05.2016.
 */
public class Sha2EncryptedTerm implements EncryptionInterface {

    private EncryptedTerm encryptedTerm;
    private Sha2EncryptionVersion sha2EncryptionVersion;

    private Sha2EncryptedTerm(EncryptedTerm encryptedTerm, Sha2EncryptionVersion version) {

        this.encryptedTerm = encryptedTerm;
        this.sha2EncryptionVersion = version;
    }

    public Sha2EncryptedTerm encryptSha2() {

        return sha2EncryptionVersion.doEncryption(encryptedTerm);
    }

    @Override
    public void doSmth() {

        encryptedTerm.doSmth();
    }

    private Term doSomeMagic(Term input) {

        return encryptedTerm;
    }
}
