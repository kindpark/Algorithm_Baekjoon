#include <iostream>
using namespace std;
 
const int MAX = 100000 + 1;
 
int arr[MAX];
long long int res;
 
int main() {
 
    int N, K;
 
    //입력
    cin >> N >> K;
 
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    int s = 0;
    long long int sum = 0;
    for (int i = s; i < s+K; i++) {
        sum += arr[i];
    }
    res = sum;
    while (true) {
        sum -= arr[s];
        if (s+K >= N) {
            break;
        }
        sum += arr[s+K];
        if (sum > res) {
            res = sum;
        }
        s++;
    }
 
    //출력
    cout << res;
}