# Word Searching

## Description

This program solves word search puzzles by finding dictionary words hidden in a two-dimensional array of letters.

A word can be formed by starting at any position in the puzzle and moving continuously in one of the eight possible directions:

* Up
* Down
* Left
* Right
* Upper-left diagonal
* Upper-right diagonal
* Lower-left diagonal
* Lower-right diagonal

If a dictionary word appears multiple times in the puzzle, it is printed only once.

## Input Format

The program reads input from standard input in the following format:

1. An integer `N` representing the size of the puzzle (`N × N`).
2. `N` lines containing the puzzle characters, separated by spaces.
3. A list of dictionary words, one word per line, until the end of input.

### Example Input

```
9
m v j l i x a p e
j h b x e e n p p
h k t t h b s w y
r w a i n u y z h
p p f x r d z k q
t p n l q o y j y
a n h a p f g b g
h x m s h w y l y
u j f j h r s o a
algorithm
syzygy
search
rain
```

## Output Format

Print every dictionary word that can be found in the puzzle, one word per line.

If a word occurs more than once, it should be printed only once.

### Example Output

```
algorithm
syzygy
rain
```

## Assumptions

* The puzzle contains only lowercase English letters.
* Dictionary words contain only lowercase English letters.
* Dictionary words are given in lexicographic order.
* All dictionary words are at least four characters long.
* The puzzle size is `N × N`.

## Algorithm Overview

For each dictionary word, the program:

1. Searches the puzzle for the first letter of the word.
2. From each matching position, checks all eight directions.
3. Continues character-by-character in the selected direction.
4. If the entire word matches, the word is added to the output.
5. Ensures each found word is printed only once.

## Complexity

Let:

* `N` be the puzzle dimension.
* `W` be the number of dictionary words.
* `L` be the length of a dictionary word.

Worst-case time complexity:

```
O(W × N² × 8 × L)
```

Space complexity:

```
O(N²)
```

