package com.offlineapes.lipoapp

import android.os.Build
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.annotation.RequiresApi
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardOpenOption

class JavaScriptHandler(private val mContext: MainActivity) {
    @RequiresApi(Build.VERSION_CODES.O)
    @JavascriptInterface
    fun saveFile(data: String){
        //Log.d("CREATION", "doing the thing");
        val fileName = mContext.getFilesDir().getPath().toString() + "/fileName.txt";
        val myfile = File(fileName)

        val content = "Today snow is falling.\n"
        myfile.createNewFile();
        Files.write(myfile.toPath(), data.toByteArray(), StandardOpenOption.WRITE)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @JavascriptInterface
    fun loadFile(): String {

        //Log.d("CREATION", "doing the thing");
        val fileName = mContext.getFilesDir().getPath().toString() + "/fileName.txt";
        val myfile = File(fileName)

        val content = "Today snow is falling.\n"
        myfile.createNewFile();
        return Files.readAllLines(myfile.toPath()).toString();
    }
}
