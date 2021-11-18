package com.kpi.mishchenko.bookingproject.patterns.bridge.page;

import com.kpi.mishchenko.bookingproject.patterns.bridge.theme.DarkTheme;
import com.kpi.mishchenko.bookingproject.patterns.bridge.theme.LightTheme;
import com.kpi.mishchenko.bookingproject.patterns.bridge.theme.Theme;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebPageTest {

    @Test
    public void setTheme_DarkTheme_CallSetThemeWithSuccessfulSetting() {
        Theme theme = new DarkTheme();
        final String expectedColor = theme.getColor();

        About aboutActual = new About();
        aboutActual.setTheme(theme);

        Home homeActual = new Home();
        homeActual.setTheme(theme);

        assertEquals(expectedColor, aboutActual.getTheme().getColor());
        assertEquals(new DarkTheme(), aboutActual.getTheme());

        assertEquals(expectedColor, homeActual.getTheme().getColor());
        assertEquals(new DarkTheme(), homeActual.getTheme());
    }

    @Test
    public void setTheme_LightTheme_CallSetThemeWithSuccessfulSetting() {
        Theme theme = new LightTheme();
        final String expectedColor = theme.getColor();

        About aboutActual = new About();
        aboutActual.setTheme(theme);

        Home homeActual = new Home();
        homeActual.setTheme(theme);

        assertEquals(expectedColor, aboutActual.getTheme().getColor());
        assertEquals(new LightTheme(), aboutActual.getTheme());

        assertEquals(expectedColor, homeActual.getTheme().getColor());
        assertEquals(new LightTheme(), homeActual.getTheme());
    }

    @Test
    public void getTheme_DarkTheme_CallGetThemeWithSuccessfulGetting() {
        Theme theme = new DarkTheme();

        About about = new About(theme);
        Home home = new Home(theme);

        assertEquals(new About(new DarkTheme()), about);
        assertEquals(new Home(new DarkTheme()), home);
    }

    @Test
    public void getTheme_LightTheme_CallGetThemeWithSuccessfulGetting() {
        Theme theme = new DarkTheme();

        About about = new About(theme);
        Home home = new Home(theme);

        assertEquals(new About(new LightTheme()), about);
        assertEquals(new Home(new LightTheme()), home);
    }

}