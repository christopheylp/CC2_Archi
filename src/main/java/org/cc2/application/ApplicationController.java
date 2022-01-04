package org.cc2.application;

import org.cc2.domain.ProjectRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @RequestMapping("/projects")
    public String projects(){
        return "test";
    }
}
