package base.beans.repositories;

import base.beans.entities.Project;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by StefanS on 11.05.2016.
 */
@Transactional
public interface ProjectRepository extends GenericRepository<Project, Integer> {

}
