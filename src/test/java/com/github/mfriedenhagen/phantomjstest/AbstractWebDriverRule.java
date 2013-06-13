/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.mfriedenhagen.phantomjstest;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Mirko Friedenhagen
 */
public abstract class AbstractWebDriverRule implements WebDriverRule {

    protected final WebDriver driver;

    protected AbstractWebDriverRule(WebDriver driver) {
        this.driver = driver;
    }
    
    

    protected void before() throws Throwable {
    }

    protected void after() {
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                before();
                try {
                    base.evaluate();
                } catch (Throwable e) {
                    final String name = description.getClassName() + "." + description.getMethodName();
                    writeScreenshot(name);
                    writeSource(name);
                    throw e;
                } finally {
                    System.err.println("Last URL=" + driver.getCurrentUrl());
                    System.err.println("Last TITLE=" + driver.getTitle());
                    driver.quit();
                    after();
                }
            }

            private void writeScreenshot(String name) throws IOException {
                final File file = new File("target/" + name + ".png");
                Files.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), file);
                System.err.println("Wrote screenshot: " + name);
            }

            private void writeSource(String name) throws IOException {
                final File file = new File("target/" + name + ".html");
                Files.write(driver.getPageSource().getBytes(), file);
                System.err.println("Wrote source: " + name);
            }
        };
    }

    /**
     * @return the driver
     */
    @Override
    public WebDriver getDriver() {
        return driver;
    }
    
}
