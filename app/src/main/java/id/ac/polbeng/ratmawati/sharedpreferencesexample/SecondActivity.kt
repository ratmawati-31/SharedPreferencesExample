package id.ac.polbeng.ratmawati.sharedpreferencesexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.polbeng.ratmawati.sharedpreferencesexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoad.setOnClickListener {
            // Pastikan nama file di sini SAMA PERSIS dengan yang ada di MainActivity
            val filename = "$packageName-TESTFILE"
            val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")

            // Menampilkan data yang berhasil dibaca
            binding.tvOutput.text = "$firstName $lastName"
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvOutput.text = "Click Button Load Data"
    }
}