package domain.models

class BackendException(val errorCode:Int, val errorBody:String) : Exception() {
}