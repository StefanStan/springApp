package base.controllers.api.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by StefanS on 03.05.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sampleItem", namespace = "http://springApp.com/data/schemas")
public class SampleItem {
    //@XmlElement(name = "id", namespace = "http://springApp.com/data/schemas")
    private int id;
    //@XmlElement(name = "name", namespace = "http://springApp.com/data/schemas")
    private String name;

    public SampleItem() {
    }

    public SampleItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
