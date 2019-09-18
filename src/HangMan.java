import java.util.Scanner;
public class HangMan {
    public static void hangMan() {
        String[] worList = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};//Random word list. Yo may update as you wish
        double random1 = Math.random() * worList.length;
        int random2 = (int) random1;
        String random = worList[random2];
        System.out.println(random+"(Printing the random string for test purpose)");
        for (int i = 0; i < random.length(); i++) {//Printing number of _ for user so user can see how many letter the random word has
            System.out.print("_" + " ");
        }
        char[] charWordArr = random.toCharArray();// random word turns in to char array
        char [] printOutChar=new char[charWordArr.length];//cretaing a print out char array for user
        for (int i=0;i<printOutChar.length;i++){//assigning  in to char array _ for every element
            printOutChar[i]='_';
        }
        int firstCounter=0;// this counter for how many time user guess incorrect
        do  {
            System.out.println("\nEnter a letter");
            Scanner sc = new Scanner(System.in);
            char input = sc.next().toLowerCase().charAt(0);//reading from keyboard as a char user guess always lowercase even user enter uppercase
            int secondCounter=0; // second counter for if user guess correct in the random string, first counter will not increase
            for (int i = 0; i < charWordArr.length; i++) {// checking user's guess is in random word
                if (charWordArr[i] == input) {
                    printOutChar[i]=input;
                    secondCounter++;
                }
            }
            if (secondCounter<=0){// if user's guess is not in list first counter will increase 1
                firstCounter++;
            }
            for (int i=0;i<printOutChar.length;i++){// printing updated sitiation for char array so user can see how many letter guested letter in so far
                System.out.print(printOutChar[i]+" ");
            }
            switch (firstCounter){// this switch is giving feedback to user which part of the man has gone
                case 0:
                    break;
                case 1:
                    System.out.println();
                    System.out.println("     |");
                    break;
                case 2:
                    System.out.println();
                    System.out.println("     |");
                    System.out.println("     0");
                    break;
                case 3:
                    System.out.println();
                    System.out.println("     |");
                    System.out.println("     0");
                    System.out.println("    /|\\ ");
                    break;
                case 4:
                    System.out.println();
                    System.out.println("     |");
                    System.out.println("     0");
                    System.out.println("    /|\\ ");
                    System.out.println("    / ");
                    break;
                case 5:
                    System.out.println();
                    System.out.println("GAME OVER");
                    System.out.println("     |");
                    System.out.println("     0");
                    System.out.println("    /|\\ ");
                    System.out.println("    / \\");
                    break;
            }
        } while (firstCounter<=4);
    }

    public static void main(String[] args) {
        hangMan();
    }
}
