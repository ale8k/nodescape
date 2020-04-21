// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.util.Random;
import sign.signlink;

public final class Class30_Sub2_Sub1_Sub4 extends Class30_Sub2_Sub1
{

    public Class30_Sub2_Sub1_Sub4(boolean flag, String s, int i, Class44 class44)
    {
        aBoolean1484 = false;
        anInt1485 = 445;
        anInt1486 = -471;
        anInt1487 = -471;
        aBoolean1488 = false;
        anInt1489 = 3;
        aBoolean1490 = false;
        aByteArrayArray1491 = new byte[256][];
        anIntArray1492 = new int[256];
        anIntArray1493 = new int[256];
        anIntArray1494 = new int[256];
        anIntArray1495 = new int[256];
        anIntArray1496 = new int[256];
        aRandom1498 = new Random();
        aBoolean1499 = false;
        Class30_Sub2_Sub2 class30_sub2_sub2 = new Class30_Sub2_Sub2(class44.method571(s + ".dat", null), 891);
        Class30_Sub2_Sub2 class30_sub2_sub2_1 = new Class30_Sub2_Sub2(class44.method571("index.dat", null), 891);
        byte byte0 = -1;
        if(i != 0)
            aBoolean1490 = !aBoolean1490;
        class30_sub2_sub2_1.anInt1406 = class30_sub2_sub2.method410() + 4;
        int k = class30_sub2_sub2_1.method408();
        if(k > 0)
            class30_sub2_sub2_1.anInt1406 += 3 * (k - 1);
        for(int l = 0; l < 256; l++)
        {
            int j = l;
            anIntArray1494[l] = class30_sub2_sub2_1.method408();
            anIntArray1495[l] = class30_sub2_sub2_1.method408();
            int i1 = anIntArray1492[l] = class30_sub2_sub2_1.method410();
            int j1 = anIntArray1493[l] = class30_sub2_sub2_1.method410();
            int k1 = class30_sub2_sub2_1.method408();
            int l1 = i1 * j1;
            aByteArrayArray1491[l] = new byte[l1];
            if(k1 == 0)
            {
                for(int i2 = 0; i2 < l1; i2++)
                    aByteArrayArray1491[l][i2] = class30_sub2_sub2.method409();

            } else
            if(k1 == 1)
            {
                for(int j2 = 0; j2 < i1; j2++)
                {
                    for(int l2 = 0; l2 < j1; l2++)
                        aByteArrayArray1491[l][j2 + l2 * i1] = class30_sub2_sub2.method409();

                }

            }
            if(j1 > anInt1497 && l < 128)
                anInt1497 = j1;
            anIntArray1494[l] = 1;
            anIntArray1496[l] = i1 + 2;
            int k2 = 0;
            for(int i3 = j1 / 7; i3 < j1; i3++)
                k2 += aByteArrayArray1491[l][i3 * i1];

            if(k2 <= j1 / 7)
            {
                anIntArray1496[l]--;
                anIntArray1494[l] = 0;
            }
            k2 = 0;
            for(int j3 = j1 / 7; j3 < j1; j3++)
                k2 += aByteArrayArray1491[l][(i1 - 1) + j3 * i1];

            if(k2 <= j1 / 7)
                anIntArray1496[l]--;
        }

        if(flag)
        {
            anIntArray1496[32] = anIntArray1496[73];
            return;
        } else
        {
            anIntArray1496[32] = anIntArray1496[105];
            return;
        }
    }

    public void method380(String s, int i, int j, byte byte0, int k)
    {
        method385(j, s, k, 822, i - method384(s, true));
        if(byte0 != -80)
        {
            for(int l = 1; l > 0; l++);
        }
    }

    public void method381(int i, String s, int j, int k, int l)
    {
        if(j != 23693)
            anInt1489 = 467;
        method385(i, s, k, 822, l - method384(s, true) / 2);
    }

    public void method382(int i, int j, int k, String s, int l, boolean flag)
    {
        k = 74 / k;
        method389(false, flag, j - method383(anInt1485, s) / 2, i, s, l);
    }

    public int method383(int i, String s)
    {
        i = 75 / i;
        if(s == null)
            return 0;
        int j = 0;
        for(int k = 0; k < s.length(); k++)
            if(s.charAt(k) == '@' && k + 4 < s.length() && s.charAt(k + 4) == '@')
                k += 4;
            else
                j += anIntArray1496[s.charAt(k)];

        return j;
    }

    public int method384(String s, boolean flag)
    {
        if(!flag)
        {
            for(int i = 1; i > 0; i++);
        }
        if(s == null)
            return 0;
        int j = 0;
        for(int k = 0; k < s.length(); k++)
            j += anIntArray1496[s.charAt(k)];

        return j;
    }

    public void method385(int i, String s, int j, int k, int l)
    {
        if(s == null)
            return;
        j -= anInt1497;
        for(int i1 = 0; i1 < s.length(); i1++)
        {
            char c = s.charAt(i1);
            if(c != ' ')
                method392(aByteArrayArray1491[c], l + anIntArray1494[c], j + anIntArray1495[c], anIntArray1492[c], anIntArray1493[c], i);
            l += anIntArray1496[c];
        }

        k = 50 / k;
    }

    public void method386(int i, boolean flag, String s, int j, int k, int l)
    {
        if(!flag)
            aBoolean1490 = !aBoolean1490;
        if(s == null)
            return;
        j -= method384(s, true) / 2;
        l -= anInt1497;
        for(int i1 = 0; i1 < s.length(); i1++)
        {
            char c = s.charAt(i1);
            if(c != ' ')
                method392(aByteArrayArray1491[c], j + anIntArray1494[c], l + anIntArray1495[c] + (int)(Math.sin((double)i1 / 2D + (double)k / 5D) * 5D), anIntArray1492[c], anIntArray1493[c], i);
            j += anIntArray1496[c];
        }

    }

    public void method387(int i, String s, int j, int k, byte byte0, int l)
    {
        if(s == null)
            return;
        i -= method384(s, true) / 2;
        k -= anInt1497;
        if(byte0 != 5)
            return;
        for(int i1 = 0; i1 < s.length(); i1++)
        {
            char c = s.charAt(i1);
            if(c != ' ')
                method392(aByteArrayArray1491[c], i + anIntArray1494[c] + (int)(Math.sin((double)i1 / 5D + (double)j / 5D) * 5D), k + anIntArray1495[c] + (int)(Math.sin((double)i1 / 3D + (double)j / 5D) * 5D), anIntArray1492[c], anIntArray1493[c], l);
            i += anIntArray1496[c];
        }

    }

    public void method388(int i, String s, boolean flag, int j, int k, int l, int i1)
    {
        if(!flag)
        {
            for(int j1 = 1; j1 > 0; j1++);
        }
        if(s == null)
            return;
        double d = 7D - (double)i / 8D;
        if(d < 0.0D)
            d = 0.0D;
        l -= method384(s, true) / 2;
        k -= anInt1497;
        for(int k1 = 0; k1 < s.length(); k1++)
        {
            char c = s.charAt(k1);
            if(c != ' ')
                method392(aByteArrayArray1491[c], l + anIntArray1494[c], k + anIntArray1495[c] + (int)(Math.sin((double)k1 / 1.5D + (double)j) * d), anIntArray1492[c], anIntArray1493[c], i1);
            l += anIntArray1496[c];
        }

    }

    public void method389(boolean flag, boolean flag1, int i, int j, String s, int k)
    {
        aBoolean1499 = false;
        int l = i;
        if(s == null)
            return;
        k -= anInt1497;
        for(int i1 = 0; i1 < s.length(); i1++)
            if(s.charAt(i1) == '@' && i1 + 4 < s.length() && s.charAt(i1 + 4) == '@')
            {
                int j1 = method391(s.substring(i1 + 1, i1 + 4), anInt1486);
                if(j1 != -1)
                    j = j1;
                i1 += 4;
            } else
            {
                char c = s.charAt(i1);
                if(c != ' ')
                {
                    if(flag1)
                        method392(aByteArrayArray1491[c], i + anIntArray1494[c] + 1, k + anIntArray1495[c] + 1, anIntArray1492[c], anIntArray1493[c], 0);
                    method392(aByteArrayArray1491[c], i + anIntArray1494[c], k + anIntArray1495[c], anIntArray1492[c], anIntArray1493[c], j);
                }
                i += anIntArray1496[c];
            }

        if(flag)
            return;
        if(aBoolean1499)
            Class30_Sub2_Sub1.method339(k + (int)((double)anInt1497 * 0.69999999999999996D), 0x800000, i - l, l, (byte)4);
    }

    public void method390(boolean flag, int i, int j, String s, int k, int l, int i1)
    {
        if(s == null)
            return;
        aRandom1498.setSeed(k);
        int j1 = 192 + (aRandom1498.nextInt() & 0x1f);
        i1 -= anInt1497;
        l = 10 / l;
        for(int k1 = 0; k1 < s.length(); k1++)
            if(s.charAt(k1) == '@' && k1 + 4 < s.length() && s.charAt(k1 + 4) == '@')
            {
                int l1 = method391(s.substring(k1 + 1, k1 + 4), anInt1486);
                if(l1 != -1)
                    j = l1;
                k1 += 4;
            } else
            {
                char c = s.charAt(k1);
                if(c != ' ')
                {
                    if(flag)
                        method394(192, i + anIntArray1494[c] + 1, aByteArrayArray1491[c], anIntArray1492[c], i1 + anIntArray1495[c] + 1, anIntArray1493[c], false, 0);
                    method394(j1, i + anIntArray1494[c], aByteArrayArray1491[c], anIntArray1492[c], i1 + anIntArray1495[c], anIntArray1493[c], false, j);
                }
                i += anIntArray1496[c];
                if((aRandom1498.nextInt() & 3) == 0)
                    i++;
            }

    }

    public int method391(String s, int i)
    {
        if(i >= 0)
            aBoolean1484 = !aBoolean1484;
        if(s.equals("red"))
            return 0xff0000;
        if(s.equals("gre"))
            return 65280;
        if(s.equals("blu"))
            return 255;
        if(s.equals("yel"))
            return 0xffff00;
        if(s.equals("cya"))
            return 65535;
        if(s.equals("mag"))
            return 0xff00ff;
        if(s.equals("whi"))
            return 0xffffff;
        if(s.equals("bla"))
            return 0;
        if(s.equals("lre"))
            return 0xff9040;
        if(s.equals("dre"))
            return 0x800000;
        if(s.equals("dbl"))
            return 128;
        if(s.equals("or1"))
            return 0xffb000;
        if(s.equals("or2"))
            return 0xff7000;
        if(s.equals("or3"))
            return 0xff3000;
        if(s.equals("gr1"))
            return 0xc0ff00;
        if(s.equals("gr2"))
            return 0x80ff00;
        if(s.equals("gr3"))
            return 0x40ff00;
        if(s.equals("str"))
            aBoolean1499 = true;
        if(s.equals("end"))
            aBoolean1499 = false;
        return -1;
    }

    private void method392(byte abyte0[], int i, int j, int k, int l, int i1)
    {
        int j1 = i + j * Class30_Sub2_Sub1.anInt1379;
        int k1 = Class30_Sub2_Sub1.anInt1379 - k;
        int l1 = 0;
        int i2 = 0;
        if(j < Class30_Sub2_Sub1.anInt1381)
        {
            int j2 = Class30_Sub2_Sub1.anInt1381 - j;
            l -= j2;
            j = Class30_Sub2_Sub1.anInt1381;
            i2 += j2 * k;
            j1 += j2 * Class30_Sub2_Sub1.anInt1379;
        }
        if(j + l >= Class30_Sub2_Sub1.anInt1382)
            l -= ((j + l) - Class30_Sub2_Sub1.anInt1382) + 1;
        if(i < Class30_Sub2_Sub1.anInt1383)
        {
            int k2 = Class30_Sub2_Sub1.anInt1383 - i;
            k -= k2;
            i = Class30_Sub2_Sub1.anInt1383;
            i2 += k2;
            j1 += k2;
            l1 += k2;
            k1 += k2;
        }
        if(i + k >= Class30_Sub2_Sub1.anInt1384)
        {
            int l2 = ((i + k) - Class30_Sub2_Sub1.anInt1384) + 1;
            k -= l2;
            l1 += l2;
            k1 += l2;
        }
        if(k <= 0 || l <= 0)
        {
            return;
        } else
        {
            method393(Class30_Sub2_Sub1.anIntArray1378, abyte0, i1, i2, j1, k, l, k1, l1);
            return;
        }
    }

    private void method393(int ai[], byte abyte0[], int i, int j, int k, int l, int i1, 
            int j1, int k1)
    {
        int l1 = -(l >> 2);
        l = -(l & 3);
        for(int i2 = -i1; i2 < 0; i2++)
        {
            for(int j2 = l1; j2 < 0; j2++)
            {
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
            }

            for(int k2 = l; k2 < 0; k2++)
                if(abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;

            k += j1;
            j += k1;
        }

    }

    private void method394(int i, int j, byte abyte0[], int k, int l, int i1, boolean flag, 
            int j1)
    {
        int k1 = j + l * Class30_Sub2_Sub1.anInt1379;
        int l1 = Class30_Sub2_Sub1.anInt1379 - k;
        int i2 = 0;
        int j2 = 0;
        if(l < Class30_Sub2_Sub1.anInt1381)
        {
            int k2 = Class30_Sub2_Sub1.anInt1381 - l;
            i1 -= k2;
            l = Class30_Sub2_Sub1.anInt1381;
            j2 += k2 * k;
            k1 += k2 * Class30_Sub2_Sub1.anInt1379;
        }
        if(l + i1 >= Class30_Sub2_Sub1.anInt1382)
            i1 -= ((l + i1) - Class30_Sub2_Sub1.anInt1382) + 1;
        if(j < Class30_Sub2_Sub1.anInt1383)
        {
            int l2 = Class30_Sub2_Sub1.anInt1383 - j;
            k -= l2;
            j = Class30_Sub2_Sub1.anInt1383;
            j2 += l2;
            k1 += l2;
            i2 += l2;
            l1 += l2;
        }
        if(j + k >= Class30_Sub2_Sub1.anInt1384)
        {
            int i3 = ((j + k) - Class30_Sub2_Sub1.anInt1384) + 1;
            k -= i3;
            i2 += i3;
            l1 += i3;
        }
        if(k <= 0 || i1 <= 0)
            return;
        method395(abyte0, i1, k1, Class30_Sub2_Sub1.anIntArray1378, 520, j2, k, i2, l1, j1, i);
        if(flag)
        {
            for(int j3 = 1; j3 > 0; j3++);
        }
    }

    private void method395(byte abyte0[], int i, int j, int ai[], int k, int l, int i1, 
            int j1, int k1, int l1, int i2)
    {
        k = 98 / k;
        l1 = ((l1 & 0xff00ff) * i2 & 0xff00ff00) + ((l1 & 0xff00) * i2 & 0xff0000) >> 8;
        i2 = 256 - i2;
        for(int j2 = -i; j2 < 0; j2++)
        {
            for(int k2 = -i1; k2 < 0; k2++)
                if(abyte0[l++] != 0)
                {
                    int l2 = ai[j];
                    ai[j++] = (((l2 & 0xff00ff) * i2 & 0xff00ff00) + ((l2 & 0xff00) * i2 & 0xff0000) >> 8) + l1;
                } else
                {
                    j++;
                }

            j += k1;
            l += j1;
        }

    }

    private boolean aBoolean1484;
    private int anInt1485;
    private int anInt1486;
    private int anInt1487;
    private boolean aBoolean1488;
    private int anInt1489;
    private boolean aBoolean1490;
    byte aByteArrayArray1491[][];
    int anIntArray1492[];
    int anIntArray1493[];
    int anIntArray1494[];
    int anIntArray1495[];
    public int anIntArray1496[];
    public int anInt1497;
    Random aRandom1498;
    boolean aBoolean1499;
}
