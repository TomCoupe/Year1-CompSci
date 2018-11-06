#University ID: 201241037 File name: Thomas_Coupe-CA01.py
#Coded October 2017
#This program will take the input values and use them with a series of calculations to calculate the draft.

height = float(input("Enter the height: "))
length = float(input("Enter the length: "))
breadth = float(input("Enter the breadth: "))

weight_of_iron = 1.06
surface_area = (2*height)*(length+breadth)+(length*breadth)
mass_of_barge = surface_area*weight_of_iron
draft = mass_of_barge/(length*breadth)

print("Height entered = {}".format(height))
print("Length entered = {}".format(length))
print("Breadth entered = {}".format(breadth))
print("Calculated draft = {0:.2f}".format(draft))

#TESTING
#height length breadth = draft
#2 3 4 = 3.53
#1 2 3 = 2.83
#5 6 7 = 4.34
