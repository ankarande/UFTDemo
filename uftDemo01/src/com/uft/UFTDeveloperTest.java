package com.uft;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.AgGridDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListBoxDescription;
import com.hp.lft.sdk.web.ListItem;
import com.hp.lft.sdk.web.RadioGroup;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.verifications.*;

import junit.framework.Assert;
import unittesting.*;

public class UFTDeveloperTest extends UnitTestClassBase {

	public UFTDeveloperTest() {
		// Change this constructor to private if you supply your own public constructor
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new UFTDeveloperTest();
		globalSetup(UFTDeveloperTest.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws GeneralLeanFtException {

		Browser browser = BrowserFactory.launch(BrowserType.CHROME);

		browser.navigate("https://www.fb.com/");

		Button u02TVButton = browser.describe(Button.class,
				new ButtonDescription.Builder().buttonType("").name("Create New Account").tagName("A").build());
		u02TVButton.click();

		EditField firstNameEditField = browser.describe(EditField.class,
				new EditFieldDescription.Builder().tagName("INPUT").name("firstname").enabled(true)
						.xpath("//input[@id='u_7_b_zr']").type("text").build());
		firstNameEditField.setValue("Amol");

		String ActualFirstName = firstNameEditField.getValue();
		String ExpectedFirstName = "Amol";
		Assert.assertEquals(ExpectedFirstName, ActualFirstName);

		EditField surnameEditField = browser.describe(EditField.class,
				new EditFieldDescription.Builder().name("lastname").tagName("INPUT").type("text").build());
		surnameEditField.setValue("K");

		EditField mobileNumberOrEmailAddressEditField = browser.describe(EditField.class,
				new EditFieldDescription.Builder().name("reg_email__").tagName("INPUT").type("text").build());
		mobileNumberOrEmailAddressEditField.setValue("amolk@gmail.com");

		EditField reEnterEmailAddressEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("reg_email_confirmation__").tagName("INPUT").type("text").build());
		reEnterEmailAddressEditField.setValue("amolk@gmail.com");

		EditField newPasswordEditField = browser.describe(EditField.class,
				new EditFieldDescription.Builder().name("reg_passwd__").tagName("INPUT").type("password").build());
		newPasswordEditField.setSecure("6078029bb8ff479cfeaa723c4ecd8302eff038836103bf7e");

		ListBox dayListBox = browser.describe(ListBox.class,
				new ListBoxDescription.Builder().name("birthday_day").tagName("SELECT").build());
		dayListBox.select("13");

		ListBox monthListBox = browser.describe(ListBox.class,
				new ListBoxDescription.Builder().name("birthday_month").tagName("SELECT").build());
		monthListBox.select("Sep");

		boolean MonthCheck = monthListBox.isEnabled();
		Assert.assertTrue(MonthCheck);

		ListBox yearListBox = browser.describe(ListBox.class,
				new ListBoxDescription.Builder().name("birthday_year").tagName("SELECT").build());
		yearListBox.select("2007");

		List<ListItem> items = yearListBox.getItems();

		for (int j = 0; j < items.size(); j++) {
			ListItem listItem = items.get(j);
			System.out.println(listItem.getText());

		}

		RadioGroup sexRadioGroup = browser.describe(RadioGroup.class,
				new AgGridDescription.Builder().name("sex").tagName("INPUT").build());
		sexRadioGroup.select("2");

		Button signUpButton = browser.describe(Button.class, new ButtonDescription.Builder().accessibilityName("")
				.buttonType("submit").name("Sign Up").role("").tagName("BUTTON").index(0).build());
		signUpButton.click();
		
		
		
		// CheckBox Code

				browser.navigate(
						"https://www.amazon.in/Girl-clothing/b/ref=brb_Kids_Girls_Clothing?ie=UTF8&node=1967936031&pf_rd_m=A1VBAL9TL5WCBF&pf_rd_s=merchandised-search-leftnav&pf_rd_r=YNAFCFTZW5QVJWNTPBNN&pf_rd_r=YNAFCFTZW5QVJWNTPBNN&pf_rd_t=101&pf_rd_p=d7786278-ce45-4df3-9132-c01aff0fdd85&pf_rd_p=d7786278-ce45-4df3-9132-c01aff0fdd85&pf_rd_i=9361420031");

				WebElement topBrandsWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder().xpath(
						"  //body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/input[1]")
						.build());
				topBrandsWebElement.click();

		

	}

}