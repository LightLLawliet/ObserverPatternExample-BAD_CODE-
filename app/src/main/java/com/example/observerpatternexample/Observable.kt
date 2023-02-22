package com.example.observerpatternexample

interface Observable {

    fun addObserver(observer: Observer)

    fun removeObserver(observer: Observer)

    fun notifyObservers(value: String)

    class Base : Observable {
        private val list = mutableListOf<Observer>()
        override fun addObserver(observer: Observer) {
            list.add(observer)
        }

        override fun removeObserver(observer: Observer) {
            list.remove(observer)
        }

        override fun notifyObservers(value: String) {
            list.forEach {
                it.update(value)
            }
        }

    }
}