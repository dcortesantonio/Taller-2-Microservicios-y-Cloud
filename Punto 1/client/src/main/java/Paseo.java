import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement
public class Paseo {

    private int id;
    private String name;
    private String origin;
    private String destination;
    private Date date;

    public Paseo() {
    }

    public Paseo(int id, String name, String origin, String destination, Date date) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Paseo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
