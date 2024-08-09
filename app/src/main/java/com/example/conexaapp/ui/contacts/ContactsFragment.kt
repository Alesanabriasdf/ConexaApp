package com.example.conexaapp.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.conexaapp.MainActivity
import com.example.conexaapp.databinding.FragmentContactsBinding
import com.example.conexaapp.ui.contacts.adapter.AdapterContact

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contactsViewModel =
            ViewModelProvider(this).get(ContactsViewModel::class.java)

        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        contactsViewModel.getContactList()

        (activity as? MainActivity)?.setUpToolbar(false, "All contacts") {}

        contactsViewModel.contactList.observe(viewLifecycleOwner) { list ->
            if (!list.isNullOrEmpty()) {
                binding.pbLoader.visibility = View.GONE
                binding.rvContacts.adapter = AdapterContact(list) {
                    findNavController().navigate(
                        ContactsFragmentDirections.actionNavigationDashboardToContactLocalizationFragment(
                            it?.localization?.lat?.toFloat() ?: 0F,
                            it?.localization?.long?.toFloat() ?: 0F,
                            it?.name ?: ""
                        )
                    )
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}