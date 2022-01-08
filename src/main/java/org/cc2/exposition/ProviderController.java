package org.cc2.exposition;

import org.cc2.application.retrieve_projects.RetrieveProject;
import org.cc2.application.retrieve_projects.RetrieveProjectHandler;
import org.cc2.application.retrieve_providers.RetrieveProvider;
import org.cc2.application.retrieve_providers.RetrieveProviderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    private final RetrieveProviderHandler retrieveProviderHandler;

    @Autowired
    private ProviderController(RetrieveProviderHandler retrieveProviderHandler) {
        this.retrieveProviderHandler = retrieveProviderHandler;
    }

    @GetMapping(value = "/providers/all")
    public String getAll() {
        return retrieveProviderHandler.handle(new RetrieveProvider()).toString();
    }
}
