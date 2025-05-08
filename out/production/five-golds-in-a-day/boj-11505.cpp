#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

using ll = long long;

constexpr int MOD = 1'000'000'007;

ll arr[1'000'001];
int n, m, k;

struct Segment_Tree {
    vector<ll> seg_tree;

    Segment_Tree(int size) {

        int heigth = (int)ceil(log2(size));

        seg_tree.assign(1 << (heigth + 1), -1);
    }

    ll init(int node, int start, int end) {
        if (start == end) return seg_tree[node] = arr[start];
        int mid = start + ((end - start) / 2);
        return seg_tree[node] = (init(2 * node, start, mid) * init(2 * node + 1, mid + 1, end)) % MOD;
    }

    ll update(int node, int index, ll value, int start, int end) {
        if (index > end || index < start) return seg_tree[node];
        if (start == end) return seg_tree[node] = value;
        int mid = start + ((end - start) / 2);
        return seg_tree[node] = (update(2 * node, index, value, start, mid) * update(2 * node + 1, index, value, mid + 1, end)) % MOD;
    }

    ll multi(int node, int left, int right, int start, int end) {
        if (right < start || left > end) return 1;
        if (left <= start && end <= right) return seg_tree[node];
        int mid = start + ((end - start) / 2);

        return (multi(2 * node, left, right, start, mid) * multi(2 * node + 1, left, right, mid + 1, end)) % MOD;
    }
};

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> n >> m >> k;

    for (int i = 1; i <= n; i++) { cin >> arr[i]; }

    Segment_Tree tree(n);

    tree.init(1, 1, n);
    for (int i = 0; i < m + k; i++) {
        int a, b, c;
        cin >> a >> b >> c;

        if (a == 1) {
            arr[b] = c;
            tree.update(1, b, c, 1, n);
        }

        else {
            int left = b, right = c;
            if (left > right) swap(left, right);
            cout << tree.multi(1, left, right, 1, n) % MOD << '\n';
        }
    }

}