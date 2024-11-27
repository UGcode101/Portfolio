package org.launchcode.portfolio.repository;

import org.launchcode.portfolio.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    /**
     * Find all projects that contain a specific technology.
     * @param technology the technology to search for.
     * @return a list of projects containing the specified technology.
     */
    List<Project> findByTechnologiesUsedContainingIgnoreCase(String technology);

    /**
     * Find all projects by their type.
     * @param type the type of project.
     * @return a list of projects of the specified type.
     */
    List<Project> findByType(Project.ProjectType type);

    /**
     * Find all projects by their name containing a keyword.
     * @param name the keyword to search for in project names.
     * @return a list of projects with names containing the keyword.
     */
    List<Project> findByNameContainingIgnoreCase(String name);
}