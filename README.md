# Exercise 10: UIMA Components and Pipelines


This exercise has the goal of writing a simple UIMA component and integrating it into a pipeline.



## Step 1
Please `clone` the repository `https://github.com/idh-cologne-machine-learning-mit-java/exercise-10`.

Create a new branch, using your UzK username.

## Step 2
As always, inspect existing code. The code in `de.ukoeln.idh.teaching.jml.ex10.Main` contains a simple `main()` function. The function creates and runs a pipeline consisting of a collection reader and a sentence splitter/tokenizer. As it is now, the code throws an exception, because the collection reader (`TextReader`, from the DKpro package) doesn't know where to read files from. Fix this, by adding a parameter `TextReader.PARAM_SOURCE_LOCATION` with a value of `src/main/resources/corpus/*.txt`. This is a large portion of the set of Sherlock Holmes stories by Conan Doyle.

(DKpro is a library that contains pre-packaged NLP components for many NLP tasks. We will talk about DKpro in more detail next week).

## Step 3
Add a new component. The new component is a simple named entity recognizer. The rules for detecting named entities are simple: Each sequence of tokens that start with an upper case letter is a single named entity, unless the sequence starts at the beginning of a sentence. In the latter case, we disregard the first token.

Consider the following examples (named entities marked with brackets):

- My name is [Sherlock].
- My name is [Sherlock Holmes].
- The dog barks.
- The dog barks at [Mr. Holmes].
- Doctor [Watson] was confused.

Implement the component, and add it to the pipeline.

## Step 4
Add a second new component to give out something on the console (`System.out'). For each text, generate a frequency table of all named entities (i.e., how often "Mr. Holmes", "Dr. Watson", "Sherlock Holmes", etc. have been used).

The output shoud look like this (made-up numbers):

```
15 Sherlock Holmes
13 Dr. Watson
123 Professor Moriarty
```

### Step 4.1 (optional)
Change your implementation such that the output is printed into a plain text file, named as the input file. You might want to look at the class `org.dkpro.core.api.io.JCasFileWriter_ImplBase`, which can be used to inherit from.


## Step 5
As always, commit and push your code.