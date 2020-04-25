// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public class Class29
{

    public final void method325(boolean flag, Class30_Sub2_Sub2 class30_sub2_sub2)
    {
        anInt540 = class30_sub2_sub2.method408();
        if(!flag)
        {
            throw new NullPointerException();
        } else
        {
            anInt538 = class30_sub2_sub2.method413();
            anInt539 = class30_sub2_sub2.method413();
            method326((byte)-112, class30_sub2_sub2);
            return;
        }
    }

    public final void method326(byte byte0, Class30_Sub2_Sub2 class30_sub2_sub2)
    {
        if(byte0 != aByte532)
            aBoolean533 = !aBoolean533;
        anInt535 = class30_sub2_sub2.method408();
        anIntArray536 = new int[anInt535];
        anIntArray537 = new int[anInt535];
        for(int i = 0; i < anInt535; i++)
        {
            anIntArray536[i] = class30_sub2_sub2.method410();
            anIntArray537[i] = class30_sub2_sub2.method410();
        }

    }

    final void method327(byte byte0)
    {
        anInt541 = 0;
        if(byte0 == 8)
            byte0 = 0;
        else
            aBoolean534 = !aBoolean534;
        anInt542 = 0;
        anInt543 = 0;
        anInt544 = 0;
        anInt545 = 0;
    }

    final int method328(boolean flag, int i)
    {
        if(!flag)
            aBoolean531 = !aBoolean531;
        if(anInt545 >= anInt541)
        {
            anInt544 = anIntArray537[anInt542++] << 15;
            if(anInt542 >= anInt535)
                anInt542 = anInt535 - 1;
            anInt541 = (int)(((double)anIntArray536[anInt542] / 65536D) * (double)i);
            if(anInt541 > anInt545)
                anInt543 = ((anIntArray537[anInt542] << 15) - anInt544) / (anInt541 - anInt545);
        }
        anInt544 += anInt543;
        anInt545++;
        return anInt544 - anInt543 >> 15;
    }

    public Class29()
    {
        aBoolean531 = false;
        aByte532 = -112;
        aBoolean533 = false;
        aBoolean534 = true;
    }

    private boolean aBoolean531;
    private byte aByte532;
    private boolean aBoolean533;
    private boolean aBoolean534;
    private int anInt535;
    private int anIntArray536[];
    private int anIntArray537[];
    int anInt538;
    int anInt539;
    int anInt540;
    private int anInt541;
    private int anInt542;
    private int anInt543;
    private int anInt544;
    private int anInt545;
    public static int anInt546;
}
