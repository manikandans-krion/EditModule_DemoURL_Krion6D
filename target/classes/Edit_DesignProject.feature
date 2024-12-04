#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Editing the Project Deatils
  This feature aims to change the details in the Projects and other functionality in it under Design module within the application.
  
  
  
#Login Page -> Login

  @Run
Scenario: User Login for Design Projects
  Given I visit the User Login for Design Projects using sheetname "Credentials" and rownumber 0
  And I enter the credentials in login and click a login button
  
  
	  	#Design -> Edit Project
	  	
  		@Run		
  		Scenario: Verify by changing the required fields in Project
  		Then Changing the required fields in Project using sheetname "Edit Project" and rownumber 0
  
  
      #Actions -> Edit Review
      
      @Run
      Scenario: Verify by changing the required field in Review module under Action
  		Then Changing the required field in Review module under Action using sheetname "Edit Review" and rownumber 0
  
  
  		
  	 #Actions -> Edit RFA

		  @Run
  		Scenario: Verify by changing the required field in RFA module under Action
  		Then Changing the required field in RFA module under Action using sheetname "Edit RFA" and rownumber 0
  
  
			#Share -> Edit Meeting  
  
 			@Run
  		Scenario: Verify by changing the required field in Meeting module under Share
  		Then Changing the required field in Meeting module under Share using sheetname "Edit Meeting" and rownumber 0
  
  
  		#Attachments -> Edit BOM/BOQ
  		
  		@Run
  		Scenario: Verify by changing the required field in BOM_BOQ module under Attachments
  		Then Changing the required field in BOM_BOQ module under Attachments using sheetname "Edit BOMBOQ" and rownumber 0
  
  
 			#Attachments -> Edit CheckList
  		
  		@Run
			Scenario: Verify by Entering values in checklist fields and items
    	Then Entering values in checklist fields and items using sheetnames "Edit checklist" and "Edit checklist items" with rownumber 0

  
  
  
  
  		#Actions-> Edit Issue -------> Kamal
  		
			@Run
			Scenario: Verify the user is able to edit the Issue
			Then filtering the required Issue and clicking on it using sheetname "Edit Issue" and rownumber 0
			Then Changing the required fields in Issue using sheetname "Edit Issue" and rownumber 0
 			
     
			#Actions-> Edit RFI -------> Kamal
			
			@Run
			Scenario: Verify the user is able to edit the RFI
			Then filtering the required RFI and clicking on it using sheetname "Edit RFI" and rownumber 0
			Then Changing the required field in RFI using sheetname "Edit RFI" and rownumber 0
			
			  		
			#Attachments-> Edit Form -------> Kamal 
			   	
			@Run
			Scenario: Verify the user is able to edit the Form
			Then filtering the required Form and clicking on it using sheetname "Edit Form" and rownumber 0
			Then Changing the required field in Form using sheetname "Edit Form" and rownumber 0
			
    
			#Share-> Edit Submittals -------> Kamal  
			  	
			@Run
			Scenario: Verify the user is able to edit the Submittals
			Then filtering the required Submittals and clicking on it using sheetname "Edit Submittals" and rownumber 0
			Then Changing the required field in Submittals using sheetname "Edit Submittals" and rownumber 0
			
   
			#Share-> Edit Transmittals -------> Kamal  
			 	
			@Run
			Scenario: Verify the user is able to edit the Transmittals
			Then filtering the required Transmittals and clicking on it using sheetname "Edit Transmittals" and rownumber 0
			Then Changing the required field in Transmittals using sheetname "Edit Transmittals" and rownumber 0		   
			
	 
			#Folder -------> Kamal 
			
			@Run
			Scenario: Verify the user is able to edit the foldername
			Given filtering the required Folder and clicking on it using sheetname "Edit Folder" and rownumber 0
			Then Click the menu button on the folder using sheetname "Edit Folder" and rownumber 0
			Then click the Rename button
			Then Update the foldername using the sheetname "Edit Folder" and rownumber 0
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  