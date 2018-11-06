#University ID: 201241037 File_name: Thomas_Coupe-CA02.py
#Coded in October 2017
#user will be prompted with a main menu. once the user selects an option they will be required to input a password that is between 8 - 15 characters that must include a mixture of numbers and letters.
print("\tMain Menu")
print("A. Numbers")
print("B. Strings")
print("C. Games")
print("X. Exit")
print("\n")
option = str(input("Enter an option(A, B, C or X): ")).upper()
if option == "B":  
    password = str(input("Please enter your password: "))
    if len(password) >= 8 and len(password) <= 15:
        hasNum = False
        hasChar = False
        for i in password:
            if i.isnumeric():
                hasNum = True
            if i.isalpha():
                hasChar = True
        if hasNum and hasChar:
            print("Password created successfully!")
        elif not hasNum:
            print("Error: The Password doesn't have numeric characters")
        elif not hasChar:
            print("Error: The Password doesn't have alphabetic characters")
    else:
        print("Error: Please enter a password length of 8-15")

#Testing
        
#Test_1: Input = password - Output = "Error: The number doesn't have numeric characters"
#Test_2: Input = 11111111 - Output = "Error: The number doesn't have alphabetic characters"
#Test_3: Input = pass123 - Output = "Error: Please enter a password length of 8-15"
#Test_4: Input = password123451234 - Output = "Error: Please enter a password length of 8-15"
#Test_5: Input = Password123 - Output = "Password created successfully!"




