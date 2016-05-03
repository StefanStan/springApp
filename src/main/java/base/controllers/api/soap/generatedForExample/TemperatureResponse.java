
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
 *         &lt;element name="Fahrenheit" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "fahrenheit"
})
@XmlRootElement(name = "TemperatureResponse", namespace = "http://www.example.org/TemperatureRequest")
public class TemperatureResponse {

    @XmlElement(name = "Fahrenheit", namespace = "http://www.example.org/TemperatureRequest")
    protected int fahrenheit;

    /**
     * Gets the value of the fahrenheit property.
     * 
     */
    public int getFahrenheit() {
        return fahrenheit;
    }

    /**
     * Sets the value of the fahrenheit property.
     * 
     */
    public void setFahrenheit(int value) {
        this.fahrenheit = value;
    }

}
