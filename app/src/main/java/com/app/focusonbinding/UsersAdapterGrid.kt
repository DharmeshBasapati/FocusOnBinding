package com.app.focusonbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.focusonbinding.databinding.GridItemUsersBinding
import com.app.focusonbinding.databinding.RowItemUsersBinding

class UsersAdapterGrid(val usersList: ArrayList<Users>, var itemClicker: (Users,ImageView,CardView)->Unit) :
    RecyclerView.Adapter<UsersAdapterGrid.UsersViewHolder>() {

    inner class UsersViewHolder(val gridItemUsersBinding: GridItemUsersBinding) : RecyclerView.ViewHolder(gridItemUsersBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UsersViewHolder(
        GridItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        with(holder) {
            with(usersList[position]) {
                gridItemUsersBinding.tvUsername.text = userName
                gridItemUsersBinding.tvUserType.text = userType
                gridItemUsersBinding.ivUserType.setImageResource(userTypeIcon)
                gridItemUsersBinding.root.setOnClickListener {
                    itemClicker(usersList[position],gridItemUsersBinding.ivUserType,gridItemUsersBinding.root)
                }
            }
        }
    }

    override fun getItemCount() = usersList.size
}