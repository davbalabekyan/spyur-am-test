package jdbc.model;

import java.util.Objects;

public class Hotel {

    private int id;
    private String name;
    private String href;

    public Hotel(int id, String name, String href) {
        this.id = id;
        this.name = name;
        this.href = href;
    }

    public Hotel() {
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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id == hotel.id && Objects.equals(name, hotel.name) && Objects.equals(href, hotel.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, href);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
