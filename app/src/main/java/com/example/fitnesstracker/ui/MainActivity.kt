package com.example.fitnesstracker.ui

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fitnesstracker.viewModel.ViewModelFactory
import com.example.fitnesstracker.databinding.ActivityMainBinding
import com.example.fitnesstracker.viewModel.BitrootViewModel


class MainActivity : AppCompatActivity(), SensorEventListener {
    val viewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(application)).get(BitrootViewModel::class.java)
    }
    private lateinit var binding: ActivityMainBinding
    private var sensorManager: SensorManager? = null
    private var totalSteps = 0f
    private lateinit var sensor: Sensor
    private var running = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        viewModel.result.observe(this, Observer {
            binding.sleepingTime.text = "${it.sleepTime} hrs"
            binding.heartRate.text = it.heartRate
            binding.trainingTextView.text = it.trainingTime
        })
    }

    override fun onResume() {
        super.onResume()
        running = true
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!!
        if (sensor != null) {
            sensorManager?.registerListener(this, sensor,SensorManager.SENSOR_DELAY_FASTEST)

        } else {
            Toast.makeText(this, "Snesor Not found", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        running = false
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (running) {
            val steps = event!!.values[0].toInt()
            binding.walking.text = "${steps}"
            val status = (steps / 10000) * 100
            binding.progressBar.progress = status
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    fun saveData() {

    }
}