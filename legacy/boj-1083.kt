fun main() =
    System.`in`.bufferedReader().use { reader ->
        System.out.bufferedWriter().use { writer ->
            val n = reader.readLine().toInt()
            val arr = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
            var s = reader.readLine().toInt()

            for (i in 0 until n) {
                var mxIdxInRange = i
                for (j in i + 1..i + s) {
                    if (j >= n) {
                        break
                    }
                    if (arr[mxIdxInRange] < arr[j]) {
                        mxIdxInRange = j
                    }
                }
                for (j in mxIdxInRange downTo i + 1) {
                    val tmp = arr[j]
                    arr[j] = arr[j - 1]
                    arr[j - 1] = tmp
                }
                s -= mxIdxInRange - i
            }
            writer.write(arr.joinToString(" "))
        }
    }
