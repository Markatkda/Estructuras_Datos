package ListasEnlazadas;

import java.util.Objects;

public class Persona {

    //ATTRIBUTES
    private String name;
    private String id;

    //CONSTRUCTOR
    public Persona(String name, String id) {
        this.name = name;
        this.id = id;
    }

    //VOID CONSTRUCTOR
    public Persona() {
    }

    //GETTERS ET SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(name, persona.name) && Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
