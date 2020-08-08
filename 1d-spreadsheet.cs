using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Collections;
using System.Collections.Generic;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution
{
    static List<Task> operations;
    static int?[] cells;

    struct Task
    {
        public string operation;
        public string arg1;
        public string arg2;
    }

    private static int getCellVal(int index)
    {
        if (cells[index] != null)
        {
            return (int)cells[index];
        }

        string arg1 = operations[index].arg1;
        string arg2 = operations[index].arg2;

        int val1 = arg1[0] == '$' ? getCellVal(int.Parse(arg1.Substring(1))) : int.Parse(arg1);
        int val2 = arg2[0] == '_' ? 0 : arg2[0] == '$' ? getCellVal(int.Parse(arg2.Substring(1))) : int.Parse(arg2);

        switch (operations[index].operation)
        {
            case "VALUE":
                cells[index] = val1;
                break;
            case "ADD":
                cells[index] = val1 + val2;
                break;
            case "SUB":
                cells[index] = val1 - val2;
                break;
            case "MULT":
                cells[index] = val1 * val2;
                break;
        }

        return (int)cells[index];
    }

    static void Main(string[] args)
    {
        int N = int.Parse(Console.ReadLine());
        operations = new List<Task>();
        cells = new int?[N];
        for (int i = 0; i < N; i++)
        {
            string[] inputs = Console.ReadLine().Split(' ');
            string operation = inputs[0];
            string arg1 = inputs[1];
            string arg2 = inputs[2];
            operations.Add(new Task() { operation = operation, arg1 = arg1, arg2 = arg2 });

        }

        for (int i = 0; i < N; i++)
        {
            Console.WriteLine(getCellVal(i));
        }
    }
}