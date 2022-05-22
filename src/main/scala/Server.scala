import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.server.Directives.*
import akka.stream.SystemMaterializer
import akka.stream.scaladsl.Sink
import ticker.TickerServiceHandler

import scala.io.StdIn

object Server {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("ticker")
    implicit val ec = system.dispatcher
    implicit val mat = SystemMaterializer(system).materializer

    val port = 9090
    val serverBindingFuture = Http()
      .newServerAt("localhost", port)
      .bind(TickerServiceHandler(new TickerServiceImpl))

    println(
      s"Server now online. Please navigate to http://localhost:$port\nPress RETURN to stop..."
    )
    StdIn.readLine()
    serverBindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
