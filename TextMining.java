import java.util.Scanner;

public class TextMining {
	public static void main(String[] args) {

		Scanner wordScanner = new Scanner(System.in);
		System.out.print("Enter a search word: ");
		String word = wordScanner.next();

		Scanner textScanner = new Scanner(System.in);
		System.out.print("Enter a string of words(words separated by single spaces or tabs): ");
		String text = textScanner.nextLine();

		System.out.println("------");
		int count = countGivenWord(text, word);
		if (count > 0) {
			System.out.println("Great, "+ "\"" + word + "\"" + " appears in the text and it's word count is " + count);
		}


		System.out.println("The total word count is "+ countWords(text));

		System.out.println("The total number of unique words in the text " + countUniqueWords(text));

		System.out.println("The total number of unique words minus stopwords in the text " + countUniqueWithoutStopword(text, word));
	}

	public static int countGivenWord(String text, String word) {
		int count = 0;
		int endOfLine = text.length() - 1; 

		if (text.indexOf(word) > -1) {
			for (int location = text.indexOf(word); location != -1; location = text.indexOf(word, location + word.length())) {
				int end = location + word.length();
				// Make sure it is not a substring contains the givin word
				if (end == text.length() || !Character.isLetter(text.charAt(end))) {
					count++;
				}	
			}   
		}

		return count;
	}

	public static int countWords(String s){
		int wordCount = 0;

		boolean isWord = false;
		int endOfLine = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {
             // The current char is a letter.
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				isWord = true;
            // When the current char isn't a letter but the previous one is, find a word. 
			} else if (!Character.isLetter(s.charAt(i)) && isWord) {
				wordCount++;
				isWord = false;
            // Hit the end of the string
		    // Or the end is a non letter.
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				wordCount++;
			}
		}

		return wordCount;
	}

	public static int countUniqueWords(String s){
		int wordCount = 0;

		boolean isWord = false;
		int endOfLine = s.length() - 1;

		int startIndex = 0;
		int endIndex = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				isWord = true;
			} else if (!Character.isLetter(s.charAt(i)) && isWord) {
				endIndex = i;

                // search the current word in the rest of the string and count its occurrences
				String currentWord = s.substring(startIndex, endIndex);
				String restS = s.substring(endIndex);
				if (countGivenWord(restS, currentWord) == 0) {
					wordCount++;
				}
				
				startIndex = i + 1;
				isWord = false;
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				wordCount++;
			}
		}

		return wordCount;
	}

	public static int countUniqueWithoutStopword(String s, String stopword){
		int wordCount = 0;

		boolean isWord = false;
		int endOfLine = s.length() - 1;

		int startIndex = 0;
		int endIndex = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				isWord = true;
			} else if (!Character.isLetter(s.charAt(i)) && isWord) {
				endIndex = i;

				String currentWord = s.substring(startIndex, endIndex);
				String restS = s.substring(endIndex);
				if (!currentWord.equals(stopword) && countGivenWord(restS, currentWord) == 0) {
					wordCount++;
				}
				
				startIndex = i + 1;
				isWord = false;
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                // make sure the last word is not the stop word
				String lastWord = s.substring(startIndex);
				if (!lastWord.equals(stopword)) {
					wordCount++;
				}
			}
		}

		return wordCount;
	}
}
