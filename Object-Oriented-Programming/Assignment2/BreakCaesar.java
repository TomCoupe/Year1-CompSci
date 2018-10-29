import java.lang.Math.*;
 
public class BreakCaesar {
	public static String message;
	public static String decryptedMessage = "";
	public static int shiftValue;
	public static char ch;
	public static char[] loweralphabet = new char[26];
	public static char[] upperalphabet = new char[26];
	public static double[] knownFreq = {0.0855, 0.0160, 0.0316, 0.0387, 0.1210,
	0.0218, 0.0209, 0.0496, 0.0733, 0.0022,
	0.0081, 0.0421, 0.0253, 0.0717, 0.0747,
	0.0207, 0.0010, 0.0633, 0.0673, 0.0894,
	0.0268, 0.0106, 0.0183, 0.0019, 0.0172,
	0.0011};
	
	public static void main(String[] args) {
		int counter = 0; //counter is acting as an index for the positions in the list
		for (char c = 'a'; c <= 'z'; c++){ //looping through each char in the alphabet and adding each chat to loweralphabet and upperalphabet
			loweralphabet[counter] = c;
			upperalphabet[counter] = Character.toUpperCase(c); //turning the chars in upperalphabet to uppercase characters
			counter++; //increasing counter by 1 each loop.
		}
		if (args.length == 0) { //checking to ensure that the user inputs a message into the args
			System.out.println("Oops, you have not given enough parameters!");
			System.exit(1); //closes program if the user did not enter a string into the args
		}
		message = args[0]; //declaring message from the args
		double lowestValue = closeness(message); 
		String lowestMsg = message;
		
		for (int shiftValue = 0; shiftValue < 26; shiftValue++) { //iterating through all possible shift values
			for(int x = 0; x < message.length(); x++) { //iterating through each character in the message
				ch = message.charAt(x); //representing each character in message with "ch"
				if(ch >= 'a' && ch <= 'z') { //if ch is between "a" and "z" in the alphabet
					ch = (char)(ch - shiftValue); //it will minus the shiftvalue for each character
					if(ch < 'a') {
						ch = (char)(ch + 'z' - 'a' + 1); // if ch is less than "a" it is equal to "z"
					}
					decryptedMessage += ch;	
				}
				else if(ch >= 'A' && ch <= 'Z') { //if ch is between "A" and "Z" in the alphabet
					ch = (char)(ch - shiftValue); //it will minus the shiftvalue for each character
					if(ch < 'A') {
						ch = (char)(ch + 'Z' - 'A' + 1); // if ch is less than "A" it is equal to "Z"
					}
					decryptedMessage += ch;
				}
				else {
					decryptedMessage += ch;
				}
			}
			//this if statement gets the lowest frequency value by using the closeness function with the decrypted message
			if (lowestValue > closeness(decryptedMessage)){
				lowestValue = closeness(decryptedMessage);
				lowestMsg = decryptedMessage;
			}		
			decryptedMessage = "";
		}
		System.out.println("=========================================");
		System.out.println(message); //outputting the encrypted message
		System.out.println("=========================================");
		System.out.println(lowestMsg); //outputting the decrypted message based upon the lowest frequencies
    }
    //this function looks at each character in a string and calculated the frequency based upon how often then appear in the string
	public static double frequency(String message, char ch) { 
		double charCounter = 0; //charCounter increases by one each time a seperate character is found in the string
		for (int i = 0; i < message.length(); i++) { // iterates through each character of message
			if (message.charAt(i) == ch) {
				charCounter++; //increasing charCounter by 1 each time a certain character is found in the string
			}
		}
	    return charCounter/message.length(); //dividing charCounter by message length to get a decimal value so it can be used in the closeness function
	}	
	
	public static double closeness(String message) {
        double top = 0;
        double bottom = 0;
        char character;
        int msg_len = message.length();
        for (int i = 0; i < msg_len; i++){ //iterating through each character in message length
            for (int y = 0; y < 26; y++){ //iterating through all 26 letters of the alphabet
                character = message.charAt(i); 
                if (character == upperalphabet[y] || character == loweralphabet[y]){ //if the characters within the message are in the loweralphabet or upperalphabet
                    top = Math.pow((frequency(message,character)-knownFreq[y]),2); //using the calculation given to us in the assignment brief
                    bottom = bottom +(top/(knownFreq[y])); // dividing the value of the calculation by the knownFreq[y] 
				}
            }
        }
        return bottom; //returning the final calculation value
    }
}
