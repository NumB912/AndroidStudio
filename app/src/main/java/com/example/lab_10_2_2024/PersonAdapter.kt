package com.example.lab_10_2_2024
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val persons:MutableList<Person>):
RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(){
    class PersonViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val PersonFirstNameTextView:TextView = itemView.findViewById(R.id.FirstName)
        val PersonLastNameTextView:TextView = itemView.findViewById(R.id.LastName)
        val PersonNumberPhone:TextView = itemView.findViewById(R.id.numberPhone)
        val PersonGender:TextView = itemView.findViewById(R.id.Gender)

    }

    fun addPerson(person:Person){
        persons.add(person)
        notifyItemInserted(persons.size-1)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_person,parent,false)
        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = persons[position]
        holder.PersonFirstNameTextView.text = person.firstName
        holder.PersonLastNameTextView.text = person.lastName
        holder.PersonNumberPhone.text = person.numberPhone
        holder.PersonGender.text = person.gender
    }

    override fun getItemCount(): Int {
        return persons.size
    }


}