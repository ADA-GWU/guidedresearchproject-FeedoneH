package com.mysamples.mvc.model

import com.mysamples.mvc.model.domain.Note
import com.mysamples.mvc.model.observer.DomainObserver


interface DataAccessLayer {

    var observers: MutableList<DomainObserver>

    fun register(observer: DomainObserver): Boolean

    fun unregister(observer: DomainObserver): Boolean

    fun insertNote(note: Note)

    fun getNoteList()


}