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
     * Update the QR contact card's street address value
     *
     * @see SettingsRepository.qrContactCardStreetAddress
     */
    val qrContactCardStreetAddress = SettingsRepository.qrContactCardStreetAddress

    /**
     * Update the QR contact card's postal code value
     *
     * @see SettingsRepository.qrContactCardPostalCode
     */
    val qrContactCardPostalCode = SettingsRepository.qrContactCardPostalCode

    /**
     * Update the QR contact card's city value
     *
     * @see SettingsRepository.qrContactCardCity
     */
    val qrContactCardCity = SettingsRepository.qrContactCardCity


    fun qrContactDataIsInvalid(): Boolean {
        refreshQRContactCardFirstName()
        refreshQRContactCardLastName()
        refreshQRContactCardStreetAddress()
        refreshQRContactCardPostalCode()
        refreshQRContactCardCity()
        return qrContactCardFirstName.value.isNullOrEmpty()
                || qrContactCardLastName.value.isNullOrEmpty()
                || qrContactCardStreetAddress.value.isNullOrEmpty()
                || qrContactCardPostalCode.value.isNullOrEmpty()
                || qrContactCardCity.value.isNullOrEmpty()
    }

    /**
     * Update QR contact card's first name
     *
     * @param value
     */
    fun updateQRContactCardFirstName(value: String?) {
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
    fun updateQRContactCardLastName(value: String?) {
        SettingsRepository.updateQRContactCardLastName(value)
    }

    fun refreshQRContactCardLastName() {
        SettingsRepository.refreshQRContactCardLastName()
    }

    /**
     * Update QR contact card's street address
     *
     * @param value
     */
    fun updateQRContactCardStreetAddress(value: String?) {
        SettingsRepository.updateQRContactCardStreetAddress(value)
    }

    fun refreshQRContactCardStreetAddress() {
        SettingsRepository.refreshQRContactCardStreetAddress()
    }

    /**
     * Update QR contact card's postal code
     *
     * @param value
     */
    fun updateQRContactCardPostalCode(value: String?) {
        SettingsRepository.updateQRContactCardPostalCode(value)
    }

    fun refreshQRContactCardPostalCode() {
        SettingsRepository.refreshQRContactCardPostalCode()
    }

    /**
     * Update QR contact card's city
     *
     * @param value
     */
    fun updateQRContactCardCity(value: String?) {
        SettingsRepository.updateQRContactCardCity(value)
    }

    fun refreshQRContactCardCity() {
        SettingsRepository.refreshQRContactCardCity()
    }
}