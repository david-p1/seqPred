
#' blah
#'
#' blah
#' @rdname functions
#' @return a list
#' @import rJava
#' @export
getFunc <- function() {

          myJavaClass <- .jnew("functions/MainTestCPTPlus2")
          out <- .jcall(myJavaClass,"Ljava/util/List;","getStats", .jarray(""))
          return(out)
}








