package vitorscoelho.sw4k.comutils.dlls

import com.jacob.com.LibraryLoader
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception


object LoaderJacobDll {
    /**
     * Original source code found in https://www.javaquery.com/2013/12/getting-started-with-jacob-example-with.html
     */
    fun load() {
        /**
         * `System.getProperty("os.arch")`
         * It'll tell us on which platform Java Program is executing. Based on that we'll load respective DLL file.
         * Placed under same folder of program file(.java/.class).
         */
        val libFile = if (System.getProperty("os.arch") == "amd64") "jacob-1.19-x64.dll" else "jacob-1.19-x86.dll"
        try {
            /* Read DLL file*/
            val inputStream = LoaderJacobDll.javaClass.getResourceAsStream(libFile)
            /**
             *  Step 1: Create temporary file under <%user.home%>\AppData\Local\Temp\jacob.dll
             *  Step 2: Write contents of `inputStream` to that temporary file.
             */
            val temporaryDll = File.createTempFile("jacob", ".dll")
            val outputStream = FileOutputStream(temporaryDll)
            val array = ByteArray(size = 8192)
            var i = inputStream.read(array)
            while (i != -1) {
                outputStream.write(array, 0, i)
                i = inputStream.read(array)
            }

            outputStream.close()
            /**
             * `System.setProperty(LibraryLoader.JACOB_DLL_PATH, temporaryDll.getAbsolutePath());`
             * Set System property same like setting java home path in system.
             *
             * `LibraryLoader.loadJacobLibrary();`
             * Load JACOB library in current System.
             */
            System.setProperty(LibraryLoader.JACOB_DLL_PATH, temporaryDll.absolutePath)
            LibraryLoader.loadJacobLibrary()

            System.out.println("Jacob dll been loaded!")

            /* Temporary file will be removed after terminating-closing-ending the application-program */
            temporaryDll.deleteOnExit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}