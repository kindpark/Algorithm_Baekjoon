using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1 {
    class Program
    {
        static int[,] array;
        static int n, m, v;
        static Queue<int> q = new Queue<int>();
        static bool[] check;
        static void Main(String[] args)
        {
            string q = Console.ReadLine();
            string[] split = q.Split(' ');
            n = Convert.ToInt32(split[0]);
            m = Convert.ToInt32(split[1]);
            v = Convert.ToInt32(split[2]);

            array = new int[n + 1, n + 1];
            check = new bool[n + 1];
            for (int i = 0; i < m; i++)
            {
                int[] mArray = Array.ConvertAll(Console.ReadLine().Split(' '), int.Parse);
                int a = Convert.ToInt32(mArray[0]);
                int b = Convert.ToInt32(mArray[1]);
                array[a, b] = 1;
                array[b, a] = 1;
            }
            dfs(v);
            Console.WriteLine();
            check = new bool[n + 1];
            bfs(v);
        }
        static void dfs(int start)
        {
            check[start] = true;
            Console.Write(start + " ");
            for(int i = 1; i <= n; i++)
            {
                if (!check[i] && array[start,i] == 1)
                {
                    dfs(i);
                }
            }
        }
        static void bfs(int start)
        {
            q.Enqueue(start);
            check[start] = true;
            while (q.TryPeek(out int result))
            {
                start = q.Dequeue();
                Console.Write(start + " ");
                for (int i = 1; i <=n; i++)
                {
                    if(!check[i] && array[start, i] == 1)
                    {
                        q.Enqueue(i);
                        check[i] = true;
                    }
                }
            }
        }
    }
}
