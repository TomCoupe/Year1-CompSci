#Student ID: 201241037, File Name: Thomas_Coupe-CA05.py
#Coded November 2017
#
import random
def main(): # defining main
    print("-------------------------")
    print("\tMAIN MENU")
    print("-------------------------")
    print("A. Numbers")
    print("B. Strings")
    print("C. Games")
    print("X. Exit")
    print()
main()
#calling main() to present to the user
option = str(input("Select an option from the menu (A, B, C or X) ").upper())
#asking for the users input to select an option from the menu
def hangman(): # defining hangman
    wordlist = []
    animals = ["owl","cow","monkey","zebra","tiger","sheep","dog","dolphin"]
    #list of words for the animal catergory
    cars = ["ford", "lamborghini", "bmw", "peugeot", "mini", "pagini", "lotus", "audi"]
    #list of words for the car catergory
    programming_languages = ["java", "c++", "python", "haskell", "sql", "php", "ruby", "pascal", "scratch"]
    #list of words for the programming language catergory
    
    search_browsers = ["opera", "chrome", "tor", "firefox", "edge", "safari", "ie"]
    #list of words for the search browsers catergory
    print("Please pick a category:\n1. Cars\n2. Programming Languages\n3. Animals\n4. Search Browsers")
    while True:
        cchoice = int(input()) #cchoice is the catergory choice from the user
        if cchoice == 1:
            for i in cars:
                wordlist.append(i)
                #selecting the list of cars and assigning the list to the variable wordlist.
            break
        elif cchoice == 2:
            for i in programming_languages:
                wordlist.append(i)
                #selecting the list of programming languages and assigning the list to the variable wordlist.
            break
        elif cchoice == 3:
            for i in animals:
                wordlist.append(i)
                #selecting the list of animals and assigning the list to the variable wordlist.
            break
        elif cchoice == 4:
            for i in search_browsers:
                wordlist.append(i)
                #selecting the list of search browsers and assigning the list to the variable wordlist.
            break
        else:
            print("Please input the number corresponding to the choice.")
                
    random.shuffle(wordlist)
    # random.shuffle shuffles the order of the words within the list at random
    word = list(wordlist[0])
    # selecting the words in the first position of the list after it has been shuffled.
    display = []
    display.extend(word)
    guessed_letters = []
    print("Length of word is: ",len(word))
    # outputting the length of the word
    for i in range(len(display)):
        display[i] = "_"
        # for every character within the length of the word it can be represented as "_"
    if cchoice == 1:
        print("The topic of the word is Cars! ")
        # informing the user of the catergory
    if cchoice == 2:
        print("The topic of the word is Programming Languages! ")
        # informing the user of the catergory
    if cchoice == 3:
        print("The topic of the word is Animals! ")
        # informing the user of the catergory
    if cchoice == 4:
        print("The topic of the word is Search Browsers! ")
        # informing the user of the catergory
    print(' '.join(display))
    print()
    count = 0 #starting the guess count at 0
    while True:
        guess = input("Please select a letter: ")
        count += 1 #after a letter is selected add one guess
        print("Number of guesses = {}/{}".format(count,str(len(word))))
        #showing guesses taken and guesses remaining
        if guess not in guessed_letters and guess not in word:
            guessed_letters.append(guess)
        if guessed_letters:
            print("Incorrect guessed letters = ", end="")
            #showing the user the incorrect guesses taken
            for i in guessed_letters:
                print(i,end=" ")
                #spacing between each of the incorrect guessed letters
        print()
        for i in range(len(word)):
            if word[i] == guess:
                display[i] = guess
            print(end="_".join(display[i]))
            print(end=" ")
            # representing each of the letters of the word as "_" and having spacing inbetween each of them.
        print("\n")
        if word == display:
            print("Good job, You guessed the word!")
            #informaing the user they guessed the qword correctly
            break
        if count >= len(word):
            print("You have ran out of guesses! ")
            #if the count is greater than the length of the word = no remaining guesses
            print("\n")
            if count >= len(word):
                final_guess = str(input("Whats your final guess of the WHOLE word? ").lower())
                #final guess of the word for the user, using .lower() to ensure their input matches the input of the list
                if final_guess == ''.join(word):
                    print("The word that you guessed was correct, Well done! ")
                else:
                    print("Unlucky your final guess was not correct, The word was:",word)
                break
if option == "C":
    print("You are playing hangman! ")
    input("Press any key to start! ")
    hangman() #calling hangman function if option c is selected
    
if option == "X":
    print("You have closed the program!")
    exit() #closes the program
