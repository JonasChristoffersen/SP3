# Use case descriptions #

---

### UC1 - StartMenu ###
Sunny day:

- User is shown a start menu that displays the options: "Login(UC3)" or "CreateNewAccount(UC2)"
- User can choose one of the options, and continue the flow to the next usecase that user have chosen

Rainy day:

- User inputs a wrong input, and should get an error message that displays what went wrong clearly

---


### UC2 - CreateNewAccount ###
Sunny day:

- User dont have an account, and is able to enter username and password to create a new account
- User is now be able to login to the newly created account by following "UC3 - Login"

Rainy day:

- User already have an account, and is not able to use the same username as database/csv files contains
- User must follow "UC3 - Login" to use existing login information

---

### UC3 - Login ###
Sunny day:

- User already have an account to StreamingPlatform
- User is able to login to StreamingPlatform using existing login credentials

Rainy day:

- User clicks "login with existing account", but is not able to do this, due to user not having an account.
- User will have the option to create account after clicking on "login with existing account" (following "UC2 - CreateNewAccount")
- After creating account, user is able to login to StreamingPlatform

---

### UC4 - MainMenu ###
Sunny day:

- User is shown the main menu that displays the options: 
  - "LogOut(UC12)"
  - "SearchMedia(UC7)" 
  - "UserInformation(UC5)"
- User is able to navigate to each of the options
  - Each option will take user to the related usecase

Rainy day:

- User inputs a wrong input, and should get an error message that displays what went wrong clearly

---

### UC5 - UserInformation ###
Sunny day:

- User gets user information shown, such as: Name, watched films amount, watched series amount
- User is able to choose the option to edit user information following "EditUserInformation(UC6)"
- User is able to go back to main menu (UC4)
- User is able to get shown SavedList of media
- User is able to get shown WatchedList of media

Rainy day:

- User inputs a wrong input, and should get an error message that displays what went wrong clearly

---

### UC6 - EditUserInformation ###
Sunny day:

- User is able to change username
- If user want to change password, user is required to enter existing password before being able to do so
- User is able to go back to "UserInformation(UC5)"


Rainy day:

- User tries to change password to existing password, user will not be able to update password
  - User is not able to change password if password contains ", or ; or space"
- User tries to change username to existing username, user will not be able to update username
  - User is not able to change username if username contains ", or ; or space"
- User is not able to change username to already existing username in database/csv file containing user information

---

### UC7 - SearchMedia ###
Sunny day:

- User is able to search for media using name of the media (After searching user will go into UC8)
- User is able to see media in SavedList (After searching user will go into UC8)
- User is able to see media in WatchedList (After searching user will go into UC8)
- User is able to search for media in specific genre (After searching user will go into UC8)
- user is able to go back to MainMenu (UC4)

Rainy day:

- User inputs a wrong input, and should get an error message that displays what went wrong clearly

---

### UC8 - DisplayListOfMedia ###
Sunny day:

- User gets shown list of media that user requested from UC7
- User is able to choose a media from list displayed, and continue flow to UC9
- User is able to go back to MainMenu UC4
- User is able to go back to UC7

Rainy day:

- User search for media (in UC7) but list of media is empty, user will be sent back to UC7 with explaining message of empty list
- User inputs a wrong input, and should get an error message that displays what went wrong clearly

---

### UC9 - DisplaySpecificMedia ###
Sunny day:

- User gets shown the chosen media site and information about media is displayed
- User is able to play the media UC10
- User is able to add or delete from savedList UC11
- User is able to go back to mainMenu UC4
- User is able to go back to UC8

Rainy day:

- User inputs a wrong input, and should get an error message that displays what went wrong clearly

---

### UC10 - PlayMedia ###
Sunny day:

- User gets shown the media that is chosen, and gets sent back to UC9
- User have chosen a media to watch, and media is added to WatchedList

Rainy day:

- There is no rainy day here :) 

---

### UC11 - EditSavedList ###
Sunny day:

- User have chosen to save the media that is displayed in UC9 and media gets saved to csv file
  - User can remove the save from csv file if choosing this option again
- User gets automatically sent back to UC9

Rainy day:

- There is no rainy day here :)

---

### UC12 - LogOut ###
Sunny day:

- User can from MainMenu choose to logout and will be sent to UC1 (StartMenu)
- User gets a confirmation prompt regarding if they are sure to logout
  - User dont want to logout anyway, and can go back to MainMenu UC4

Rainy day:

- User inputs a wrong input, and should get an error message that displays what went wrong clearly