package jdbc.model;

import java.util.Objects;

public class Furniture {

    private int id;
    private String name;
    private String href;

    public Furniture(int id, String name, String href) {
        this.id = id;
        this.name = name;
        this.href = href;
    }

    public Furniture() {
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
        Furniture furniture = (Furniture) o;
        return id == furniture.id && Objects.equals(name, furniture.name) && Objects.equals(href, furniture.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, href);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
