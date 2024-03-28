package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.GetData
import com.example.myapplication.data.Posts
import com.example.myapplication.databinding.ItemPostBinding

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var posts: List<GetData> = listOf()

    fun setData(posts: List<GetData>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: GetData) {
            binding.showNameRv.text =post.name
            binding.showOldDueRv.text = "${post.oldDue} BDT"
            binding.showgroupBdt.text = post.group.toString()
        }
    }
}