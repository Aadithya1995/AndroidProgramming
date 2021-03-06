/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.444444
 */

package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    HashSet<String> wordset;

    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
        wordset =new HashSet<>();


        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordset.add(word);
        }


    }
    String sortit(String s)
    {
        char a[];
        a=s.toCharArray();
        //System.out.println(a);
        Arrays.sort(a);
        String k=new String(a);
        return k;
        //System.out.println(k);
    }

   public boolean isGoodWord(String word, String base) {
        if(wordset.contains(word)&&(!word.contains(base)))
        return true;
        return false;
    }

    public List<String> getAnagrams(String targetWord)
    {//not used
        String targetWordl;
        ArrayList<String> result = new ArrayList<>();
        for (char a = 'a'; a <= 'z'; a++)
        {

            targetWordl = targetWord + a;
            targetWordl = sortit(targetWordl);
            String k;
            for (String s : wordset)
            {
                k = sortit(s);
                if (k.compareTo(targetWordl) == 0&&(!s.contains(targetWord)))
                    result.add(s);
            }
        }

            return result;
    }


    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public String pickGoodStarterWord() {
        return "badge";
    }
}
