#201241037 , Thomas_Coupe-CA06.py
#coded november of 2017
#The program will take morse code from the user and will use a set of dictionaries in order to trnslate the morse code to english.
def main():
    print("=========================")
    print("\tMAIN MENU")
    print("=========================")
    print("A. Numbers")
    print("B. Strings")
    print("C. Games")
    print("X. Exit")
main()

option = str(input("Please select an option from the menu above (A, B, C or X): ").upper())

if option == "X":
    print("You closed the program ")
    exit()
    
unordered = {
    'B': '-...',
    'C': '-.-.',
    'G': '--.',
    'H': '....',
    'D': '-..',
    'F': '..-.',
    'M': '--',
    'N': '-.',
    'J': '.---',
    'K': '-.-',
    'L': '.-..',
    'P': '.--.',
    'Q': '--.-',
    'R': '.-.',
    'V': '...-',
    'W': '.--',
    'X': '-..-',
    'S': '...',
    'T': '-',
    'Y': '-.--',
    'Z': '--..'} 

vowels = {
    'A': '.-',
    'E': '.',
    'I': '..',
    'O': '---',
    'U': '..-'}


numbers = ["0","1","2","3","4","5","6","7","8","9"]
#list of numbers
morsenumbers = ["-----",".----","..---","...--","....-",".....","-....","--...","---..","----."]
#list of morse numbers index corresponding to the their actual numbers
ordered_letters = {**unordered, **vowels}
#merging lists
morsedictnumbers = {}
#declaring dictionary names
f_morsedictnumbers = {}
#declaring dictionary names
for i in range(len(numbers)):
    morsedictnumbers[numbers[i]] = morsenumbers[i]
#the position in the list of numbers is the same as the position for the morse numbers
flippedMDN = list(morsedictnumbers.items())
#flippedMDN is a reversed output of the numbers dictionary
flippedMDN.reverse()
print(flippedMDN)
for k in flippedMDN:
    f_morsedictnumbers[k[0]] = k[1]
#k[0] and k[1] represent the index of the numbers to the morse code numbers
    
def printflippedMDN():
#creating a function to output the reversed numbers
    print("Flipped Numbers: ")
    for i, v in f_morsedictnumbers.items():
        print("\t{} = {}".format(i, v))
#output the reversed numbers
    print("Non-flipped numbers: ")
    for i, v in morsedictnumbers.items():
        print("\t{} = {}".format(i, v))
#output the non-reversed numbers
def printletter():
    print("Letters: ")
    for i, v in sorted(ordered_letters.items()):
        print("\t{} = {}".format(i, v))

def printunordered():
    print("Unordered Letters:")
    for i, v in sorted(unordered.items()):
        print("\t{} = {}".format(i, v))
#printing the list of unordered letters with the vowels added
def getword(word):
    new_word = ""
    for i in range(len(word)):
        if word[i] != " ":
            new_word = new_word + word[i]
        else:
            return new_word

#get word gets the first word of a string. I use this for the morse code
#so i can separate each letter. For example:
#getword("--.- --. .---")
#this would return "--.-"
       
def getallwords(string):
    strword = string
    word = []
    while True:
        if getword(strword) != None:
            word.append(strword[:len(getword(strword))])
            strword = strword[len(getword(strword))+1:]
        else:
            word.append(strword)
            return word
printunordered()    
printletter()
#outputting the list of letters
printflippedMDN()
#outputting the flipped numbers and the non-flipped numbers
print()

decoded_string = ""
#string to decode
decode = str(input("Enter code to be decoded: "))
decodeinput = getallwords(decode)
for k in decodeinput:
    if k == "/":
# k is each of the letters of the decoded word
# the slashes can be used by the user to seperate the words in morse code
        decoded_string = decoded_string + " "
    else:
        for i, v in (ordered_letters.items()):
            if k == v:
                decoded_string = decoded_string + i
        for i, v in (morsedictnumbers.items()):
            if k == v:
                decoded_string = decoded_string + i
print("\nDecoded string:\n\t{}".format(decoded_string))
# outputting the decoded string
if option == "B":
    printletter()

