package com.example.recyclerview_study

import android.database.DatabaseUtils
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //이곳에 리스트를 정의하는게 좋습니다
    //일반적으로 뷰 컨트롤러에서 어댑터로 데이터를 보냄
    val fruitsList = listOf(Fruit("Mango","tom"),Fruit("Apple","jom"),Fruit("Banana","hom"),Fruit("Guava","jom"),Fruit("Lemon","kom"),Fruit("Pear","oom"),Fruit("Orange","koa"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myRecyclerView.setBackgroundColor(Color.YELLOW)

        //linearlayout관리자 설정
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)

        //MyRecyclerViewAdapter 클래스를 RecyclerView의 어댑터로 설정
        //MyRecyclerViewAdapter.kt에서 fruitslist를 생성자 매개 변수로 추가했기 때문에 인수로 fruitsList를 넘겨줍니다
        binding.myRecyclerView.adapter = MyRecyclerViewAdapter(fruitsList)

    }

}
