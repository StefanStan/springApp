
package base.controllers.api.soap.generatedForExample;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Celsius" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "celsius"
})
@XmlRootElement(name = "TemperatureRequest", namespace = "http://www.example.org/TemperatureRequest")
public class TemperatureRequest {

    @XmlElement(name = "Celsius", namespace = "http://www.example.org/TemperatureRequest")
    protected int celsius;

    /**
     * Gets the value of the celsius property.
     * 
     */
    public int getCelsius() {
        return celsius;
    }

    /**
     * Sets the value of the celsius property.
     * 
     */
    public void setCelsius(int value) {
        this.celsius = value;
    }

}
