package com.example.gajendraalarm;

public class Question {
    public String[] questions = {
            "Q. _____ is used to find and fix bugs in the Java programs.",
            "Q. Evaluate the following Java expression, if x=3, y=5, and z=10:\n" +
                    "++z + y - y + z + x++",
            "Q. What will be the output ?\n" +
                    "public class Test {  \n" +
                    "public static void main(String[] args) {  \n" +
                    "    int count = 1;  \n" +
                    "    while (count <= 15) {  \n" +
                    "    System.out.println(count % 2 == 1 ? \"***\" : \"+++++\");  \n" +
                    "    ++count;  \n" +
                    "        } } }",
            "Q. How many primitive data types are there in Java ?",
            "Q. Which of the following is a valid declaration of a char ?"
    };
    public String[][] choices = {
            {"JVM","JRE","JDK","JDB"},
            {"20","23","24","25"},
            {"15 times ***", "15 times +++++","8 times *** and 7 times +++++","Both will print only once"},
            {"6","7","8","9"},
            {"char ch = '\\utea';","char ca = 'tea';","char cr = \\u0223;","char cc = '\\itea';"}
    };
    public String[] correctAnswer = {
            "JDB","24","8 times *** and 7 times +++++","8","char ch = '\\utea';"
    };
    public String getQuestion(int a){
        return questions[a];
    }
    public String getChoices1(int a) { return choices[a][0]; }
    public String getChoices2(int a){
        return choices[a][1];
    }
    public String getChoices3(int a){
        return choices[a][2];
    }
    public String getChoices4(int a){ return choices[a][3]; }
    public String getCorrectAnswer(int a){
        return correctAnswer[a];
    }
}
