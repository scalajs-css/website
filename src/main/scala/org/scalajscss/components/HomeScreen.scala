package org.scalajscss.components

import sri.web.router.RouterScreenComponentNoPSLS
import sri.web.vdom.tags._

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.{UndefOr => U}
import scalajscss.{CSSStyleSheet, CSSStyleSheetRegistry}

@ScalaJSDefined
class HomeScreen extends RouterScreenComponentNoPSLS {
  import HomeScreen._

  override def componentWillMount(): Unit = {
    CSSStyleSheetRegistry.addToDocument(styles)
  }

  def render() = {
    div(className = styles.container)(
      div(className = styles.topNav)(
        div(className = styles.button)("Home")
      ),
      div(className = styles.contentContainer)(
        h1(className = styles.title)("ScalaJS CSS"),
        div(className = styles.featuresContainer)(
          ulC(
            li(className = styles.featureItem)("Type Safe CSS"),
            li(className = styles.featureItem)("Compile Time Generated"),
            li(className = styles.featureItem)("Built for Component Age"),
            li(className = styles.featureItem)("Extensible via Plugins")
          )),
        div(className = styles.linksContainer)(
          a(className = styles.linkButton,
            href = "https://github.com/scalajs-css/core#scalajs-css",
            target = "_blank")("Docs"),
          a(className = styles.linkButton,
            href = "https://github.com/scalajs-css/discuss/issues",
            target = "_blank")("Discuss"),
          a(className = styles.linkButton,
            href = "https://github.com/scalajs-css",
            target = "_blank")("Github")
        )
      )
    )
  }

}

object HomeScreen {

  object styles extends CSSStyleSheet {

    import dsl._

    val container = style(display.flex,
                          minHeight := "100vh",
                          top := "0",
                          left := "0",
                          right := "0",
                          backgroundColor := "#505050",
                          bottom := "0",
                          minWidth := "100%",
                          flexDirection.column)

    val topNav = style(
      display.flex,
      top := "0",
      position.fixed,
      height := "64px",
      width := "100%",
      alignItems.center,
      paddingLeft := "40px",
      background := "#3a3838",
      zIndex := 100,
      flexDirection.row
    )

    val button = style(color := "#eae2e2", fontSize := "18px", cursor.pointer)

    val contentContainer = style(display.flex,
                                 flex := "1",
                                 color := "#f9a918",
                                 flexDirection.column,
                                 paddingTop := "80px",
                                 alignItems.center)

    val title = style(marginTop := "40px")

    val featuresContainer = style(boxShadow := "0 2px 4px #333333",
                                  paddingTop := "30px",
                                  paddingBottom := "30px",
                                  paddingRight := "60px",
                                  fontSize := "15px",
                                  color := "#e8e8e8")

    val featureItem = style(marginTop := "10px")

    val linksContainer =
      style(display.flex, justifyContent.spaceAround, marginTop := "30px")

    val linkButton = style(
      color.white,
      padding := "10px",
      fontSize := "18px",
      fontWeight.bold,
      borderRadius := "5px",
      border := "0",
      cursor.pointer,
      marginLeft := "15px",
      background := "linear-gradient(to right, #ff512f, #1cb5e0)",
      boxShadow := "0 2px 4px #2d2d2d"
    )
  }

}
