Feature: Login into Application

Scenario Outline: Positive test validation login
	Given Initialize the browser with chrome
	And Navigate to "http://qaclickacademy.com/" site
	And Click on login link in home page to land on secure sign in page
	When User enters <username> and <password> and logs in
	Then verify that user is successfully logged in
	And close the browsers
	
	Examples:
	|username			|password	|
	|test99@gmail.com	|123456		|
	|test123@gmail.com	|32145		|
	
	
	
	
	
	
	