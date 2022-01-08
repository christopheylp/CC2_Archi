package org.cc2.exposition;

import org.cc2.application.retrieve_providers.RetrieveProvider;
import org.cc2.application.retrieve_providers.RetrieveProviderHandler;
import org.cc2.application.retrieve_workmans.RetrieveWorkman;
import org.cc2.application.retrieve_workmans.RetrieveWorkmanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkmanController {
    private final RetrieveWorkmanHandler retrieveWorkmanHandler;

    @Autowired
    private WorkmanController(RetrieveWorkmanHandler retrieveWorkmanHandler) {
        this.retrieveWorkmanHandler = retrieveWorkmanHandler;
    }

    @GetMapping(value = "/workmans/all")
    public String getAll() {
        return retrieveWorkmanHandler.handle(new RetrieveWorkman()).toString();
    }
}
