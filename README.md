# Exercise 9: UIMA Type Systems


This exercise has the goal of making you familiar with setting up and using a UIMA type system.



## Step 1
Please `clone` the repository `https://github.com/idh-cologne-machine-learning-mit-java/exercise-09`.

Create a new branch, using your UzK username.

## Step 2
Open the file `src/main/resources/ex09types.xml`. This is our type descriptor file. You'll find some meta data in the file already. Please add the following types: `de.ukoeln.idh.teaching.jml.ex09.types.Token`, `de.ukoeln.idh.teaching.jml.ex09.types.Sentence` and `de.ukoeln.idh.teaching.jml.ex09.types.NamedEntity`, all inherit from `uima.tcas.Annotation`. `Token` and `Sentence` get an id feature, `NamedEntity` gets three features: `NEClass` (a String, to distinguish between person, organization etc.), `Confidence` (to store the probability from an NE recognizer) and `Source` (to store the name of the NER). You may want to verify that your type system description translates to Java code by invoking JCasGen (see documentation [here](https://uima.apache.org/d/uimaj-current/tools.html#ugr.tools.jcasgen)).

## Step 3
Invoking JCasGen manually is not a good strategy. We therefore want to add it to our build process via maven. To this end, add the `jcasgen-maven-plugin` to the `pom.xml` file. It has the groupId `org.apache.uima`, the artifactId `jcasgen-maven-plugin` and version `3.1.1` is the most recent one. You'll find documentation on the configuration on [this page](https://uima.apache.org/d/uimaj-current/tools.html#ugr.tools.jcasgen.maven_plugin). 

If you did everything correctly, each change of the `ex09types.xml` file should result in updated Java classes. By default, they appear in the directory `target/generated-sources/jcasgen`.

## Step 4
The class `de.ukoeln.idh.teaching.jml.ex09.Main` (the only one in the project) contains a line of code to create a `JCas` object for a (very short) text. Add token and sentence annotations for each token and sentence (well, it's only one).

If you have created the types and they have been converted to Java classes, you can create annotations by first creating a Java object and then setting their begin/end features. E.g.:

```java
Token token = new Token(jcas);
token.setBegin(0);
token.setEnd(0);
```

## Step 5
As always, commit and push your code.