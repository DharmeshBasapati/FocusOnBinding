package com.app.focusonbinding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.focusonbinding.databinding.FragmentMyTestBinding
import java.util.*

class MyTestFragment : Fragment() {

    private lateinit var usersList: ArrayList<Users>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMyTestBinding.inflate(layoutInflater)

        binding.tvMessage.text = "Team India Playing XI"

        usersList = ArrayList()

        prepareListData()

        binding.btnListToggler.addOnButtonCheckedListener { _, checkedId, _ ->

            when (checkedId) {
                R.id.btnList -> {
                    setListWithManager(LayoutType.LINEAR_LAYOUT, binding)
                }
                R.id.btnGrid -> {
                    setListWithManager(LayoutType.GRID_LAYOUT, binding)
                }
                R.id.btnStaggered -> {
                    setListWithManager(LayoutType.STAGGERED_GRID_LAYOUT, binding)
                }
            }

        }

        setListWithManager(LayoutType.LINEAR_LAYOUT, binding)


        return binding.root
    }

    private fun setListWithManager(layoutType: LayoutType, binding: FragmentMyTestBinding) {

        when (layoutType) {
            LayoutType.LINEAR_LAYOUT -> {
                binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
                val usersAdapter = UsersAdapter(usersList) { user, imgView, cardView ->
                    onItemClick(
                        user,
                        imgView,
                        cardView
                    )
                }
                binding.rvUsers.adapter = usersAdapter
            }
            LayoutType.GRID_LAYOUT -> {
                binding.rvUsers.layoutManager = GridLayoutManager(requireContext(), 2)
                val usersAdapter = UsersAdapterGrid(usersList) { user, imgView, cardView ->
                    onItemClick(
                        user,
                        imgView,
                        cardView
                    )
                }
                binding.rvUsers.adapter = usersAdapter
            }
            LayoutType.STAGGERED_GRID_LAYOUT -> {
                binding.rvUsers.layoutManager =
                    StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
                val usersAdapter = UsersAdapterGrid(usersList) { user, imgView, cardView ->
                    onItemClick(
                        user,
                        imgView,
                        cardView
                    )
                }
                binding.rvUsers.adapter = usersAdapter
            }
        }

    }

    private fun onItemClick(user: Users, imageView: ImageView, cardView: CardView) {
        val intent = Intent(requireContext(), PlayerDetailActivity::class.java)
        intent.putExtra("PASSED_PLAYER", user)

        val p1 = Pair.create<View, String>(imageView as ImageView?, "image")
        val p2 = Pair.create<View, String>(cardView as CardView?, "root")

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            requireActivity(),
            (imageView as ImageView?)!!, "image"
        )
        startActivity(intent, options.toBundle())
    }

    private fun prepareListData() {
        usersList.add(Users("Rohit Ritika Sharma", "Right-handed batsmen", R.drawable.icon_batsmen))
        usersList.add(Users("Shikhar Dhawan", "Left-handed batsmen", R.drawable.icon_batsmen))
        usersList.add(Users("Virat Kohli", "Right-handed batsmen", R.drawable.icon_batsmen))
        usersList.add(Users("Manish Pandey", "Right-handed batsmen", R.drawable.icon_batsmen))
        usersList.add(Users("Rishabh Pant", "Left-handed batsmen", R.drawable.icon_wk))
        usersList.add(
            Users(
                "Hardik Pandya",
                "Right-handed All-rounder",
                R.drawable.icon_allrounder
            )
        )
        usersList.add(
            Users(
                "Ravindra Jadeja",
                "Left-handed All-rounder",
                R.drawable.icon_allrounder
            )
        )
        usersList.add(
            Users(
                "Ravichandran Ashwin",
                "Right-handed All-rounder",
                R.drawable.icon_allrounder
            )
        )
        usersList.add(Users("Shardul Thakur", "Right-handed bowler", R.drawable.icon_bowler))
        usersList.add(Users("Jasprit Bumrah", "Right-handed bowler", R.drawable.icon_bowler))
        usersList.add(Users("Mohammad Siraj", "Right-handed bowler", R.drawable.icon_bowler))
    }


}