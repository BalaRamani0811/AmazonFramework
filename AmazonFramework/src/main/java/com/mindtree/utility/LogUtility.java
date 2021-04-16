package com.mindtree.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.LogManager;

import com.mindtree.runner.Application;

public class LogUtility {

	static {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		System.setProperty("current.dateTime", dateFormat.format(new Date()));
	}
	
	public static void StartLogger() {
		Application.log4j=LogManager.getLogger(".\\runner\\Application.class");
	}
}
