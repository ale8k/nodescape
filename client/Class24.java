// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.io.*;
import java.net.Socket;
import sign.signlink;

public final class Class24
    implements Runnable
{

    public Class24(Applet_Sub1 applet_sub1, int i, Socket socket)
        throws IOException
    {
        anInt416 = -53;
        aBoolean417 = true;
        anInt418 = 519;
        aBoolean422 = false;
        aBoolean427 = false;
        aBoolean428 = false;
        while(i >= 0) 
            aBoolean417 = !aBoolean417;
        anApplet_Sub1_423 = applet_sub1;
        aSocket421 = socket;
        aSocket421.setSoTimeout(30000);
        aSocket421.setTcpNoDelay(true);
        anInputStream419 = aSocket421.getInputStream();
        anOutputStream420 = aSocket421.getOutputStream();
    }

    public void method267()
    {
        aBoolean422 = true;
        try
        {
            if(anInputStream419 != null)
                anInputStream419.close();
            if(anOutputStream420 != null)
                anOutputStream420.close();
            if(aSocket421 != null)
                aSocket421.close();
        }
        catch(IOException _ex)
        {
            System.out.println("Error closing stream");
        }
        aBoolean427 = false;
        synchronized(this)
        {
            notify();
        }
        aByteArray424 = null;
    }

    public int method268()
        throws IOException
    {
        if(aBoolean422)
            return 0;
        else
            return anInputStream419.read();
    }

    public int method269()
        throws IOException
    {
        if(aBoolean422)
            return 0;
        else
            return anInputStream419.available();
    }

    public void method270(byte abyte0[], int i, int j)
        throws IOException
    {
        if(aBoolean422)
            return;
        int k;
        for(; j > 0; j -= k)
        {
            k = anInputStream419.read(abyte0, i, j);
            if(k <= 0)
                throw new IOException("EOF");
            i += k;
        }

    }

    public void method271(int i, int j, byte abyte0[], int k)
        throws IOException
    {
        if(aBoolean422)
            return;
        if(aBoolean428)
        {
            aBoolean428 = false;
            throw new IOException("Error in writer thread");
        }
        if(aByteArray424 == null)
            aByteArray424 = new byte[5000];
        synchronized(this)
        {
            for(int l = 0; l < i; l++)
            {
                aByteArray424[anInt426] = abyte0[l + k];
                anInt426 = (anInt426 + 1) % 5000;
                if(anInt426 == (anInt425 + 4900) % 5000)
                    throw new IOException("buffer overflow");
            }

            if(!aBoolean427)
            {
                aBoolean427 = true;
                anApplet_Sub1_423.method12(this, 3);
            }
            notify();
        }
        if(j != 0)
            anInt418 = 255;
    }

    public void run()
    {
        while(aBoolean427) 
        {
            int i;
            int j;
            synchronized(this)
            {
                if(anInt426 == anInt425)
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException _ex) { }
                if(!aBoolean427)
                    return;
                j = anInt425;
                if(anInt426 >= anInt425)
                    i = anInt426 - anInt425;
                else
                    i = 5000 - anInt425;
            }
            if(i > 0)
            {
                try
                {
                    anOutputStream420.write(aByteArray424, j, i);
                }
                catch(IOException _ex)
                {
                    aBoolean428 = true;
                }
                anInt425 = (anInt425 + i) % 5000;
                try
                {
                    if(anInt426 == anInt425)
                        anOutputStream420.flush();
                }
                catch(IOException _ex)
                {
                    aBoolean428 = true;
                }
            }
        }
    }

    public void method272(byte byte0)
    {
        if(byte0 != 1)
            anInt416 = 457;
        System.out.println("dummy:" + aBoolean422);
        System.out.println("tcycl:" + anInt425);
        System.out.println("tnum:" + anInt426);
        System.out.println("writer:" + aBoolean427);
        System.out.println("ioerror:" + aBoolean428);
        try
        {
            System.out.println("available:" + method269());
            return;
        }
        catch(IOException _ex)
        {
            return;
        }
    }

    private int anInt416;
    private boolean aBoolean417;
    private int anInt418;
    private InputStream anInputStream419;
    private OutputStream anOutputStream420;
    private Socket aSocket421;
    private boolean aBoolean422;
    Applet_Sub1 anApplet_Sub1_423;
    private byte aByteArray424[];
    private int anInt425;
    private int anInt426;
    private boolean aBoolean427;
    private boolean aBoolean428;
}
