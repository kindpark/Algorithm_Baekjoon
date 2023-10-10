#include <stdio.h>

char cross(int x, int y)
{
	if((x+y)%2 == 0){
		return '#';
	}
	else{
		return '.';
	}
}

int main(void)
{
	char c[10][10];
	char f[20][20];
	int n, m, u, l, r, d;
	scanf("%d %d", &n, &m);
	scanf("%d %d %d %d", &u, &l, &r, &d);
	for(int i = 0; i < n; i++){
		scanf("%s", c[i]);
	}
	for(int q = 0; q < n + u + d; q++){
		for(int w = 0; w < l + m + r; w++){
			f[q][w] = cross(q, w);
		}
	}
	for(int e = 0; e < n; e++){
		for(int t = 0; t < m; t++){
			f[e + u][t + l] = c[e][t];
		}
	}
	for(int a = 0; a < n + u + d; a++){
		for(int b = 0; b < l + m + r; b++){
			printf("%c", f[a][b]);
		}
		printf("\n");
	}
	return 0;
}