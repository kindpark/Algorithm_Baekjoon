#include <cstdio>
#include <vector>
using namespace std;
vector<int> a[1001];
bool check[1001];

void dfs(int node) {
    check[node] = true;
    for (int i=0; i<a[node].size(); i++) {
        int next = a[node][i];
        if (check[next] == false) {
            dfs(next);
        }
    }
}
int main() {
    int n, m;
    scanf("%d %d",&n,&m);
    for (int i=0; i<m; i++) {
        int u,v;
        scanf("%d %d",&u,&v);
        a[u].push_back(v);
        a[v].push_back(u);
    }
    int components = 0;
    for (int i=1; i<=n; i++) {		// 모든 인접 리스트를 순회하면서
        if (check[i] == false) {	// 방문하지 않은 노드가 있다면
            dfs(i);			// 하나의 연결 요소 모두 방문
            components += 1;		// 연결 요소의 수 증가
        }
    }
    printf("%d\n",components);
    return 0;
}