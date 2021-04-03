package com.example.recyclerview_study
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//어댑터 클래스의 세 가지 주요 기능
//onCreateViewHolder, onBindViewHolder, getItemCount

//fruitslist를 생성자 매개 변수로 추가해준다
class MyRecyclerViewAdapter(private val fruitsList:List<Fruit>, private val clickListener:(Fruit)->Unit):RecyclerView.Adapter<MyViewHolder>() {
    //이와 같이 어댑터 내부에 정의 하는건 좋은 습관이 아닙니다
//    val fruitsList = listOf("Mango","Apple","Banana","Guava","Lemon","Pear","Orange")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)

        //onCreateViewHolder에서 리사이클러뷰 라이브러리는 뷰홀더 인스턴스를 반환해야함
        //위에 : MyViewHolder이 인스턴스
        //여기서 만든 MyViewHolder 클래스는 ViewHolder 클래스의 하위 클래스이다
        //따라서 MyViewHolder는 ViewHolder 입니다. 뷰가 매개 변수로 표시되는 생성자를 포함합니다.
        //따라서 MyViewHolder로 return 해줍니다
        return MyViewHolder(listItem)
    }


    //onBindViewHolder를 사용하여 데이터를 표시
    //position은 목록 항목의 위치 값을 나타냅니다
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //onBindViewHolder의 매개변수를 MyViewHolder로 넘겨줘야한다
        holder.bind(fruitsList[position], clickListener)
    }

    //어댑터가 보유한 데이터 세트의 총 항목 수 리턴
    override fun getItemCount(): Int {
        return fruitsList.size
    }

}

//별도의 파일에서 이 작업을 할수 있지만 ViewHolder클래스를 사용하는 것이 훨씬 쉽다
//MyViewHolder에서 onBindViewHolder의 역할을 수행하는것이 객체지향 프로그래밍의 모범 사례이다
class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    //위쪽에서 MyViewHolder 클래스에서 ViewHolder에 인수로 뷰를 전달해야 하기 때문에 (view)를 썼다

    fun bind(fruit: Fruit,  clickListener:(Fruit)->Unit){
        view.findViewById<TextView>(R.id.name_text_view).text = fruit.name
        view.setOnClickListener {
            clickListener(fruit)
        }
    }


}