import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //C:\Users\Rudolfs\Desktop\JSON benchmarks\citylots3.json
        //C:\Users\Rudolfs\Desktop\JSON benchmarks\JSON_small.json
        String fileLocation = "";
        int libraryChoice = 0;
        int process = 0;
        int runs = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file path");
        fileLocation = scanner.nextLine();

        try {
            System.out.println("Pick library: \n" +
                    "1 = Jackson \n" +
                    "2 = Gson \n" +
                    "3 = JSON-P \n" +
                    "4 = JSON-java \n" +
                    "5 = Fastjson \n" +
                    "6 = JSON.simple");
            libraryChoice = scanner.nextInt();

            System.out.println("Pick operation: \n" +
                    "1 = serialize \n" +
                    "2 = deserialize");
            process = scanner.nextInt();

            System.out.println("Enter number of runs: ");
            runs = scanner.nextInt();
            scanner.close();
            Library lib;

            switch(libraryChoice) {
                case 1:
                    lib = new JacksonLibrary(fileLocation);
                    runTests(lib, process, runs);
                    break;

                case 2:
                    lib = new GsonLibrary(fileLocation);
                    runTests(lib, process, runs);
                    break;

                case 3:
                    lib = new JSONPLibrary(fileLocation);
                    runTests(lib, process, runs);
                    break;

                case 4:
                    lib = new JSONJavaLibrary(fileLocation);
                    runTests(lib, process, runs);
                    break;

                case 5:
                    lib = new FastjsonLibrary(fileLocation);
                    runTests(lib, process, runs);
                    break;

                case 6:
                    lib = new JSONSimpleLibrary(fileLocation);
                    runTests(lib, process, runs);
                    break;

                default:
                    System.out.println("Enter library number between 1 and 6");
                    System.exit(0);
                    break;
            }

        } catch(InputMismatchException e) {
            System.out.println("Enter numbers");
            System.exit(0);
        }


    }

    public static void runTests(Library lib, int process, int runs) {
        if(process == 1)
            lib.runSerialize(runs);
        else if(process == 2)
            lib.runDeserialize(runs);
        else {
            System.out.println("Operation has to be 1 or 2");
            System.exit(0);
        }

    }
}
