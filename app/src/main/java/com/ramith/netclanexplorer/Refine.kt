package com.ramith.netclanexplorer

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class Refine : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var spinner: Spinner
    lateinit var seekBar: SeekBar
    lateinit var btnP1: Button
    lateinit var btnP2: Button
    lateinit var btnP3: Button
    lateinit var btnP4: Button
    lateinit var btnP5: Button
    lateinit var btnP6: Button
    lateinit var btnP7: Button
    lateinit var btnP8: Button
    lateinit var etStatus: EditText
    lateinit var txtCharacterCount: TextView
    lateinit var txtProgress: TextView
//    var popupWindow: PopupWindow? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_refine)

        toolbar = findViewById(R.id.toolbar)
        etStatus = findViewById(R.id.etStatus)
        spinner = findViewById(R.id.spinnerAvailability)
        seekBar = findViewById(R.id.simpleSeekBar)
        btnP1 = findViewById(R.id.btnP1)
        btnP2 = findViewById(R.id.btnP2)
        btnP3 = findViewById(R.id.btnP3)
        btnP4 = findViewById(R.id.btnP4)
        btnP5 = findViewById(R.id.btnP5)
        btnP6 = findViewById(R.id.btnP6)
        btnP7 = findViewById(R.id.btnP7)
        btnP8 = findViewById(R.id.btnP8)
        txtCharacterCount = findViewById(R.id.txtCharacterCount)
        txtProgress = findViewById(R.id.txtProgress)

        setUpToolbar()

        var purposes = arrayOf(1, 1, 0, 1, 0, 0, 0, 0)

        val adapter = ArrayAdapter.createFromResource(this, R.array.availability_dropdown, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.setSelection(0)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Do something with the selected option
                val selectedOption = spinner.selectedItem as String
                // Update the Spinner's selected item text
                (view as? TextView)?.text = selectedOption
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case when no item is selected (optional)
            }
        }

        val purposeButtonClickListener = View.OnClickListener { view ->
            val button = view as Button
            val buttonId = resources.getResourceEntryName(button.id)

            val lastChar = buttonId.toString().last()
            val intId = Character.getNumericValue(lastChar)
            if(purposes[intId-1]==1){
                purposes[intId-1]=0
                button.setBackgroundResource(R.drawable.rounded_buttton_white_background)
                button.setTextColor(ContextCompat.getColor(this, R.color.light_prussian))
            }
            else {
                purposes[intId-1]=1
                button.setBackgroundResource(R.drawable.rounded_button_background)
                button.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
        }

        btnP1.setOnClickListener(purposeButtonClickListener)
        btnP2.setOnClickListener(purposeButtonClickListener)
        btnP3.setOnClickListener(purposeButtonClickListener)
        btnP4.setOnClickListener(purposeButtonClickListener)
        btnP5.setOnClickListener(purposeButtonClickListener)
        btnP6.setOnClickListener(purposeButtonClickListener)
        btnP7.setOnClickListener(purposeButtonClickListener)
        btnP8.setOnClickListener(purposeButtonClickListener)

        etStatus.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not used
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = etStatus.text.toString()
                val characterCount = text.length
                txtCharacterCount.text = characterCount.toString()+"/250"
            }

            override fun afterTextChanged(s: Editable?) {
                // Not used
            }
        })


        val maxProgress = seekBar.max.toFloat()
        var seekBarWidth : Float = 100.00f

        val screenWidth = Resources.getSystem().displayMetrics.widthPixels
        val xUnit = resources.getDimensionPixelSize(R.dimen.margin_15dp).toFloat()
        val xUnit2 = xUnit/1.65f
        val leftMargin = resources.getDimensionPixelSize(R.dimen.margin_15dp)
        val leftMarginFloat = leftMargin.toFloat()

        seekBar.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                seekBar.viewTreeObserver.removeOnGlobalLayoutListener(this) // Remove the listener to prevent multiple calls

                seekBarWidth = seekBar.width.toFloat()
                seekBarWidth = seekBarWidth-leftMarginFloat-leftMarginFloat
            }
        })

        // Add a listener to the ViewTreeObserver of the parent view
        txtProgress.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                // Remove the listener to prevent multiple invocations
                txtProgress.viewTreeObserver.removeOnGlobalLayoutListener(this)

                // Access the initial X position of the TextView
                txtProgress.x = screenWidth/2.00f - xUnit2
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val progressRatio = progress / maxProgress
                var xChange = progressRatio * seekBarWidth - xUnit2

                // Update the X position of the TextView
                txtProgress.text=progress.toString()
                txtProgress.setX(leftMarginFloat+xChange)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Handle start tracking touch event
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Handle stop tracking touch event
            }
        })



//        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                val thumb = seekBar?.thumb
//                val thumbBounds = thumb?.bounds
//
//                showSeekBarProgressPopup(progress, thumbBounds)
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                // Do nothing
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//                popupWindow?.dismiss()
//            }
//        })



//        val popUpView = layoutInflater.inflate(R.layout.popup_seekbar_progress, null)
//        val txtProgress = popUpView.findViewById<TextView>(R.id.txtProgress)
//
//        val popUp = PopupWindow(this)
//        popUp.contentView = popUpView
//        popUp.width = ViewGroup.LayoutParams.WRAP_CONTENT
//        popUp.height = ViewGroup.LayoutParams.WRAP_CONTENT
//        popUp.isOutsideTouchable = true
//        popUp.isTouchable = false
//
//        seekBar.progressDrawable = ColorDrawable(Color.TRANSPARENT)
//        seekBar.thumb = ContextCompat.getDrawable(this, androidx.transition.R.drawable.abc_seekbar_thumb_material)
//
//        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                txtProgress.text = progress.toString()
//                val thumbRect = seekBar?.thumb?.bounds
//                thumbRect?.let { rect ->
//                    val x = rect.left + rect.width() / 2
//                    val y = -rect.height()
//                    popUp.showAsDropDown(seekBar, x, y)
//                }
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                // Not needed for pop-up display
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//                popUp.dismiss()
//            }
//        })


    }

    fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Refine"
        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        }
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home)
            super.onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}