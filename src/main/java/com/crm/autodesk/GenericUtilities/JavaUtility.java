package com.crm.autodesk.GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * This class contains generic methods pertaining to java
 * @author Keshava
 *
 */
public class JavaUtility {

	/**
	 * this method generates random numbers
	 * @return 
	 */
	public int getRandomNum() {
		Random r = new Random();
		int randomNum = r.nextInt(100000);
		return randomNum;
	}
	/**
	 * its used to get the current System date & time
	 * @return
	 */
	public String getSystmeDate() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}
	/**
	 * its used to get the current System date with YYYY-MM-DD format
	 * @return
	 */
	public String getSystmeDate_YYYY_MM__DD() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split(" ");
        String DD = arr[2];
        String YYYY = arr[5];   
        int MM = date.getMonth()+1;
        
        String finalFromat = YYYY+"-"+MM+"-"+DD;
		return finalFromat;	  
	}
	
    /**
     * used to pass Virtual Key to OS
     * @throws Throwable
     */
    public void pressVurtualEnterKey() throws Throwable {
    	
    	Robot rc=new Robot();
    	rc.keyPress(KeyEvent.VK_ENTER);
    	rc.keyRelease(KeyEvent.VK_ENTER);
    }
}


