import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 8/5/13
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        URL url = new URL("https://dl.dropboxusercontent.com/u/129841492/dict.txt");
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            //construct dictionary collection from an online txt file, which is including all english words
            inputStreamReader = new InputStreamReader(url.openStream());
            bufferedReader = new BufferedReader(inputStreamReader);

            HashMap<String, ArrayList<String>> dictionary = new HashMap<String, ArrayList<String>>();
            ArrayList<String> wordList;
            String tempDictWord;
            int count = 0;

            while ((tempDictWord = bufferedReader.readLine()) != null) {

                tempDictWord = tempDictWord.toLowerCase();
                String tempKeyOfDictWord = generateKeyHelper(tempDictWord);

                if (dictionary.containsKey(tempKeyOfDictWord)) {
                    wordList = dictionary.get(tempKeyOfDictWord);
                    wordList.add(tempDictWord);
                } else {
                    wordList = new ArrayList<String>();
                    wordList.add(tempDictWord);
                    dictionary.put(tempKeyOfDictWord, wordList);
                }
                count++;
            }
            System.out.println("Dictionay is successfully constructed of " + count + " words.");
            System.out.println();

            //finish constructing the dictionary and start a command line prompt to retrieve user's input
            String input;

            inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);

            System.out.println("Please input a word:");
            System.out.println();

            HashMap<String, String> tempKeys, res = new HashMap<String, String>();

            while ((input = bufferedReader.readLine()) != null) {

                input = input.toLowerCase();

                if(input.length() > 0){

                    tempKeys = allSubStringsHelper(input);

                    for (String str : tempKeys.keySet()) {
                        if (dictionary.containsKey(str)) {
                            for (String s : dictionary.get(str)) {
                                res.put(s, s);
                            }
                        }
                    }

                    if (res.size() == 0) {
                        System.out.println("No proper results can be found in the dictionary.");
                        System.exit(1);
                    } else {
                        System.out.print("Result sets are : ");
                        for (String str : res.keySet()) {
                            if(!str.equals(input)){
                                System.out.print(str + " ");
                            }
                        }
                        System.exit(1);
                    }

                }else {
                    System.out.println("Input cannot be null");
                    System.out.println();
                    System.out.println("Please input a word:");
                    System.out.println();
                }

            }

            System.exit(1);

        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

    }

    //stand for purpose of mapping one key to many words: i.e., god, dog can both be mapped by key 'dgo' (char in key is sorted in alphabetical order)
    public static String generateKeyHelper(String str) {
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        return new String(strArray);
    }

    //find all SubStrings of a given string
    public static HashMap<String, String> allSubStringsHelper(String str){
        HashMap<String, String> res = new HashMap<String, String>();

        if(str.length() > 1){

            for(int i = 0; i < str.length(); i++){

                for(int j = 1; j <= str.length() - i; j++){
                    String temp = str.substring(i, i+j);
                    temp = generateKeyHelper(temp);
                    res.put(temp, temp);
                }

            }

        }else {
            res.put(str, str);
        }

        return res;
    }

}
