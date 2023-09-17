import Helper.Base_Driver;
import Helper.Function;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Openmrs_Testing extends Base_Driver {

    @Test(groups = {"Smoke"})
    public void checkLoginErrors() {
        Elements e = new Elements();
        driver.get("https://openmrs.org/");
        e.Click(e.demo);
        e.Click(e.openMrs2);
        e.Click(e.openMrs2Demo);
        e.Sendkeys(e.username, "abcd");
        e.Sendkeys(e.password, "123qwe456");
        e.Click(e.loginButton);
        e.verifyContainsText(e.locationMessage, "choose a location");
        int randomNumber = Function.RandomGenerator(e.locations.size());
        e.Click(e.locations.get(randomNumber));
        e.Click(e.loginButton);
        e.verifyContainsText(e.errorMessage, "Invalid username/password");
        Login();
        e.verifyContainsText(e.loginControl, "admin");
        e.Click(e.logoutButton);
        e.verifyContainsText(e.logoutControl, "Username");
    }

    @Test(groups = {"Smoke"})
    public void loginToSystem() {
        Elements e = new Elements();
        driver.get("https://openmrs.org/");
        e.Click(e.demo);
        e.Click(e.openMrs2);
        e.Click(e.openMrs2Demo);
        e.Sendkeys(e.username, "admin");
        e.Sendkeys(e.password, "Admin123");
        int randomNumber = Function.RandomGenerator(e.locations.size());
        e.Click(e.locations.get(randomNumber));
        e.Click(e.loginButton);
        e.verifyContainsText(e.loginControl, "admin");
        e.Click(e.logoutButton);
        e.verifyContainsText(e.logoutControl, "Username");

    }

    @Test(groups = {"Smoke"})
    public void logoutToSystem() {
        Elements e = new Elements();
        Login();
        e.verifyContainsText(e.loginControl, "admin");
        e.Click(e.logoutButton);
        e.verifyContainsText(e.logoutControl, "Username");
    }


    @Test(groups = {"Regression"}, dataProvider = "patientData", dataProviderClass = Elements.class, priority = 2)
    public void patientReg(String givenName, String familyName, String day, String month, String year,
                           String adres1, String adres2, String city, String state, String country, String postalCode,
                           String phoneNumber, String relationsship, String personName) {
        Elements e = new Elements();
        e.Click(e.patientReg);
        e.Sendkeys(e.given, givenName);
        e.Sendkeys(e.familyName, familyName);
        e.Click(e.next);
        e.Click(e.male);
        e.Click(e.next);
        e.Sendkeys(e.day, day);
        Select dMenu = new Select(e.month);
        dMenu.selectByVisibleText(month);
        e.Sendkeys(e.year, year);
        e.Click(e.next);
        e.Sendkeys(e.adres1, adres1);
        e.Sendkeys(e.adres2, adres2);
        e.Sendkeys(e.city, city);
        e.Sendkeys(e.state, state);
        e.Sendkeys(e.country, country);
        e.Sendkeys(e.postalCode, postalCode);
        e.Click(e.next);
        e.Sendkeys(e.phoneNumber, phoneNumber);
        e.Click(e.next);
        Select dMenu2 = new Select(e.relationship);
        dMenu2.selectByVisibleText(relationsship);
        e.Sendkeys(e.personName, personName);
        e.Click(e.next);
        e.Click(e.submit);
        Assert.assertTrue(e.idControl.isDisplayed());
        idList.add(e.idLoctr.getText());
        e.Click(e.anaSayfa);
    }

    @Test(groups = {"Smoke"})
    public void myAccount() {
        Elements e = new Elements();
        Login();
        moveToElement(e.admin);
        e.Click(e.myAccount);
        e.verifyContainsText(e.changePassword, "Change Password");
        e.verifyContainsText(e.myLanguages, "My Languages");
    }

    @Test(groups = {"Regression"}, priority = 5)
    public void searchPatient() {
        Elements e = new Elements();
        e.Click(e.anaSayfa);
        e.Click(e.searchPatient);
        e.Sendkeys(e.searchPatientBox, "Arif Yılmaz");
        Function.Wait(1);
        e.Click(e.patientButton);
        Assert.assertTrue(e.idLoctr.isDisplayed());
    }

    @Test(groups = {"Smoke"})
    public void patientDeletion() {
        Elements e = new Elements();
        Login();
        e.Click(e.searchPatient);
        e.Sendkeys(e.searchPatientBox, "Sait Hayratlı");
        Function.Wait(2);
        e.Click(e.patientButton);
        e.verifyContainsText(e.nameControl, "Sait");
        e.verifyContainsText(e.familyControl, "Hayratlı");
        e.Click(e.deletePatient);
        e.Sendkeys(e.deleteReason, "YES");
        e.Click(e.confirmButton);
        wait.until(ExpectedConditions.visibilityOf(e.searchPatientBox));
        e.Sendkeys(e.searchPatientBox, "Sait Hayratlı");
        e.verifyContainsText(e.notFound, "No matching");
    }

    @Test(groups = {"Regression"}, priority = 1)
    public void listOfPatient() {
        Elements e = new Elements();
        e.Click(e.anaSayfa);
        e.Click(e.searchPatient);
        int tablo = e.patientList.size();
        String[] parts = e.patientInfo.getText().split(" ");
        int info = Integer.parseInt(parts[3]);
        Assert.assertEquals(tablo, info, "Liste uzunluğu doğrulanamadı");
        e.Click(e.anaSayfa);
    }

    @Test(groups = {"Regression"}, priority = 3)
    public void patientMerge() {
        Elements e = new Elements();
        e.Click(e.anaSayfa);
        e.Click(e.patientMerge);
        e.Click(e.records);
        e.Sendkeys(e.patient1, idList.get(0));
        e.Sendkeys(e.patient2, idList.get(1));
        e.Click(e.label);
        e.Click(wait.until(ExpectedConditions.elementToBeClickable(e.devam)));
        e.verifyContainsText(e.mergeControl, "Merging cannot be undone");
        e.Click(e.choosePatient);
        e.Click(e.yesContinue);
        Assert.assertTrue(e.idLoctr.isDisplayed());
    }

    @Test(groups = {"Regression"}, priority = 4)
    public void patientAppointment() {
        Elements e = new Elements();
        e.Click(e.anaSayfa);
        e.Click(e.patientAppointment);
        e.Click(e.manageAppointment);
        e.Sendkeys(e.searchPatientBox, idList.get(2));
        e.Click(wait.until(ExpectedConditions.visibilityOf(e.patientButton)));
        e.verifyContainsText(e.requests, "Your computer");
    }
}
