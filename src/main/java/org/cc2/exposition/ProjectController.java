package org.cc2.exposition;

import org.cc2.application.retrieve_projects.RetrieveProject;
import org.cc2.application.retrieve_projects.RetrieveProjectHandler;
import org.cc2.domain.Project;
import org.cc2.domain.ProjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {

    private final RetrieveProjectHandler retrieveProjectHandler;

    @Autowired
    private ProjectController(RetrieveProjectHandler retrieveProjectHandler) {
        this.retrieveProjectHandler = retrieveProjectHandler;
    }

    @GetMapping(value = "/projects/all")
    public String getAll() {
        return retrieveProjectHandler.handle(new RetrieveProject()).toString();
    }
}
