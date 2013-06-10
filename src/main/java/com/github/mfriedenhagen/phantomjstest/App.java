package com.github.mfriedenhagen.phantomjstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get("http://web.de");
        } finally {
            driver.close();
        }
        
    }
}
