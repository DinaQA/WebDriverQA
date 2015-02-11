package com.company;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * Created by dina.knyr on 06.02.2015.
 */
@RunWith(JUnit4.class)

public class TestBase {

        public boolean testPassed;

        @Before
        public void init() {
            TestHelpers.init();
            TestHelpers.open();
            TestHelpers.driver.manage().window().maximize();
            testPassed = false;
        }

        @Rule
        public TestName name = new TestName();

        @After
        public void close() throws IOException {
            if (!testPassed) {
                File scrFile = ((TakesScreenshot) TestHelpers.driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + name.getMethodName() + ".png"));
            }
            TestHelpers.close();
        }
}
