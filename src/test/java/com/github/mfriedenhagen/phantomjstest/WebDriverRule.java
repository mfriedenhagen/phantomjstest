/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.mfriedenhagen.phantomjstest;

import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Mirko Friedenhagen
 */
public interface WebDriverRule extends TestRule {    
    public WebDriver getDriver();
}
