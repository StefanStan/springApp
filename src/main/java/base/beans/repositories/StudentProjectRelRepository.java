package base.beans.repositories;

import base.beans.entities.Project;
import base.beans.entities.Student;
import base.beans.entities.StudentProjectRel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by StefanS on 11.05.2016.
 */
@Transactional
public interface StudentProjectRelRepository extends GenericRepository<StudentProjectRel, Integer> {

    @Transactional
    @Modifying
    @Query("insert into StudentProjectRel (student, project, rank) select s, p, 0 from Student s, Project p where s =:student and p =:project")
    void assignProjectToStudent(@Param("project") Project project, @Param("student") Student student);

    @Modifying
    @Query("select o from StudentProjectRel o where o.project.id =:projId")
    List<StudentProjectRel> getStudentsOfProject(@Param("projId") int projId);

    @Transactional
    @Modifying
    @Query("delete from StudentProjectRel o where o.project =:project and o.student =:student")
    void deleteStudentFromProjectList(@Param("project") Project project, @Param("student") Student student);
}
