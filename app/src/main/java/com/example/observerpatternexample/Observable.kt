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

interface MapObservable {

    fun addObserver(key: String, observer: Observer)

    fun removeObserver(key: String)

    fun notifyObservers(value: String)

    class Base : MapObservable {

        private val map = HashMap<String, Observer>()

        override fun addObserver(key: String, observer: Observer) {
            map[key] = observer
        }

        override fun removeObserver(key: String) {
            map.remove(key)
        }

        override fun notifyObservers(value: String) {
            map.forEach {
                it.value.update(value)
            }
        }

    }
}