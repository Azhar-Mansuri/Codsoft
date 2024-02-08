//WORD COUNTER

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Scanner;

public class task2
{
    static String user_input;
    static int wordcounter=0;
    static int unique_WordCounter=0;
    static int common_WordCounter=0;

    static HashSet<String> uniquWords = new HashSet<>();
    static HashSet<String> commonWords = new HashSet<>();

    static void welcome_Method()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("\t\t\t ========================> * * * WLECOME TO  WORD COUNTER  * * * <========================");
        System.out.println("\n");
        System.out.println("\t\t\t\t            [ ENTER THE TEXT OR ENTER THE FILE NAME (.txt)* ]  \n");
        System.out.print("YOU ENTERED : ");
        user_input = sc.nextLine();
        System.out.println("\n");

    }
    static void lastLine_Method()
    {
        System.out.println("\t\t\t ==========================> * * * > > > > > E N D < < < < < * * * <=======================");
    }

    public static void main(String[] args)
    {
        welcome_Method();
        if(user_input.contains(".txt"))
        {
            File file = new File(user_input);
            try
            {
                BufferedReader br = new BufferedReader(new FileReader(file));
                try
                {
                    String line = br.readLine();
                    while (line != null)
                    {
                        String store = new String(line);
                        String words[] = store.split("\\s");

                        for (String s : words)
                        {
                            wordcounter++;
                            if(uniquWords.add(s))
                            {
                                unique_WordCounter++;
                            }
                            else
                            {
                                if(commonWords.add(s))
                                {
                                    common_WordCounter++;
                                }
                            }

                        }
                        line = br.readLine();
                    }

                    br.close();

                    System.out.println("TOTAL WORDS IN YOUR FILE : "+wordcounter);
                    System.out.println();
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            String text = user_input;
            text.trim();
            String words[] =  text.split("\\s");

            for (String string : words)
            {
                wordcounter++;
                if( uniquWords.add(string) )
                {
                    unique_WordCounter++;
                }
                else
                {
                    if(commonWords.add(string))
                    {
                        common_WordCounter++;
                    }
                }
            }

            System.out.println("TOTAL WORDS IN YOUR TEXT IS "+wordcounter);
            System.out.println("\n");
        }

        System.out.println("TOTAL UNIQUE WORDS : "+unique_WordCounter);
        System.out.println();
        System.out.println("TOTAL COMMON WORDS : "+common_WordCounter);
        System.out.println("\n");
        lastLine_Method();

        System.out.println("\n");
    }
}
