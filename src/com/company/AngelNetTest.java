package com.company;



import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by dina.knyr on 30.01.2015.
 */
@RunWith(JUnit4.class)

public class AngelNetTest {
    WebDriver webDriv;

        @Before //will be executed before each test
        public void Init() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "D:\\Java+SeleniumWebDriver\\chromedriver.exe");
            webDriv = new ChromeDriver();
            AngelNet.open(webDriv);
            Thread.sleep(1000);

        }

        @After // will be executed after each test
        public void Close(){

            webDriv.quit();
        }

        @Test //1. При пустом мастер пароле и заполненном сайте пароль генерится.
        public void ValidateEmptyMasterPass() throws InterruptedException {
            AngelNet.setMasterPass(webDriv, "");
            AngelNet.setSite(webDriv, "angel.net");
            AngelNet.generate(webDriv);

            AngelNet.assertPassword(webDriv, "");
        }

         @Test //2. При мастер пароле: asdasd и сайте: angel.net сгенеренный пароль: B9ya7yayeK/Zn@1a
         public void ValidateCorrectPass() throws InterruptedException {
            AngelNet.setMasterPass(webDriv, "asdasd");
            AngelNet.setSite(webDriv, "angel.net");
            AngelNet.generate(webDriv);

            AngelNet.assertPassword(webDriv, "B9ya7yayeK/Zn@1a" );
        }

    @Test //3. При мастер пароле: не asdasd и сайте: angel.net сгенеренный пароль: НЕ B9ya7yayeK/Zn@1a
    public void ValidateIncorrectPass() throws InterruptedException {
        AngelNet.setMasterPass(webDriv, AngelNet.passRandom());
        AngelNet.setSite(webDriv, "angel.net");
        AngelNet.generate(webDriv);
        AngelNet.assertPassword(webDriv, "B9ya7yayeK/Zn@1a");
    }

    //4. При заполнении мастер пароля и сайта всевозможными символами, они все оказываются введенными в поля.
    @Test
    public void ValidateAllSymbols() throws InterruptedException {
            String symbolMasterPass;
        symbolMasterPass = "aDіІЇЦjK19~!@#$%^&*)_+=-;:.,/?";
        AngelNet.setMasterPass(webDriv, symbolMasterPass);
        AngelNet.setSite(webDriv, symbolMasterPass);
        System.out.println("Master Password with all symbols");
        Assert.assertEquals(symbolMasterPass, AngelNet.getMasterPass(webDriv));
        System.out.println("Site name with all symbols");
        Assert.assertEquals(symbolMasterPass, AngelNet.getSite(webDriv));

    }
 //5. При заполнении мастер пароля 32 символами, и сайт 128 символами, они все оказываются введенными в поля.
 @Test
 public void ValidateMaxSymbols() throws InterruptedException {
     String symbolMasterPass;
     symbolMasterPass = AngelNet.passMax();
     String symbolSite;
     symbolSite = AngelNet.siteMax();

     AngelNet.setMasterPass(webDriv, symbolMasterPass);
     AngelNet.setSite(webDriv, symbolSite);
     System.out.println("Master Password with Max number of symbols");
     Assert.assertEquals(symbolMasterPass, AngelNet.getMasterPass(webDriv));
     System.out.println("Site name with Max number of symbols");
     Assert.assertEquals(symbolSite, AngelNet.getSite(webDriv));

 }

    @Test //6. перевірити чи сайт і мастер-пароль не порожні після генерації пароля
    public void ValidateSiteAndMasterPassAfterGenerate() throws InterruptedException {
        AngelNet.setMasterPass(webDriv, "asdasd");
        AngelNet.setSite(webDriv, "angel.net");
        AngelNet.generate(webDriv);

        System.out.println("Master Password is not empty");
        Assert.assertNotEquals("", AngelNet.getMasterPass(webDriv));
        System.out.println("Site is not empty");
        Assert.assertNotEquals("", AngelNet.getSite(webDriv));
    }

    @Test //7. перевірити чи активне поле мастер-пароль після генерації пароля
    public void ValidateMasterPassIsEnabled() throws InterruptedException {
        AngelNet.setMasterPass(webDriv, "asdasd");
        AngelNet.setSite(webDriv, "angel.net");
        AngelNet.generate(webDriv);

        Assert.assertTrue(AngelNet.checkMasterPass(webDriv));

    }

    @Test //8. перевірити чи активне поле  Site після генерації пароля
    public void ValidateSiteIsEnabled() throws InterruptedException {
        AngelNet.setMasterPass(webDriv, "asdasd");
        AngelNet.setSite(webDriv, "angel.net");
        AngelNet.generate(webDriv);

        Assert.assertTrue(AngelNet.checkSite(webDriv));

    }

    @Test //9. перевірити чи активне поле Password після генерації пароля
    public void ValidatePasswordIsEnabled() throws InterruptedException {
        AngelNet.setMasterPass(webDriv, "asdasd");
        AngelNet.setSite(webDriv, "angel.net");
        AngelNet.generate(webDriv);

        Assert.assertTrue(AngelNet.checkPassword(webDriv));

    }
}
