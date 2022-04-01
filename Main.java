import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[] wrongChar = {'0','0','0','0','0','0'};
        char[] thereChar = {'0','0','0','0','0','0'};
        char[] rightChar = {'0','0','0','0','0','0'};
        System.out.print("회색 글자의 갯수를 입력하세요.");
        int wrong = input.nextInt();
        int[] rightPlace = new int[6];


        if (wrong > 6 || wrong < 0) {
            System.out.println("범위 오류입니다.");

            System.exit(0);
        } else if (wrong != 0) {
            System.out.println("회색 글자를 입력하세요.");
            for (int i = 0; i < wrong; i++) {
                System.out.print((i + 1) + " : ");
                String s = input.next();
                wrongChar[i] = s.charAt(0);
            }

        }
        System.out.print("노란 글자의 갯수룰 입력하세요.");

        int there = input.nextInt();

        if (there > 6 || there < 0) {
            System.out.println("범위 오류입니다.");

            System.exit(0);
        } else if (there != 0) {
            System.out.println("노란 글자를 순서대로 입력하세요.");

            for (int i = 0; i < there; i++) {
                System.out.print(i + " : ");
                String s = input.next();
                thereChar[i] = s.charAt(0);
            }
        }


            System.out.print("초록 글자의 갯수를 입력하세요.");

            int right = input.nextInt();

            if (right > 6 || right < 0) {
                System.out.println("범위 오류입니다.");

                System.exit(0);
            } else if (right != 0) {
                System.out.println("초록 글자의 위치를 입력하세요. 0 1 2 3 4 5");
                for (int i = 0; i < right; i++) {
                    rightPlace[i] = input.nextInt();
                }

                System.out.println("초록 글자를 순서대로 입력하세요.");

                for (int i = 0; i < right; i++) {
                    System.out.print(i + " : ");
                    String s = input.next();
                    rightChar[i] = s.charAt(0);
                }
            }
System.out.println(wrongChar);
System.out.println(thereChar);
System.out.println(rightChar);

                try {
                    File key = new File("C:/Users/civbf/Project/WordleAns/src/main/java/AnsKey.txt");
                    Scanner reader = new Scanner(key);
                    while(reader.hasNextLine()){
                        String data = reader.nextLine();
                        boolean ifYes1 = true;
                        boolean ifYes2 = true;
                        boolean ifYes3 = false;
                        for (int k =0; k<wrong ; k++){
                            if(data.contains(String.valueOf(wrongChar[k]))){
                                ifYes1 = false;
                            }
                        }

                        for (int h = 0; h<there; h++){
                            if(!data.contains(String.valueOf(thereChar[h]))){
                                ifYes2=false;
                            }
                            }

                        for (int l = 0; l<right; l++){
                            if(data.indexOf(rightChar[l])==(rightPlace[l]+4)){
                                ifYes3=true;
                            }
                        }
                        if (ifYes1&&ifYes2&&ifYes3){
                            System.out.println(data);
                        }
                    }



                } catch (FileNotFoundException e) {
                    System.out.println("An error occured");

                }
            }
        }
