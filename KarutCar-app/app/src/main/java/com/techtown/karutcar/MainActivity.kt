package com.techtown.karutcar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.autoButton -> {
                    // autonomous driving mode
                    status.text = "status: autonomous driving mode \uD83D\uDE98"
                    frontButton.setEnabled(false)
                    backButton.setEnabled(false)
                    leftButton.setEnabled(false)
                    rightButton.setEnabled(false)
                    beepButton.setEnabled(false)
                }
                R.id.manualButton -> {
                    // manual driving mode
                    status.text = "status: manual driving mode \uD83D\uDE98"
                    frontButton.setEnabled(true)
                    backButton.setEnabled(true)
                    leftButton.setEnabled(true)
                    rightButton.setEnabled(true)
                    beepButton.setEnabled(true)
                }
            }

        }


        frontButton.setOnTouchListener { _: View, event: MotionEvent ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // frontButton method
                    goFront()
                }
                MotionEvent.ACTION_UP -> {
                    goInitial()
                }
            }
            true
        }

        backButton.setOnTouchListener { _: View, event: MotionEvent ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // backButton method
                    goBack()
                }
                MotionEvent.ACTION_UP -> {
                    goInitial()
                }
            }
            true
        }

        leftButton.setOnTouchListener { _: View, event: MotionEvent ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // leftButton method
                    goLeft()
                }
                MotionEvent.ACTION_UP -> {
                    goInitial()
                }
            }
            true
        }

        rightButton.setOnTouchListener { _: View, event: MotionEvent ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // rightButton method
                    goRight()
                }
                MotionEvent.ACTION_UP -> {
                    goInitial()
                }
            }
            true
        }

        beepButton.setOnTouchListener { _: View, event: MotionEvent ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // beepButton method
                    beep()
                }
                MotionEvent.ACTION_UP -> {
                    goInitial()
                }
            }
            true
        }
    }

    fun goInitial(): Unit {
        status.text = "status: "
    }

    fun goFront(): Unit {
        status.text = "status: Karut Car is moving forward."
    }

    fun goBack(): Unit {
        status.text = "status: Karut Car is backing up."
    }

    fun goLeft(): Unit {
        status.text = "status: Karut Car is turning left."
    }

    fun goRight(): Unit {
        status.text = "status: Karut Car is turning right."
    }

    fun beep(): Unit {
        status.text = "status: Karut Car is honking! \uD83D\uDD14"
    }
}