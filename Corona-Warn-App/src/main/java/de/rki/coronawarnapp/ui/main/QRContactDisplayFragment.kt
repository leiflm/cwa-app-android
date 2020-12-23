package de.rki.coronawarnapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import de.rki.coronawarnapp.databinding.FragmentQrContactDisplayBinding
import de.rki.coronawarnapp.ui.viewmodel.QRContactDetailsViewModel


class QRContactDisplayFragment : Fragment() {

    companion object {
        private val TAG: String? = QRContactDisplayFragment::class.simpleName
    }

    private var qrContactDetailsViewModel: QRContactDetailsViewModel = QRContactDetailsViewModel()
    private var _binding: FragmentQrContactDisplayBinding? = null
    private val binding: FragmentQrContactDisplayBinding get() = _binding!!
    private val barcodeEncoder = BarcodeEncoder()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQrContactDisplayBinding.inflate(inflater)
        binding.qrContactDetailsViewModel = qrContactDetailsViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        qrContactDetailsViewModel = ViewModelProvider(this).get(QRContactDetailsViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        val firstName = qrContactDetailsViewModel.qrContactCardFirstName.value
        val lastName = qrContactDetailsViewModel.qrContactCardLastName.value
        val streetAddress = qrContactDetailsViewModel.qrContactCardStreetAddress.value
        val postalCode = qrContactDetailsViewModel.qrContactCardPostalCode.value
        val city = qrContactDetailsViewModel.qrContactCardCity.value
        qrContactDetailsViewModel.refreshQRContactCardFirstName()
        qrContactDetailsViewModel.refreshQRContactCardLastName()
        qrContactDetailsViewModel.refreshQRContactCardStreetAddress()
        qrContactDetailsViewModel.refreshQRContactCardPostalCode()
        qrContactDetailsViewModel.refreshQRContactCardCity()
        val vCardTemplate =
                """
                BEGIN:VCARD
                VERSION:3.0
                N:$lastName;$firstName
                FN:$firstName $lastName
                ADR;TYPE=HOME:;;$streetAddress;$city;;$postalCode;Germany
                END:VCARD
                """.trimIndent()
        val qrCodeImageView = binding.imageViewQRContactDisplay
        val qrString = vCardTemplate
        binding.layoutQRContactDisplay.post {
            val width = binding.layoutQRContactDisplay.width
            val qrCode = barcodeEncoder.encodeBitmap(qrString, BarcodeFormat.QR_CODE, width, width)
            qrCodeImageView.setImageBitmap(qrCode)
        }
    }

}