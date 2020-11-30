package com.alkalynx.githubusers.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.alkalynx.githubusers.DetailActivity
import com.alkalynx.githubusers.R
import com.alkalynx.githubusers.model.UserModel

class UserAdapter internal constructor(private val user:ArrayList<UserModel>): RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.avatar.setImageResource(user[position].avatar)
        holder.username.text = user[position].username
        holder.name.text = user[position].name
        holder.location.text = user[position].location
        holder.cardView.setOnClickListener {
            val intent = Intent(holder.context, DetailActivity::class.java)
            intent.putExtra("extra_detail", user[position])
            holder.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return user.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val context : Context = itemView.context
        val avatar : ImageView = itemView.findViewById(R.id.userAvatar)
        val username : TextView = itemView.findViewById(R.id.usernameTxt)
        val name : TextView = itemView.findViewById(R.id.nameTxt)
        val location : TextView = itemView.findViewById(R.id.locationTxt)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
    }

}