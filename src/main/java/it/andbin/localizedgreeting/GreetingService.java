/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Localized Greeting MicroProfile Demo" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.localizedgreeting;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;

import it.andbin.localizedgreeting.util.LocaleResolver;

@ApplicationScoped
public class GreetingService {
    public String getGreetingMessage(List<Locale> acceptableLocales, String name) {
        LocaleResolver localeResolver = new LocaleResolver(acceptableLocales, Locale.ENGLISH);

        ResourceBundle bundle = ResourceBundle.getBundle("messages",
                localeResolver.nextLocale(), localeResolver.createBundleControl());

        String greetingMessage = bundle.getString("greeting-message");

        if (name == null || name.trim().isEmpty()) {
            name = bundle.getString("anonymous-user");
        }

        MessageFormat format = new MessageFormat(greetingMessage);
        greetingMessage = format.format(new Object[] { name });
        return greetingMessage;
    }
}
