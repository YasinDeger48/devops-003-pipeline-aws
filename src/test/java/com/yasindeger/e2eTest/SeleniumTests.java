package com.yasindeger.e2eTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {


    @DisplayName("Selenium Sample Test")
    @Test
    public void simpleNavigationToGoogle(){
        String a = "a";
        String b = "b";
        assertEquals("ab",a.concat(b));

    }
}
