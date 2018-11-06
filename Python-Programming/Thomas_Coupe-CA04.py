#Student ID: 201241037 File name: Thomas_Coupe-CA04
#coded november 2017
#User will be presented with a menu where they will press the option "C" for games. once they have done this they will be playing a 3 dice game that outputs what the user got from each roll.
from random import randint
def main():
    print("\tMAIN MENU")
    print("A. Numbers")
    print("B. Strings")
    print("C. Games")
    print("X. Exit")
    return
main()
option = str(input("Please enter an option(A, B, C or X): ")).upper()
#calling the main menu then asking for the user to input an option.
def pattern():
    dice_order = [a,b,c]
    dice_order.sort()
    if a==b and a==c:
        print("you got three of the same! you got three {}'s ").format(a)
        return "Three of a kind"
    if a!=b and a!=c and b!=c:
        print("all different! {} {} {}".format(a, b, c))
    if a==b or a==c:
        print("you got a pair of {}'s".format(a))
        if b==c:
            print("you got a pair of {}'s".format(b))
            return "a pair"
    if dice_order[1]==dice_order[0]+1 and dice_order[2]==dice_order[0]+2:
            print("You got a Run! {} {} {}".format(dice_order[0], dice_order[1], dice_order[2]))
            return "Run"
#defining all of the outcomes of the die rolls by using if statements and assignment operators
if option == "C":
    input("Press any key to play the 3 die game! ")
    print("You rolled 3 dice and got: ")
    a = randint(1,6)
    b = randint(1,6)
    c = randint(1,6)
#defining the variables that each represent a dice roll. they will be a number with the range of 1 - 6
    print(a)
    print(b)
    print(c)
    pattern()
#calling pattern() after the 3 values of the dice have been revealed 
if option == "X":
    print("You closed the program! ")
    exit()
#using exit() if the user inputs "X" as their option making the program stop and exit.  
    
