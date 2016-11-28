package com.qatestlab.calc;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCalcPage extends BaseTest{

    @Test
    public void testCalcPage() {

//        driver.get("https://twitter.com");
//        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Apps\")").click();
//        driver.findElementByClassName("android.widget.TextView").click();

        driver.findElementById("com.android2.calculator3:id/digit_2").click();
        driver.findElementById("com.android2.calculator3:id/op_add").click();
        driver.findElementById("com.android2.calculator3:id/digit_2").click();
        driver.findElementById("com.android2.calculator3:id/eq").click();
        String displayValue = driver.findElementById("com.android2.calculator3:id/formula").getText();
        System.out.println("display value is "+displayValue);
        assertEquals(displayValue,"4","display value is not 4");

    }
}
