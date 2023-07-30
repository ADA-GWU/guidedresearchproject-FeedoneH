package com.mysamples.mvp.model.validator

import com.mysamples.mvp.model.domain.Credential

interface Validator {

    fun validate(credential: Credential): Boolean

}
