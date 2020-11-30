package com.alkalynx.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alkalynx.githubusers.adapter.UserAdapter
import com.alkalynx.githubusers.model.UserModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView : RecyclerView = findViewById(R.id.userRecycler)

        adapter = UserAdapter(dummyData())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }

    fun dummyData():ArrayList<UserModel>{
        var users : ArrayList<UserModel> = ArrayList()
        var username = resources.getStringArray(R.array.username)
        var name = resources.getStringArray(R.array.name)
        var location = resources.getStringArray(R.array.location)
        var repository = resources.getStringArray(R.array.repository)
        var company = resources.getStringArray(R.array.company)
        var followers = resources.getStringArray(R.array.followers)
        var following = resources.getStringArray(R.array.following)
        var avatar = resources.obtainTypedArray(R.array.avatar)
        for(i in 0..(username.size-1)){
            users.add(UserModel(
                username[i],
                name[i],
                location[i],
                repository[i],
                company[i],
                followers[i],
                following[i],
                avatar.getResourceId(i, -1)
            ))
        }
        return users
    }

}