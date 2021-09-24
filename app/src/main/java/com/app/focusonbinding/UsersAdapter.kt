package com.app.focusonbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.focusonbinding.databinding.GridItemUsersBinding
import com.app.focusonbinding.databinding.RowItemUsersBinding

class UsersAdapter(val usersList: ArrayList<Users>, var itemClicker: (Users, ImageView,CardView)->Unit) :
    RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    inner class UsersViewHolder(val rowItemUsersBinding: RowItemUsersBinding) : RecyclerView.ViewHolder(rowItemUsersBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UsersViewHolder(
        RowItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        with(holder) {
            with(usersList[position]) {
                rowItemUsersBinding.tvUsername.text = userName
                rowItemUsersBinding.tvUserType.text = userType
                rowItemUsersBinding.ivUserType.setImageResource(userTypeIcon)
                rowItemUsersBinding.root.setOnClickListener {
                    itemClicker(usersList[position],rowItemUsersBinding.ivUserType,rowItemUsersBinding.root)
                }
            }
        }
    }

    override fun getItemCount() = usersList.size
}