package de.rki.coronawarnapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import de.rki.coronawarnapp.storage.SettingsRepository

class QRContactDetailsViewModel : ViewModel() {

    /**
     * Update the QR contact card's first name value
     *
     * @see SettingsRepository.qrContactCardFirstName
     */
    val qrContactCardFirstName = SettingsRepository.qrContactCardFirstName

    /**
     * Update the QR contact card's last name value
     *
     * @see SettingsRepository.qrContactCardLastName
     */
    val qrContactCardLastName = SettingsRepository.qrContactCardLastName

    /**
     * Update the QR contact card's address value
     *
     * @see SettingsRepository.qrContactCardAddress
     */
    val qrContactCardAddress = SettingsRepository.qrContactCardAddress


    val qrContactDataIsInvalid: Boolean
        get() = qrContactCardFirstName.value.isNullOrEmpty() || qrContactCardLastName.value.isNullOrEmpty() || qrContactCardAddress.value.isNullOrEmpty()

    /**
     * Update QR contact card's first name
     *
     * @param value
     */
    fun updateQRContactCardFirstName(value: String) {
        SettingsRepository.updateQRContactCardFirstName(value)
    }

    fun refreshQRContactCardFirstName() {
        SettingsRepository.refreshQRContactCardFirstName()
    }

    /**
     * Update QR contact card's last name
     *
     * @param value
     */
    fun updateQRContactCardLastName(value: String) {
        SettingsRepository.updateQRContactCardLastName(value)
    }

    fun refreshQRContactCardLastName() {
        SettingsRepository.refreshQRContactCardLastName()
    }

    /**
     * Update QR contact card's address
     *
     * @param value
     */
    fun updateQRContactCardAddress(value: String) {
        SettingsRepository.updateQRContactCardAddress(value)
    }

    fun refreshQRContactCardAddress() {
        SettingsRepository.refreshQRContactCardAddress()
    }
}