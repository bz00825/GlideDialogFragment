package com.example.glidew

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.fragment_super.view.*



class MysuperRecyclerViewAdapter(

    private val mContext: MainActivity,
    private val mValues: ArrayList<HashMap<String, Any>>

) : RecyclerView.Adapter<MysuperRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_super, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mContentView.text = item["names"].toString()
        holder.mPower.text = item["powers"].toString()
        holder.mGender.text = item["genders"].toString()
        Glide.with(mContext).load(item["pics"]).into(holder.mPics)

        holder.mView.setOnClickListener {
            Toast.makeText(mContext, item["names"].toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        // val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.names
        val mPower: TextView = mView.powers
        val mGender: TextView = mView.genders
        val mPics: ImageView = mView.pics
    }
}
