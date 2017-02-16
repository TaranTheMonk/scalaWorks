/**
  * Created by Taran on 19/1/17.
  */

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

object CSVScanner {
  def main(args: Array[String]) {

    def readInOneDay(input_pattern: Regex, Date: String, userSummary: Map[String, Int]): Map[String, Int] = {

      val bufferedSource = io.Source.fromFile("./Data/data-" + Date + ".csv")

      for (line <- bufferedSource.getLines) {

        val cols = line.split(",").map(_.trim)
        if (input_pattern.pattern.matcher(cols(1)).find() && cols.length >= 5) {
          if (userSummary.keySet.contains(cols(4))) {
            userSummary += (cols(4) -> 0)
          }
          userSummary(cols(4)) += 1
        }
      }

      bufferedSource.close
      return userSummary
    }

    def scanByDays(StartDate: String, EndDate: String): List[String] = {}

    val sample_pattern = new Regex("lotteries|toto|4d|sweep")
    val output = readInOneDay(sample_pattern)
    println(output)

  }
}