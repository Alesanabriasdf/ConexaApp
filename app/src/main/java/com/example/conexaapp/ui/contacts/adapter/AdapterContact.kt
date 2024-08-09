package com.example.conexaapp.ui.contacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.conexaapp.R
import com.example.conexaapp.databinding.ContactItemBinding
import com.example.conexaapp.model.contacts.ContactModel
import com.example.conexaapp.model.contacts.Localization
import com.squareup.picasso.Picasso

class AdapterContact (private var list: List<ContactModel?>, private val interaction: (ContactModel?) -> Unit) :
    RecyclerView.Adapter<AdapterContact.RecyclerAdapterHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterHolder {
        val layout = LayoutInflater.from(parent.context)
        return RecyclerAdapterHolder(layout.inflate(R.layout.contact_item, parent, false))
    }

    override fun onBindViewHolder(
        holder: RecyclerAdapterHolder,
        position: Int
    ) {
        holder.paintIt(list[position], interaction)

    }

    override fun getItemCount(): Int = list.size

    class RecyclerAdapterHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var binding = ContactItemBinding.bind(view)

        fun paintIt(contactModel: ContactModel?, interaction: (ContactModel?) -> Unit) {
            with(binding){
                if (contactModel?.image == null){
                    ivContact.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.baseline_person_24))
                } else {
                    Picasso.get().load(contactModel.image).into(ivContact)
                }
                tvNameContact.text = contactModel?.name ?: ""
                tvNumberContact.text = contactModel?.number ?: ""

                constraintContact.setOnClickListener {
                    interaction(contactModel)
                }
            }
        }
    }
}