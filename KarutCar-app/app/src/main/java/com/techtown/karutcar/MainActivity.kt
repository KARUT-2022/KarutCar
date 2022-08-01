package com.techtown.karutcar

import android.graphics.Color
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
                    frontButton.setVisibility(View.INVISIBLE)
                    backButton.setVisibility(View.INVISIBLE)
                    leftButton.setVisibility(View.INVISIBLE)
                    rightButton.setVisibility(View.INVISIBLE)
                    beepButton.setVisibility(View.INVISIBLE)
                }
                R.id.manualButton -> {
                    // manual driving mode
                    status.text = "status: manual driving mode \uD83D\uDE98"
                    frontButton.setVisibility(View.VISIBLE)
                    backButton.setVisibility(View.VISIBLE)
                    leftButton.setVisibility(View.VISIBLE)
                    rightButton.setVisibility(View.VISIBLE)
                    beepButton.setVisibility(View.VISIBLE)

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
        frontButton.setBackgroundColor(Color.parseColor("#FFFFFF"))
        backButton.setBackgroundColor(Color.parseColor("#FFFFFF"))
        leftButton.setBackgroundColor(Color.parseColor("#FFFFFF"))
        rightButton.setBackgroundColor(Color.parseColor("#FFFFFF"))
        beepButton.setBackgroundColor(Color.parseColor("#FFFFFF"))
        status.text = "status: manual driving mode \uD83D\uDE98"
    }

    fun goFront(): Unit {
        frontButton.setBackgroundColor(Color.parseColor("#E9ECEF"))
        status.text = "status: Karut Car is moving forward."
    }

    fun goBack(): Unit {
        backButton.setBackgroundColor(Color.parseColor("#E9ECEF"))
        status.text = "status: Karut Car is backing up."
    }

    fun goLeft(): Unit {
        leftButton.setBackgroundColor(Color.parseColor("#E9ECEF"))
        status.text = "status: Karut Car is turning left."
    }

    fun goRight(): Unit {
        rightButton.setBackgroundColor(Color.parseColor("#E9ECEF"))
        status.text = "status: Karut Car is turning right."
    }

    fun beep(): Unit {
        beepButton.setBackgroundColor(Color.parseColor("#E9ECEF"))
        status.text = "status: Karut Car is honking! \uD83D\uDD14"
    }
}