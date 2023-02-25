package com.example.observerpatternexample

interface Observer<T> {

    fun update(value: T)
}