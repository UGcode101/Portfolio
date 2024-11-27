package org.launchcode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project name is required")
    @Size(max = 255, message = "Project name must be less than 255 characters")
    @Column(nullable = false)
    private String name;

    @Size(max = 1000, message = "Description must be less than 1000 characters")
    @Column(length = 1000)
    private String description;

    @Size(max = 500, message = "Technologies used must be less than 500 characters")
    @Column(name = "technologies_used")
    private String technologiesUsed;

    @Size(max = 500, message = "GitHub link must be less than 500 characters")
    @Column(name = "github_link")
    private String githubLink;

    @Size(max = 500, message = "Demo link must be less than 500 characters")
    @Column(name = "demo_link")
    private String demoLink;

    @Column(name = "project_date")
    private LocalDate projectDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectType type;

    // Enum for project categorization
    public enum ProjectType {
        WEB_APPLICATION,
        MOBILE_APP,
        DATA_SCIENCE,
        BACKEND,
        FULL_STACK
    }
}