/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.mfriedenhagen.phantomjstest;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Mirko Friedenhagen
 */
public class FirefoxDriverRule extends AbstractWebDriverRule {

    public FirefoxDriverRule() {
        super(new FirefoxDriver());
    }
}
