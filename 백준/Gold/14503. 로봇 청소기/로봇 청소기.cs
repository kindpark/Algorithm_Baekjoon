using System;
using System.Collections.Generic;

public class Solution
{
    static int n1, m;
    static int[,] ground;
    static bool[,] check;
    //0123
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void Main(string[] args)
    {
        string[] input = Console.ReadLine().Split();
        n1 = int.Parse(input[0]);
        m = int.Parse(input[1]);
        ground = new int[n1, m];
        check = new bool[n1, m];
        input = Console.ReadLine().Split();
        int xp = int.Parse(input[0]);
        int yp = int.Parse(input[1]);
        int direct = int.Parse(input[2]);
        for (int i = 0; i < n1; i++)
        {
            input = Console.ReadLine().Split();
            for (int j = 0; j < m; j++)
            {
                ground[i, j] = int.Parse(input[j]);
            }
        }
        Console.WriteLine(BFS(xp, yp, direct));
    }

    static int Direct(int dir)
    {
        if (dir == 0)
        {
            return 3;
        }
        else
        {
            dir--;
            return dir;
        }
    }

    public class Node
    {
        public int x;
        public int y;
        public int direct;
        public Node(int x, int y, int direct)
        {
            this.x = x;
            this.y = y;
            this.direct = direct;
        }
    }

    public static int BFS(int x, int y, int direct)
    {
        Queue<Node> q = new Queue<Node>();
        q.Enqueue(new Node(x, y, direct));
        int res = 0;
        while (q.Count > 0)
        {
            //네방향 탐색 유무 판별
            bool spin = false;
            Node n = q.Dequeue();
            if (!check[n.x, n.y])
            {
                check[n.x, n.y] = true;
                res++;
            }
            int nd = n.direct;
            for (int i = 0; i < 4; i++)
            {
                nd = Direct(nd);
                int nx = dx[nd] + n.x;
                int ny = dy[nd] + n.y;
                if (nx < 0 || ny < 0 || nx >= n1 || ny >= m)
                {
                    continue;
                }
                if (check[nx, ny])
                {
                    continue;
                }
                if (ground[nx, ny] == 1)
                {
                    continue;
                }
                q.Enqueue(new Node(nx, ny, nd));
                spin = true;
                break;
            }
            if (!spin)
            {
                int nnd = (n.direct + 2) % 4;
                int nx = n.x + dx[nnd];
                int ny = n.y + dy[nnd];
                if (nx < 0 || ny < 0 || nx >= n1 || ny >= m)
                {
                    continue;
                }
                if (ground[nx, ny] != 1)
                {
                    q.Enqueue(new Node(nx, ny, n.direct));
                    continue;
                }
                else
                {
                    break;
                }
            }
        }
        return res;
    }
}
