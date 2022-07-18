package domain.models

class BackendInvalidResponseException() : Exception() {

    override val message: String
        get() = "Invalid response from backend"
    
}