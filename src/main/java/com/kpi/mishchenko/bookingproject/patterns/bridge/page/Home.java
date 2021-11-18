package com.kpi.mishchenko.bookingproject.patterns.bridge.page;

import com.kpi.mishchenko.bookingproject.patterns.bridge.theme.DarkTheme;
import com.kpi.mishchenko.bookingproject.patterns.bridge.theme.Theme;

public class Home implements WebPage {

    private Theme theme;

    public Home() {};

    public Home(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public Theme getTheme() {
        return theme;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof Home;
    }

}
