#include <iostream>
#include <queue>
#include <cmath>
using namespace std;

int N;
priority_queue<pair<int,int>> pq;

int main()
{
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int tc = 0; tc < N; tc++)
	{
		int input;
		cin >> input;

		if (input == 0)
		{
			if (pq.empty())
				cout << "0" << '\n';
			else
			{
				cout << -pq.top().second << '\n';
				pq.pop();
			}
		}
		else
			pq.push({ -abs(input), -input });
		
	}
    
	return 0;
}