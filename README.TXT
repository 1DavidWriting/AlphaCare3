M04-A03: Two Implemented Use Cases with Clean, Refactored Code
Group 7: David Giordano, Ryan Feng, Ken Kim
November 11,2018

Refactoring:

    1. PatientList has 2 Patients.  LoginController allows access to PatientView or CaregiverView according to user's role.
    2. PatientController has been refactored and is less bloated.  
    3. DatabaseController has been removed.  DataCreation class handles creation of all sample data.
    4. Patient objects and the objects within them have been made serializable.  
    5. Save function is now part of Patient class.  This method is called by DataCreation and by PatientController.
    6. Blood Pressure button now works correctly.
    7. Dead code has been removed, with the exception of Physician and Administrator and associated classes for later implementation.

Use Case 2:

    1. Caregiver use case has been implemented.
    2. Classes used: Caregiver, CaregiverController, CaregiverView, CaregiverFrame, CaregiverPanel, AlphaCare, LoginController, DataCreation
    3. Who implemented them: We all worked on each class at some point. But Ken contributed more to the Caregiver View classes, David contributed more to the DataCreation class and saving data, and Ryan contributed more to the login and credential handling for Caregiver. 

Login credentials:

    Patient1 login info:
        Username: js1
        Password: easy1


    Patient2 login info:
        Username: ag2
        Password: easy2

    Physician login info:
        username: bcarson
        password: hud1

    Caregiver login info:
        username: dfire
        password: rwilliams1

    Admin login info:
        
    

Notes:

    1. DataCreation creates new patient if not already created.  To create again, delete the files js1.ser and ag2.ser, and run again.
    2. Save button works.  To test, run application and edit some data.  Click Save, close app, and run again.
    3. Cancel and Save button functionality only works for patients over 18.  You may create a younger patient to test that this is true.


