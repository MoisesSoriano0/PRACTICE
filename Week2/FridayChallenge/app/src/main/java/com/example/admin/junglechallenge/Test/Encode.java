package com.example.admin.junglechallenge.Test;

import java.util.ArrayList;

public class Encode {

    public static void main(String[] args) {
//        reverse("hello");
//        duplicateChar("holacrayola");

//        encodeString("abcdz");
        encodeString("Errors in strategy cannot be correct through tactical maneuvers");

    }

    public static void encodeString(String input){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String reversedAlphabet = new StringBuilder(alphabet).reverse().toString();
        ArrayList<Integer> intArr = new ArrayList<>();


        String inputString=input.replaceAll("\\s","").toLowerCase().trim();
//        System.out.println("inputString: " + inputString);

            for(int i=0;i<inputString.length();i++){
                 intArr.add(alphabet.indexOf(inputString.charAt(i)));
            }
//                 System.out.println(intArr);

//        System.out.println(reversedAlphabet);


        String result = "";

        for (int k = 0; k < intArr.size(); k++) {
            result += reversedAlphabet.charAt(intArr.get(k)) + "";

        }
        System.out.println(result);

    }

    public static void reverse(String inputString)
    {

        String reverse = "";

        for(int i = inputString.length()-1; i >= 0; i--)
        {

            String x = inputString.charAt(i)+"";
            reverse += x.toLowerCase();

        }

        System.out.println("Input : "+inputString);
        System.out.println("Output : "+reverse);

    }

    public static void duplicateChar(String inputString)
    {
        ArrayList<String> letters = new ArrayList<String>();

        for(int i = 0; i < inputString.length(); i++)
        {
            letters.add(inputString.charAt(i)+"");
        }

        ArrayList<String> duplicates = new ArrayList<String>();
        int count = 0;

        for(int j = 0; j < letters.size(); j++)
        {

            for(int x = 0; x < inputString.length(); x++)
            {

                if(letters.get(j).equalsIgnoreCase(""+inputString.charAt(x)) && !duplicates.contains(letters.get(j)))
                {
                    count++;
                }
            }
            if(count >= 2)
            {
                System.out.println(letters.get(j).toLowerCase() + " = " + count);
                duplicates.add(letters.get(j));
            }
            count = 0;
        }

    }

}
