package javeriana.edu.rest;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Date;

public class Paseo {

    @BsonProperty(value = "id")
    private int id;
    @BsonProperty(value = "name")
    private String name;
    @BsonProperty(value = "origin")
    private String origin;
    @BsonProperty(value = "destination")
    private String destination;
    @BsonProperty(value = "date")
    private Date date;

    public Paseo() {
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
