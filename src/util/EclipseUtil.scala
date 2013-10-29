package util

import org.eclipse.jface.viewers.DoubleClickEvent
import org.eclipse.jface.viewers.IDoubleClickListener
import org.eclipse.jface.viewers.LabelProvider

object EclipseUtil {

  implicit def doubleClickEvent2listener(f: DoubleClickEvent => Unit): IDoubleClickListener = {
    new IDoubleClickListener() {
      override def doubleClick(event: DoubleClickEvent) {
        f(event)
      }
    }
  }

  object LabelProvider {
    def apply(f: AnyRef => String): LabelProvider =
      new LabelProvider() {
        override def getText(element: AnyRef): String = f(element)
      }
  }
}