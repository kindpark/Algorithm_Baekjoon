#include <iostream>
#include <cstdio> 
#include <cmath>
#include <cstring> 
using namespace std;
void HanoiTower(int num, int from, int by, int to) {
    if (num == 1) 
        printf("%d %d\n", from, to); 
    else{ 
        HanoiTower(num - 1, from, to, by); 
        printf("%d %d \n", from, to); 
        HanoiTower(num - 1, by, from, to); 
    }
} 
int main(void) {
    int N; cin >> N; 
    string a = to_string(pow(2, N)); 
    int x = a.find('.'); //pow 함수 결과가 실수형이기에 소수점 찾기
    a = a.substr(0, x); //소수점 앞자리만 나오게하기
    a[a.length() - 1] -= 1; //string a에 대한 마지막 위치의 인덱스 값에 -1 
    cout << a << endl; 
    if(N <= 20) 
        HanoiTower(N, 1, 2, 3); 
    return 0;
}