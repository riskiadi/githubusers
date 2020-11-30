package com.alkalynx.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alkalynx.githubusers.model.UserModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        val user = intent.getParcelableExtra<UserModel>("extra_detail")
        userAvatar.setImageResource(user!!.avatar)
        usernameTxt.text = user.username
        nameTxt.text = user.name
        locationTxt.text = user.location
        companyTxt.text = "@${user.company}"
        repoTxt.text = user.repository
        followerTxt.text = user.followers
        followingTxt.text = user.following

    }
}