package base.beans.services.spring_data;

import base.beans.entities.Project;
import base.beans.entities.Student;
import base.beans.entities.StudentProjectRel;
import base.beans.repositories.GenericRepository;
import base.beans.repositories.ProjectRepository;
import base.beans.repositories.StudentProjectRelRepository;
import base.beans.repositories.StudentRepository;
import base.exceptions.ConflictException;
import base.exceptions.NotFoundException;
import base.exceptions.NotModifiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StefanS on 25.04.2016.
 */
@Repository
@Service
public class StudentProjectRelServiceSpringDataImpl extends GenericServiceSpringDataImpl<StudentProjectRel, Integer> implements base.beans.services.StudentProjectRelService {

    @Autowired
    @Qualifier("studentProjectRelRepository")
    private StudentProjectRelRepository repository;

    @Autowired
    @Qualifier("projectRepository")
    private ProjectRepository projectRepository;

    @Autowired
    @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Override
    public GenericRepository getRepository() {

        return repository;
    }

    @Override
    public void assignStudentToProject(int studId, int projId) {

        Student student = studentRepository.findOne(studId);
        if(student == null) {

            throw new NotFoundException();
        }

        Project project = projectRepository.findOne(projId);
        if(project == null) {

            throw new NotFoundException();
        }


        List<Student> students = new ArrayList<>();
        repository.getStudentsOfProject(projId).forEach((elem) -> students.add(elem.getStudent()));

        if(students.size() >= project.getCapacity()) {

            throw new ConflictException();
        }

        try {
            repository.assignProjectToStudent(project, student);
        } catch (Exception exc) {

            throw new NotModifiedException();
        }
    }

    @Override
    public List<Student> getStudentsOfProject(int projId) {

        if(projectRepository.findOne(projId) == null) {

            throw new NotFoundException();
        }

        List<Student> result = new ArrayList<>();

        repository.getStudentsOfProject(projId).forEach((value) -> result.add(value.getStudent()));
        return result;
    }

    @Override
    public void deleteStudentFromProjectList(int studId, int projId) {

        Student student = studentRepository.findOne(studId);
        if(student == null) {

            throw new NotFoundException();
        }

        Project project = projectRepository.findOne(projId);
        if(project == null) {

            throw new NotFoundException();
        }

        try {
            repository.deleteStudentFromProjectList(project, student);
        } catch (Exception exc) {

            throw new NotFoundException();
        }
    }
}
