package com.company;


import org.junit.Test;

/**
 * Created by dina.knyr on 06.02.2015.
 * https://strahovator.com.ua/

 1. Открываем страховатор и проверяем на соответствие пункты меню.
 2. ОСАГО: проверяем значения по умолчанию в 6 дропдаунах.
 3. При легковой автомобиль и до 1600см3 первая страховая компания ЮТИКО и цена 530 грн.
 4. При тех же условиях 2-я компания СКАЙД, 3-я ИЛЛИЧИВСЬКЕ.
 5. Под каждый вариант "я хочу застраховать", список "детали содержит верные значения".
 */

public class InsuranceTest extends TestBase{ //цей клас начлідує всі властивості класу TestBase

    @Test
    public void ValidateMenuItems() throws InterruptedException {
        TestHelpers.findObject("Главная");
        TestHelpers.findObject("ОСАГО");
        TestHelpers.findObject("КАСКО");
        TestHelpers.findObject("Зеленая карта");
        TestHelpers.findObject("Для выезжающих");
        TestHelpers.findObject("Как мы работаем");
        TestHelpers.findObject("Контакты");
    }

    @Test
    public void ValidateDefaultValues() throws InterruptedException {
        TestHelpers.click("ОСАГО");
        TestHelpers.checkDefaultValue("я хочу застраховать","--необходимо выбрать--");
        TestHelpers.checkDefaultValue("детали", "--необходимо выбрать--");
        TestHelpers.checkDefaultValue("зарегистирирован", "Киев");
        TestHelpers.checkDefaultValue("стаж", "3 года");
        TestHelpers.checkDefaultValue("срок действия", "1 год");
        TestHelpers.checkDefaultValue("заключить договор", "нет");
    }

    @Test
    public void ValidateFirstCompanyPrice() throws InterruptedException {
        TestHelpers.click("ОСАГО");
        TestHelpers.setDropDownValue("я хочу застраховать", "легковой автомобиль");
        TestHelpers.setDropDownValue("детали", "объем двигателя до 1600 см³ включительно");
        TestHelpers.checkFirstPrice("530 грн.");
        TestHelpers.checkFirstCompany("Utico");
        TestHelpers.checkSecondCompany("СКАЙД");
        TestHelpers.checkThirdCompany("ІЛЛІЧІВСЬКЕ");

    }

    @Test
    public void ValidateDetailsValues() throws InterruptedException {
        TestHelpers.click("ОСАГО");
        TestHelpers.setDropDownValue("я хочу застраховать", "легковой автомобиль");
        TestHelpers.checkAllValues("детали", new String[] {
                "--необходимо выбрать--",
                "объем двигателя до 1600 см³ включительно",
                "объем двигателя от 1601 до 2000 см³",
                "объем двигателя от 2001 до 3000 см³",
                "объем двигателя 3001 см³ и более"});
        TestHelpers.setDropDownValue("я хочу застраховать", "прицеп");
        TestHelpers.checkAllValues("детали", new String[] {
                "--необходимо выбрать--",
                "для легкового автомобиля",
                "для грузового автомобиля"});

    }
    @Test
    public void ValidateFranchiseDetails() throws InterruptedException {
        TestHelpers.click("ОСАГО");
        TestHelpers.setDropDownValue("я хочу застраховать", "легковой автомобиль");
        TestHelpers.setDropDownValue("детали", "объем двигателя до 1600 см³ включительно");
        TestHelpers.findFranchiseDetails("Это та часть страховой выплаты, которую в любом случае необходимо будет оплатить Вам самостоятельно, если произойдет ДТП по Вашей вине");
    }

    @Test
    public void ValidateBuyButton() throws InterruptedException {
        TestHelpers.click("ОСАГО");
        TestHelpers.setDropDownValue("я хочу застраховать", "легковой автомобиль");
        TestHelpers.setDropDownValue("детали", "объем двигателя до 1600 см³ включительно");
        TestHelpers.clickBuy("купить");
    }
}
