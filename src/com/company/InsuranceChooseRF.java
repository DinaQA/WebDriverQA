package com.company;



import org.junit.Test;
/**
 * Created by Dina.Knyr on 09.02.2015.
 */

public class InsuranceChooseRF extends TestBase {

    @Test
    public void ValidateRegistrationTypes() throws InterruptedException {
        TestHelpers.click("ОСАГО");
        TestHelpers.setDropDownValue("я хочу застраховать", "легковой автомобиль");
        TestHelpers.setDropDownValue("детали", "объем двигателя до 1600 см³ включительно");
        TestHelpers.clickBuy("купить");
        TestHelpers.findRegistrationType("Продолжить");
        TestHelpers.findRegistrationType("Зарегистрироваться");
        TestHelpers.findRegistrationType("ввести логин и пароль для входа на сайт");
        TestHelpers.findRegistrationType("Восстановление забытого пароля");
    }

    @Test
     public void ValidateChooseRegistration() throws InterruptedException {
        TestHelpers.click("ОСАГО");
        TestHelpers.setDropDownValue("я хочу застраховать", "легковой автомобиль");
        TestHelpers.setDropDownValue("детали", "объем двигателя до 1600 см³ включительно");
        TestHelpers.clickBuy("купить");
        TestHelpers.click("Продолжить");
    }

    @Test
    public void ValidateBuyType() throws InterruptedException {
        TestHelpers.click("ОСАГО");
        TestHelpers.setDropDownValue("я хочу застраховать", "легковой автомобиль");
        TestHelpers.setDropDownValue("детали", "объем двигателя до 1600 см³ включительно");
        TestHelpers.clickBuy("купить");
        TestHelpers.click("Продолжить");
        TestHelpers.findObject("Купить на 20 гривен дешевле");
        TestHelpers.findObject("Купить на 10 гривен дешевле");
        TestHelpers.findObject("Оформление по телефону");
        TestHelpers.findObject("Оформление при доставке");
    }

    @Test
    public void ValidateChooseBuyType() throws InterruptedException {
        TestHelpers.click("ОСАГО");
        TestHelpers.setDropDownValue("я хочу застраховать", "легковой автомобиль");
        TestHelpers.setDropDownValue("детали", "объем двигателя до 1600 см³ включительно");
        TestHelpers.clickBuy("купить");
        TestHelpers.click("Продолжить");
        TestHelpers.click("Купить на 20 гривен дешевле");
    }

}
