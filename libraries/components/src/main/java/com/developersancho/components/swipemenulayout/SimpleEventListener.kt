package com.developersancho.components.swipemenulayout

typealias OnMenuItemClickListener = ((item: SwipeMenuItem, position: Int) -> Unit)?

typealias OnMenuClosedListener = ((layout: SwipeMenuLayout) -> Unit)?

typealias OnMenuLeftOpenedListener = ((layout: SwipeMenuLayout) -> Unit)?

typealias OnMenuRightOpenedListener = ((layout: SwipeMenuLayout) -> Unit)?
