// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public final class Class1
{

    public Class1(int i, int j)
    {
        aBoolean37 = false;
        anInt38 = -373;
        if(i >= 0)
            throw new NullPointerException();
        anInt39 = j;
        aClass30Array40 = new Class30[j];
        for(int k = 0; k < j; k++)
        {
            Class30 class30 = aClass30Array40[k] = new Class30();
            class30.aClass30_549 = class30;
            class30.aClass30_550 = class30;
        }

    }

    public Class30 method148(long l)
    {
        Class30 class30 = aClass30Array40[(int)(l & (long)(anInt39 - 1))];
        for(Class30 class30_1 = class30.aClass30_549; class30_1 != class30; class30_1 = class30_1.aClass30_549)
            if(class30_1.aLong548 == l)
                return class30_1;

        return null;
    }

    public void method149(Class30 class30, long l, byte byte0)
    {
        try
        {
            if(class30.aClass30_550 != null)
                class30.method329();
            Class30 class30_1 = aClass30Array40[(int)(l & (long)(anInt39 - 1))];
            if(byte0 != 7)
            {
                return;
            } else
            {
                class30.aClass30_550 = class30_1.aClass30_550;
                class30.aClass30_549 = class30_1;
                class30.aClass30_550.aClass30_549 = class30;
                class30.aClass30_549.aClass30_550 = class30;
                class30.aLong548 = l;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("91499, " + class30 + ", " + l + ", " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    private boolean aBoolean37;
    private int anInt38;
    private int anInt39;
    private Class30 aClass30Array40[];
}
