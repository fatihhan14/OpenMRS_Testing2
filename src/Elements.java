import Helper.Base_Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.util.List;

public class Elements extends Base_Driver {

    public Elements() {
        PageFactory.initElements(Base_Driver.driver, this);
    }

    @FindBy(xpath = "//a[@class='zak-button']")
    public WebElement demo;
    @FindBy(xpath = "//span[text()='Explore OpenMRS 2']")
    public WebElement openMrs2;
    @FindBy(xpath = "//span[text()='Enter the OpenMRS 2 Demo']")
    public WebElement openMrs2Demo;
    @FindBy(xpath = "//input[@placeholder='Enter your username']")
    public WebElement username;
    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    public WebElement password;
    @FindBy(css = "input[id='loginButton']")
    public WebElement loginButton;
    @FindBy(xpath = "//span[contains(text(),'choose a location')]")
    public WebElement locationMessage;
    @FindBy(css = "[id='sessionLocation']>li")
    public List<WebElement> locations;
    @FindBy(xpath = "//div[contains(text(),'Invalid username/password')]")
    public WebElement errorMessage;
    @FindBy(css = "li[class='nav-item identifier']")
    public WebElement loginControl;
    @FindBy(linkText = "Logout")
    public WebElement logoutButton;
    @FindBy(xpath = "//label[contains(text(),'Username:')]")
    public WebElement logoutControl;
    @FindBy(xpath = "//div[@id='apps']//a[4]")
    public WebElement patientReg;
    @FindBy(xpath = "//input[@name='givenName']")
    public WebElement given;
    @FindBy(xpath = "//input[@name='familyName']")
    public WebElement familyName;
    @FindBy(xpath = "//button[@id='next-button']")
    public WebElement next;
    @FindBy(xpath = "//option[@value='M']")
    public WebElement male;
    @FindBy(xpath = "//input[@name='birthdateDay']")
    public WebElement day;
    @FindBy(xpath = "//select[@name='birthdateMonth']")
    public WebElement month;
    @FindBy(xpath = "//input[@name='birthdateYear']")
    public WebElement year;
    @FindBy(css = "[id = 'address1']")
    public WebElement adres1;
    @FindBy(css = "[id = 'address2']")
    public WebElement adres2;
    @FindBy(css = "[id = 'cityVillage']")
    public WebElement city;
    @FindBy(css = "[id = 'stateProvince']")
    public WebElement state;
    @FindBy(css = "[id = 'country']")
    public WebElement country;
    @FindBy(css = "[id = 'postalCode']")
    public WebElement postalCode;
    @FindBy(css = "[name = 'phoneNumber']")
    public WebElement phoneNumber;
    @FindBy(xpath = "//select[@id='relationship_type']")
    public WebElement relationship;
    @FindBy(xpath = "//input[@placeholder='Person Name']")
    public WebElement personName;
    @FindBy(xpath = "//input[@id='submit']")
    public WebElement submit;
    @FindBy(xpath = "(//span[@class='labeled']//span)[1]")
    public WebElement nameControl;
    @FindBy(xpath = "(//span[@class='labeled']//span)[2]")
    public WebElement familyControl;
    @FindBy(xpath = "//li[@class='nav-item identifier']")
    public WebElement admin;
    @FindBy(linkText = "My Account")
    public WebElement myAccount;
    @FindBy(xpath = "(//div[@class='task'])[1]")
    public WebElement changePassword;
    @FindBy(xpath = "(//div[@class='task'])[2]")
    public WebElement myLanguages;
    @FindBy(xpath = "//div[@id='apps']//a[1]")
    public WebElement searchPatient;
    @FindBy(xpath = "//input[@id='patient-search']")
    public WebElement searchPatientBox;
    @FindBy(xpath = "(//tr[@class='odd'])[1]")
    public WebElement patientButton;
    @FindBy(xpath = "//tr[@class='odd']//td")
    public WebElement notFound;
    @FindBy(xpath = "//a[@id='org.openmrs.module.coreapps.deletePatient']")
    public WebElement deletePatient;
    @FindBy(xpath = "//input[@id='delete-reason']")
    public WebElement deleteReason;
    @FindBy(xpath = "(//div[@id='simplemodal-container']//button)[1]")
    public WebElement confirmButton;
    @FindBy(css = "[aria-relevant='all']>tr")
    public List<WebElement> patientList;
    @FindBy(xpath = "//div[@id='patient-search-results-table_info']")
    public WebElement patientInfo;
    @FindBy(xpath = "//div[@id='apps']//a[7]")
    public WebElement patientMerge;
    @FindBy(xpath = "//i[@class='icon-group']")
    public WebElement records;
    @FindBy(css = "[id='patient1-text']")
    public WebElement patient1;
    @FindBy(css = "[id='patient2-text']")
    public WebElement patient2;
    @FindBy(css = "[id='confirm-button']")
    public WebElement devam;
    @FindBy(xpath = "//h1[contains(text(),'Merging cannot be undone!')]")
    public WebElement mergeControl;
    @FindBy(css = "[id='first-patient']")
    public WebElement choosePatient;
    @FindBy(css = "[id='confirm-button']")
    public WebElement yesContinue;
    @FindBy(xpath = "(//div[@class='float-sm-right']//span)[2]")
    public WebElement id1;
    @FindBy(xpath = "(//div[@class='float-sm-right']//span)[3]")
    public WebElement id2;
    @FindBy(xpath = "//label[text()='You can also dynamically search for patients to merge, by name or id']")
    public WebElement label;
    @FindBy(xpath = "//div[@id='apps']//a[5]")
    public WebElement patientAppointment;
    @FindBy(xpath = "//div[@id='apps']//div[3]")
    public WebElement manageAppointment;
    @FindBy(xpath = "//p[contains(text(),'Your computer')]")
    public WebElement requests;
    @FindBy(xpath = "//div[@class='logo']")
    public WebElement anaSayfa;
    @FindBy(xpath = "//div[@class='float-sm-right']")
    public WebElement idControl;

    @DataProvider(name = "patientData")
    public static Object[][] patientRegData() {
        return new Object[][]{
                {"Sait", "Hayratlı", "20", "April", "1991", "Yağmur Sk.", "Bulut Cad.", "Hayrat", "Trabzon", "Türkiye", "72569", "+9054936198524", "Supervisor", "Haydar"},
                {"Arif", "Yılmaz", "21", "May", "1995", "Tipi Sk.", "Kar Cad.", "Fetiye", "Muğla", "Türkiye", "45987", "+9054936194168", "Sibling", "Ayşe"},
                {"Emre", "Aktaş", "17", "June", "1996", "Menekşe Sk.", "Badem Cad.", "Konak", "İzmir", "Türkiye", "73269", "+9057513198524", "Parent", "Yücel"},
                {"Ramiz", "Göksu", "27", "October", "1998", "Lale Sk.", "Temelli Cad.", "Pamukkale", "Denizli", "Türkiye", "78529", "+9057513168424", "Doctor", "Bahar"},
                {"Halit", "Eşsiz", "11", "December", "1975", "Sümbül Sk.", "Vatan Cad.", "Silifke", "Mersin", "Türkiye", "65229", "+9057731968424", "Child", "Rıfat"},
        };
    }

    @FindBy(xpath = "//div[@class='float-sm-right']//span")
    public WebElement idLoctr;



}
