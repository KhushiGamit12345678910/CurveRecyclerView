package com.example.curverecyclerview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.view.drawToBitmap
import com.example.curverecyclerview.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val data = arrayOf("Berlin", "Moscow", "Tokyo", "Paris")
//        binding.wheelPicker.minValue = 0
//        binding.wheelPicker.maxValue = data.size -1
//        binding.wheelPicker.displayedValues = data
//
        openBottomSheet()

    }

    @SuppressLint("MissingInflatedId")
    private fun openBottomSheet(){
        val dialog = BottomSheetDialog(this)

        val view = layoutInflater.inflate(R.layout.fragment_dry_cargo_bottom_sheet, null)

        val picker = view.findViewById<NumberPicker>(R.id.wheelPicker)
        val clMainView = view.findViewById<ConstraintLayout>(R.id.clMain)

        val data = arrayOf("Curtainside", "Box/Van Trailer", "Tanker Trailer", "Livestock Trailer","B-Train Reefer Trailer")
        picker.minValue = 0
        picker.maxValue = data.size-1
        picker.displayedValues = data

        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
        clMainView.setOnClickListener {

            dialog.dismiss()
        }
    }
}