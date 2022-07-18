package domain.models

class ConnectionException : Exception() {

    override val message: String
        get() = "Connection failed"
}