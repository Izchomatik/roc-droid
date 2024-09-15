package org.rocstreaming.connector

import AndroidConnector
import android.util.Log
import org.rocstreaming.service.SenderReceiverService

private const val LOG_TAG = "[rocdroid.Connector]"

class AndroidConnectorImpl : AndroidConnector {
    companion object {
        var senderReceiverService : SenderReceiverService? = null
    }

    override fun startReceiver() {
        Log.d(LOG_TAG, "Try start Receiver")
        senderReceiverService?.startReceiver()
    }

    override fun stopReceiver() {
        Log.d(LOG_TAG, "Try stop Receiver")
        senderReceiverService?.stopReceiver()
    }

    override fun isReceiverAlive(): Boolean {
        return if (senderReceiverService != null) {
            senderReceiverService!!.isReceiverAlive()
        }
        else {
            false
        }
    }

    override fun startSender(ip: String) {
        Log.d(LOG_TAG, "Try start Sender")
        senderReceiverService?.startSender(ip, null)
    }

    override fun stopSender() {
        Log.d(LOG_TAG, "Try stop Sender")
        senderReceiverService?.stopSender()
    }

    override fun isSenderAlive(): Boolean {
        return if (senderReceiverService != null) {
            senderReceiverService!!.isReceiverAlive()
        }
        else {
            false
        }
    }
}
