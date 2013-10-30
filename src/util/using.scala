package util

object using {

  type Disposable = { def dispose(): Unit }

  def apply[T <: Disposable, R](resource: T)(f: T => R): R = {
    try {
      f(resource)
    }
    finally {
      resource.dispose()
    }
  }
}