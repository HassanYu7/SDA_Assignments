package assignments.week5;

import assignments.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DragAndDropTest extends TestBase {

    /*
            Go to URL: http://demo.guru99.com/test/drag_drop.html
            Drag and drop the BANK button to the Account section in DEBIT SIDE
            Drag and drop the SALES button to the Account section in CREDIT SIDE
            Drag and drop the 5000 button to the Amount section in DEBIT SIDE
            Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
            Verify the visibility of Perfect text.
    */

    @Test
    public void testDragAndDrop() {
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");

        By bankButton = By.cssSelector("li#credit2 > a");
        By accountDebitSide = By.cssSelector("ol#bank > li");

        By salesButton = By.cssSelector("li#credit1 > a");
        By accountCreditSide = By.cssSelector("ol#loan > li");

        By fiveThousandButtonFirst = By.xpath("(//li[@id='fourth'])[1]");
        By amountDebitSide = By.cssSelector("ol#amt7 > li");


        By fiveThousandButtonSecond = By.xpath("(//li[@id='fourth'])[2]");
        By amountCreditSide = By.cssSelector("ol#amt8 > li");

        bot.dragAndDrop(bankButton,accountDebitSide);
        bot.dragAndDrop(salesButton,accountCreditSide);
        bot.dragAndDrop(fiveThousandButtonFirst,amountDebitSide);
        bot.dragAndDrop(fiveThousandButtonSecond,amountCreditSide);

        By textElement = By.xpath("//a[text()='Perfect!']");
        assertEquals("Perfect!", driver.findElement(textElement).getText());
    }


}
