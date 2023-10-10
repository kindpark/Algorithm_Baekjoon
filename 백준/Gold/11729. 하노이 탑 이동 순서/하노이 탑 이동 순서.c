#include <stdio.h>
#include <math.h>
int move(int num, int from, int to, int via);
int main(int argc, char *argv[]) { 
    int num;
    scanf("%d", &num); 
    printf("%.0f\n", pow(2, num) - 1);
    move(num, 1, 3, 2); return 0; }
int move(int num, int from, int to, int via) {
    if (num == 1) { 
        printf("%d %d\n", from, to); } 
    else {
        move(num - 1, from, via, to);
        printf("%d %d\n", from, to); 
        move(num - 1, via, to, from);
    }
    return 0;
}