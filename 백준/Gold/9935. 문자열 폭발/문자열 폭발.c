#include <stdio.h>
#include <string.h>
char str[1000001], ans[1000001], bomb[37];
int main(){
    scanf("%s %s", str, bomb);
    int len = strlen(str), exp_len = strlen(bomb), idx = 0;
    for (int i = 0; i < len; i++){
        ans[idx++] = str[i];
		
        if (idx >= exp_len){
            int temp = idx - exp_len, j;
            for (j = temp; j < idx; j++)
                if (ans[j] != bomb[j-temp]) break;
				
            idx -= (j == idx ? exp_len : 0);
        }
    }
    ans[idx] = '\0';
    puts(idx ? ans : "FRULA");
}