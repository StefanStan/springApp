package base.beans.entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@Entity
@Table(name = "projects")
@ManagedBean(name = "projectBean")
@RequestScoped
public class Project implements Comparable{

   @Column(name = "id")
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int id;

   @Column(name = "name", unique = true, nullable = false)
   private String name;

   @Column(name = "capacity", nullable = false)
   private Double capacity;

   public String getName() {
      return name;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(final int id) {
      this.id = id;
   }

   public Double getCapacity() {
      return capacity;
   }

   public void setCapacity(final Double capacity) {
      this.capacity = capacity;
   }

   @Override
   public String toString() {
      return name;
   }

   @Override
   public int compareTo(Object o) {

      Project project = (Project) o;

      return this.name.compareTo(project.name);
   }

   public boolean isValid() {

      return name != null && capacity > 0;
   }
}
