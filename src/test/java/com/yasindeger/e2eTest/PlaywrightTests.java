package com.yasindeger.e2eTest;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlaywrightTests {
    private static Page page;
    private static Browser browser;
    private static Playwright playwright;
    boolean isCloud = false;

    @BeforeEach
    public void beforeEach(){
        String workspace = System.getenv("WORKSPACE");

        if (workspace != null && new File(workspace).exists()) {
            System.out.println("Cloud environment");
            isCloud = true;
        } else {
            System.out.println("Local environment");
        }
        if(!isCloud) {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
            );
            page = browser.newPage();
        }
    }


    @DisplayName("Test 1")
    @Test
    public void test1(){
        if(!isCloud) {
            page.navigate("http://docker.com");
            System.out.println(page.title());
            assertEquals("Docker: Accelerated Container Application Development",
                    page.title());
            page.close();
            playwright.close();
        }
    }

    @DisplayName("Test 2")
    @Test
    public void test2(){
        if(!isCloud) {
            page.navigate("http://kubernetes.io");
            System.out.println(page.title());
            assertEquals("Kubernetes",
                    page.title());
            page.close();
            playwright.close();
        }
    }



}
