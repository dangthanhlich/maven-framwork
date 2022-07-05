package com.wordpress.admin;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageObjects.wordpress.UserSearchPostPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {

	String adminUsername = "automationfc";
	String adminPassword = "automationfc";
	String searchPostUrl;
	int randomnumber = generateFakeNumber();
	String postTitle = "Live coding Title" + randomnumber;
	String postBody = "Live coding body" + randomnumber;
	String editPostTitle = "Edit Title" + randomnumber;
	String editPostBody = "Edit Body";
	String authorName = "automationfc";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition-step 01: Open browser and admin Url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, adminUrl);
		// adminPostSearchPage.openEndUserSite(this.endUserUrl);

//		adminLoginPage = new AdminLoginPO(driver);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-Condition-step 02: Enter to Username textbox with value" + adminUsername);
		adminLoginPage.entertoUsernameTextbox(adminUsername);

		log.info("Pre-Condition-step 03:  Enter to Password textbox with value" + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-Condition-step 04: Click to Login button");
		adminDashboadPage = adminLoginPage.clickToLoginButton();

	}

	@Test
	public void Post_01_Create_New_post() {
		log.info("Create_Post-step 01:Click to 'Posts menu link' ");

		adminPostSearchPage = adminDashboadPage.clickToPostMenuLink();

		// adminPostSearchPage = PageGeneratorManager.getAdminPostSearchPage(driver);
		log.info("Create_Post-step 02: Get 'search Posts' page Url ");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Create_Post-step 03: Enter to 'Add new' button ");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create_Post-step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);

		log.info("Create_Post-step 05: Enter to  post body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);

		log.info("Create_Post-step 06: Click to 'publish' button");
		adminPostAddNewPage.clickToPublishOrUpdatehButton();

		log.info("Create_Post-step 06: Click to 'Pre publish' button");
		adminPostAddNewPage.clickToPrePublishButton();

		log.info("Create_Post-step 08: verify 'Post published.' mesage is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));

	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Create_Post-step 01: Open 'Search Posts' page");

		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("search_post - step 02 :Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("search_post - step 03 :Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("search_post - step 04 :Verify Search table contains'" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Title", postTitle));

		log.info("search_post - step 05 :verify search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Author", authorName));

		log.info("search_post - step 06 :open end user site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("search_post - step 07:verify post infor dislayed at home page");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithauthorName(postTitle, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithcurrentDay(postTitle, currentDay));

		log.info("search_post - step 08 :click to post title");
		userPostDetailPage = userHomePage.clickToPosrTitle(postTitle);

		log.info("search_post - step 09 :verify post infor displayed at home page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithauthorName(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithcurrentDay(postTitle, currentDay));
	}

	@Test
	public void Post_03_View_Post() {
		log.info("Edit_Post - step 01: Open Admin site");
		adminDashboadPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);

		log.info("Edit_Post - step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboadPage.clickToPostMenuLink();

		log.info("Edit_Post - step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		;

		log.info("Edit_Post - step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit_Post - step 05: Click to Post title link and navigate to Edit Post Page");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

		log.info("Edit_Post - step 06: Enter to Post title: ");
		adminPostAddNewPage.enterToAddNewPostTitle(editPostTitle);
		;

		log.info("Edit_Post - step 07: Enter to post body");
		adminPostAddNewPage.enterToEditPostBody(editPostBody);

		log.info("Edit_Post - step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToPublishOrUpdatehButton();

		log.info("Edit_Post 09: verify 'Post updated.' mesage is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post updated."));

		log.info("Edit_Post 10: Open 'Search Posts' page");

		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Edit_Post 11 :Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Edit_Post 12 :Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit_Post 13 :Verify Search table contains'" + editPostTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Title", editPostTitle));

		log.info("Edit_Post 14 :verify search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Author", authorName));

		log.info("Edit_Post 15 :open end user site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Edit_Post 16:verify post infor dislayed at home page");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithauthorName(editPostTitle, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithcurrentDay(editPostTitle, currentDay));

		log.info("Edit_Post 17 :click to post title");
		userPostDetailPage = userHomePage.clickToPosrTitle(editPostTitle);

		log.info("Edit_Post 18 :verify post infor displayed at home page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithauthorName(editPostTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithcurrentDay(editPostTitle, currentDay));

	}

	@Test
	public void Post_04_Edit_Post() {
		log.info("Delete_Post - step 01: Open Admin site");
		adminDashboadPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);

		log.info("Delete_Post - step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboadPage.clickToPostMenuLink();

		log.info("Delete_Post - step 03: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);
		;

		log.info("Delete_Post - step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit_Post - step 05: Select post detail checkbox");
		adminPostSearchPage.selectPostCheckboxByTitle(editPostTitle);

		log.info("Edit_Post - step 06:Select 'Move to trash' item in dropdown");
		adminPostSearchPage.selectTextItemInActionDropdown("Move to Trash");

		log.info("Edit_Post - step 07:click to 'apply' button");
		adminPostSearchPage.clickToapplyButton();
		adminPostSearchPage.sleepInSecond(5);

		log.info("Edit_Post - step 08:Verify '1 post moved to trash ' message is displayed ");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));

		log.info("Edit_Post - step 09:Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Edit_Post - step 10:Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		verifyTrue(adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));

		log.info("Edit_Post - step 12:Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Edit_Post - step 13:Verify Post title undisplayed at Home Page");
		verifyTrue(userHomePage.isPostInforUndisplayWithPostTitle(editPostTitle));

		log.info("Edit_Post - step 14:Enter to Search textbox");
		userHomePage.enterToSearchTextbox(editPostTitle);

		log.info("Edit_Post - step 15:Click to 'Search ' button");
		userSearchPostPage = userHomePage.clickToSearchButton();

		log.info("Edit_Post - step 16:Verify 'Nothing Found' message is displayed ");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));

	}

	@Test
	public void Post_05_Delete_Post() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboadPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserSearchPostPO userSearchPostPage;

}
