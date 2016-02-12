/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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

import org.kie.smoke.wb.selenium.util.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewItemModal extends ModalDialog {

    public CreateNewItemModal(WebDriver driver) {
        super(driver);
    }

    private void setFileName(String fileName) {
        WebElement fileNameInput = Waits.elementPresent(driver, By.id("fileName"));
        fileNameInput.sendKeys(fileName);
    }

    public void create(String fileName) {
        setFileName(fileName);
        //Wait for KieProjectService#resolvePackages
        Waits.elementPresent(driver, By.xpath("//label[contains(.,'Package')]//following-sibling::div//span[contains(.,'<default>')]"));
        ok();
    }
}
