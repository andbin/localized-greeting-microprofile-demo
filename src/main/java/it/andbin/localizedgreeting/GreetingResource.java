/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Localized Greeting MicroProfile Demo" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.localizedgreeting;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Path("/")
@ApplicationScoped
public class GreetingResource {
    @Inject
    private GreetingService greetingService;

    @GET
    @Produces("text/plain;charset=UTF-8")
    public String greetingMessage(
            @Context HttpHeaders headers,
            @QueryParam("name") String name) {
        return greetingService.getGreetingMessage(headers.getAcceptableLanguages(), name);
    }
}
