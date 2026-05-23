package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.HomePage;

public class TestSearch extends BaseClass{
	@Test
	public void loginTest(){
		HomePage home = new HomePage();
		home.google_search("Hello");
	}
}
