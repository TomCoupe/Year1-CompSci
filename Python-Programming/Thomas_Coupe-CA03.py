#University ID: 201241037 File Name: Thomas_Coupe-CA03.py
#Coded 23rd October 2017
#User will be prompted with a menu asking them to input one of the 4 options, after selecting the option they will be prompted to input a number with the range being 1 - 27. this will then output in a triangular shape.
def main():
    print("\tMain menu".upper())
    print("\tA. Numbers")
    print("\tB. Strings")
    print("\tC. Games")
    print("\tX. Exit")
main()
option = str(input("Enter an option (A, B, C or X): ")).upper()
if option == "A":
    num = int(input("Enter a number: "))
    if num<=0 or num>27:
        print("The number is not between 1 and 27! ")
        num = int(input("Enter a number (Between 1 and 27): "))
elif option == "B":
    print("You chose the wrong option! ")
elif option == "C":
    print("You chose the wrong option! ")
for i in range(1,num+1):
    for y in range(num-i,):
        print(" ",end="")
    for z in range(i):
        print(i,end=" ")
    print()
    
    
    
    
    



