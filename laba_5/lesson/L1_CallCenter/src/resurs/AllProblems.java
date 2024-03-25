package resurs;

public class AllProblems {
    public static final String[] problems = {
            "What is my name?",
            "I miss my pincod?",
            "Who are you?",
            "How can I fix something?",
            "Hello?",
    };
    public static void ShowProblem(){
        for (int i = 0; i < problems.length; i++){
            System.out.println((i+1) + ") " + problems[i]);
        }
    }
}
