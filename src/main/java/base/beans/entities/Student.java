package base.beans.entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@Entity
@Table(name = "students")
@ManagedBean(name = "studentBean")
@RequestScoped
public class Student implements Comparable{

   @Column(name = "id")
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;

   @Column(name = "name", nullable = false)
   private String name;

   @Column(name = "email", unique = true, nullable = false)
   private String email;

   public int getId() {
      return id;
   }

   public void setId(final int id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   @Override
   public String toString() {
      return name;
   }

   public String getName() {
      return name;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public int compareTo(Object o) {

      Student student = (Student) o;

      return this.name.compareTo(student.name);
   }

   public boolean isValid() {

      return name != null && email != null;
   }
}
