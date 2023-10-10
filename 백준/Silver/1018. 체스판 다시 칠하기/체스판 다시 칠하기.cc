#include <iostream>
#include <cstring>
using namespace std;

int fix(string line, int start){
    int cnt = 0;

    if (start == 0) { 
        for (int i=0; i < 8; i++){
            if ((i % 2 == 1) && (line[i]=='B')) { 
                cnt += 1;
            }
            if ((i % 2 == 0) && (line[i]=='W')) { 
                cnt += 1;
            }
        }
    }
    else {
        for (int i=0; i < 8; i++){
            if ((i % 2 == 1) && (line[i]=='W')) { 
                cnt += 1;
            }
            if ((i % 2 == 0) && (line[i]=='B')) { 
                cnt += 1;
            }
        }
    }
    return cnt;
}


int main(void){
    int n, m;
    cin>>n>>m;
    string array[50];
    for (int i=0; i<n; i++){
        cin>>array[i];
    }
    int result = 64;

    for (int i=0; i <= m-8; i++){
        for (int j=0; j <= n-8; j++){
            int tmp = 0;

            for (int k=j; k < j+8; k++){  
                tmp += fix((array[k].substr(i, i+8)), (k % 2));
            }

            if (tmp > 32){
                tmp = 64 - tmp;
            }

            if (tmp < result) {
                result = tmp;
            }

        }
    }
    cout<<result;
}