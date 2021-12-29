package com.taghavi.rxjavaflatmaptest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList
import com.taghavi.rxjavaflatmaptest.models.Post
import android.widget.ProgressBar
import android.widget.TextView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private val TAG = "RecyclerAdapter"
    private var posts: ArrayList<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_post_list_item, null, false)
        )
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    fun setPosts(posts: ArrayList<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    fun updatePost(post: Post) {
        posts[posts.indexOf(post)] = post
        notifyItemChanged(posts.indexOf(post))
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null
        var numComments: TextView? = null
        var progressBar: ProgressBar? = null

        init {
            title = itemView.findViewById(R.id.title)
            numComments = itemView.findViewById(R.id.num_comments)
            progressBar = itemView.findViewById(R.id.progress_bar)
        }

        fun bind(post: Post) {
            title!!.text = post.title
            if (post.comments == null) {
                showProgressBar(true)
                numComments?.text = ""
            } else {
                showProgressBar(false)
                numComments?.text = post.comments.size.toString()
            }
        }

        private fun showProgressBar(showProgressBar: Boolean) {
            if (showProgressBar) {
                progressBar!!.visibility = View.VISIBLE
            } else {
                progressBar!!.visibility = View.GONE
            }
        }
    }
}