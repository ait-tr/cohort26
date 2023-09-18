package com.ait.demoqa.tests;

import com.ait.demoqa.data.BookData;
import com.ait.demoqa.data.UserData;
import com.ait.demoqa.pages.BookStorePage;
import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.LoginPage;
import com.ait.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStorePageTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookTest() {
        new BookStorePage(driver)
                .enterBookName(BookData.BOOK_NAME)
                .verifyBookName(BookData.BOOK_NAME);
    }

    @Test
    public void addToCollectionTest() {
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).loginPositive(UserData.USER_NAME,UserData.USER_PASSWORD);
        new BookStorePage(driver).enterBookName(BookData.BOOK_NAME)
                .selectBook()
                .addToCollectionButton();
        new SidePanel(driver).selectProfile();
        new BookStorePage(driver).verifyBookName(BookData.BOOK_NAME).deleteBook();
    }
}
