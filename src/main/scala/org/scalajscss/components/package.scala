package org.scalajscss

import sri.web.router
import sri.web.router.{
  History,
  HistoryFactory,
  RouteNotFound,
  Router,
  RouterConfig
}

package object components {

  object AppRoutes extends RouterConfig {

    override val history: History = HistoryFactory.browserHistory()

    registerScreen[HomeScreen]("/")

    override val notFound: RouteNotFound = RouteNotFound(
      router.getRouterScreenKey[HomeScreen])

  }

  val root = Router(AppRoutes)
}
