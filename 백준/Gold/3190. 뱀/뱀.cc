#include<iostream>
#include<cstdio>
#include<queue>
#define SNAKE -1
#define APPLE 1
using namespace std;

char turn[10001];
int N, K, L, map[101][101], d[]={0,1}, head[2];//head's x y

bool canMove(int, int);
void changeDir(int &, int &, char &);

int main(){
	char ch;
    int i, dx, dy, time;
    for(scanf("%d%d",&N,&K), i=0;i<K;i++){
		scanf("%d %d", &dx, &dy);
		map[dx-1][dy-1] = APPLE;
    }
    for(scanf("%d", &L), i=0;i<L;i++){
		scanf("%d %c", &dx, &ch);
		turn[dx] = ch;
    }

    map[0][0] = SNAKE;
    queue<pair<int, int>> snake;
    snake.push(pair<int, int>(0, 0));

    for(time=1;;time++){
		dx=head[0]+d[0], dy=head[1]+d[1];
		if(!canMove(dx, dy)) break;

		head[0] = dx, head[1] = dy;
		if(map[dx][dy]!=APPLE){
		    pair<int, int> tail = snake.front();
		    map[tail.first][tail.second] = 0;
		    snake.pop();
		}
		
		if(turn[time]) changeDir(d[0], d[1], turn[time]);
	
		map[dx][dy] = SNAKE;
		snake.push(pair<int, int>(dx, dy));
    }
    printf("%d", time);
}

bool canMove(int x, int y){
    return ((0<=x&&x<N)&&(0<=y&&y<N)) && map[x][y]!=SNAKE;
}

void changeDir(int &x, int &y, char &dir){
    if(x==0&&y==1){ //cur:right
		if(dir=='D') x=1, y=0;
		else x=-1, y=0;
    }
    else if(x==1&&y==0){ //cur:down
		if(dir=='D') x=0, y=-1;
		else x=0, y=1;
    }
    else if(x==0&&y==-1){ //cur:left
		if(dir=='D') x=-1, y=0;
		else x=1, y=0;
    }
    else{ //cur:up
		if(dir=='D') x=0, y=1;
		else x=0, y=-1;
    }
}