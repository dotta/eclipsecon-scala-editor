package util

import org.eclipse.swt.widgets.{Display => SWTDisplay}

object Display {

  /** Asynchronously run `f` on the UI thread. */
  def asyncExec(display: SWTDisplay)(f: SWTDisplay => Unit) {
    display asyncExec new Runnable {
      override def run() { f(display) }
    }
  }

  /** Synchronously run `f` on the UI thread. */
  def syncExec(display: SWTDisplay)(f: SWTDisplay => Unit) {
    display syncExec new Runnable {
      override def run() { f(display) }
    }
  }
}