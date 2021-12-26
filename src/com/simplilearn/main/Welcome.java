package com.simplilearn.main;

public class Welcome {
	
	String applicationName;
	String developerName;
	String welcomeApplication;
	
	final String LABELAPPLICATIONNAME = "Application Name: ";
	final String LABELDEVELOPERNAME = "Developer Name: ";
	
	Welcome(){
		this.applicationName = "Full Stack Developer Assessment 1";
		this.developerName   = "Cecilia González Fuentes";
		this.welcomeApplication = "Welcome to our application!";
	}
	
	Welcome(String applicationName, String developerName, String welcomeApplication){
		this.applicationName = applicationName;
		this.developerName   = developerName;
		this.welcomeApplication = welcomeApplication;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getWelcomeApplication() {
		return welcomeApplication;
	}

	public void setWelcomeApplication(String welcomeApplication) {
		this.welcomeApplication = welcomeApplication;
	}
	

}
