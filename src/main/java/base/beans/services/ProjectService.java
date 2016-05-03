package base.beans.services;

import base.beans.entities.Project;

/**
 * Created by StefanS on 26.04.2016.
 */
public interface ProjectService extends GenericService<Project, Integer> {

    Project saveProject(Project project);

    void deleteProjectById(int id);

    Project updateProjectById(int id, Project project);
}
