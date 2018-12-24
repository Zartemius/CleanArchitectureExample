package com.example.darte.cleanarchitectureexample.constants

enum class SigningUpDataValidation(val status:Int) {

    EMAIL_IS_EMPTY(1),
    PASSWORD_IS_EMPTY(2),
    PASSWORD_TOO_SHORT(3),
    NAME_IS_EMPTY(4),
    SURNAME_IS_EMPTY(5),
    MIDDLE_NAME_IS_EMPTY(6),
    PHONE_NUMBER_IS_EMPTY(7),
    NAME_FORMAT_WRONG(8),
    SURNAME_FORMAT_WRONG(9),
    MIDDLE_NAME_FORMAT_WRONG(10),
    EMAIL_FORMAT_WRONG(11),
    PASSWORDS_DO_NOT_MATCH(12)
}