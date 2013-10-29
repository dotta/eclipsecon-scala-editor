package editor.scala

import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext

object Activator {

  val PLUGIN_ID = "editor.scala"

  private var plugin: Activator = _

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  def getDefault(): Activator = plugin

  /**
   * Returns an image descriptor for the image file at the given
   * plug-in relative path
   *
   * @param path the path
   * @return the image descriptor
   */
  def getImageDescriptor(path: String): ImageDescriptor = {
    AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path)
  }
}

/**
 * The activator class controls the plug-in life cycle
 */
class Activator extends AbstractUIPlugin {

  override def start(context: BundleContext) {
    super.start(context)
    Activator.plugin = this
  }

  override def stop(context: BundleContext) {
    Activator.plugin = null
    super.stop(context)
  }
}
