import java.util.PriorityQueue

fun main()  = System.`in`.bufferedReader().use { reader ->
    System.out.bufferedWriter().use { writer ->
        val n = reader.readLine().toInt()
        var table = List(n) { reader.readLine().split(" ").map { it.toInt() }.toList() }
        table = table.sortedBy { it[0] }
        val pq = PriorityQueue<Int>()

        var ans = 1
        for ((st, ed) in table) {
            val curMin =
                if (pq.isEmpty()) {
                    0
                } else {
                    pq.peek()
                }
            if (st >= curMin) {
                pq.poll()
                pq.add(ed)
            } else {
                ans++
                pq.add(ed)
            }
        }
        writer.write("$ans")
    }
}
