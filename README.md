# eclipse-pet-plugin

This is an eclipse plugin created as a 'Plug-in with a view' to add a sample plugin to the view compoenent of the eclipse IDE.

Main idea is to check the feasibility of using a WEB UI technology (mostly HTML) and javaScript in the plugin development. 

Eclipse provides the <strong>org.eclipse.swt.browser.Browser</strong> widget to render the HTML inside that widget. As it says "Instances of this class implement the browser user interface metaphor. It allows the user to visualize and navigate through HTML documents."

And we can use  <strong>org.eclipse.swt.browser.BrowserFunction</strong> to access java side function from javaScript. As it says "Instances of this class represent java-side "functions" that are invokable from javascript. Browser clients define these functions by subclassing BrowserFunction and overriding its function(Object[]) method. This method will be invoked whenever javascript running in the Browser makes a call with the function's name."

The eclipse-pet-plugin is a plugin which has a HTML UI and a javaScript function which calls a java method to get the current Java version.
