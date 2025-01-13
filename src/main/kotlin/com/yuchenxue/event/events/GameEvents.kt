package com.yuchenxue.event.events

import com.yuchenxue.event.Event
import net.minecraft.client.util.InputUtil.Key

/**
 * @author yuchenxue
 * @date 2025/01/11 - 09:59
 */

class ClientStartEvent: Event()

class ClientShutdownEvent: Event()

class KeyBoardEvent(val key: Key, val keyCode: Int, val scanCode: Int, val action: Int): Event()
class KeyEvent(val key: Key, action: Int): Event()