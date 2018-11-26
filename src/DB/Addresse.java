package DB;

import javax.persistence.Embeddable;

@Embeddable
public class Addresse{
    String zipCode;

    public Addresse(){}

    public Addresse(String zipCode) {
        this.zipCode = zipCode;
    }
}
