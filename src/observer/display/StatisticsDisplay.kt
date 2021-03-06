package observer.display

import observer.base.IDisplayElement
import observer.base.IObserver
import observer.base.ISubject

class StatisticsDisplay(private val weatherData: ISubject) : IObserver, IDisplayElement {
    private var temperature: Float = 0f
    private var humidity: Float = 0f
    private var pressure: Float = 0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure

        display()
    }

    override fun display() {
        println("Statistics Display -> Right now there is $temperature degrees, $humidity% humidity and $pressure pressure.")
    }
}