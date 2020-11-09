/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Localized Greeting MicroProfile Demo" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.localizedgreeting;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class GreetingApplication extends Application {
}
