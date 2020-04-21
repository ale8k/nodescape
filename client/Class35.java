// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public final class Class35
{

    public static String method525(int i, boolean flag, Class30_Sub2_Sub2 class30_sub2_sub2)
    {
        int j = 0;
        int k = -1;
        for(int l = 0; l < i; l++)
        {
            int i1 = class30_sub2_sub2.method408();
            int j1 = i1 >> 4 & 0xf;
            if(k == -1)
            {
                if(j1 < 13)
                    aCharArray631[j++] = aCharArray633[j1];
                else
                    k = j1;
            } else
            {
                aCharArray631[j++] = aCharArray633[((k << 4) + j1) - 195];
                k = -1;
            }
            j1 = i1 & 0xf;
            if(k == -1)
            {
                if(j1 < 13)
                    aCharArray631[j++] = aCharArray633[j1];
                else
                    k = j1;
            } else
            {
                aCharArray631[j++] = aCharArray633[((k << 4) + j1) - 195];
                k = -1;
            }
        }

        boolean flag1 = true;
        for(int k1 = 0; k1 < j; k1++)
        {
            char c = aCharArray631[k1];
            if(flag1 && c >= 'a' && c <= 'z')
            {
                aCharArray631[k1] += '\uFFE0';
                flag1 = false;
            }
            if(c == '.' || c == '!' || c == '?')
                flag1 = true;
        }

        if(!flag)
            anInt628 = 466;
        return new String(aCharArray631, 0, j);
    }

    public static void method526(String s, boolean flag, Class30_Sub2_Sub2 class30_sub2_sub2)
    {
        if(s.length() > 80)
            s = s.substring(0, 80);
        s = s.toLowerCase();
        int i = -1;
        for(int j = 0; j < s.length(); j++)
        {
            char c = s.charAt(j);
            int k = 0;
            for(int l = 0; l < aCharArray633.length; l++)
            {
                if(c != aCharArray633[l])
                    continue;
                k = l;
                break;
            }

            if(k > 12)
                k += 195;
            if(i == -1)
            {
                if(k < 13)
                    i = k;
                else
                    class30_sub2_sub2.method398(k);
            } else
            if(k < 13)
            {
                class30_sub2_sub2.method398((i << 4) + k);
                i = -1;
            } else
            {
                class30_sub2_sub2.method398((i << 4) + (k >> 4));
                i = k & 0xf;
            }
        }

        if(!flag)
            anInt628 = -452;
        if(i != -1)
            class30_sub2_sub2.method398(i << 4);
    }

    public static String method527(String s, int i)
    {
        aClass30_Sub2_Sub2_632.anInt1406 = 0;
        method526(s, aBoolean630, aClass30_Sub2_Sub2_632);
        int j = aClass30_Sub2_Sub2_632.anInt1406;
        aClass30_Sub2_Sub2_632.anInt1406 = 0;
        if(i != 0)
            aBoolean629 = !aBoolean629;
        String s1 = method525(j, true, aClass30_Sub2_Sub2_632);
        return s1;
    }

    private static int anInt628;
    private static boolean aBoolean629;
    private static boolean aBoolean630 = true;
    public static char aCharArray631[] = new char[100];
    private static Class30_Sub2_Sub2 aClass30_Sub2_Sub2_632 = new Class30_Sub2_Sub2(new byte[100], 891);
    private static char aCharArray633[] = {
        ' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 
        'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p', 
        'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', 
        '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', 
        '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', 
        '\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[', 
        ']'
    };

}
