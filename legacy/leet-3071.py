class Solution:
    def minimumOperationsToWriteY(self, grid: List[List[int]]) -> int:
        yDist = [0] * 3
        nyDist = [0] * 3
        n = len(grid)
        center = n // 2
        for i in range(n):
            for j in range(n):
                if i <= center and j <= center and (i == j):
                    yDist[grid[i][j]] += 1
                elif i <= center and j > center and (i == n - j - 1):
                    yDist[grid[i][j]] += 1
                elif i > center and j == center:
                    yDist[grid[i][j]] += 1
                else:
                    nyDist[grid[i][j]] += 1

        yToBe0 = yDist[1] + yDist[2] + nyDist[0] + min(nyDist[1], nyDist[2])
        yToBe1 = yDist[0] + yDist[2] + nyDist[1] + min(nyDist[0], nyDist[2])
        yToBe2 = yDist[1] + yDist[0] + nyDist[2] + min(nyDist[0], nyDist[1])
        ans = min(yToBe0, yToBe1, yToBe2)
        return ans
        