package tn.mss.mssIntern.modele;

import jakarta.persistence.*;
@Entity
@Table(name = "tutorials")
public class Tutorial{
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
   private String name ;
    private String description;
    public Tutorial() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
