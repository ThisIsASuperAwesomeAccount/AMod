package com.aa.mod.updateChecker;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.aa.mod.Reference;

public class CheckVersion implements Runnable
{
    private static boolean isLatestVersion = false;
    private static String latestVersion = "";

    @Override
    public void run() 
    {
        InputStream in = null;
        try 
        {
            in = new URL("https://raw.githubusercontent.com/jordsta95/ArcaneArteries/master/aaversion.txt").openStream();
        } 
        catch 
        (MalformedURLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try 
        {
            latestVersion = IOUtils.readLines(in).get(0);
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        finally 
        {
            IOUtils.closeQuietly(in);
        }
        System.out.println("Latest version of Arcane Arteries is = "+latestVersion);
        isLatestVersion = Reference.VERSION.equals(latestVersion);
    }
    
    public boolean isLatestVersion()
    {
     return isLatestVersion;
    }
    
    public String getLatestVersion()
    {
     return latestVersion;
    }
}