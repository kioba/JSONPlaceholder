package io.github.kioba.core

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


fun Disposable.registerForDispose(pool: CompositeDisposable): Boolean = pool.add(this)
