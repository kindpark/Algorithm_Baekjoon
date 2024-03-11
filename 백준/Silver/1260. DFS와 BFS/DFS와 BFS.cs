using System;
using System.Collections.Generic;
using System.IO;

class MainClass {
    static int[,] li;
    static bool[] check;
    static System.Text.StringBuilder sb;
    static Queue<int> q;
    static int n, m, v;

    public static void bfs(int v) {
        q.Enqueue(v);
        check[v] = true;
        while (q.Count > 0) {
            v = q.Dequeue();
            sb.Append(v + " ");
            for (int i = 1; i <= n; i++) {
                if (!check[i] && li[v, i] == 1) {
                    q.Enqueue(i);
                    check[i] = true;
                }
            }
        }
    }

    public static void dfs(int v) {
        check[v] = true;
        sb.Append(v + " ");
        for (int i = 1; i <= n; i++) {
            if (!check[i] && li[v, i] == 1) {
                dfs(i);
            }
        }
    }

    public static void Main(string[] args) {
        StreamReader sr = new StreamReader(Console.OpenStandardInput());
        sb = new System.Text.StringBuilder();
        string[] input = sr.ReadLine().Split(' ');
        n = int.Parse(input[0]);
        m = int.Parse(input[1]);
        v = int.Parse(input[2]);
        li = new int[n + 1, n + 1];
        check = new bool[n + 1];
        q = new Queue<int>();
        for (int i = 0; i < m; i++) {
            string[] s = sr.ReadLine().Split(' ');
            int x = int.Parse(s[0]);
            int y = int.Parse(s[1]);

            li[x, y] = 1;
            li[y, x] = 1;
        }
        dfs(v);
        Console.WriteLine(sb);
        sb = new System.Text.StringBuilder();
        check = new bool[n + 1];
        bfs(v);
        Console.WriteLine(sb);
    }
}