import akka.NotUsed
import akka.stream.scaladsl.Source
import ticker.{StockValue, TickerService, TickerSymbol}

class TickerServiceImpl extends TickerService {
  val random = scala.util.Random

  override def monitorSymbol(in: TickerSymbol): Source[StockValue, NotUsed] = {
    val iter = new Iterator[StockValue] {
      override def hasNext: Boolean = true
      override def next(): StockValue = StockValue(in.name, random.nextInt(800))
    }
    Source.fromIterator(() => iter)
  }
}
