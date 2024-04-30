// Java program to implement 
// Hangman game 

import java.util.Scanner; 
import java.util.Random; 

class Game { 
    public static void main(String[] args) 
	{ 
		// play hangman game 
		hangman(); 
	} 
	static Scanner input; 
	public static void hangman() 
	{ 
		input = new Scanner(System.in); 

		// array of strings containing words 
		String[] company = { "apples", "banana", "papaya", "Lemons", "orange","cherry","berry","tomato"}; 
		System.out.println( " Welcome to HANGMAN GAME "); 

		Random obj = new Random(); 
		int Ran_num = obj.nextInt(6); 

		// takes input of the word 
		String word = (company[Ran_num]); 
		word = word.toUpperCase(); 

		// To show the word in underscores 
		String word1 = word.replaceAll("[A-Z]", "_ "); 

		// play the game 
		System.out.println("let's play the game"); 
		startGame(word, word1); 
	} 
	public static void startGame(String word, String word1) 
	{ 
 
		int guess_num = 0; 
		int wrong = 0; 
		String guess; 
		char letter; 
		boolean guessescontainsguess; 
		String guesses = ""; 
		boolean guessinword; 

		while (wrong < 5 && word1.contains("_")) { 

			System.out.println(word1 + "\n"); 
			int temp = 5 - wrong; 
			if (wrong != 0) { 

				System.out.println("You have " + temp 
								+ " guesses left."); 
			} 

			System.out.print("Your Guess:"); 

			// takes guess input 
			guess = input.nextLine(); 

			// converts to uppercase 
			guess = guess.toUpperCase(); 

			// gets the first letter 
			letter = guess.charAt(0); 

			guessescontainsguess 
				= (guesses.indexOf(letter)) != -1; 

			// stores every letter that is guesses
			guesses += letter; 

			// converts to uppercase for 
			letter = Character.toUpperCase(letter); 
			System.out.println(); 

			// if letter already guessed 
			if (guessescontainsguess == true) { 

				// already guessed letter 
				System.out.println("You ALREADY guessed "
								+ letter + ". \n"); 
			} 

			// guessed letter is in the word 
			guessinword = (word.indexOf(letter)) != -1; 

			if (guessinword == true) { 

				System.out.println( 
					letter + " is present in the word."); 
				System.out.print("\n"); 

				// find the letter positions 
				// replace dashes with those 
				// letter at valid positions 
				for (int position = 0; 
					position < word.length(); position++) { 

					// guessed letter is equal to letter at position

					if (word.charAt(position) == letter 
						&& word1.charAt(position) 
							!= letter) { 

						word1 = word1.replaceAll("_ ", "_"); 
						String word2; 
						word2 = word1.substring(0, position) 
								+ letter 
								+ word1.substring(position 
												+ 1); 
						word2 = word2.replaceAll("_", "_ "); 
						word1 = word2; 
					} 
				} 
			} 
 
			else { 
// incrementas no of wrongs
				System.out.println( 
					letter 
					+ " is not present in the word."); 
				wrong++; 
			} 

			// shows remaining guesses 
			guess_num++; 

		}

		// if the lifelines finishes 
		if (wrong == 5) { 
			System.out.println( 
				"YOU LOST!, maximum limit of incorrect guesses reached."); 
		} 
		else { 

			// when all letters guessed correctly
			System.out.print( 
				"The word is: " + word1 
				+ "\n Well Played, you did it!!"); 
		} 
	} 		
}
