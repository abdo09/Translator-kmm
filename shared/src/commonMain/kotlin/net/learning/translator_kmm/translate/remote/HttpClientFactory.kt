package net.learning.translator_kmm.translate.remote

import io.ktor.client.HttpClient

expect class HttpClientFactory{
    fun create(): HttpClient
}