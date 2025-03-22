package com.example.start

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import com.example.start.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(

            id = 1,
            author = "Бтпит",
            content = "ГБПОУ ВО «БТПИТ» образовано в соответствии с  постановлением правительства Воронежской области от 20 мая 2015 года № 401 в результате реорганизации в  форме слияния государственного образовательного бюджетного учреждения среднего профессионального образования Воронежской области «Борисоглебский индустриальный техникум», государственного образовательного бюджетного учреждения среднего профессионального образования Воронежской области «Борисоглебский техникум информатики и вычислительной техники» и государственного образовательного бюджетного учреждения начального профессионального образования Воронежской области «Профессиональное училище № 34 г. Борисоглебска»",
            published = "14 марта в 11:32",
            likeB = false,
            repost = 5, likes = 10,
        )
        with(binding){
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likes.text = formatNumber(post.likes)
            repost.text = formatNumber(post.repost)
            if (post.likeB) {
                like?.setImageResource(R.drawable.lik)
            }
            like?.setOnClickListener {
                post.likeB = !post.likeB
                like.setImageResource(
                    if (post.likeB) R.drawable.like1 else R.drawable.lik
                )
                if(post.likeB){
                    post.likes = post.likes+1
                    likes.text = formatNumber(post.likes)
                }
                else{
                    post.likes = post.likes-1
                    likes.text = formatNumber(post.likes)
                }
            }

            aaa?.setOnClickListener{
                post.repost = post.repost+1
                repost.text = formatNumber(post.repost)
            }
        }
    }private fun formatNumber(number: Int): String{
        return when{
            number >= 1_000_000 -> String.format("%.1fM",number / 1_000_000.0).replace(",",".")
            number >= 1_000 -> String.format("%.1fK",number / 1_000.0)
            else -> number.toString()
            }
        }

    }



