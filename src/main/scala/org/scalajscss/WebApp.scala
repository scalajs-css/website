package org.scalajscss

import org.scalajs.dom
import sri.web.ReactDOM

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
object WebApp  {


  def main(args: Array[String]): Unit = {
    // remove waiting page stuff
    if (!js.isUndefined(g.loadingElement)) {
      g.document.body.removeChild(g.loadingElement)
      g.loadingElement = js.undefined
      dom.document.body.className.replace("pg-loading", "")
      dom.document.body.className = " pg-loaded"
    }
    ReactDOM.render(components.root, dom.document.getElementById("container"))
  }

}
