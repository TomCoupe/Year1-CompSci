#201241037, Thomas_Coupe-CA07.py
#Coded december of 2017
#The program will take the users input from the menu and then run the game Go. players will take turns selecting squares with their numbers attempting to get a 2x2 slot of their number.
row = 5
col = 5
Board = [[0]*col for i in range(row)]
#the variable Board is set as a 5x5 of 0's. this will be used to visualise the board to the users.
changedzeros = []

def player_1():
#this function contains everything that happens on player 1's turn
    while True:
#using a while loop so that once the player has had there go, it will break from the loop and move onto player 2's turn
        p1 = int(input("\nPlayer 1's turn, Select a square from the grid (1 - 25) "))
        x=((p1-1)%5)
        y=((p1-x+1)//5)
#selecting a position from the board using x and y to choose the row and column
        if Board[y][x] == 1 or Board[y][x] == 2:
            print("\nThis Square has already been chosen, please select a different Square")
#saying that if there is already a 1 or 2 in the square selected you need to choose a different square
        elif not (p1 >=0 and p1 <=25):
            print("\nPlease Select a Square between 1 and 25")
#ensuring that the square selected is between 1 and 25
        else:
            Board[y][x] = 1
            break

def player_2():
#this function contains everything that happens on player 2's turn
    while True:
#again im using a loop here to make sure that unless player 2 successfully has their turn it will keep looping until they successfully have a turn
        p2 = int(input("\nPlayer 2's Turn. Select a square from the grid (1 - 25) "))
        x=((p2-1)%5)
        y=((p2-x+1)//5)
#selecting a position from the board usuing x and y to choose the row and column
        if Board[y][x] == 1 or Board[y][x] == 2:
            print("\nThis Square has already been chosen, please select a different Square")
#saying that if there is already a 1 or 2 in the square selected you need to choose a different square
        elif not (p2 >=1 and p2 <=25):
            print("\nPlease Select a Square between 1 and 25")
#ensuring that the square selected is between 1 and 25
        else:
            Board[y][x] = 2
            break

def show_The_board(l):
    print()
    for i in l:
        print("\t"+str(i))
#this function is really important. after each turn it will update the board with the new values of the squares
        
def Game():
#the "Game" function sets the requirements in order for someone to win by getting a 2x2 section of their numbers.
    while True:
        show_The_board(Board)
#calling the show_the_board function to show an updated version of the board
        player_1()
#player 1's  turn
        if len(changedzeros)<25:
#saying that if the number of squares that are now 1 or 2 is under 25 then player 1 can continue their go.
            for v in range(4):
                for k in range(4):
                    try:
# using the "try" function to set an exception

                        if Board[v][k]== 1 and Board[v+1][k]== 1 and Board[v][k+1]== 1 and Board[v+1][k+1]== 1:
                            show_The_board(Board)
                            print("\nPlayer 1 Has won Go!")
# saying that if there is a set of 1's positioned on the board in a 2x2 position, player 1 wins.
                            return
                        elif Board[v][k]==2 and Board[v+1][k]==2 and Board[v][k+1]==2 and Board[v+1][k+1]==2:
                            show_The_board(Board)
                            print("\nPlayer 2 Has won Go!")
# saying that if there is a set of 2's positioned on the board in a 2x2 position, player 2 wins.
                            return
                    except IndexError:
                        pass
        elif len(changedzeros)==25:
            print("\nNo one Won. It's a draw!")
            return
#saying that if the squares containing either 1's or 2's if equal to 25 then nobody wins and its a draw as there are no more squares to play on.
        show_The_board(Board)
#updating the board
        player_2()
#player 2's turn
        if len(changedzeros)<25:
#saying that if the number of squares that are now 1 or 2 is under 25 then player 2 can continue their go.
            for v in range(4):
                for k in range(4):
                    try:
# using the "try" function to set an exception
                        if Board[v][k]== 1 and Board[v+1][k]== 1 and Board[v][k+1]== 1 and Board[v+1][k+1]== 1:
                            show_The_board(Board)
                            print("\nPlayer 1 is the Winner!")
# saying that if there is a set of 1's positioned on the board in a 2x2 position, player 1 wins.
                            return
                        elif Board[v][k]==2 and Board[v+1][k]==2 and Board[v][k+1]==2 and Board[v+1][k+1]==2:
                            show_The_board(Board)
                            print("\nPlayer 2 is the Winner!")
# saying that if there is a set of 2's positioned on the board in a 2x2 position, player 2 wins.
                            return
                    except IndexError:
                        pass
        elif len(changedzeros)==25 :
            print("\nNo one Won. It's a draw!")
#saying that if the squares containing either 1's or 2's if equal to 25 then nobody wins and its a draw as there are no more squares to play on.           return

def howToPlay():
    print()
    print("""
You have chosen to play Go!
How to play:
In Go you will need two players, each player will take turns chosing a square from a 5x5 board and turning it into their number.
For example, if you're player 1 your number will be 1 and if you're player 2 your number will be 2.
To win at Go you need to populate a 2x2 section on the board with your number, for example:
2 2
2 2

Have fun playing! """)
#set of instructions on how to play the game. this function is called when the user selects option "C" from Main()
    Game()
#calling the Game() function after the instructions have been output to the players


def Main():
    while True:
#putting the menu in a while loop so that if the option is equal to C it will break and call the howtoplay function
        print("=========================")
        print("\tMAIN MENU")
        print("=========================")
        print("A. Numbers")
        print("B. Strings")
        print("C. Games")
        print("X. Exit")
        print()  
        option = str(input("Enter an option(A, B, C or X): ")).upper()
        if option == "A":
            print("Please select another option")
            pass
#using a pass function so that if option "A" is selected the user will have to reinput another option
        elif option == "B":
            print("Please select another option")
            pass
#using a pass function so that if option "B" is selected the user will have to reinput another option
        elif option == "C":
            howToPlay()
            break
        elif option == "X":
            print("You have closed the program, Goodbye! ")
            exit()
#closes the program
        else:
            print("That is not a valid option")

Main()
#calling the Main() function
