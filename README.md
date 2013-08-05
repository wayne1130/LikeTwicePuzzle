LikeTwice Puzzle
===============

A word jumble solution

Programming language: Java

Puzzle description
------------

The program should accept a string as input, and then return a list of words that can be created using the submitted letters.  
For example, on the input "dog", the program should return a set of words including "god", "do", and "go".

Solution
------------

Two main steps in my algorithm:
  
1. Generating a `dictionary` collection in memory.
  
2. Considering the input via command line, find all possible substrings, then looking for words against keys in `dictionary`.
  
Generating `dictionary`
------------

The `dictionary` is constructing from an online [text file](https://dl.dropboxusercontent.com/u/129841492/dict.txt). 

The text file is considered as including all english words, one per line.

All words that shared the same `Key`, will be assciated with that `Key` in hashmap collection. 

`Key` is generated based on characters in a given word. For example, both "dog" and "god" associate with key "dgo".

Looking for result words
------------

1. Find all possible substrings from user's input via command line.
2. Check each substring against key in dictionary hashmap collection. 
3. Combine all proper results and print out.

About the english words list
------------

The original word list resource: http://www-01.sil.org/linguistics/wordlists/english/. 


