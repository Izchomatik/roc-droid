package org.rocstreaming.rocdroid

import AndroidConnector
import android.util.Log
import org.rocstreaming.rocdroid.SenderReceiverService

private const val LOG_TAG = "rocdroid.AndroidConnectorImpl"

class AndroidConnectorImpl : AndroidConnector {
    companion object {
        lateinit var senderReceiverService : SenderReceiverService
    }

    override fun startReceiver() {
        Log.i(LOG_TAG, "Try start Receiver")
        senderReceiverService.startReceiver()
    }

    override fun stopReceiver() {
        Log.i(LOG_TAG, "Try stop Receiver")
        senderReceiverService.stopReceiver()
    }

    override fun isReceiverAlive(): Boolean {
        return senderReceiverService.isReceiverAlive()
    }

    override fun startSender(ip: String) {
        Log.i(LOG_TAG, "Try start Sender")
        senderReceiverService.startSender(ip, null)
    }

    override fun stopSender() {
        Log.i(LOG_TAG, "Try stop Sender")
        senderReceiverService.stopSender()
    }

    override fun isSenderAlive(): Boolean {
        return senderReceiverService.isReceiverAlive()
    }
}
