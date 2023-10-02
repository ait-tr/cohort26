package com.ait.demoqa.tests.form;

import com.ait.demoqa.data.StudentData;
import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.form.PracticeFormPage;
import com.ait.demoqa.tests.TestBase;
import com.ait.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void fillPracticeFormTest() {
        //hide iframes(ad & footer)
        new PracticeFormPage(driver).hideIframes();
        //enter personal data
        new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
                        StudentData.EMAIL, StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER)
                //enter date(select date)
                //   .enterDate(StudentData.DATE_OF_BIRTH)
                .selectDate("May", "1953", "13")
                .addSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBY)
                .uploadFile(StudentData.PATH)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submitForm()
                .assertModalTitle("Thanks for submitting the form");
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "addNewStudentFromCSV")
    public void fillPracticeFormFromDataProviderTest(String name, String lastName, String email, String phone,
                                                     String date, String path, String address) {
        new PracticeFormPage(driver).hideIframes();

        new PracticeFormPage(driver).enterPersonalData(name,lastName,email,phone)
                .selectGender(StudentData.GENDER)
                .enterDate(date)
                .addSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBY)
                .uploadFile(path)
                .enterAddress(address)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submitForm()
                .assertModalTitle("Thanks for submitting the form");
    }

}
