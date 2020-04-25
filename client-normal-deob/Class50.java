// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public final class Class50
{

    public static long method583(String s)
    {
        long l = 0L;
        for(int i = 0; i < s.length() && i < 12; i++)
        {
            char c = s.charAt(i);
            l *= 37L;
            if(c >= 'A' && c <= 'Z')
                l += (1 + c) - 65;
            else
            if(c >= 'a' && c <= 'z')
                l += (1 + c) - 97;
            else
            if(c >= '0' && c <= '9')
                l += (27 + c) - 48;
        }

        for(; l % 37L == 0L && l != 0L; l /= 37L);
        return l;
    }

    public static String method584(long l, byte byte0)
    {
        try
        {
            if(byte0 != aByte818)
                throw new NullPointerException();
            if(l <= 0L || l >= 0x5b5b57f8a98a5dd1L)
                return "invalid_name";
            if(l % 37L == 0L)
                return "invalid_name";
            int i = 0;
            char ac[] = new char[12];
            while(l != 0L) 
            {
                long l1 = l;
                l /= 37L;
                ac[11 - i++] = aCharArray821[(int)(l1 - l * 37L)];
            }
            return new String(ac, 12 - i, i);
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("81570, " + l + ", " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static long method585(byte byte0, String s)
    {
        s = s.toUpperCase();
        long l = 0L;
        for(int i = 0; i < s.length(); i++)
        {
            l = (l * 61L + (long)s.charAt(i)) - 32L;
            l = l + (l >> 56) & 0xffffffffffffffL;
        }

        if(byte0 != 1)
            aBoolean820 = !aBoolean820;
        return l;
    }

    public static String method586(int i, boolean flag)
    {
        if(!flag)
            throw new NullPointerException();
        else
            return (i >> 24 & 0xff) + "." + (i >> 16 & 0xff) + "." + (i >> 8 & 0xff) + "." + (i & 0xff);
    }

    public static String method587(int i, String s)
    {
        if(i != -45804)
            anInt817 = -410;
        if(s.length() > 0)
        {
            char ac[] = s.toCharArray();
            for(int j = 0; j < ac.length; j++)
                if(ac[j] == '_')
                {
                    ac[j] = ' ';
                    if(j + 1 < ac.length && ac[j + 1] >= 'a' && ac[j + 1] <= 'z')
                        ac[j + 1] = (char)((ac[j + 1] + 65) - 97);
                }

            if(ac[0] >= 'a' && ac[0] <= 'z')
                ac[0] = (char)((ac[0] + 65) - 97);
            return new String(ac);
        } else
        {
            return s;
        }
    }

    public static String method588(String s, int i)
    {
        if(i != 0)
            throw new NullPointerException();
        StringBuffer stringbuffer = new StringBuffer();
        for(int j = 0; j < s.length(); j++)
            stringbuffer.append("*");

        return stringbuffer.toString();
    }

    private static int anInt817 = 923;
    private static byte aByte818 = -99;
    private static int anInt819 = -388;
    private static boolean aBoolean820;
    private static final char aCharArray821[] = {
        '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
        't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', 
        '3', '4', '5', '6', '7', '8', '9'
    };

}
