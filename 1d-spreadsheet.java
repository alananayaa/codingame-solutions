import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Task {
    public String operation;
    public String arg1;
    public String arg2;
    public Task(String operation, String arg1, String arg2){
        this.operation = operation;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
}

class Solution {
    public static ArrayList<Task> tasks = new ArrayList<Task>();
    public static Integer[] values;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        values = new Integer[N];

        for (int i = 0; i < N; i++) {
            String operation = in.next();
            String arg1 = in.next();
            String arg2 = in.next();
            tasks.add(new Task(operation, arg1, arg2));
        }

        for (int i = 0; i < N; i++) {
            System.out.println(getCellValue(i));
        }
    }

    private static Integer getCellValue(int index) {
        if (values[index] != null){
            return values[index];
        }

        String arg1 = tasks.get(index).arg1;
        String arg2 = tasks.get(index).arg2;
        
        int val1 = arg1.charAt(0) == '$' ? getCellValue(Integer.parseInt(arg1.substring(1))) : Integer.parseInt(arg1);
        int val2 = arg2.charAt(0) == '_' ? 0 : arg2.charAt(0) == '$' ? getCellValue(Integer.parseInt(arg2.substring(1))) : Integer.parseInt(arg2);

        switch (tasks.get(index).operation) {
            case "VALUE":
                values[index] = val1;
                break;
            
            case "ADD":
                values[index] = val1 + val2;
                break;
            
            case "SUB":
                values[index] = val1 - val2;
                break;
            
            case "MULT":
                values[index] = val1 * val2;
                break;
        
            default:
                break;
        }
        return values[index];
    }
}