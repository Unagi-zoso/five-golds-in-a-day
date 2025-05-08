#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

using pii = pair<int, int>;

int n;
vector<pii> line_arr;

int dp[502];

bool comp(pii a, pii b) {
    return a.first < b.first;
}

int main () {
    cin >> n;

    int t_l, t_r;
    for (int i = 0; i < n; ++i) {
        cin >> t_l >> t_r;
        pii t_p = {t_l, t_r};
        line_arr.emplace_back(t_p);

        dp[i] = 1;
    }

    sort(line_arr.begin(), line_arr.end(), comp);

    int mx_v = -1;
    for (int i = 0; i < n; ++i) {
        for (int j = i-1; j >= 0; --j) {
            if (line_arr[j].second < line_arr[i].second)
                dp[i] = max(dp[i], dp[j] + 1);
        }
        mx_v = max(mx_v, dp[i]);
    }

    cout << n - mx_v;
}