package com.mysamples.mvp.model.validator

import com.mysamples.mvp.model.domain.Credential


class LoginValidator : Validator {

    private val userCredential = Credential("username", "123456")

    override fun validate(credential: Credential): Boolean {
        return credential == userCredential
    }

}