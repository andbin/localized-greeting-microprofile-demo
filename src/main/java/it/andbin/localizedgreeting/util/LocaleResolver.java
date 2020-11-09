/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Localized Greeting MicroProfile Demo" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.localizedgreeting.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class LocaleResolver {
    private List<Locale> locales;

    public LocaleResolver(List<Locale> acceptableLocales, Locale defaultLocale) {
        locales = new ArrayList<>();

        if (acceptableLocales != null) {
            for (Locale locale : acceptableLocales) {
                if (Objects.equals(locale.getLanguage(), "*")) {
                    if (defaultLocale != null) {
                        locales.add(defaultLocale);
                    }
                } else {
                    locales.add(locale);
                }
            }
        }

        if (defaultLocale != null && !locales.contains(defaultLocale)) {
            locales.add(defaultLocale);
        }
    }

    public Locale nextLocale() {
        if (locales.size() > 0) {
            return locales.remove(0);
        } else {
            return null;
        }
    }

    public ResourceBundle.Control createBundleControl() {
        return new FallbackingBundleControl();
    }


    private class FallbackingBundleControl extends ResourceBundle.Control {
        @Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            return nextLocale();
        }
    }
}
