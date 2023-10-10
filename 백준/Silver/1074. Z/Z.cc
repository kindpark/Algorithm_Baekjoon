#include<iostream>
#include<algorithm>
using namespace std;

int N, C, R;
long long ans;
void solve(int n, int c, int r)
{
	if (n == 0) return;

	int size = 1 << n;
	long long half = size / 2;

	if (c / half == 0 && r / half == 0)
	{
		ans += half * half * 0;
		solve(n - 1, c % half, r % half);
	}
	else if (c / half == 0 && r / half == 1)
	{
		ans += half * half * 1;
		solve(n - 1, c % half, r % half);
	}
	else if (c / half == 1 && r / half == 0)
	{
		ans += half * half * 2;
		solve(n - 1, c % half, r % half);
	}
	else // (c / size == 1 && r / size == 1)
	{
		ans += half * half * 3;
		solve(n - 1, c % half, r % half);
	}
}

int main()
{
	cin >> N >> C >> R;
	solve(N, C, R);
	cout << ans << endl;
}
