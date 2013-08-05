LikeTwicePuzzle
===============

A word jumble solution

Programming language: Java

Puzzle description:
The program should accept a string as input, and then return a list of words that can be created using the submitted letters.  
For example, on the input "dog", the program should return a set of words including "god", "do", and "go".

Solution:
Two main steps in my algorithm:
  First step, generating a dictionary collection in memory.
  Second step, considering the input via command line, find all possible substrings, then looking for words against keys in dictionary collection.
  
Generating dictionary:
The dictionay is constructing from an online text file (https://dl.dropboxusercontent.com/u/129841492/dict.txt). 
The text file is considered as including all english words, one per line.
All words that shared the same key, will be assciated with that key in hashmap collection. 
Key is generated based on characters in a given word. For example, both "dog" and "god" associate with key "dgo".

Looking for result words:
Firstly, find all possible substrings from user's input via command line.
Then, check each substring against key in dictionary hashmap collection. Combine all proper results and print out.

About the english words list
The original word list resource: http://www-01.sil.org/linguistics/wordlists/english/. 


