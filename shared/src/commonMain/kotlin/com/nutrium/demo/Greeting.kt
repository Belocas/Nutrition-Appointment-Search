package com.nutrium.demo

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello ISABEL, ${platform.name}!"
    }
}