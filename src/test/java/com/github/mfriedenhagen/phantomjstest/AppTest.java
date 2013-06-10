package com.github.mfriedenhagen.phantomjstest;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Rule
    public WebDriverRule rule = new PhantomJSDriverRule();
//    public WebDriverRule rule  = new FirefoxDriverRule();

    final WebDriver driver = rule.getDriver();

    @Test
    public void gotoHomePage() throws InterruptedException {
        driver.get("http://huschteguzzel.de/hudson/");
        assertEquals("All [Jenkins]", driver.getTitle());
        driver.findElement(By.partialLinkText("oneandone-ono-artifactory-shared")).click();
    }

}
