package com.yuchenxue

import com.yuchenxue.event.Listenable
import com.yuchenxue.module.ModuleManager
import org.slf4j.LoggerFactory

object Stay : Listenable {

    // maybe change
    private val CLIENT_NAME = "Stay"
    private val CLIENT_VERSION = "0.1"

    val logger = LoggerFactory.getLogger("stay")

    fun startClient() {
        ModuleManager
    }
}