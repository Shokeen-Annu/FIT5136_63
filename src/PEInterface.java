/**
 *  This is the Prime Event interface. This method contains the main menu, user menu and back menu.
 *
 * @author    Annu Shokeen
 * @version   20/10/2019
 */

public class PEInterface {

    private AdministratorInterface administratorInterface = new AdministratorInterface();
    private CustomerInterface customerInterface = new CustomerInterface();
    private OwnerInterface ownerInterface = new OwnerInterface();
    private InputValidation validator = new InputValidation();
    private CommonController commonController = new CommonController();

    /**
     * This method displays the main menu.
     *
     */
    public void displayMainMenu()
    {
        CommonController.createDatabase();
        int choiceNumber = -1;
        boolean flag = true;
        do {

            System.out.println("      WELCOME TO PRIME EVENTS     ");
            System.out.println();
            System.out.println("1 VIEW HALLS");
            System.out.println("2 SEARCH HALLS");
            System.out.println("3 LOGIN");
            System.out.println("4 REGISTER");
            System.out.println("5 FORGOT PASSWORD");
            System.out.println("6 EXIT");
            System.out.println();
            System.out.println("Enter your choice number:");


            choiceNumber = validator.receiveInt();
            switch (choiceNumber) {
                case -1: break;
                case 1:
                    commonController.viewHalls("ALL"," ");
                    break;
                case 2:
                    flag = customerInterface.displaySearchHallMenu(true, false);
                    break;
                case 3:

                    System.out.println("---------------- LOGIN ---------------");
                    System.out.println("Provide your login details to login.....");
                    System.out.println();
                    System.out.println();
                    boolean tryAgain = true;
                    boolean isUserAuthorized = false;
                    while(!isUserAuthorized && tryAgain) {
                        System.out.println("Enter your email id:");

                        boolean emailValid = true;
                        String emailId = "";
                        do {
                            if(!emailValid)
                                System.out.println("Email id entered is empty. Please enter correct email id:");
                            emailId = validator.receiveString().trim();
                            emailValid = !validator.isStringNullOrEmpty(emailId);
                        } while (!emailValid);

                        System.out.println();
                        System.out.println("Enter your password:");
                        String password = validator.receiveString();
                        String role = commonController.primeEventsLogin(emailId,password);
                        if(!role.isEmpty()) {
                            isUserAuthorized = true;
                            displayUserMenu(role);
                            flag = false;
                        }
                        if(!isUserAuthorized)
                        {
                            System.out.println("Either email id or password is wrong....");
                            int choiceLogout;
                            do {
                                System.out.println("Do you want to try again? Enter your choice number");
                                System.out.println("1 Yes");
                                System.out.println("2 No");
                                choiceLogout = validator.receiveInt();
                                tryAgain = commonController.logout(choiceLogout);
                            }while(choiceLogout == -1);
                            flag = tryAgain;
                        }
                    }

                    break;
                case 4:
                    System.out.println("-------------- REGISTER --------------");
                    System.out.println();
                    System.out.println();
                    boolean isRepeat = false;
                    do {
                        System.out.println("Enter your choice number for type of user:");
                        System.out.println("1 Customer");
                        System.out.println("2 Owner");
                        int typeOfUser = validator.receiveInt();
                        if (typeOfUser == -1)
                            isRepeat = true;
                        else {
                            isRepeat = false;
                            //first name
                            boolean isFirstNameValid = true;
                            String firstName = "";
                            System.out.println("Enter your first name:");
                            do {
                                if (!isFirstNameValid)
                                    System.out.println("Please input valid first name. It can be between 1 and 15 characters without '$' character.");
                                firstName = validator.receiveString();
                                isFirstNameValid = !validator.isStringNullOrEmpty(firstName)
                                        && validator.validateLengthOfString(firstName, 15, 1)
                                        && validator.isDollarSign(firstName);
                            } while (!isFirstNameValid);

                            //last name
                            boolean isLastNameValid = true;
                            String lastName = "";
                            System.out.println("Enter your last name:");
                            do {
                                if (!isLastNameValid)
                                    System.out.println("Please input valid last name. It can be between 1 and 15 characters without '$' character.");
                                lastName = validator.receiveString();
                                isLastNameValid = !validator.isStringNullOrEmpty(lastName)
                                        && validator.validateLengthOfString(lastName, 15, 1)
                                        && validator.isDollarSign(lastName);
                            } while (!isLastNameValid);

                            //phone number
                            boolean isPhoneNumValid = true;
                            String phoneNum = "";
                            System.out.println("Enter your phone number:");
                            do {
                                if (!isPhoneNumValid)
                                    System.out.println("Please input valid phone number. It should be of 10 digits.");
                                phoneNum = validator.receiveString();
                                isPhoneNumValid = !validator.isStringNullOrEmpty(phoneNum)
                                        && validator.validateLengthOfString(phoneNum, 10, 10)
                                        && validator.validateInt(phoneNum);
                                if (!validator.isPhoneNumUnique(phoneNum)) {
                                    System.out.println("Phone number entered is not unique.");
                                    isPhoneNumValid = false;
                                }
                            } while (!isPhoneNumValid);

                            //email
                            boolean isEmailValid = true;
                            String email = "";
                            System.out.println("Enter your email address:");
                            do {
                                if (!isEmailValid)
                                    System.out.println("Please enter valid email address. It should be in xxxxxx@xxx.xxx format without '$' character.");
                                email = validator.receiveString();
                                isEmailValid = !validator.isStringNullOrEmpty(email)
                                        && validator.validateEmail(email) && validator.isDollarSign(email);
                                if (!validator.isEmailUnique(email)) {
                                    System.out.println("Email address entered is not unique.");
                                    isEmailValid = false;
                                }
                            } while (!isEmailValid);

                            boolean passwordLoop = false;
                            String password = "";
                            System.out.println("Enter your password: \nPassword guidelines: Length should be between " +
                                    "5 and 12 characters. \n                It must contain small case, upper case, digits and special character EXCEPT '$'.");

                            do {
                                //password
                                boolean isPasswordValid = true;
                                if (passwordLoop)
                                    System.out.println("Enter your password:");
                                do {
                                    if (!isPasswordValid)
                                        System.out.println("Please enter valid password. \n Length of password should be between " +
                                                "5 and 12 characters. \nIt must contain small case, upper case, digits and special character EXCEPT '$'.");
                                    password = validator.receiveString();
                                    isPasswordValid = !validator.isStringNullOrEmpty(password)
                                            && validator.validatePassword(password) && validator.isDollarSign(password);
                                } while (!isPasswordValid);

                                //confirm password
                                boolean isConPasswordValid = true;
                                String conPassword = "";
                                System.out.println("Enter the password again to confirm:");
                                conPassword = validator.receiveString();
                                isConPasswordValid = !validator.isStringNullOrEmpty(conPassword)
                                        && password.equals(conPassword);
                                if (!isConPasswordValid) {
                                    passwordLoop = true;
                                    System.out.println("The two passwords do not match. Please enter correct passwords.");
                                } else
                                    passwordLoop = false;
                            } while (passwordLoop);
                            //security question 1
                            boolean isSQ1Valid = true;
                            String sq1 = "";
                            System.out.println("Enter your first security question:");
                            do {
                                if (!isSQ1Valid)
                                    System.out.println("Please enter valid security question. It's length should be between 1 and 50 characters without '$' character.");
                                sq1 = validator.receiveString();
                                isSQ1Valid = !validator.isStringNullOrEmpty(sq1)
                                        && validator.validateLengthOfString(sq1, 50, 1)
                                        && validator.isDollarSign(sq1);

                            } while (!isSQ1Valid);

                            //security question 1 answer
                            boolean isSQ1AnsValid = true;
                            String sq1Ans = "";
                            System.out.println("Enter answer to your first security question:");
                            do {
                                if (!isSQ1AnsValid)
                                    System.out.println("Please enter valid answer. It's length should be between 1 and 15 characters without '$' character.");
                                sq1Ans = validator.receiveString();
                                isSQ1AnsValid = !validator.isStringNullOrEmpty(sq1Ans)
                                        && validator.validateLengthOfString(sq1Ans, 15, 1)
                                        && validator.isDollarSign(sq1Ans);

                            } while (!isSQ1AnsValid);

                            //security question 2
                            boolean isSQ2Valid = true;
                            String sq2 = "";
                            System.out.println("Enter your second security question:");
                            do {
                                if (!isSQ2Valid)
                                    System.out.println("Please enter valid security question. It's length should be between 1 and 50 characters without '$' character.");
                                sq2 = validator.receiveString();
                                isSQ2Valid = !validator.isStringNullOrEmpty(sq2)
                                        && validator.validateLengthOfString(sq2, 50, 1)
                                        && validator.isDollarSign(sq2);

                            } while (!isSQ2Valid);

                            //security question 2 answer
                            boolean isSQ2AnsValid = true;
                            String sq2Ans = "";
                            System.out.println("Enter answer to your second security question:");
                            do {
                                if (!isSQ2AnsValid)
                                    System.out.println("Please enter valid answer. It's length should be between 1 and 15 characters without '$' character.");
                                sq2Ans = validator.receiveString();
                                isSQ2AnsValid = !validator.isStringNullOrEmpty(sq2Ans)
                                        && validator.validateLengthOfString(sq2Ans, 15, 1)
                                        && validator.isDollarSign(sq2Ans);

                            } while (!isSQ2AnsValid);

                            String role = "";
                            boolean isVeteran = false;
                            boolean isSeniorCitizen = false;

                            if (typeOfUser == 1) {
                                //customer
                                role = "customer";

                                // is veteran
                                int isVeteranInt = -1;
                                System.out.println("Are you a veteran?");
                                do {
                                    System.out.println("Enter 1 if YES or 2 if NO");
                                    isVeteranInt = validator.receiveInt();
                                    if (isVeteranInt == 1)
                                        isVeteran = true;
                                    else if (isVeteranInt == 2)
                                        isVeteran = false;
                                    else
                                        isVeteranInt = -1;
                                } while (isVeteranInt == -1);

                                // is senior citizen
                                int isSeniorInt = -1;
                                System.out.println("Are you a senior citizen?");
                                do {
                                    System.out.println("Enter 1 if YES or 2 if NO");
                                    isSeniorInt = validator.receiveInt();
                                    if (isSeniorInt == 1)
                                        isSeniorCitizen = true;
                                    else if (isSeniorInt == 2)
                                        isSeniorCitizen = false;
                                    else
                                        isSeniorInt = -1;
                                } while (isSeniorInt == -1);

                            } else if (typeOfUser == 2) {
                                //owner
                                role = "owner";
                            }
                            boolean isSuccess = commonController.registerNewUser(firstName, lastName, phoneNum, email, password,
                                    sq1, sq1Ans, sq2, sq2Ans, isVeteran, isSeniorCitizen, role);
                            if (isSuccess)
                                System.out.println("User is created successfully.");
                            else
                                System.out.println("User is not created. Some error occurred.");
                        }
                    }while(isRepeat);
                    flag = backMenu();
                    break;
                case 5:
                    System.out.println("-------------- RESET PASSWORD --------------");
                    System.out.println();
                    System.out.println();
                    System.out.println("Please provide details to reset your password.");
                    flag = backMenu();
                    break;
                case 6:
                    flag = true;
                    System.out.println("You exited the system...");
                    break;
                default:
                    System.out.println("Please enter your choice correctly!");

                    break;
            }
        }while(choiceNumber<1 || choiceNumber>6 || !flag);
    }

    /**
     * This method converts the information into this format in order to write into the txt file
     *
     * @param  role The string is to identify the role of user
     */
    public void displayUserMenu(String role)
    {
        role = role.toUpperCase();
        switch (role)
        {
            case "ADMINISTRATOR":
                System.out.println("Welcome Administrator!!");
                administratorInterface.displayAdminMenu();
                break;
            case "CUSTOMER":
                customerInterface.displayCustomerMenu();
                break;
            case "OWNER":
                ownerInterface.displayOwnerMenu();
                break;
            default: System.out.println("You do not have a verified role. Contact Administrator.");
                break;
        }
    }

    /**
     * This method is used to back to  previous page.
     *
     * @return boolean to back menu
     **/
    public boolean backMenu()
    {
        System.out.println("Press 0 to return to menu");
        int admInput = validator.receiveInt();
        if(admInput == 0)
            return false;
        else
            return true;
    }
}
