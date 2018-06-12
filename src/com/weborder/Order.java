package com.weborder;

import java.util.Random;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/Tarik/Documents/ selenium dependencies/drivers/chromedriver");
		
		String username = "Tester";
		String password = "test";
		
		WebDriver driver = new ChromeDriver();
		driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		
		String expectedTitle="Web Orders Login";
		String actual = driver.getTitle();
		
		if(expectedTitle.equals(actual)) {
			System.out.println("Succesfully landed on the main page :" + actual);
		}else {
			System.out.println("Fail landing on the main Page: " + actual);
		}
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys(username);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(password);
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
		Random rand = new Random();
		int rn = rand.nextInt(100);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(""+rn);
	
		
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
      

  
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John <"+saltStr+"> Smith");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any St");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(""+rand.nextInt(9)+rand.nextInt(9)+rand.nextInt(9)+rand.nextInt(9)+rand.nextInt(9));
		
		String s1="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]";
		String s2="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_2\"]";
		String s3="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]";
		int a =rand.nextInt(3);
		
		if(a==1)
		driver.findElement(By.xpath(s3)).click();
		else if(a==2)
			driver.findElement(By.xpath(s1)).click();
		else
			driver.findElement(By.xpath(s2)).click();
		
		StringBuilder cardnumber = new StringBuilder();
		for(int i=0; i<15; i++) {
			cardnumber.append(""+(rand.nextInt(10)-1));
		}
		StringBuilder cardnumber2 = new StringBuilder();
		for(int i=0; i<14; i++) {
			cardnumber2.append(""+(rand.nextInt(10)-1));
		}
		if(a==1 ) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+4+cardnumber);
		}else if(a==2) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+5+cardnumber);
		}else {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+3+cardnumber2);
		}
		int date=rand.nextInt(12);
		StringBuilder datee =new StringBuilder();
		if(date<10) {
			
			datee.append("0").append(date);
		}else {
			datee.append(date);
		}
		int year= rand.nextInt(99);
		while(year<19) {
			year=rand.nextInt(99);
		}
//		StringBuilder yearr = new StringBuilder();
//		yearr.append(year);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(datee+"/"+year);
//		driver.close();
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();
	}

}