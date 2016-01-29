/*
 * Copyright 2016 JBoss by Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.smoke.wb.selenium.model;

import org.kie.smoke.wb.selenium.util.ByUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SecondaryNavbar extends PageObject {

    /* Works both for menu titles (e.g. New Item) and menu items (e.g. Drl File) */
    private static final String MENU_LINK = "//ul[contains(@class,'navbar-persistent')]//a[contains(text(),'%s')]";

    public SecondaryNavbar(WebDriver driver) {
        super(driver);
    }

    public CreateNewItemModal newItem(Item i) {
        menuLink("New Item").click();
        menuLink(i.toString()).click();
        return PageFactory.initElements(driver, CreateNewItemModal.class);
    }

    public static enum Item {

        Data_Object,
        DRL_file,
        Enumeration;

        @Override
        public String toString() {
            return name().replace('_', ' ');
        }
    }

    private WebElement menuLink(String title) {
        return driver.findElement(ByUtil.xpath(MENU_LINK, title));
    }
}
