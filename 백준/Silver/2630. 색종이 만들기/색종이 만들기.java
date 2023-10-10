
import java.io.*;
import java.util.StringTokenizer; 
public class Main { 
    static int z,o; 
    public static void main(String[] args) throws Exception{ 
    	Count c = new Count();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine()); 
        int [][] map = new int [n][n]; 
        for(int i=0;i<n;i++) { 
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            for(int j=0;j<n;j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }
        c.setCount(map, 0, 0, n); 
        z = c.getZ();
        o = c.getO();
        bw.write(String.valueOf(z)+"\n"); 
        bw.write(String.valueOf(o));
        bw.flush();
    } 
}
class Count{
	int z = 0, o = 0;
	public void setCount(int[][]map,int si,int sj, int size){ 
        int cnt=0; 
        for(int i=si;i<si+size;i++) { 
            for(int j=sj;j<sj+size;j++) 
                cnt+=map[i][j];
        } 
        if(cnt==0)
            z++; 
        else if(size*size==cnt) 
            o++; 
        else { 
                setCount(map, si, sj, size/2); 
                setCount(map, si+size/2, sj, size/2); 
                setCount(map, si, sj+size/2, size/2); 
                setCount(map, si+size/2, sj+size/2, size/2);
        }
    } 
	public int getZ() {
		return z;
	}
	public int getO() {
		return o;
	}
}