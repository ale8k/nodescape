// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   signlink.java

package sign;

import java.applet.Applet;
import java.io.*;
import java.net.*;

public final class signlink
    implements Runnable
{

    public static final void startpriv(InetAddress inetaddress)
    {
        threadliveid = (int)(Math.random() * 99999999D);
        if(active)
        {
            try
            {
                Thread.sleep(500L);
            }
            catch(Exception _ex) { }
            active = false;
        }
        socketreq = 0;
        threadreq = null;
        dnsreq = null;
        savereq = null;
        urlreq = null;
        socketip = inetaddress;
        Thread thread = new Thread(new signlink());
        thread.setDaemon(true);
        thread.start();
        while(!active) 
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }
    }

    public final void run()
    {
        active = true;
        String s = findcachedir();
        uid = getuid(s);
        try
        {
            File file = new File(s + "main_file_cache.dat");
            if(file.exists() && file.length() > 0x3200000L)
                file.delete();
            cache_dat = new RandomAccessFile(s + "main_file_cache.dat", "rw");
            for(int j = 0; j < 5; j++)
                cache_idx[j] = new RandomAccessFile(s + "main_file_cache.idx" + j, "rw");

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        for(int i = threadliveid; threadliveid == i;)
        {
            if(socketreq != 0)
            {
                try
                {
                    socket = new Socket(socketip, socketreq);
                }
                catch(Exception _ex)
                {
                    socket = null;
                }
                socketreq = 0;
            } else
            if(threadreq != null)
            {
                Thread thread = new Thread(threadreq);
                thread.setDaemon(true);
                thread.start();
                thread.setPriority(threadreqpri);
                threadreq = null;
            } else
            if(dnsreq != null)
            {
                try
                {
                    dns = InetAddress.getByName(dnsreq).getHostName();
                }
                catch(Exception _ex)
                {
                    dns = "unknown";
                }
                dnsreq = null;
            } else
            if(savereq != null)
            {
                if(savebuf != null)
                    try
                    {
                        FileOutputStream fileoutputstream = new FileOutputStream(s + savereq);
                        fileoutputstream.write(savebuf, 0, savelen);
                        fileoutputstream.close();
                    }
                    catch(Exception _ex) { }
                if(waveplay)
                {
                    wave = s + savereq;
                    waveplay = false;
                }
                if(midiplay)
                {
                    midi = s + savereq;
                    midiplay = false;
                }
                savereq = null;
            } else
            if(urlreq != null)
            {
                try
                {
                    urlstream = new DataInputStream((new URL(mainapp.getCodeBase(), urlreq)).openStream());
                }
                catch(Exception _ex)
                {
                    urlstream = null;
                }
                urlreq = null;
            }
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }
        }

    }

    public static String findcachedir()
    {
        String as[] = {
            "./cache/"
        };
        if(storeid < 32 || storeid > 34)
            storeid = 32;
        String s = "";
        for(int i = 0; i < as.length; i++)
            try
            {
                String s1 = as[i];
                if(s1.length() > 0)
                {
                    File file = new File(s1);
                    if(!file.exists())
                        continue;
                }
                File file1 = new File(s1 + s);
                if(file1.exists() || file1.mkdir())
                    return s1 + s + "/";
            }
            catch(Exception _ex) { }

        return null;
    }

    private static final int getuid(String s)
    {
      return (int)(Math.random() * 99999999D);
    }

    public static final synchronized Socket opensocket(int i)
        throws IOException
    {
        for(socketreq = i; socketreq != 0;)
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }

        if(socket == null)
            throw new IOException("could not open socket");
        else
            return socket;
    }

    public static final synchronized DataInputStream openurl(String s)
        throws IOException
    {
        for(urlreq = s; urlreq != null;)
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }

        if(urlstream == null)
            throw new IOException("could not open: " + s);
        else
            return urlstream;
    }

    public static final synchronized void dnslookup(String s)
    {
        dns = s;
        dnsreq = s;
    }

    public static final synchronized void startthread(Runnable runnable, int i)
    {
        threadreqpri = i;
        threadreq = runnable;
    }

    public static final synchronized boolean wavesave(byte abyte0[], int i)
    {
        if(i > 0x1e8480)
            return false;
        if(savereq != null)
        {
            return false;
        } else
        {
            wavepos = (wavepos + 1) % 5;
            savelen = i;
            savebuf = abyte0;
            waveplay = true;
            savereq = "sound" + wavepos + ".wav";
            return true;
        }
    }

    public static final synchronized boolean wavereplay()
    {
        if(savereq != null)
        {
            return false;
        } else
        {
            savebuf = null;
            waveplay = true;
            savereq = "sound" + wavepos + ".wav";
            return true;
        }
    }

    public static final synchronized void midisave(byte abyte0[], int i)
    {
        if(i > 0x1e8480)
            return;
        if(savereq != null)
        {
            return;
        } else
        {
            midipos = (midipos + 1) % 5;
            savelen = i;
            savebuf = abyte0;
            midiplay = true;
            //savereq = "jingle" + midipos + ".mid";
            return;
        }
    }

    public static final void reporterror(String s)
    {
        if(!reporterror)
            return;
        if(!active)
            return;
        System.out.println("Error: " + s);
        try
        {
            s = s.replace(':', '_');
            s = s.replace('@', '_');
            s = s.replace('&', '_');
            s = s.replace('#', '_');
            DataInputStream datainputstream = openurl("reporterror" + 317 + ".cgi?error=" + errorname + " " + s);
            datainputstream.readLine();
            datainputstream.close();
            return;
        }
        catch(IOException _ex)
        {
            return;
        }
    }

    public signlink()
    {
    }

    private static final int clientversion = 317;
    public static int uid;
    public static int storeid = 32;
    public static RandomAccessFile cache_dat = null;
    public static RandomAccessFile cache_idx[] = new RandomAccessFile[5];
    public static boolean sunjava;
    public static Applet mainapp = null;
    private static boolean active;
    private static int threadliveid;
    private static InetAddress socketip;
    private static int socketreq;
    private static Socket socket = null;
    private static int threadreqpri = 1;
    private static Runnable threadreq = null;
    private static String dnsreq = null;
    public static String dns = null;
    private static String urlreq = null;
    private static DataInputStream urlstream = null;
    private static int savelen;
    private static String savereq = null;
    private static byte savebuf[] = null;
    private static boolean midiplay;
    private static int midipos;
    public static String midi = null;
    public static int midivol;
    public static int midifade;
    private static boolean waveplay;
    private static int wavepos;
    public static String wave = null;
    public static int wavevol;
    public static boolean reporterror = true;
    public static String errorname = "";

}
