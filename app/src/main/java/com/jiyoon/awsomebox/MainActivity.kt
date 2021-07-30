package com.jiyoon.awsomebox

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jiyoon.awsomebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // MediaPlayer 클래스로 리소스에서 오디오 재생 (공식)
        var beat1Player: MediaPlayer? = MediaPlayer.create(this, R.raw.beat1)
        var effect1Player: MediaPlayer? = MediaPlayer.create(this, R.raw.effect1)

        // 버튼 클릭 시 싱글스레드로 사운드 재생
        binding.btnBeat1.setOnClickListener {
            Thread() {
                beat1Player?.start()
            }.start()
        }

        binding.btnEffect1.setOnClickListener {
            Thread() {
                effect1Player?.start()
            }.start()
        }
    }
}