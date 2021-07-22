package psa.hours;

import java.util.ArrayList;
import java.util.List;


public class Proyect {
    private final Integer proyectID;
    private final String description = "";
    private List<Task> tasks = new ArrayList<>();

    public Proyect(Integer proyectID) {
        this.proyectID = proyectID;
    }

    public Integer getID() {
        return this.proyectID;
    }
}