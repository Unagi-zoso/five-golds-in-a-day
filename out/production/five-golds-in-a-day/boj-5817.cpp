#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

constexpr int MAX = 200005;
constexpr int INF = 0x7f7f7f7f;

struct SegmentTree
{
	vector<int> minTree;
	vector<int> maxTree;

	SegmentTree(int size)
	{
		minTree.assign(size*4, INF);
		maxTree.assign(size*4, -1);
	}

	int minQuery(int left, int right, int node, int nodeLeft, int nodeRight){
		if (nodeRight < left || right < nodeLeft)
			return INF;
		if (left <= nodeLeft && nodeRight <= right)
			return minTree[node];

		int mid = (nodeLeft + nodeRight) / 2;
		return min(minQuery(left, right, node * 2, nodeLeft, mid), 
			   minQuery(left, right, node *2+1, mid+1, nodeRight));
	}

	int minUpdate(int idx, int value, int node, int nodeLeft, int nodeRight){
		if (nodeRight < idx || idx < nodeLeft)
			return minTree[node];
		if (nodeLeft == nodeRight)
			return minTree[node] = value;

		int mid = (nodeLeft + nodeRight) / 2;
		return minTree[node] = min(minUpdate(idx, value, node * 2, nodeLeft, mid), 
			   					   minUpdate(idx, value, node * 2 + 1, mid + 1, nodeRight));
	}

	int maxQuery(int left, int right, int node, int nodeLeft, int nodeRight){
		if (nodeRight < left || right < nodeLeft)
			return -1;
		if (left <= nodeLeft && nodeRight <= right)
			return maxTree[node];
		
		int mid = (nodeLeft + nodeRight) / 2;
		return max(maxQuery(left, right, node*2, nodeLeft, mid), 
			   	   maxQuery(left, right, node*2+1, mid+1, nodeRight));
	}

	int maxUpdate(int idx, int value, int node, int nodeLeft, int nodeRight){
		if (nodeRight < idx || idx < nodeLeft)
			return maxTree[node];
		if (nodeLeft == nodeRight)
			return maxTree[node] = value;

		int mid = (nodeLeft + nodeRight) / 2;
		return maxTree[node] = max(maxUpdate(idx, value, node*2, nodeLeft, mid), 
		                           maxUpdate(idx, value, node*2+1, mid+1, nodeRight));
	}
};

int range[MAX];

int main(){
    cin.tie(0)->sync_with_stdio(0);
	int N, M;
	cin >> N >> M;

	SegmentTree segTree(N);
	for (int i = 1; i <= N; i++){
		cin >> range[i];

		segTree.minUpdate(range[i], i, 1, 1, N);
		segTree.maxUpdate(range[i], i, 1, 1, N);
	}

	for (int i = 0; i < M; i++){
		for (int i = 1; i <= 4*N; ++i ) cout << segTree.maxTree[i] << ' ';
		int op, a, b;
		cin >> op >> a >> b;

		if (op == 1){
			segTree.minUpdate(range[b], a, 1, 1, N);
			segTree.minUpdate(range[a], b, 1, 1, N);
			segTree.maxUpdate(range[b], a, 1, 1, N);
			segTree.maxUpdate(range[a], b, 1, 1, N);

			swap(range[a], range[b]);
		}
		else{
			int diff = segTree.maxQuery(a, b, 1, 1, N)-  segTree.minQuery(a, b, 1, 1, N);		
			if (diff == b-a) cout << "YES\n";
			else cout << "NO\n";
		}
	}
}
