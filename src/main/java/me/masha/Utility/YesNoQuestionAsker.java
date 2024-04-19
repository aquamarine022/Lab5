package me.masha.Utility;

import me.masha.Constants;

public class YesNoQuestionAsker {
    String question;

    public YesNoQuestionAsker(String question){
        this.question = question;
    }

    public boolean ask(){
        if(Constants.SCRIPT_MODE) return true;
        Console.getInstance().printLn(question +" (yes/no)");
        while (true){
            String answer = Console.getInstance().readLine().trim();
            if (answer.equals("yes")){
                return true;
            }
            if (answer.equals("no")){
                return false;
            }
            Console.getInstance().printLn("Please enter yes or no");
        }
    }
}
