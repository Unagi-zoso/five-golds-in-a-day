#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

#define BEGIN_TIME first
#define END_TIME second

using namespace std;

using ui = unsigned int;
using puu = pair<ui, ui>;

struct cmp {
  bool operator()(puu a, puu b) {
    return a.END_TIME > b.END_TIME;
  }
};

bool less_begin_time_puu(puu a, puu b) {
    return a.BEGIN_TIME < b.BEGIN_TIME;
}

vector<puu> v;
priority_queue<puu, vector<puu>, cmp> min_end_time_heap;

int n;

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        ui begin_time, end_time;
        cin >> begin_time >> end_time;

        v.emplace_back(begin_time, end_time);
    }

    sort(v.begin(), v.end(), less_begin_time_puu);

    ui ans = 1;
    for (auto i : v) {
        cout << i.fi
        while (!min_end_time_heap.empty() && min_end_time_heap.top().END_TIME <= i.BEGIN_TIME)
            min_end_time_heap.pop();
        min_end_time_heap.push(i);
        ans = max(ans, (ui)min_end_time_heap.size());
    }

    cout << ans;    
}