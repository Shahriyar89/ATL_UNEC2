package com.example.atl_unec2.coroutines.flow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.whenResumed
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.FragmentCoroutinesBinding
import com.example.atl_unec2.databinding.FragmentKotlinFlowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class KotlinFlowFragment : Fragment() {
    private var _binding: FragmentKotlinFlowBinding? = null
    private val binding get() = _binding!!
    val TAG = "Collecting data"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKotlinFlowBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            getDataFlow()?.collect { data ->
                Log.d(TAG, "$data")
            }
        }


//
//            filterFlowData()
//                .filter { it.contains("3") }
//                .map { "$it. but it is not all" }
//                .collect { data ->
//                    Log.d(TAG, "$data")
//                }


//            getFlowForConcat()
//                .flatMapLatest{ counter ->
////                .flatMapConcat { counter ->
//                    flow {
//                        delay(1000)
//                        emit(counter * 10)
//
//                    }
//                }.collect { data ->
//                    Log.d(TAG, "$data")
//                }
//
//            getFlowDataByList()
//                .onEach { data ->
//                    Log.d(TAG, data)
//                }
//                .collectLatest { a ->
//                    delay(1000)
//                    Log.d(TAG, "by collect $a")
//                }


//            getChannelData()


    }


    private suspend fun getDataFlow(): Flow<String>? {
        var data :Flow<String>?=null

        CoroutineScope(Dispatchers.Main).launch {
           data= flow {
                emit("start loading ...")
                delay(1000)

                emit("get data ")
                delay(1000)

                emit("start filtering data ")
                delay(1000)

                emit("ready data")
                delay(1000)

                emit("stop loading")
                delay(1000)
            }
        }
                return data
    }


    private fun startCountDown(): Flow<Int> {
        var startTime = 10
        return flow {
            while (startTime >= 0) {
                emit(startTime)
                delay(1000)
                startTime--
            }
        }
    }


    private fun filterFlowData(): Flow<String> {
        var counter = 1

        return flow {
            emit("This result number is $counter")
            delay(1000)
            counter++

            emit("this result number is $counter")
            delay(1000)
            counter++

            emit("This result number is $counter")
            delay(1000)
            counter++

            emit("This result number is $counter")
            delay(1000)
            counter++
        }
    }


    private fun getFlowForConcat(): Flow<Int> {
        return flow {
            repeat(5) {
                emit(it)
            }
        }
    }

    val list = listOf("result 1", "result 2", "result 3")

    private fun getFlowDataByList(): Flow<String> = flow {
        emit(list[0])
        delay(1000)

        emit(list[1])
        delay(1000)

        emit(list[2])
        delay(1000)
    }


    private fun getChannelData() {
        var channel: ReceiveChannel<String> = Channel()

        // Producer Coroutine
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        val coroutineScope_ = CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
            channel = produce {
                Log.d(TAG, "Is producer closed: ${channel.isClosedForReceive}")
                send("A")
                send("B")
                send("C")
                send("D")
                // we don't have to close the channel explicitly
            }
        }

        // Consumer Coroutine
        coroutineScope_.launch {

            channel.consumeEach {
                Log.d(TAG, "Received $it")
            }

            // channel is automatically closed
            Log.d(TAG, "Is producer closed: ${channel.isClosedForReceive}")
        }
    }

}