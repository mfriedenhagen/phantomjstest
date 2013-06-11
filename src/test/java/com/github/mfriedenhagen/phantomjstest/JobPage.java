/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.mfriedenhagen.phantomjstest;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Mirko Friedenhagen
 */
public class JobPage {

    private final WebDriver driver;
    private final String name;
    private final By changesLink = By.xpath("//a[@href='changes']");
    
    private JobPage(WebDriver driver, String name) {
        this.driver = driver;
        this.name = name;        
    }
    
    public static JobPage create(WebDriver driver, String name) {
        final JobPage jobPage = new JobPage(driver, name);
        assertEquals(name + " [Jenkins]", driver.getTitle());
        assertTrue(jobPage.hasChangesLink());
        return jobPage;
    }
    
    public boolean hasChangesLink() {
        return driver.findElements(changesLink).size() > 0;
    }
}
