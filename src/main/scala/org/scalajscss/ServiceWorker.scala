package org.scalajscss

import org.scalajs.dom
import org.scalajs.dom.experimental.serviceworkers.{ServiceWorkerRegistration, _}

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js.JSON
import scala.scalajs.{LinkingInfo, js}

object ServiceWorker {

  def init() = {
    if (LinkingInfo.productionMode) {
      if (!js.isUndefined(dom.window.navigator.serviceWorker)) { // check if serviceWorker supported or not
        dom.window.navigator.serviceWorker
          .register("sw.js")
          .toFuture
          .map((resp: ServiceWorkerRegistration) => {
            println(
              s" ServiceWorker registered  successfully : ${JSON.stringify(resp)}  ")
          })
          .recover {
            case ex: Exception => println("ServiceWorker registration failed")
          }
      } else {
        println("ServiceWorker not there yet!")
      }
    }

  }

}
