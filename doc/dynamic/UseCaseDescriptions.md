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
  - "DisplayListOfMedia(UC8)"
  - "DisplaySpecificMedia(UC9)"
- User is able to navigate to each of the options
  - Each option will take user to the related usecase

Rainy day:

- User inputs a wrong input, and should get an error message that displays what went wrong clearly

---

### UC5 - UserInformation ###
Sunny day:

-

Rainy day:

-

---

### UC6 - EditUserInformation ###
Sunny day:

-

Rainy day:

-

---

### UC7 - SearchMedia ###
Sunny day:

-

Rainy day:

-

---

### UC8 - DisplayListOfMedia ###
Sunny day:

-

Rainy day:

-

---

### UC9 - DisplaySpecificMedia ###
Sunny day:

-

Rainy day:

-

---

### UC10 - PlayMedia ###
Sunny day:

-

Rainy day:

-

---

### UC11 - EditWatchList ###
Sunny day:

-

Rainy day:

-

---

### UC12 - LogOut ###
Sunny day:

-

Rainy day:

-