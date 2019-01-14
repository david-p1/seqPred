
#' blah
#'
#' blah
#' @rdname functions
#' @return a list
#' @import rJava
#' @export
getFunc <- function() {

          myJavaClass <- .jnew("functions/MainTestCPTPlus2")
          out <- J(myJavaClass, "getStats")
          # out <- .jcall(myJavaClass, "Ljava/lang/Object;", "getStats")
          # Error in .jcall(myJavaClass, "Ljava/lang/Object;", "getStats") :
          # method getStats with signature ()Ljava/lang/Object; not found
          return(out)
}








