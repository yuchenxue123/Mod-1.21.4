package com.yuchenxue.event

interface Listenable {
    fun handleEvents(): Boolean = parent()?.handleEvents() ?: true

    fun parent(): Listenable? = null

    fun unregister() {
        EventManager.unregisterEventHandler(this)
    }
}

typealias Handler<T> = (T) -> Unit

class EventHook<T : Event>(
    val handlerClass: Listenable,
    val handler: Handler<T>,
    val ignoresCondition: Boolean
)

inline fun <reified T: Event> Listenable.handle(
    ignoreCondition: Boolean = false,
    noinline handler: Handler<T>
) {
    EventManager.registerEventHook(T::class.java, EventHook(this, handler, ignoreCondition))
}