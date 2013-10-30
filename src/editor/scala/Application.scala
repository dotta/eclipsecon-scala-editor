package editor.scala

import org.eclipse.equinox.app.IApplication
import org.eclipse.equinox.app.IApplicationContext
import org.eclipse.ui.PlatformUI

import util.Display
import util.using

/**
 * This class controls all aspects of the application's execution
 */
class Application extends IApplication {

  override def start(context: IApplicationContext): AnyRef = {
    using(PlatformUI.createDisplay()) { display =>
      val returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor())
      if (returnCode == PlatformUI.RETURN_RESTART) IApplication.EXIT_RESTART
      else IApplication.EXIT_OK
    }
  }

  override def stop() {
    if (PlatformUI.isWorkbenchRunning) {
      val workbench = PlatformUI.getWorkbench
      Display.syncExec(workbench.getDisplay) { display =>
        if (!display.isDisposed) workbench.close()
      }
    }
  }
}
