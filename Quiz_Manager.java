package Assignment_5;
import java.util.Scanner;

public class Quiz_Manager {
	Scanner scanner = new Scanner(System.in);
	int score;
	
	public void start_quiz(String[] subject,String[] question_array,String[] options_array,char[] answer_key) {
		char[] user_answer_key = new char[15];
		System.out.println("Choice the Subjects");
		
		for(int i=0;i<subject.length;i++) {
			System.out.println("type number "+i+" for"+" "+subject[i]);
		}
		
		System.out.print("your response");
		int subject_response = scanner.nextInt();
		scanner.nextLine();
		
		int end = (subject_response+1)*15;
		int start = end - 15;
		
		
		for(int i=start;i<end;i++) {
			System.out.println(question_array[i]);
            System.out.println("a. " + options_array[i * 4]);
            System.out.println("b. " + options_array[i * 4 + 1]);
            System.out.println("c. " + options_array[i * 4 + 2]);
            System.out.println("d. " + options_array[i * 4 + 3]);
			System.out.print("your answer: ");
		optionsFromUser(user_answer_key,start,i);
		}
		calculate_Score(answer_key, user_answer_key,start);
	}
	
	
	public void optionsFromUser(char[] user_answer_key,int start,int i) {
		char user_option;
		while(true) {
			 try {
		            System.out.print("Your answer: ");
		            String input = scanner.nextLine();
		            
		            if(input.length() == 0) {
		            	user_answer_key[i - start] = ' '; 
		            	break;
		            }
		            
		            user_option = input.toLowerCase().charAt(0);
		            
		            if (user_option == 'a' || user_option == 'b' || user_option == 'c' || user_option == 'd' ) {
		                user_answer_key[i - start] = user_option; 
		                break;  
		            } else {
		                System.out.println("Your response is not a/b/c/d or blank");
		            }
		        } catch (Exception error) {
		            System.out.println("Please enter a valid option.");
		            scanner.nextLine();  
		        }
		    }
		}
	
	public void calculate_Score(char[] answer_key,char[] user_answer_key,int start) {
		score = 0;
		for(int i=0;i<user_answer_key.length;i++) {
			if(answer_key[start + i]== user_answer_key[i]) {
				score++;
			}
		}
		System.out.print("Your Score is: "+ score);
	}
}
	
	

