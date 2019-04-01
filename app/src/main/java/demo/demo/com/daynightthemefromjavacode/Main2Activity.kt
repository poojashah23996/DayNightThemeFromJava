package demo.demo.com.daynightthemefromjavacode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.SwitchCompat
import android.widget.Button
import com.journaldev.daynightmode.R

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PreferenceHelper.initialize(this)
        if (!PreferenceHelper.getInstance().getBoolean("theme")) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        setContentView(R.layout.activity_main)
        val switchCompat = findViewById<SwitchCompat>(R.id.switchCompat)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            AlertDialog.Builder(this, R.style.MyDialog)
                .setTitle("Title")
                .setMessage("Message")
                .show()
        }

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            switchCompat.isChecked = true

        switchCompat.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                PreferenceHelper.getInstance().setBoolean("theme", false)
                this.recreate()
            } else {
                PreferenceHelper.getInstance().setBoolean("theme", true)
                this.recreate()
            }
        }

    }
}
