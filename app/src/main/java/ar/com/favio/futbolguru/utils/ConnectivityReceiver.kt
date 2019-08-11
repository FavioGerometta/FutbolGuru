package ar.com.favio.futbolguru.utils

import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.IntentFilter
import javax.inject.Inject
import android.arch.lifecycle.LiveData
import android.content.Context
import android.net.NetworkCapabilities
import android.util.Log
import javax.inject.Singleton


@Singleton
class ConnectivityReceiver @Inject
constructor(private val context: Context) : LiveData<ConnectivityReceiver.ConnectionModel>() {

    private val networkReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            try {
                if (intent.extras != null) {
                    val networkInfo = intent.extras!!.getParcelable<NetworkInfo>("networkInfo")
                    if (networkInfo.isConnected) {
                        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                        if (connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork).hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                            postValue(ConnectionModel(NetworkCapabilities.TRANSPORT_WIFI, true))
                        }
                        else if (connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork).hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                            postValue(ConnectionModel(NetworkCapabilities.TRANSPORT_CELLULAR, true))
                        }
                    } else {
                        postValue(ConnectionModel(null, false))
                    }
                }
            } catch (e: Exception) {
                Log.e("Catched Error!", "Not able to connect to Internet!")
            }
        }
    }

    private fun networkService(context: Context): Pair<NetworkCapabilities?, NetworkInfo?> {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return try {
            cm.getNetworkCapabilities(cm.activeNetwork) to cm.activeNetworkInfo
        } catch (e: RuntimeException) {
            null to null
        }
    }

    fun isConnectedWifi(context: Context): Boolean {
        val service = networkService(context)
        val capabilities = service.first
        val networkInfo = service.second
        return (capabilities is NetworkCapabilities && networkInfo is NetworkInfo) &&
                networkInfo.isConnected &&
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
    }

    inner class ConnectionModel(val type: Int?, val isConnected: Boolean)

    override fun onActive() {
        super.onActive()
        val filter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        context.registerReceiver(networkReceiver, filter)

    }

    override fun onInactive() {
        super.onInactive()
        context.unregisterReceiver(networkReceiver)
    }
}