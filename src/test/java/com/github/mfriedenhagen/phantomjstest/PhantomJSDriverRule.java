/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.mfriedenhagen.phantomjstest;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author Mirko Friedenhagen
 */
public class PhantomJSDriverRule extends AbstractWebDriverRule {
    final static DesiredCapabilities CAPS = new DesiredCapabilities();
    
    static {
        CAPS.setJavascriptEnabled(true);
        CAPS.setCapability("takesScreenshot", true);
    }

    public PhantomJSDriverRule() {
        super(new PhantomJSDriver(CAPS));
    }

}
