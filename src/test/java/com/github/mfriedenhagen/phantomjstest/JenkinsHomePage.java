/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.mfriedenhagen.phantomjstest;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.By;

/**
 *
 * @author Mirko Friedenhagen
 */
public class JenkinsHomePage {
    
    private static final String TITLE = "All [Jenkins]";
    private final WebDriver driver;

    private JenkinsHomePage(final WebDriver driver) {
        this.driver = driver;        
    }
    
    public JobPage gotoJobPage(String name) {
        driver.findElement(By.partialLinkText(name)).click();
        return JobPage.create(driver, name);
    }
    
    public static JenkinsHomePage create(final WebDriver driver) {
        final JenkinsHomePage jenkinsHomePage = new JenkinsHomePage(driver);
        assertEquals(TITLE, driver.getTitle());
        return jenkinsHomePage;
    }
}
