#include<stdio.h>
#include<string.h>

int main(){
    int t, i, j, l, r, check;
    char ps[51];
    
    scanf("%d", &t);
    for(i=0;i<t;i++){
        check = 1;
        l=0;
        r=0;
        scanf("%s", ps);
        for(j=0;j<strlen(ps);j++){
            if(ps[j] == '(')
                l++;
            if(ps[j] == ')')
                r++;
            
            if(r>l){
                check = 0;
                break;
            }
        }
        if(check == 1 && l == r)
            printf("YES\n");
        else
            printf("NO\n");
    }
}