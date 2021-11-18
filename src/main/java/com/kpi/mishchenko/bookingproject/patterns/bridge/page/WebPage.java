package com.kpi.mishchenko.bookingproject.patterns.bridge.page;

import com.kpi.mishchenko.bookingproject.patterns.bridge.theme.Theme;

public interface WebPage {

    void setTheme(Theme theme);

    Theme getTheme();

}
