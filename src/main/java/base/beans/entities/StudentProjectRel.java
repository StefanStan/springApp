package base.beans.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Stefan Stan on 01/12/15.
 */
@Entity
@Table(name = "student_project_rels",
    uniqueConstraints = {
            @UniqueConstraint(columnNames = {"student_id", "project_id"})
    })
public class StudentProjectRel implements Serializable {

    @Column(name = "id", unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    private Project project;

    @Column(name = "rank", nullable = false)
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Student getStudent() {

        return student;
    }

    public void setStudent(Student student) {

        this.student = student;
    }

    public Project getProject() {

        return project;
    }

    public void setProject(Project project) {

        this.project = project;
    }
}