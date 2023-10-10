import java.util.*;
 
public class Main {
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String str = sc.next();
        sc.close();
        int res = 0;
        
        char s[] = new char[1000001];
        
        for(int i=0; i<M; i++) {
            s[i] = str.charAt(i);
        }
        
        for (int i = 0; i < M - 2; i++) {
            if (s[i+1] == 'O' && s[i + 2] == 'I') {
                int IOI = 0;
                while (s[i] == 'I' && s[i + 1] == 'O') {
                    i += 2;
                    IOI += 1;
 
                    if (s[i] == 'I' && IOI == N) {
                        res += 1;
                        IOI -= 1;
                    }
                }
            }
        }
 
        System.out.println(res);
 
    }
}
