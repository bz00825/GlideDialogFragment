package com.example.glidew

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.glidew.R.drawable.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [superFragment.OnListFragmentInteractionListener] interface.
 */
class superFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_super_list, container, false)

        val names = listOf("Iron Man", "Spider man", "Thor", "Black widow")
        val powers = listOf(100, 85, 120, 80)
        val genders = listOf("Male", "Male", "Male","Female")
        val pics = listOf(ironman, spidey, fatgod, widow)
        val superheroes = ArrayList<HashMap<String, Any>>()

        for (i in 0 until names.size) {
            val heroHashMap: HashMap<String, Any> = HashMap()
            heroHashMap["names"] = names[i]
            heroHashMap["powers"] = powers[i]
            heroHashMap["genders"] = genders[i]
            heroHashMap["pics"] = pics[i]
            superheroes.add(heroHashMap)
        }

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MysuperRecyclerViewAdapter(activity as MainActivity, superheroes)
            }
        }
        return view
    }
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"
                }
            }
