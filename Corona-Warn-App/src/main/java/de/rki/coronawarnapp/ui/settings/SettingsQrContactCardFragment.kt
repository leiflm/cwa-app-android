package de.rki.coronawarnapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.rki.coronawarnapp.R
import de.rki.coronawarnapp.databinding.FragmentSettingsQrContactCardBinding
import de.rki.coronawarnapp.ui.main.MainActivity
import de.rki.coronawarnapp.ui.viewmodel.QRContactDetailsViewModel
import de.rki.coronawarnapp.ui.viewmodel.SettingsViewModel

/**
 * This is the setting qr contact information details page. Here the user sees the configured contact details.
 * If no details are configured, they may be specified here.
 *
 * @see SettingsViewModel
 */
class SettingsQrContactCardFragment : Fragment() {
    companion object {
        private val TAG: String? = SettingsQrContactCardFragment::class.simpleName
    }

    private val settingsViewModel: SettingsViewModel by activityViewModels()
    private val qrContactDetailsViewModel: QRContactDetailsViewModel by activityViewModels()
    private var _binding: FragmentSettingsQrContactCardBinding? = null
    private val binding: FragmentSettingsQrContactCardBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsQrContactCardBinding.inflate(inflater)
        binding.qrContactDetailsViewModel = qrContactDetailsViewModel
        binding.settingsViewModel = settingsViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMutableLiveDataObservers()
        setButtonOnClickListener()
    }

    override fun onResume() {
        super.onResume()
        binding.settingsQrContactCardContainer.sendAccessibilityEvent(AccessibilityEvent.TYPE_ANNOUNCEMENT)
        // refresh required data
        qrContactDetailsViewModel.refreshQRContactCardFirstName()
        qrContactDetailsViewModel.refreshQRContactCardLastName()
        qrContactDetailsViewModel.refreshQRContactCardAddress()
    }

    private fun addMutableLiveDataObservers() {
        qrContactDetailsViewModel.qrContactCardFirstName.observe(viewLifecycleOwner, Observer<String> {
                newValue ->
            qrContactDetailsViewModel.updateQRContactCardFirstName(newValue)
        }
        )
        qrContactDetailsViewModel.qrContactCardLastName.observe(viewLifecycleOwner, Observer<String> {
                    newValue ->
            qrContactDetailsViewModel.updateQRContactCardLastName(newValue)
            }
        )
        qrContactDetailsViewModel.qrContactCardAddress.observe(viewLifecycleOwner, Observer<String> {
                newValue ->
            qrContactDetailsViewModel.updateQRContactCardAddress(newValue)
        }
        )
    }

    private fun setButtonOnClickListener() {
        // back navigation
        binding.settingsQrContactCardHeader.headerButtonBack.buttonIcon.setOnClickListener {
            (activity as MainActivity).goBack()
        }
    }
}
