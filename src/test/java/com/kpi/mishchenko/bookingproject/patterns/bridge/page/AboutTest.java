package com.kpi.mishchenko.bookingproject.patterns.bridge.page;

import com.kpi.mishchenko.bookingproject.patterns.bridge.theme.DarkTheme;
import com.kpi.mishchenko.bookingproject.patterns.bridge.theme.Theme;
import org.junit.Test;

import static org.junit.Assert.*;

public class AboutTest {

    @Test
    public void setThemeDarkTheme() {
        Theme dark = new DarkTheme();
        About about = new About(dark);

        assertEquals("Dark Theme", about.getTheme().getColor());
    }

    @Test
    public void getTheme() {
    }

}