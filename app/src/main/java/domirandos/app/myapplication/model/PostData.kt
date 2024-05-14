package domirandos.app.myapplication.model

data class PostData(
    val limit: Int,
    val posts: List<Post>,
    val skip: Int,
    val total: Int
)