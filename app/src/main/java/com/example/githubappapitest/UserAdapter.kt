package com.example.githubappapitest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
//import com.example.githubappapitest.data.model.Item
import com.example.githubappapitest.data.model.ResponeUserGithub
import com.example.githubappapitest.databinding.ItemUserBinding

class UserAdapter(private val data:MutableList<ResponeUserGithub.Item> = mutableListOf()):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    fun setData(data: MutableList<ResponeUserGithub.Item>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    class UserViewHolder(private val v:ItemUserBinding): RecyclerView.ViewHolder(v.root){
        fun bind(item: ResponeUserGithub.Item){
            v.image.load(item.avatar_url){
                transformations(CircleCropTransformation())
            }

            v.username.text = item.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size
}