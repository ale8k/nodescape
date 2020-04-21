// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public final class Class12
{

    public Class12(boolean flag, int i)
    {
        aBoolean295 = false;
        aBoolean297 = false;
        aClass30_Sub2_300 = new Class30_Sub2();
        aClass2_304 = new Class2(anInt296);
        anInt301 = i;
        anInt302 = i;
        aClass1_303 = new Class1(-877, 1024);
        if(flag)
            anInt296 = -225;
    }

    public Class30_Sub2 method222(long l)
    {
        Class30_Sub2 class30_sub2 = (Class30_Sub2)aClass1_303.method148(l);
        if(class30_sub2 != null)
        {
            aClass2_304.method150(class30_sub2);
            anInt299++;
        } else
        {
            anInt298++;
        }
        return class30_sub2;
    }

    public void method223(Class30_Sub2 class30_sub2, long l, byte byte0)
    {
        try
        {
            if(byte0 != 2)
                aBoolean297 = !aBoolean297;
            if(anInt302 == 0)
            {
                Class30_Sub2 class30_sub2_1 = aClass2_304.method151();
                class30_sub2_1.method329();
                class30_sub2_1.method330();
                if(class30_sub2_1 == aClass30_Sub2_300)
                {
                    Class30_Sub2 class30_sub2_2 = aClass2_304.method151();
                    class30_sub2_2.method329();
                    class30_sub2_2.method330();
                }
            } else
            {
                anInt302--;
            }
            aClass1_303.method149(class30_sub2, l, (byte)7);
            aClass2_304.method150(class30_sub2);
            return;
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("47547, " + class30_sub2 + ", " + l + ", " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method224()
    {
        do
        {
            Class30_Sub2 class30_sub2 = aClass2_304.method151();
            if(class30_sub2 != null)
            {
                class30_sub2.method329();
                class30_sub2.method330();
            } else
            {
                anInt302 = anInt301;
                return;
            }
        } while(true);
    }

    private boolean aBoolean295;
    private static int anInt296;
    private boolean aBoolean297;
    private int anInt298;
    private int anInt299;
    private Class30_Sub2 aClass30_Sub2_300;
    private int anInt301;
    private int anInt302;
    private Class1 aClass1_303;
    private Class2 aClass2_304;
}
