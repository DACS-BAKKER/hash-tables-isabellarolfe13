# hash-tables-isabellarolfe13
hash-tables-isabellarolfe13 created by GitHub Classroom

VIEW THIS READ ME RAW

My Hash Function (total files: 2)	
        -Run HashTables
        -need wordFile.txt
About: HashTables.java prints out, after it hashes worldFile.txt, the location of every word that hashed and the total number of collisions.

Analysis: When I first started to create my Hash function I knew it was important to minimize the number of collisions to maximize performance. I thought about the differences between an array and a HashTable. For a hash table to get() an item is 0(1). With an unordered array, the program has to go through the whole list to get an item. The only aspect limiting the get() is collisions. When an item in my HashTables hashes to the same place that another item is already in, I simply move its place in my HashTables over by one until there is an empty place. I decided to start with my hash table being 1.3 x the size of word list that I was reading in. 

The first Hash function that I wrote consisted of adding up the letters place in the alphabet of the word and multiplying that by the prime number 13. I then wanted to incorporate the size of my HashTable into my function so I used modulus operator and % the sum by the size.  I thought this was a good hash function to start with because it incorporated a prime number which would make it less likely to have collisions. I also thought this method was unique enough to limit collisions. However, when I ran it with a size of at 1,300 there were 639 collisions. I realized my function was hashing at least 7 words at a time to the same place. This was because adding all of the positions in the alphabet up and multiplying it by the same number resulted in numbers that were very close to each other. I realized I needed to make my method more unique for individual words. I decided to incorporate the idea that it mattered the location of each letter in the word. For every letter in the word I multiplied it by my prime number 13*it locations in the alphabet AND multiplied it by its spot in the word and then added this to the pos variable. This small increment reduced collisions. I also added all the values for the letters in the word and added it onto pos at the end. This helped increase individuality for words. My collisions number went from 639 to 68 by adding these changes. Then, I began to think about the size of my HashTable and how that impacts collisions. I tested increasing and decreasing my HashTable. Increasing a hash tables decreases the amount of collisions (line 41 % by size). By increasing the size of the table, the “fullness” of the table decreases. The hash tables performance therefore directly depends on how much space is allocated. To decrease collisions I needed to increase the size of my Hash function AND edit my function to make the hash more unique for individual words. I increased the size to 8,000 and had 92 collisions. I had to increase my hash number when I increased the size so I changed my prime number from 13 to 31. The smaller the size of my hash table, the more collisions. There can still be improvements made on my hash function. In an ideal world, there would be little to no collisions. 

I also timed my get() and put() methods and timed it depending on how big the data set was. However, my findings are not applicable and able to be analyzed because I don’t think the data set I used was big enough to have an impact on the performance.

Shakespearean Concordance (Console Program) (total files: 7)	
        -Run SonnetConcordanceConsole.java
        -HashTablesWordConsole.java	
        -SonnetReaderConsole.java	
        -References.java	
        -Sonnet.java	
        -Word.java	
        -shake.txt (text file with Shakespeare’s texts
       
Shakespearean Concordance (with Graphics and User Interface) (total files: 8)	
        -Run Graphics.java-this is all graphics and user interface
        -SonnetConcordance.java - program Concordance
        -HashTablesWord.java-Hash table file
        -References.java
        -Sonnet.java
        -SonnetReader.java
        -Word.java
        -shake.txt (text file with Shakespeare’s texts)
