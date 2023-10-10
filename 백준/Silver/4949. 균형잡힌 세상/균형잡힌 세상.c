#include <stdio.h>
#include <string.h>
#define MAX 100
 
char stack[MAX];
int top = -1;
 

int push(char ch) {
    if (top >= MAX - 1) return -1;
    return stack[++top] = ch;
}
 

int pop() {
    if (top < 0) return -1;
    return stack[top--] = '\0';
}
 

char peek() {
    return stack[top];
}
 
void Result(char *ch, int size) {
    for (int i = 0; i < size; i++) {
        if (ch[i] == '(' || ch[i] == ')' || ch[i] == '[' || ch[i] == ']') {
        
            if (top == -1) push(ch[i]);
            else {
                
                if (peek() == '('&&ch[i] == ')') pop();
                else if (peek() == '['&&ch[i] == ']') pop();
              
                else push(ch[i]);
            }
        }
    }
    if (top == -1) printf("yes\n");
    else printf("no\n");
}
 
int main() {
    char str[MAX];
    while (1) {
        top = -1;
        gets(str);
        if (strcmp(str, ".") == 0) break;
        Result(str, strlen(str));
    }
    return 0;
}