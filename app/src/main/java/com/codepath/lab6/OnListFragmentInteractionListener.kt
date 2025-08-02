package com.codepath.lab6

/**
 * This interface is used by the [CampgroundsAdapter] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [CampgroundFragment ]
 */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: Campground)
}