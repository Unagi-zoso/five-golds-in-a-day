fun main() = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val (n, k) = reader.readLine().split(" ").map { it.toInt() }

        if (n <= k) {
            writer.write("0")
        } else {
            var boughtBottles = 0
            while (true) {
                var allBottles = n + boughtBottles
                var cnt = 0
                while (allBottles != 0) {
                    if (allBottles % 2 == 1) {
                        cnt++
                    }
                    allBottles /= 2
                }
                if (cnt <= k) {
                    writer.write("$boughtBottles")
                    break
                }
                boughtBottles++
            }
        }
    }
}
