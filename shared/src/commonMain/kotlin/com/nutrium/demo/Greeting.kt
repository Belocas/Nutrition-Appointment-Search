package com.nutrium.demo
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationPlugin
import io.ktor.serialization.kotlinx.json.Json
import kotlinx.serialization.json.Json



class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello ISABEL, ${platform.name}!"
    }

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }
}