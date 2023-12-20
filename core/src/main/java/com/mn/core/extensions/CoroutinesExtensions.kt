package com.mn.core.extensions

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

fun <T> mutableSharedFlow(
    replay: Int = 0,
    extraBufferCapacity: Int = replay,
    onBufferOverflow: BufferOverflow = BufferOverflow.SUSPEND,
) = MutableSharedFlow<T>(replay, extraBufferCapacity, onBufferOverflow)
