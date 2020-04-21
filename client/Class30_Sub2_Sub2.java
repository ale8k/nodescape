// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

/**
 * Reads incoming packets Alex!
 */
import java.math.BigInteger;
import sign.signlink;

public final class Class30_Sub2_Sub2 extends Class30_Sub2
{

    public static Class30_Sub2_Sub2 method396(int i, int j)
    {
        synchronized(aClass19_1415)
        {
            Class30_Sub2_Sub2 class30_sub2_sub2_2 = null;
            if(i == 0 && anInt1411 > 0)
            {
                anInt1411--;
                class30_sub2_sub2_2 = (Class30_Sub2_Sub2)aClass19_1414.method251();
            } else
            if(i == 1 && anInt1412 > 0)
            {
                anInt1412--;
                class30_sub2_sub2_2 = (Class30_Sub2_Sub2)aClass19_1415.method251();
            } else
            if(i == 2 && anInt1413 > 0)
            {
                anInt1413--;
                class30_sub2_sub2_2 = (Class30_Sub2_Sub2)aClass19_1416.method251();
            }
            if(class30_sub2_sub2_2 != null)
            {
                class30_sub2_sub2_2.anInt1406 = 0;
                Class30_Sub2_Sub2 class30_sub2_sub2 = class30_sub2_sub2_2;
                return class30_sub2_sub2;
            }
        }
        if(j < 9 || j > 9)
            throw new NullPointerException();
        Class30_Sub2_Sub2 class30_sub2_sub2_1 = new Class30_Sub2_Sub2(false);
        class30_sub2_sub2_1.anInt1406 = 0;
        if(i == 0)
            class30_sub2_sub2_1.aByteArray1405 = new byte[100];
        else
        if(i == 1)
            class30_sub2_sub2_1.aByteArray1405 = new byte[5000];
        else
            class30_sub2_sub2_1.aByteArray1405 = new byte[30000];
        return class30_sub2_sub2_1;
    }

    private Class30_Sub2_Sub2(boolean flag)
    {
        anInt1389 = 891;
        anInt1390 = 9;
        aByte1391 = 14;
        anInt1392 = -29508;
        anInt1393 = 881;
        aByte1394 = 8;
        anInt1395 = 657;
        aBoolean1396 = false;
        anInt1397 = -715;
        aByte1398 = -57;
        aByte1399 = 108;
        aByte1400 = 3;
        aBoolean1401 = false;
        anInt1402 = -373;
        aBoolean1403 = false;
        aBoolean1404 = true;
        if(flag)
            throw new NullPointerException();
        else
            return;
    }

    public Class30_Sub2_Sub2(byte abyte0[], int i)
    {
        anInt1389 = 891;
        anInt1390 = 9;
        aByte1391 = 14;
        anInt1392 = -29508;
        anInt1393 = 881;
        aByte1394 = 8;
        anInt1395 = 657;
        aBoolean1396 = false;
        anInt1397 = -715;
        aByte1398 = -57;
        aByte1399 = 108;
        aByte1400 = 3;
        aBoolean1401 = false;
        anInt1402 = -373;
        aBoolean1403 = false;
        aBoolean1404 = true;
        if(i <= 0)
        {
            throw new NullPointerException();
        } else
        {
            aByteArray1405 = abyte0;
            anInt1406 = 0;
            return;
        }
    }

    public void method397(byte byte0, int i)
    {
        if(byte0 != 6)
        {
            for(int j = 1; j > 0; j++);
        }
        aByteArray1405[anInt1406++] = (byte)(i + aClass17_1410.method246());
    }

    public void method398(int i)
    {
        aByteArray1405[anInt1406++] = (byte)i;
    }

    public void method399(int i)
    {
        aByteArray1405[anInt1406++] = (byte)(i >> 8);
        aByteArray1405[anInt1406++] = (byte)i;
    }

    public void method400(boolean flag, int i)
    {
        aByteArray1405[anInt1406++] = (byte)i;
        aByteArray1405[anInt1406++] = (byte)(i >> 8);
        if(!flag)
            anInt1389 = -142;
    }

    public void method401(int i)
    {
        aByteArray1405[anInt1406++] = (byte)(i >> 16);
        aByteArray1405[anInt1406++] = (byte)(i >> 8);
        aByteArray1405[anInt1406++] = (byte)i;
    }

    public void method402(int i)
    {
        aByteArray1405[anInt1406++] = (byte)(i >> 24);
        aByteArray1405[anInt1406++] = (byte)(i >> 16);
        aByteArray1405[anInt1406++] = (byte)(i >> 8);
        aByteArray1405[anInt1406++] = (byte)i;
    }

    public void method403(int i, int j)
    {
        aByteArray1405[anInt1406++] = (byte)j;
        aByteArray1405[anInt1406++] = (byte)(j >> 8);
        if(i != 0)
        {
            return;
        } else
        {
            aByteArray1405[anInt1406++] = (byte)(j >> 16);
            aByteArray1405[anInt1406++] = (byte)(j >> 24);
            return;
        }
    }

    public void method404(int i, long l)
    {
        try
        {
            aByteArray1405[anInt1406++] = (byte)(int)(l >> 56);
            aByteArray1405[anInt1406++] = (byte)(int)(l >> 48);
            aByteArray1405[anInt1406++] = (byte)(int)(l >> 40);
            aByteArray1405[anInt1406++] = (byte)(int)(l >> 32);
            if(i < 5 || i > 5)
                anInt1402 = 409;
            aByteArray1405[anInt1406++] = (byte)(int)(l >> 24);
            aByteArray1405[anInt1406++] = (byte)(int)(l >> 16);
            aByteArray1405[anInt1406++] = (byte)(int)(l >> 8);
            aByteArray1405[anInt1406++] = (byte)(int)l;
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("14395, " + i + ", " + l + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method405(String s)
    {
        s.getBytes(0, s.length(), aByteArray1405, anInt1406);
        anInt1406 += s.length();
        aByteArray1405[anInt1406++] = 10;
    }

    public void method406(byte abyte0[], int i, boolean flag, int j)
    {
        if(!flag)
            aBoolean1401 = !aBoolean1401;
        for(int k = j; k < j + i; k++)
            aByteArray1405[anInt1406++] = abyte0[k];

    }

    public void method407(int i, byte byte0)
    {
        aByteArray1405[anInt1406 - i - 1] = (byte)i;
        if(byte0 == 0)
            byte0 = 0;
    }

    public int method408()
    {
        return aByteArray1405[anInt1406++] & 0xff;
    }

    public byte method409()
    {
        return aByteArray1405[anInt1406++];
    }

    public int method410()
    {
        anInt1406 += 2;
        return ((aByteArray1405[anInt1406 - 2] & 0xff) << 8) + (aByteArray1405[anInt1406 - 1] & 0xff);
    }

    public int method411()
    {
        anInt1406 += 2;
        int i = ((aByteArray1405[anInt1406 - 2] & 0xff) << 8) + (aByteArray1405[anInt1406 - 1] & 0xff);
        if(i > 32767)
            i -= 0x10000;
        return i;
    }

    public int method412()
    {
        anInt1406 += 3;
        return ((aByteArray1405[anInt1406 - 3] & 0xff) << 16) + ((aByteArray1405[anInt1406 - 2] & 0xff) << 8) + (aByteArray1405[anInt1406 - 1] & 0xff);
    }

    public int method413()
    {
        anInt1406 += 4;
        return ((aByteArray1405[anInt1406 - 4] & 0xff) << 24) + ((aByteArray1405[anInt1406 - 3] & 0xff) << 16) + ((aByteArray1405[anInt1406 - 2] & 0xff) << 8) + (aByteArray1405[anInt1406 - 1] & 0xff);
    }

    public long method414(int i)
    {
        long l = (long)method413() & 0xffffffffL;
        if(i != -35089)
            aBoolean1403 = !aBoolean1403;
        long l1 = (long)method413() & 0xffffffffL;
        return (l << 32) + l1;
    }

    public String method415()
    {
        int i = anInt1406;
        while(aByteArray1405[anInt1406++] != 10) ;
        return new String(aByteArray1405, i, anInt1406 - i - 1);
    }

    public byte[] method416(byte byte0)
    {
        int i = anInt1406;
        while(aByteArray1405[anInt1406++] != 10) ;
        byte abyte0[] = new byte[anInt1406 - i - 1];
        if(byte0 != 30)
            aBoolean1404 = !aBoolean1404;
        for(int j = i; j < anInt1406 - 1; j++)
            abyte0[j - i] = aByteArray1405[j];

        return abyte0;
    }

    public void method417(int i, byte byte0, int j, byte abyte0[])
    {
        if(byte0 != 14)
        {
            for(int k = 1; k > 0; k++);
        }
        for(int l = j; l < j + i; l++)
            abyte0[l] = aByteArray1405[anInt1406++];

    }

    public void method418(int i)
    {
        anInt1407 = anInt1406 * 8;
        if(i != anInt1392)
        {
            for(int j = 1; j > 0; j++);
        }
    }

    public int method419(int i, int j)
    {
        int k = anInt1407 >> 3;
        int l = 8 - (anInt1407 & 7);
        int i1 = 0;
        if(j != 0)
            aBoolean1403 = !aBoolean1403;
        anInt1407 += i;
        for(; i > l; l = 8)
        {
            i1 += (aByteArray1405[k++] & anIntArray1409[l]) << i - l;
            i -= l;
        }

        if(i == l)
            i1 += aByteArray1405[k] & anIntArray1409[l];
        else
            i1 += aByteArray1405[k] >> l - i & anIntArray1409[i];

        return i1;
    }

    public void method420(boolean flag)
    {
        anInt1406 = (anInt1407 + 7) / 8;
        if(!flag)
        {
            for(int i = 1; i > 0; i++);
        }
    }

    public int method421()
    {
        int i = aByteArray1405[anInt1406] & 0xff;
        if(i < 128)
            return method408() - 64;
        else
            return method410() - 49152;
    }

    public int method422()
    {
        int i = aByteArray1405[anInt1406] & 0xff;
        if(i < 128)
            return method408();
        else
            return method410() - 32768;
    }

    public void method423(BigInteger biginteger, BigInteger biginteger1, byte byte0)
    {
        int i = anInt1406;
        anInt1406 = 0;
        byte abyte0[] = new byte[i];
        method417(i, aByte1391, 0, abyte0);
        BigInteger biginteger2 = new BigInteger(abyte0);
        if(byte0 != 0)
            aBoolean1403 = !aBoolean1403;
        BigInteger biginteger3 = biginteger2;//.modPow(biginteger, biginteger1);
        byte abyte1[] = biginteger3.toByteArray();
        anInt1406 = 0;
        method398(abyte1.length);
        method406(abyte1, abyte1.length, true, 0);
    }

    public void method424(int i, int j)
    {
        aByteArray1405[anInt1406++] = (byte)(-i);
        if(j != 0)
        {
            for(int k = 1; k > 0; k++);
        }
    }

    public void method425(int i, int j)
    {
        aByteArray1405[anInt1406++] = (byte)(128 - j);
        i = 90 / i;
    }

    public int method426(int i)
    {
        if(i != 0)
            return anInt1395;
        else
            return aByteArray1405[anInt1406++] - 128 & 0xff;
    }

    public int method427(boolean flag)
    {
        if(flag)
            anInt1389 = 310;
        return -aByteArray1405[anInt1406++] & 0xff;
    }

    public int method428(int i)
    {
        if(i != 2)
            aBoolean1404 = !aBoolean1404;
        return 128 - aByteArray1405[anInt1406++] & 0xff;
    }

    public byte method429(byte byte0)
    {
        if(byte0 != aByte1398)
            throw new NullPointerException();
        else
            return (byte)(-aByteArray1405[anInt1406++]);
    }

    public byte method430(int i)
    {
        if(i != 0)
        {
            for(int j = 1; j > 0; j++);
        }
        return (byte)(128 - aByteArray1405[anInt1406++]);
    }

    public void method431(boolean flag, int i)
    {
        aByteArray1405[anInt1406++] = (byte)i;
        aByteArray1405[anInt1406++] = (byte)(i >> 8);
        if(!flag)
            aBoolean1401 = !aBoolean1401;
    }

    public void method432(int i, int j)
    {
        aByteArray1405[anInt1406++] = (byte)(j >> 8);
        while(i >= 0) 
            anInt1402 = 376;
        aByteArray1405[anInt1406++] = (byte)(j + 128);
    }

    public void method433(int i, int j)
    {
        aByteArray1405[anInt1406++] = (byte)(j + 128);
        if(i != 0)
            anInt1402 = -238;
        aByteArray1405[anInt1406++] = (byte)(j >> 8);
    }

    public int method434(byte byte0)
    {
        anInt1406 += 2;
        if(byte0 != aByte1399)
            return 3;
        else
            return ((aByteArray1405[anInt1406 - 1] & 0xff) << 8) + (aByteArray1405[anInt1406 - 2] & 0xff);
    }

    public int method435(boolean flag)
    {
        if(!flag)
        {
            for(int i = 1; i > 0; i++);
        }
        anInt1406 += 2;
        return ((aByteArray1405[anInt1406 - 2] & 0xff) << 8) + (aByteArray1405[anInt1406 - 1] - 128 & 0xff);
    }

    public int method436(byte byte0)
    {
        anInt1406 += 2;
        if(byte0 != -74)
        {
            for(int i = 1; i > 0; i++);
        }
        return ((aByteArray1405[anInt1406 - 1] & 0xff) << 8) + (aByteArray1405[anInt1406 - 2] - 128 & 0xff);
    }

    public int method437(int i)
    {
        anInt1406 += 2;
        if(i >= 0)
            return 2;
        int j = ((aByteArray1405[anInt1406 - 1] & 0xff) << 8) + (aByteArray1405[anInt1406 - 2] & 0xff);
        if(j > 32767)
            j -= 0x10000;
        return j;
    }

    public int method438(boolean flag)
    {
        if(flag)
        {
            for(int i = 1; i > 0; i++);
        }
        anInt1406 += 2;
        int j = ((aByteArray1405[anInt1406 - 1] & 0xff) << 8) + (aByteArray1405[anInt1406 - 2] - 128 & 0xff);
        if(j > 32767)
            j -= 0x10000;
        return j;
    }

    public int method439(byte byte0)
    {
        if(byte0 != 41)
        {
            return 3;
        } else
        {
            anInt1406 += 4;
            return ((aByteArray1405[anInt1406 - 2] & 0xff) << 24) + ((aByteArray1405[anInt1406 - 1] & 0xff) << 16) + ((aByteArray1405[anInt1406 - 4] & 0xff) << 8) + (aByteArray1405[anInt1406 - 3] & 0xff);
        }
    }

    public int method440(boolean flag)
    {
        if(!flag)
            aBoolean1396 = !aBoolean1396;
        anInt1406 += 4;
        return ((aByteArray1405[anInt1406 - 3] & 0xff) << 24) + ((aByteArray1405[anInt1406 - 4] & 0xff) << 16) + ((aByteArray1405[anInt1406 - 1] & 0xff) << 8) + (aByteArray1405[anInt1406 - 2] & 0xff);
    }

    public void method441(int i, byte byte0, byte abyte0[], int j)
    {
        if(byte0 != 6)
            aBoolean1396 = !aBoolean1396;
        for(int k = (i + j) - 1; k >= i; k--)
            aByteArray1405[anInt1406++] = (byte)(abyte0[k] + 128);

    }

    public void method442(int i, int j, boolean flag, byte abyte0[])
    {
        if(!flag)
            aBoolean1396 = !aBoolean1396;
        for(int k = (j + i) - 1; k >= j; k--)
            abyte0[k] = aByteArray1405[anInt1406++];

    }

    private int anInt1389;
    private int anInt1390;
    private byte aByte1391;
    private int anInt1392;
    private int anInt1393;
    private byte aByte1394;
    private int anInt1395;
    private boolean aBoolean1396;
    private int anInt1397;
    private byte aByte1398;
    private byte aByte1399;
    private byte aByte1400;
    private boolean aBoolean1401;
    private int anInt1402;
    private boolean aBoolean1403;
    private boolean aBoolean1404;
    public byte aByteArray1405[];
    public int anInt1406;
    public int anInt1407;
    private static int anIntArray1408[];
    private static final int anIntArray1409[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    public Class17 aClass17_1410;
    private static int anInt1411;
    private static int anInt1412;
    private static int anInt1413;
    private static Class19 aClass19_1414 = new Class19(169);
    private static Class19 aClass19_1415 = new Class19(169);
    private static Class19 aClass19_1416 = new Class19(169);
    private static char aCharArray1417[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
        'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
        'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
        '8', '9', '+', '/'
    };
    public static boolean aBoolean1418;

    static 
    {
        anIntArray1408 = new int[256];
        for(int j = 0; j < 256; j++)
        {
            int i = j;
            for(int k = 0; k < 8; k++)
                if((i & 1) == 1)
                    i = i >>> 1 ^ 0xedb88320;
                else
                    i >>>= 1;

            anIntArray1408[j] = i;
        }

    }
}
