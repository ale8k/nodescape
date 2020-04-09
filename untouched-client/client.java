// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.zip.CRC32;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import sign.signlink;

public final class client extends Applet_Sub1
{

    private static final String method14(int i, int j)
    {
        String s = String.valueOf(i);
        for(int k = s.length() - 3; k > 0; k -= 3)
            s = s.substring(0, k) + "," + s.substring(k);

        if(j != 0)
            aBoolean1224 = !aBoolean1224;
        if(s.length() > 8)
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        else
        if(s.length() > 4)
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        return " " + s;
    }

    public final void method15(int i)
    {
        signlink.midifade = 0;
        signlink.midi = "stop";
        if(i <= 0)
            aBoolean1206 = !aBoolean1206;
    }

    public final void method16(int i)
    {
 /*       if(i <= 0)
            anInt1218 = aClass17_1000.method246();
        int j = 5;
        anIntArray1090[8] = 0;
        int k = 0;
        while(anIntArray1090[8] == 0) 
        {
            String s = "Unknown problem";
            method13(20, (byte)4, "Connecting to web server");
            try
            {
                DataInputStream datainputstream = method132("crc" + (int)(Math.random() * 99999999D) + "-" + 317);
                Class30_Sub2_Sub2 class30_sub2_sub2 = new Class30_Sub2_Sub2(new byte[40], 891);
                datainputstream.readFully(class30_sub2_sub2.aByteArray1405, 0, 40);
                datainputstream.close();
                for(int i1 = 0; i1 < 9; i1++)
                    anIntArray1090[i1] = class30_sub2_sub2.method413();

                int j1 = class30_sub2_sub2.method413();
                int k1 = 1234;
                for(int l1 = 0; l1 < 9; l1++)
                    k1 = (k1 << 1) + anIntArray1090[l1];

                if(j1 != k1)
                {
                    s = "checksum problem";
                    anIntArray1090[8] = 0;
                }
            }
            catch(EOFException _ex)
            {
                s = "EOF problem";
                anIntArray1090[8] = 0;
            }
            catch(IOException _ex)
            {
                s = "connection problem";
                anIntArray1090[8] = 0;
            }
            catch(Exception _ex)
            {
                s = "logic problem";
                anIntArray1090[8] = 0;
                if(!signlink.reporterror)
                    return;
            }
            if(anIntArray1090[8] == 0)
            {
                k++;
                for(int l = j; l > 0; l--)
                {
                    if(k >= 10)
                    {
                        method13(10, (byte)4, "Game updated - please reload page");
                        l = 10;
                    } else
                    {
                        method13(10, (byte)4, s + " - Will retry in " + l + " secs.");
                    }
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch(Exception _ex) { }
                }

                j *= 2;
                if(j > 60)
                    j = 60;
                aBoolean872 = !aBoolean872;
            }
        }
*/    
    }
    
    public final boolean method17(int i, int j)
    {
        if(j < 0)
            return false;
        int k = anIntArray1093[j];
        if(i != 9)
            opcode = -1;
        if(k >= 2000)
            k -= 2000;
        return k == 337;
    }

    public final void method18(int i)
    {
        aClass15_1166.method237(0);
        Class30_Sub2_Sub1_Sub3.anIntArray1472 = anIntArray1180;
        aClass30_Sub2_Sub1_Sub2_1198.method361(0, 16083, 0);
        if(aBoolean1256)
        {
            aClass30_Sub2_Sub1_Sub4_1272.method381(0, aString1121, 23693, 40, 239);
            aClass30_Sub2_Sub1_Sub4_1272.method381(128, aString1212 + "*", 23693, 60, 239);
        } else
        if(anInt1225 == 1)
        {
            aClass30_Sub2_Sub1_Sub4_1272.method381(0, "Enter amount:", 23693, 40, 239);
            aClass30_Sub2_Sub1_Sub4_1272.method381(128, aString1004 + "*", 23693, 60, 239);
        } else
        if(anInt1225 == 2)
        {
            aClass30_Sub2_Sub1_Sub4_1272.method381(0, "Enter name:", 23693, 40, 239);
            aClass30_Sub2_Sub1_Sub4_1272.method381(128, aString1004 + "*", 23693, 60, 239);
        } else
        if(aString844 != null)
        {
            aClass30_Sub2_Sub1_Sub4_1272.method381(0, aString844, 23693, 40, 239);
            aClass30_Sub2_Sub1_Sub4_1272.method381(128, "Click to continue", 23693, 60, 239);
        } else
        if(anInt1276 != -1)
            method105(8, 0, 0, Class9.aClass9Array210[anInt1276], 0);
        else
        if(anInt1042 != -1)
        {
            method105(8, 0, 0, Class9.aClass9Array210[anInt1042], 0);
        } else
        {
            Class30_Sub2_Sub1_Sub4 class30_sub2_sub1_sub4 = aClass30_Sub2_Sub1_Sub4_1271;
            int j = 0;
            Class30_Sub2_Sub1.method333(77, 0, false, 463, 0);
            for(int k = 0; k < 100; k++)
                if(aStringArray944[k] != null)
                {
                    int l = anIntArray942[k];
                    int i1 = (70 - j * 14) + anInt1089;
                    String s1 = aStringArray943[k];
                    byte byte0 = 0;
                    if(s1 != null && s1.startsWith("@cr1@"))
                    {
                        s1 = s1.substring(5);
                        byte0 = 1;
                    }
                    if(s1 != null && s1.startsWith("@cr2@"))
                    {
                        s1 = s1.substring(5);
                        byte0 = 2;
                    }
                    if(l == 0)
                    {
                        if(i1 > 0 && i1 < 110)
                            class30_sub2_sub1_sub4.method385(0, aStringArray944[k], i1, 822, 4);
                        j++;
                    }
                    if((l == 1 || l == 2) && (l == 1 || anInt1287 == 0 || anInt1287 == 1 && method109(false, s1)))
                    {
                        if(i1 > 0 && i1 < 110)
                        {
                            int j1 = 4;
                            if(byte0 == 1)
                            {
                                aClass30_Sub2_Sub1_Sub2Array1219[0].method361(j1, 16083, i1 - 12);
                                j1 += 14;
                            }
                            if(byte0 == 2)
                            {
                                aClass30_Sub2_Sub1_Sub2Array1219[1].method361(j1, 16083, i1 - 12);
                                j1 += 14;
                            }
                            class30_sub2_sub1_sub4.method385(0, s1 + ":", i1, 822, j1);
                            j1 += class30_sub2_sub1_sub4.method383(anInt1116, s1) + 8;
                            class30_sub2_sub1_sub4.method385(255, aStringArray944[k], i1, 822, j1);
                        }
                        j++;
                    }
                    if((l == 3 || l == 7) && anInt1195 == 0 && (l == 7 || anInt845 == 0 || anInt845 == 1 && method109(false, s1)))
                    {
                        if(i1 > 0 && i1 < 110)
                        {
                            int k1 = 4;
                            class30_sub2_sub1_sub4.method385(0, "From", i1, 822, k1);
                            k1 += class30_sub2_sub1_sub4.method383(anInt1116, "From ");
                            if(byte0 == 1)
                            {
                                aClass30_Sub2_Sub1_Sub2Array1219[0].method361(k1, 16083, i1 - 12);
                                k1 += 14;
                            }
                            if(byte0 == 2)
                            {
                                aClass30_Sub2_Sub1_Sub2Array1219[1].method361(k1, 16083, i1 - 12);
                                k1 += 14;
                            }
                            class30_sub2_sub1_sub4.method385(0, s1 + ":", i1, 822, k1);
                            k1 += class30_sub2_sub1_sub4.method383(anInt1116, s1) + 8;
                            class30_sub2_sub1_sub4.method385(0x800000, aStringArray944[k], i1, 822, k1);
                        }
                        j++;
                    }
                    if(l == 4 && (anInt1248 == 0 || anInt1248 == 1 && method109(false, s1)))
                    {
                        if(i1 > 0 && i1 < 110)
                            class30_sub2_sub1_sub4.method385(0x800080, s1 + " " + aStringArray944[k], i1, 822, 4);
                        j++;
                    }
                    if(l == 5 && anInt1195 == 0 && anInt845 < 2)
                    {
                        if(i1 > 0 && i1 < 110)
                            class30_sub2_sub1_sub4.method385(0x800000, aStringArray944[k], i1, 822, 4);
                        j++;
                    }
                    if(l == 6 && anInt1195 == 0 && anInt845 < 2)
                    {
                        if(i1 > 0 && i1 < 110)
                        {
                            class30_sub2_sub1_sub4.method385(0, "To " + s1 + ":", i1, 822, 4);
                            class30_sub2_sub1_sub4.method385(0x800000, aStringArray944[k], i1, 822, 12 + class30_sub2_sub1_sub4.method383(anInt1116, "To " + s1));
                        }
                        j++;
                    }
                    if(l == 8 && (anInt1248 == 0 || anInt1248 == 1 && method109(false, s1)))
                    {
                        if(i1 > 0 && i1 < 110)
                            class30_sub2_sub1_sub4.method385(0x7e3200, s1 + " " + aStringArray944[k], i1, 822, 4);
                        j++;
                    }
                }

            Class30_Sub2_Sub1.method332(4);
            anInt1211 = j * 14 + 7;
            if(anInt1211 < 78)
                anInt1211 = 78;
            method30(519, 77, anInt1211 - anInt1089 - 77, 0, 463, anInt1211);
            String s;
            if(aClass30_Sub2_Sub4_Sub1_Sub2_1126 != null && aClass30_Sub2_Sub4_Sub1_Sub2_1126.aString1703 != null)
                s = aClass30_Sub2_Sub4_Sub1_Sub2_1126.aString1703;
            else
                s = Class50.method587(-45804, aString1173);
            class30_sub2_sub1_sub4.method385(0, s + ":", 90, 822, 4);
            class30_sub2_sub1_sub4.method385(255, aString887 + "*", 90, 822, 6 + class30_sub2_sub1_sub4.method383(anInt1116, s + ": "));
            Class30_Sub2_Sub1.method339(77, 0, 479, 0, (byte)4);
        }
        if(aBoolean885 && anInt948 == 2)
            method40((byte)9);
        aClass15_1166.method238(357, 23680, super.aGraphics12, 17);
        aClass15_1165.method237(0);
        Class30_Sub2_Sub1_Sub3.anIntArray1472 = anIntArray1182;
        if(i < 6 || i > 6)
            aBoolean991 = !aBoolean991;
    }

    public final void init()
    {
        anInt957 = Integer.parseInt(getParameter("nodeid"));
        anInt958 = Integer.parseInt(getParameter("portoff"));
        String s = getParameter("lowmem");
        if(s != null && s.equals("1"))
            method138((byte)77);
        else
            method52(false);
        String s1 = getParameter("free");
        if(s1 != null && s1.equals("1"))
            aBoolean959 = false;
        else
            aBoolean959 = true;
        method2(503, false, 765);
    }

    public final void method12(Runnable runnable, int i)
    {
        if(i > 10)
            i = 10;
        if(signlink.mainapp != null)
        {
            signlink.startthread(runnable, i);
            return;
        } else
        {
            super.method12(runnable, i);
            return;
        }
    }

    public final Socket method19(int i)
        throws IOException
    {
        if(signlink.mainapp != null)
            return signlink.opensocket(i);
        else
            return new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
    }

    public final void method20(int i)
    {
        if(i != 4)
            opcode = aClass30_Sub2_Sub2_1083.method408();
        if(anInt1086 != 0)
            return;
        int j = super.anInt26;
        if(anInt1136 == 1 && super.anInt27 >= 516 && super.anInt28 >= 160 && super.anInt27 <= 765 && super.anInt28 <= 205)
            j = 0;
        if(aBoolean885)
        {
            if(j != 1)
            {
                int k = super.anInt20;
                int j1 = super.anInt21;
                if(anInt948 == 0)
                {
                    k -= 4;
                    j1 -= 4;
                }
                if(anInt948 == 1)
                {
                    k -= 553;
                    j1 -= 205;
                }
                if(anInt948 == 2)
                {
                    k -= 17;
                    j1 -= 357;
                }
                if(k < anInt949 - 10 || k > anInt949 + anInt951 + 10 || j1 < anInt950 - 10 || j1 > anInt950 + anInt952 + 10)
                {
                    aBoolean885 = false;
                    if(anInt948 == 1)
                        aBoolean1153 = true;
                    if(anInt948 == 2)
                        aBoolean1223 = true;
                }
            }
            if(j == 1)
            {
                int l = anInt949;
                int k1 = anInt950;
                int i2 = anInt951;
                int k2 = super.anInt27;
                int l2 = super.anInt28;
                if(anInt948 == 0)
                {
                    k2 -= 4;
                    l2 -= 4;
                }
                if(anInt948 == 1)
                {
                    k2 -= 553;
                    l2 -= 205;
                }
                if(anInt948 == 2)
                {
                    k2 -= 17;
                    l2 -= 357;
                }
                int i3 = -1;
                for(int j3 = 0; j3 < anInt1133; j3++)
                {
                    int k3 = k1 + 31 + (anInt1133 - 1 - j3) * 15;
                    if(k2 > l && k2 < l + i2 && l2 > k3 - 13 && l2 < k3 + 3)
                        i3 = j3;
                }

                if(i3 != -1)
                    method69(i3, false);
                aBoolean885 = false;
                if(anInt948 == 1)
                    aBoolean1153 = true;
                if(anInt948 == 2)
                {
                    aBoolean1223 = true;
                    return;
                }
            }
        } else
        {
            if(j == 1 && anInt1133 > 0)
            {
                int i1 = anIntArray1093[anInt1133 - 1];
                if(i1 == 632 || i1 == 78 || i1 == 867 || i1 == 431 || i1 == 53 || i1 == 74 || i1 == 454 || i1 == 539 || i1 == 493 || i1 == 847 || i1 == 447 || i1 == 1125)
                {
                    int l1 = anIntArray1091[anInt1133 - 1];
                    int j2 = anIntArray1092[anInt1133 - 1];
                    Class9 class9 = Class9.aClass9Array210[j2];
                    if(class9.aBoolean259 || class9.aBoolean235)
                    {
                        aBoolean1242 = false;
                        anInt989 = 0;
                        anInt1084 = j2;
                        anInt1085 = l1;
                        anInt1086 = 2;
                        anInt1087 = super.anInt27;
                        anInt1088 = super.anInt28;
                        if(Class9.aClass9Array210[j2].anInt236 == anInt857)
                            anInt1086 = 1;
                        if(Class9.aClass9Array210[j2].anInt236 == anInt1276)
                            anInt1086 = 3;
                        return;
                    }
                }
            }
            if(j == 1 && (anInt1253 == 1 || method17(9, anInt1133 - 1)) && anInt1133 > 2)
                j = 2;
            if(j == 1 && anInt1133 > 0)
                method69(anInt1133 - 1, false);
            if(j == 2 && anInt1133 > 0)
                method116(true);
        }
    }

    public final void method21(boolean flag, int i, byte abyte0[])
    {
        signlink.midifade = flag ? 1 : 0;
        signlink.midisave(abyte0, abyte0.length);
        if(i != 0)
            opcode = aClass30_Sub2_Sub2_1083.method408();
    }

    public final void method22(boolean flag)
    {
        try
        {
            anInt985 = -1;
            aClass19_1056.method256();
            aClass19_1013.method256();
            Class30_Sub2_Sub1_Sub3.method366(anInt846);
            method23(false);
            aClass25_946.method274(619);
            System.gc();
            for(int i = 0; i < 4; i++)
                aClass11Array1230[i].method210();

            for(int l = 0; l < 4; l++)
            {
                for(int k1 = 0; k1 < 104; k1++)
                {
                    for(int j2 = 0; j2 < 104; j2++)
                        aByteArrayArrayArray1258[l][k1][j2] = 0;

                }

            }

            Class7 class7 = new Class7(aByteArrayArrayArray1258, -60, 104, 104, anIntArrayArrayArray1214);
            int k2 = aByteArrayArray1183.length;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 0);
            if(!aBoolean1159)
            {
                for(int i3 = 0; i3 < k2; i3++)
                {
                    int i4 = (anIntArray1234[i3] >> 8) * 64 - anInt1034;
                    int k5 = (anIntArray1234[i3] & 0xff) * 64 - anInt1035;
                    byte abyte0[] = aByteArrayArray1183[i3];
                    if(abyte0 != null)
                        class7.method180(abyte0, k5, i4, (anInt1069 - 6) * 8, (anInt1070 - 6) * 8, (byte)4, aClass11Array1230);
                }

                for(int j4 = 0; j4 < k2; j4++)
                {
                    int l5 = (anIntArray1234[j4] >> 8) * 64 - anInt1034;
                    int k7 = (anIntArray1234[j4] & 0xff) * 64 - anInt1035;
                    byte abyte2[] = aByteArrayArray1183[j4];
                    if(abyte2 == null && anInt1070 < 800)
                        class7.method174(k7, 64, 0, 64, l5);
                }

                anInt1097++;
                if(anInt1097 > 160)
                {
                    anInt1097 = 0;
                    aClass30_Sub2_Sub2_1192.method397((byte)6, 238);
                    aClass30_Sub2_Sub2_1192.method398(96);
                }
                aClass30_Sub2_Sub2_1192.method397((byte)6, 0);
                for(int i6 = 0; i6 < k2; i6++)
                {
                    byte abyte1[] = aByteArrayArray1247[i6];
                    if(abyte1 != null)
                    {
                        int l8 = (anIntArray1234[i6] >> 8) * 64 - anInt1034;
                        int k9 = (anIntArray1234[i6] & 0xff) * 64 - anInt1035;
                        class7.method190(l8, aClass11Array1230, k9, 7, aClass25_946, abyte1);
                    }
                }

            }
            if(aBoolean1159)
            {
                for(int j3 = 0; j3 < 4; j3++)
                {
                    for(int k4 = 0; k4 < 13; k4++)
                    {
                        for(int j6 = 0; j6 < 13; j6++)
                        {
                            int l7 = anIntArrayArrayArray1129[j3][k4][j6];
                            if(l7 != -1)
                            {
                                int i9 = l7 >> 24 & 3;
                                int l9 = l7 >> 1 & 3;
                                int j10 = l7 >> 14 & 0x3ff;
                                int l10 = l7 >> 3 & 0x7ff;
                                int j11 = (j10 / 8 << 8) + l10 / 8;
                                for(int l11 = 0; l11 < anIntArray1234.length; l11++)
                                {
                                    if(anIntArray1234[l11] != j11 || aByteArrayArray1183[l11] == null)
                                        continue;
                                    class7.method179(i9, l9, aClass11Array1230, 9, k4 * 8, (j10 & 7) * 8, aByteArrayArray1183[l11], (l10 & 7) * 8, j3, j6 * 8);
                                    break;
                                }

                            }
                        }

                    }

                }

                for(int l4 = 0; l4 < 13; l4++)
                {
                    for(int k6 = 0; k6 < 13; k6++)
                    {
                        int i8 = anIntArrayArrayArray1129[0][l4][k6];
                        if(i8 == -1)
                            class7.method174(k6 * 8, 8, 0, 8, l4 * 8);
                    }

                }

                aClass30_Sub2_Sub2_1192.method397((byte)6, 0);
                for(int l6 = 0; l6 < 4; l6++)
                {
                    for(int j8 = 0; j8 < 13; j8++)
                    {
                        for(int j9 = 0; j9 < 13; j9++)
                        {
                            int i10 = anIntArrayArrayArray1129[l6][j8][j9];
                            if(i10 != -1)
                            {
                                int k10 = i10 >> 24 & 3;
                                int i11 = i10 >> 1 & 3;
                                int k11 = i10 >> 14 & 0x3ff;
                                int i12 = i10 >> 3 & 0x7ff;
                                int j12 = (k11 / 8 << 8) + i12 / 8;
                                for(int k12 = 0; k12 < anIntArray1234.length; k12++)
                                {
                                    if(anIntArray1234[k12] != j12 || aByteArrayArray1247[k12] == null)
                                        continue;
                                    class7.method183(aClass11Array1230, aClass25_946, k10, j8 * 8, (i12 & 7) * 8, true, l6, aByteArrayArray1247[k12], (k11 & 7) * 8, i11, j9 * 8);
                                    break;
                                }

                            }
                        }

                    }

                }

            }
            aClass30_Sub2_Sub2_1192.method397((byte)6, 0);
            class7.method171(aClass11Array1230, aClass25_946, 2);
            aClass15_1165.method237(0);
            aClass30_Sub2_Sub2_1192.method397((byte)6, 0);
            int k3 = Class7.anInt145;
            if(k3 > anInt918)
                k3 = anInt918;
            if(k3 < anInt918 - 1)
                k3 = anInt918 - 1;
            if(aBoolean960)
                aClass25_946.method275(Class7.anInt145, -34686);
            else
                aClass25_946.method275(0, -34686);
            for(int i5 = 0; i5 < 104; i5++)
            {
                for(int i7 = 0; i7 < 104; i7++)
                    method25(i5, i7);

            }

            anInt1051++;
            if(anInt1051 > 98)
            {
                anInt1051 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 150);
            }
            method63(-919);
        }
        catch(Exception exception) { }
        Class46.aClass12_785.method224();
        aBoolean1157 &= flag;
        if(super.aFrame_Sub1_15 != null)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 210);
            aClass30_Sub2_Sub2_1192.method402(0x3f008edd);
        }
        if(aBoolean960 && signlink.cache_dat != null)
        {
            int j = aClass42_Sub1_1068.method555(79, 0);
            for(int i1 = 0; i1 < j; i1++)
            {
                int l1 = aClass42_Sub1_1068.method559(i1, -203);
                if((l1 & 0x79) == 0)
                    Class30_Sub2_Sub4_Sub6.method461(116, i1);
            }

        }
        System.gc();
        Class30_Sub2_Sub1_Sub3.method367(20, true);
        aClass42_Sub1_1068.method566(0);
        int k = (anInt1069 - 6) / 8 - 1;
        int j1 = (anInt1069 + 6) / 8 + 1;
        int i2 = (anInt1070 - 6) / 8 - 1;
        int l2 = (anInt1070 + 6) / 8 + 1;
        if(aBoolean1141)
        {
            k = 49;
            j1 = 50;
            i2 = 49;
            l2 = 50;
        }
        for(int l3 = k; l3 <= j1; l3++)
        {
            for(int j5 = i2; j5 <= l2; j5++)
                if(l3 == k || l3 == j1 || j5 == i2 || j5 == l2)
                {
                    int j7 = aClass42_Sub1_1068.method562(0, 0, j5, l3);
                    if(j7 != -1)
                        aClass42_Sub1_1068.method560(j7, 3, false);
                    int k8 = aClass42_Sub1_1068.method562(1, 0, j5, l3);
                    if(k8 != -1)
                        aClass42_Sub1_1068.method560(k8, 3, false);
                }

        }

    }

    public final void method23(boolean flag)
    {
        Class46.aClass12_785.method224();
        Class46.aClass12_780.method224();
        Class5.aClass12_95.method224();
        Class8.aClass12_159.method224();
        Class8.aClass12_158.method224();
        if(flag)
            opcode = -1;
        Class30_Sub2_Sub4_Sub1_Sub2.aClass12_1704.method224();
        Class23.aClass12_415.method224();
    }

    public final void method24(boolean flag, int i)
    {
        int ai[] = aClass30_Sub2_Sub1_Sub1_1263.anIntArray1439;
        int j = ai.length;
        for(int k = 0; k < j; k++)
            ai[k] = 0;

        for(int l = 1; l < 103; l++)
        {
            int i1 = 24628 + (103 - l) * 512 * 4;
            for(int k1 = 1; k1 < 103; k1++)
            {
                if((aByteArrayArrayArray1258[i][k1][l] & 0x18) == 0)
                    aClass25_946.method309(ai, i1, 512, i, k1, l);
                if(i < 3 && (aByteArrayArrayArray1258[i + 1][k1][l] & 8) != 0)
                    aClass25_946.method309(ai, i1, 512, i + 1, k1, l);
                i1 += 4;
            }

        }

        int j1 = ((238 + (int)(Math.random() * 20D)) - 10 << 16) + ((238 + (int)(Math.random() * 20D)) - 10 << 8) + ((238 + (int)(Math.random() * 20D)) - 10);
        int l1 = (238 + (int)(Math.random() * 20D)) - 10 << 16;
        aClass30_Sub2_Sub1_Sub1_1263.method343(0);
        for(int i2 = 1; i2 < 103; i2++)
        {
            for(int j2 = 1; j2 < 103; j2++)
            {
                if((aByteArrayArrayArray1258[i][j2][i2] & 0x18) == 0)
                    method50(i2, -960, j1, j2, l1, i);
                if(i < 3 && (aByteArrayArrayArray1258[i + 1][j2][i2] & 8) != 0)
                    method50(i2, -960, j1, j2, l1, i + 1);
            }

        }

        aClass15_1165.method237(0);
        aBoolean1157 &= flag;
        anInt1071 = 0;
        for(int k2 = 0; k2 < 104; k2++)
        {
            for(int l2 = 0; l2 < 104; l2++)
            {
                int i3 = aClass25_946.method303(anInt918, k2, l2);
                if(i3 != 0)
                {
                    i3 = i3 >> 14 & 0x7fff;
                    int j3 = Class46.method572(i3).anInt746;
                    if(j3 >= 0)
                    {
                        int k3 = k2;
                        int l3 = l2;
                        if(j3 != 22 && j3 != 29 && j3 != 34 && j3 != 36 && j3 != 46 && j3 != 47 && j3 != 48)
                        {
                            byte byte0 = 104;
                            byte byte1 = 104;
                            int ai1[][] = aClass11Array1230[anInt918].anIntArrayArray294;
                            for(int i4 = 0; i4 < 10; i4++)
                            {
                                int j4 = (int)(Math.random() * 4D);
                                if(j4 == 0 && k3 > 0 && k3 > k2 - 3 && (ai1[k3 - 1][l3] & 0x1280108) == 0)
                                    k3--;
                                if(j4 == 1 && k3 < byte0 - 1 && k3 < k2 + 3 && (ai1[k3 + 1][l3] & 0x1280180) == 0)
                                    k3++;
                                if(j4 == 2 && l3 > 0 && l3 > l2 - 3 && (ai1[k3][l3 - 1] & 0x1280102) == 0)
                                    l3--;
                                if(j4 == 3 && l3 < byte1 - 1 && l3 < l2 + 3 && (ai1[k3][l3 + 1] & 0x1280120) == 0)
                                    l3++;
                            }

                        }
                        aClass30_Sub2_Sub1_Sub1Array1140[anInt1071] = aClass30_Sub2_Sub1_Sub1Array1033[j3];
                        anIntArray1072[anInt1071] = k3;
                        anIntArray1073[anInt1071] = l3;
                        anInt1071++;
                    }
                }
            }

        }

    }

    public final void method25(int i, int j)
    {
        Class19 class19 = aClass19ArrayArrayArray827[anInt918][i][j];
        if(class19 == null)
        {
            aClass25_946.method295(anInt918, i, j);
            return;
        }
        int k = 0xfa0a1f01;
        Object obj = null;
        for(Class30_Sub2_Sub4_Sub2 class30_sub2_sub4_sub2 = (Class30_Sub2_Sub4_Sub2)class19.method252(); class30_sub2_sub4_sub2 != null; class30_sub2_sub4_sub2 = (Class30_Sub2_Sub4_Sub2)class19.method254(false))
        {
            Class8 class8 = Class8.method198(class30_sub2_sub4_sub2.anInt1558);
            int l = class8.anInt155;
            if(class8.aBoolean176)
                l *= class30_sub2_sub4_sub2.anInt1559 + 1;
            if(l > k)
            {
                k = l;
                obj = class30_sub2_sub4_sub2;
            }
        }

        class19.method250(-493, ((Class30) (obj)));
        Object obj1 = null;
        Object obj2 = null;
        for(Class30_Sub2_Sub4_Sub2 class30_sub2_sub4_sub2_1 = (Class30_Sub2_Sub4_Sub2)class19.method252(); class30_sub2_sub4_sub2_1 != null; class30_sub2_sub4_sub2_1 = (Class30_Sub2_Sub4_Sub2)class19.method254(false))
        {
            if(class30_sub2_sub4_sub2_1.anInt1558 != ((Class30_Sub2_Sub4_Sub2) (obj)).anInt1558 && obj1 == null)
                obj1 = class30_sub2_sub4_sub2_1;
            if(class30_sub2_sub4_sub2_1.anInt1558 != ((Class30_Sub2_Sub4_Sub2) (obj)).anInt1558 && class30_sub2_sub4_sub2_1.anInt1558 != ((Class30_Sub2_Sub4_Sub2) (obj1)).anInt1558 && obj2 == null)
                obj2 = class30_sub2_sub4_sub2_1;
        }

        int i1 = i + (j << 7) + 0x60000000;
        aClass25_946.method281((byte)7, i, i1, ((Class30_Sub2_Sub4) (obj1)), method42(anInt918, j * 128 + 64, true, i * 128 + 64), ((Class30_Sub2_Sub4) (obj2)), ((Class30_Sub2_Sub4) (obj)), anInt918, j);
    }

    public final void method26(boolean flag, int i)
    {
        for(int j = 0; j < anInt836; j++)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[anIntArray837[j]];
            int k = 0x20000000 + (anIntArray837[j] << 14);
            if(class30_sub2_sub4_sub1_sub1 == null || !class30_sub2_sub4_sub1_sub1.method449(aBoolean1224) || class30_sub2_sub4_sub1_sub1.aClass5_1696.aBoolean93 != flag)
                continue;
            int l = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550 >> 7;
            int i1 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551 >> 7;
            if(l < 0 || l >= 104 || i1 < 0 || i1 >= 104)
                continue;
            if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1540 == 1 && (((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550 & 0x7f) == 64 && (((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551 & 0x7f) == 64)
            {
                if(anIntArrayArray929[l][i1] == anInt1265)
                    continue;
                anIntArrayArray929[l][i1] = anInt1265;
            }
            if(!class30_sub2_sub4_sub1_sub1.aClass5_1696.aBoolean84)
                k += 0x80000000;
            aClass25_946.method285(anInt918, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1552, (byte)6, method42(anInt918, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551, true, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550), k, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551, (((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1540 - 1) * 64 + 60, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550, class30_sub2_sub4_sub1_sub1, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).aBoolean1541);
        }

        if(i == -30815);
    }

    public final boolean method27(int i)
    {
        if(i != 11456)
            throw new NullPointerException();
        else
            return signlink.wavereplay();
    }

    private final void method28(String s)
    {
        System.out.println(s);
        try
        {
            getAppletContext().showDocument(new URL(getCodeBase(), "loaderror_" + s + ".html"));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        do
            try
            {
                Thread.sleep(1000L);
            }
            catch(Exception _ex) { }
        while(true);
    }

    public final void method29(int i, int j, Class9 class9, int k, int l, int i1, int j1)
    {
        if(class9.anInt262 != 0 || class9.anIntArray240 == null || class9.aBoolean266)
            return;
        if(k < i || i1 < l || k > i + class9.anInt220 || i1 > l + class9.anInt267)
            return;
        int k1 = class9.anIntArray240.length;
        if(j != 13037)
            aClass19ArrayArrayArray827 = null;
        for(int l1 = 0; l1 < k1; l1++)
        {
            int i2 = class9.anIntArray241[l1] + i;
            int j2 = (class9.anIntArray272[l1] + l) - j1;
            Class9 class9_1 = Class9.aClass9Array210[class9.anIntArray240[l1]];
            i2 += class9_1.anInt263;
            j2 += class9_1.anInt265;
            if((class9_1.anInt230 >= 0 || class9_1.anInt216 != 0) && k >= i2 && i1 >= j2 && k < i2 + class9_1.anInt220 && i1 < j2 + class9_1.anInt267)
                if(class9_1.anInt230 >= 0)
                    anInt886 = class9_1.anInt230;
                else
                    anInt886 = class9_1.anInt250;
            if(class9_1.anInt262 == 0)
            {
                method29(i2, 13037, class9_1, k, j2, i1, class9_1.anInt224);
                if(class9_1.anInt261 > class9_1.anInt267)
                    method65(i2 + class9_1.anInt220, class9_1.anInt267, k, i1, class9_1, j2, true, class9_1.anInt261, 0);
            } else
            {
                if(class9_1.anInt217 == 1 && k >= i2 && i1 >= j2 && k < i2 + class9_1.anInt220 && i1 < j2 + class9_1.anInt267)
                {
                    boolean flag = false;
                    if(class9_1.anInt214 != 0)
                        flag = method103(class9_1, false);
                    if(!flag)
                    {
                        aStringArray1199[anInt1133] = class9_1.aString221;
                        anIntArray1093[anInt1133] = 315;
                        anIntArray1092[anInt1133] = class9_1.anInt250;
                        anInt1133++;
                    }
                }
                if(class9_1.anInt217 == 2 && anInt1136 == 0 && k >= i2 && i1 >= j2 && k < i2 + class9_1.anInt220 && i1 < j2 + class9_1.anInt267)
                {
                    String s = class9_1.aString222;
                    if(s.indexOf(" ") != -1)
                        s = s.substring(0, s.indexOf(" "));
                    aStringArray1199[anInt1133] = s + " @gre@" + class9_1.aString218;
                    anIntArray1093[anInt1133] = 626;
                    anIntArray1092[anInt1133] = class9_1.anInt250;
                    anInt1133++;
                }
                if(class9_1.anInt217 == 3 && k >= i2 && i1 >= j2 && k < i2 + class9_1.anInt220 && i1 < j2 + class9_1.anInt267)
                {
                    aStringArray1199[anInt1133] = "Close";
                    anIntArray1093[anInt1133] = 200;
                    anIntArray1092[anInt1133] = class9_1.anInt250;
                    anInt1133++;
                }
                if(class9_1.anInt217 == 4 && k >= i2 && i1 >= j2 && k < i2 + class9_1.anInt220 && i1 < j2 + class9_1.anInt267)
                {
                    aStringArray1199[anInt1133] = class9_1.aString221;
                    anIntArray1093[anInt1133] = 169;
                    anIntArray1092[anInt1133] = class9_1.anInt250;
                    anInt1133++;
                }
                if(class9_1.anInt217 == 5 && k >= i2 && i1 >= j2 && k < i2 + class9_1.anInt220 && i1 < j2 + class9_1.anInt267)
                {
                    aStringArray1199[anInt1133] = class9_1.aString221;
                    anIntArray1093[anInt1133] = 646;
                    anIntArray1092[anInt1133] = class9_1.anInt250;
                    anInt1133++;
                }
                if(class9_1.anInt217 == 6 && !aBoolean1149 && k >= i2 && i1 >= j2 && k < i2 + class9_1.anInt220 && i1 < j2 + class9_1.anInt267)
                {
                    aStringArray1199[anInt1133] = class9_1.aString221;
                    anIntArray1093[anInt1133] = 679;
                    anIntArray1092[anInt1133] = class9_1.anInt250;
                    anInt1133++;
                }
                if(class9_1.anInt262 == 2)
                {
                    int k2 = 0;
                    for(int l2 = 0; l2 < class9_1.anInt267; l2++)
                    {
                        for(int i3 = 0; i3 < class9_1.anInt220; i3++)
                        {
                            int j3 = i2 + i3 * (32 + class9_1.anInt231);
                            int k3 = j2 + l2 * (32 + class9_1.anInt244);
                            if(k2 < 20)
                            {
                                j3 += class9_1.anIntArray215[k2];
                                k3 += class9_1.anIntArray247[k2];
                            }
                            if(k >= j3 && i1 >= k3 && k < j3 + 32 && i1 < k3 + 32)
                            {
                                anInt1066 = k2;
                                anInt1067 = class9_1.anInt250;
                                if(class9_1.anIntArray253[k2] > 0)
                                {
                                    Class8 class8 = Class8.method198(class9_1.anIntArray253[k2] - 1);
                                    if(anInt1282 == 1 && class9_1.aBoolean249)
                                    {
                                        if(class9_1.anInt250 != anInt1284 || k2 != anInt1283)
                                        {
                                            aStringArray1199[anInt1133] = "Use " + aString1286 + " with @lre@" + class8.aString170;
                                            anIntArray1093[anInt1133] = 870;
                                            anIntArray1094[anInt1133] = class8.anInt157;
                                            anIntArray1091[anInt1133] = k2;
                                            anIntArray1092[anInt1133] = class9_1.anInt250;
                                            anInt1133++;
                                        }
                                    } else
                                    if(anInt1136 == 1 && class9_1.aBoolean249)
                                    {
                                        if((anInt1138 & 0x10) == 16)
                                        {
                                            aStringArray1199[anInt1133] = aString1139 + " @lre@" + class8.aString170;
                                            anIntArray1093[anInt1133] = 543;
                                            anIntArray1094[anInt1133] = class8.anInt157;
                                            anIntArray1091[anInt1133] = k2;
                                            anIntArray1092[anInt1133] = class9_1.anInt250;
                                            anInt1133++;
                                        }
                                    } else
                                    {
                                        if(class9_1.aBoolean249)
                                        {
                                            for(int l3 = 4; l3 >= 3; l3--)
                                                if(class8.aStringArray189 != null && class8.aStringArray189[l3] != null)
                                                {
                                                    aStringArray1199[anInt1133] = class8.aStringArray189[l3] + " @lre@" + class8.aString170;
                                                    if(l3 == 3)
                                                        anIntArray1093[anInt1133] = 493;
                                                    if(l3 == 4)
                                                        anIntArray1093[anInt1133] = 847;
                                                    anIntArray1094[anInt1133] = class8.anInt157;
                                                    anIntArray1091[anInt1133] = k2;
                                                    anIntArray1092[anInt1133] = class9_1.anInt250;
                                                    anInt1133++;
                                                } else
                                                if(l3 == 4)
                                                {
                                                    aStringArray1199[anInt1133] = "Drop @lre@" + class8.aString170;
                                                    anIntArray1093[anInt1133] = 847;
                                                    anIntArray1094[anInt1133] = class8.anInt157;
                                                    anIntArray1091[anInt1133] = k2;
                                                    anIntArray1092[anInt1133] = class9_1.anInt250;
                                                    anInt1133++;
                                                }

                                        }
                                        if(class9_1.aBoolean242)
                                        {
                                            aStringArray1199[anInt1133] = "Use @lre@" + class8.aString170;
                                            anIntArray1093[anInt1133] = 447;
                                            anIntArray1094[anInt1133] = class8.anInt157;
                                            anIntArray1091[anInt1133] = k2;
                                            anIntArray1092[anInt1133] = class9_1.anInt250;
                                            anInt1133++;
                                        }
                                        if(class9_1.aBoolean249 && class8.aStringArray189 != null)
                                        {
                                            for(int i4 = 2; i4 >= 0; i4--)
                                                if(class8.aStringArray189[i4] != null)
                                                {
                                                    aStringArray1199[anInt1133] = class8.aStringArray189[i4] + " @lre@" + class8.aString170;
                                                    if(i4 == 0)
                                                        anIntArray1093[anInt1133] = 74;
                                                    if(i4 == 1)
                                                        anIntArray1093[anInt1133] = 454;
                                                    if(i4 == 2)
                                                        anIntArray1093[anInt1133] = 539;
                                                    anIntArray1094[anInt1133] = class8.anInt157;
                                                    anIntArray1091[anInt1133] = k2;
                                                    anIntArray1092[anInt1133] = class9_1.anInt250;
                                                    anInt1133++;
                                                }

                                        }
                                        if(class9_1.aStringArray225 != null)
                                        {
                                            for(int j4 = 4; j4 >= 0; j4--)
                                                if(class9_1.aStringArray225[j4] != null)
                                                {
                                                    aStringArray1199[anInt1133] = class9_1.aStringArray225[j4] + " @lre@" + class8.aString170;
                                                    if(j4 == 0)
                                                        anIntArray1093[anInt1133] = 632;
                                                    if(j4 == 1)
                                                        anIntArray1093[anInt1133] = 78;
                                                    if(j4 == 2)
                                                        anIntArray1093[anInt1133] = 867;
                                                    if(j4 == 3)
                                                        anIntArray1093[anInt1133] = 431;
                                                    if(j4 == 4)
                                                        anIntArray1093[anInt1133] = 53;
                                                    anIntArray1094[anInt1133] = class8.anInt157;
                                                    anIntArray1091[anInt1133] = k2;
                                                    anIntArray1092[anInt1133] = class9_1.anInt250;
                                                    anInt1133++;
                                                }

                                        }
                                        aStringArray1199[anInt1133] = "Examine @lre@" + class8.aString170;
                                        anIntArray1093[anInt1133] = 1125;
                                        anIntArray1094[anInt1133] = class8.anInt157;
                                        anIntArray1091[anInt1133] = k2;
                                        anIntArray1092[anInt1133] = class9_1.anInt250;
                                        anInt1133++;
                                    }
                                }
                            }
                            k2++;
                        }

                    }

                }
            }
        }

    }

    public final void method30(int i, int j, int k, int l, int i1, int j1)
    {
        aClass30_Sub2_Sub1_Sub2_1024.method361(i1, 16083, l);
        aClass30_Sub2_Sub1_Sub2_1025.method361(i1, 16083, (l + j) - 16);
        Class30_Sub2_Sub1.method336(j - 32, l + 16, i1, anInt1002, 16, 0);
        int k1 = ((j - 32) * j) / j1;
        if(k1 < 8)
            k1 = 8;
        int l1 = ((j - 32 - k1) * k) / (j1 - j);
        Class30_Sub2_Sub1.method336(k1, l + 16 + l1, i1, anInt1063, 16, 0);
        Class30_Sub2_Sub1.method341(l + 16 + l1, anInt902, k1, i1, anInt1135);
        Class30_Sub2_Sub1.method341(l + 16 + l1, anInt902, k1, i1 + 1, anInt1135);
        Class30_Sub2_Sub1.method339(l + 16 + l1, anInt902, 16, i1, (byte)4);
        Class30_Sub2_Sub1.method339(l + 17 + l1, anInt902, 16, i1, (byte)4);
        if(i <= 0)
            anInt1105 = aClass17_1000.method246();
        Class30_Sub2_Sub1.method341(l + 16 + l1, anInt927, k1, i1 + 15, anInt1135);
        Class30_Sub2_Sub1.method341(l + 17 + l1, anInt927, k1 - 1, i1 + 14, anInt1135);
        Class30_Sub2_Sub1.method339(l + 15 + l1 + k1, anInt927, 16, i1, (byte)4);
        Class30_Sub2_Sub1.method339(l + 14 + l1 + k1, anInt927, 15, i1 + 1, (byte)4);
    }

    private final void method31(Class30_Sub2_Sub2 class30_sub2_sub2, int i, int j)
    {
        anInt839 = 0;
        anInt893 = 0;
        if(j <= 0)
            anInt877 = aClass17_1000.method246();
        method139(class30_sub2_sub2, -45, i);
        method46(i, class30_sub2_sub2, (byte)2);
        method86(i, class30_sub2_sub2, true);
        for(int k = 0; k < anInt839; k++)
        {
            int l = anIntArray840[k];
            if(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub1Array835[l])).anInt1537 != anInt1161)
            {
                aClass30_Sub2_Sub4_Sub1_Sub1Array835[l].aClass5_1696 = null;
                aClass30_Sub2_Sub4_Sub1_Sub1Array835[l] = null;
            }
        }

        if(class30_sub2_sub2.anInt1406 != i)
        {
            signlink.reporterror(aString1173 + " size mismatch in getnpcpos - pos:" + class30_sub2_sub2.anInt1406 + " psize:" + i);
            throw new RuntimeException("eek");
        }
        for(int i1 = 0; i1 < anInt836; i1++)
            if(aClass30_Sub2_Sub4_Sub1_Sub1Array835[anIntArray837[i1]] == null)
            {
                signlink.reporterror(aString1173 + " null entry in npc list - pos:" + i1 + " size:" + anInt836);
                throw new RuntimeException("eek");
            }

    }

    public final void method32(boolean flag)
    {
        aBoolean1157 &= flag;
        if(super.anInt26 == 1)
        {
            if(super.anInt27 >= 6 && super.anInt27 <= 106 && super.anInt28 >= 467 && super.anInt28 <= 499)
            {
                anInt1287 = (anInt1287 + 1) % 4;
                aBoolean1233 = true;
                aBoolean1223 = true;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 95);
                aClass30_Sub2_Sub2_1192.method398(anInt1287);
                aClass30_Sub2_Sub2_1192.method398(anInt845);
                aClass30_Sub2_Sub2_1192.method398(anInt1248);
            }
            if(super.anInt27 >= 135 && super.anInt27 <= 235 && super.anInt28 >= 467 && super.anInt28 <= 499)
            {
                anInt845 = (anInt845 + 1) % 3;
                aBoolean1233 = true;
                aBoolean1223 = true;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 95);
                aClass30_Sub2_Sub2_1192.method398(anInt1287);
                aClass30_Sub2_Sub2_1192.method398(anInt845);
                aClass30_Sub2_Sub2_1192.method398(anInt1248);
            }
            if(super.anInt27 >= 273 && super.anInt27 <= 373 && super.anInt28 >= 467 && super.anInt28 <= 499)
            {
                anInt1248 = (anInt1248 + 1) % 3;
                aBoolean1233 = true;
                aBoolean1223 = true;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 95);
                aClass30_Sub2_Sub2_1192.method398(anInt1287);
                aClass30_Sub2_Sub2_1192.method398(anInt845);
                aClass30_Sub2_Sub2_1192.method398(anInt1248);
            }
            if(super.anInt27 >= 412 && super.anInt27 <= 512 && super.anInt28 >= 467 && super.anInt28 <= 499)
                if(anInt857 == -1)
                {
                    method147(537);
                    aString881 = "";
                    aBoolean1158 = false;
                    for(int i = 0; i < Class9.aClass9Array210.length; i++)
                    {
                        if(Class9.aClass9Array210[i] == null || Class9.aClass9Array210[i].anInt214 != 600)
                            continue;
                        anInt1178 = anInt857 = Class9.aClass9Array210[i].anInt236;
                        break;
                    }

                } else
                {
                    method77("Please close the interface you have open before using 'report abuse'", 0, "", aBoolean991);
                }
            anInt940++;
            if(anInt940 > 1386)
            {
                anInt940 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 165);
                aClass30_Sub2_Sub2_1192.method398(0);
                int j = aClass30_Sub2_Sub2_1192.anInt1406;
                aClass30_Sub2_Sub2_1192.method398(139);
                aClass30_Sub2_Sub2_1192.method398(150);
                aClass30_Sub2_Sub2_1192.method399(32131);
                aClass30_Sub2_Sub2_1192.method398((int)(Math.random() * 256D));
                aClass30_Sub2_Sub2_1192.method399(3250);
                aClass30_Sub2_Sub2_1192.method398(177);
                aClass30_Sub2_Sub2_1192.method399(24859);
                aClass30_Sub2_Sub2_1192.method398(119);
                if((int)(Math.random() * 2D) == 0)
                    aClass30_Sub2_Sub2_1192.method399(47234);
                if((int)(Math.random() * 2D) == 0)
                    aClass30_Sub2_Sub2_1192.method398(21);
                aClass30_Sub2_Sub2_1192.method407(aClass30_Sub2_Sub2_1192.anInt1406 - j, (byte)0);
            }
        }
    }

    public final void method33(boolean flag, int i)
    {
        int j = Class41.aClass41Array701[i].anInt709;
        if(j == 0)
            return;
        int k = anIntArray971[i];
        if(flag)
            anInt961 = aClass17_1000.method246();
        if(j == 1)
        {
            if(k == 1)
                Class30_Sub2_Sub1_Sub3.method372(0.90000000000000002D, aByte1200);
            if(k == 2)
                Class30_Sub2_Sub1_Sub3.method372(0.80000000000000004D, aByte1200);
            if(k == 3)
                Class30_Sub2_Sub1_Sub3.method372(0.69999999999999996D, aByte1200);
            if(k == 4)
                Class30_Sub2_Sub1_Sub3.method372(0.59999999999999998D, aByte1200);
            Class8.aClass12_158.method224();
            aBoolean1255 = true;
        }
        if(j == 3)
        {
            boolean flag1 = aBoolean1151;
            if(k == 0)
            {
                method123((byte)0, aBoolean1151, 0);
                aBoolean1151 = true;
            }
            if(k == 1)
            {
                method123((byte)0, aBoolean1151, -400);
                aBoolean1151 = true;
            }
            if(k == 2)
            {
                method123((byte)0, aBoolean1151, -800);
                aBoolean1151 = true;
            }
            if(k == 3)
            {
                method123((byte)0, aBoolean1151, -1200);
                aBoolean1151 = true;
            }
            if(k == 4)
                aBoolean1151 = false;
            if(aBoolean1151 != flag1 && !aBoolean960)
            {
                if(aBoolean1151)
                {
                    anInt1227 = anInt956;
                    aBoolean1228 = true;
                    aClass42_Sub1_1068.method558(2, anInt1227);
                } else
                {
                    method15(860);
                }
                anInt1259 = 0;
            }
        }
        if(j == 4)
        {
            if(k == 0)
            {
                aBoolean848 = true;
                method111((byte)2, 0);
            }
            if(k == 1)
            {
                aBoolean848 = true;
                method111((byte)2, -400);
            }
            if(k == 2)
            {
                aBoolean848 = true;
                method111((byte)2, -800);
            }
            if(k == 3)
            {
                aBoolean848 = true;
                method111((byte)2, -1200);
            }
            if(k == 4)
                aBoolean848 = false;
        }
        if(j == 5)
            anInt1253 = k;
        if(j == 6)
            anInt1249 = k;
        if(j == 8)
        {
            anInt1195 = k;
            aBoolean1223 = true;
        }
        if(j == 9)
            anInt913 = k;
    }

    public final void method34(int i)
    {
        anInt974 = 0;
        for(int j = -1; j < anInt891 + anInt836; j++)
        {
            Object obj;
            if(j == -1)
                obj = aClass30_Sub2_Sub4_Sub1_Sub2_1126;
            else
            if(j < anInt891)
                obj = aClass30_Sub2_Sub4_Sub1_Sub2Array890[anIntArray892[j]];
            else
                obj = aClass30_Sub2_Sub4_Sub1_Sub1Array835[anIntArray837[j - anInt891]];
            if(obj == null || !((Class30_Sub2_Sub4_Sub1) (obj)).method449(aBoolean1224))
                continue;
            if(obj instanceof Class30_Sub2_Sub4_Sub1_Sub1)
            {
                Class5 class5 = ((Class30_Sub2_Sub4_Sub1_Sub1)obj).aClass5_1696;
                if(class5.anIntArray88 != null)
                    class5 = class5.method161(anInt877);
                if(class5 == null)
                    continue;
            }
            if(j < anInt891)
            {
                int l = 30;
                Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = (Class30_Sub2_Sub4_Sub1_Sub2)obj;
                if(class30_sub2_sub4_sub1_sub2.anInt1706 != 0)
                {
                    method127(true, ((Class30_Sub2_Sub4_Sub1) (obj)), ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1507 + 15);
                    if(anInt963 > -1)
                    {
                        for(int i2 = 0; i2 < 8; i2++)
                            if((class30_sub2_sub4_sub1_sub2.anInt1706 & 1 << i2) != 0)
                            {
                                aClass30_Sub2_Sub1_Sub1Array1095[i2].method348(anInt963 - 12, 16083, anInt964 - l);
                                l -= 25;
                            }

                    }
                }
                if(j >= 0 && anInt855 == 10 && anInt933 == anIntArray892[j])
                {
                    method127(true, ((Class30_Sub2_Sub4_Sub1) (obj)), ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1507 + 15);
                    if(anInt963 > -1)
                        aClass30_Sub2_Sub1_Sub1Array1095[7].method348(anInt963 - 12, 16083, anInt964 - l);
                }
            } else
            {
                Class5 class5_1 = ((Class30_Sub2_Sub4_Sub1_Sub1)obj).aClass5_1696;
                if(class5_1.anInt75 >= 0 && class5_1.anInt75 < aClass30_Sub2_Sub1_Sub1Array1095.length)
                {
                    method127(true, ((Class30_Sub2_Sub4_Sub1) (obj)), ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1507 + 15);
                    if(anInt963 > -1)
                        aClass30_Sub2_Sub1_Sub1Array1095[class5_1.anInt75].method348(anInt963 - 12, 16083, anInt964 - 30);
                }
                if(anInt855 == 1 && anInt1222 == anIntArray837[j - anInt891] && anInt1161 % 20 < 10)
                {
                    method127(true, ((Class30_Sub2_Sub4_Sub1) (obj)), ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1507 + 15);
                    if(anInt963 > -1)
                        aClass30_Sub2_Sub1_Sub1Array1095[2].method348(anInt963 - 12, 16083, anInt964 - 28);
                }
            }
            if(((Class30_Sub2_Sub4_Sub1) (obj)).aString1506 != null && (j >= anInt891 || anInt1287 == 0 || anInt1287 == 3 || anInt1287 == 1 && method109(false, ((Class30_Sub2_Sub4_Sub1_Sub2)obj).aString1703)))
            {
                method127(true, ((Class30_Sub2_Sub4_Sub1) (obj)), ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1507);
                if(anInt963 > -1 && anInt974 < anInt975)
                {
                    anIntArray979[anInt974] = aClass30_Sub2_Sub1_Sub4_1272.method384(((Class30_Sub2_Sub4_Sub1) (obj)).aString1506, true) / 2;
                    anIntArray978[anInt974] = aClass30_Sub2_Sub1_Sub4_1272.anInt1497;
                    anIntArray976[anInt974] = anInt963;
                    anIntArray977[anInt974] = anInt964;
                    anIntArray980[anInt974] = ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1513;
                    anIntArray981[anInt974] = ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1531;
                    anIntArray982[anInt974] = ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1535;
                    aStringArray983[anInt974++] = ((Class30_Sub2_Sub4_Sub1) (obj)).aString1506;
                    if(anInt1249 == 0 && ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1531 >= 1 && ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1531 <= 3)
                    {
                        anIntArray978[anInt974] += 10;
                        anIntArray977[anInt974] += 5;
                    }
                    if(anInt1249 == 0 && ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1531 == 4)
                        anIntArray979[anInt974] = 60;
                    if(anInt1249 == 0 && ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1531 == 5)
                        anIntArray978[anInt974] += 5;
                }
            }
            if(((Class30_Sub2_Sub4_Sub1) (obj)).anInt1532 > anInt1161)
            {
                method127(true, ((Class30_Sub2_Sub4_Sub1) (obj)), ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1507 + 15);
                if(anInt963 > -1)
                {
                    int i1 = (((Class30_Sub2_Sub4_Sub1) (obj)).anInt1533 * 30) / ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1534;
                    if(i1 > 30)
                        i1 = 30;
                    Class30_Sub2_Sub1.method336(5, anInt964 - 3, anInt963 - 15, 65280, i1, 0);
                    Class30_Sub2_Sub1.method336(5, anInt964 - 3, (anInt963 - 15) + i1, 0xff0000, 30 - i1, 0);
                }
            }
            for(int j1 = 0; j1 < 4; j1++)
                if(((Class30_Sub2_Sub4_Sub1) (obj)).anIntArray1516[j1] > anInt1161)
                {
                    method127(true, ((Class30_Sub2_Sub4_Sub1) (obj)), ((Class30_Sub2_Sub4_Sub1) (obj)).anInt1507 / 2);
                    if(anInt963 > -1)
                    {
                        if(j1 == 1)
                            anInt964 -= 20;
                        if(j1 == 2)
                        {
                            anInt963 -= 15;
                            anInt964 -= 10;
                        }
                        if(j1 == 3)
                        {
                            anInt963 += 15;
                            anInt964 -= 10;
                        }
                        aClass30_Sub2_Sub1_Sub1Array987[((Class30_Sub2_Sub4_Sub1) (obj)).anIntArray1515[j1]].method348(anInt963 - 12, 16083, anInt964 - 12);
                        aClass30_Sub2_Sub1_Sub4_1270.method381(0, String.valueOf(((Class30_Sub2_Sub4_Sub1) (obj)).anIntArray1514[j1]), 23693, anInt964 + 4, anInt963);
                        aClass30_Sub2_Sub1_Sub4_1270.method381(0xffffff, String.valueOf(((Class30_Sub2_Sub4_Sub1) (obj)).anIntArray1514[j1]), 23693, anInt964 + 3, anInt963 - 1);
                    }
                }

        }

        if(i != 0)
            method6();
        for(int k = 0; k < anInt974; k++)
        {
            int k1 = anIntArray976[k];
            int l1 = anIntArray977[k];
            int j2 = anIntArray979[k];
            int k2 = anIntArray978[k];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int l2 = 0; l2 < k; l2++)
                    if(l1 + 2 > anIntArray977[l2] - anIntArray978[l2] && l1 - k2 < anIntArray977[l2] + 2 && k1 - j2 < anIntArray976[l2] + anIntArray979[l2] && k1 + j2 > anIntArray976[l2] - anIntArray979[l2] && anIntArray977[l2] - anIntArray978[l2] < l1)
                    {
                        l1 = anIntArray977[l2] - anIntArray978[l2];
                        flag = true;
                    }

            }
            anInt963 = anIntArray976[k];
            anInt964 = anIntArray977[k] = l1;
            String s = aStringArray983[k];
            if(anInt1249 == 0)
            {
                int i3 = 0xffff00;
                if(anIntArray980[k] < 6)
                    i3 = anIntArray965[anIntArray980[k]];
                if(anIntArray980[k] == 6)
                    i3 = anInt1265 % 20 >= 10 ? 0xffff00 : 0xff0000;
                if(anIntArray980[k] == 7)
                    i3 = anInt1265 % 20 >= 10 ? 65535 : 255;
                if(anIntArray980[k] == 8)
                    i3 = anInt1265 % 20 >= 10 ? 0x80ff80 : 45056;
                if(anIntArray980[k] == 9)
                {
                    int j3 = 150 - anIntArray982[k];
                    if(j3 < 50)
                        i3 = 0xff0000 + 1280 * j3;
                    else
                    if(j3 < 100)
                        i3 = 0xffff00 - 0x50000 * (j3 - 50);
                    else
                    if(j3 < 150)
                        i3 = 65280 + 5 * (j3 - 100);
                }
                if(anIntArray980[k] == 10)
                {
                    int k3 = 150 - anIntArray982[k];
                    if(k3 < 50)
                        i3 = 0xff0000 + 5 * k3;
                    else
                    if(k3 < 100)
                        i3 = 0xff00ff - 0x50000 * (k3 - 50);
                    else
                    if(k3 < 150)
                        i3 = (255 + 0x50000 * (k3 - 100)) - 5 * (k3 - 100);
                }
                if(anIntArray980[k] == 11)
                {
                    int l3 = 150 - anIntArray982[k];
                    if(l3 < 50)
                        i3 = 0xffffff - 0x50005 * l3;
                    else
                    if(l3 < 100)
                        i3 = 65280 + 0x50005 * (l3 - 50);
                    else
                    if(l3 < 150)
                        i3 = 0xffffff - 0x50000 * (l3 - 100);
                }
                if(anIntArray981[k] == 0)
                {
                    aClass30_Sub2_Sub1_Sub4_1272.method381(0, s, 23693, anInt964 + 1, anInt963);
                    aClass30_Sub2_Sub1_Sub4_1272.method381(i3, s, 23693, anInt964, anInt963);
                }
                if(anIntArray981[k] == 1)
                {
                    aClass30_Sub2_Sub1_Sub4_1272.method386(0, true, s, anInt963, anInt1265, anInt964 + 1);
                    aClass30_Sub2_Sub1_Sub4_1272.method386(i3, true, s, anInt963, anInt1265, anInt964);
                }
                if(anIntArray981[k] == 2)
                {
                    aClass30_Sub2_Sub1_Sub4_1272.method387(anInt963, s, anInt1265, anInt964 + 1, aByte1194, 0);
                    aClass30_Sub2_Sub1_Sub4_1272.method387(anInt963, s, anInt1265, anInt964, aByte1194, i3);
                }
                if(anIntArray981[k] == 3)
                {
                    aClass30_Sub2_Sub1_Sub4_1272.method388(150 - anIntArray982[k], s, true, anInt1265, anInt964 + 1, anInt963, 0);
                    aClass30_Sub2_Sub1_Sub4_1272.method388(150 - anIntArray982[k], s, true, anInt1265, anInt964, anInt963, i3);
                }
                if(anIntArray981[k] == 4)
                {
                    int i4 = aClass30_Sub2_Sub1_Sub4_1272.method384(s, true);
                    int k4 = ((150 - anIntArray982[k]) * (i4 + 100)) / 150;
                    Class30_Sub2_Sub1.method333(334, anInt963 - 50, false, anInt963 + 50, 0);
                    aClass30_Sub2_Sub1_Sub4_1272.method385(0, s, anInt964 + 1, 822, (anInt963 + 50) - k4);
                    aClass30_Sub2_Sub1_Sub4_1272.method385(i3, s, anInt964, 822, (anInt963 + 50) - k4);
                    Class30_Sub2_Sub1.method332(4);
                }
                if(anIntArray981[k] == 5)
                {
                    int j4 = 150 - anIntArray982[k];
                    int l4 = 0;
                    if(j4 < 25)
                        l4 = j4 - 25;
                    else
                    if(j4 > 125)
                        l4 = j4 - 125;
                    Class30_Sub2_Sub1.method333(anInt964 + 5, 0, false, 512, anInt964 - aClass30_Sub2_Sub1_Sub4_1272.anInt1497 - 1);
                    aClass30_Sub2_Sub1_Sub4_1272.method381(0, s, 23693, anInt964 + 1 + l4, anInt963);
                    aClass30_Sub2_Sub1_Sub4_1272.method381(i3, s, 23693, anInt964 + l4, anInt963);
                    Class30_Sub2_Sub1.method332(4);
                }
            } else
            {
                aClass30_Sub2_Sub1_Sub4_1272.method381(0, s, 23693, anInt964 + 1, anInt963);
                aClass30_Sub2_Sub1_Sub4_1272.method381(0xffff00, s, 23693, anInt964, anInt963);
            }
        }

    }

    public final void method35(boolean flag, long l)
    {
        try
        {
            if(l == 0L)
                return;
            for(int i = 0; i < anInt899; i++)
            {
                if(aLongArray955[i] != l)
                    continue;
                anInt899--;
                aBoolean1153 = true;
                for(int j = i; j < anInt899; j++)
                {
                    aStringArray1082[j] = aStringArray1082[j + 1];
                    anIntArray826[j] = anIntArray826[j + 1];
                    aLongArray955[j] = aLongArray955[j + 1];
                }

                aClass30_Sub2_Sub2_1192.method397((byte)6, 215);
                aClass30_Sub2_Sub2_1192.method404(5, l);
                break;
            }

            if(flag)
                return;
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("18622, " + flag + ", " + l + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public final void method36(byte byte0)
    {
        aClass15_1163.method237(0);
        Class30_Sub2_Sub1_Sub3.anIntArray1472 = anIntArray1181;
        if(byte0 != -81)
            return;
        aClass30_Sub2_Sub1_Sub2_1196.method361(0, 16083, 0);
        if(anInt1189 != -1)
            method105(8, 0, 0, Class9.aClass9Array210[anInt1189], 0);
        else
        if(anIntArray1130[anInt1221] != -1)
            method105(8, 0, 0, Class9.aClass9Array210[anIntArray1130[anInt1221]], 0);
        if(aBoolean885 && anInt948 == 1)
            method40((byte)9);
        aClass15_1163.method238(205, 23680, super.aGraphics12, 553);
        aClass15_1165.method237(0);
        Class30_Sub2_Sub1_Sub3.anIntArray1472 = anIntArray1182;
    }

    public final void method37(int i, int j)
    {
        if(i <= 0)
            opcode = -1;
        if(!aBoolean960)
        {
            if(Class30_Sub2_Sub1_Sub3.anIntArray1480[17] >= j)
            {
                Class30_Sub2_Sub1_Sub2 class30_sub2_sub1_sub2 = Class30_Sub2_Sub1_Sub3.aClass30_Sub2_Sub1_Sub2Array1474[17];
                int k = class30_sub2_sub1_sub2.anInt1452 * class30_sub2_sub1_sub2.anInt1453 - 1;
                int j1 = class30_sub2_sub1_sub2.anInt1452 * anInt945 * 2;
                byte abyte0[] = class30_sub2_sub1_sub2.aByteArray1450;
                byte abyte3[] = aByteArray912;
                for(int i2 = 0; i2 <= k; i2++)
                    abyte3[i2] = abyte0[i2 - j1 & k];

                class30_sub2_sub1_sub2.aByteArray1450 = abyte3;
                aByteArray912 = abyte0;
                Class30_Sub2_Sub1_Sub3.method370(17, -477);
                anInt854++;
                if(anInt854 > 1235)
                {
                    anInt854 = 0;
                    aClass30_Sub2_Sub2_1192.method397((byte)6, 226);
                    aClass30_Sub2_Sub2_1192.method398(0);
                    int l2 = aClass30_Sub2_Sub2_1192.anInt1406;
                    aClass30_Sub2_Sub2_1192.method399(58722);
                    aClass30_Sub2_Sub2_1192.method398(240);
                    aClass30_Sub2_Sub2_1192.method399((int)(Math.random() * 65536D));
                    aClass30_Sub2_Sub2_1192.method398((int)(Math.random() * 256D));
                    if((int)(Math.random() * 2D) == 0)
                        aClass30_Sub2_Sub2_1192.method399(51825);
                    aClass30_Sub2_Sub2_1192.method398((int)(Math.random() * 256D));
                    aClass30_Sub2_Sub2_1192.method399((int)(Math.random() * 65536D));
                    aClass30_Sub2_Sub2_1192.method399(7130);
                    aClass30_Sub2_Sub2_1192.method399((int)(Math.random() * 65536D));
                    aClass30_Sub2_Sub2_1192.method399(61657);
                    aClass30_Sub2_Sub2_1192.method407(aClass30_Sub2_Sub2_1192.anInt1406 - l2, (byte)0);
                }
            }
            if(Class30_Sub2_Sub1_Sub3.anIntArray1480[24] >= j)
            {
                Class30_Sub2_Sub1_Sub2 class30_sub2_sub1_sub2_1 = Class30_Sub2_Sub1_Sub3.aClass30_Sub2_Sub1_Sub2Array1474[24];
                int l = class30_sub2_sub1_sub2_1.anInt1452 * class30_sub2_sub1_sub2_1.anInt1453 - 1;
                int k1 = class30_sub2_sub1_sub2_1.anInt1452 * anInt945 * 2;
                byte abyte1[] = class30_sub2_sub1_sub2_1.aByteArray1450;
                byte abyte4[] = aByteArray912;
                for(int j2 = 0; j2 <= l; j2++)
                    abyte4[j2] = abyte1[j2 - k1 & l];

                class30_sub2_sub1_sub2_1.aByteArray1450 = abyte4;
                aByteArray912 = abyte1;
                Class30_Sub2_Sub1_Sub3.method370(24, -477);
            }
            if(Class30_Sub2_Sub1_Sub3.anIntArray1480[34] >= j)
            {
                Class30_Sub2_Sub1_Sub2 class30_sub2_sub1_sub2_2 = Class30_Sub2_Sub1_Sub3.aClass30_Sub2_Sub1_Sub2Array1474[34];
                int i1 = class30_sub2_sub1_sub2_2.anInt1452 * class30_sub2_sub1_sub2_2.anInt1453 - 1;
                int l1 = class30_sub2_sub1_sub2_2.anInt1452 * anInt945 * 2;
                byte abyte2[] = class30_sub2_sub1_sub2_2.aByteArray1450;
                byte abyte5[] = aByteArray912;
                for(int k2 = 0; k2 <= i1; k2++)
                    abyte5[k2] = abyte2[k2 - l1 & i1];

                class30_sub2_sub1_sub2_2.aByteArray1450 = abyte5;
                aByteArray912 = abyte2;
                Class30_Sub2_Sub1_Sub3.method370(34, -477);
            }
        }
    }

    public final void method38(byte byte0)
    {
        if(byte0 != -92)
            aClass30_Sub2_Sub2_1192.method398(214);
        for(int i = -1; i < anInt891; i++)
        {
            int j;
            if(i == -1)
                j = anInt889;
            else
                j = anIntArray892[i];
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[j];
            if(class30_sub2_sub4_sub1_sub2 != null && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1535 > 0)
            {
                class30_sub2_sub4_sub1_sub2.anInt1535--;
                if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1535 == 0)
                    class30_sub2_sub4_sub1_sub2.aString1506 = null;
            }
        }

        for(int k = 0; k < anInt836; k++)
        {
            int l = anIntArray837[k];
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[l];
            if(class30_sub2_sub4_sub1_sub1 != null && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1535 > 0)
            {
                class30_sub2_sub4_sub1_sub1.anInt1535--;
                if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1535 == 0)
                    class30_sub2_sub4_sub1_sub1.aString1506 = null;
            }
        }

    }

    public final void method39(byte byte0)
    {
        int i = anInt1098 * 128 + 64;
        int j = anInt1099 * 128 + 64;
        int k = method42(anInt918, j, true, i) - anInt1100;
        if(anInt858 < i)
        {
            anInt858 += anInt1101 + ((i - anInt858) * anInt1102) / 1000;
            if(anInt858 > i)
                anInt858 = i;
        }
        if(anInt858 > i)
        {
            anInt858 -= anInt1101 + ((anInt858 - i) * anInt1102) / 1000;
            if(anInt858 < i)
                anInt858 = i;
        }
        if(anInt859 < k)
        {
            anInt859 += anInt1101 + ((k - anInt859) * anInt1102) / 1000;
            if(anInt859 > k)
                anInt859 = k;
        }
        if(anInt859 > k)
        {
            anInt859 -= anInt1101 + ((anInt859 - k) * anInt1102) / 1000;
            if(anInt859 < k)
                anInt859 = k;
        }
        if(anInt860 < j)
        {
            anInt860 += anInt1101 + ((j - anInt860) * anInt1102) / 1000;
            if(anInt860 > j)
                anInt860 = j;
        }
        if(anInt860 > j)
        {
            anInt860 -= anInt1101 + ((anInt860 - j) * anInt1102) / 1000;
            if(anInt860 < j)
                anInt860 = j;
        }
        i = anInt995 * 128 + 64;
        j = anInt996 * 128 + 64;
        k = method42(anInt918, j, true, i) - anInt997;
        int l = i - anInt858;
        int i1 = k - anInt859;
        int j1 = j - anInt860;
        int k1 = (int)Math.sqrt(l * l + j1 * j1);
        int l1 = (int)(Math.atan2(i1, k1) * 325.94900000000001D) & 0x7ff;
        if(byte0 == 5)
            byte0 = 0;
        else
            aBoolean919 = !aBoolean919;
        int i2 = (int)(Math.atan2(l, j1) * -325.94900000000001D) & 0x7ff;
        if(l1 < 128)
            l1 = 128;
        if(l1 > 383)
            l1 = 383;
        if(anInt861 < l1)
        {
            anInt861 += anInt998 + ((l1 - anInt861) * anInt999) / 1000;
            if(anInt861 > l1)
                anInt861 = l1;
        }
        if(anInt861 > l1)
        {
            anInt861 -= anInt998 + ((anInt861 - l1) * anInt999) / 1000;
            if(anInt861 < l1)
                anInt861 = l1;
        }
        int j2 = i2 - anInt862;
        if(j2 > 1024)
            j2 -= 2048;
        if(j2 < -1024)
            j2 += 2048;
        if(j2 > 0)
        {
            anInt862 += anInt998 + (j2 * anInt999) / 1000;
            anInt862 &= 0x7ff;
        }
        if(j2 < 0)
        {
            anInt862 -= anInt998 + (-j2 * anInt999) / 1000;
            anInt862 &= 0x7ff;
        }
        int k2 = i2 - anInt862;
        if(k2 > 1024)
            k2 -= 2048;
        if(k2 < -1024)
            k2 += 2048;
        if(k2 < 0 && j2 > 0 || k2 > 0 && j2 < 0)
            anInt862 = i2;
    }

    public final void method40(byte byte0)
    {
        int i = anInt949;
        int j = anInt950;
        int k = anInt951;
        int l = anInt952;
        int i1 = 0x5d5447;
        Class30_Sub2_Sub1.method336(l, j, i, i1, k, 0);
        if(byte0 == 9)
            byte0 = 0;
        else
            return;
        Class30_Sub2_Sub1.method336(16, j + 1, i + 1, 0, k - 2, 0);
        Class30_Sub2_Sub1.method337(i + 1, k - 2, l - 19, 0, j + 18, true);
        aClass30_Sub2_Sub1_Sub4_1272.method385(i1, "Choose Option", j + 14, 822, i + 3);
        int j1 = super.anInt20;
        int k1 = super.anInt21;
        if(anInt948 == 0)
        {
            j1 -= 4;
            k1 -= 4;
        }
        if(anInt948 == 1)
        {
            j1 -= 553;
            k1 -= 205;
        }
        if(anInt948 == 2)
        {
            j1 -= 17;
            k1 -= 357;
        }
        for(int l1 = 0; l1 < anInt1133; l1++)
        {
            int i2 = j + 31 + (anInt1133 - 1 - l1) * 15;
            int j2 = 0xffffff;
            if(j1 > i && j1 < i + k && k1 > i2 - 13 && k1 < i2 + 3)
                j2 = 0xffff00;
            aClass30_Sub2_Sub1_Sub4_1272.method389(false, true, i + 3, j2, aStringArray1199[l1], i2);
        }

    }

    public final void method41(byte byte0, long l)
    {
        try
        {
            if(l == 0L)
                return;
            if(anInt899 >= 100 && anInt1046 != 1)
            {
                method77("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "", aBoolean991);
                return;
            }
            if(anInt899 >= 200)
            {
                method77("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "", aBoolean991);
                return;
            }
            String s = Class50.method587(-45804, Class50.method584(l, (byte)-99));
            for(int i = 0; i < anInt899; i++)
                if(aLongArray955[i] == l)
                {
                    method77(s + " is already on your friend list", 0, "", aBoolean991);
                    return;
                }

            if(byte0 != 68)
                opcode = -1;
            for(int j = 0; j < anInt822; j++)
                if(aLongArray925[j] == l)
                {
                    method77("Please remove " + s + " from your ignore list first", 0, "", aBoolean991);
                    return;
                }

            if(s.equals(aClass30_Sub2_Sub4_Sub1_Sub2_1126.aString1703))
            {
                return;
            } else
            {
                aStringArray1082[anInt899] = s;
                aLongArray955[anInt899] = l;
                anIntArray826[anInt899] = 0;
                anInt899++;
                aBoolean1153 = true;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 188);
                aClass30_Sub2_Sub2_1192.method404(5, l);
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("15283, " + byte0 + ", " + l + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public final int method42(int i, int j, boolean flag, int k)
    {
        aBoolean1157 &= flag;
        int l = k >> 7;
        int i1 = j >> 7;
        if(l < 0 || i1 < 0 || l > 103 || i1 > 103)
            return 0;
        int j1 = i;
        if(j1 < 3 && (aByteArrayArrayArray1258[1][l][i1] & 2) == 2)
            j1++;
        int k1 = k & 0x7f;
        int l1 = j & 0x7f;
        int i2 = anIntArrayArrayArray1214[j1][l][i1] * (128 - k1) + anIntArrayArrayArray1214[j1][l + 1][i1] * k1 >> 7;
        int j2 = anIntArrayArrayArray1214[j1][l][i1 + 1] * (128 - k1) + anIntArrayArrayArray1214[j1][l + 1][i1 + 1] * k1 >> 7;
        return i2 * (128 - l1) + j2 * l1 >> 7;
    }

    private static final String method43(int i, int j)
    {
        if(i != -33245)
            anInt846 = -65;
        if(j < 0x186a0)
            return String.valueOf(j);
        if(j < 0x989680)
            return j / 1000 + "K";
        else
            return j / 0xf4240 + "M";
    }

    public final void method44(boolean flag)
    {
        try
        {
            if(aClass24_1168 != null)
                aClass24_1168.method267();
        }
        catch(Exception _ex) { }
        aClass24_1168 = null;
        if(!flag)
            return;
        aBoolean1157 = false;
        anInt833 = 0;
        aString1173 = "";
        aString1174 = "";
        method23(false);
        aClass25_946.method274(619);
        for(int i = 0; i < 4; i++)
            aClass11Array1230[i].method210();

        System.gc();
        method15(860);
        anInt956 = -1;
        anInt1227 = -1;
        anInt1259 = 0;
    }

    public final void method45(int i)
    {
        if(i != 0)
            opcode = -1;
        aBoolean1031 = true;
        for(int j = 0; j < 7; j++)
        {
            anIntArray1065[j] = -1;
            for(int k = 0; k < Class38.anInt655; k++)
            {
                if(Class38.aClass38Array656[k].aBoolean662 || Class38.aClass38Array656[k].anInt657 != j + (aBoolean1047 ? 0 : 7))
                    continue;
                anIntArray1065[j] = k;
                break;
            }

        }

    }

    private final void method46(int i, Class30_Sub2_Sub2 class30_sub2_sub2, byte byte0)
    {
        if(byte0 != 2)
        {
            for(int j = 1; j > 0; j++);
        }
        while(class30_sub2_sub2.anInt1407 + 21 < i * 8) 
        {
            int k = class30_sub2_sub2.method419(14, 0);
            if(k == 16383)
                break;
            if(aClass30_Sub2_Sub4_Sub1_Sub1Array835[k] == null)
                aClass30_Sub2_Sub4_Sub1_Sub1Array835[k] = new Class30_Sub2_Sub4_Sub1_Sub1();
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[k];
            anIntArray837[anInt836++] = k;
            class30_sub2_sub4_sub1_sub1.anInt1537 = anInt1161;
            int l = class30_sub2_sub2.method419(5, 0);
            if(l > 15)
                l -= 32;
            int i1 = class30_sub2_sub2.method419(5, 0);
            if(i1 > 15)
                i1 -= 32;
            int j1 = class30_sub2_sub2.method419(1, 0);
            class30_sub2_sub4_sub1_sub1.aClass5_1696 = Class5.method159(class30_sub2_sub2.method419(12, 0));
            int k1 = class30_sub2_sub2.method419(1, 0);
            if(k1 == 1)
                anIntArray894[anInt893++] = k;
            class30_sub2_sub4_sub1_sub1.anInt1540 = class30_sub2_sub4_sub1_sub1.aClass5_1696.aByte68;
            class30_sub2_sub4_sub1_sub1.anInt1504 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt79;
            class30_sub2_sub4_sub1_sub1.anInt1554 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt67;
            class30_sub2_sub4_sub1_sub1.anInt1555 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt58;
            class30_sub2_sub4_sub1_sub1.anInt1556 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt83;
            class30_sub2_sub4_sub1_sub1.anInt1557 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt55;
            class30_sub2_sub4_sub1_sub1.anInt1511 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt77;
            class30_sub2_sub4_sub1_sub1.method445(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0] + i1, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0] + l, j1 == 1, false);
        }
        class30_sub2_sub2.method420(true);
    }

    public final void method7(int i)
    {
        if(aBoolean1252 || aBoolean926 || aBoolean1176)
            return;
        anInt1161++;
        if(!aBoolean1157)
            method140(true);
        else
            method62(anInt1218);
        method57(false);
        if(i != anInt1058)
            aBoolean919 = !aBoolean919;
    }

    public final void method47(int i, boolean flag)
    {
        if(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 >> 7 == anInt1261 && ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 >> 7 == anInt1262)
            anInt1261 = 0;
        int j = anInt891;
        if(i != 0)
        {
            for(int k = 1; k > 0; k++);
        }
        if(flag)
            j = 1;
        for(int l = 0; l < j; l++)
        {
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2;
            int i1;
            if(flag)
            {
                class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2_1126;
                i1 = anInt889 << 14;
            } else
            {
                class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[anIntArray892[l]];
                i1 = anIntArray892[l] << 14;
            }
            if(class30_sub2_sub4_sub1_sub2 == null || !class30_sub2_sub4_sub1_sub2.method449(aBoolean1224))
                continue;
            class30_sub2_sub4_sub1_sub2.aBoolean1699 = false;
            if((aBoolean960 && anInt891 > 50 || anInt891 > 200) && !flag && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1517 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1511)
                class30_sub2_sub4_sub1_sub2.aBoolean1699 = true;
            int j1 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550 >> 7;
            int k1 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551 >> 7;
            if(j1 < 0 || j1 >= 104 || k1 < 0 || k1 >= 104)
                continue;
            if(class30_sub2_sub4_sub1_sub2.aClass30_Sub2_Sub4_Sub6_1714 != null && anInt1161 >= class30_sub2_sub4_sub1_sub2.anInt1707 && anInt1161 < class30_sub2_sub4_sub1_sub2.anInt1708)
            {
                class30_sub2_sub4_sub1_sub2.aBoolean1699 = false;
                class30_sub2_sub4_sub1_sub2.anInt1709 = method42(anInt918, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551, true, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550);
                aClass25_946.method286(60, anInt918, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551, class30_sub2_sub4_sub1_sub2, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1552, class30_sub2_sub4_sub1_sub2.anInt1722, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550, class30_sub2_sub4_sub1_sub2.anInt1709, class30_sub2_sub4_sub1_sub2.anInt1719, class30_sub2_sub4_sub1_sub2.anInt1721, i1, class30_sub2_sub4_sub1_sub2.anInt1720, (byte)35);
                continue;
            }
            if((((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550 & 0x7f) == 64 && (((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551 & 0x7f) == 64)
            {
                if(anIntArrayArray929[j1][k1] == anInt1265)
                    continue;
                anIntArrayArray929[j1][k1] = anInt1265;
            }
            class30_sub2_sub4_sub1_sub2.anInt1709 = method42(anInt918, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551, true, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550);
            aClass25_946.method285(anInt918, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1552, (byte)6, class30_sub2_sub4_sub1_sub2.anInt1709, i1, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551, 60, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550, class30_sub2_sub4_sub1_sub2, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).aBoolean1541);
        }

    }

    public final boolean method48(int i, Class9 class9)
    {
        if(i <= 0)
            opcode = -1;
        int j = class9.anInt214;
        if(anInt900 == 2)
        {
            if(j == 201)
            {
                aBoolean1223 = true;
                anInt1225 = 0;
                aBoolean1256 = true;
                aString1212 = "";
                anInt1064 = 1;
                aString1121 = "Enter name of friend to add to list";
            }
            if(j == 202)
            {
                aBoolean1223 = true;
                anInt1225 = 0;
                aBoolean1256 = true;
                aString1212 = "";
                anInt1064 = 2;
                aString1121 = "Enter name of friend to delete from list";
            }
        }
        if(j == 205)
        {
            anInt1011 = 250;
            return true;
        }
        if(j == 501)
        {
            aBoolean1223 = true;
            anInt1225 = 0;
            aBoolean1256 = true;
            aString1212 = "";
            anInt1064 = 4;
            aString1121 = "Enter name of player to add to list";
        }
        if(j == 502)
        {
            aBoolean1223 = true;
            anInt1225 = 0;
            aBoolean1256 = true;
            aString1212 = "";
            anInt1064 = 5;
            aString1121 = "Enter name of player to delete from list";
        }
        if(j >= 300 && j <= 313)
        {
            int k = (j - 300) / 2;
            int j1 = j & 1;
            int i2 = anIntArray1065[k];
            if(i2 != -1)
            {
                do
                {
                    if(j1 == 0 && --i2 < 0)
                        i2 = Class38.anInt655 - 1;
                    if(j1 == 1 && ++i2 >= Class38.anInt655)
                        i2 = 0;
                } while(Class38.aClass38Array656[i2].aBoolean662 || Class38.aClass38Array656[i2].anInt657 != k + (aBoolean1047 ? 0 : 7));
                anIntArray1065[k] = i2;
                aBoolean1031 = true;
            }
        }
        if(j >= 314 && j <= 323)
        {
            int l = (j - 314) / 2;
            int k1 = j & 1;
            int j2 = anIntArray990[l];
            if(k1 == 0 && --j2 < 0)
                j2 = anIntArrayArray1003[l].length - 1;
            if(k1 == 1 && ++j2 >= anIntArrayArray1003[l].length)
                j2 = 0;
            anIntArray990[l] = j2;
            aBoolean1031 = true;
        }
        if(j == 324 && !aBoolean1047)
        {
            aBoolean1047 = true;
            method45(0);
        }
        if(j == 325 && aBoolean1047)
        {
            aBoolean1047 = false;
            method45(0);
        }
        if(j == 326)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 101);
            aClass30_Sub2_Sub2_1192.method398(aBoolean1047 ? 0 : 1);
            for(int i1 = 0; i1 < 7; i1++)
                aClass30_Sub2_Sub2_1192.method398(anIntArray1065[i1]);

            for(int l1 = 0; l1 < 5; l1++)
                aClass30_Sub2_Sub2_1192.method398(anIntArray990[l1]);

            return true;
        }
        if(j == 613)
            aBoolean1158 = !aBoolean1158;
        if(j >= 601 && j <= 612)
        {
            method147(537);
            if(aString881.length() > 0)
            {
                aClass30_Sub2_Sub2_1192.method397((byte)6, 218);
                aClass30_Sub2_Sub2_1192.method404(5, Class50.method583(aString881));
                aClass30_Sub2_Sub2_1192.method398(j - 601);
                aClass30_Sub2_Sub2_1192.method398(aBoolean1158 ? 1 : 0);
            }
        }
        return false;
    }

    private final void method49(int i, byte byte0, Class30_Sub2_Sub2 class30_sub2_sub2) {
        System.out.println("METHOD 49 CALLED");
        if(byte0 == 2)
            byte0 = 0;
        else
            return;
        // begin block updating
        // anint893 is all players in our list
        for(int j = 0; j < anInt893; j++)
        {
            int k = anIntArray894[j];
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[k];
            int l = class30_sub2_sub2.method408();
            System.out.println("Update flag: " + l);
            if((l & 0x40) != 0)
                l += class30_sub2_sub2.method408() << 8;
            method107(l, k, class30_sub2_sub2, aByte923, class30_sub2_sub4_sub1_sub2);
        }

    }

    public final void method50(int i, int j, int k, int l, int i1, int j1)
    {
        int k1 = aClass25_946.method300(j1, l, i);
        if(j >= 0)
            return;
        if(k1 != 0)
        {
            int l1 = aClass25_946.method304(j1, l, i, k1);
            int k2 = l1 >> 6 & 3;
            int i3 = l1 & 0x1f;
            int k3 = k;
            if(k1 > 0)
                k3 = i1;
            int ai[] = aClass30_Sub2_Sub1_Sub1_1263.anIntArray1439;
            int k4 = 24624 + l * 4 + (103 - i) * 512 * 4;
            int i5 = k1 >> 14 & 0x7fff;
            Class46 class46_2 = Class46.method572(i5);
            if(class46_2.anInt758 != -1)
            {
                Class30_Sub2_Sub1_Sub2 class30_sub2_sub1_sub2_2 = aClass30_Sub2_Sub1_Sub2Array1060[class46_2.anInt758];
                if(class30_sub2_sub1_sub2_2 != null)
                {
                    int i6 = (class46_2.anInt744 * 4 - class30_sub2_sub1_sub2_2.anInt1452) / 2;
                    int j6 = (class46_2.anInt761 * 4 - class30_sub2_sub1_sub2_2.anInt1453) / 2;
                    class30_sub2_sub1_sub2_2.method361(48 + l * 4 + i6, 16083, 48 + (104 - i - class46_2.anInt761) * 4 + j6);
                }
            } else
            {
                if(i3 == 0 || i3 == 2)
                    if(k2 == 0)
                    {
                        ai[k4] = k3;
                        ai[k4 + 512] = k3;
                        ai[k4 + 1024] = k3;
                        ai[k4 + 1536] = k3;
                    } else
                    if(k2 == 1)
                    {
                        ai[k4] = k3;
                        ai[k4 + 1] = k3;
                        ai[k4 + 2] = k3;
                        ai[k4 + 3] = k3;
                    } else
                    if(k2 == 2)
                    {
                        ai[k4 + 3] = k3;
                        ai[k4 + 3 + 512] = k3;
                        ai[k4 + 3 + 1024] = k3;
                        ai[k4 + 3 + 1536] = k3;
                    } else
                    if(k2 == 3)
                    {
                        ai[k4 + 1536] = k3;
                        ai[k4 + 1536 + 1] = k3;
                        ai[k4 + 1536 + 2] = k3;
                        ai[k4 + 1536 + 3] = k3;
                    }
                if(i3 == 3)
                    if(k2 == 0)
                        ai[k4] = k3;
                    else
                    if(k2 == 1)
                        ai[k4 + 3] = k3;
                    else
                    if(k2 == 2)
                        ai[k4 + 3 + 1536] = k3;
                    else
                    if(k2 == 3)
                        ai[k4 + 1536] = k3;
                if(i3 == 2)
                    if(k2 == 3)
                    {
                        ai[k4] = k3;
                        ai[k4 + 512] = k3;
                        ai[k4 + 1024] = k3;
                        ai[k4 + 1536] = k3;
                    } else
                    if(k2 == 0)
                    {
                        ai[k4] = k3;
                        ai[k4 + 1] = k3;
                        ai[k4 + 2] = k3;
                        ai[k4 + 3] = k3;
                    } else
                    if(k2 == 1)
                    {
                        ai[k4 + 3] = k3;
                        ai[k4 + 3 + 512] = k3;
                        ai[k4 + 3 + 1024] = k3;
                        ai[k4 + 3 + 1536] = k3;
                    } else
                    if(k2 == 2)
                    {
                        ai[k4 + 1536] = k3;
                        ai[k4 + 1536 + 1] = k3;
                        ai[k4 + 1536 + 2] = k3;
                        ai[k4 + 1536 + 3] = k3;
                    }
            }
        }
        k1 = aClass25_946.method302(j1, l, i);
        if(k1 != 0)
        {
            int i2 = aClass25_946.method304(j1, l, i, k1);
            int l2 = i2 >> 6 & 3;
            int j3 = i2 & 0x1f;
            int l3 = k1 >> 14 & 0x7fff;
            Class46 class46_1 = Class46.method572(l3);
            if(class46_1.anInt758 != -1)
            {
                Class30_Sub2_Sub1_Sub2 class30_sub2_sub1_sub2_1 = aClass30_Sub2_Sub1_Sub2Array1060[class46_1.anInt758];
                if(class30_sub2_sub1_sub2_1 != null)
                {
                    int j5 = (class46_1.anInt744 * 4 - class30_sub2_sub1_sub2_1.anInt1452) / 2;
                    int k5 = (class46_1.anInt761 * 4 - class30_sub2_sub1_sub2_1.anInt1453) / 2;
                    class30_sub2_sub1_sub2_1.method361(48 + l * 4 + j5, 16083, 48 + (104 - i - class46_1.anInt761) * 4 + k5);
                }
            } else
            if(j3 == 9)
            {
                int l4 = 0xeeeeee;
                if(k1 > 0)
                    l4 = 0xee0000;
                int ai1[] = aClass30_Sub2_Sub1_Sub1_1263.anIntArray1439;
                int l5 = 24624 + l * 4 + (103 - i) * 512 * 4;
                if(l2 == 0 || l2 == 2)
                {
                    ai1[l5 + 1536] = l4;
                    ai1[l5 + 1024 + 1] = l4;
                    ai1[l5 + 512 + 2] = l4;
                    ai1[l5 + 3] = l4;
                } else
                {
                    ai1[l5] = l4;
                    ai1[l5 + 512 + 1] = l4;
                    ai1[l5 + 1024 + 2] = l4;
                    ai1[l5 + 1536 + 3] = l4;
                }
            }
        }
        k1 = aClass25_946.method303(j1, l, i);
        if(k1 != 0)
        {
            int j2 = k1 >> 14 & 0x7fff;
            Class46 class46 = Class46.method572(j2);
            if(class46.anInt758 != -1)
            {
                Class30_Sub2_Sub1_Sub2 class30_sub2_sub1_sub2 = aClass30_Sub2_Sub1_Sub2Array1060[class46.anInt758];
                if(class30_sub2_sub1_sub2 != null)
                {
                    int i4 = (class46.anInt744 * 4 - class30_sub2_sub1_sub2.anInt1452) / 2;
                    int j4 = (class46.anInt761 * 4 - class30_sub2_sub1_sub2.anInt1453) / 2;
                    class30_sub2_sub1_sub2.method361(48 + l * 4 + i4, 16083, 48 + (104 - i - class46.anInt761) * 4 + j4);
                }
            }
        }
    }

    public final void method51(int i)
    {
        aClass30_Sub2_Sub1_Sub2_966 = new Class30_Sub2_Sub1_Sub2(aClass44_1053, "titlebox", 0);
        if(i <= 0)
            aBoolean1231 = !aBoolean1231;
        aClass30_Sub2_Sub1_Sub2_967 = new Class30_Sub2_Sub1_Sub2(aClass44_1053, "titlebutton", 0);
        aClass30_Sub2_Sub1_Sub2Array1152 = new Class30_Sub2_Sub1_Sub2[12];
        int j = 0;
        try
        {
            j = Integer.parseInt(getParameter("fl_icon"));
        }
        catch(Exception _ex) { }
        if(j == 0)
        {
            for(int k = 0; k < 12; k++)
                aClass30_Sub2_Sub1_Sub2Array1152[k] = new Class30_Sub2_Sub1_Sub2(aClass44_1053, "runes", k);

        } else
        {
            for(int l = 0; l < 12; l++)
                aClass30_Sub2_Sub1_Sub2Array1152[l] = new Class30_Sub2_Sub1_Sub2(aClass44_1053, "runes", 12 + (l & 3));

        }
        aClass30_Sub2_Sub1_Sub1_1201 = new Class30_Sub2_Sub1_Sub1(128, 265);
        aClass30_Sub2_Sub1_Sub1_1202 = new Class30_Sub2_Sub1_Sub1(128, 265);
        for(int i1 = 0; i1 < 33920; i1++)
            aClass30_Sub2_Sub1_Sub1_1201.anIntArray1439[i1] = aClass15_1110.anIntArray315[i1];

        for(int j1 = 0; j1 < 33920; j1++)
            aClass30_Sub2_Sub1_Sub1_1202.anIntArray1439[j1] = aClass15_1111.anIntArray315[j1];

        anIntArray851 = new int[256];
        for(int k1 = 0; k1 < 64; k1++)
            anIntArray851[k1] = k1 * 0x40000;

        for(int l1 = 0; l1 < 64; l1++)
            anIntArray851[l1 + 64] = 0xff0000 + 1024 * l1;

        for(int i2 = 0; i2 < 64; i2++)
            anIntArray851[i2 + 128] = 0xffff00 + 4 * i2;

        for(int j2 = 0; j2 < 64; j2++)
            anIntArray851[j2 + 192] = 0xffffff;

        anIntArray852 = new int[256];
        for(int k2 = 0; k2 < 64; k2++)
            anIntArray852[k2] = k2 * 1024;

        for(int l2 = 0; l2 < 64; l2++)
            anIntArray852[l2 + 64] = 65280 + 4 * l2;

        for(int i3 = 0; i3 < 64; i3++)
            anIntArray852[i3 + 128] = 65535 + 0x40000 * i3;

        for(int j3 = 0; j3 < 64; j3++)
            anIntArray852[j3 + 192] = 0xffffff;

        anIntArray853 = new int[256];
        for(int k3 = 0; k3 < 64; k3++)
            anIntArray853[k3] = k3 * 4;

        for(int l3 = 0; l3 < 64; l3++)
            anIntArray853[l3 + 64] = 255 + 0x40000 * l3;

        for(int i4 = 0; i4 < 64; i4++)
            anIntArray853[i4 + 128] = 0xff00ff + 1024 * i4;

        for(int j4 = 0; j4 < 64; j4++)
            anIntArray853[j4 + 192] = 0xffffff;

        anIntArray850 = new int[256];
        anIntArray1190 = new int[32768];
        anIntArray1191 = new int[32768];
        method106(null, -135);
        anIntArray828 = new int[32768];
        anIntArray829 = new int[32768];
        method13(10, (byte)4, "Connecting to fileserver");
        if(!aBoolean831)
        {
            aBoolean880 = true;
            aBoolean831 = true;
            method12(this, 2);
        }
    }

    public static final void method52(boolean flag)
    {
        Class25.aBoolean436 = false;
        Class30_Sub2_Sub1_Sub3.aBoolean1461 = false;
        aBoolean960 = false;
        Class7.aBoolean151 = false;
        if(flag)
            aBoolean919 = !aBoolean919;
        Class46.aBoolean752 = false;
    }
    // 0 0 highmem members 0
    public static final void main(String args[])
    {
        try
        {
            System.out.println("Loading 317 cache");
            if(args.length != 5)
            {
                System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
                return;
            }
            anInt957 = Integer.parseInt(args[0]);
            anInt958 = Integer.parseInt(args[1]);
            if(args[2].equals("lowmem"))
                method138((byte)77);
            else
            if(args[2].equals("highmem"))
            {
                method52(false);
            } else
            {
                System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
                return;
            }
            if(args[3].equals("free"))
                aBoolean959 = false;
            else
            if(args[3].equals("members"))
            {
                aBoolean959 = true;
            } else
            {
                System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
                return;
            }
            signlink.storeid = Integer.parseInt(args[4]);
            signlink.startpriv(InetAddress.getLocalHost());
            client client1 = new client();
            client1.method1(503, false, 765);
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    public final void method53(int i)
    {
        if(i != -48877)
            return;
        if(aBoolean960 && anInt1023 == 2 && Class7.anInt131 != anInt918)
        {
            aClass15_1165.method237(0);
            aClass30_Sub2_Sub1_Sub4_1271.method381(0, "Loading - please wait.", 23693, 151, 257);
            aClass30_Sub2_Sub1_Sub4_1271.method381(0xffffff, "Loading - please wait.", 23693, 150, 256);
            aClass15_1165.method238(4, 23680, super.aGraphics12, 4);
            anInt1023 = 1;
            aLong824 = System.currentTimeMillis();
        }
        if(anInt1023 == 1)
        {
            int j = method54((byte)-95);
            if(j != 0 && System.currentTimeMillis() - aLong824 > 0x57e40L)
            {
                signlink.reporterror(aString1173 + " glcfb " + aLong1215 + "," + j + "," + aBoolean960 + "," + aClass14Array970[0] + "," + aClass42_Sub1_1068.method552() + "," + anInt918 + "," + anInt1069 + "," + anInt1070);
                aLong824 = System.currentTimeMillis();
            }
        }
        if(anInt1023 == 2 && anInt918 != anInt985)
        {
            anInt985 = anInt918;
            method24(true, anInt918);
        }
    }

    public final int method54(byte byte0)
    {
        for(int i = 0; i < aByteArrayArray1183.length; i++)
        {
            if(aByteArrayArray1183[i] == null && anIntArray1235[i] != -1)
                return -1;
            if(aByteArrayArray1247[i] == null && anIntArray1236[i] != -1)
                return -2;
        }

        boolean flag = true;
        if(byte0 != -95)
            return 0;
        for(int j = 0; j < aByteArrayArray1183.length; j++)
        {
            byte abyte0[] = aByteArrayArray1247[j];
            if(abyte0 != null)
            {
                int k = (anIntArray1234[j] >> 8) * 64 - anInt1034;
                int l = (anIntArray1234[j] & 0xff) * 64 - anInt1035;
                if(aBoolean1159)
                {
                    k = 10;
                    l = 10;
                }
                flag &= Class7.method189(k, abyte0, l, 6);
            }
        }

        if(!flag)
            return -3;
        if(aBoolean1080)
        {
            return -4;
        } else
        {
            anInt1023 = 2;
            Class7.anInt131 = anInt918;
            method22(true);
            aClass30_Sub2_Sub2_1192.method397((byte)6, 121);
            return 0;
        }
    }

    public final void method55(int i)
    {
        while(i >= 0) 
            method6();
        for(Class30_Sub2_Sub4_Sub4 class30_sub2_sub4_sub4 = (Class30_Sub2_Sub4_Sub4)aClass19_1013.method252(); class30_sub2_sub4_sub4 != null; class30_sub2_sub4_sub4 = (Class30_Sub2_Sub4_Sub4)aClass19_1013.method254(false))
            if(class30_sub2_sub4_sub4.anInt1597 != anInt918 || anInt1161 > class30_sub2_sub4_sub4.anInt1572)
                class30_sub2_sub4_sub4.method329();
            else
            if(anInt1161 >= class30_sub2_sub4_sub4.anInt1571)
            {
                if(class30_sub2_sub4_sub4.anInt1590 > 0)
                {
                    Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[class30_sub2_sub4_sub4.anInt1590 - 1];
                    if(class30_sub2_sub4_sub1_sub1 != null && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550 >= 0 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550 < 13312 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551 >= 0 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551 < 13312)
                        class30_sub2_sub4_sub4.method455(anInt1161, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551, method42(class30_sub2_sub4_sub4.anInt1597, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551, true, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550) - class30_sub2_sub4_sub4.anInt1583, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550, (byte)-83);
                }
                if(class30_sub2_sub4_sub4.anInt1590 < 0)
                {
                    int j = -class30_sub2_sub4_sub4.anInt1590 - 1;
                    Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2;
                    if(j == anInt884)
                        class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2_1126;
                    else
                        class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[j];
                    if(class30_sub2_sub4_sub1_sub2 != null && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550 >= 0 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550 < 13312 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551 >= 0 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551 < 13312)
                        class30_sub2_sub4_sub4.method455(anInt1161, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551, method42(class30_sub2_sub4_sub4.anInt1597, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551, true, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550) - class30_sub2_sub4_sub4.anInt1583, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550, (byte)-83);
                }
                class30_sub2_sub4_sub4.method456(anInt945, anInt1020);
                aClass25_946.method285(anInt918, class30_sub2_sub4_sub4.anInt1595, (byte)6, (int)class30_sub2_sub4_sub4.aDouble1587, -1, (int)class30_sub2_sub4_sub4.aDouble1586, 60, (int)class30_sub2_sub4_sub4.aDouble1585, class30_sub2_sub4_sub4, false);
            }

    }

    public final AppletContext getAppletContext()
    {
        if(signlink.mainapp != null)
            return signlink.mainapp.getAppletContext();
        else
            return super.getAppletContext();
    }

    public final void method56(int i)
    {
        byte abyte0[] = aClass44_1053.method571("title.dat", null);
        Class30_Sub2_Sub1_Sub1 class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(abyte0, this);
        aClass15_1110.method237(0);
        class30_sub2_sub1_sub1.method346(0, 0, -32357);
        aClass15_1111.method237(0);
        class30_sub2_sub1_sub1.method346(-637, 0, -32357);
        aClass15_1107.method237(0);
        class30_sub2_sub1_sub1.method346(-128, 0, -32357);
        aClass15_1108.method237(0);
        class30_sub2_sub1_sub1.method346(-202, -371, -32357);
        aClass15_1109.method237(0);
        class30_sub2_sub1_sub1.method346(-202, -171, -32357);
        aClass15_1112.method237(0);
        class30_sub2_sub1_sub1.method346(0, -265, -32357);
        aClass15_1113.method237(0);
        class30_sub2_sub1_sub1.method346(-562, -265, -32357);
        aClass15_1114.method237(0);
        class30_sub2_sub1_sub1.method346(-128, -171, -32357);
        aClass15_1115.method237(0);
        class30_sub2_sub1_sub1.method346(-562, -171, -32357);
        int ai[] = new int[class30_sub2_sub1_sub1.anInt1440];
        for(int j = 0; j < class30_sub2_sub1_sub1.anInt1441; j++)
        {
            for(int k = 0; k < class30_sub2_sub1_sub1.anInt1440; k++)
                ai[k] = class30_sub2_sub1_sub1.anIntArray1439[(class30_sub2_sub1_sub1.anInt1440 - k - 1) + class30_sub2_sub1_sub1.anInt1440 * j];

            for(int l = 0; l < class30_sub2_sub1_sub1.anInt1440; l++)
                class30_sub2_sub1_sub1.anIntArray1439[l + class30_sub2_sub1_sub1.anInt1440 * j] = ai[l];

        }

        aClass15_1110.method237(0);
        class30_sub2_sub1_sub1.method346(382, 0, -32357);
        aClass15_1111.method237(0);
        class30_sub2_sub1_sub1.method346(-255, 0, -32357);
        aClass15_1107.method237(0);
        class30_sub2_sub1_sub1.method346(254, 0, -32357);
        aClass15_1108.method237(0);
        class30_sub2_sub1_sub1.method346(180, -371, -32357);
        aClass15_1109.method237(0);
        class30_sub2_sub1_sub1.method346(180, -171, -32357);
        aClass15_1112.method237(0);
        class30_sub2_sub1_sub1.method346(382, -265, -32357);
        aClass15_1113.method237(0);
        class30_sub2_sub1_sub1.method346(-180, -265, -32357);
        aClass15_1114.method237(0);
        class30_sub2_sub1_sub1.method346(254, -171, -32357);
        aClass15_1115.method237(0);
        if(i != 0)
        {
            return;
        } else
        {
            class30_sub2_sub1_sub1.method346(-180, -171, -32357);
            class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(aClass44_1053, "logo", 0);
            aClass15_1107.method237(0);
            class30_sub2_sub1_sub1.method348(382 - class30_sub2_sub1_sub1.anInt1440 / 2 - 128, 16083, 18);
            class30_sub2_sub1_sub1 = null;
            Object obj = null;
            Object obj1 = null;
            System.gc();
            return;
        }
    }

    public final void method57(boolean flag)
    {
        if(flag)
            anInt883 = -72;
        do
        {
            Class30_Sub2_Sub3 class30_sub2_sub3;
            do
            {
                class30_sub2_sub3 = aClass42_Sub1_1068.method561();
                if(class30_sub2_sub3 == null)
                    return;
                if(class30_sub2_sub3.anInt1419 == 0)
                {
                    Class30_Sub2_Sub4_Sub6.method460(class30_sub2_sub3.aByteArray1420, -4036, class30_sub2_sub3.anInt1421);
                    if((aClass42_Sub1_1068.method559(class30_sub2_sub3.anInt1421, -203) & 0x62) != 0)
                    {
                        aBoolean1153 = true;
                        if(anInt1276 != -1)
                            aBoolean1223 = true;
                    }
                }
                if(class30_sub2_sub3.anInt1419 == 1 && class30_sub2_sub3.aByteArray1420 != null)
                    Class36.method529(class30_sub2_sub3.aByteArray1420, false);
                if(class30_sub2_sub3.anInt1419 == 2 && class30_sub2_sub3.anInt1421 == anInt1227 && class30_sub2_sub3.aByteArray1420 != null)
                    method21(aBoolean1228, 0, class30_sub2_sub3.aByteArray1420);
                if(class30_sub2_sub3.anInt1419 == 3 && anInt1023 == 1)
                {
                    for(int i = 0; i < aByteArrayArray1183.length; i++)
                    {
                        if(anIntArray1235[i] == class30_sub2_sub3.anInt1421)
                        {
                            aByteArrayArray1183[i] = class30_sub2_sub3.aByteArray1420;
                            if(class30_sub2_sub3.aByteArray1420 == null)
                                anIntArray1235[i] = -1;
                            break;
                        }
                        if(anIntArray1236[i] != class30_sub2_sub3.anInt1421)
                            continue;
                        aByteArrayArray1247[i] = class30_sub2_sub3.aByteArray1420;
                        if(class30_sub2_sub3.aByteArray1420 == null)
                            anIntArray1236[i] = -1;
                        break;
                    }

                }
            } while(class30_sub2_sub3.anInt1419 != 93 || !aClass42_Sub1_1068.method564(class30_sub2_sub3.anInt1421, -520));
            Class7.method173((byte)-107, new Class30_Sub2_Sub2(class30_sub2_sub3.aByteArray1420, 891), aClass42_Sub1_1068);
        } while(true);
    }

    public final void method58(int i)
    {
        char c = '\u0100';
        for(int j = 10; j < 117; j++)
        {
            int k = (int)(Math.random() * 100D);
            if(k < 50)
                anIntArray828[j + (c - 2 << 7)] = 255;
        }

        if(i != 25106)
            method6();
        for(int l = 0; l < 100; l++)
        {
            int i1 = (int)(Math.random() * 124D) + 2;
            int k1 = (int)(Math.random() * 128D) + 128;
            int k2 = i1 + (k1 << 7);
            anIntArray828[k2] = 192;
        }

        for(int j1 = 1; j1 < c - 1; j1++)
        {
            for(int l1 = 1; l1 < 127; l1++)
            {
                int l2 = l1 + (j1 << 7);
                anIntArray829[l2] = (anIntArray828[l2 - 1] + anIntArray828[l2 + 1] + anIntArray828[l2 - 128] + anIntArray828[l2 + 128]) / 4;
            }

        }

        anInt1275 += 128;
        if(anInt1275 > anIntArray1190.length)
        {
            anInt1275 -= anIntArray1190.length;
            int i2 = (int)(Math.random() * 12D);
            method106(aClass30_Sub2_Sub1_Sub2Array1152[i2], -135);
        }
        for(int j2 = 1; j2 < c - 1; j2++)
        {
            for(int i3 = 1; i3 < 127; i3++)
            {
                int k3 = i3 + (j2 << 7);
                int i4 = anIntArray829[k3 + 128] - anIntArray1190[k3 + anInt1275 & anIntArray1190.length - 1] / 5;
                if(i4 < 0)
                    i4 = 0;
                anIntArray828[k3] = i4;
            }

        }

        for(int j3 = 0; j3 < c - 1; j3++)
            anIntArray969[j3] = anIntArray969[j3 + 1];

        anIntArray969[c - 1] = (int)(Math.sin((double)anInt1161 / 14D) * 16D + Math.sin((double)anInt1161 / 15D) * 14D + Math.sin((double)anInt1161 / 16D) * 12D);
        if(anInt1040 > 0)
            anInt1040 -= 4;
        if(anInt1041 > 0)
            anInt1041 -= 4;
        if(anInt1040 == 0 && anInt1041 == 0)
        {
            int l3 = (int)(Math.random() * 2000D);
            if(l3 == 0)
                anInt1040 = 1024;
            if(l3 == 1)
                anInt1041 = 1024;
        }
    }

    public final boolean method59(byte abyte0[], byte byte0, int i)
    {
        if(byte0 != 116)
            throw new NullPointerException();
        if(abyte0 == null)
            return true;
        else
            return signlink.wavesave(abyte0, i);
    }

    public final void method60(int i, byte byte0)
    {
        Class9 class9 = Class9.aClass9Array210[i];
        for(int j = 0; j < class9.anIntArray240.length; j++)
        {
            if(class9.anIntArray240[j] == -1)
                break;
            Class9 class9_1 = Class9.aClass9Array210[class9.anIntArray240[j]];
            if(class9_1.anInt262 == 1)
                method60(class9_1.anInt250, (byte)6);
            class9_1.anInt246 = 0;
            class9_1.anInt208 = 0;
        }

        if(byte0 == 6)
            byte0 = 0;
    }

    public final void method61(int i)
    {
        if(anInt855 != 2)
            return;
        method128((anInt934 - anInt1034 << 7) + anInt937, anInt936 * 2, anInt875, (anInt935 - anInt1035 << 7) + anInt938);
        if(i >= 0)
            aBoolean1224 = !aBoolean1224;
        if(anInt963 > -1 && anInt1161 % 20 < 10)
            aClass30_Sub2_Sub1_Sub1Array1095[2].method348(anInt963 - 12, 16083, anInt964 - 28);
    }

    public final void method62(int i)
    {
        if(anInt1104 > 1)
            anInt1104--;
        if(anInt1011 > 0)
            anInt1011--;
        for(int j = 0; j < 5; j++)
            if(!method145(true))
                break;

        if(!aBoolean1157)
            return;
        synchronized(aClass48_879.anObject806)
        {
            if(aBoolean1205)
            {
                if(super.anInt26 != 0 || aClass48_879.anInt810 >= 40)
                {
                    aClass30_Sub2_Sub2_1192.method397((byte)6, 45);
                    aClass30_Sub2_Sub2_1192.method398(0);
                    int j2 = aClass30_Sub2_Sub2_1192.anInt1406;
                    int j3 = 0;
                    for(int j4 = 0; j4 < aClass48_879.anInt810; j4++)
                    {
                        if(j2 - aClass30_Sub2_Sub2_1192.anInt1406 >= 240)
                            break;
                        j3++;
                        int l4 = aClass48_879.anIntArray807[j4];
                        if(l4 < 0)
                            l4 = 0;
                        else
                        if(l4 > 502)
                            l4 = 502;
                        int k5 = aClass48_879.anIntArray809[j4];
                        if(k5 < 0)
                            k5 = 0;
                        else
                        if(k5 > 764)
                            k5 = 764;
                        int i6 = l4 * 765 + k5;
                        if(aClass48_879.anIntArray807[j4] == -1 && aClass48_879.anIntArray809[j4] == -1)
                        {
                            k5 = -1;
                            l4 = -1;
                            i6 = 0x7ffff;
                        }
                        if(k5 == anInt1237 && l4 == anInt1238)
                        {
                            if(anInt1022 < 2047)
                                anInt1022++;
                        } else
                        {
                            int j6 = k5 - anInt1237;
                            anInt1237 = k5;
                            int k6 = l4 - anInt1238;
                            anInt1238 = l4;
                            if(anInt1022 < 8 && j6 >= -32 && j6 <= 31 && k6 >= -32 && k6 <= 31)
                            {
                                j6 += 32;
                                k6 += 32;
                                aClass30_Sub2_Sub2_1192.method399((anInt1022 << 12) + (j6 << 6) + k6);
                                anInt1022 = 0;
                            } else
                            if(anInt1022 < 8)
                            {
                                aClass30_Sub2_Sub2_1192.method401(0x800000 + (anInt1022 << 19) + i6);
                                anInt1022 = 0;
                            } else
                            {
                                aClass30_Sub2_Sub2_1192.method402(0xc0000000 + (anInt1022 << 19) + i6);
                                anInt1022 = 0;
                            }
                        }
                    }

                    aClass30_Sub2_Sub2_1192.method407(aClass30_Sub2_Sub2_1192.anInt1406 - j2, (byte)0);
                    if(j3 >= aClass48_879.anInt810)
                    {
                        aClass48_879.anInt810 = 0;
                    } else
                    {
                        aClass48_879.anInt810 -= j3;
                        for(int i5 = 0; i5 < aClass48_879.anInt810; i5++)
                        {
                            aClass48_879.anIntArray809[i5] = aClass48_879.anIntArray809[i5 + j3];
                            aClass48_879.anIntArray807[i5] = aClass48_879.anIntArray807[i5 + j3];
                        }

                    }
                }
            } else
            {
                aClass48_879.anInt810 = 0;
            }
        }
        if(super.anInt26 != 0)
        {
            long l = (super.aLong29 - aLong1220) / 50L;
            if(l > 4095L)
                l = 4095L;
            aLong1220 = super.aLong29;
            int k2 = super.anInt28;
            if(k2 < 0)
                k2 = 0;
            else
            if(k2 > 502)
                k2 = 502;
            int k3 = super.anInt27;
            if(k3 < 0)
                k3 = 0;
            else
            if(k3 > 764)
                k3 = 764;
            int k4 = k2 * 765 + k3;
            int j5 = 0;
            if(super.anInt26 == 2)
                j5 = 1;
            int l5 = (int)l;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 241);
            aClass30_Sub2_Sub2_1192.method402((l5 << 20) + (j5 << 19) + k4);
        }
        if(anInt1016 > 0)
            anInt1016--;
        if(super.anIntArray30[1] == 1 || super.anIntArray30[2] == 1 || super.anIntArray30[3] == 1 || super.anIntArray30[4] == 1)
            aBoolean1017 = true;
        if(aBoolean1017 && anInt1016 <= 0)
        {
            anInt1016 = 20;
            aBoolean1017 = false;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 86);
            aClass30_Sub2_Sub2_1192.method399(anInt1184);
            aClass30_Sub2_Sub2_1192.method432(-431, anInt1185);
        }
        if(super.aBoolean17 && !aBoolean954)
        {
            aBoolean954 = true;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 3);
            aClass30_Sub2_Sub2_1192.method398(1);
        }
        if(!super.aBoolean17 && aBoolean954)
        {
            aBoolean954 = false;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 3);
            aClass30_Sub2_Sub2_1192.method398(0);
        }
        method53(-48877);
        method115((byte)8);
        method90(false);
        anInt1009++;
        if(anInt1009 > 750)
            method68(-670);
        method114((byte)-74);
        method95(-8066);
        method38((byte)-92);
        anInt945++;
        if(anInt917 != 0)
        {
            anInt916 += 20;
            if(anInt916 >= 400)
                anInt917 = 0;
        }
        if(anInt1246 != 0)
        {
            anInt1243++;
            if(anInt1243 >= 15)
            {
                if(anInt1246 == 2)
                    aBoolean1153 = true;
                if(anInt1246 == 3)
                    aBoolean1223 = true;
                anInt1246 = 0;
            }
        }
        if(anInt1086 != 0)
        {
            anInt989++;
            if(super.anInt20 > anInt1087 + 5 || super.anInt20 < anInt1087 - 5 || super.anInt21 > anInt1088 + 5 || super.anInt21 < anInt1088 - 5)
                aBoolean1242 = true;
            if(super.anInt19 == 0)
            {
                if(anInt1086 == 2)
                    aBoolean1153 = true;
                if(anInt1086 == 3)
                    aBoolean1223 = true;
                anInt1086 = 0;
                if(aBoolean1242 && anInt989 >= 5)
                {
                    anInt1067 = -1;
                    method82(0);
                    if(anInt1067 == anInt1084 && anInt1066 != anInt1085)
                    {
                        Class9 class9 = Class9.aClass9Array210[anInt1084];
                        int j1 = 0;
                        if(anInt913 == 1 && class9.anInt214 == 206)
                            j1 = 1;
                        if(class9.anIntArray253[anInt1066] <= 0)
                            j1 = 0;
                        if(class9.aBoolean235)
                        {
                            int l2 = anInt1085;
                            int l3 = anInt1066;
                            class9.anIntArray253[l3] = class9.anIntArray253[l2];
                            class9.anIntArray252[l3] = class9.anIntArray252[l2];
                            class9.anIntArray253[l2] = -1;
                            class9.anIntArray252[l2] = 0;
                        } else
                        if(j1 == 1)
                        {
                            int i3 = anInt1085;
                            for(int i4 = anInt1066; i3 != i4;)
                                if(i3 > i4)
                                {
                                    class9.method204(i3, (byte)9, i3 - 1);
                                    i3--;
                                } else
                                if(i3 < i4)
                                {
                                    class9.method204(i3, (byte)9, i3 + 1);
                                    i3++;
                                }

                        } else
                        {
                            class9.method204(anInt1085, (byte)9, anInt1066);
                        }
                        aClass30_Sub2_Sub2_1192.method397((byte)6, 214);
                        aClass30_Sub2_Sub2_1192.method433(0, anInt1084);
                        aClass30_Sub2_Sub2_1192.method424(j1, 0);
                        aClass30_Sub2_Sub2_1192.method433(0, anInt1085);
                        aClass30_Sub2_Sub2_1192.method431(true, anInt1066);
                    }
                } else
                if((anInt1253 == 1 || method17(9, anInt1133 - 1)) && anInt1133 > 2)
                    method116(true);
                else
                if(anInt1133 > 0)
                    method69(anInt1133 - 1, false);
                anInt1243 = 10;
                super.anInt26 = 0;
            }
        }
        if(Class25.anInt470 != -1)
        {
            int k = Class25.anInt470;
            int k1 = Class25.anInt471;
            boolean flag = method85(0, 0, 0, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, k1, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], true, k);
            Class25.anInt470 = -1;
            if(flag)
            {
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 1;
                anInt916 = 0;
            }
        }
        if(super.anInt26 == 1 && aString844 != null)
        {
            aString844 = null;
            aBoolean1223 = true;
            super.anInt26 = 0;
        }
        method20(4);
        method92(true);
        method78(19);
        method32(true);
        if(super.anInt19 == 1 || super.anInt26 == 1)
            anInt1213++;
        if(anInt1023 == 2)
            method108(3);
        if(anInt1023 == 2 && aBoolean1160)
            method39((byte)5);
        for(int i1 = 0; i1 < 5; i1++)
            anIntArray1030[i1]++;

        method73(732);
        super.anInt18++;
        if(super.anInt18 > 4500)
        {
            anInt1011 = 250;
            super.anInt18 -= 500;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 202);
        }
        anInt988++;
        if(i >= 0)
            aClass19ArrayArrayArray827 = null;
        if(anInt988 > 500)
        {
            anInt988 = 0;
            int l1 = (int)(Math.random() * 8D);
            if((l1 & 1) == 1)
                anInt1278 += anInt1279;
            if((l1 & 2) == 2)
                anInt1131 += anInt1132;
            if((l1 & 4) == 4)
                anInt896 += anInt897;
        }
        if(anInt1278 < -50)
            anInt1279 = 2;
        if(anInt1278 > 50)
            anInt1279 = -2;
        if(anInt1131 < -55)
            anInt1132 = 2;
        if(anInt1131 > 55)
            anInt1132 = -2;
        if(anInt896 < -40)
            anInt897 = 1;
        if(anInt896 > 40)
            anInt897 = -1;
        anInt1254++;
        if(anInt1254 > 500)
        {
            anInt1254 = 0;
            int i2 = (int)(Math.random() * 8D);
            if((i2 & 1) == 1)
                anInt1209 += anInt1210;
            if((i2 & 2) == 2)
                anInt1170 += anInt1171;
        }
        if(anInt1209 < -60)
            anInt1210 = 2;
        if(anInt1209 > 60)
            anInt1210 = -2;
        if(anInt1170 < -20)
            anInt1171 = 1;
        if(anInt1170 > 10)
            anInt1171 = -1;
        anInt1010++;
        if(anInt1010 > 50)
            aClass30_Sub2_Sub2_1192.method397((byte)6, 0);
        try
        {
            if(aClass24_1168 != null && aClass30_Sub2_Sub2_1192.anInt1406 > 0)
            {
                aClass24_1168.method271(aClass30_Sub2_Sub2_1192.anInt1406, 0, aClass30_Sub2_Sub2_1192.aByteArray1405, 0);
                aClass30_Sub2_Sub2_1192.anInt1406 = 0;
                anInt1010 = 0;
                return;
            }
        }
        catch(IOException _ex)
        {
            method68(-670);
            return;
        }
        catch(Exception exception)
        {
            method44(true);
        }
    }

    private final void method63(int i)
    {
        Class30_Sub1 class30_sub1 = (Class30_Sub1)aClass19_1179.method252();
        while(i >= 0) 
        {
            for(int j = 1; j > 0; j++);
        }
        for(; class30_sub1 != null; class30_sub1 = (Class30_Sub1)aClass19_1179.method254(false))
            if(class30_sub1.anInt1294 == -1)
            {
                class30_sub1.anInt1302 = 0;
                method89(false, class30_sub1);
            } else
            {
                class30_sub1.method329();
            }

    }

    public final void method64(int i)
    {
        if(aClass15_1107 != null)
            return;
        super.aClass15_13 = null;
        aClass15_1166 = null;
        aClass15_1164 = null;
        aClass15_1163 = null;
        aClass15_1165 = null;
        aClass15_1123 = null;
        aClass15_1124 = null;
        aClass15_1125 = null;
        aClass15_1110 = new Class15(128, 265, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass15_1111 = new Class15(128, 265, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass15_1107 = new Class15(509, 171, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass15_1108 = new Class15(360, 132, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass15_1109 = new Class15(360, 200, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass15_1112 = new Class15(202, 238, method11(0), 0);
        if(i < 0 || i > 0)
            aClass19ArrayArrayArray827 = null;
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass15_1113 = new Class15(203, 238, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass15_1114 = new Class15(74, 94, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass15_1115 = new Class15(75, 94, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        if(aClass44_1053 != null)
        {
            method56(0);
            method51(215);
        }
        aBoolean1255 = true;
    }

    public final void method13(int i, byte byte0, String s)
    {
        anInt1079 = i;
        aString1049 = s;
        method64(0);
        if(aClass44_1053 == null)
        {
            super.method13(i, (byte)4, s);
            return;
        }
        aClass15_1109.method237(0);
        char c = '\u0168';
        char c1 = '\310';
        byte byte1 = 20;
        aClass30_Sub2_Sub1_Sub4_1272.method381(0xffffff, "RuneScape is loading - please wait...", 23693, c1 / 2 - 26 - byte1, c / 2);
        int j = c1 / 2 - 18 - byte1;
        Class30_Sub2_Sub1.method337(c / 2 - 152, 304, 34, 0x8c1111, j, true);
        Class30_Sub2_Sub1.method337(c / 2 - 151, 302, 32, 0, j + 1, true);
        Class30_Sub2_Sub1.method336(30, j + 2, c / 2 - 150, 0x8c1111, i * 3, 0);
        Class30_Sub2_Sub1.method336(30, j + 2, (c / 2 - 150) + i * 3, 0, 300 - i * 3, 0);
        aClass30_Sub2_Sub1_Sub4_1272.method381(0xffffff, s, 23693, (c1 / 2 + 5) - byte1, c / 2);
        aClass15_1109.method238(171, 23680, super.aGraphics12, 202);
        if(byte0 != 4)
        {
            for(int k = 1; k > 0; k++);
        }
        if(aBoolean1255)
        {
            aBoolean1255 = false;
            if(!aBoolean831)
            {
                aClass15_1110.method238(0, 23680, super.aGraphics12, 0);
                aClass15_1111.method238(0, 23680, super.aGraphics12, 637);
            }
            aClass15_1107.method238(0, 23680, super.aGraphics12, 128);
            aClass15_1108.method238(371, 23680, super.aGraphics12, 202);
            aClass15_1112.method238(265, 23680, super.aGraphics12, 0);
            aClass15_1113.method238(265, 23680, super.aGraphics12, 562);
            aClass15_1114.method238(171, 23680, super.aGraphics12, 128);
            aClass15_1115.method238(171, 23680, super.aGraphics12, 562);
        }
    }

    public final void method65(int i, int j, int k, int l, Class9 class9, int i1, boolean flag, 
            int j1, int k1)
    {
        if(aBoolean972)
            anInt992 = 32;
        else
            anInt992 = 0;
        aBoolean972 = false;
        anInt1007 += k1;
        if(k >= i && k < i + 16 && l >= i1 && l < i1 + 16)
        {
            class9.anInt224 -= anInt1213 * 4;
            if(flag)
            {
                aBoolean1153 = true;
                return;
            }
        } else
        if(k >= i && k < i + 16 && l >= (i1 + j) - 16 && l < i1 + j)
        {
            class9.anInt224 += anInt1213 * 4;
            if(flag)
            {
                aBoolean1153 = true;
                return;
            }
        } else
        if(k >= i - anInt992 && k < i + 16 + anInt992 && l >= i1 + 16 && l < (i1 + j) - 16 && anInt1213 > 0)
        {
            int l1 = ((j - 32) * j) / j1;
            if(l1 < 8)
                l1 = 8;
            int i2 = l - i1 - 16 - l1 / 2;
            int j2 = j - 32 - l1;
            class9.anInt224 = ((j1 - j) * i2) / j2;
            if(flag)
                aBoolean1153 = true;
            aBoolean972 = true;
        }
    }

    public final boolean method66(int i, int j, int k, int l)
    {
        int i1 = i >> 14 & 0x7fff;
        int j1 = aClass25_946.method304(anInt918, k, j, i);
        if(l >= 0)
            throw new NullPointerException();
        if(j1 == -1)
            return false;
        int k1 = j1 & 0x1f;
        int l1 = j1 >> 6 & 3;
        if(k1 == 10 || k1 == 11 || k1 == 22)
        {
            Class46 class46 = Class46.method572(i1);
            int i2;
            int j2;
            if(l1 == 0 || l1 == 2)
            {
                i2 = class46.anInt744;
                j2 = class46.anInt761;
            } else
            {
                i2 = class46.anInt761;
                j2 = class46.anInt744;
            }
            int k2 = class46.anInt768;
            if(l1 != 0)
                k2 = (k2 << l1 & 0xf) + (k2 >> 4 - l1);
            method85(2, 0, j2, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], i2, k2, j, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, k);
        } else
        {
            method85(2, l1, 0, -11308, k1 + 1, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, j, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, k);
        }
        anInt914 = super.anInt27;
        anInt915 = super.anInt28;
        anInt917 = 2;
        anInt916 = 0;
        return true;
    }

    public final Class44 method67(int i, String s, String s1, int j, byte byte0, int k)
    {
        byte abyte0[] = null;
        int l = 5;
        try
        {
            if(aClass14Array970[0] != null)
                abyte0 = aClass14Array970[0].method233(true, i);
        }
        catch(Exception _ex) { }
        if(abyte0 != null)
        {
    //        aCRC32_930.reset();
    //        aCRC32_930.update(abyte0);
    //        int i1 = (int)aCRC32_930.getValue();
    //        if(i1 != j)
    //            abyte0 = null;
        }
        if(abyte0 != null)
        {
            Class44 class44 = new Class44(44820, abyte0);
            return class44;
        }
        int j1 = 0;
        while(abyte0 == null) 
        {
            String s2 = "Unknown error";
            method13(k, (byte)4, "Requesting " + s);
            Object obj = null;
            try
            {
                int k1 = 0;
                DataInputStream datainputstream = method132(s1 + j);
                byte abyte1[] = new byte[6];
                datainputstream.readFully(abyte1, 0, 6);
                Class30_Sub2_Sub2 class30_sub2_sub2 = new Class30_Sub2_Sub2(abyte1, 891);
                class30_sub2_sub2.anInt1406 = 3;
                int i2 = class30_sub2_sub2.method412() + 6;
                int j2 = 6;
                abyte0 = new byte[i2];
                for(int k2 = 0; k2 < 6; k2++)
                    abyte0[k2] = abyte1[k2];

                while(j2 < i2) 
                {
                    int l2 = i2 - j2;
                    if(l2 > 1000)
                        l2 = 1000;
                    int j3 = datainputstream.read(abyte0, j2, l2);
                    if(j3 < 0)
                    {
                        s2 = "Length error: " + j2 + "/" + i2;
                        throw new IOException("EOF");
                    }
                    j2 += j3;
                    int k3 = (j2 * 100) / i2;
                    if(k3 != k1)
                        method13(k, (byte)4, "Loading " + s + " - " + k3 + "%");
                    k1 = k3;
                }
                datainputstream.close();
                try
                {
                    if(aClass14Array970[0] != null)
                        aClass14Array970[0].method234(abyte0.length, abyte0, (byte)2, i);
                }
                catch(Exception _ex)
                {
                    aClass14Array970[0] = null;
                }
   /*             if(abyte0 != null)
                {
                    aCRC32_930.reset();
                    aCRC32_930.update(abyte0);
                    int i3 = (int)aCRC32_930.getValue();
                    if(i3 != j)
                    {
                        abyte0 = null;
                        j1++;
                        s2 = "Checksum error: " + i3;
                    }
                }
  */
            }
            catch(IOException ioexception)
            {
                if(s2.equals("Unknown error"))
                    s2 = "Connection error";
                abyte0 = null;
            }
            catch(NullPointerException _ex)
            {
                s2 = "Null error";
                abyte0 = null;
                if(!signlink.reporterror)
                    return null;
            }
            catch(ArrayIndexOutOfBoundsException _ex)
            {
                s2 = "Bounds error";
                abyte0 = null;
                if(!signlink.reporterror)
                    return null;
            }
            catch(Exception _ex)
            {
                s2 = "Unexpected error";
                abyte0 = null;
                if(!signlink.reporterror)
                    return null;
            }
            if(abyte0 == null)
            {
                for(int l1 = l; l1 > 0; l1--)
                {
                    if(j1 >= 3)
                    {
                        method13(k, (byte)4, "Game updated - please reload page");
                        l1 = 10;
                    } else
                    {
                        method13(k, (byte)4, s2 + " - Retrying in " + l1);
                    }
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch(Exception _ex) { }
                }

                l *= 2;
                if(l > 60)
                    l = 60;
                aBoolean872 = !aBoolean872;
            }
        }
        Class44 class44_1 = new Class44(44820, abyte0);
        if(byte0 != -41)
            throw new NullPointerException();
        else
            return class44_1;
    }

    public final void method68(int i)
    {
        if(anInt1011 > 0)
        {
            method44(true);
            return;
        }
        aClass15_1165.method237(0);
        aClass30_Sub2_Sub1_Sub4_1271.method381(0, "Connection lost", 23693, 144, 257);
        aClass30_Sub2_Sub1_Sub4_1271.method381(0xffffff, "Connection lost", 23693, 143, 256);
        aClass30_Sub2_Sub1_Sub4_1271.method381(0, "Please wait - attempting to reestablish", 23693, 159, 257);
        aClass30_Sub2_Sub1_Sub4_1271.method381(0xffffff, "Please wait - attempting to reestablish", 23693, 158, 256);
        while(i >= 0) 
            aClass30_Sub2_Sub2_1192.method398(164);
        aClass15_1165.method238(4, 23680, super.aGraphics12, 4);
        anInt1021 = 0;
        anInt1261 = 0;
        Class24 class24 = aClass24_1168;
        aBoolean1157 = false;
        anInt1038 = 0;
        method84(aString1173, aString1174, true);
        if(!aBoolean1157)
            method44(true);
        try
        {
            class24.method267();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public final void method69(int i, boolean flag)
    {
        if(i < 0)
            return;
        if(anInt1225 != 0)
        {
            anInt1225 = 0;
            aBoolean1223 = true;
        }
        int j = anIntArray1091[i];
        int k = anIntArray1092[i];
        int l = anIntArray1093[i];
        int i1 = anIntArray1094[i];
        if(l >= 2000)
            l -= 2000;
        if(l == 582)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[i1];
            if(class30_sub2_sub4_sub1_sub1 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 57);
                aClass30_Sub2_Sub2_1192.method432(-431, anInt1285);
                aClass30_Sub2_Sub2_1192.method432(-431, i1);
                aClass30_Sub2_Sub2_1192.method431(true, anInt1283);
                aClass30_Sub2_Sub2_1192.method432(-431, anInt1284);
            }
        }
        if(l == 234)
        {
            boolean flag1 = method85(2, 0, 0, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            if(!flag1)
                flag1 = method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            anInt914 = super.anInt27;
            anInt915 = super.anInt28;
            anInt917 = 2;
            anInt916 = 0;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 236);
            aClass30_Sub2_Sub2_1192.method431(true, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method399(i1);
            aClass30_Sub2_Sub2_1192.method431(true, j + anInt1034);
        }
        if(l == 62 && method66(i1, k, j, -770))
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 192);
            aClass30_Sub2_Sub2_1192.method399(anInt1284);
            aClass30_Sub2_Sub2_1192.method431(true, i1 >> 14 & 0x7fff);
            aClass30_Sub2_Sub2_1192.method433(0, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method431(true, anInt1283);
            aClass30_Sub2_Sub2_1192.method433(0, j + anInt1034);
            aClass30_Sub2_Sub2_1192.method399(anInt1285);
        }
        if(l == 511)
        {
            boolean flag2 = method85(2, 0, 0, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            if(!flag2)
                flag2 = method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            anInt914 = super.anInt27;
            anInt915 = super.anInt28;
            anInt917 = 2;
            anInt916 = 0;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 25);
            aClass30_Sub2_Sub2_1192.method431(true, anInt1284);
            aClass30_Sub2_Sub2_1192.method432(-431, anInt1285);
            aClass30_Sub2_Sub2_1192.method399(i1);
            aClass30_Sub2_Sub2_1192.method432(-431, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method433(0, anInt1283);
            aClass30_Sub2_Sub2_1192.method399(j + anInt1034);
        }
        if(l == 74)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 122);
            aClass30_Sub2_Sub2_1192.method433(0, k);
            aClass30_Sub2_Sub2_1192.method432(-431, j);
            aClass30_Sub2_Sub2_1192.method431(true, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 315)
        {
            Class9 class9 = Class9.aClass9Array210[k];
            boolean flag8 = true;
            if(class9.anInt214 > 0)
                flag8 = method48(505, class9);
            if(flag8)
            {
                aClass30_Sub2_Sub2_1192.method397((byte)6, 185);
                aClass30_Sub2_Sub2_1192.method399(k);
            }
        }
        if(l == 561)
        {
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i1];
            if(class30_sub2_sub4_sub1_sub2 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                anInt1188 += i1;
                if(anInt1188 >= 90)
                {
                    aClass30_Sub2_Sub2_1192.method397((byte)6, 136);
                    anInt1188 = 0;
                }
                aClass30_Sub2_Sub2_1192.method397((byte)6, 128);
                aClass30_Sub2_Sub2_1192.method399(i1);
            }
        }
        if(l == 20)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[i1];
            if(class30_sub2_sub4_sub1_sub1_1 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_1)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_1)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 155);
                aClass30_Sub2_Sub2_1192.method431(true, i1);
            }
        }
        if(l == 779)
        {
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_1 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i1];
            if(class30_sub2_sub4_sub1_sub2_1 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_1)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_1)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 153);
                aClass30_Sub2_Sub2_1192.method431(true, i1);
            }
        }
        if(l == 516)
            if(!aBoolean885)
                aClass25_946.method312(false, super.anInt28 - 4, super.anInt27 - 4);
            else
                aClass25_946.method312(false, k - 4, j - 4);
        if(l == 1062)
        {
            anInt924 += anInt1034;
            if(anInt924 >= 113)
            {
                aClass30_Sub2_Sub2_1192.method397((byte)6, 183);
                aClass30_Sub2_Sub2_1192.method401(0xe63271);
                anInt924 = 0;
            }
            method66(i1, k, j, -770);
            aClass30_Sub2_Sub2_1192.method397((byte)6, 228);
            aClass30_Sub2_Sub2_1192.method432(-431, i1 >> 14 & 0x7fff);
            aClass30_Sub2_Sub2_1192.method432(-431, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method399(j + anInt1034);
        }
        if(l == 679 && !aBoolean1149)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 40);
            aClass30_Sub2_Sub2_1192.method399(k);
            aBoolean1149 = true;
        }
        if(l == 431)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 129);
            aClass30_Sub2_Sub2_1192.method432(-431, j);
            aClass30_Sub2_Sub2_1192.method399(k);
            aClass30_Sub2_Sub2_1192.method432(-431, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 337 || l == 42 || l == 792 || l == 322)
        {
            String s = aStringArray1199[i];
            int k1 = s.indexOf("@whi@");
            if(k1 != -1)
            {
                long l3 = Class50.method583(s.substring(k1 + 5).trim());
                if(l == 337)
                    method41((byte)68, l3);
                if(l == 42)
                    method113(l3, 4);
                if(l == 792)
                    method35(false, l3);
                if(l == 322)
                    method122(3, l3);
            }
        }
        if(l == 53)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 135);
            aClass30_Sub2_Sub2_1192.method431(true, j);
            aClass30_Sub2_Sub2_1192.method432(-431, k);
            aClass30_Sub2_Sub2_1192.method431(true, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 539)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 16);
            aClass30_Sub2_Sub2_1192.method432(-431, i1);
            aClass30_Sub2_Sub2_1192.method433(0, j);
            aClass30_Sub2_Sub2_1192.method433(0, k);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 484 || l == 6)
        {
            String s1 = aStringArray1199[i];
            int l1 = s1.indexOf("@whi@");
            if(l1 != -1)
            {
                s1 = s1.substring(l1 + 5).trim();
                String s7 = Class50.method587(-45804, Class50.method584(Class50.method583(s1), (byte)-99));
                boolean flag9 = false;
                for(int j3 = 0; j3 < anInt891; j3++)
                {
                    Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_7 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[anIntArray892[j3]];
                    if(class30_sub2_sub4_sub1_sub2_7 == null || class30_sub2_sub4_sub1_sub2_7.aString1703 == null || !class30_sub2_sub4_sub1_sub2_7.aString1703.equalsIgnoreCase(s7))
                        continue;
                    method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_7)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_7)).anIntArray1500[0]);
                    if(l == 484)
                    {
                        aClass30_Sub2_Sub2_1192.method397((byte)6, 139);
                        aClass30_Sub2_Sub2_1192.method431(true, anIntArray892[j3]);
                    }
                    if(l == 6)
                    {
                        anInt1188 += i1;
                        if(anInt1188 >= 90)
                        {
                            aClass30_Sub2_Sub2_1192.method397((byte)6, 136);
                            anInt1188 = 0;
                        }
                        aClass30_Sub2_Sub2_1192.method397((byte)6, 128);
                        aClass30_Sub2_Sub2_1192.method399(anIntArray892[j3]);
                    }
                    flag9 = true;
                    break;
                }

                if(!flag9)
                    method77("Unable to find " + s7, 0, "", aBoolean991);
            }
        }
        if(l == 870)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 53);
            aClass30_Sub2_Sub2_1192.method399(j);
            aClass30_Sub2_Sub2_1192.method432(-431, anInt1283);
            aClass30_Sub2_Sub2_1192.method433(0, i1);
            aClass30_Sub2_Sub2_1192.method399(anInt1284);
            aClass30_Sub2_Sub2_1192.method431(true, anInt1285);
            aClass30_Sub2_Sub2_1192.method399(k);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 847)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 87);
            aClass30_Sub2_Sub2_1192.method432(-431, i1);
            aClass30_Sub2_Sub2_1192.method399(k);
            aClass30_Sub2_Sub2_1192.method432(-431, j);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 626)
        {
            Class9 class9_1 = Class9.aClass9Array210[k];
            anInt1136 = 1;
            anInt1137 = k;
            anInt1138 = class9_1.anInt237;
            anInt1282 = 0;
            aBoolean1153 = true;
            String s4 = class9_1.aString222;
            if(s4.indexOf(" ") != -1)
                s4 = s4.substring(0, s4.indexOf(" "));
            String s8 = class9_1.aString222;
            if(s8.indexOf(" ") != -1)
                s8 = s8.substring(s8.indexOf(" ") + 1);
            aString1139 = s4 + " " + class9_1.aString218 + " " + s8;
            if(anInt1138 == 16)
            {
                aBoolean1153 = true;
                anInt1221 = 3;
                aBoolean1103 = true;
            }
            return;
        }
        if(l == 78)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 117);
            aClass30_Sub2_Sub2_1192.method433(0, k);
            aClass30_Sub2_Sub2_1192.method433(0, i1);
            aClass30_Sub2_Sub2_1192.method431(true, j);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 27)
        {
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i1];
            if(class30_sub2_sub4_sub1_sub2_2 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_2)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_2)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                anInt986 += i1;
                if(anInt986 >= 54)
                {
                    aClass30_Sub2_Sub2_1192.method397((byte)6, 189);
                    aClass30_Sub2_Sub2_1192.method398(234);
                    anInt986 = 0;
                }
                aClass30_Sub2_Sub2_1192.method397((byte)6, 73);
                aClass30_Sub2_Sub2_1192.method431(true, i1);
            }
        }
        if(l == 213)
        {
            boolean flag3 = method85(2, 0, 0, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            if(!flag3)
                flag3 = method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            anInt914 = super.anInt27;
            anInt915 = super.anInt28;
            anInt917 = 2;
            anInt916 = 0;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 79);
            aClass30_Sub2_Sub2_1192.method431(true, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method399(i1);
            aClass30_Sub2_Sub2_1192.method432(-431, j + anInt1034);
        }
        if(l == 632)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 145);
            aClass30_Sub2_Sub2_1192.method432(-431, k);
            aClass30_Sub2_Sub2_1192.method432(-431, j);
            aClass30_Sub2_Sub2_1192.method432(-431, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 493)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 75);
            aClass30_Sub2_Sub2_1192.method433(0, k);
            aClass30_Sub2_Sub2_1192.method431(true, j);
            aClass30_Sub2_Sub2_1192.method432(-431, i1);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 652)
        {
            boolean flag4 = method85(2, 0, 0, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            if(!flag4)
                flag4 = method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            anInt914 = super.anInt27;
            anInt915 = super.anInt28;
            anInt917 = 2;
            anInt916 = 0;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 156);
            aClass30_Sub2_Sub2_1192.method432(-431, j + anInt1034);
            aClass30_Sub2_Sub2_1192.method431(true, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method433(0, i1);
        }
        if(l == 94)
        {
            boolean flag5 = method85(2, 0, 0, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            if(!flag5)
                flag5 = method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            anInt914 = super.anInt27;
            anInt915 = super.anInt28;
            anInt917 = 2;
            anInt916 = 0;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 181);
            aClass30_Sub2_Sub2_1192.method431(true, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method399(i1);
            aClass30_Sub2_Sub2_1192.method431(true, j + anInt1034);
            aClass30_Sub2_Sub2_1192.method432(-431, anInt1137);
        }
        if(l == 646)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 185);
            aClass30_Sub2_Sub2_1192.method399(k);
            Class9 class9_2 = Class9.aClass9Array210[k];
            if(class9_2.anIntArrayArray226 != null && class9_2.anIntArrayArray226[0][0] == 5)
            {
                int i2 = class9_2.anIntArrayArray226[0][1];
                if(anIntArray971[i2] != class9_2.anIntArray212[0])
                {
                    anIntArray971[i2] = class9_2.anIntArray212[0];
                    method33(false, i2);
                    aBoolean1153 = true;
                }
            }
        }
        if(l == 225)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_2 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[i1];
            if(class30_sub2_sub4_sub1_sub1_2 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_2)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_2)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                anInt1226 += i1;
                if(anInt1226 >= 85)
                {
                    aClass30_Sub2_Sub2_1192.method397((byte)6, 230);
                    aClass30_Sub2_Sub2_1192.method398(239);
                    anInt1226 = 0;
                }
                aClass30_Sub2_Sub2_1192.method397((byte)6, 17);
                aClass30_Sub2_Sub2_1192.method433(0, i1);
            }
        }
        if(l == 965)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_3 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[i1];
            if(class30_sub2_sub4_sub1_sub1_3 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_3)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_3)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                anInt1134++;
                if(anInt1134 >= 96)
                {
                    aClass30_Sub2_Sub2_1192.method397((byte)6, 152);
                    aClass30_Sub2_Sub2_1192.method398(88);
                    anInt1134 = 0;
                }
                aClass30_Sub2_Sub2_1192.method397((byte)6, 21);
                aClass30_Sub2_Sub2_1192.method399(i1);
            }
        }
        if(l == 413)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_4 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[i1];
            if(class30_sub2_sub4_sub1_sub1_4 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_4)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_4)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 131);
                aClass30_Sub2_Sub2_1192.method433(0, i1);
                aClass30_Sub2_Sub2_1192.method432(-431, anInt1137);
            }
        }
        if(l == 200)
            method147(537);
        if(l == 1025)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_5 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[i1];
            if(class30_sub2_sub4_sub1_sub1_5 != null)
            {
                Class5 class5 = class30_sub2_sub4_sub1_sub1_5.aClass5_1696;
                if(class5.anIntArray88 != null)
                    class5 = class5.method161(anInt877);
                if(class5 != null)
                {
                    String s9;
                    if(class5.aByteArray89 != null)
                        s9 = new String(class5.aByteArray89);
                    else
                        s9 = "It's a " + class5.aString65 + ".";
                    method77(s9, 0, "", aBoolean991);
                }
            }
        }
        if(l == 900)
        {
            method66(i1, k, j, -770);
            aClass30_Sub2_Sub2_1192.method397((byte)6, 252);
            aClass30_Sub2_Sub2_1192.method433(0, i1 >> 14 & 0x7fff);
            aClass30_Sub2_Sub2_1192.method431(true, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method432(-431, j + anInt1034);
        }
        if(l == 412)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_6 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[i1];
            if(class30_sub2_sub4_sub1_sub1_6 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_6)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_6)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 72);
                aClass30_Sub2_Sub2_1192.method432(-431, i1);
            }
        }
        if(l == 365)
        {
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_3 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i1];
            if(class30_sub2_sub4_sub1_sub2_3 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_3)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_3)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 249);
                aClass30_Sub2_Sub2_1192.method432(-431, i1);
                aClass30_Sub2_Sub2_1192.method431(true, anInt1137);
            }
        }
        if(l == 729)
        {
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_4 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i1];
            if(class30_sub2_sub4_sub1_sub2_4 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_4)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_4)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 39);
                aClass30_Sub2_Sub2_1192.method431(true, i1);
            }
        }
        if(l == 577)
        {
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_5 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i1];
            if(class30_sub2_sub4_sub1_sub2_5 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_5)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_5)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 139);
                aClass30_Sub2_Sub2_1192.method431(true, i1);
            }
        }
        if(l == 956 && method66(i1, k, j, -770))
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 35);
            aClass30_Sub2_Sub2_1192.method431(true, j + anInt1034);
            aClass30_Sub2_Sub2_1192.method432(-431, anInt1137);
            aClass30_Sub2_Sub2_1192.method432(-431, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method431(true, i1 >> 14 & 0x7fff);
        }
        if(l == 567)
        {
            boolean flag6 = method85(2, 0, 0, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            if(!flag6)
                flag6 = method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            anInt914 = super.anInt27;
            anInt915 = super.anInt28;
            anInt917 = 2;
            anInt916 = 0;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 23);
            aClass30_Sub2_Sub2_1192.method431(true, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method431(true, i1);
            aClass30_Sub2_Sub2_1192.method431(true, j + anInt1034);
        }
        if(l == 867)
        {
            if((i1 & 3) == 0)
                anInt1175++;
            if(anInt1175 >= 59)
            {
                aClass30_Sub2_Sub2_1192.method397((byte)6, 200);
                aClass30_Sub2_Sub2_1192.method399(25501);
                anInt1175 = 0;
            }
            aClass30_Sub2_Sub2_1192.method397((byte)6, 43);
            aClass30_Sub2_Sub2_1192.method431(true, k);
            aClass30_Sub2_Sub2_1192.method432(-431, i1);
            aClass30_Sub2_Sub2_1192.method432(-431, j);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 543)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 237);
            aClass30_Sub2_Sub2_1192.method399(j);
            aClass30_Sub2_Sub2_1192.method432(-431, i1);
            aClass30_Sub2_Sub2_1192.method399(k);
            aClass30_Sub2_Sub2_1192.method432(-431, anInt1137);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 606)
        {
            String s2 = aStringArray1199[i];
            int j2 = s2.indexOf("@whi@");
            if(j2 != -1)
                if(anInt857 == -1)
                {
                    method147(537);
                    aString881 = s2.substring(j2 + 5).trim();
                    aBoolean1158 = false;
                    for(int i3 = 0; i3 < Class9.aClass9Array210.length; i3++)
                    {
                        if(Class9.aClass9Array210[i3] == null || Class9.aClass9Array210[i3].anInt214 != 600)
                            continue;
                        anInt1178 = anInt857 = Class9.aClass9Array210[i3].anInt236;
                        break;
                    }

                } else
                {
                    method77("Please close the interface you have open before using 'report abuse'", 0, "", aBoolean991);
                }
        }
        if(l == 491)
        {
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_6 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i1];
            if(class30_sub2_sub4_sub1_sub2_6 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_6)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_6)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 14);
                aClass30_Sub2_Sub2_1192.method432(-431, anInt1284);
                aClass30_Sub2_Sub2_1192.method399(i1);
                aClass30_Sub2_Sub2_1192.method399(anInt1285);
                aClass30_Sub2_Sub2_1192.method431(true, anInt1283);
            }
        }
        if(l == 639)
        {
            String s3 = aStringArray1199[i];
            int k2 = s3.indexOf("@whi@");
            if(k2 != -1)
            {
                long l4 = Class50.method583(s3.substring(k2 + 5).trim());
                int k3 = -1;
                for(int i4 = 0; i4 < anInt899; i4++)
                {
                    if(aLongArray955[i4] != l4)
                        continue;
                    k3 = i4;
                    break;
                }

                if(k3 != -1 && anIntArray826[k3] > 0)
                {
                    aBoolean1223 = true;
                    anInt1225 = 0;
                    aBoolean1256 = true;
                    aString1212 = "";
                    anInt1064 = 3;
                    aLong953 = aLongArray955[k3];
                    aString1121 = "Enter message to send to " + aStringArray1082[k3];
                }
            }
        }
        if(l == 454)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 41);
            aClass30_Sub2_Sub2_1192.method399(i1);
            aClass30_Sub2_Sub2_1192.method432(-431, j);
            aClass30_Sub2_Sub2_1192.method432(-431, k);
            anInt1243 = 0;
            anInt1244 = k;
            anInt1245 = j;
            anInt1246 = 2;
            if(Class9.aClass9Array210[k].anInt236 == anInt857)
                anInt1246 = 1;
            if(Class9.aClass9Array210[k].anInt236 == anInt1276)
                anInt1246 = 3;
        }
        if(l == 478)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_7 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[i1];
            if(class30_sub2_sub4_sub1_sub1_7 != null)
            {
                method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_7)).anIntArray1501[0], ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_7)).anIntArray1500[0]);
                anInt914 = super.anInt27;
                anInt915 = super.anInt28;
                anInt917 = 2;
                anInt916 = 0;
                if((i1 & 3) == 0)
                    anInt1155++;
                if(anInt1155 >= 53)
                {
                    aClass30_Sub2_Sub2_1192.method397((byte)6, 85);
                    aClass30_Sub2_Sub2_1192.method398(66);
                    anInt1155 = 0;
                }
                aClass30_Sub2_Sub2_1192.method397((byte)6, 18);
                aClass30_Sub2_Sub2_1192.method431(true, i1);
            }
        }
        if(l == 113)
        {
            method66(i1, k, j, -770);
            aClass30_Sub2_Sub2_1192.method397((byte)6, 70);
            aClass30_Sub2_Sub2_1192.method431(true, j + anInt1034);
            aClass30_Sub2_Sub2_1192.method399(k + anInt1035);
            aClass30_Sub2_Sub2_1192.method433(0, i1 >> 14 & 0x7fff);
        }
        if(l == 872)
        {
            method66(i1, k, j, -770);
            aClass30_Sub2_Sub2_1192.method397((byte)6, 234);
            aClass30_Sub2_Sub2_1192.method433(0, j + anInt1034);
            aClass30_Sub2_Sub2_1192.method432(-431, i1 >> 14 & 0x7fff);
            aClass30_Sub2_Sub2_1192.method433(0, k + anInt1035);
        }
        if(l == 502)
        {
            method66(i1, k, j, -770);
            aClass30_Sub2_Sub2_1192.method397((byte)6, 132);
            aClass30_Sub2_Sub2_1192.method433(0, j + anInt1034);
            aClass30_Sub2_Sub2_1192.method399(i1 >> 14 & 0x7fff);
            aClass30_Sub2_Sub2_1192.method432(-431, k + anInt1035);
        }
        if(l == 1125)
        {
            Class8 class8 = Class8.method198(i1);
            Class9 class9_4 = Class9.aClass9Array210[k];
            String s5;
            if(class9_4 != null && class9_4.anIntArray252[j] >= 0x186a0)
                s5 = class9_4.anIntArray252[j] + " x " + class8.aString170;
            else
            if(class8.aByteArray178 != null)
                s5 = new String(class8.aByteArray178);
            else
                s5 = "It's a " + class8.aString170 + ".";
            method77(s5, 0, "", aBoolean991);
        }
        if(l == 169)
        {
            aClass30_Sub2_Sub2_1192.method397((byte)6, 185);
            aClass30_Sub2_Sub2_1192.method399(k);
            Class9 class9_3 = Class9.aClass9Array210[k];
            if(class9_3.anIntArrayArray226 != null && class9_3.anIntArrayArray226[0][0] == 5)
            {
                int l2 = class9_3.anIntArrayArray226[0][1];
                anIntArray971[l2] = 1 - anIntArray971[l2];
                method33(false, l2);
                aBoolean1153 = true;
            }
        }
        if(l == 447)
        {
            anInt1282 = 1;
            anInt1283 = j;
            anInt1284 = k;
            anInt1285 = i1;
            aString1286 = Class8.method198(i1).aString170;
            anInt1136 = 0;
            aBoolean1153 = true;
            return;
        }
        if(l == 1226)
        {
            int j1 = i1 >> 14 & 0x7fff;
            Class46 class46 = Class46.method572(j1);
            String s10;
            if(class46.aByteArray777 != null)
                s10 = new String(class46.aByteArray777);
            else
                s10 = "It's a " + class46.aString739 + ".";
            method77(s10, 0, "", aBoolean991);
        }
        if(l == 244)
        {
            boolean flag7 = method85(2, 0, 0, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            if(!flag7)
                flag7 = method85(2, 0, 1, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 1, 0, k, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], false, j);
            anInt914 = super.anInt27;
            anInt915 = super.anInt28;
            anInt917 = 2;
            anInt916 = 0;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 253);
            aClass30_Sub2_Sub2_1192.method431(true, j + anInt1034);
            aClass30_Sub2_Sub2_1192.method433(0, k + anInt1035);
            aClass30_Sub2_Sub2_1192.method432(-431, i1);
        }
        if(l == 1448)
        {
            Class8 class8_1 = Class8.method198(i1);
            String s6;
            if(class8_1.aByteArray178 != null)
                s6 = new String(class8_1.aByteArray178);
            else
                s6 = "It's a " + class8_1.aString170 + ".";
            method77(s6, 0, "", aBoolean991);
        }
        anInt1282 = 0;
        if(flag)
        {
            return;
        } else
        {
            anInt1136 = 0;
            aBoolean1153 = true;
            return;
        }
    }

    public final void method70(int i)
    {
        anInt1251 = 0;
        int j = (((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 >> 7) + anInt1034;
        int k = (((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 >> 7) + anInt1035;
        i = 58 / i;
        if(j >= 3053 && j <= 3156 && k >= 3056 && k <= 3136)
            anInt1251 = 1;
        if(j >= 3072 && j <= 3118 && k >= 9492 && k <= 9535)
            anInt1251 = 1;
        if(anInt1251 == 1 && j >= 3139 && j <= 3199 && k >= 3008 && k <= 3062)
            anInt1251 = 0;
    }

    public final void run()
    {
        if(aBoolean880)
        {
            method136((byte)59);
            return;
        } else
        {
            super.run();
            return;
        }
    }

    public final void method71(int i)
    {
        if(anInt1282 == 0 && anInt1136 == 0)
        {
            aStringArray1199[anInt1133] = "Walk here";
            anIntArray1093[anInt1133] = 516;
            anIntArray1091[anInt1133] = super.anInt20;
            anIntArray1092[anInt1133] = super.anInt21;
            anInt1133++;
        }
        int j = -1;
        for(int k = 0; k < Class30_Sub2_Sub4_Sub6.anInt1687; k++)
        {
            int l = Class30_Sub2_Sub4_Sub6.anIntArray1688[k];
            int i1 = l & 0x7f;
            int j1 = l >> 7 & 0x7f;
            int k1 = l >> 29 & 3;
            int l1 = l >> 14 & 0x7fff;
            if(l == j)
                continue;
            j = l;
            if(k1 == 2 && aClass25_946.method304(anInt918, i1, j1, l) >= 0)
            {
                Class46 class46 = Class46.method572(l1);
                if(class46.anIntArray759 != null)
                    class46 = class46.method580(true);
                if(class46 == null)
                    continue;
                if(anInt1282 == 1)
                {
                    aStringArray1199[anInt1133] = "Use " + aString1286 + " with @cya@" + class46.aString739;
                    anIntArray1093[anInt1133] = 62;
                    anIntArray1094[anInt1133] = l;
                    anIntArray1091[anInt1133] = i1;
                    anIntArray1092[anInt1133] = j1;
                    anInt1133++;
                } else
                if(anInt1136 == 1)
                {
                    if((anInt1138 & 4) == 4)
                    {
                        aStringArray1199[anInt1133] = aString1139 + " @cya@" + class46.aString739;
                        anIntArray1093[anInt1133] = 956;
                        anIntArray1094[anInt1133] = l;
                        anIntArray1091[anInt1133] = i1;
                        anIntArray1092[anInt1133] = j1;
                        anInt1133++;
                    }
                } else
                {
                    if(class46.aStringArray786 != null)
                    {
                        for(int i2 = 4; i2 >= 0; i2--)
                            if(class46.aStringArray786[i2] != null)
                            {
                                aStringArray1199[anInt1133] = class46.aStringArray786[i2] + " @cya@" + class46.aString739;
                                if(i2 == 0)
                                    anIntArray1093[anInt1133] = 502;
                                if(i2 == 1)
                                    anIntArray1093[anInt1133] = 900;
                                if(i2 == 2)
                                    anIntArray1093[anInt1133] = 113;
                                if(i2 == 3)
                                    anIntArray1093[anInt1133] = 872;
                                if(i2 == 4)
                                    anIntArray1093[anInt1133] = 1062;
                                anIntArray1094[anInt1133] = l;
                                anIntArray1091[anInt1133] = i1;
                                anIntArray1092[anInt1133] = j1;
                                anInt1133++;
                            }

                    }
                    aStringArray1199[anInt1133] = "Examine @cya@" + class46.aString739;
                    anIntArray1093[anInt1133] = 1226;
                    anIntArray1094[anInt1133] = class46.anInt754 << 14;
                    anIntArray1091[anInt1133] = i1;
                    anIntArray1092[anInt1133] = j1;
                    anInt1133++;
                }
            }
            if(k1 == 1)
            {
                Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[l1];
                if(class30_sub2_sub4_sub1_sub1.aClass5_1696.aByte68 == 1 && (((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550 & 0x7f) == 64 && (((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551 & 0x7f) == 64)
                {
                    for(int j2 = 0; j2 < anInt836; j2++)
                    {
                        Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[anIntArray837[j2]];
                        if(class30_sub2_sub4_sub1_sub1_1 != null && class30_sub2_sub4_sub1_sub1_1 != class30_sub2_sub4_sub1_sub1 && class30_sub2_sub4_sub1_sub1_1.aClass5_1696.aByte68 == 1 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_1)).anInt1550 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_1)).anInt1551 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551)
                            method87(class30_sub2_sub4_sub1_sub1_1.aClass5_1696, anIntArray837[j2], false, j1, i1);
                    }

                    for(int l2 = 0; l2 < anInt891; l2++)
                    {
                        Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_1 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[anIntArray892[l2]];
                        if(class30_sub2_sub4_sub1_sub2_1 != null && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_1)).anInt1550 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_1)).anInt1551 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551)
                            method88(i1, anIntArray892[l2], class30_sub2_sub4_sub1_sub2_1, false, j1);
                    }

                }
                method87(class30_sub2_sub4_sub1_sub1.aClass5_1696, l1, false, j1, i1);
            }
            if(k1 == 0)
            {
                Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[l1];
                if((((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550 & 0x7f) == 64 && (((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551 & 0x7f) == 64)
                {
                    for(int k2 = 0; k2 < anInt836; k2++)
                    {
                        Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_2 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[anIntArray837[k2]];
                        if(class30_sub2_sub4_sub1_sub1_2 != null && class30_sub2_sub4_sub1_sub1_2.aClass5_1696.aByte68 == 1 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_2)).anInt1550 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_2)).anInt1551 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551)
                            method87(class30_sub2_sub4_sub1_sub1_2.aClass5_1696, anIntArray837[k2], false, j1, i1);
                    }

                    for(int i3 = 0; i3 < anInt891; i3++)
                    {
                        Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[anIntArray892[i3]];
                        if(class30_sub2_sub4_sub1_sub2_2 != null && class30_sub2_sub4_sub1_sub2_2 != class30_sub2_sub4_sub1_sub2 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_2)).anInt1550 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550 && ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_2)).anInt1551 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551)
                            method88(i1, anIntArray892[i3], class30_sub2_sub4_sub1_sub2_2, false, j1);
                    }

                }
                method88(i1, l1, class30_sub2_sub4_sub1_sub2, false, j1);
            }
            if(k1 == 3)
            {
                Class19 class19 = aClass19ArrayArrayArray827[anInt918][i1][j1];
                if(class19 != null)
                {
                    for(Class30_Sub2_Sub4_Sub2 class30_sub2_sub4_sub2 = (Class30_Sub2_Sub4_Sub2)class19.method253(5); class30_sub2_sub4_sub2 != null; class30_sub2_sub4_sub2 = (Class30_Sub2_Sub4_Sub2)class19.method255(8))
                    {
                        Class8 class8 = Class8.method198(class30_sub2_sub4_sub2.anInt1558);
                        if(anInt1282 == 1)
                        {
                            aStringArray1199[anInt1133] = "Use " + aString1286 + " with @lre@" + class8.aString170;
                            anIntArray1093[anInt1133] = 511;
                            anIntArray1094[anInt1133] = class30_sub2_sub4_sub2.anInt1558;
                            anIntArray1091[anInt1133] = i1;
                            anIntArray1092[anInt1133] = j1;
                            anInt1133++;
                        } else
                        if(anInt1136 == 1)
                        {
                            if((anInt1138 & 1) == 1)
                            {
                                aStringArray1199[anInt1133] = aString1139 + " @lre@" + class8.aString170;
                                anIntArray1093[anInt1133] = 94;
                                anIntArray1094[anInt1133] = class30_sub2_sub4_sub2.anInt1558;
                                anIntArray1091[anInt1133] = i1;
                                anIntArray1092[anInt1133] = j1;
                                anInt1133++;
                            }
                        } else
                        {
                            for(int j3 = 4; j3 >= 0; j3--)
                                if(class8.aStringArray168 != null && class8.aStringArray168[j3] != null)
                                {
                                    aStringArray1199[anInt1133] = class8.aStringArray168[j3] + " @lre@" + class8.aString170;
                                    if(j3 == 0)
                                        anIntArray1093[anInt1133] = 652;
                                    if(j3 == 1)
                                        anIntArray1093[anInt1133] = 567;
                                    if(j3 == 2)
                                        anIntArray1093[anInt1133] = 234;
                                    if(j3 == 3)
                                        anIntArray1093[anInt1133] = 244;
                                    if(j3 == 4)
                                        anIntArray1093[anInt1133] = 213;
                                    anIntArray1094[anInt1133] = class30_sub2_sub4_sub2.anInt1558;
                                    anIntArray1091[anInt1133] = i1;
                                    anIntArray1092[anInt1133] = j1;
                                    anInt1133++;
                                } else
                                if(j3 == 2)
                                {
                                    aStringArray1199[anInt1133] = "Take @lre@" + class8.aString170;
                                    anIntArray1093[anInt1133] = 234;
                                    anIntArray1094[anInt1133] = class30_sub2_sub4_sub2.anInt1558;
                                    anIntArray1091[anInt1133] = i1;
                                    anIntArray1092[anInt1133] = j1;
                                    anInt1133++;
                                }

                            aStringArray1199[anInt1133] = "Examine @lre@" + class8.aString170;
                            anIntArray1093[anInt1133] = 1448;
                            anIntArray1094[anInt1133] = class30_sub2_sub4_sub2.anInt1558;
                            anIntArray1091[anInt1133] = i1;
                            anIntArray1092[anInt1133] = j1;
                            anInt1133++;
                        }
                    }

                }
            }
        }

        if(i != 33660)
            opcode = aClass30_Sub2_Sub2_1083.method408();
    }

    public final void method8(int i)
    {
        signlink.reporterror = false;
        try
        {
            if(aClass24_1168 != null)
                aClass24_1168.method267();
        }
        catch(Exception _ex) { }
        aClass24_1168 = null;
        method15(860);
        if(aClass48_879 != null)
            aClass48_879.aBoolean808 = false;
        aClass48_879 = null;
        aClass42_Sub1_1068.method553();
        aClass42_Sub1_1068 = null;
        aClass30_Sub2_Sub2_834 = null;
        aClass30_Sub2_Sub2_1192 = null;
        aClass30_Sub2_Sub2_847 = null;
        aClass30_Sub2_Sub2_1083 = null;
        anIntArray1234 = null;
        aByteArrayArray1183 = null;
        aByteArrayArray1247 = null;
        anIntArray1235 = null;
        anIntArray1236 = null;
        anIntArrayArrayArray1214 = null;
        aByteArrayArrayArray1258 = null;
        aClass25_946 = null;
        aClass11Array1230 = null;
        anIntArrayArray901 = null;
        anIntArrayArray825 = null;
        anIntArray1280 = null;
        anIntArray1281 = null;
        aByteArray912 = null;
        aClass15_1163 = null;
        aClass15_1164 = null;
        aClass15_1165 = null;
        aClass15_1166 = null;
        aClass15_1123 = null;
        aClass15_1124 = null;
        aClass15_1125 = null;
        aClass15_903 = null;
        aClass15_904 = null;
        aClass15_905 = null;
        aClass15_906 = null;
        aClass15_907 = null;
        aClass15_908 = null;
        aClass15_909 = null;
        aClass15_910 = null;
        aClass15_911 = null;
        aClass30_Sub2_Sub1_Sub2_1196 = null;
        aClass30_Sub2_Sub1_Sub2_1197 = null;
        aClass30_Sub2_Sub1_Sub2_1198 = null;
        aClass30_Sub2_Sub1_Sub2_1027 = null;
        aClass30_Sub2_Sub1_Sub2_1028 = null;
        aClass30_Sub2_Sub1_Sub2_1029 = null;
        aClass30_Sub2_Sub1_Sub2Array947 = null;
        aClass30_Sub2_Sub1_Sub2_1143 = null;
        aClass30_Sub2_Sub1_Sub2_1144 = null;
        aClass30_Sub2_Sub1_Sub2_1145 = null;
        aClass30_Sub2_Sub1_Sub2_1146 = null;
        aClass30_Sub2_Sub1_Sub2_1147 = null;
        aClass30_Sub2_Sub1_Sub2_865 = null;
        aClass30_Sub2_Sub1_Sub2_866 = null;
        aClass30_Sub2_Sub1_Sub2_867 = null;
        aClass30_Sub2_Sub1_Sub2_868 = null;
        aClass30_Sub2_Sub1_Sub2_869 = null;
        aClass30_Sub2_Sub1_Sub1_1122 = null;
        aClass30_Sub2_Sub1_Sub1Array987 = null;
        aClass30_Sub2_Sub1_Sub1Array1095 = null;
        aClass30_Sub2_Sub1_Sub1Array1150 = null;
        aClass30_Sub2_Sub1_Sub1_1074 = null;
        aClass30_Sub2_Sub1_Sub1_1075 = null;
        aClass30_Sub2_Sub1_Sub1_1076 = null;
        aClass30_Sub2_Sub1_Sub1_1077 = null;
        aClass30_Sub2_Sub1_Sub1_1078 = null;
        aClass30_Sub2_Sub1_Sub2Array1060 = null;
        aClass30_Sub2_Sub1_Sub1Array1033 = null;
        anIntArrayArray929 = null;
        aClass30_Sub2_Sub4_Sub1_Sub2Array890 = null;
        anIntArray892 = null;
        anIntArray894 = null;
        aClass30_Sub2_Sub2Array895 = null;
        anIntArray840 = null;
        aClass30_Sub2_Sub4_Sub1_Sub1Array835 = null;
        anIntArray837 = null;
        aClass19ArrayArrayArray827 = null;
        aClass19_1179 = null;
        i = 55 / i;
        aClass19_1013 = null;
        aClass19_1056 = null;
        anIntArray1091 = null;
        anIntArray1092 = null;
        anIntArray1093 = null;
        anIntArray1094 = null;
        aStringArray1199 = null;
        anIntArray971 = null;
        anIntArray1072 = null;
        anIntArray1073 = null;
        aClass30_Sub2_Sub1_Sub1Array1140 = null;
        aClass30_Sub2_Sub1_Sub1_1263 = null;
        aStringArray1082 = null;
        aLongArray955 = null;
        anIntArray826 = null;
        aClass15_1110 = null;
        aClass15_1111 = null;
        aClass15_1107 = null;
        aClass15_1108 = null;
        aClass15_1109 = null;
        aClass15_1112 = null;
        aClass15_1113 = null;
        aClass15_1114 = null;
        aClass15_1115 = null;
        method118(3);
        Class46.method575(-501);
        Class5.method163(-501);
        Class8.method191(-501);
        Class22.aClass22Array388 = null;
        Class38.aClass38Array656 = null;
        Class9.aClass9Array210 = null;
        Class27.aClass27Array507 = null;
        Class20.aClass20Array351 = null;
        Class23.aClass23Array403 = null;
        Class23.aClass12_415 = null;
        Class41.aClass41Array701 = null;
        super.aClass15_13 = null;
        Class30_Sub2_Sub4_Sub1_Sub2.aClass12_1704 = null;
        Class30_Sub2_Sub1_Sub3.method363(-501);
        Class25.method273(-501);
        Class30_Sub2_Sub4_Sub6.method458(-501);
        Class36.method530(-501);
        System.gc();
    }

    public void method72(byte byte0)
    {
        System.out.println("============");
        System.out.println("flame-cycle:" + anInt1208);
        if(aClass42_Sub1_1068 != null)
            System.out.println("Od-cycle:" + aClass42_Sub1_1068.anInt1341);
        System.out.println("loop-cycle:" + anInt1161);
        System.out.println("draw-cycle:" + anInt1061);
        System.out.println("ptype:" + opcode);
        if(byte0 == 1)
            byte0 = 0;
        else
            anInt961 = 281;
        System.out.println("psize:" + anInt1007);
        if(aClass24_1168 != null)
            aClass24_1168.method272((byte)1);
        super.aBoolean9 = true;
    }

    public final Component method11(int i)
    {
        anInt1007 += i;
        if(signlink.mainapp != null)
            return signlink.mainapp;
        if(super.aFrame_Sub1_15 != null)
            return super.aFrame_Sub1_15;
        else
            return this;
    }

    public final void method73(int i)
    {
        i = 55 / i;
        do
        {
            int j = method5(-796);
            if(j == -1)
                break;
            if(anInt857 != -1 && anInt857 == anInt1178)
            {
                if(j == 8 && aString881.length() > 0)
                    aString881 = aString881.substring(0, aString881.length() - 1);
                if((j >= 97 && j <= 122 || j >= 65 && j <= 90 || j >= 48 && j <= 57 || j == 32) && aString881.length() < 12)
                    aString881 += (char)j;
            } else
            if(aBoolean1256)
            {
                if(j >= 32 && j <= 122 && aString1212.length() < 80)
                {
                    aString1212 += (char)j;
                    aBoolean1223 = true;
                }
                if(j == 8 && aString1212.length() > 0)
                {
                    aString1212 = aString1212.substring(0, aString1212.length() - 1);
                    aBoolean1223 = true;
                }
                if(j == 13 || j == 10)
                {
                    aBoolean1256 = false;
                    aBoolean1223 = true;
                    if(anInt1064 == 1)
                    {
                        long l = Class50.method583(aString1212);
                        method41((byte)68, l);
                    }
                    if(anInt1064 == 2 && anInt899 > 0)
                    {
                        long l1 = Class50.method583(aString1212);
                        method35(false, l1);
                    }
                    if(anInt1064 == 3 && aString1212.length() > 0)
                    {
                        aClass30_Sub2_Sub2_1192.method397((byte)6, 126);
                        aClass30_Sub2_Sub2_1192.method398(0);
                        int k = aClass30_Sub2_Sub2_1192.anInt1406;
                        aClass30_Sub2_Sub2_1192.method404(5, aLong953);
                        Class35.method526(aString1212, aBoolean1277, aClass30_Sub2_Sub2_1192);
                        aClass30_Sub2_Sub2_1192.method407(aClass30_Sub2_Sub2_1192.anInt1406 - k, (byte)0);
                        aString1212 = Class35.method527(aString1212, 0);
                        aString1212 = Class34.method497(aString1212, 0);
                        method77(aString1212, 6, Class50.method587(-45804, Class50.method584(aLong953, (byte)-99)), aBoolean991);
                        if(anInt845 == 2)
                        {
                            anInt845 = 1;
                            aBoolean1233 = true;
                            aClass30_Sub2_Sub2_1192.method397((byte)6, 95);
                            aClass30_Sub2_Sub2_1192.method398(anInt1287);
                            aClass30_Sub2_Sub2_1192.method398(anInt845);
                            aClass30_Sub2_Sub2_1192.method398(anInt1248);
                        }
                    }
                    if(anInt1064 == 4 && anInt822 < 100)
                    {
                        long l2 = Class50.method583(aString1212);
                        method113(l2, 4);
                    }
                    if(anInt1064 == 5 && anInt822 > 0)
                    {
                        long l3 = Class50.method583(aString1212);
                        method122(3, l3);
                    }
                }
            } else
            if(anInt1225 == 1)
            {
                if(j >= 48 && j <= 57 && aString1004.length() < 10)
                {
                    aString1004 += (char)j;
                    aBoolean1223 = true;
                }
                if(j == 8 && aString1004.length() > 0)
                {
                    aString1004 = aString1004.substring(0, aString1004.length() - 1);
                    aBoolean1223 = true;
                }
                if(j == 13 || j == 10)
                {
                    if(aString1004.length() > 0)
                    {
                        int i1 = 0;
                        try
                        {
                            i1 = Integer.parseInt(aString1004);
                        }
                        catch(Exception _ex) { }
                        aClass30_Sub2_Sub2_1192.method397((byte)6, 208);
                        aClass30_Sub2_Sub2_1192.method402(i1);
                    }
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
            } else
            if(anInt1225 == 2)
            {
                if(j >= 32 && j <= 122 && aString1004.length() < 12)
                {
                    aString1004 += (char)j;
                    aBoolean1223 = true;
                }
                if(j == 8 && aString1004.length() > 0)
                {
                    aString1004 = aString1004.substring(0, aString1004.length() - 1);
                    aBoolean1223 = true;
                }
                if(j == 13 || j == 10)
                {
                    if(aString1004.length() > 0)
                    {
                        aClass30_Sub2_Sub2_1192.method397((byte)6, 60);
                        aClass30_Sub2_Sub2_1192.method404(5, Class50.method583(aString1004));
                    }
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
            } else
            if(anInt1276 == -1)
            {
                if(j >= 32 && j <= 122 && aString887.length() < 80)
                {
                    aString887 += (char)j;
                    aBoolean1223 = true;
                }
                if(j == 8 && aString887.length() > 0)
                {
                    aString887 = aString887.substring(0, aString887.length() - 1);
                    aBoolean1223 = true;
                }
                if((j == 13 || j == 10) && aString887.length() > 0)
                {
                    if(anInt863 == 2)
                    {
                        if(aString887.equals("::clientdrop"))
                            method68(-670);
                        if(aString887.equals("::lag"))
                            method72((byte)1);
                        if(aString887.equals("::prefetchmusic"))
                        {
                            for(int j1 = 0; j1 < aClass42_Sub1_1068.method555(79, 2); j1++)
                                aClass42_Sub1_1068.method563((byte)1, 2, j1, (byte)8);

                        }
                        if(aString887.equals("::fpson"))
                            aBoolean1156 = true;
                        if(aString887.equals("::fpsoff"))
                            aBoolean1156 = false;
                        if(aString887.equals("::noclip"))
                        {
                            for(int k1 = 0; k1 < 4; k1++)
                            {
                                for(int i2 = 1; i2 < 103; i2++)
                                {
                                    for(int k2 = 1; k2 < 103; k2++)
                                        aClass11Array1230[k1].anIntArrayArray294[i2][k2] = 0;

                                }

                            }

                        }
                    }
                    if(aString887.startsWith("::"))
                    {
                        aClass30_Sub2_Sub2_1192.method397((byte)6, 103);
                        aClass30_Sub2_Sub2_1192.method398(aString887.length() - 1);
                        aClass30_Sub2_Sub2_1192.method405(aString887.substring(2));
                    } else
                    {
                        String s = aString887.toLowerCase();
                        int j2 = 0;
                        if(s.startsWith("yellow:"))
                        {
                            j2 = 0;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("red:"))
                        {
                            j2 = 1;
                            aString887 = aString887.substring(4);
                        } else
                        if(s.startsWith("green:"))
                        {
                            j2 = 2;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("cyan:"))
                        {
                            j2 = 3;
                            aString887 = aString887.substring(5);
                        } else
                        if(s.startsWith("purple:"))
                        {
                            j2 = 4;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("white:"))
                        {
                            j2 = 5;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("flash1:"))
                        {
                            j2 = 6;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("flash2:"))
                        {
                            j2 = 7;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("flash3:"))
                        {
                            j2 = 8;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("glow1:"))
                        {
                            j2 = 9;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("glow2:"))
                        {
                            j2 = 10;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("glow3:"))
                        {
                            j2 = 11;
                            aString887 = aString887.substring(6);
                        }
                        s = aString887.toLowerCase();
                        int i3 = 0;
                        if(s.startsWith("wave:"))
                        {
                            i3 = 1;
                            aString887 = aString887.substring(5);
                        } else
                        if(s.startsWith("wave2:"))
                        {
                            i3 = 2;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("shake:"))
                        {
                            i3 = 3;
                            aString887 = aString887.substring(6);
                        } else
                        if(s.startsWith("scroll:"))
                        {
                            i3 = 4;
                            aString887 = aString887.substring(7);
                        } else
                        if(s.startsWith("slide:"))
                        {
                            i3 = 5;
                            aString887 = aString887.substring(6);
                        }
                        aClass30_Sub2_Sub2_1192.method397((byte)6, 4);
                        aClass30_Sub2_Sub2_1192.method398(0);
                        int j3 = aClass30_Sub2_Sub2_1192.anInt1406;
                        aClass30_Sub2_Sub2_1192.method425(301, i3);
                        aClass30_Sub2_Sub2_1192.method425(301, j2);
                        aClass30_Sub2_Sub2_834.anInt1406 = 0;
                        Class35.method526(aString887, aBoolean1277, aClass30_Sub2_Sub2_834);
                        aClass30_Sub2_Sub2_1192.method441(0, aByte1217, aClass30_Sub2_Sub2_834.aByteArray1405, aClass30_Sub2_Sub2_834.anInt1406);
                        aClass30_Sub2_Sub2_1192.method407(aClass30_Sub2_Sub2_1192.anInt1406 - j3, (byte)0);
                        aString887 = Class35.method527(aString887, 0);
                        aString887 = Class34.method497(aString887, 0);
                        aClass30_Sub2_Sub4_Sub1_Sub2_1126.aString1506 = aString887;
                        aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1513 = j2;
                        aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1531 = i3;
                        aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1535 = 150;
                        if(anInt863 == 2)
                            method77(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).aString1506, 2, "@cr2@" + aClass30_Sub2_Sub4_Sub1_Sub2_1126.aString1703, aBoolean991);
                        else
                        if(anInt863 == 1)
                            method77(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).aString1506, 2, "@cr1@" + aClass30_Sub2_Sub4_Sub1_Sub2_1126.aString1703, aBoolean991);
                        else
                            method77(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).aString1506, 2, aClass30_Sub2_Sub4_Sub1_Sub2_1126.aString1703, aBoolean991);
                        if(anInt1287 == 2)
                        {
                            anInt1287 = 3;
                            aBoolean1233 = true;
                            aClass30_Sub2_Sub2_1192.method397((byte)6, 95);
                            aClass30_Sub2_Sub2_1192.method398(anInt1287);
                            aClass30_Sub2_Sub2_1192.method398(anInt845);
                            aClass30_Sub2_Sub2_1192.method398(anInt1248);
                        }
                    }
                    aString887 = "";
                    aBoolean1223 = true;
                }
            }
        } while(true);
    }

    public final void method74(int i, int j, int k)
    {
        if(k != anInt838)
            anInt838 = aClass17_1000.method246();
        int l = 0;
        for(int i1 = 0; i1 < 100; i1++)
        {
            if(aStringArray944[i1] == null)
                continue;
            int j1 = anIntArray942[i1];
            int k1 = (70 - l * 14) + anInt1089 + 4;
            if(k1 < -20)
                break;
            String s = aStringArray943[i1];
            boolean flag = false;
            if(s != null && s.startsWith("@cr1@"))
            {
                s = s.substring(5);
                boolean flag1 = true;
            }
            if(s != null && s.startsWith("@cr2@"))
            {
                s = s.substring(5);
                byte byte0 = 2;
            }
            if(j1 == 0)
                l++;
            if((j1 == 1 || j1 == 2) && (j1 == 1 || anInt1287 == 0 || anInt1287 == 1 && method109(false, s)))
            {
                if(j > k1 - 14 && j <= k1 && !s.equals(aClass30_Sub2_Sub4_Sub1_Sub2_1126.aString1703))
                {
                    if(anInt863 >= 1)
                    {
                        aStringArray1199[anInt1133] = "Report abuse @whi@" + s;
                        anIntArray1093[anInt1133] = 606;
                        anInt1133++;
                    }
                    aStringArray1199[anInt1133] = "Add ignore @whi@" + s;
                    anIntArray1093[anInt1133] = 42;
                    anInt1133++;
                    aStringArray1199[anInt1133] = "Add friend @whi@" + s;
                    anIntArray1093[anInt1133] = 337;
                    anInt1133++;
                }
                l++;
            }
            if((j1 == 3 || j1 == 7) && anInt1195 == 0 && (j1 == 7 || anInt845 == 0 || anInt845 == 1 && method109(false, s)))
            {
                if(j > k1 - 14 && j <= k1)
                {
                    if(anInt863 >= 1)
                    {
                        aStringArray1199[anInt1133] = "Report abuse @whi@" + s;
                        anIntArray1093[anInt1133] = 606;
                        anInt1133++;
                    }
                    aStringArray1199[anInt1133] = "Add ignore @whi@" + s;
                    anIntArray1093[anInt1133] = 42;
                    anInt1133++;
                    aStringArray1199[anInt1133] = "Add friend @whi@" + s;
                    anIntArray1093[anInt1133] = 337;
                    anInt1133++;
                }
                l++;
            }
            if(j1 == 4 && (anInt1248 == 0 || anInt1248 == 1 && method109(false, s)))
            {
                if(j > k1 - 14 && j <= k1)
                {
                    aStringArray1199[anInt1133] = "Accept trade @whi@" + s;
                    anIntArray1093[anInt1133] = 484;
                    anInt1133++;
                }
                l++;
            }
            if((j1 == 5 || j1 == 6) && anInt1195 == 0 && anInt845 < 2)
                l++;
            if(j1 == 8 && (anInt1248 == 0 || anInt1248 == 1 && method109(false, s)))
            {
                if(j > k1 - 14 && j <= k1)
                {
                    aStringArray1199[anInt1133] = "Accept challenge @whi@" + s;
                    anIntArray1093[anInt1133] = 6;
                    anInt1133++;
                }
                l++;
            }
        }

    }

    public final void method75(int i, Class9 class9)
    {
        int j = class9.anInt214;
        if(i <= 0)
            aClass30_Sub2_Sub2_1192.method398(49);
        if(j >= 1 && j <= 100 || j >= 701 && j <= 800)
        {
            if(j == 1 && anInt900 == 0)
            {
                class9.aString248 = "Loading friend list";
                class9.anInt217 = 0;
                return;
            }
            if(j == 1 && anInt900 == 1)
            {
                class9.aString248 = "Connecting to friendserver";
                class9.anInt217 = 0;
                return;
            }
            if(j == 2 && anInt900 != 2)
            {
                class9.aString248 = "Please wait...";
                class9.anInt217 = 0;
                return;
            }
            int k = anInt899;
            if(anInt900 != 2)
                k = 0;
            if(j > 700)
                j -= 601;
            else
                j--;
            if(j >= k)
            {
                class9.aString248 = "";
                class9.anInt217 = 0;
                return;
            } else
            {
                class9.aString248 = aStringArray1082[j];
                class9.anInt217 = 1;
                return;
            }
        }
        if(j >= 101 && j <= 200 || j >= 801 && j <= 900)
        {
            int l = anInt899;
            if(anInt900 != 2)
                l = 0;
            if(j > 800)
                j -= 701;
            else
                j -= 101;
            if(j >= l)
            {
                class9.aString248 = "";
                class9.anInt217 = 0;
                return;
            }
            if(anIntArray826[j] == 0)
                class9.aString248 = "@red@Offline";
            else
            if(anIntArray826[j] == anInt957)
                class9.aString248 = "@gre@World-" + (anIntArray826[j] - 9);
            else
                class9.aString248 = "@yel@World-" + (anIntArray826[j] - 9);
            class9.anInt217 = 1;
            return;
        }
        if(j == 203)
        {
            int i1 = anInt899;
            if(anInt900 != 2)
                i1 = 0;
            class9.anInt261 = i1 * 15 + 20;
            if(class9.anInt261 <= class9.anInt267)
                class9.anInt261 = class9.anInt267 + 1;
            return;
        }
        if(j >= 401 && j <= 500)
        {
            if((j -= 401) == 0 && anInt900 == 0)
            {
                class9.aString248 = "Loading ignore list";
                class9.anInt217 = 0;
                return;
            }
            if(j == 1 && anInt900 == 0)
            {
                class9.aString248 = "Please wait...";
                class9.anInt217 = 0;
                return;
            }
            int j1 = anInt822;
            if(anInt900 == 0)
                j1 = 0;
            if(j >= j1)
            {
                class9.aString248 = "";
                class9.anInt217 = 0;
                return;
            } else
            {
                class9.aString248 = Class50.method587(-45804, Class50.method584(aLongArray925[j], (byte)-99));
                class9.anInt217 = 1;
                return;
            }
        }
        if(j == 503)
        {
            class9.anInt261 = anInt822 * 15 + 20;
            if(class9.anInt261 <= class9.anInt267)
                class9.anInt261 = class9.anInt267 + 1;
            return;
        }
        if(j == 327)
        {
            class9.anInt270 = 150;
            class9.anInt271 = (int)(Math.sin((double)anInt1161 / 40D) * 256D) & 0x7ff;
            if(aBoolean1031)
            {
                for(int k1 = 0; k1 < 7; k1++)
                {
                    int l1 = anIntArray1065[k1];
                    if(l1 >= 0 && !Class38.aClass38Array656[l1].method537((byte)2))
                        return;
                }

                aBoolean1031 = false;
                Class30_Sub2_Sub4_Sub6 aclass30_sub2_sub4_sub6[] = new Class30_Sub2_Sub4_Sub6[7];
                int i2 = 0;
                for(int j2 = 0; j2 < 7; j2++)
                {
                    int k2 = anIntArray1065[j2];
                    if(k2 >= 0)
                        aclass30_sub2_sub4_sub6[i2++] = Class38.aClass38Array656[k2].method538(false);
                }

                Class30_Sub2_Sub4_Sub6 class30_sub2_sub4_sub6 = new Class30_Sub2_Sub4_Sub6(i2, aclass30_sub2_sub4_sub6, -38);
                for(int l2 = 0; l2 < 5; l2++)
                    if(anIntArray990[l2] != 0)
                    {
                        class30_sub2_sub4_sub6.method476(anIntArrayArray1003[l2][0], anIntArrayArray1003[l2][anIntArray990[l2]]);
                        if(l2 == 1)
                            class30_sub2_sub4_sub6.method476(anIntArray1204[0], anIntArray1204[anIntArray990[l2]]);
                    }

                class30_sub2_sub4_sub6.method469((byte)-71);
                class30_sub2_sub4_sub6.method470(Class20.aClass20Array351[((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1511].anIntArray353[0], 40542);
                class30_sub2_sub4_sub6.method479(64, 850, -30, -50, -30, true);
                class9.anInt233 = 5;
                class9.anInt234 = 0;
                Class9.method208(0, aBoolean994, 5, class30_sub2_sub4_sub6);
            }
            return;
        }
        if(j == 324)
        {
            if(aClass30_Sub2_Sub1_Sub1_931 == null)
            {
                aClass30_Sub2_Sub1_Sub1_931 = class9.aClass30_Sub2_Sub1_Sub1_207;
                aClass30_Sub2_Sub1_Sub1_932 = class9.aClass30_Sub2_Sub1_Sub1_260;
            }
            if(aBoolean1047)
            {
                class9.aClass30_Sub2_Sub1_Sub1_207 = aClass30_Sub2_Sub1_Sub1_932;
                return;
            } else
            {
                class9.aClass30_Sub2_Sub1_Sub1_207 = aClass30_Sub2_Sub1_Sub1_931;
                return;
            }
        }
        if(j == 325)
        {
            if(aClass30_Sub2_Sub1_Sub1_931 == null)
            {
                aClass30_Sub2_Sub1_Sub1_931 = class9.aClass30_Sub2_Sub1_Sub1_207;
                aClass30_Sub2_Sub1_Sub1_932 = class9.aClass30_Sub2_Sub1_Sub1_260;
            }
            if(aBoolean1047)
            {
                class9.aClass30_Sub2_Sub1_Sub1_207 = aClass30_Sub2_Sub1_Sub1_931;
                return;
            } else
            {
                class9.aClass30_Sub2_Sub1_Sub1_207 = aClass30_Sub2_Sub1_Sub1_932;
                return;
            }
        }
        if(j == 600)
        {
            class9.aString248 = aString881;
            if(anInt1161 % 20 < 10)
            {
                class9.aString248 += "|";
                return;
            } else
            {
                class9.aString248 += " ";
                return;
            }
        }
        if(j == 613)
            if(anInt863 >= 1)
            {
                if(aBoolean1158)
                {
                    class9.anInt232 = 0xff0000;
                    class9.aString248 = "Moderator option: Mute player for 48 hours: <ON>";
                } else
                {
                    class9.anInt232 = 0xffffff;
                    class9.aString248 = "Moderator option: Mute player for 48 hours: <OFF>";
                }
            } else
            {
                class9.aString248 = "";
            }
        if(j == 650 || j == 655)
            if(anInt1193 != 0)
            {
                String s;
                if(anInt1006 == 0)
                    s = "earlier today";
                else
                if(anInt1006 == 1)
                    s = "yesterday";
                else
                    s = anInt1006 + " days ago";
                class9.aString248 = "You last logged in " + s + " from: " + signlink.dns;
            } else
            {
                class9.aString248 = "";
            }
        if(j == 651)
        {
            if(anInt1154 == 0)
            {
                class9.aString248 = "0 unread messages";
                class9.anInt232 = 0xffff00;
            }
            if(anInt1154 == 1)
            {
                class9.aString248 = "1 unread message";
                class9.anInt232 = 65280;
            }
            if(anInt1154 > 1)
            {
                class9.aString248 = anInt1154 + " unread messages";
                class9.anInt232 = 65280;
            }
        }
        if(j == 652)
            if(anInt1167 == 201)
            {
                if(anInt1120 == 1)
                    class9.aString248 = "@yel@This is a non-members world: @whi@Since you are a member we";
                else
                    class9.aString248 = "";
            } else
            if(anInt1167 == 200)
            {
                class9.aString248 = "You have not yet set any password recovery questions.";
            } else
            {
                String s1;
                if(anInt1167 == 0)
                    s1 = "Earlier today";
                else
                if(anInt1167 == 1)
                    s1 = "Yesterday";
                else
                    s1 = anInt1167 + " days ago";
                class9.aString248 = s1 + " you changed your recovery questions";
            }
        if(j == 653)
            if(anInt1167 == 201)
            {
                if(anInt1120 == 1)
                    class9.aString248 = "@whi@recommend you use a members world instead. You may use";
                else
                    class9.aString248 = "";
            } else
            if(anInt1167 == 200)
                class9.aString248 = "We strongly recommend you do so now to secure your account.";
            else
                class9.aString248 = "If you do not remember making this change then cancel it immediately";
        if(j == 654)
        {
            if(anInt1167 == 201)
                if(anInt1120 == 1)
                {
                    class9.aString248 = "@whi@this world but member benefits are unavailable whilst here.";
                    return;
                } else
                {
                    class9.aString248 = "";
                    return;
                }
            if(anInt1167 == 200)
            {
                class9.aString248 = "Do this from the 'account management' area on our front webpage";
                return;
            }
            class9.aString248 = "Do this from the 'account management' area on our front webpage";
        }
    }

    public final void method76(byte byte0)
    {
        if(anInt1195 == 0)
            return;
        Class30_Sub2_Sub1_Sub4 class30_sub2_sub1_sub4 = aClass30_Sub2_Sub1_Sub4_1271;
        if(byte0 != aByte1274)
            aBoolean1231 = !aBoolean1231;
        int i = 0;
        if(anInt1104 != 0)
            i = 1;
        for(int j = 0; j < 100; j++)
            if(aStringArray944[j] != null)
            {
                int k = anIntArray942[j];
                String s = aStringArray943[j];
                byte byte1 = 0;
                if(s != null && s.startsWith("@cr1@"))
                {
                    s = s.substring(5);
                    byte1 = 1;
                }
                if(s != null && s.startsWith("@cr2@"))
                {
                    s = s.substring(5);
                    byte1 = 2;
                }
                if((k == 3 || k == 7) && (k == 7 || anInt845 == 0 || anInt845 == 1 && method109(false, s)))
                {
                    int l = 329 - i * 13;
                    int k1 = 4;
                    class30_sub2_sub1_sub4.method385(0, "From", l, 822, k1);
                    class30_sub2_sub1_sub4.method385(65535, "From", l - 1, 822, k1);
                    k1 += class30_sub2_sub1_sub4.method383(anInt1116, "From ");
                    if(byte1 == 1)
                    {
                        aClass30_Sub2_Sub1_Sub2Array1219[0].method361(k1, 16083, l - 12);
                        k1 += 14;
                    }
                    if(byte1 == 2)
                    {
                        aClass30_Sub2_Sub1_Sub2Array1219[1].method361(k1, 16083, l - 12);
                        k1 += 14;
                    }
                    class30_sub2_sub1_sub4.method385(0, s + ": " + aStringArray944[j], l, 822, k1);
                    class30_sub2_sub1_sub4.method385(65535, s + ": " + aStringArray944[j], l - 1, 822, k1);
                    if(++i >= 5)
                        return;
                }
                if(k == 5 && anInt845 < 2)
                {
                    int i1 = 329 - i * 13;
                    class30_sub2_sub1_sub4.method385(0, aStringArray944[j], i1, 822, 4);
                    class30_sub2_sub1_sub4.method385(65535, aStringArray944[j], i1 - 1, 822, 4);
                    if(++i >= 5)
                        return;
                }
                if(k == 6 && anInt845 < 2)
                {
                    int j1 = 329 - i * 13;
                    class30_sub2_sub1_sub4.method385(0, "To " + s + ": " + aStringArray944[j], j1, 822, 4);
                    class30_sub2_sub1_sub4.method385(65535, "To " + s + ": " + aStringArray944[j], j1 - 1, 822, 4);
                    if(++i >= 5)
                        return;
                }
            }

    }

    public final void method77(String s, int i, String s1, boolean flag)
    {
        if(flag)
            return;
        if(i == 0 && anInt1042 != -1)
        {
            aString844 = s;
            super.anInt26 = 0;
        }
        if(anInt1276 == -1)
            aBoolean1223 = true;
        for(int j = 99; j > 0; j--)
        {
            anIntArray942[j] = anIntArray942[j - 1];
            aStringArray943[j] = aStringArray943[j - 1];
            aStringArray944[j] = aStringArray944[j - 1];
        }

        anIntArray942[0] = i;
        aStringArray943[0] = s1;
        aStringArray944[0] = s;
    }

    public final void method78(int i)
    {
        i = 72 / i;
        if(super.anInt26 == 1)
        {
            if(super.anInt27 >= 539 && super.anInt27 <= 573 && super.anInt28 >= 169 && super.anInt28 < 205 && anIntArray1130[0] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 0;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 569 && super.anInt27 <= 599 && super.anInt28 >= 168 && super.anInt28 < 205 && anIntArray1130[1] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 1;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 597 && super.anInt27 <= 627 && super.anInt28 >= 168 && super.anInt28 < 205 && anIntArray1130[2] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 2;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 625 && super.anInt27 <= 669 && super.anInt28 >= 168 && super.anInt28 < 203 && anIntArray1130[3] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 3;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 666 && super.anInt27 <= 696 && super.anInt28 >= 168 && super.anInt28 < 205 && anIntArray1130[4] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 4;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 694 && super.anInt27 <= 724 && super.anInt28 >= 168 && super.anInt28 < 205 && anIntArray1130[5] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 5;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 722 && super.anInt27 <= 756 && super.anInt28 >= 169 && super.anInt28 < 205 && anIntArray1130[6] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 6;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 540 && super.anInt27 <= 574 && super.anInt28 >= 466 && super.anInt28 < 502 && anIntArray1130[7] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 7;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 572 && super.anInt27 <= 602 && super.anInt28 >= 466 && super.anInt28 < 503 && anIntArray1130[8] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 8;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 599 && super.anInt27 <= 629 && super.anInt28 >= 466 && super.anInt28 < 503 && anIntArray1130[9] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 9;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 627 && super.anInt27 <= 671 && super.anInt28 >= 467 && super.anInt28 < 502 && anIntArray1130[10] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 10;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 669 && super.anInt27 <= 699 && super.anInt28 >= 466 && super.anInt28 < 503 && anIntArray1130[11] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 11;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 696 && super.anInt27 <= 726 && super.anInt28 >= 466 && super.anInt28 < 503 && anIntArray1130[12] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 12;
                aBoolean1103 = true;
            }
            if(super.anInt27 >= 724 && super.anInt27 <= 758 && super.anInt28 >= 466 && super.anInt28 < 502 && anIntArray1130[13] != -1)
            {
                aBoolean1153 = true;
                anInt1221 = 13;
                aBoolean1103 = true;
            }
        }
    }

    public final void method79(int i)
    {
        if(aClass15_1166 != null)
            return;
        method118(3);
        super.aClass15_13 = null;
        aClass15_1107 = null;
        aClass15_1108 = null;
        aClass15_1109 = null;
        aClass15_1110 = null;
        aClass15_1111 = null;
        aClass15_1112 = null;
        aClass15_1113 = null;
        aClass15_1114 = null;
        aClass15_1115 = null;
        aClass15_1166 = new Class15(479, 96, method11(0), 0);
        aClass15_1164 = new Class15(172, 156, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass30_Sub2_Sub1_Sub2_1197.method361(0, 16083, 0);
        aClass15_1163 = new Class15(190, 261, method11(0), 0);
        aClass15_1165 = new Class15(512, 334, method11(0), 0);
        Class30_Sub2_Sub1.method334(aBoolean1206);
        aClass15_1123 = new Class15(496, 50, method11(0), 0);
        if(i != 1)
            method6();
        aClass15_1124 = new Class15(269, 37, method11(0), 0);
        aClass15_1125 = new Class15(249, 45, method11(0), 0);
        aBoolean1255 = true;
    }

    public final String method80(boolean flag)
    {
        aBoolean1157 &= flag;
        if(signlink.mainapp != null)
            return signlink.mainapp.getDocumentBase().getHost().toLowerCase();
        if(super.aFrame_Sub1_15 != null)
            return "runescape.com";
        else
            return super.getDocumentBase().getHost().toLowerCase();
    }

    public final void method81(Class30_Sub2_Sub1_Sub1 class30_sub2_sub1_sub1, int i, int j, int k)
    {
        int l = k * k + j * j;
        if(i >= 0)
            method6();
        if(l > 4225 && l < 0x15f90)
        {
            int i1 = anInt1185 + anInt1209 & 0x7ff;
            int j1 = Class30_Sub2_Sub4_Sub6.anIntArray1689[i1];
            int k1 = Class30_Sub2_Sub4_Sub6.anIntArray1690[i1];
            j1 = (j1 * 256) / (anInt1170 + 256);
            k1 = (k1 * 256) / (anInt1170 + 256);
            int l1 = j * j1 + k * k1 >> 16;
            int i2 = j * k1 - k * j1 >> 16;
            double d = Math.atan2(l1, i2);
            int j2 = (int)(Math.sin(d) * 63D);
            int k2 = (int)(Math.cos(d) * 57D);
            aClass30_Sub2_Sub1_Sub1_1001.method353(83 - k2 - 20, 15, 20, 15, 41960, 256, 20, d, (94 + j2 + 4) - 10);
            return;
        } else
        {
            method141(class30_sub2_sub1_sub1, k, j, false);
            return;
        }
    }

    public final void method82(int i)
    {
        if(anInt1086 != 0)
            return;
        aStringArray1199[0] = "Cancel";
        anIntArray1093[0] = 1107;
        anInt1133 = 1;
        method129(false);
        anInt886 = 0;
        if(super.anInt20 > 4 && super.anInt21 > 4 && super.anInt20 < 516 && super.anInt21 < 338)
            if(anInt857 != -1)
                method29(4, 13037, Class9.aClass9Array210[anInt857], super.anInt20, 4, super.anInt21, 0);
            else
                method71(33660);
        if(anInt886 != anInt1026)
            anInt1026 = anInt886;
        anInt886 = 0;
        if(super.anInt20 > 553 && super.anInt21 > 205 && super.anInt20 < 743 && super.anInt21 < 466)
            if(anInt1189 != -1)
                method29(553, 13037, Class9.aClass9Array210[anInt1189], super.anInt20, 205, super.anInt21, 0);
            else
            if(anIntArray1130[anInt1221] != -1)
                method29(553, 13037, Class9.aClass9Array210[anIntArray1130[anInt1221]], super.anInt20, 205, super.anInt21, 0);
        if(anInt886 != anInt1048)
        {
            aBoolean1153 = true;
            anInt1048 = anInt886;
        }
        anInt886 = 0;
        if(super.anInt20 > 17 && super.anInt21 > 357 && super.anInt20 < 496 && super.anInt21 < 453)
            if(anInt1276 != -1)
                method29(17, 13037, Class9.aClass9Array210[anInt1276], super.anInt20, 357, super.anInt21, 0);
            else
            if(super.anInt21 < 434 && super.anInt20 < 426)
                method74(super.anInt20 - 17, super.anInt21 - 357, 9);
        if(anInt1276 != -1 && anInt886 != anInt1039)
        {
            aBoolean1223 = true;
            anInt1039 = anInt886;
        }
        boolean flag = false;
        anInt1007 += i;
        while(!flag) 
        {
            flag = true;
            for(int j = 0; j < anInt1133 - 1; j++)
                if(anIntArray1093[j] < 1000 && anIntArray1093[j + 1] > 1000)
                {
                    String s = aStringArray1199[j];
                    aStringArray1199[j] = aStringArray1199[j + 1];
                    aStringArray1199[j + 1] = s;
                    int k = anIntArray1093[j];
                    anIntArray1093[j] = anIntArray1093[j + 1];
                    anIntArray1093[j + 1] = k;
                    k = anIntArray1091[j];
                    anIntArray1091[j] = anIntArray1091[j + 1];
                    anIntArray1091[j + 1] = k;
                    k = anIntArray1092[j];
                    anIntArray1092[j] = anIntArray1092[j + 1];
                    anIntArray1092[j + 1] = k;
                    k = anIntArray1094[j];
                    anIntArray1094[j] = anIntArray1094[j + 1];
                    anIntArray1094[j + 1] = k;
                    flag = false;
                }

        }
    }

    public final int method83(boolean flag, int i, int j, int k)
    {
        if(!flag)
            aClass19ArrayArrayArray827 = null;
        int l = 256 - k;
        return ((i & 0xff00ff) * l + (j & 0xff00ff) * k & 0xff00ff00) + ((i & 0xff00) * l + (j & 0xff00) * k & 0xff0000) >> 8;
    }

    public final void method84(String s, String s1, boolean flag)
    {
        signlink.errorname = s;
        try
        {
            if(!flag)
            {
                aString1266 = "";
                aString1267 = "Connecting to server...";
                method135(true, false);
            }
            aClass24_1168 = new Class24(this, -978, method19(43594 + anInt958));
            long l = Class50.method583(s);
            int i = (int)(l >> 16 & 31L);
            aClass30_Sub2_Sub2_1192.anInt1406 = 0;
            aClass30_Sub2_Sub2_1192.method398(14);
            aClass30_Sub2_Sub2_1192.method398(i);
            aClass24_1168.method271(2, 0, aClass30_Sub2_Sub2_1192.aByteArray1405, 0);
            for(int j = 0; j < 8; j++)
                aClass24_1168.method268();

            int k = aClass24_1168.method268();
            int i1 = k;
            if(k == 0)
            {
                aClass24_1168.method270(aClass30_Sub2_Sub2_1083.aByteArray1405, 0, 8);
                aClass30_Sub2_Sub2_1083.anInt1406 = 0;
                aLong1215 = aClass30_Sub2_Sub2_1083.method414(-35089);
                int ai[] = new int[4];
                ai[0] = (int)(Math.random() * 99999999D);
                ai[1] = (int)(Math.random() * 99999999D);
                ai[2] = (int)(aLong1215 >> 32);
                ai[3] = (int)aLong1215;
                aClass30_Sub2_Sub2_1192.anInt1406 = 0;
                aClass30_Sub2_Sub2_1192.method398(10);
                aClass30_Sub2_Sub2_1192.method402(ai[0]);
                aClass30_Sub2_Sub2_1192.method402(ai[1]);
                aClass30_Sub2_Sub2_1192.method402(ai[2]);
                aClass30_Sub2_Sub2_1192.method402(ai[3]);
                aClass30_Sub2_Sub2_1192.method402(signlink.uid);
                aClass30_Sub2_Sub2_1192.method405(s);
                aClass30_Sub2_Sub2_1192.method405(s1);
                aClass30_Sub2_Sub2_1192.method423(aBigInteger1032, aBigInteger856, (byte)0);
                aClass30_Sub2_Sub2_847.anInt1406 = 0;
                if(flag)
                    aClass30_Sub2_Sub2_847.method398(18);
                else
                    aClass30_Sub2_Sub2_847.method398(16);
                aClass30_Sub2_Sub2_847.method398(aClass30_Sub2_Sub2_1192.anInt1406 + 36 + 1 + 1 + 2);
                aClass30_Sub2_Sub2_847.method398(255);
                aClass30_Sub2_Sub2_847.method399(317);
                aClass30_Sub2_Sub2_847.method398(aBoolean960 ? 1 : 0);
                for(int l1 = 0; l1 < 9; l1++)
                    aClass30_Sub2_Sub2_847.method402(anIntArray1090[l1]);

                aClass30_Sub2_Sub2_847.method406(aClass30_Sub2_Sub2_1192.aByteArray1405, aClass30_Sub2_Sub2_1192.anInt1406, true, 0);
                aClass30_Sub2_Sub2_1192.aClass17_1410 = new Class17(-436, ai);
                for(int j2 = 0; j2 < 4; j2++)
                    ai[j2] += 50;

                aClass17_1000 = new Class17(-436, ai);
                aClass24_1168.method271(aClass30_Sub2_Sub2_847.anInt1406, 0, aClass30_Sub2_Sub2_847.aByteArray1405, 0);
                k = aClass24_1168.method268();
            }
            if(k == 1)
            {
                try
                {
                    Thread.sleep(2000L);
                }
                catch(Exception _ex) { }
                method84(s, s1, flag);
                return;
            }
            if(k == 2)
            {
                anInt863 = aClass24_1168.method268();
                aBoolean1205 = aClass24_1168.method268() == 1;
                aLong1220 = 0L;
                anInt1022 = 0;
                aClass48_879.anInt810 = 0;
                super.aBoolean17 = true;
                aBoolean954 = true;
                aBoolean1157 = true;
                aClass30_Sub2_Sub2_1192.anInt1406 = 0;
                aClass30_Sub2_Sub2_1083.anInt1406 = 0;
                opcode = -1;
                anInt841 = -1;
                anInt842 = -1;
                anInt843 = -1;
                anInt1007 = 0;
                anInt1009 = 0;
                anInt1104 = 0;
                anInt1011 = 0;
                anInt855 = 0;
                anInt1133 = 0;
                aBoolean885 = false;
                super.anInt18 = 0;
                for(int j1 = 0; j1 < 100; j1++)
                    aStringArray944[j1] = null;

                anInt1282 = 0;
                anInt1136 = 0;
                anInt1023 = 0;
                anInt1062 = 0;
                anInt1278 = (int)(Math.random() * 100D) - 50;
                anInt1131 = (int)(Math.random() * 110D) - 55;
                anInt896 = (int)(Math.random() * 80D) - 40;
                anInt1209 = (int)(Math.random() * 120D) - 60;
                anInt1170 = (int)(Math.random() * 30D) - 20;
                anInt1185 = (int)(Math.random() * 20D) - 10 & 0x7ff;
                anInt1021 = 0;
                anInt985 = -1;
                anInt1261 = 0;
                anInt1262 = 0;
                anInt891 = 0;
                anInt836 = 0;
                for(int i2 = 0; i2 < anInt888; i2++)
                {
                    aClass30_Sub2_Sub4_Sub1_Sub2Array890[i2] = null;
                    aClass30_Sub2_Sub2Array895[i2] = null;
                }

                for(int k2 = 0; k2 < 16384; k2++)
                    aClass30_Sub2_Sub4_Sub1_Sub1Array835[k2] = null;

                aClass30_Sub2_Sub4_Sub1_Sub2_1126 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[anInt889] = new Class30_Sub2_Sub4_Sub1_Sub2();
                aClass19_1013.method256();
                aClass19_1056.method256();
                for(int l2 = 0; l2 < 4; l2++)
                {
                    for(int i3 = 0; i3 < 104; i3++)
                    {
                        for(int k3 = 0; k3 < 104; k3++)
                            aClass19ArrayArrayArray827[l2][i3][k3] = null;

                    }

                }

                aClass19_1179 = new Class19(169);
                anInt900 = 0;
                anInt899 = 0;
                anInt1042 = -1;
                anInt1276 = -1;
                anInt857 = -1;
                anInt1189 = -1;
                anInt1018 = -1;
                aBoolean1149 = false;
                anInt1221 = 3;
                anInt1225 = 0;
                aBoolean885 = false;
                aBoolean1256 = false;
                aString844 = null;
                anInt1055 = 0;
                anInt1054 = -1;
                aBoolean1047 = true;
                method45(0);
                for(int j3 = 0; j3 < 5; j3++)
                    anIntArray990[j3] = 0;

                for(int l3 = 0; l3 < 5; l3++)
                {
                    aStringArray1127[l3] = null;
                    aBooleanArray1128[l3] = false;
                }

                anInt1175 = 0;
                anInt1134 = 0;
                anInt986 = 0;
                anInt1288 = 0;
                anInt924 = 0;
                anInt1188 = 0;
                anInt1155 = 0;
                anInt1226 = 0;
                anInt941 = 0;
                anInt1260 = 0;
                method79(1);
                return;
            }
            if(k == 3)
            {
                aString1266 = "";
                aString1267 = "Invalid username or password.";
                return;
            }
            if(k == 4)
            {
                aString1266 = "Your account has been disabled.";
                aString1267 = "Please check your message-centre for details.";
                return;
            }
            if(k == 5)
            {
                aString1266 = "Your account is already logged in.";
                aString1267 = "Try again in 60 secs...";
                return;
            }
            if(k == 6)
            {
                aString1266 = "RuneScape has been updated!";
                aString1267 = "Please reload this page.";
                return;
            }
            if(k == 7)
            {
                aString1266 = "This world is full.";
                aString1267 = "Please use a different world.";
                return;
            }
            if(k == 8)
            {
                aString1266 = "Unable to connect.";
                aString1267 = "Login server offline.";
                return;
            }
            if(k == 9)
            {
                aString1266 = "Login limit exceeded.";
                aString1267 = "Too many connections from your address.";
                return;
            }
            if(k == 10)
            {
                aString1266 = "Unable to connect.";
                aString1267 = "Bad session id.";
                return;
            }
            if(k == 11)
            {
                aString1267 = "Login server rejected session.";
                aString1267 = "Please try again.";
                return;
            }
            if(k == 12)
            {
                aString1266 = "You need a members account to login to this world.";
                aString1267 = "Please subscribe, or use a different world.";
                return;
            }
            if(k == 13)
            {
                aString1266 = "Could not complete login.";
                aString1267 = "Please try using a different world.";
                return;
            }
            if(k == 14)
            {
                aString1266 = "The server is being updated.";
                aString1267 = "Please wait 1 minute and try again.";
                return;
            }
            if(k == 15)
            {
                aBoolean1157 = true;
                aClass30_Sub2_Sub2_1192.anInt1406 = 0;
                aClass30_Sub2_Sub2_1083.anInt1406 = 0;
                opcode = -1;
                anInt841 = -1;
                anInt842 = -1;
                anInt843 = -1;
                anInt1007 = 0;
                anInt1009 = 0;
                anInt1104 = 0;
                anInt1133 = 0;
                aBoolean885 = false;
                aLong824 = System.currentTimeMillis();
                return;
            }
            if(k == 16)
            {
                aString1266 = "Login attempts exceeded.";
                aString1267 = "Please wait 1 minute and try again.";
                return;
            }
            if(k == 17)
            {
                aString1266 = "You are standing in a members-only area.";
                aString1267 = "To play on this world move to a free area first";
                return;
            }
            if(k == 20)
            {
                aString1266 = "Invalid loginserver requested";
                aString1267 = "Please try using a different world.";
                return;
            }
            if(k == 21)
            {
                for(int k1 = aClass24_1168.method268(); k1 >= 0; k1--)
                {
                    aString1266 = "You have only just left another world";
                    aString1267 = "Your profile will be transferred in: " + k1 + " seconds";
                    method135(true, false);
                    try
                    {
                        Thread.sleep(1000L);
                    }
                    catch(Exception _ex) { }
                }

                method84(s, s1, flag);
                return;
            }
            if(k == -1)
            {
                if(i1 == 0)
                {
                    if(anInt1038 < 2)
                    {
                        try
                        {
                            Thread.sleep(2000L);
                        }
                        catch(Exception _ex) { }
                        anInt1038++;
                        method84(s, s1, flag);
                        return;
                    } else
                    {
                        aString1266 = "No response from loginserver";
                        aString1267 = "Please wait 1 minute and try again.";
                        return;
                    }
                } else
                {
                    aString1266 = "No response from server";
                    aString1267 = "Please try using a different world.";
                    return;
                }
            } else
            {
                System.out.println("response:" + k);
                aString1266 = "Unexpected server response";
                aString1267 = "Please try using a different world.";
                return;
            }
        }
        catch(IOException _ex)
        {
            aString1266 = "";
        }
        aString1267 = "Error connecting to server.";
    }

    public final boolean method85(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, boolean flag, int k2)
    {
        byte byte0 = 104;
        byte byte1 = 104;
        for(int l2 = 0; l2 < byte0; l2++)
        {
            for(int i3 = 0; i3 < byte1; i3++)
            {
                anIntArrayArray901[l2][i3] = 0;
                anIntArrayArray825[l2][i3] = 0x5f5e0ff;
            }

        }

        int j3 = j2;
        int k3 = j1;
        anIntArrayArray901[j2][j1] = 99;
        anIntArrayArray825[j2][j1] = 0;
        int l3 = 0;
        int i4 = 0;
        anIntArray1280[l3] = j2;
        anIntArray1281[l3++] = j1;
        boolean flag1 = false;
        int j4 = anIntArray1280.length;
        int ai[][] = aClass11Array1230[anInt918].anIntArrayArray294;
        while(i4 != l3) 
        {
            j3 = anIntArray1280[i4];
            k3 = anIntArray1281[i4];
            i4 = (i4 + 1) % j4;
            if(j3 == k2 && k3 == i2)
            {
                flag1 = true;
                break;
            }
            if(i1 != 0)
            {
                if((i1 < 5 || i1 == 10) && aClass11Array1230[anInt918].method219(k2, j3, k3, 0, j, i1 - 1, i2))
                {
                    flag1 = true;
                    break;
                }
                if(i1 < 10 && aClass11Array1230[anInt918].method220(k2, i2, k3, i1 - 1, j, j3, 0))
                {
                    flag1 = true;
                    break;
                }
            }
            if(k1 != 0 && k != 0 && aClass11Array1230[anInt918].method221((byte)1, i2, k2, j3, k, l1, k1, k3))
            {
                flag1 = true;
                break;
            }
            int l4 = anIntArrayArray825[j3][k3] + 1;
            if(j3 > 0 && anIntArrayArray901[j3 - 1][k3] == 0 && (ai[j3 - 1][k3] & 0x1280108) == 0)
            {
                anIntArray1280[l3] = j3 - 1;
                anIntArray1281[l3] = k3;
                l3 = (l3 + 1) % j4;
                anIntArrayArray901[j3 - 1][k3] = 2;
                anIntArrayArray825[j3 - 1][k3] = l4;
            }
            if(j3 < byte0 - 1 && anIntArrayArray901[j3 + 1][k3] == 0 && (ai[j3 + 1][k3] & 0x1280180) == 0)
            {
                anIntArray1280[l3] = j3 + 1;
                anIntArray1281[l3] = k3;
                l3 = (l3 + 1) % j4;
                anIntArrayArray901[j3 + 1][k3] = 8;
                anIntArrayArray825[j3 + 1][k3] = l4;
            }
            if(k3 > 0 && anIntArrayArray901[j3][k3 - 1] == 0 && (ai[j3][k3 - 1] & 0x1280102) == 0)
            {
                anIntArray1280[l3] = j3;
                anIntArray1281[l3] = k3 - 1;
                l3 = (l3 + 1) % j4;
                anIntArrayArray901[j3][k3 - 1] = 1;
                anIntArrayArray825[j3][k3 - 1] = l4;
            }
            if(k3 < byte1 - 1 && anIntArrayArray901[j3][k3 + 1] == 0 && (ai[j3][k3 + 1] & 0x1280120) == 0)
            {
                anIntArray1280[l3] = j3;
                anIntArray1281[l3] = k3 + 1;
                l3 = (l3 + 1) % j4;
                anIntArrayArray901[j3][k3 + 1] = 4;
                anIntArrayArray825[j3][k3 + 1] = l4;
            }
            if(j3 > 0 && k3 > 0 && anIntArrayArray901[j3 - 1][k3 - 1] == 0 && (ai[j3 - 1][k3 - 1] & 0x128010e) == 0 && (ai[j3 - 1][k3] & 0x1280108) == 0 && (ai[j3][k3 - 1] & 0x1280102) == 0)
            {
                anIntArray1280[l3] = j3 - 1;
                anIntArray1281[l3] = k3 - 1;
                l3 = (l3 + 1) % j4;
                anIntArrayArray901[j3 - 1][k3 - 1] = 3;
                anIntArrayArray825[j3 - 1][k3 - 1] = l4;
            }
            if(j3 < byte0 - 1 && k3 > 0 && anIntArrayArray901[j3 + 1][k3 - 1] == 0 && (ai[j3 + 1][k3 - 1] & 0x1280183) == 0 && (ai[j3 + 1][k3] & 0x1280180) == 0 && (ai[j3][k3 - 1] & 0x1280102) == 0)
            {
                anIntArray1280[l3] = j3 + 1;
                anIntArray1281[l3] = k3 - 1;
                l3 = (l3 + 1) % j4;
                anIntArrayArray901[j3 + 1][k3 - 1] = 9;
                anIntArrayArray825[j3 + 1][k3 - 1] = l4;
            }
            if(j3 > 0 && k3 < byte1 - 1 && anIntArrayArray901[j3 - 1][k3 + 1] == 0 && (ai[j3 - 1][k3 + 1] & 0x1280138) == 0 && (ai[j3 - 1][k3] & 0x1280108) == 0 && (ai[j3][k3 + 1] & 0x1280120) == 0)
            {
                anIntArray1280[l3] = j3 - 1;
                anIntArray1281[l3] = k3 + 1;
                l3 = (l3 + 1) % j4;
                anIntArrayArray901[j3 - 1][k3 + 1] = 6;
                anIntArrayArray825[j3 - 1][k3 + 1] = l4;
            }
            if(j3 < byte0 - 1 && k3 < byte1 - 1 && anIntArrayArray901[j3 + 1][k3 + 1] == 0 && (ai[j3 + 1][k3 + 1] & 0x12801e0) == 0 && (ai[j3 + 1][k3] & 0x1280180) == 0 && (ai[j3][k3 + 1] & 0x1280120) == 0)
            {
                anIntArray1280[l3] = j3 + 1;
                anIntArray1281[l3] = k3 + 1;
                l3 = (l3 + 1) % j4;
                anIntArrayArray901[j3 + 1][k3 + 1] = 12;
                anIntArrayArray825[j3 + 1][k3 + 1] = l4;
            }
        }
        anInt1264 = 0;
        if(!flag1)
        {
            if(flag)
            {
                int i5 = 100;
                for(int k5 = 1; k5 < 2; k5++)
                {
                    for(int i6 = k2 - k5; i6 <= k2 + k5; i6++)
                    {
                        for(int l6 = i2 - k5; l6 <= i2 + k5; l6++)
                            if(i6 >= 0 && l6 >= 0 && i6 < 104 && l6 < 104 && anIntArrayArray825[i6][l6] < i5)
                            {
                                i5 = anIntArrayArray825[i6][l6];
                                j3 = i6;
                                k3 = l6;
                                anInt1264 = 1;
                                flag1 = true;
                            }

                    }

                    if(flag1)
                        break;
                }

            }
            if(!flag1)
                return false;
        }
        i4 = 0;
        anIntArray1280[i4] = j3;
        anIntArray1281[i4++] = k3;
        if(l != -11308)
        {
            for(int j6 = 1; j6 > 0; j6++);
        }
        int l5;
        for(int j5 = l5 = anIntArrayArray901[j3][k3]; j3 != j2 || k3 != j1; j5 = anIntArrayArray901[j3][k3])
        {
            if(j5 != l5)
            {
                l5 = j5;
                anIntArray1280[i4] = j3;
                anIntArray1281[i4++] = k3;
            }
            if((j5 & 2) != 0)
                j3++;
            else
            if((j5 & 8) != 0)
                j3--;
            if((j5 & 1) != 0)
                k3++;
            else
            if((j5 & 4) != 0)
                k3--;
        }

        if(i4 > 0)
        {
            int k4 = i4;
            if(k4 > 25)
                k4 = 25;
            i4--;
            int k6 = anIntArray1280[i4];
            int i7 = anIntArray1281[i4];
            anInt1288 += k4;
            if(anInt1288 >= 92)
            {
                aClass30_Sub2_Sub2_1192.method397((byte)6, 36);
                aClass30_Sub2_Sub2_1192.method402(0);
                anInt1288 = 0;
            }
            if(i == 0)
            {
                aClass30_Sub2_Sub2_1192.method397((byte)6, 164);
                aClass30_Sub2_Sub2_1192.method398(k4 + k4 + 3);
            }
            if(i == 1)
            {
                aClass30_Sub2_Sub2_1192.method397((byte)6, 248);
                aClass30_Sub2_Sub2_1192.method398(k4 + k4 + 3 + 14);
            }
            if(i == 2)
            {
                aClass30_Sub2_Sub2_1192.method397((byte)6, 98);
                aClass30_Sub2_Sub2_1192.method398(k4 + k4 + 3);
            }
            aClass30_Sub2_Sub2_1192.method433(0, k6 + anInt1034);
            anInt1261 = anIntArray1280[0];
            anInt1262 = anIntArray1281[0];
            for(int j7 = 1; j7 < k4; j7++)
            {
                i4--;
                aClass30_Sub2_Sub2_1192.method398(anIntArray1280[i4] - k6);
                aClass30_Sub2_Sub2_1192.method398(anIntArray1281[i4] - i7);
            }

            aClass30_Sub2_Sub2_1192.method431(true, i7 + anInt1035);
            aClass30_Sub2_Sub2_1192.method424(super.anIntArray30[5] != 1 ? 0 : 1, 0);
            return true;
        }
        return i != 1;
    }

    private final void method86(int i, Class30_Sub2_Sub2 class30_sub2_sub2, boolean flag)
    {
        for(int j = 0; j < anInt893; j++)
        {
            int k = anIntArray894[j];
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[k];
            int l = class30_sub2_sub2.method408();
            if((l & 0x10) != 0)
            {
                int i1 = class30_sub2_sub2.method434((byte)108);
                if(i1 == 65535)
                    i1 = -1;
                int i2 = class30_sub2_sub2.method408();
                if(i1 == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1526 && i1 != -1)
                {
                    int l2 = Class20.aClass20Array351[i1].anInt365;
                    if(l2 == 1)
                    {
                        class30_sub2_sub4_sub1_sub1.anInt1527 = 0;
                        class30_sub2_sub4_sub1_sub1.anInt1528 = 0;
                        class30_sub2_sub4_sub1_sub1.anInt1529 = i2;
                        class30_sub2_sub4_sub1_sub1.anInt1530 = 0;
                    }
                    if(l2 == 2)
                        class30_sub2_sub4_sub1_sub1.anInt1530 = 0;
                } else
                if(i1 == -1 || ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1526 == -1 || Class20.aClass20Array351[i1].anInt359 >= Class20.aClass20Array351[((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1526].anInt359)
                {
                    class30_sub2_sub4_sub1_sub1.anInt1526 = i1;
                    class30_sub2_sub4_sub1_sub1.anInt1527 = 0;
                    class30_sub2_sub4_sub1_sub1.anInt1528 = 0;
                    class30_sub2_sub4_sub1_sub1.anInt1529 = i2;
                    class30_sub2_sub4_sub1_sub1.anInt1530 = 0;
                    class30_sub2_sub4_sub1_sub1.anInt1542 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1525;
                }
            }
            if((l & 8) != 0)
            {
                int j1 = class30_sub2_sub2.method426(0);
                int j2 = class30_sub2_sub2.method427(false);
                class30_sub2_sub4_sub1_sub1.method447(-35698, j2, j1, anInt1161);
                class30_sub2_sub4_sub1_sub1.anInt1532 = anInt1161 + 300;
                class30_sub2_sub4_sub1_sub1.anInt1533 = class30_sub2_sub2.method426(0);
                class30_sub2_sub4_sub1_sub1.anInt1534 = class30_sub2_sub2.method408();
            }
            if((l & 0x80) != 0)
            {
                class30_sub2_sub4_sub1_sub1.anInt1520 = class30_sub2_sub2.method410();
                int k1 = class30_sub2_sub2.method413();
                class30_sub2_sub4_sub1_sub1.anInt1524 = k1 >> 16;
                class30_sub2_sub4_sub1_sub1.anInt1523 = anInt1161 + (k1 & 0xffff);
                class30_sub2_sub4_sub1_sub1.anInt1521 = 0;
                class30_sub2_sub4_sub1_sub1.anInt1522 = 0;
                if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1523 > anInt1161)
                    class30_sub2_sub4_sub1_sub1.anInt1521 = -1;
                if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1520 == 65535)
                    class30_sub2_sub4_sub1_sub1.anInt1520 = -1;
            }
            if((l & 0x20) != 0)
            {
                class30_sub2_sub4_sub1_sub1.anInt1502 = class30_sub2_sub2.method410();
                if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1502 == 65535)
                    class30_sub2_sub4_sub1_sub1.anInt1502 = -1;
            }
            if((l & 1) != 0)
            {
                class30_sub2_sub4_sub1_sub1.aString1506 = class30_sub2_sub2.method415();
                class30_sub2_sub4_sub1_sub1.anInt1535 = 100;
            }
            if((l & 0x40) != 0)
            {
                int l1 = class30_sub2_sub2.method427(false);
                int k2 = class30_sub2_sub2.method428(2);
                class30_sub2_sub4_sub1_sub1.method447(-35698, k2, l1, anInt1161);
                class30_sub2_sub4_sub1_sub1.anInt1532 = anInt1161 + 300;
                class30_sub2_sub4_sub1_sub1.anInt1533 = class30_sub2_sub2.method428(2);
                class30_sub2_sub4_sub1_sub1.anInt1534 = class30_sub2_sub2.method427(false);
            }
            if((l & 2) != 0)
            {
                class30_sub2_sub4_sub1_sub1.aClass5_1696 = Class5.method159(class30_sub2_sub2.method436((byte)-74));
                class30_sub2_sub4_sub1_sub1.anInt1540 = class30_sub2_sub4_sub1_sub1.aClass5_1696.aByte68;
                class30_sub2_sub4_sub1_sub1.anInt1504 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt79;
                class30_sub2_sub4_sub1_sub1.anInt1554 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt67;
                class30_sub2_sub4_sub1_sub1.anInt1555 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt58;
                class30_sub2_sub4_sub1_sub1.anInt1556 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt83;
                class30_sub2_sub4_sub1_sub1.anInt1557 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt55;
                class30_sub2_sub4_sub1_sub1.anInt1511 = class30_sub2_sub4_sub1_sub1.aClass5_1696.anInt77;
            }
            if((l & 4) != 0)
            {
                class30_sub2_sub4_sub1_sub1.anInt1538 = class30_sub2_sub2.method434((byte)108);
                class30_sub2_sub4_sub1_sub1.anInt1539 = class30_sub2_sub2.method434((byte)108);
            }
        }

        aBoolean1157 &= flag;
    }

    public final void method87(Class5 class5, int i, boolean flag, int j, int k)
    {
        if(anInt1133 >= 400)
            return;
        if(class5.anIntArray88 != null)
            class5 = class5.method161(anInt877);
        if(class5 == null)
            return;
        if(!class5.aBoolean84)
            return;
        String s = class5.aString65;
        if(flag)
            aBoolean919 = !aBoolean919;
        if(class5.anInt61 != 0)
            s = s + method110(aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1705, class5.anInt61, true) + " (level-" + class5.anInt61 + ")";
        if(anInt1282 == 1)
        {
            aStringArray1199[anInt1133] = "Use " + aString1286 + " with @yel@" + s;
            anIntArray1093[anInt1133] = 582;
            anIntArray1094[anInt1133] = i;
            anIntArray1091[anInt1133] = k;
            anIntArray1092[anInt1133] = j;
            anInt1133++;
            return;
        }
        if(anInt1136 == 1)
        {
            if((anInt1138 & 2) == 2)
            {
                aStringArray1199[anInt1133] = aString1139 + " @yel@" + s;
                anIntArray1093[anInt1133] = 413;
                anIntArray1094[anInt1133] = i;
                anIntArray1091[anInt1133] = k;
                anIntArray1092[anInt1133] = j;
                anInt1133++;
                return;
            }
        } else
        {
            if(class5.aStringArray66 != null)
            {
                for(int l = 4; l >= 0; l--)
                    if(class5.aStringArray66[l] != null && !class5.aStringArray66[l].equalsIgnoreCase("attack"))
                    {
                        aStringArray1199[anInt1133] = class5.aStringArray66[l] + " @yel@" + s;
                        if(l == 0)
                            anIntArray1093[anInt1133] = 20;
                        if(l == 1)
                            anIntArray1093[anInt1133] = 412;
                        if(l == 2)
                            anIntArray1093[anInt1133] = 225;
                        if(l == 3)
                            anIntArray1093[anInt1133] = 965;
                        if(l == 4)
                            anIntArray1093[anInt1133] = 478;
                        anIntArray1094[anInt1133] = i;
                        anIntArray1091[anInt1133] = k;
                        anIntArray1092[anInt1133] = j;
                        anInt1133++;
                    }

            }
            if(class5.aStringArray66 != null)
            {
                for(int i1 = 4; i1 >= 0; i1--)
                    if(class5.aStringArray66[i1] != null && class5.aStringArray66[i1].equalsIgnoreCase("attack"))
                    {
                        char c = '\0';
                        if(class5.anInt61 > aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1705)
                            c = '\u07D0';
                        aStringArray1199[anInt1133] = class5.aStringArray66[i1] + " @yel@" + s;
                        if(i1 == 0)
                            anIntArray1093[anInt1133] = 20 + c;
                        if(i1 == 1)
                            anIntArray1093[anInt1133] = 412 + c;
                        if(i1 == 2)
                            anIntArray1093[anInt1133] = 225 + c;
                        if(i1 == 3)
                            anIntArray1093[anInt1133] = 965 + c;
                        if(i1 == 4)
                            anIntArray1093[anInt1133] = 478 + c;
                        anIntArray1094[anInt1133] = i;
                        anIntArray1091[anInt1133] = k;
                        anIntArray1092[anInt1133] = j;
                        anInt1133++;
                    }

            }
            aStringArray1199[anInt1133] = "Examine @yel@" + s;
            anIntArray1093[anInt1133] = 1025;
            anIntArray1094[anInt1133] = i;
            anIntArray1091[anInt1133] = k;
            anIntArray1092[anInt1133] = j;
            anInt1133++;
        }
    }

    public final void method88(int i, int j, Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2, boolean flag, int k)
    {
        if(class30_sub2_sub4_sub1_sub2 == aClass30_Sub2_Sub4_Sub1_Sub2_1126)
            return;
        if(anInt1133 >= 400)
            return;
        if(flag)
            return;
        String s;
        if(class30_sub2_sub4_sub1_sub2.anInt1723 == 0)
            s = class30_sub2_sub4_sub1_sub2.aString1703 + method110(aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1705, class30_sub2_sub4_sub1_sub2.anInt1705, true) + " (level-" + class30_sub2_sub4_sub1_sub2.anInt1705 + ")";
        else
            s = class30_sub2_sub4_sub1_sub2.aString1703 + " (skill-" + class30_sub2_sub4_sub1_sub2.anInt1723 + ")";
        if(anInt1282 == 1)
        {
            aStringArray1199[anInt1133] = "Use " + aString1286 + " with @whi@" + s;
            anIntArray1093[anInt1133] = 491;
            anIntArray1094[anInt1133] = j;
            anIntArray1091[anInt1133] = i;
            anIntArray1092[anInt1133] = k;
            anInt1133++;
        } else
        if(anInt1136 == 1)
        {
            if((anInt1138 & 8) == 8)
            {
                aStringArray1199[anInt1133] = aString1139 + " @whi@" + s;
                anIntArray1093[anInt1133] = 365;
                anIntArray1094[anInt1133] = j;
                anIntArray1091[anInt1133] = i;
                anIntArray1092[anInt1133] = k;
                anInt1133++;
            }
        } else
        {
            for(int l = 4; l >= 0; l--)
                if(aStringArray1127[l] != null)
                {
                    aStringArray1199[anInt1133] = aStringArray1127[l] + " @whi@" + s;
                    char c = '\0';
                    if(aStringArray1127[l].equalsIgnoreCase("attack"))
                    {
                        if(class30_sub2_sub4_sub1_sub2.anInt1705 > aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1705)
                            c = '\u07D0';
                        if(aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1701 != 0 && class30_sub2_sub4_sub1_sub2.anInt1701 != 0)
                            if(aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1701 == class30_sub2_sub4_sub1_sub2.anInt1701)
                                c = '\u07D0';
                            else
                                c = '\0';
                    } else
                    if(aBooleanArray1128[l])
                        c = '\u07D0';
                    if(l == 0)
                        anIntArray1093[anInt1133] = 561 + c;
                    if(l == 1)
                        anIntArray1093[anInt1133] = 779 + c;
                    if(l == 2)
                        anIntArray1093[anInt1133] = 27 + c;
                    if(l == 3)
                        anIntArray1093[anInt1133] = 577 + c;
                    if(l == 4)
                        anIntArray1093[anInt1133] = 729 + c;
                    anIntArray1094[anInt1133] = j;
                    anIntArray1091[anInt1133] = i;
                    anIntArray1092[anInt1133] = k;
                    anInt1133++;
                }

        }
        for(int i1 = 0; i1 < anInt1133; i1++)
            if(anIntArray1093[i1] == 516)
            {
                aStringArray1199[i1] = "Walk here @whi@" + s;
                return;
            }

    }

    private final void method89(boolean flag, Class30_Sub1 class30_sub1)
    {
        int i = 0;
        int j = -1;
        int k = 0;
        int l = 0;
        if(class30_sub1.anInt1296 == 0)
            i = aClass25_946.method300(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298);
        if(class30_sub1.anInt1296 == 1)
            i = aClass25_946.method301(class30_sub1.anInt1295, class30_sub1.anInt1297, 0, class30_sub1.anInt1298);
        if(class30_sub1.anInt1296 == 2)
            i = aClass25_946.method302(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298);
        if(class30_sub1.anInt1296 == 3)
            i = aClass25_946.method303(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298);
        if(i != 0)
        {
            int i1 = aClass25_946.method304(class30_sub1.anInt1295, class30_sub1.anInt1297, class30_sub1.anInt1298, i);
            j = i >> 14 & 0x7fff;
            k = i1 & 0x1f;
            l = i1 >> 6;
        }
        class30_sub1.anInt1299 = j;
        class30_sub1.anInt1301 = k;
        if(flag)
        {
            for(int j1 = 1; j1 > 0; j1++);
        }
        class30_sub1.anInt1300 = l;
    }

    public final void method90(boolean flag)
    {
        if(flag)
            opcode = -1;
        for(int i = 0; i < anInt1062; i++)
            if(anIntArray1250[i] <= 0)
            {
                boolean flag1 = false;
                try
                {
                    if(anIntArray1207[i] == anInt874 && anIntArray1241[i] == anInt1289)
                    {
                        if(!method27(11456))
                            flag1 = true;
                    } else
                    {
                        Class30_Sub2_Sub2 class30_sub2_sub2 = Class16.method241(anIntArray1241[i], anIntArray1207[i], false);
                        if(System.currentTimeMillis() + (long)(class30_sub2_sub2.anInt1406 / 22) > aLong1172 + (long)(anInt1257 / 22))
                        {
                            anInt1257 = class30_sub2_sub2.anInt1406;
                            aLong1172 = System.currentTimeMillis();
                            if(method59(class30_sub2_sub2.aByteArray1405, (byte)116, class30_sub2_sub2.anInt1406))
                            {
                                anInt874 = anIntArray1207[i];
                                anInt1289 = anIntArray1241[i];
                            } else
                            {
                                flag1 = true;
                            }
                        }
                    }
                }
                catch(Exception exception) { }
                if(!flag1 || anIntArray1250[i] == -5)
                {
                    anInt1062--;
                    for(int j = i; j < anInt1062; j++)
                    {
                        anIntArray1207[j] = anIntArray1207[j + 1];
                        anIntArray1241[j] = anIntArray1241[j + 1];
                        anIntArray1250[j] = anIntArray1250[j + 1];
                    }

                    i--;
                } else
                {
                    anIntArray1250[i] = -5;
                }
            } else
            {
                anIntArray1250[i]--;
            }

        if(anInt1259 > 0)
        {
            anInt1259 -= 20;
            if(anInt1259 < 0)
                anInt1259 = 0;
            if(anInt1259 == 0 && aBoolean1151 && !aBoolean960)
            {
                anInt1227 = anInt956;
                aBoolean1228 = true;
                aClass42_Sub1_1068.method558(2, anInt1227);
            }
        }
    }

    public final void method6()
    {
        method13(20, (byte)4, "Starting up");
        if(signlink.sunjava)
            super.anInt6 = 5;
        if(aBoolean993)
        {
 //           aBoolean1252 = true;
 //           return;
        }
        aBoolean993 = true;
        boolean flag = false;
        String s = method80(true);
        if(s.endsWith("jagex.com"))
            flag = true;
        if(s.endsWith("runescape.com"))
            flag = true;
        if(s.endsWith("192.168.1.2"))
            flag = true;
        if(s.endsWith("192.168.1.229"))
            flag = true;
        if(s.endsWith("192.168.1.228"))
            flag = true;
        if(s.endsWith("192.168.1.227"))
            flag = true;
        if(s.endsWith("192.168.1.226"))
            flag = true;
        if(s.endsWith("127.0.0.1"))
            flag = true;
        if(!flag)
        {
            aBoolean1176 = true;
            return;
        }
        if(signlink.cache_dat != null)
        {
            for(int i = 0; i < 5; i++)
                aClass14Array970[i] = new Class14(0x7a120, signlink.cache_dat, signlink.cache_idx[i], i + 1, true);

        }
        try
        {
            method16(533);
            aClass44_1053 = method67(1, "title screen", "title", anIntArray1090[1], (byte)-41, 25);
            aClass30_Sub2_Sub1_Sub4_1270 = new Class30_Sub2_Sub1_Sub4(false, "p11_full", 0, aClass44_1053);
            aClass30_Sub2_Sub1_Sub4_1271 = new Class30_Sub2_Sub1_Sub4(false, "p12_full", 0, aClass44_1053);
            aClass30_Sub2_Sub1_Sub4_1272 = new Class30_Sub2_Sub1_Sub4(false, "b12_full", 0, aClass44_1053);
            aClass30_Sub2_Sub1_Sub4_1273 = new Class30_Sub2_Sub1_Sub4(true, "q8_full", 0, aClass44_1053);
            method56(0);
            method51(215);
            Class44 class44 = method67(2, "config", "config", anIntArray1090[2], (byte)-41, 30);
            Class44 class44_1 = method67(3, "interface", "interface", anIntArray1090[3], (byte)-41, 35);
            Class44 class44_2 = method67(4, "2d graphics", "media", anIntArray1090[4], (byte)-41, 40);
            Class44 class44_3 = method67(6, "textures", "textures", anIntArray1090[6], (byte)-41, 45);
            Class44 class44_4 = method67(7, "chat system", "wordenc", anIntArray1090[7], (byte)-41, 50);
            Class44 class44_5 = method67(8, "sound effects", "sounds", anIntArray1090[8], (byte)-41, 55);
            aByteArrayArrayArray1258 = new byte[4][104][104];
            anIntArrayArrayArray1214 = new int[4][105][105];
            aClass25_946 = new Class25(104, (byte)43, 104, anIntArrayArrayArray1214, 4);
            for(int j = 0; j < 4; j++)
                aClass11Array1230[j] = new Class11(104, 104, true);

            aClass30_Sub2_Sub1_Sub1_1263 = new Class30_Sub2_Sub1_Sub1(512, 512);
            Class44 class44_6 = method67(5, "update list", "versionlist", anIntArray1090[5], (byte)-41, 60);
            method13(60, (byte)4, "Connecting to update server");
            aClass42_Sub1_1068 = new Class42_Sub1();
            aClass42_Sub1_1068.method551(class44_6, this);
            Class36.method528(aClass42_Sub1_1068.method557(0));
            Class30_Sub2_Sub4_Sub6.method459(aClass42_Sub1_1068.method555(79, 0), aClass42_Sub1_1068);
            if(!aBoolean960)
            {
                anInt1227 = 0;
                try
                {
                    anInt1227 = Integer.parseInt(getParameter("music"));
                }
                catch(Exception _ex) { }
                aBoolean1228 = true;
                aClass42_Sub1_1068.method558(2, anInt1227);
                while(aClass42_Sub1_1068.method552() > 0) 
                {
                    method57(false);
                    try
                    {
                        Thread.sleep(100L);
                    }
                    catch(Exception _ex) { }
                    if(aClass42_Sub1_1068.anInt1349 > 3)
                    {
                        method28("ondemand");
                        return;
                    }
                }
            }
            method13(65, (byte)4, "Requesting animations");
            int k = aClass42_Sub1_1068.method555(79, 1);
            for(int i1 = 0; i1 < k; i1++)
                aClass42_Sub1_1068.method558(1, i1);

            while(aClass42_Sub1_1068.method552() > 0) 
            {
                int j1 = k - aClass42_Sub1_1068.method552();
                if(j1 > 0)
                    method13(65, (byte)4, "Loading animations - " + (j1 * 100) / k + "%");
                method57(false);
                try
                {
                    Thread.sleep(100L);
                }
                catch(Exception _ex) { }
                if(aClass42_Sub1_1068.anInt1349 > 3)
                {
                    method28("ondemand");
                    return;
                }
            }
            method13(70, (byte)4, "Requesting models");
            k = aClass42_Sub1_1068.method555(79, 0);
            for(int k1 = 0; k1 < k; k1++)
            {
                int l1 = aClass42_Sub1_1068.method559(k1, -203);
                if((l1 & 1) != 0)
                    aClass42_Sub1_1068.method558(0, k1);
            }

            k = aClass42_Sub1_1068.method552();
            while(aClass42_Sub1_1068.method552() > 0) 
            {
                int i2 = k - aClass42_Sub1_1068.method552();
                if(i2 > 0)
                    method13(70, (byte)4, "Loading models - " + (i2 * 100) / k + "%");
                method57(false);
                try
                {
                    Thread.sleep(100L);
                }
                catch(Exception _ex) { }
            }
            if(aClass14Array970[0] != null)
            {
                method13(75, (byte)4, "Requesting maps");
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(0, 0, 48, 47));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(1, 0, 48, 47));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(0, 0, 48, 48));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(1, 0, 48, 48));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(0, 0, 48, 49));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(1, 0, 48, 49));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(0, 0, 47, 47));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(1, 0, 47, 47));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(0, 0, 47, 48));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(1, 0, 47, 48));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(0, 0, 148, 48));
                aClass42_Sub1_1068.method558(3, aClass42_Sub1_1068.method562(1, 0, 148, 48));
                k = aClass42_Sub1_1068.method552();
                while(aClass42_Sub1_1068.method552() > 0) 
                {
                    int j2 = k - aClass42_Sub1_1068.method552();
                    if(j2 > 0)
                        method13(75, (byte)4, "Loading maps - " + (j2 * 100) / k + "%");
                    method57(false);
                    try
                    {
                        Thread.sleep(100L);
                    }
                    catch(Exception _ex) { }
                }
            }
            k = aClass42_Sub1_1068.method555(79, 0);
            for(int k2 = 0; k2 < k; k2++)
            {
                int l2 = aClass42_Sub1_1068.method559(k2, -203);
                byte byte0 = 0;
                if((l2 & 8) != 0)
                    byte0 = 10;
                else
                if((l2 & 0x20) != 0)
                    byte0 = 9;
                else
                if((l2 & 0x10) != 0)
                    byte0 = 8;
                else
                if((l2 & 0x40) != 0)
                    byte0 = 7;
                else
                if((l2 & 0x80) != 0)
                    byte0 = 6;
                else
                if((l2 & 2) != 0)
                    byte0 = 5;
                else
                if((l2 & 4) != 0)
                    byte0 = 4;
                if((l2 & 1) != 0)
                    byte0 = 3;
                if(byte0 != 0)
                    aClass42_Sub1_1068.method563(byte0, 0, k2, (byte)8);
            }

            aClass42_Sub1_1068.method554(aBoolean959, 0);
            if(!aBoolean960)
            {
                int l = aClass42_Sub1_1068.method555(79, 2);
                for(int i3 = 1; i3 < l; i3++)
                    if(aClass42_Sub1_1068.method569(i3, 5))
                        aClass42_Sub1_1068.method563((byte)1, 2, i3, (byte)8);

            }
            method13(80, (byte)4, "Unpacking media");
            aClass30_Sub2_Sub1_Sub2_1196 = new Class30_Sub2_Sub1_Sub2(class44_2, "invback", 0);
            aClass30_Sub2_Sub1_Sub2_1198 = new Class30_Sub2_Sub1_Sub2(class44_2, "chatback", 0);
            aClass30_Sub2_Sub1_Sub2_1197 = new Class30_Sub2_Sub1_Sub2(class44_2, "mapback", 0);
            aClass30_Sub2_Sub1_Sub2_1027 = new Class30_Sub2_Sub1_Sub2(class44_2, "backbase1", 0);
            aClass30_Sub2_Sub1_Sub2_1028 = new Class30_Sub2_Sub1_Sub2(class44_2, "backbase2", 0);
            aClass30_Sub2_Sub1_Sub2_1029 = new Class30_Sub2_Sub1_Sub2(class44_2, "backhmid1", 0);
            for(int j3 = 0; j3 < 13; j3++)
                aClass30_Sub2_Sub1_Sub2Array947[j3] = new Class30_Sub2_Sub1_Sub2(class44_2, "sideicons", j3);

            aClass30_Sub2_Sub1_Sub1_1122 = new Class30_Sub2_Sub1_Sub1(class44_2, "compass", 0);
            aClass30_Sub2_Sub1_Sub1_1001 = new Class30_Sub2_Sub1_Sub1(class44_2, "mapedge", 0);
            aClass30_Sub2_Sub1_Sub1_1001.method345(5059);
            try
            {
                for(int k3 = 0; k3 < 100; k3++)
                    aClass30_Sub2_Sub1_Sub2Array1060[k3] = new Class30_Sub2_Sub1_Sub2(class44_2, "mapscene", k3);

            }
            catch(Exception _ex) { }
            try
            {
                for(int l3 = 0; l3 < 100; l3++)
                    aClass30_Sub2_Sub1_Sub1Array1033[l3] = new Class30_Sub2_Sub1_Sub1(class44_2, "mapfunction", l3);

            }
            catch(Exception _ex) { }
            try
            {
                for(int i4 = 0; i4 < 20; i4++)
                    aClass30_Sub2_Sub1_Sub1Array987[i4] = new Class30_Sub2_Sub1_Sub1(class44_2, "hitmarks", i4);

            }
            catch(Exception _ex) { }
            try
            {
                for(int j4 = 0; j4 < 20; j4++)
                    aClass30_Sub2_Sub1_Sub1Array1095[j4] = new Class30_Sub2_Sub1_Sub1(class44_2, "headicons", j4);

            }
            catch(Exception _ex) { }
            aClass30_Sub2_Sub1_Sub1_870 = new Class30_Sub2_Sub1_Sub1(class44_2, "mapmarker", 0);
            aClass30_Sub2_Sub1_Sub1_871 = new Class30_Sub2_Sub1_Sub1(class44_2, "mapmarker", 1);
            for(int k4 = 0; k4 < 8; k4++)
                aClass30_Sub2_Sub1_Sub1Array1150[k4] = new Class30_Sub2_Sub1_Sub1(class44_2, "cross", k4);

            aClass30_Sub2_Sub1_Sub1_1074 = new Class30_Sub2_Sub1_Sub1(class44_2, "mapdots", 0);
            aClass30_Sub2_Sub1_Sub1_1075 = new Class30_Sub2_Sub1_Sub1(class44_2, "mapdots", 1);
            aClass30_Sub2_Sub1_Sub1_1076 = new Class30_Sub2_Sub1_Sub1(class44_2, "mapdots", 2);
            aClass30_Sub2_Sub1_Sub1_1077 = new Class30_Sub2_Sub1_Sub1(class44_2, "mapdots", 3);
            aClass30_Sub2_Sub1_Sub1_1078 = new Class30_Sub2_Sub1_Sub1(class44_2, "mapdots", 4);
            aClass30_Sub2_Sub1_Sub2_1024 = new Class30_Sub2_Sub1_Sub2(class44_2, "scrollbar", 0);
            aClass30_Sub2_Sub1_Sub2_1025 = new Class30_Sub2_Sub1_Sub2(class44_2, "scrollbar", 1);
            aClass30_Sub2_Sub1_Sub2_1143 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone1", 0);
            aClass30_Sub2_Sub1_Sub2_1144 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone2", 0);
            aClass30_Sub2_Sub1_Sub2_1145 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone3", 0);
            aClass30_Sub2_Sub1_Sub2_1146 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone1", 0);
            aClass30_Sub2_Sub1_Sub2_1146.method358(0);
            aClass30_Sub2_Sub1_Sub2_1147 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone2", 0);
            aClass30_Sub2_Sub1_Sub2_1147.method358(0);
            aClass30_Sub2_Sub1_Sub2_865 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone1", 0);
            aClass30_Sub2_Sub1_Sub2_865.method359(true);
            aClass30_Sub2_Sub1_Sub2_866 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone2", 0);
            aClass30_Sub2_Sub1_Sub2_866.method359(true);
            aClass30_Sub2_Sub1_Sub2_867 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone3", 0);
            aClass30_Sub2_Sub1_Sub2_867.method359(true);
            aClass30_Sub2_Sub1_Sub2_868 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone1", 0);
            aClass30_Sub2_Sub1_Sub2_868.method358(0);
            aClass30_Sub2_Sub1_Sub2_868.method359(true);
            aClass30_Sub2_Sub1_Sub2_869 = new Class30_Sub2_Sub1_Sub2(class44_2, "redstone2", 0);
            aClass30_Sub2_Sub1_Sub2_869.method358(0);
            aClass30_Sub2_Sub1_Sub2_869.method359(true);
            for(int l4 = 0; l4 < 2; l4++)
                aClass30_Sub2_Sub1_Sub2Array1219[l4] = new Class30_Sub2_Sub1_Sub2(class44_2, "mod_icons", l4);

            Class30_Sub2_Sub1_Sub1 class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(class44_2, "backleft1", 0);
            aClass15_903 = new Class15(class30_sub2_sub1_sub1.anInt1440, class30_sub2_sub1_sub1.anInt1441, method11(0), 0);
            class30_sub2_sub1_sub1.method346(0, 0, -32357);
            class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(class44_2, "backleft2", 0);
            aClass15_904 = new Class15(class30_sub2_sub1_sub1.anInt1440, class30_sub2_sub1_sub1.anInt1441, method11(0), 0);
            class30_sub2_sub1_sub1.method346(0, 0, -32357);
            class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(class44_2, "backright1", 0);
            aClass15_905 = new Class15(class30_sub2_sub1_sub1.anInt1440, class30_sub2_sub1_sub1.anInt1441, method11(0), 0);
            class30_sub2_sub1_sub1.method346(0, 0, -32357);
            class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(class44_2, "backright2", 0);
            aClass15_906 = new Class15(class30_sub2_sub1_sub1.anInt1440, class30_sub2_sub1_sub1.anInt1441, method11(0), 0);
            class30_sub2_sub1_sub1.method346(0, 0, -32357);
            class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(class44_2, "backtop1", 0);
            aClass15_907 = new Class15(class30_sub2_sub1_sub1.anInt1440, class30_sub2_sub1_sub1.anInt1441, method11(0), 0);
            class30_sub2_sub1_sub1.method346(0, 0, -32357);
            class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(class44_2, "backvmid1", 0);
            aClass15_908 = new Class15(class30_sub2_sub1_sub1.anInt1440, class30_sub2_sub1_sub1.anInt1441, method11(0), 0);
            class30_sub2_sub1_sub1.method346(0, 0, -32357);
            class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(class44_2, "backvmid2", 0);
            aClass15_909 = new Class15(class30_sub2_sub1_sub1.anInt1440, class30_sub2_sub1_sub1.anInt1441, method11(0), 0);
            class30_sub2_sub1_sub1.method346(0, 0, -32357);
            class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(class44_2, "backvmid3", 0);
            aClass15_910 = new Class15(class30_sub2_sub1_sub1.anInt1440, class30_sub2_sub1_sub1.anInt1441, method11(0), 0);
            class30_sub2_sub1_sub1.method346(0, 0, -32357);
            class30_sub2_sub1_sub1 = new Class30_Sub2_Sub1_Sub1(class44_2, "backhmid2", 0);
            aClass15_911 = new Class15(class30_sub2_sub1_sub1.anInt1440, class30_sub2_sub1_sub1.anInt1441, method11(0), 0);
            class30_sub2_sub1_sub1.method346(0, 0, -32357);
            int i5 = (int)(Math.random() * 21D) - 10;
            int j5 = (int)(Math.random() * 21D) - 10;
            int k5 = (int)(Math.random() * 21D) - 10;
            int l5 = (int)(Math.random() * 41D) - 20;
            for(int i6 = 0; i6 < 100; i6++)
            {
                if(aClass30_Sub2_Sub1_Sub1Array1033[i6] != null)
                    aClass30_Sub2_Sub1_Sub1Array1033[i6].method344(i5 + l5, j5 + l5, k5 + l5, 0);
                if(aClass30_Sub2_Sub1_Sub2Array1060[i6] != null)
                    aClass30_Sub2_Sub1_Sub2Array1060[i6].method360(i5 + l5, j5 + l5, k5 + l5, 0);
            }

            method13(83, (byte)4, "Unpacking textures");
            Class30_Sub2_Sub1_Sub3.method368(class44_3, 0);
            Class30_Sub2_Sub1_Sub3.method372(0.80000000000000004D, aByte1200);
            Class30_Sub2_Sub1_Sub3.method367(20, true);
            method13(86, (byte)4, "Unpacking config");
            Class20.method257(0, class44);
            Class46.method576(class44);
            Class22.method260(0, class44);
            Class8.method193(class44);
            Class5.method162(class44);
            Class38.method535(0, class44);
            Class23.method264(0, class44);
            Class41.method546(0, class44);
            Class37.method533(0, class44);
            Class8.aBoolean182 = aBoolean959;
            if(!aBoolean960)
            {
                method13(90, (byte)4, "Unpacking sounds");
                byte abyte0[] = class44_5.method571("sounds.dat", null);
                Class30_Sub2_Sub2 class30_sub2_sub2 = new Class30_Sub2_Sub2(abyte0, 891);
                Class16.method240(0, class30_sub2_sub2);
            }
            method13(95, (byte)4, "Unpacking interfaces");
            Class30_Sub2_Sub1_Sub4 aclass30_sub2_sub1_sub4[] = {
                aClass30_Sub2_Sub1_Sub4_1270, aClass30_Sub2_Sub1_Sub4_1271, aClass30_Sub2_Sub1_Sub4_1272, aClass30_Sub2_Sub1_Sub4_1273
            };
            Class9.method205(class44_1, aclass30_sub2_sub1_sub4, (byte)-84, class44_2);
            method13(100, (byte)4, "Preparing game engine");
            for(int j6 = 0; j6 < 33; j6++)
            {
                int k6 = 999;
                int i7 = 0;
                for(int k7 = 0; k7 < 34; k7++)
                {
                    if(aClass30_Sub2_Sub1_Sub2_1197.aByteArray1450[k7 + j6 * aClass30_Sub2_Sub1_Sub2_1197.anInt1452] == 0)
                    {
                        if(k6 == 999)
                            k6 = k7;
                        continue;
                    }
                    if(k6 == 999)
                        continue;
                    i7 = k7;
                    break;
                }

                anIntArray968[j6] = k6;
                anIntArray1057[j6] = i7 - k6;
            }

            for(int l6 = 5; l6 < 156; l6++)
            {
                int j7 = 999;
                int l7 = 0;
                for(int j8 = 25; j8 < 172; j8++)
                {
                    if(aClass30_Sub2_Sub1_Sub2_1197.aByteArray1450[j8 + l6 * aClass30_Sub2_Sub1_Sub2_1197.anInt1452] == 0 && (j8 > 34 || l6 > 34))
                    {
                        if(j7 == 999)
                            j7 = j8;
                        continue;
                    }
                    if(j7 == 999)
                        continue;
                    l7 = j8;
                    break;
                }

                anIntArray1052[l6 - 5] = j7 - 25;
                anIntArray1229[l6 - 5] = l7 - j7;
            }

            Class30_Sub2_Sub1_Sub3.method365(-950, 479, 96);
            anIntArray1180 = Class30_Sub2_Sub1_Sub3.anIntArray1472;
            Class30_Sub2_Sub1_Sub3.method365(-950, 190, 261);
            anIntArray1181 = Class30_Sub2_Sub1_Sub3.anIntArray1472;
            Class30_Sub2_Sub1_Sub3.method365(-950, 512, 334);
            anIntArray1182 = Class30_Sub2_Sub1_Sub3.anIntArray1472;
            int ai[] = new int[9];
            for(int i8 = 0; i8 < 9; i8++)
            {
                int k8 = 128 + i8 * 32 + 15;
                int l8 = 600 + k8 * 3;
                int i9 = Class30_Sub2_Sub1_Sub3.anIntArray1470[k8];
                ai[i8] = l8 * i9 >> 16;
            }

            Class25.method310(500, 800, 512, 334, ai, aBoolean1231);
            Class34.method487(class44_4);
            aClass48_879 = new Class48(this, anInt1096);
            method12(aClass48_879, 10);
            Class30_Sub2_Sub4_Sub5.aClient1609 = this;
            Class46.aClient765 = this;
            Class5.aClient82 = this;
            return;
        }
        catch(Exception exception)
        {
            signlink.reporterror("loaderror " + aString1049 + " " + anInt1079);
        }
        aBoolean926 = true;
    }

    /**
     * Player list updating, this nasty loop goes through every player
     * This includes both the appearance updates and location updates
     * for all players in the local list (cache), it's honestly
     * monolithic. It may be worth attempting a refactor on this eventually.
     * @param class30_sub2_sub2_1083 the input stream
     * @param i expected packet size
     * @param byte0 a value representing 8?
     */
    private final void method91(Class30_Sub2_Sub2 class30_sub2_sub2_1083, int i, byte byte0) {
        System.out.println("METHOD 91 CALLED");
        if(byte0 == 8)
            byte0 = 0;
        else
            anInt1119 = -50;

        /**
         * anInt1407 is our bit position, this loop will run until it receives bits passed
         * packet size.i.e., 39 + 11 = 50. i
         * As such this only runs once, despite what it appears to do.
         */
        while(class30_sub2_sub2_1083.anInt1407 + 10 < i * 8) {
            // player index id for next player to update
            int j = class30_sub2_sub2_1083.method419(11, 0);
            System.out.println("\n");
            System.out.println("Player list updating 11bit ID: " + j);
            // 2047 max player count, allows us to break past this
            if(j == 2047) {
                break;
            }
            
            /**
             * APPEARANCE UPDATING:
             * Checks if there's a cached buffer, aka a literal fucking stream
             * for our player. There isn't on the first packet because this is set
             * in method49, our update block flags... Jesus.
             */
            // if player is not in array...
            if(aClass30_Sub2_Sub4_Sub1_Sub2Array890[j] == null) {
                // add player instance to player array
                aClass30_Sub2_Sub4_Sub1_Sub2Array890[j] = new Class30_Sub2_Sub4_Sub1_Sub2();
                //System.out.println("player " + j + " added to update buffer");
                //System.out.println("this should have a value: " + aClass30_Sub2_Sub2Array895[j]);
                // for some reason this is always gonna be null, but i wanna update my dudes appearance lol
                // i think this is because our player is null until our block flag update
                if(aClass30_Sub2_Sub2Array895[j] != null) {
                    // Appearance loop, I believe
                    System.out.println("Updating players appearance for player IDX: " + j);
                    aClass30_Sub2_Sub4_Sub1_Sub2Array890[j].method451(0, aClass30_Sub2_Sub2Array895[j]);
                }
            }

            /**
             * LOCATION UPDATING
             */
            // adds player to local player list
            anIntArray892[anInt891++] = j;
            // Sets the player stream
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[j];


            class30_sub2_sub4_sub1_sub2.anInt1537 = anInt1161;

            // It then reads a 1 bit quantity that defines whether or not the client has a chunk in the player update block list.
            // I think this checks if method49 has run before... 
            // It hasn't so we'll say no. But next packet we send,
            // it has, so we'll update this to true and therefore the player
            // can update their appearance from then on and other
            // block flag updates
            int k = class30_sub2_sub2_1083.method419(1, 0);
            System.out.println("Update block flag cached?: " + k);
            if(k == 1)
                anIntArray894[anInt893++] = j;

            // clear awaiting point queue, like when telleing 
            int l = class30_sub2_sub2_1083.method419(1, 0);
            System.out.println("Clear awaiting-point queue?: " + l);
            // players x/y
            // this is all other players co-ordinates relative to our players,
            // we don't actually have any 'other' players though...
            int i1 = class30_sub2_sub2_1083.method419(5, 0);
            System.out.println("Update player to X co-ordinate: " + i1);

            if(i1 > 15)
                i1 -= 32;

            int j1 = class30_sub2_sub2_1083.method419(5, 0);
            System.out.println("Update player to Y co-ordinate: " + j1);
            if(j1 > 15)
                j1 -= 32;

            class30_sub2_sub4_sub1_sub2.method445(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0] + j1, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0] + i1, l == 1, false);
        }
        System.out.println("\n");
        class30_sub2_sub2_1083.method420(true);
    }

    public final void method92(boolean flag)
    {
        aBoolean1157 &= flag;
        if(anInt1021 != 0)
            return;
        if(super.anInt26 == 1)
        {
            int i = super.anInt27 - 25 - 550;
            int j = super.anInt28 - 5 - 4;
            if(i >= 0 && j >= 0 && i < 146 && j < 151)
            {
                i -= 73;
                j -= 75;
                int k = anInt1185 + anInt1209 & 0x7ff;
                int i1 = Class30_Sub2_Sub1_Sub3.anIntArray1470[k];
                int j1 = Class30_Sub2_Sub1_Sub3.anIntArray1471[k];
                i1 = i1 * (anInt1170 + 256) >> 8;
                j1 = j1 * (anInt1170 + 256) >> 8;
                int k1 = j * i1 + i * j1 >> 11;
                int l1 = j * j1 - i * i1 >> 11;
                int i2 = ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 + k1 >> 7;
                int j2 = ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 - l1 >> 7;
                boolean flag1 = method85(1, 0, 0, -11308, 0, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0], 0, 0, j2, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0], true, i2);
                if(flag1)
                {
                    aClass30_Sub2_Sub2_1192.method398(i);
                    aClass30_Sub2_Sub2_1192.method398(j);
                    aClass30_Sub2_Sub2_1192.method399(anInt1185);
                    aClass30_Sub2_Sub2_1192.method398(57);
                    aClass30_Sub2_Sub2_1192.method398(anInt1209);
                    aClass30_Sub2_Sub2_1192.method398(anInt1170);
                    aClass30_Sub2_Sub2_1192.method398(89);
                    aClass30_Sub2_Sub2_1192.method399(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550);
                    aClass30_Sub2_Sub2_1192.method399(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551);
                    aClass30_Sub2_Sub2_1192.method398(anInt1264);
                    aClass30_Sub2_Sub2_1192.method398(63);
                }
            }
            anInt1117++;
            if(anInt1117 > 1151)
            {
                anInt1117 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 246);
                aClass30_Sub2_Sub2_1192.method398(0);
                int l = aClass30_Sub2_Sub2_1192.anInt1406;
                if((int)(Math.random() * 2D) == 0)
                    aClass30_Sub2_Sub2_1192.method398(101);
                aClass30_Sub2_Sub2_1192.method398(197);
                aClass30_Sub2_Sub2_1192.method399((int)(Math.random() * 65536D));
                aClass30_Sub2_Sub2_1192.method398((int)(Math.random() * 256D));
                aClass30_Sub2_Sub2_1192.method398(67);
                aClass30_Sub2_Sub2_1192.method399(14214);
                if((int)(Math.random() * 2D) == 0)
                    aClass30_Sub2_Sub2_1192.method399(29487);
                aClass30_Sub2_Sub2_1192.method399((int)(Math.random() * 65536D));
                if((int)(Math.random() * 2D) == 0)
                    aClass30_Sub2_Sub2_1192.method398(220);
                aClass30_Sub2_Sub2_1192.method398(180);
                aClass30_Sub2_Sub2_1192.method407(aClass30_Sub2_Sub2_1192.anInt1406 - l, (byte)0);
            }
        }
    }

    public final String method93(int i, int j)
    {
        if(i <= 0)
            opcode = aClass30_Sub2_Sub2_1083.method408();
        if(j < 0x3b9ac9ff)
            return String.valueOf(j);
        else
            return "*";
    }

    public final void method94(int i)
    {
        if(i != -13873)
        {
            for(int j = 1; j > 0; j++);
        }
        Graphics g = method11(0).getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, 765, 503);
        method4(false, 1);
        if(aBoolean926)
        {
            aBoolean831 = false;
            g.setFont(new Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            int k = 35;
            g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, k);
            k += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, k);
            k += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, k);
            k += 30;
            g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, k);
            k += 30;
            g.drawString("3: Try using a different game-world", 30, k);
            k += 30;
            g.drawString("4: Try rebooting your computer", 30, k);
            k += 30;
            g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, k);
        }
        if(aBoolean1176)
        {
            aBoolean831 = false;
            g.setFont(new Font("Helvetica", 1, 20));
            g.setColor(Color.white);
            g.drawString("Error - unable to load game!", 50, 50);
            g.drawString("To play RuneScape make sure you play from", 50, 100);
            g.drawString("http://www.runescape.com", 50, 150);
        }
        if(aBoolean1252)
        {
            aBoolean831 = false;
            g.setColor(Color.yellow);
            int l = 35;
            g.drawString("Error a copy of RuneScape already appears to be loaded", 30, l);
            l += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, l);
            l += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, l);
            l += 30;
            g.drawString("2: Try rebooting your computer, and reloading", 30, l);
            l += 30;
        }
    }

    public final URL getCodeBase()
    {
        if(signlink.mainapp != null)
            return signlink.mainapp.getCodeBase();
        try
        {
            if(super.aFrame_Sub1_15 != null)
                return new URL("http://127.0.0.1:" + (80 + anInt958));
        }
        catch(Exception _ex) { }
        return super.getCodeBase();
    }

    public final void method95(int i)
    {
        for(int j = 0; j < anInt836; j++)
        {
            int k = anIntArray837[j];
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[k];
            if(class30_sub2_sub4_sub1_sub1 != null)
                method96(46988, class30_sub2_sub4_sub1_sub1.aClass5_1696.aByte68, class30_sub2_sub4_sub1_sub1);
        }

        if(i != -8066)
            anInt1218 = 148;
    }

    public final void method96(int i, int j, Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1)
    {
        if(i != 46988)
            opcode = -1;
        if(class30_sub2_sub4_sub1.anInt1550 < 128 || class30_sub2_sub4_sub1.anInt1551 < 128 || class30_sub2_sub4_sub1.anInt1550 >= 13184 || class30_sub2_sub4_sub1.anInt1551 >= 13184)
        {
            class30_sub2_sub4_sub1.anInt1526 = -1;
            class30_sub2_sub4_sub1.anInt1520 = -1;
            class30_sub2_sub4_sub1.anInt1547 = 0;
            class30_sub2_sub4_sub1.anInt1548 = 0;
            class30_sub2_sub4_sub1.anInt1550 = class30_sub2_sub4_sub1.anIntArray1500[0] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.anInt1551 = class30_sub2_sub4_sub1.anIntArray1501[0] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.method446(true);
        }
        if(class30_sub2_sub4_sub1 == aClass30_Sub2_Sub4_Sub1_Sub2_1126 && (class30_sub2_sub4_sub1.anInt1550 < 1536 || class30_sub2_sub4_sub1.anInt1551 < 1536 || class30_sub2_sub4_sub1.anInt1550 >= 11776 || class30_sub2_sub4_sub1.anInt1551 >= 11776))
        {
            class30_sub2_sub4_sub1.anInt1526 = -1;
            class30_sub2_sub4_sub1.anInt1520 = -1;
            class30_sub2_sub4_sub1.anInt1547 = 0;
            class30_sub2_sub4_sub1.anInt1548 = 0;
            class30_sub2_sub4_sub1.anInt1550 = class30_sub2_sub4_sub1.anIntArray1500[0] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.anInt1551 = class30_sub2_sub4_sub1.anIntArray1501[0] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.method446(true);
        }
        if(class30_sub2_sub4_sub1.anInt1547 > anInt1161)
            method97(class30_sub2_sub4_sub1, true);
        else
        if(class30_sub2_sub4_sub1.anInt1548 >= anInt1161)
            method98(class30_sub2_sub4_sub1, aByte1012);
        else
            method99((byte)34, class30_sub2_sub4_sub1);
        method100(class30_sub2_sub4_sub1, -843);
        method101(class30_sub2_sub4_sub1, -805);
    }

    public final void method97(Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, boolean flag)
    {
        int i = class30_sub2_sub4_sub1.anInt1547 - anInt1161;
        int j = class30_sub2_sub4_sub1.anInt1543 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
        int k = class30_sub2_sub4_sub1.anInt1545 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
        class30_sub2_sub4_sub1.anInt1550 += (j - class30_sub2_sub4_sub1.anInt1550) / i;
        if(!flag)
            return;
        class30_sub2_sub4_sub1.anInt1551 += (k - class30_sub2_sub4_sub1.anInt1551) / i;
        class30_sub2_sub4_sub1.anInt1503 = 0;
        if(class30_sub2_sub4_sub1.anInt1549 == 0)
            class30_sub2_sub4_sub1.anInt1510 = 1024;
        if(class30_sub2_sub4_sub1.anInt1549 == 1)
            class30_sub2_sub4_sub1.anInt1510 = 1536;
        if(class30_sub2_sub4_sub1.anInt1549 == 2)
            class30_sub2_sub4_sub1.anInt1510 = 0;
        if(class30_sub2_sub4_sub1.anInt1549 == 3)
            class30_sub2_sub4_sub1.anInt1510 = 512;
    }

    public final void method98(Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, byte byte0)
    {
        if(class30_sub2_sub4_sub1.anInt1548 == anInt1161 || class30_sub2_sub4_sub1.anInt1526 == -1 || class30_sub2_sub4_sub1.anInt1529 != 0 || class30_sub2_sub4_sub1.anInt1528 + 1 > Class20.aClass20Array351[class30_sub2_sub4_sub1.anInt1526].method258(class30_sub2_sub4_sub1.anInt1527, (byte)-39))
        {
            int i = class30_sub2_sub4_sub1.anInt1548 - class30_sub2_sub4_sub1.anInt1547;
            int j = anInt1161 - class30_sub2_sub4_sub1.anInt1547;
            int k = class30_sub2_sub4_sub1.anInt1543 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            int l = class30_sub2_sub4_sub1.anInt1545 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            int i1 = class30_sub2_sub4_sub1.anInt1544 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            int j1 = class30_sub2_sub4_sub1.anInt1546 * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
            class30_sub2_sub4_sub1.anInt1550 = (k * (i - j) + i1 * j) / i;
            class30_sub2_sub4_sub1.anInt1551 = (l * (i - j) + j1 * j) / i;
        }
        class30_sub2_sub4_sub1.anInt1503 = 0;
        if(class30_sub2_sub4_sub1.anInt1549 == 0)
            class30_sub2_sub4_sub1.anInt1510 = 1024;
        if(class30_sub2_sub4_sub1.anInt1549 == 1)
            class30_sub2_sub4_sub1.anInt1510 = 1536;
        if(class30_sub2_sub4_sub1.anInt1549 == 2)
            class30_sub2_sub4_sub1.anInt1510 = 0;
        if(class30_sub2_sub4_sub1.anInt1549 == 3)
            class30_sub2_sub4_sub1.anInt1510 = 512;
        class30_sub2_sub4_sub1.anInt1552 = class30_sub2_sub4_sub1.anInt1510;
        if(byte0 != aByte1012)
            anInt1096 = -383;
    }

    public final void method99(byte byte0, Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1)
    {
        class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1511;
        if(class30_sub2_sub4_sub1.anInt1525 == 0)
        {
            class30_sub2_sub4_sub1.anInt1503 = 0;
            return;
        }
        if(class30_sub2_sub4_sub1.anInt1526 != -1 && class30_sub2_sub4_sub1.anInt1529 == 0)
        {
            Class20 class20 = Class20.aClass20Array351[class30_sub2_sub4_sub1.anInt1526];
            if(class30_sub2_sub4_sub1.anInt1542 > 0 && class20.anInt363 == 0)
            {
                class30_sub2_sub4_sub1.anInt1503++;
                return;
            }
            if(class30_sub2_sub4_sub1.anInt1542 <= 0 && class20.anInt364 == 0)
            {
                class30_sub2_sub4_sub1.anInt1503++;
                return;
            }
        }
        int i = class30_sub2_sub4_sub1.anInt1550;
        int j = class30_sub2_sub4_sub1.anInt1551;
        int k = class30_sub2_sub4_sub1.anIntArray1500[class30_sub2_sub4_sub1.anInt1525 - 1] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
        int l = class30_sub2_sub4_sub1.anIntArray1501[class30_sub2_sub4_sub1.anInt1525 - 1] * 128 + class30_sub2_sub4_sub1.anInt1540 * 64;
        if(k - i > 256 || k - i < -256 || l - j > 256 || l - j < -256)
        {
            class30_sub2_sub4_sub1.anInt1550 = k;
            class30_sub2_sub4_sub1.anInt1551 = l;
            return;
        }
        if(i < k)
        {
            if(j < l)
                class30_sub2_sub4_sub1.anInt1510 = 1280;
            else
            if(j > l)
                class30_sub2_sub4_sub1.anInt1510 = 1792;
            else
                class30_sub2_sub4_sub1.anInt1510 = 1536;
        } else
        if(i > k)
        {
            if(j < l)
                class30_sub2_sub4_sub1.anInt1510 = 768;
            else
            if(j > l)
                class30_sub2_sub4_sub1.anInt1510 = 256;
            else
                class30_sub2_sub4_sub1.anInt1510 = 512;
        } else
        if(j < l)
            class30_sub2_sub4_sub1.anInt1510 = 1024;
        else
            class30_sub2_sub4_sub1.anInt1510 = 0;
        int i1 = class30_sub2_sub4_sub1.anInt1510 - class30_sub2_sub4_sub1.anInt1552 & 0x7ff;
        if(i1 > 1024)
            i1 -= 2048;
        int j1 = class30_sub2_sub4_sub1.anInt1555;
        if(i1 >= -256 && i1 <= 256)
            j1 = class30_sub2_sub4_sub1.anInt1554;
        else
        if(i1 >= 256 && i1 < 768)
            j1 = class30_sub2_sub4_sub1.anInt1557;
        else
        if(i1 >= -768 && i1 <= -256)
            j1 = class30_sub2_sub4_sub1.anInt1556;
        if(j1 == -1)
            j1 = class30_sub2_sub4_sub1.anInt1554;
        class30_sub2_sub4_sub1.anInt1517 = j1;
        int k1 = 4;
        if(byte0 != 34)
            anInt1096 = 285;
        if(class30_sub2_sub4_sub1.anInt1552 != class30_sub2_sub4_sub1.anInt1510 && class30_sub2_sub4_sub1.anInt1502 == -1 && class30_sub2_sub4_sub1.anInt1504 != 0)
            k1 = 2;
        if(class30_sub2_sub4_sub1.anInt1525 > 2)
            k1 = 6;
        if(class30_sub2_sub4_sub1.anInt1525 > 3)
            k1 = 8;
        if(class30_sub2_sub4_sub1.anInt1503 > 0 && class30_sub2_sub4_sub1.anInt1525 > 1)
        {
            k1 = 8;
            class30_sub2_sub4_sub1.anInt1503--;
        }
        if(class30_sub2_sub4_sub1.aBooleanArray1553[class30_sub2_sub4_sub1.anInt1525 - 1])
            k1 <<= 1;
        if(k1 >= 8 && class30_sub2_sub4_sub1.anInt1517 == class30_sub2_sub4_sub1.anInt1554 && class30_sub2_sub4_sub1.anInt1505 != -1)
            class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1505;
        if(i < k)
        {
            class30_sub2_sub4_sub1.anInt1550 += k1;
            if(class30_sub2_sub4_sub1.anInt1550 > k)
                class30_sub2_sub4_sub1.anInt1550 = k;
        } else
        if(i > k)
        {
            class30_sub2_sub4_sub1.anInt1550 -= k1;
            if(class30_sub2_sub4_sub1.anInt1550 < k)
                class30_sub2_sub4_sub1.anInt1550 = k;
        }
        if(j < l)
        {
            class30_sub2_sub4_sub1.anInt1551 += k1;
            if(class30_sub2_sub4_sub1.anInt1551 > l)
                class30_sub2_sub4_sub1.anInt1551 = l;
        } else
        if(j > l)
        {
            class30_sub2_sub4_sub1.anInt1551 -= k1;
            if(class30_sub2_sub4_sub1.anInt1551 < l)
                class30_sub2_sub4_sub1.anInt1551 = l;
        }
        if(class30_sub2_sub4_sub1.anInt1550 == k && class30_sub2_sub4_sub1.anInt1551 == l)
        {
            class30_sub2_sub4_sub1.anInt1525--;
            if(class30_sub2_sub4_sub1.anInt1542 > 0)
                class30_sub2_sub4_sub1.anInt1542--;
        }
    }

    public final void method100(Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, int i)
    {
        if(i >= 0)
            return;
        if(class30_sub2_sub4_sub1.anInt1504 == 0)
            return;
        if(class30_sub2_sub4_sub1.anInt1502 != -1 && class30_sub2_sub4_sub1.anInt1502 < 32768)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[class30_sub2_sub4_sub1.anInt1502];
            if(class30_sub2_sub4_sub1_sub1 != null)
            {
                int i1 = class30_sub2_sub4_sub1.anInt1550 - ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550;
                int k1 = class30_sub2_sub4_sub1.anInt1551 - ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551;
                if(i1 != 0 || k1 != 0)
                    class30_sub2_sub4_sub1.anInt1510 = (int)(Math.atan2(i1, k1) * 325.94900000000001D) & 0x7ff;
            }
        }
        if(class30_sub2_sub4_sub1.anInt1502 >= 32768)
        {
            int j = class30_sub2_sub4_sub1.anInt1502 - 32768;
            if(j == anInt884)
                j = anInt889;
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[j];
            if(class30_sub2_sub4_sub1_sub2 != null)
            {
                int l1 = class30_sub2_sub4_sub1.anInt1550 - ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550;
                int i2 = class30_sub2_sub4_sub1.anInt1551 - ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551;
                if(l1 != 0 || i2 != 0)
                    class30_sub2_sub4_sub1.anInt1510 = (int)(Math.atan2(l1, i2) * 325.94900000000001D) & 0x7ff;
            }
        }
        if((class30_sub2_sub4_sub1.anInt1538 != 0 || class30_sub2_sub4_sub1.anInt1539 != 0) && (class30_sub2_sub4_sub1.anInt1525 == 0 || class30_sub2_sub4_sub1.anInt1503 > 0))
        {
            int k = class30_sub2_sub4_sub1.anInt1550 - (class30_sub2_sub4_sub1.anInt1538 - anInt1034 - anInt1034) * 64;
            int j1 = class30_sub2_sub4_sub1.anInt1551 - (class30_sub2_sub4_sub1.anInt1539 - anInt1035 - anInt1035) * 64;
            if(k != 0 || j1 != 0)
                class30_sub2_sub4_sub1.anInt1510 = (int)(Math.atan2(k, j1) * 325.94900000000001D) & 0x7ff;
            class30_sub2_sub4_sub1.anInt1538 = 0;
            class30_sub2_sub4_sub1.anInt1539 = 0;
        }
        int l = class30_sub2_sub4_sub1.anInt1510 - class30_sub2_sub4_sub1.anInt1552 & 0x7ff;
        if(l != 0)
        {
            if(l < class30_sub2_sub4_sub1.anInt1504 || l > 2048 - class30_sub2_sub4_sub1.anInt1504)
                class30_sub2_sub4_sub1.anInt1552 = class30_sub2_sub4_sub1.anInt1510;
            else
            if(l > 1024)
                class30_sub2_sub4_sub1.anInt1552 -= class30_sub2_sub4_sub1.anInt1504;
            else
                class30_sub2_sub4_sub1.anInt1552 += class30_sub2_sub4_sub1.anInt1504;
            class30_sub2_sub4_sub1.anInt1552 &= 0x7ff;
            if(class30_sub2_sub4_sub1.anInt1517 == class30_sub2_sub4_sub1.anInt1511 && class30_sub2_sub4_sub1.anInt1552 != class30_sub2_sub4_sub1.anInt1510)
            {
                if(class30_sub2_sub4_sub1.anInt1512 != -1)
                {
                    class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1512;
                    return;
                }
                class30_sub2_sub4_sub1.anInt1517 = class30_sub2_sub4_sub1.anInt1554;
            }
        }
    }

    public final void method101(Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, int i)
    {
        if(i >= 0)
            aBoolean919 = !aBoolean919;
        class30_sub2_sub4_sub1.aBoolean1541 = false;
        if(class30_sub2_sub4_sub1.anInt1517 != -1)
        {
            Class20 class20 = Class20.aClass20Array351[class30_sub2_sub4_sub1.anInt1517];
            class30_sub2_sub4_sub1.anInt1519++;
            if(class30_sub2_sub4_sub1.anInt1518 < class20.anInt352 && class30_sub2_sub4_sub1.anInt1519 > class20.method258(class30_sub2_sub4_sub1.anInt1518, (byte)-39))
            {
                class30_sub2_sub4_sub1.anInt1519 = 0;
                class30_sub2_sub4_sub1.anInt1518++;
            }
            if(class30_sub2_sub4_sub1.anInt1518 >= class20.anInt352)
            {
                class30_sub2_sub4_sub1.anInt1519 = 0;
                class30_sub2_sub4_sub1.anInt1518 = 0;
            }
        }
        if(class30_sub2_sub4_sub1.anInt1520 != -1 && anInt1161 >= class30_sub2_sub4_sub1.anInt1523)
        {
            if(class30_sub2_sub4_sub1.anInt1521 < 0)
                class30_sub2_sub4_sub1.anInt1521 = 0;
            Class20 class20_1 = Class23.aClass23Array403[class30_sub2_sub4_sub1.anInt1520].aClass20_407;
            for(class30_sub2_sub4_sub1.anInt1522++; class30_sub2_sub4_sub1.anInt1521 < class20_1.anInt352 && class30_sub2_sub4_sub1.anInt1522 > class20_1.method258(class30_sub2_sub4_sub1.anInt1521, (byte)-39); class30_sub2_sub4_sub1.anInt1521++)
                class30_sub2_sub4_sub1.anInt1522 -= class20_1.method258(class30_sub2_sub4_sub1.anInt1521, (byte)-39);

            if(class30_sub2_sub4_sub1.anInt1521 >= class20_1.anInt352 && (class30_sub2_sub4_sub1.anInt1521 < 0 || class30_sub2_sub4_sub1.anInt1521 >= class20_1.anInt352))
                class30_sub2_sub4_sub1.anInt1520 = -1;
        }
        if(class30_sub2_sub4_sub1.anInt1526 != -1 && class30_sub2_sub4_sub1.anInt1529 <= 1)
        {
            Class20 class20_2 = Class20.aClass20Array351[class30_sub2_sub4_sub1.anInt1526];
            if(class20_2.anInt363 == 1 && class30_sub2_sub4_sub1.anInt1542 > 0 && class30_sub2_sub4_sub1.anInt1547 <= anInt1161 && class30_sub2_sub4_sub1.anInt1548 < anInt1161)
            {
                class30_sub2_sub4_sub1.anInt1529 = 1;
                return;
            }
        }
        if(class30_sub2_sub4_sub1.anInt1526 != -1 && class30_sub2_sub4_sub1.anInt1529 == 0)
        {
            Class20 class20_3 = Class20.aClass20Array351[class30_sub2_sub4_sub1.anInt1526];
            for(class30_sub2_sub4_sub1.anInt1528++; class30_sub2_sub4_sub1.anInt1527 < class20_3.anInt352 && class30_sub2_sub4_sub1.anInt1528 > class20_3.method258(class30_sub2_sub4_sub1.anInt1527, (byte)-39); class30_sub2_sub4_sub1.anInt1527++)
                class30_sub2_sub4_sub1.anInt1528 -= class20_3.method258(class30_sub2_sub4_sub1.anInt1527, (byte)-39);

            if(class30_sub2_sub4_sub1.anInt1527 >= class20_3.anInt352)
            {
                class30_sub2_sub4_sub1.anInt1527 -= class20_3.anInt356;
                class30_sub2_sub4_sub1.anInt1530++;
                if(class30_sub2_sub4_sub1.anInt1530 >= class20_3.anInt362)
                    class30_sub2_sub4_sub1.anInt1526 = -1;
                if(class30_sub2_sub4_sub1.anInt1527 < 0 || class30_sub2_sub4_sub1.anInt1527 >= class20_3.anInt352)
                    class30_sub2_sub4_sub1.anInt1526 = -1;
            }
            class30_sub2_sub4_sub1.aBoolean1541 = class20_3.aBoolean358;
        }
        if(class30_sub2_sub4_sub1.anInt1529 > 0)
            class30_sub2_sub4_sub1.anInt1529--;
    }

    public final void method102(boolean flag)
    {
        if(!flag)
            anInt939 = aClass17_1000.method246();
        if(aBoolean1255)
        {
            aBoolean1255 = false;
            aClass15_903.method238(4, 23680, super.aGraphics12, 0);
            aClass15_904.method238(357, 23680, super.aGraphics12, 0);
            aClass15_905.method238(4, 23680, super.aGraphics12, 722);
            aClass15_906.method238(205, 23680, super.aGraphics12, 743);
            aClass15_907.method238(0, 23680, super.aGraphics12, 0);
            aClass15_908.method238(4, 23680, super.aGraphics12, 516);
            aClass15_909.method238(205, 23680, super.aGraphics12, 516);
            aClass15_910.method238(357, 23680, super.aGraphics12, 496);
            aClass15_911.method238(338, 23680, super.aGraphics12, 0);
            aBoolean1153 = true;
            aBoolean1223 = true;
            aBoolean1103 = true;
            aBoolean1233 = true;
            if(anInt1023 != 2)
            {
                aClass15_1165.method238(4, 23680, super.aGraphics12, 4);
                aClass15_1164.method238(4, 23680, super.aGraphics12, 550);
            }
        }
        if(anInt1023 == 2)
            method146((byte)1);
        if(aBoolean885 && anInt948 == 1)
            aBoolean1153 = true;
        if(anInt1189 != -1)
        {
            boolean flag1 = method119(anInt945, false, anInt1189);
            if(flag1)
                aBoolean1153 = true;
        }
        if(anInt1246 == 2)
            aBoolean1153 = true;
        if(anInt1086 == 2)
            aBoolean1153 = true;
        if(aBoolean1153)
        {
            method36((byte)-81);
            aBoolean1153 = false;
        }
        if(anInt1276 == -1)
        {
            aClass9_1059.anInt224 = anInt1211 - anInt1089 - 77;
            if(super.anInt20 > 448 && super.anInt20 < 560 && super.anInt21 > 332)
                method65(463, 77, super.anInt20 - 17, super.anInt21 - 357, aClass9_1059, 0, false, anInt1211, 0);
            int i = anInt1211 - 77 - aClass9_1059.anInt224;
            if(i < 0)
                i = 0;
            if(i > anInt1211 - 77)
                i = anInt1211 - 77;
            if(anInt1089 != i)
            {
                anInt1089 = i;
                aBoolean1223 = true;
            }
        }
        if(anInt1276 != -1)
        {
            boolean flag2 = method119(anInt945, false, anInt1276);
            if(flag2)
                aBoolean1223 = true;
        }
        if(anInt1246 == 3)
            aBoolean1223 = true;
        if(anInt1086 == 3)
            aBoolean1223 = true;
        if(aString844 != null)
            aBoolean1223 = true;
        if(aBoolean885 && anInt948 == 2)
            aBoolean1223 = true;
        if(aBoolean1223)
        {
            method18(6);
            aBoolean1223 = false;
        }
        if(anInt1023 == 2)
        {
            method126(false);
            aClass15_1164.method238(4, 23680, super.aGraphics12, 550);
        }
        if(anInt1054 != -1)
            aBoolean1103 = true;
        if(aBoolean1103)
        {
            if(anInt1054 != -1 && anInt1054 == anInt1221)
            {
                anInt1054 = -1;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 120);
                aClass30_Sub2_Sub2_1192.method398(anInt1221);
            }
            aBoolean1103 = false;
            aClass15_1125.method237(0);
            aClass30_Sub2_Sub1_Sub2_1029.method361(0, 16083, 0);
            if(anInt1189 == -1)
            {
                if(anIntArray1130[anInt1221] != -1)
                {
                    if(anInt1221 == 0)
                        aClass30_Sub2_Sub1_Sub2_1143.method361(22, 16083, 10);
                    if(anInt1221 == 1)
                        aClass30_Sub2_Sub1_Sub2_1144.method361(54, 16083, 8);
                    if(anInt1221 == 2)
                        aClass30_Sub2_Sub1_Sub2_1144.method361(82, 16083, 8);
                    if(anInt1221 == 3)
                        aClass30_Sub2_Sub1_Sub2_1145.method361(110, 16083, 8);
                    if(anInt1221 == 4)
                        aClass30_Sub2_Sub1_Sub2_1147.method361(153, 16083, 8);
                    if(anInt1221 == 5)
                        aClass30_Sub2_Sub1_Sub2_1147.method361(181, 16083, 8);
                    if(anInt1221 == 6)
                        aClass30_Sub2_Sub1_Sub2_1146.method361(209, 16083, 9);
                }
                if(anIntArray1130[0] != -1 && (anInt1054 != 0 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[0].method361(29, 16083, 13);
                if(anIntArray1130[1] != -1 && (anInt1054 != 1 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[1].method361(53, 16083, 11);
                if(anIntArray1130[2] != -1 && (anInt1054 != 2 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[2].method361(82, 16083, 11);
                if(anIntArray1130[3] != -1 && (anInt1054 != 3 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[3].method361(115, 16083, 12);
                if(anIntArray1130[4] != -1 && (anInt1054 != 4 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[4].method361(153, 16083, 13);
                if(anIntArray1130[5] != -1 && (anInt1054 != 5 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[5].method361(180, 16083, 11);
                if(anIntArray1130[6] != -1 && (anInt1054 != 6 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[6].method361(208, 16083, 13);
            }
            aClass15_1125.method238(160, 23680, super.aGraphics12, 516);
            aClass15_1124.method237(0);
            aClass30_Sub2_Sub1_Sub2_1028.method361(0, 16083, 0);
            if(anInt1189 == -1)
            {
                if(anIntArray1130[anInt1221] != -1)
                {
                    if(anInt1221 == 7)
                        aClass30_Sub2_Sub1_Sub2_865.method361(42, 16083, 0);
                    if(anInt1221 == 8)
                        aClass30_Sub2_Sub1_Sub2_866.method361(74, 16083, 0);
                    if(anInt1221 == 9)
                        aClass30_Sub2_Sub1_Sub2_866.method361(102, 16083, 0);
                    if(anInt1221 == 10)
                        aClass30_Sub2_Sub1_Sub2_867.method361(130, 16083, 1);
                    if(anInt1221 == 11)
                        aClass30_Sub2_Sub1_Sub2_869.method361(173, 16083, 0);
                    if(anInt1221 == 12)
                        aClass30_Sub2_Sub1_Sub2_869.method361(201, 16083, 0);
                    if(anInt1221 == 13)
                        aClass30_Sub2_Sub1_Sub2_868.method361(229, 16083, 0);
                }
                if(anIntArray1130[8] != -1 && (anInt1054 != 8 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[7].method361(74, 16083, 2);
                if(anIntArray1130[9] != -1 && (anInt1054 != 9 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[8].method361(102, 16083, 3);
                if(anIntArray1130[10] != -1 && (anInt1054 != 10 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[9].method361(137, 16083, 4);
                if(anIntArray1130[11] != -1 && (anInt1054 != 11 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[10].method361(174, 16083, 2);
                if(anIntArray1130[12] != -1 && (anInt1054 != 12 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[11].method361(201, 16083, 2);
                if(anIntArray1130[13] != -1 && (anInt1054 != 13 || anInt1161 % 20 < 10))
                    aClass30_Sub2_Sub1_Sub2Array947[12].method361(226, 16083, 2);
            }
            aClass15_1124.method238(466, 23680, super.aGraphics12, 496);
            aClass15_1165.method237(0);
        }
        if(aBoolean1233)
        {
            aBoolean1233 = false;
            aClass15_1123.method237(0);
            aClass30_Sub2_Sub1_Sub2_1027.method361(0, 16083, 0);
            aClass30_Sub2_Sub1_Sub4_1271.method382(0xffffff, 55, anInt939, "Public chat", 28, true);
            if(anInt1287 == 0)
                aClass30_Sub2_Sub1_Sub4_1271.method382(65280, 55, anInt939, "On", 41, true);
            if(anInt1287 == 1)
                aClass30_Sub2_Sub1_Sub4_1271.method382(0xffff00, 55, anInt939, "Friends", 41, true);
            if(anInt1287 == 2)
                aClass30_Sub2_Sub1_Sub4_1271.method382(0xff0000, 55, anInt939, "Off", 41, true);
            if(anInt1287 == 3)
                aClass30_Sub2_Sub1_Sub4_1271.method382(65535, 55, anInt939, "Hide", 41, true);
            aClass30_Sub2_Sub1_Sub4_1271.method382(0xffffff, 184, anInt939, "Private chat", 28, true);
            if(anInt845 == 0)
                aClass30_Sub2_Sub1_Sub4_1271.method382(65280, 184, anInt939, "On", 41, true);
            if(anInt845 == 1)
                aClass30_Sub2_Sub1_Sub4_1271.method382(0xffff00, 184, anInt939, "Friends", 41, true);
            if(anInt845 == 2)
                aClass30_Sub2_Sub1_Sub4_1271.method382(0xff0000, 184, anInt939, "Off", 41, true);
            aClass30_Sub2_Sub1_Sub4_1271.method382(0xffffff, 324, anInt939, "Trade/compete", 28, true);
            if(anInt1248 == 0)
                aClass30_Sub2_Sub1_Sub4_1271.method382(65280, 324, anInt939, "On", 41, true);
            if(anInt1248 == 1)
                aClass30_Sub2_Sub1_Sub4_1271.method382(0xffff00, 324, anInt939, "Friends", 41, true);
            if(anInt1248 == 2)
                aClass30_Sub2_Sub1_Sub4_1271.method382(0xff0000, 324, anInt939, "Off", 41, true);
            aClass30_Sub2_Sub1_Sub4_1271.method382(0xffffff, 458, anInt939, "Report abuse", 33, true);
            aClass15_1123.method238(453, 23680, super.aGraphics12, 0);
            aClass15_1165.method237(0);
        }
        anInt945 = 0;
    }

    public final boolean method103(Class9 class9, boolean flag)
    {
        int i = class9.anInt214;
        if(flag)
            method6();
        if(i >= 1 && i <= 200 || i >= 701 && i <= 900)
        {
            if(i >= 801)
                i -= 701;
            else
            if(i >= 701)
                i -= 601;
            else
            if(i >= 101)
                i -= 101;
            else
                i--;
            aStringArray1199[anInt1133] = "Remove @whi@" + aStringArray1082[i];
            anIntArray1093[anInt1133] = 792;
            anInt1133++;
            aStringArray1199[anInt1133] = "Message @whi@" + aStringArray1082[i];
            anIntArray1093[anInt1133] = 639;
            anInt1133++;
            return true;
        }
        if(i >= 401 && i <= 500)
        {
            aStringArray1199[anInt1133] = "Remove @whi@" + class9.aString248;
            anIntArray1093[anInt1133] = 322;
            anInt1133++;
            return true;
        } else
        {
            return false;
        }
    }

    public final void method104(boolean flag)
    {
        Class30_Sub2_Sub4_Sub3 class30_sub2_sub4_sub3 = (Class30_Sub2_Sub4_Sub3)aClass19_1056.method252();
        aBoolean1157 &= flag;
        for(; class30_sub2_sub4_sub3 != null; class30_sub2_sub4_sub3 = (Class30_Sub2_Sub4_Sub3)aClass19_1056.method254(false))
            if(class30_sub2_sub4_sub3.anInt1560 != anInt918 || class30_sub2_sub4_sub3.aBoolean1567)
                class30_sub2_sub4_sub3.method329();
            else
            if(anInt1161 >= class30_sub2_sub4_sub3.anInt1564)
            {
                class30_sub2_sub4_sub3.method454(anInt945, true);
                if(class30_sub2_sub4_sub3.aBoolean1567)
                    class30_sub2_sub4_sub3.method329();
                else
                    aClass25_946.method285(class30_sub2_sub4_sub3.anInt1560, 0, (byte)6, class30_sub2_sub4_sub3.anInt1563, -1, class30_sub2_sub4_sub3.anInt1562, 60, class30_sub2_sub4_sub3.anInt1561, class30_sub2_sub4_sub3, false);
            }

    }

    public final void method105(int i, int j, int k, Class9 class9, int l)
    {
        if(i != 8)
            aBoolean991 = !aBoolean991;
        if(class9.anInt262 != 0 || class9.anIntArray240 == null)
            return;
        if(class9.aBoolean266 && anInt1026 != class9.anInt250 && anInt1048 != class9.anInt250 && anInt1039 != class9.anInt250)
            return;
        int i1 = Class30_Sub2_Sub1.anInt1383;
        int j1 = Class30_Sub2_Sub1.anInt1381;
        int k1 = Class30_Sub2_Sub1.anInt1384;
        int l1 = Class30_Sub2_Sub1.anInt1382;
        Class30_Sub2_Sub1.method333(l + class9.anInt267, k, false, k + class9.anInt220, l);
        int i2 = class9.anIntArray240.length;
        for(int j2 = 0; j2 < i2; j2++)
        {
            int k2 = class9.anIntArray241[j2] + k;
            int l2 = (class9.anIntArray272[j2] + l) - j;
            Class9 class9_1 = Class9.aClass9Array210[class9.anIntArray240[j2]];
            k2 += class9_1.anInt263;
            l2 += class9_1.anInt265;
            if(class9_1.anInt214 > 0)
                method75(950, class9_1);
            if(class9_1.anInt262 == 0)
            {
                if(class9_1.anInt224 > class9_1.anInt261 - class9_1.anInt267)
                    class9_1.anInt224 = class9_1.anInt261 - class9_1.anInt267;
                if(class9_1.anInt224 < 0)
                    class9_1.anInt224 = 0;
                method105(8, class9_1.anInt224, k2, class9_1, l2);
                if(class9_1.anInt261 > class9_1.anInt267)
                    method30(519, class9_1.anInt267, class9_1.anInt224, l2, k2 + class9_1.anInt220, class9_1.anInt261);
            } else
            if(class9_1.anInt262 != 1)
                if(class9_1.anInt262 == 2)
                {
                    int i3 = 0;
                    for(int l3 = 0; l3 < class9_1.anInt267; l3++)
                    {
                        for(int l4 = 0; l4 < class9_1.anInt220; l4++)
                        {
                            int k5 = k2 + l4 * (32 + class9_1.anInt231);
                            int j6 = l2 + l3 * (32 + class9_1.anInt244);
                            if(i3 < 20)
                            {
                                k5 += class9_1.anIntArray215[i3];
                                j6 += class9_1.anIntArray247[i3];
                            }
                            if(class9_1.anIntArray253[i3] > 0)
                            {
                                int k6 = 0;
                                int j7 = 0;
                                int j9 = class9_1.anIntArray253[i3] - 1;
                                if(k5 > Class30_Sub2_Sub1.anInt1383 - 32 && k5 < Class30_Sub2_Sub1.anInt1384 && j6 > Class30_Sub2_Sub1.anInt1381 - 32 && j6 < Class30_Sub2_Sub1.anInt1382 || anInt1086 != 0 && anInt1085 == i3)
                                {
                                    int l9 = 0;
                                    if(anInt1282 == 1 && anInt1283 == i3 && anInt1284 == class9_1.anInt250)
                                        l9 = 0xffffff;
                                    Class30_Sub2_Sub1_Sub1 class30_sub2_sub1_sub1_2 = Class8.method200(j9, class9_1.anIntArray252[i3], l9, 9);
                                    if(class30_sub2_sub1_sub1_2 != null)
                                    {
                                        if(anInt1086 != 0 && anInt1085 == i3 && anInt1084 == class9_1.anInt250)
                                        {
                                            k6 = super.anInt20 - anInt1087;
                                            j7 = super.anInt21 - anInt1088;
                                            if(k6 < 5 && k6 > -5)
                                                k6 = 0;
                                            if(j7 < 5 && j7 > -5)
                                                j7 = 0;
                                            if(anInt989 < 5)
                                            {
                                                k6 = 0;
                                                j7 = 0;
                                            }
                                            class30_sub2_sub1_sub1_2.method350(k5 + k6, j6 + j7, 128, aBoolean1043);
                                            if(j6 + j7 < Class30_Sub2_Sub1.anInt1381 && class9.anInt224 > 0)
                                            {
                                                int i10 = (anInt945 * (Class30_Sub2_Sub1.anInt1381 - j6 - j7)) / 3;
                                                if(i10 > anInt945 * 10)
                                                    i10 = anInt945 * 10;
                                                if(i10 > class9.anInt224)
                                                    i10 = class9.anInt224;
                                                class9.anInt224 -= i10;
                                                anInt1088 += i10;
                                            }
                                            if(j6 + j7 + 32 > Class30_Sub2_Sub1.anInt1382 && class9.anInt224 < class9.anInt261 - class9.anInt267)
                                            {
                                                int j10 = (anInt945 * ((j6 + j7 + 32) - Class30_Sub2_Sub1.anInt1382)) / 3;
                                                if(j10 > anInt945 * 10)
                                                    j10 = anInt945 * 10;
                                                if(j10 > class9.anInt261 - class9.anInt267 - class9.anInt224)
                                                    j10 = class9.anInt261 - class9.anInt267 - class9.anInt224;
                                                class9.anInt224 += j10;
                                                anInt1088 -= j10;
                                            }
                                        } else
                                        if(anInt1246 != 0 && anInt1245 == i3 && anInt1244 == class9_1.anInt250)
                                            class30_sub2_sub1_sub1_2.method350(k5, j6, 128, aBoolean1043);
                                        else
                                            class30_sub2_sub1_sub1_2.method348(k5, 16083, j6);
                                        if(class30_sub2_sub1_sub1_2.anInt1444 == 33 || class9_1.anIntArray252[i3] != 1)
                                        {
                                            int k10 = class9_1.anIntArray252[i3];
                                            aClass30_Sub2_Sub1_Sub4_1270.method385(0, method43(-33245, k10), j6 + 10 + j7, 822, k5 + 1 + k6);
					    if(k10 >= 1000000)
                                            aClass30_Sub2_Sub1_Sub4_1270.method385(0x00ff80, method43(-33245, k10), j6 + 9 + j7, 822, k5 + k6);
					    if(k10 <= 1000000)
                                            aClass30_Sub2_Sub1_Sub4_1270.method385(0xffff00, method43(-33245, k10), j6 + 9 + j7, 822, k5 + k6);
					    if(k10 <= 10000000)
                                            aClass30_Sub2_Sub1_Sub4_1270.method385(0xffff00, method43(-33245, k10), j6 + 9 + j7, 822, k5 + k6);
                                        }
                                    }
                                }
                            } else
                            if(class9_1.aClass30_Sub2_Sub1_Sub1Array209 != null && i3 < 20)
                            {
                                Class30_Sub2_Sub1_Sub1 class30_sub2_sub1_sub1_1 = class9_1.aClass30_Sub2_Sub1_Sub1Array209[i3];
                                if(class30_sub2_sub1_sub1_1 != null)
                                    class30_sub2_sub1_sub1_1.method348(k5, 16083, j6);
                            }
                            i3++;
                        }

                    }

                } else
                if(class9_1.anInt262 == 3)
                {
                    boolean flag = false;
                    if(anInt1039 == class9_1.anInt250 || anInt1048 == class9_1.anInt250 || anInt1026 == class9_1.anInt250)
                        flag = true;
                    int j3;
                    if(method131(class9_1, false))
                    {
                        j3 = class9_1.anInt219;
                        if(flag && class9_1.anInt239 != 0)
                            j3 = class9_1.anInt239;
                    } else
                    {
                        j3 = class9_1.anInt232;
                        if(flag && class9_1.anInt216 != 0)
                            j3 = class9_1.anInt216;
                    }
                    if(class9_1.aByte254 == 0)
                    {
                        if(class9_1.aBoolean227)
                            Class30_Sub2_Sub1.method336(class9_1.anInt267, l2, k2, j3, class9_1.anInt220, 0);
                        else
                            Class30_Sub2_Sub1.method337(k2, class9_1.anInt220, class9_1.anInt267, j3, l2, true);
                    } else
                    if(class9_1.aBoolean227)
                        Class30_Sub2_Sub1.method335(j3, l2, class9_1.anInt220, class9_1.anInt267, 256 - (class9_1.aByte254 & 0xff), 0, k2);
                    else
                        Class30_Sub2_Sub1.method338(l2, class9_1.anInt267, 256 - (class9_1.aByte254 & 0xff), j3, class9_1.anInt220, k2, -17319);
                } else
                if(class9_1.anInt262 == 4)
                {
                    Class30_Sub2_Sub1_Sub4 class30_sub2_sub1_sub4 = class9_1.aClass30_Sub2_Sub1_Sub4_243;
                    String s = class9_1.aString248;
                    boolean flag1 = false;
                    if(anInt1039 == class9_1.anInt250 || anInt1048 == class9_1.anInt250 || anInt1026 == class9_1.anInt250)
                        flag1 = true;
                    int i4;
                    if(method131(class9_1, false))
                    {
                        i4 = class9_1.anInt219;
                        if(flag1 && class9_1.anInt239 != 0)
                            i4 = class9_1.anInt239;
                        if(class9_1.aString228.length() > 0)
                            s = class9_1.aString228;
                    } else
                    {
                        i4 = class9_1.anInt232;
                        if(flag1 && class9_1.anInt216 != 0)
                            i4 = class9_1.anInt216;
                    }
                    if(class9_1.anInt217 == 6 && aBoolean1149)
                    {
                        s = "Please wait...";
                        i4 = class9_1.anInt232;
                    }
                    if(Class30_Sub2_Sub1.anInt1379 == 479)
                    {
                        if(i4 == 0xffff00)
                            i4 = 255;
                        if(i4 == 49152)
                            i4 = 0xffffff;
                    }
                    for(int l6 = l2 + class30_sub2_sub1_sub4.anInt1497; s.length() > 0; l6 += class30_sub2_sub1_sub4.anInt1497)
                    {
                        if(s.indexOf("%") != -1)
                        {
                            do
                            {
                                int k7 = s.indexOf("%1");
                                if(k7 == -1)
                                    break;
                                s = s.substring(0, k7) + method93(369, method124(341, class9_1, 0)) + s.substring(k7 + 2);
                            } while(true);
                            do
                            {
                                int l7 = s.indexOf("%2");
                                if(l7 == -1)
                                    break;
                                s = s.substring(0, l7) + method93(369, method124(341, class9_1, 1)) + s.substring(l7 + 2);
                            } while(true);
                            do
                            {
                                int i8 = s.indexOf("%3");
                                if(i8 == -1)
                                    break;
                                s = s.substring(0, i8) + method93(369, method124(341, class9_1, 2)) + s.substring(i8 + 2);
                            } while(true);
                            do
                            {
                                int j8 = s.indexOf("%4");
                                if(j8 == -1)
                                    break;
                                s = s.substring(0, j8) + method93(369, method124(341, class9_1, 3)) + s.substring(j8 + 2);
                            } while(true);
                            do
                            {
                                int k8 = s.indexOf("%5");
                                if(k8 == -1)
                                    break;
                                s = s.substring(0, k8) + method93(369, method124(341, class9_1, 4)) + s.substring(k8 + 2);
                            } while(true);
                        }
                        int l8 = s.indexOf("\\n");
                        String s1;
                        if(l8 != -1)
                        {
                            s1 = s.substring(0, l8);
                            s = s.substring(l8 + 2);
                        } else
                        {
                            s1 = s;
                            s = "";
                        }
                        if(class9_1.aBoolean223)
                            class30_sub2_sub1_sub4.method382(i4, k2 + class9_1.anInt220 / 2, anInt939, s1, l6, class9_1.aBoolean268);
                        else
                            class30_sub2_sub1_sub4.method389(false, class9_1.aBoolean268, k2, i4, s1, l6);
                    }

                } else
                if(class9_1.anInt262 == 5)
                {
                    Class30_Sub2_Sub1_Sub1 class30_sub2_sub1_sub1;
                    if(method131(class9_1, false))
                        class30_sub2_sub1_sub1 = class9_1.aClass30_Sub2_Sub1_Sub1_260;
                    else
                        class30_sub2_sub1_sub1 = class9_1.aClass30_Sub2_Sub1_Sub1_207;
                    if(class30_sub2_sub1_sub1 != null)
                        class30_sub2_sub1_sub1.method348(k2, 16083, l2);
                } else
                if(class9_1.anInt262 == 6)
                {
                    int k3 = Class30_Sub2_Sub1_Sub3.anInt1466;
                    int j4 = Class30_Sub2_Sub1_Sub3.anInt1467;
                    Class30_Sub2_Sub1_Sub3.anInt1466 = k2 + class9_1.anInt220 / 2;
                    Class30_Sub2_Sub1_Sub3.anInt1467 = l2 + class9_1.anInt267 / 2;
                    int i5 = Class30_Sub2_Sub1_Sub3.anIntArray1470[class9_1.anInt270] * class9_1.anInt269 >> 16;
                    int l5 = Class30_Sub2_Sub1_Sub3.anIntArray1471[class9_1.anInt270] * class9_1.anInt269 >> 16;
                    boolean flag2 = method131(class9_1, false);
                    int i7;
                    if(flag2)
                        i7 = class9_1.anInt258;
                    else
                        i7 = class9_1.anInt257;
                    Class30_Sub2_Sub4_Sub6 class30_sub2_sub4_sub6;
                    if(i7 == -1)
                    {
                        class30_sub2_sub4_sub6 = class9_1.method209(0, -1, -1, flag2);
                    } else
                    {
                        Class20 class20 = Class20.aClass20Array351[i7];
                        class30_sub2_sub4_sub6 = class9_1.method209(0, class20.anIntArray354[class9_1.anInt246], class20.anIntArray353[class9_1.anInt246], flag2);
                    }
                    if(class30_sub2_sub4_sub6 != null)
                        class30_sub2_sub4_sub6.method482(0, class9_1.anInt271, 0, class9_1.anInt270, 0, i5, l5);
                    Class30_Sub2_Sub1_Sub3.anInt1466 = k3;
                    Class30_Sub2_Sub1_Sub3.anInt1467 = j4;
                } else
                if(class9_1.anInt262 == 7)
                {
                    Class30_Sub2_Sub1_Sub4 class30_sub2_sub1_sub4_1 = class9_1.aClass30_Sub2_Sub1_Sub4_243;
                    int k4 = 0;
                    for(int j5 = 0; j5 < class9_1.anInt267; j5++)
                    {
                        for(int i6 = 0; i6 < class9_1.anInt220; i6++)
                        {
                            if(class9_1.anIntArray253[k4] > 0)
                            {
                                Class8 class8 = Class8.method198(class9_1.anIntArray253[k4] - 1);
                                String s2 = class8.aString170;
                                if(class8.aBoolean176 || class9_1.anIntArray252[k4] != 1)
                                    s2 = s2 + " x" + method14(class9_1.anIntArray252[k4], 0);
                                int i9 = k2 + i6 * (115 + class9_1.anInt231);
                                int k9 = l2 + j5 * (12 + class9_1.anInt244);
                                if(class9_1.aBoolean223)
                                    class30_sub2_sub1_sub4_1.method382(class9_1.anInt232, i9 + class9_1.anInt220 / 2, anInt939, s2, k9, class9_1.aBoolean268);
                                else
                                    class30_sub2_sub1_sub4_1.method389(false, class9_1.aBoolean268, i9, class9_1.anInt232, s2, k9);
                            }
                            k4++;
                        }

                    }

                }
        }

        Class30_Sub2_Sub1.method333(l1, i1, false, k1, j1);
    }

    public final void method106(Class30_Sub2_Sub1_Sub2 class30_sub2_sub1_sub2, int i)
    {
        int j = 256;
        if(i >= 0)
            aClass30_Sub2_Sub2_1192.method398(126);
        for(int k = 0; k < anIntArray1190.length; k++)
            anIntArray1190[k] = 0;

        for(int l = 0; l < 5000; l++)
        {
            int i1 = (int)(Math.random() * 128D * (double)j);
            anIntArray1190[i1] = (int)(Math.random() * 256D);
        }

        for(int j1 = 0; j1 < 20; j1++)
        {
            for(int k1 = 1; k1 < j - 1; k1++)
            {
                for(int i2 = 1; i2 < 127; i2++)
                {
                    int k2 = i2 + (k1 << 7);
                    anIntArray1191[k2] = (anIntArray1190[k2 - 1] + anIntArray1190[k2 + 1] + anIntArray1190[k2 - 128] + anIntArray1190[k2 + 128]) / 4;
                }

            }

            int ai[] = anIntArray1190;
            anIntArray1190 = anIntArray1191;
            anIntArray1191 = ai;
        }

        if(class30_sub2_sub1_sub2 != null)
        {
            int l1 = 0;
            for(int j2 = 0; j2 < class30_sub2_sub1_sub2.anInt1453; j2++)
            {
                for(int l2 = 0; l2 < class30_sub2_sub1_sub2.anInt1452; l2++)
                    if(class30_sub2_sub1_sub2.aByteArray1450[l1++] != 0)
                    {
                        int i3 = l2 + 16 + class30_sub2_sub1_sub2.anInt1454;
                        int j3 = j2 + 16 + class30_sub2_sub1_sub2.anInt1455;
                        int k3 = i3 + (j3 << 7);
                        anIntArray1190[k3] = 0;
                    }

            }

        }
    }

    private final void method107(int i, int j, Class30_Sub2_Sub2 class30_sub2_sub2, byte byte0, Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2)
    {
        //System.out.println("Packet size in method 49 is currently: " + i);
        if(byte0 != 25)
            aClass19ArrayArrayArray827 = null;
        if((i & 0x400) != 0)
        {
            class30_sub2_sub4_sub1_sub2.anInt1543 = class30_sub2_sub2.method428(2);
            class30_sub2_sub4_sub1_sub2.anInt1545 = class30_sub2_sub2.method428(2);
            class30_sub2_sub4_sub1_sub2.anInt1544 = class30_sub2_sub2.method428(2);
            class30_sub2_sub4_sub1_sub2.anInt1546 = class30_sub2_sub2.method428(2);
            class30_sub2_sub4_sub1_sub2.anInt1547 = class30_sub2_sub2.method436((byte)-74) + anInt1161;
            class30_sub2_sub4_sub1_sub2.anInt1548 = class30_sub2_sub2.method435(true) + anInt1161;
            class30_sub2_sub4_sub1_sub2.anInt1549 = class30_sub2_sub2.method428(2);
            class30_sub2_sub4_sub1_sub2.method446(true);
        }
        if((i & 0x100) != 0)
        {
            class30_sub2_sub4_sub1_sub2.anInt1520 = class30_sub2_sub2.method434((byte)108);
            int k = class30_sub2_sub2.method413();
            class30_sub2_sub4_sub1_sub2.anInt1524 = k >> 16;
            class30_sub2_sub4_sub1_sub2.anInt1523 = anInt1161 + (k & 0xffff);
            class30_sub2_sub4_sub1_sub2.anInt1521 = 0;
            class30_sub2_sub4_sub1_sub2.anInt1522 = 0;
            if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1523 > anInt1161)
                class30_sub2_sub4_sub1_sub2.anInt1521 = -1;
            if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1520 == 65535)
                class30_sub2_sub4_sub1_sub2.anInt1520 = -1;
        }
        if((i & 8) != 0)
        {
            int l = class30_sub2_sub2.method434((byte)108);
            if(l == 65535)
                l = -1;
            int i2 = class30_sub2_sub2.method427(false);
            if(l == ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1526 && l != -1)
            {
                int i3 = Class20.aClass20Array351[l].anInt365;
                if(i3 == 1)
                {
                    class30_sub2_sub4_sub1_sub2.anInt1527 = 0;
                    class30_sub2_sub4_sub1_sub2.anInt1528 = 0;
                    class30_sub2_sub4_sub1_sub2.anInt1529 = i2;
                    class30_sub2_sub4_sub1_sub2.anInt1530 = 0;
                }
                if(i3 == 2)
                    class30_sub2_sub4_sub1_sub2.anInt1530 = 0;
            } else
            if(l == -1 || ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1526 == -1 || Class20.aClass20Array351[l].anInt359 >= Class20.aClass20Array351[((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1526].anInt359)
            {
                class30_sub2_sub4_sub1_sub2.anInt1526 = l;
                class30_sub2_sub4_sub1_sub2.anInt1527 = 0;
                class30_sub2_sub4_sub1_sub2.anInt1528 = 0;
                class30_sub2_sub4_sub1_sub2.anInt1529 = i2;
                class30_sub2_sub4_sub1_sub2.anInt1530 = 0;
                class30_sub2_sub4_sub1_sub2.anInt1542 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1525;
            }
        }
        if((i & 4) != 0)
        {
            class30_sub2_sub4_sub1_sub2.aString1506 = class30_sub2_sub2.method415();
            if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).aString1506.charAt(0) == '~')
            {
                class30_sub2_sub4_sub1_sub2.aString1506 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).aString1506.substring(1);
                method77(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).aString1506, 2, class30_sub2_sub4_sub1_sub2.aString1703, aBoolean991);
            } else
            if(class30_sub2_sub4_sub1_sub2 == aClass30_Sub2_Sub4_Sub1_Sub2_1126)
                method77(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).aString1506, 2, class30_sub2_sub4_sub1_sub2.aString1703, aBoolean991);
            class30_sub2_sub4_sub1_sub2.anInt1513 = 0;
            class30_sub2_sub4_sub1_sub2.anInt1531 = 0;
            class30_sub2_sub4_sub1_sub2.anInt1535 = 150;
        }
        if((i & 0x80) != 0)
        {
            int i1 = class30_sub2_sub2.method434((byte)108);
            int j2 = class30_sub2_sub2.method408();
            int j3 = class30_sub2_sub2.method427(false);
            int k3 = class30_sub2_sub2.anInt1406;
            if(class30_sub2_sub4_sub1_sub2.aString1703 != null && class30_sub2_sub4_sub1_sub2.aBoolean1710)
            {
                long l3 = Class50.method583(class30_sub2_sub4_sub1_sub2.aString1703);
                boolean flag = false;
                if(j2 <= 1)
                {
                    for(int i4 = 0; i4 < anInt822; i4++)
                    {
                        if(aLongArray925[i4] != l3)
                            continue;
                        flag = true;
                        break;
                    }

                }
                if(!flag && anInt1251 == 0)
                    try
                    {
                        aClass30_Sub2_Sub2_834.anInt1406 = 0;
                        class30_sub2_sub2.method442(j3, 0, true, aClass30_Sub2_Sub2_834.aByteArray1405);
                        aClass30_Sub2_Sub2_834.anInt1406 = 0;
                        String s = Class35.method525(j3, true, aClass30_Sub2_Sub2_834);
                        s = Class34.method497(s, 0);
                        class30_sub2_sub4_sub1_sub2.aString1506 = s;
                        class30_sub2_sub4_sub1_sub2.anInt1513 = i1 >> 8;
                        class30_sub2_sub4_sub1_sub2.anInt1531 = i1 & 0xff;
                        class30_sub2_sub4_sub1_sub2.anInt1535 = 150;
                        if(j2 == 2 || j2 == 3)
                            method77(s, 1, "@cr2@" + class30_sub2_sub4_sub1_sub2.aString1703, aBoolean991);
                        else
                        if(j2 == 1)
                            method77(s, 1, "@cr1@" + class30_sub2_sub4_sub1_sub2.aString1703, aBoolean991);
                        else
                            method77(s, 2, class30_sub2_sub4_sub1_sub2.aString1703, aBoolean991);
                    }
                    catch(Exception exception)
                    {
                        signlink.reporterror("cde2");
                    }
            }
            class30_sub2_sub2.anInt1406 = k3 + j3;
        }
        if((i & 1) != 0)
        {
            class30_sub2_sub4_sub1_sub2.anInt1502 = class30_sub2_sub2.method434((byte)108);
            if(((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1502 == 65535)
                class30_sub2_sub4_sub1_sub2.anInt1502 = -1;
        }
        if((i & 0x10) != 0)
        {
            int j1 = class30_sub2_sub2.method427(false);
            byte abyte0[] = new byte[j1];
            Class30_Sub2_Sub2 class30_sub2_sub2_1 = new Class30_Sub2_Sub2(abyte0, 891);
            class30_sub2_sub2.method417(j1, aByte920, 0, abyte0);
            aClass30_Sub2_Sub2Array895[j] = class30_sub2_sub2_1;
            class30_sub2_sub4_sub1_sub2.method451(0, class30_sub2_sub2_1);
        }
        if((i & 2) != 0)
        {
            class30_sub2_sub4_sub1_sub2.anInt1538 = class30_sub2_sub2.method436((byte)-74);
            class30_sub2_sub4_sub1_sub2.anInt1539 = class30_sub2_sub2.method434((byte)108);
        }
        if((i & 0x20) != 0)
        {
            int k1 = class30_sub2_sub2.method408();
            int k2 = class30_sub2_sub2.method426(0);
            class30_sub2_sub4_sub1_sub2.method447(-35698, k2, k1, anInt1161);
            class30_sub2_sub4_sub1_sub2.anInt1532 = anInt1161 + 300;
            class30_sub2_sub4_sub1_sub2.anInt1533 = class30_sub2_sub2.method427(false);
            class30_sub2_sub4_sub1_sub2.anInt1534 = class30_sub2_sub2.method408();
        }
        if((i & 0x200) != 0)
        {
            int l1 = class30_sub2_sub2.method408();
            int l2 = class30_sub2_sub2.method428(2);
            class30_sub2_sub4_sub1_sub2.method447(-35698, l2, l1, anInt1161);
            class30_sub2_sub4_sub1_sub2.anInt1532 = anInt1161 + 300;
            class30_sub2_sub4_sub1_sub2.anInt1533 = class30_sub2_sub2.method408();
            class30_sub2_sub4_sub1_sub2.anInt1534 = class30_sub2_sub2.method427(false);
        }
    }

    public final void method108(int i)
    {
        if(i != 3)
            opcode = -1;
        try
        {
            int j = ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 + anInt1278;
            int k = ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 + anInt1131;
            if(anInt1014 - j < -500 || anInt1014 - j > 500 || anInt1015 - k < -500 || anInt1015 - k > 500)
            {
                anInt1014 = j;
                anInt1015 = k;
            }
            if(anInt1014 != j)
                anInt1014 += (j - anInt1014) / 16;
            if(anInt1015 != k)
                anInt1015 += (k - anInt1015) / 16;
            if(super.anIntArray30[1] == 1)
                anInt1186 += (-24 - anInt1186) / 2;
            else
            if(super.anIntArray30[2] == 1)
                anInt1186 += (24 - anInt1186) / 2;
            else
                anInt1186 /= 2;
            if(super.anIntArray30[3] == 1)
                anInt1187 += (12 - anInt1187) / 2;
            else
            if(super.anIntArray30[4] == 1)
                anInt1187 += (-12 - anInt1187) / 2;
            else
                anInt1187 /= 2;
            anInt1185 = anInt1185 + anInt1186 / 2 & 0x7ff;
            anInt1184 += anInt1187 / 2;
            if(anInt1184 < 128)
                anInt1184 = 128;
            if(anInt1184 > 383)
                anInt1184 = 383;
            int l = anInt1014 >> 7;
            int i1 = anInt1015 >> 7;
            int j1 = method42(anInt918, anInt1015, true, anInt1014);
            int k1 = 0;
            if(l > 3 && i1 > 3 && l < 100 && i1 < 100)
            {
                for(int l1 = l - 4; l1 <= l + 4; l1++)
                {
                    for(int k2 = i1 - 4; k2 <= i1 + 4; k2++)
                    {
                        int l2 = anInt918;
                        if(l2 < 3 && (aByteArrayArrayArray1258[1][l1][k2] & 2) == 2)
                            l2++;
                        int i3 = j1 - anIntArrayArrayArray1214[l2][l1][k2];
                        if(i3 > k1)
                            k1 = i3;
                    }

                }

            }
            anInt1005++;
            if(anInt1005 > 1512)
            {
                anInt1005 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 77);
                aClass30_Sub2_Sub2_1192.method398(0);
                int i2 = aClass30_Sub2_Sub2_1192.anInt1406;
                aClass30_Sub2_Sub2_1192.method398((int)(Math.random() * 256D));
                aClass30_Sub2_Sub2_1192.method398(101);
                aClass30_Sub2_Sub2_1192.method398(233);
                aClass30_Sub2_Sub2_1192.method399(45092);
                if((int)(Math.random() * 2D) == 0)
                    aClass30_Sub2_Sub2_1192.method399(35784);
                aClass30_Sub2_Sub2_1192.method398((int)(Math.random() * 256D));
                aClass30_Sub2_Sub2_1192.method398(64);
                aClass30_Sub2_Sub2_1192.method398(38);
                aClass30_Sub2_Sub2_1192.method399((int)(Math.random() * 65536D));
                aClass30_Sub2_Sub2_1192.method399((int)(Math.random() * 65536D));
                aClass30_Sub2_Sub2_1192.method407(aClass30_Sub2_Sub2_1192.anInt1406 - i2, (byte)0);
            }
            int j2 = k1 * 192;
            if(j2 > 0x17f00)
                j2 = 0x17f00;
            if(j2 < 32768)
                j2 = 32768;
            if(j2 > anInt984)
            {
                anInt984 += (j2 - anInt984) / 24;
                return;
            }
            if(j2 < anInt984)
            {
                anInt984 += (j2 - anInt984) / 80;
                return;
            }
        }
        catch(Exception _ex)
        {
            signlink.reporterror("glfc_ex " + ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 + "," + ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 + "," + anInt1014 + "," + anInt1015 + "," + anInt1069 + "," + anInt1070 + "," + anInt1034 + "," + anInt1035);
            throw new RuntimeException("eek");
        }
    }

    public final void method9(int i)
    {
        if(aBoolean1252 || aBoolean926 || aBoolean1176)
        {
            method94(-13873);
            return;
        }
        anInt1061++;
        if(i != 0)
            opcode = -1;
        if(!aBoolean1157)
            method135(false, false);
        else
            method102(true);
        anInt1213 = 0;
    }

    public final boolean method109(boolean flag, String s)
    {
        if(s == null)
            return false;
        for(int i = 0; i < anInt899; i++)
            if(s.equalsIgnoreCase(aStringArray1082[i]))
                return true;

        if(flag)
            aClass30_Sub2_Sub2_1192.method398(138);
        return s.equalsIgnoreCase(aClass30_Sub2_Sub4_Sub1_Sub2_1126.aString1703);
    }

    public static final String method110(int i, int j, boolean flag)
    {
        if(!flag)
            throw new NullPointerException();
        int k = i - j;
        if(k < -9)
            return "@red@";
        if(k < -6)
            return "@or3@";
        if(k < -3)
            return "@or2@";
        if(k < 0)
            return "@or1@";
        if(k > 9)
            return "@gre@";
        if(k > 6)
            return "@gr3@";
        if(k > 3)
            return "@gr2@";
        if(k > 0)
            return "@gr1@";
        else
            return "@yel@";
    }

    public final void method111(byte byte0, int i)
    {
        if(byte0 == 2)
            byte0 = 0;
        else
            method6();
        signlink.wavevol = i;
    }

    public final void method112(int i)
    {
        if(i != 8)
            anInt939 = 130;
        method76((byte)-13);
        if(anInt917 == 1)
        {
            aClass30_Sub2_Sub1_Sub1Array1150[anInt916 / 100].method348(anInt914 - 8 - 4, 16083, anInt915 - 8 - 4);
            anInt1142++;
            if(anInt1142 > 67)
            {
                anInt1142 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 78);
            }
        }
        if(anInt917 == 2)
            aClass30_Sub2_Sub1_Sub1Array1150[4 + anInt916 / 100].method348(anInt914 - 8 - 4, 16083, anInt915 - 8 - 4);
        if(anInt1018 != -1)
        {
            method119(anInt945, false, anInt1018);
            method105(8, 0, 0, Class9.aClass9Array210[anInt1018], 0);
        }
        if(anInt857 != -1)
        {
            method119(anInt945, false, anInt857);
            method105(8, 0, 0, Class9.aClass9Array210[anInt857], 0);
        }
        method70(184);
        if(!aBoolean885)
        {
            method82(0);
            method125(45706);
        } else
        if(anInt948 == 0)
            method40((byte)9);
        if(anInt1055 == 1)
            aClass30_Sub2_Sub1_Sub1Array1095[1].method348(472, 16083, 296);
        if(aBoolean1156)
        {
            char c = '\u01FB';
            int k = 20;
            int i1 = 0xffff00;
            if(super.anInt8 < 15)
                i1 = 0xff0000;
            aClass30_Sub2_Sub1_Sub4_1271.method380("Fps:" + super.anInt8, c, i1, (byte)-80, k);
            k += 15;
            Runtime runtime = Runtime.getRuntime();
            int j1 = (int)((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
            i1 = 0xffff00;
            if(j1 > 0x2000000 && aBoolean960)
                i1 = 0xff0000;
            aClass30_Sub2_Sub1_Sub4_1271.method380("Mem:" + j1 + "k", c, 0xffff00, (byte)-80, k);
            k += 15;
        }
        if(anInt1104 != 0)
        {
            int j = anInt1104 / 50;
            int l = j / 60;
            j %= 60;
            if(j < 10)
                aClass30_Sub2_Sub1_Sub4_1271.method385(0xffff00, "System update in: " + l + ":0" + j, 329, 822, 4);
            else
                aClass30_Sub2_Sub1_Sub4_1271.method385(0xffff00, "System update in: " + l + ":" + j, 329, 822, 4);
            anInt849++;
            if(anInt849 > 75)
            {
                anInt849 = 0;
                aClass30_Sub2_Sub2_1192.method397((byte)6, 148);
            }
        }
    }

    public final void method113(long l, int i)
    {
        try
        {
            if(l == 0L)
                return;
            if(anInt822 >= 100)
            {
                method77("Your ignore list is full. Max of 100 hit", 0, "", aBoolean991);
                return;
            }
            String s = Class50.method587(-45804, Class50.method584(l, (byte)-99));
            for(int j = 0; j < anInt822; j++)
                if(aLongArray925[j] == l)
                {
                    method77(s + " is already on your ignore list", 0, "", aBoolean991);
                    return;
                }

            if(i < 4 || i > 4)
                return;
            for(int k = 0; k < anInt899; k++)
                if(aLongArray955[k] == l)
                {
                    method77("Please remove " + s + " from your friend list first", 0, "", aBoolean991);
                    return;
                }

            aLongArray925[anInt822++] = l;
            aBoolean1153 = true;
            aClass30_Sub2_Sub2_1192.method397((byte)6, 133);
            aClass30_Sub2_Sub2_1192.method404(5, l);
            return;
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("45688, " + l + ", " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public final void method114(byte byte0)
    {
        if(byte0 != aByte973)
            return;
        for(int i = -1; i < anInt891; i++)
        {
            int j;
            if(i == -1)
                j = anInt889;
            else
                j = anIntArray892[i];
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[j];
            if(class30_sub2_sub4_sub1_sub2 != null)
                method96(46988, 1, class30_sub2_sub4_sub1_sub2);
        }

    }

    private final void method115(byte byte0)
    {
        if(byte0 == 8)
            byte0 = 0;
        else
            aClass30_Sub2_Sub2_1192.method398(101);
        if(anInt1023 == 2)
        {
            for(Class30_Sub1 class30_sub1 = (Class30_Sub1)aClass19_1179.method252(); class30_sub1 != null; class30_sub1 = (Class30_Sub1)aClass19_1179.method254(false))
            {
                if(class30_sub1.anInt1294 > 0)
                    class30_sub1.anInt1294--;
                if(class30_sub1.anInt1294 == 0)
                {
                    if(class30_sub1.anInt1299 < 0 || Class7.method178(class30_sub1.anInt1299, class30_sub1.anInt1301, 8))
                    {
                        method142(class30_sub1.anInt1298, class30_sub1.anInt1295, class30_sub1.anInt1300, class30_sub1.anInt1301, class30_sub1.anInt1297, class30_sub1.anInt1296, class30_sub1.anInt1299, 4);
                        class30_sub1.method329();
                    }
                } else
                {
                    if(class30_sub1.anInt1302 > 0)
                        class30_sub1.anInt1302--;
                    if(class30_sub1.anInt1302 == 0 && class30_sub1.anInt1297 >= 1 && class30_sub1.anInt1298 >= 1 && class30_sub1.anInt1297 <= 102 && class30_sub1.anInt1298 <= 102 && (class30_sub1.anInt1291 < 0 || Class7.method178(class30_sub1.anInt1291, class30_sub1.anInt1293, 8)))
                    {
                        method142(class30_sub1.anInt1298, class30_sub1.anInt1295, class30_sub1.anInt1292, class30_sub1.anInt1293, class30_sub1.anInt1297, class30_sub1.anInt1296, class30_sub1.anInt1291, 4);
                        class30_sub1.anInt1302 = -1;
                        if(class30_sub1.anInt1291 == class30_sub1.anInt1299 && class30_sub1.anInt1299 == -1)
                            class30_sub1.method329();
                        else
                        if(class30_sub1.anInt1291 == class30_sub1.anInt1299 && class30_sub1.anInt1292 == class30_sub1.anInt1300 && class30_sub1.anInt1293 == class30_sub1.anInt1301)
                            class30_sub1.method329();
                    }
                }
            }

        }
    }

    public final void method116(boolean flag)
    {
        int i = aClass30_Sub2_Sub1_Sub4_1272.method383(anInt1116, "Choose Option");
        aBoolean1157 &= flag;
        for(int j = 0; j < anInt1133; j++)
        {
            int k = aClass30_Sub2_Sub1_Sub4_1272.method383(anInt1116, aStringArray1199[j]);
            if(k > i)
                i = k;
        }

        i += 8;
        int l = 15 * anInt1133 + 21;
        if(super.anInt27 > 4 && super.anInt28 > 4 && super.anInt27 < 516 && super.anInt28 < 338)
        {
            int i1 = super.anInt27 - 4 - i / 2;
            if(i1 + i > 512)
                i1 = 512 - i;
            if(i1 < 0)
                i1 = 0;
            int l1 = super.anInt28 - 4;
            if(l1 + l > 334)
                l1 = 334 - l;
            if(l1 < 0)
                l1 = 0;
            aBoolean885 = true;
            anInt948 = 0;
            anInt949 = i1;
            anInt950 = l1;
            anInt951 = i;
            anInt952 = 15 * anInt1133 + 22;
        }
        if(super.anInt27 > 553 && super.anInt28 > 205 && super.anInt27 < 743 && super.anInt28 < 466)
        {
            int j1 = super.anInt27 - 553 - i / 2;
            if(j1 < 0)
                j1 = 0;
            else
            if(j1 + i > 190)
                j1 = 190 - i;
            int i2 = super.anInt28 - 205;
            if(i2 < 0)
                i2 = 0;
            else
            if(i2 + l > 261)
                i2 = 261 - l;
            aBoolean885 = true;
            anInt948 = 1;
            anInt949 = j1;
            anInt950 = i2;
            anInt951 = i;
            anInt952 = 15 * anInt1133 + 22;
        }
        if(super.anInt27 > 17 && super.anInt28 > 357 && super.anInt27 < 496 && super.anInt28 < 453)
        {
            int k1 = super.anInt27 - 17 - i / 2;
            if(k1 < 0)
                k1 = 0;
            else
            if(k1 + i > 479)
                k1 = 479 - i;
            int j2 = super.anInt28 - 357;
            if(j2 < 0)
                j2 = 0;
            else
            if(j2 + l > 96)
                j2 = 96 - l;
            aBoolean885 = true;
            anInt948 = 2;
            anInt949 = k1;
            anInt950 = j2;
            anInt951 = i;
            anInt952 = 15 * anInt1133 + 22;
        }
    }

    /**
     * Handles 'our' player movements
     * method419: reads x amount bits, unsure of second arg
     * @param class30_sub2_sub2
     * @param i expected packet size
     * @param byte0
     */
    private final void method117(Class30_Sub2_Sub2 class30_sub2_sub2, int i, byte byte0) {
        System.out.println("METHOD 117 CALLED");
        // no idea 
        class30_sub2_sub2.method418(anInt1118);
        // sets the next opcode, not really sure why though?
        if(byte0 == 5)
            byte0 = 0;
        else
            opcode = class30_sub2_sub2.method408();

        // update our player or not
        int j = class30_sub2_sub2.method419(1, 0);

        // don't update our player if bit is 0
        if(j == 0) {
            System.out.println("Skip updating for 'our' player");
            return;
        }

        /**
         * Type 0: There is nothing to update for our players, just add its index to the local updating list.
         * 
         * Type 1: (Walking) Our player moved in our direction, takes 3 bit value for the direction we moved in
         * and a further 1 bit, which states whether further update is required. If so, it adds it to the updating list. 
         * This is used in walking.
         * 
         * Type 2: (Running) Our player moved, same as Type 1 but reads two 3 bit values. 
         * The first represents the player's last direction, and the second the player's current direction.
         * It then reads the same 1 bit, as type 1 above.
         * 
         * Type 3: Client reads in 2 bits which represents our player's plane, or its level of height, in the game world. (0-3 I believe)
         */
        // gets our movement type (0-3)
        int k = class30_sub2_sub2.method419(2, 0);

        if(k == 0) {
            // adds our player index (anInt889) to local updating list (anIntArray894)
            anIntArray894[anInt893++] = anInt889;
            System.out.println("Movement type: 0");
            return;
        }

        if(k == 1) {
            int l = class30_sub2_sub2.method419(3, 0);
            aClass30_Sub2_Sub4_Sub1_Sub2_1126.method448(false, (byte)20, l);
            int k1 = class30_sub2_sub2.method419(1, 0);
            if(k1 == 1)
                anIntArray894[anInt893++] = anInt889;
            System.out.println("Movement type: 1");
            return;
        }
        if(k == 2)
        {
            int i1 = class30_sub2_sub2.method419(3, 0);
            aClass30_Sub2_Sub4_Sub1_Sub2_1126.method448(true, (byte)20, i1);
            int l1 = class30_sub2_sub2.method419(3, 0);
            aClass30_Sub2_Sub4_Sub1_Sub2_1126.method448(true, (byte)20, l1);
            int j2 = class30_sub2_sub2.method419(1, 0);
            if(j2 == 1)
                anIntArray894[anInt893++] = anInt889;
            System.out.println("Movement type: 2");
            return;
        }
        if(k == 3) {
            // our plane level, 0-3
            anInt918 = class30_sub2_sub2.method419(2, 0);
            // clear awaiting point queue
            int j1 = class30_sub2_sub2.method419(1, 0);
            // update required?
            int i2 = class30_sub2_sub2.method419(1, 0);
            // not sure why it checks the 2nd bit here?
            if(i2 == 1)
                anIntArray894[anInt893++] = anInt889;
            // our zone co-ordinates
            int k2 = class30_sub2_sub2.method419(7, 0);
            int l2 = class30_sub2_sub2.method419(7, 0);
            // if we clear await queue, and our coords are 1
            // set false? no idea
            aClass30_Sub2_Sub4_Sub1_Sub2_1126.method445(l2, k2, j1 == 1, false);
            //System.out.println("Movement type: 3");
        }
    }

    public final void method118(int i)
    {
        aBoolean831 = false;
        while(aBoolean962) 
        {
            aBoolean831 = false;
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }
        }
        aClass30_Sub2_Sub1_Sub2_966 = null;
        aClass30_Sub2_Sub1_Sub2_967 = null;
        aClass30_Sub2_Sub1_Sub2Array1152 = null;
        anIntArray850 = null;
        anIntArray851 = null;
        anIntArray852 = null;
        anIntArray853 = null;
        anIntArray1190 = null;
        anIntArray1191 = null;
        anIntArray828 = null;
        anIntArray829 = null;
        aClass30_Sub2_Sub1_Sub1_1201 = null;
        aClass30_Sub2_Sub1_Sub1_1202 = null;
        if(i < 3 || i > 3)
            aClass19ArrayArrayArray827 = null;
    }

    public final boolean method119(int i, boolean flag, int j)
    {
        boolean flag1 = false;
        if(flag)
            throw new NullPointerException();
        Class9 class9 = Class9.aClass9Array210[j];
        for(int k = 0; k < class9.anIntArray240.length; k++)
        {
            if(class9.anIntArray240[k] == -1)
                break;
            Class9 class9_1 = Class9.aClass9Array210[class9.anIntArray240[k]];
            if(class9_1.anInt262 == 1)
                flag1 |= method119(i, false, class9_1.anInt250);
            if(class9_1.anInt262 == 6 && (class9_1.anInt257 != -1 || class9_1.anInt258 != -1))
            {
                boolean flag2 = method131(class9_1, false);
                int l;
                if(flag2)
                    l = class9_1.anInt258;
                else
                    l = class9_1.anInt257;
                if(l != -1)
                {
                    Class20 class20 = Class20.aClass20Array351[l];
                    for(class9_1.anInt208 += i; class9_1.anInt208 > class20.method258(class9_1.anInt246, (byte)-39);)
                    {
                        class9_1.anInt208 -= class20.method258(class9_1.anInt246, (byte)-39) + 1;
                        class9_1.anInt246++;
                        if(class9_1.anInt246 >= class20.anInt352)
                        {
                            class9_1.anInt246 -= class20.anInt356;
                            if(class9_1.anInt246 < 0 || class9_1.anInt246 >= class20.anInt352)
                                class9_1.anInt246 = 0;
                        }
                        flag1 = true;
                    }

                }
            }
        }

        return flag1;
    }

    public final int method120(int i)
    {
        if(i <= 0)
            aBoolean1224 = !aBoolean1224;
        int j = 3;
        if(anInt861 < 310)
        {
            int k = anInt858 >> 7;
            int l = anInt860 >> 7;
            int i1 = ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 >> 7;
            int j1 = ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 >> 7;
            if((aByteArrayArrayArray1258[anInt918][k][l] & 4) != 0)
                j = anInt918;
            int k1;
            if(i1 > k)
                k1 = i1 - k;
            else
                k1 = k - i1;
            int l1;
            if(j1 > l)
                l1 = j1 - l;
            else
                l1 = l - j1;
            if(k1 > l1)
            {
                int i2 = (l1 * 0x10000) / k1;
                int k2 = 32768;
                while(k != i1) 
                {
                    if(k < i1)
                        k++;
                    else
                    if(k > i1)
                        k--;
                    if((aByteArrayArrayArray1258[anInt918][k][l] & 4) != 0)
                        j = anInt918;
                    k2 += i2;
                    if(k2 >= 0x10000)
                    {
                        k2 -= 0x10000;
                        if(l < j1)
                            l++;
                        else
                        if(l > j1)
                            l--;
                        if((aByteArrayArrayArray1258[anInt918][k][l] & 4) != 0)
                            j = anInt918;
                    }
                }
            } else
            {
                int j2 = (k1 * 0x10000) / l1;
                int l2 = 32768;
                while(l != j1) 
                {
                    if(l < j1)
                        l++;
                    else
                    if(l > j1)
                        l--;
                    if((aByteArrayArrayArray1258[anInt918][k][l] & 4) != 0)
                        j = anInt918;
                    l2 += j2;
                    if(l2 >= 0x10000)
                    {
                        l2 -= 0x10000;
                        if(k < i1)
                            k++;
                        else
                        if(k > i1)
                            k--;
                        if((aByteArrayArrayArray1258[anInt918][k][l] & 4) != 0)
                            j = anInt918;
                    }
                }
            }
        }
        if((aByteArrayArrayArray1258[anInt918][((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 >> 7][((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 >> 7] & 4) != 0)
            j = anInt918;
        return j;
    }

    public final int method121(int i)
    {
        while(i >= 0) 
            aClass30_Sub2_Sub2_1192.method398(21);
        int j = method42(anInt918, anInt860, true, anInt858);
        if(j - anInt859 < 800 && (aByteArrayArrayArray1258[anInt918][anInt858 >> 7][anInt860 >> 7] & 4) != 0)
            return anInt918;
        else
            return 3;
    }

    public final void method122(int i, long l)
    {
        try
        {
            if(i != 3)
                method6();
            if(l == 0L)
                return;
            for(int j = 0; j < anInt822; j++)
                if(aLongArray925[j] == l)
                {
                    anInt822--;
                    aBoolean1153 = true;
                    for(int k = j; k < anInt822; k++)
                        aLongArray925[k] = aLongArray925[k + 1];

                    aClass30_Sub2_Sub2_1192.method397((byte)6, 74);
                    aClass30_Sub2_Sub2_1192.method404(5, l);
                    return;
                }

            return;
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("47229, " + i + ", " + l + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public final String getParameter(String s)
    {
        if(signlink.mainapp != null)
            return signlink.mainapp.getParameter(s);
        else
            return super.getParameter(s);
    }

    public final void method123(byte byte0, boolean flag, int i)
    {
        if(byte0 == 0)
            byte0 = 0;
        else
            aClass19ArrayArrayArray827 = null;
        signlink.midivol = i;
        if(flag)
            signlink.midi = "voladjust";
    }

    public final int method124(int i, Class9 class9, int j)
    {
        i = 91 / i;
        if(class9.anIntArrayArray226 == null || j >= class9.anIntArrayArray226.length)
            return -2;
        try
        {
            int ai[] = class9.anIntArrayArray226[j];
            int k = 0;
            int l = 0;
            int i1 = 0;
            do
            {
                int j1 = ai[l++];
                int k1 = 0;
                byte byte0 = 0;
                if(j1 == 0)
                    return k;
                if(j1 == 1)
                    k1 = anIntArray922[ai[l++]];
                if(j1 == 2)
                    k1 = anIntArray1044[ai[l++]];
                if(j1 == 3)
                    k1 = anIntArray864[ai[l++]];
                if(j1 == 4)
                {
                    Class9 class9_1 = Class9.aClass9Array210[ai[l++]];
                    int k2 = ai[l++];
                    if(k2 >= 0 && k2 < Class8.anInt203 && (!Class8.method198(k2).aBoolean161 || aBoolean959))
                    {
                        for(int j3 = 0; j3 < class9_1.anIntArray253.length; j3++)
                            if(class9_1.anIntArray253[j3] == k2 + 1)
                                k1 += class9_1.anIntArray252[j3];

                    }
                }
                if(j1 == 5)
                    k1 = anIntArray971[ai[l++]];
                if(j1 == 6)
                    k1 = anIntArray1019[anIntArray1044[ai[l++]] - 1];
                if(j1 == 7)
                    k1 = (anIntArray971[ai[l++]] * 100) / 46875;
                if(j1 == 8)
                    k1 = aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1705;
                if(j1 == 9)
                {
                    for(int l1 = 0; l1 < Class45.anInt733; l1++)
                        if(Class45.aBooleanArray735[l1])
                            k1 += anIntArray1044[l1];

                }
                if(j1 == 10)
                {
                    Class9 class9_2 = Class9.aClass9Array210[ai[l++]];
                    int l2 = ai[l++] + 1;
                    if(l2 >= 0 && l2 < Class8.anInt203 && (!Class8.method198(l2).aBoolean161 || aBoolean959))
                    {
                        for(int k3 = 0; k3 < class9_2.anIntArray253.length; k3++)
                        {
                            if(class9_2.anIntArray253[k3] != l2)
                                continue;
                            k1 = 0x3b9ac9ff;
                            break;
                        }

                    }
                }
                if(j1 == 11)
                    k1 = anInt1148;
                if(j1 == 12)
                    k1 = anInt878;
                if(j1 == 13)
                {
                    int i2 = anIntArray971[ai[l++]];
                    int i3 = ai[l++];
                    k1 = (i2 & 1 << i3) == 0 ? 0 : 1;
                }
                if(j1 == 14)
                {
                    int j2 = ai[l++];
                    Class37 class37 = Class37.aClass37Array646[j2];
                    int l3 = class37.anInt648;
                    int i4 = class37.anInt649;
                    int j4 = class37.anInt650;
                    int k4 = anIntArray1232[j4 - i4];
                    k1 = anIntArray971[l3] >> i4 & k4;
                }
                if(j1 == 15)
                    byte0 = 1;
                if(j1 == 16)
                    byte0 = 2;
                if(j1 == 17)
                    byte0 = 3;
                if(j1 == 18)
                    k1 = (((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 >> 7) + anInt1034;
                if(j1 == 19)
                    k1 = (((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 >> 7) + anInt1035;
                if(j1 == 20)
                    k1 = ai[l++];
                if(byte0 == 0)
                {
                    if(i1 == 0)
                        k += k1;
                    if(i1 == 1)
                        k -= k1;
                    if(i1 == 2 && k1 != 0)
                        k /= k1;
                    if(i1 == 3)
                        k *= k1;
                    i1 = 0;
                } else
                {
                    i1 = byte0;
                }
            } while(true);
        }
        catch(Exception _ex)
        {
            return -1;
        }
    }

    public final void method125(int i)
    {
        if(anInt1133 < 2 && anInt1282 == 0 && anInt1136 == 0)
            return;
        String s;
        if(anInt1282 == 1 && anInt1133 < 2)
            s = "Use " + aString1286 + " with...";
        else
        if(anInt1136 == 1 && anInt1133 < 2)
            s = aString1139 + "...";
        else
            s = aStringArray1199[anInt1133 - 1];
        if(anInt1133 > 2)
            s = s + "@whi@ / " + (anInt1133 - 2) + " more options";
        aClass30_Sub2_Sub1_Sub4_1272.method390(true, 4, 0xffffff, s, anInt1161 / 1000, 973, 15);
        if(i != 45706)
        {
            for(int j = 1; j > 0; j++);
        }
    }

    public final void method126(boolean flag)
    {
        if(flag)
            return;
        aClass15_1164.method237(0);
        if(anInt1021 == 2)
        {
            byte abyte0[] = aClass30_Sub2_Sub1_Sub2_1197.aByteArray1450;
            int ai[] = Class30_Sub2_Sub1.anIntArray1378;
            int k2 = abyte0.length;
            for(int i5 = 0; i5 < k2; i5++)
                if(abyte0[i5] == 0)
                    ai[i5] = 0;

            aClass30_Sub2_Sub1_Sub1_1122.method352(33, anInt1185, anIntArray1057, 256, anIntArray968, -236, 25, 0, 0, 33, 25);
            aClass15_1165.method237(0);
            return;
        }
        int i = anInt1185 + anInt1209 & 0x7ff;
        int j = 48 + ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 / 32;
        int l2 = 464 - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 / 32;
        aClass30_Sub2_Sub1_Sub1_1263.method352(151, i, anIntArray1229, 256 + anInt1170, anIntArray1052, -236, l2, 5, 25, 146, j);
        aClass30_Sub2_Sub1_Sub1_1122.method352(33, anInt1185, anIntArray1057, 256, anIntArray968, -236, 25, 0, 0, 33, 25);
        for(int j5 = 0; j5 < anInt1071; j5++)
        {
            int k = (anIntArray1072[j5] * 4 + 2) - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 / 32;
            int i3 = (anIntArray1073[j5] * 4 + 2) - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 / 32;
            method141(aClass30_Sub2_Sub1_Sub1Array1140[j5], k, i3, false);
        }

        for(int k5 = 0; k5 < 104; k5++)
        {
            for(int l5 = 0; l5 < 104; l5++)
            {
                Class19 class19 = aClass19ArrayArrayArray827[anInt918][k5][l5];
                if(class19 != null)
                {
                    int l = (k5 * 4 + 2) - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 / 32;
                    int j3 = (l5 * 4 + 2) - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 / 32;
                    method141(aClass30_Sub2_Sub1_Sub1_1074, l, j3, false);
                }
            }

        }

        for(int i6 = 0; i6 < anInt836; i6++)
        {
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[anIntArray837[i6]];
            if(class30_sub2_sub4_sub1_sub1 != null && class30_sub2_sub4_sub1_sub1.method449(aBoolean1224))
            {
                Class5 class5 = class30_sub2_sub4_sub1_sub1.aClass5_1696;
                if(class5.anIntArray88 != null)
                    class5 = class5.method161(anInt877);
                if(class5 != null && class5.aBoolean87 && class5.aBoolean84)
                {
                    int i1 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1550 / 32 - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 / 32;
                    int k3 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anInt1551 / 32 - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 / 32;
                    method141(aClass30_Sub2_Sub1_Sub1_1075, i1, k3, false);
                }
            }
        }

        for(int j6 = 0; j6 < anInt891; j6++)
        {
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[anIntArray892[j6]];
            if(class30_sub2_sub4_sub1_sub2 != null && class30_sub2_sub4_sub1_sub2.method449(aBoolean1224))
            {
                int j1 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1550 / 32 - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 / 32;
                int l3 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anInt1551 / 32 - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 / 32;
                boolean flag1 = false;
                long l6 = Class50.method583(class30_sub2_sub4_sub1_sub2.aString1703);
                for(int k6 = 0; k6 < anInt899; k6++)
                {
                    if(l6 != aLongArray955[k6] || anIntArray826[k6] == 0)
                        continue;
                    flag1 = true;
                    break;
                }

                boolean flag2 = false;
                if(aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1701 != 0 && class30_sub2_sub4_sub1_sub2.anInt1701 != 0 && aClass30_Sub2_Sub4_Sub1_Sub2_1126.anInt1701 == class30_sub2_sub4_sub1_sub2.anInt1701)
                    flag2 = true;
                if(flag1)
                    method141(aClass30_Sub2_Sub1_Sub1_1077, j1, l3, false);
                else
                if(flag2)
                    method141(aClass30_Sub2_Sub1_Sub1_1078, j1, l3, false);
                else
                    method141(aClass30_Sub2_Sub1_Sub1_1076, j1, l3, false);
            }
        }

        if(anInt855 != 0 && anInt1161 % 20 < 10)
        {
            if(anInt855 == 1 && anInt1222 >= 0 && anInt1222 < aClass30_Sub2_Sub4_Sub1_Sub1Array835.length)
            {
                Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1_1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[anInt1222];
                if(class30_sub2_sub4_sub1_sub1_1 != null)
                {
                    int k1 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_1)).anInt1550 / 32 - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 / 32;
                    int i4 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1_1)).anInt1551 / 32 - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 / 32;
                    method81(aClass30_Sub2_Sub1_Sub1_871, -760, i4, k1);
                }
            }
            if(anInt855 == 2)
            {
                int l1 = ((anInt934 - anInt1034) * 4 + 2) - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 / 32;
                int j4 = ((anInt935 - anInt1035) * 4 + 2) - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 / 32;
                method81(aClass30_Sub2_Sub1_Sub1_871, -760, j4, l1);
            }
            if(anInt855 == 10 && anInt933 >= 0 && anInt933 < aClass30_Sub2_Sub4_Sub1_Sub2Array890.length)
            {
                Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2_1 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[anInt933];
                if(class30_sub2_sub4_sub1_sub2_1 != null)
                {
                    int i2 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_1)).anInt1550 / 32 - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 / 32;
                    int k4 = ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2_1)).anInt1551 / 32 - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 / 32;
                    method81(aClass30_Sub2_Sub1_Sub1_871, -760, k4, i2);
                }
            }
        }
        if(anInt1261 != 0)
        {
            int j2 = (anInt1261 * 4 + 2) - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550 / 32;
            int l4 = (anInt1262 * 4 + 2) - ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551 / 32;
            method141(aClass30_Sub2_Sub1_Sub1_870, j2, l4, false);
        }
        Class30_Sub2_Sub1.method336(3, 78, 97, 0xffffff, 3, 0);
        aClass15_1165.method237(0);
    }

    public final void method127(boolean flag, Class30_Sub2_Sub4_Sub1 class30_sub2_sub4_sub1, int i)
    {
        if(!flag)
            opcode = aClass30_Sub2_Sub2_1083.method408();
        method128(class30_sub2_sub4_sub1.anInt1550, i, anInt875, class30_sub2_sub4_sub1.anInt1551);
    }

    public final void method128(int i, int j, int k, int l)
    {
        if(i < 128 || l < 128 || i > 13056 || l > 13056)
        {
            anInt963 = -1;
            anInt964 = -1;
            return;
        }
        int i1 = method42(anInt918, l, true, i) - j;
        i -= anInt858;
        i1 -= anInt859;
        l -= anInt860;
        int j1 = Class30_Sub2_Sub4_Sub6.anIntArray1689[anInt861];
        int k1 = Class30_Sub2_Sub4_Sub6.anIntArray1690[anInt861];
        int l1 = Class30_Sub2_Sub4_Sub6.anIntArray1689[anInt862];
        int i2 = Class30_Sub2_Sub4_Sub6.anIntArray1690[anInt862];
        int j2 = l * l1 + i * i2 >> 16;
        l = l * i2 - i * l1 >> 16;
        i = j2;
        if(k >= 0)
            aClass30_Sub2_Sub2_1192.method398(27);
        j2 = i1 * k1 - l * j1 >> 16;
        l = i1 * j1 + l * k1 >> 16;
        i1 = j2;
        if(l >= 50)
        {
            anInt963 = Class30_Sub2_Sub1_Sub3.anInt1466 + (i << 9) / l;
            anInt964 = Class30_Sub2_Sub1_Sub3.anInt1467 + (i1 << 9) / l;
            return;
        } else
        {
            anInt963 = -1;
            anInt964 = -1;
            return;
        }
    }

    public final void method129(boolean flag)
    {
        if(anInt1195 == 0)
            return;
        int i = 0;
        if(flag)
            opcode = -1;
        if(anInt1104 != 0)
            i = 1;
        for(int j = 0; j < 100; j++)
            if(aStringArray944[j] != null)
            {
                int k = anIntArray942[j];
                String s = aStringArray943[j];
                boolean flag1 = false;
                if(s != null && s.startsWith("@cr1@"))
                {
                    s = s.substring(5);
                    boolean flag2 = true;
                }
                if(s != null && s.startsWith("@cr2@"))
                {
                    s = s.substring(5);
                    byte byte0 = 2;
                }
                if((k == 3 || k == 7) && (k == 7 || anInt845 == 0 || anInt845 == 1 && method109(false, s)))
                {
                    int l = 329 - i * 13;
                    if(super.anInt20 > 4 && super.anInt21 - 4 > l - 10 && super.anInt21 - 4 <= l + 3)
                    {
                        int i1 = aClass30_Sub2_Sub1_Sub4_1271.method383(anInt1116, "From:  " + s + aStringArray944[j]) + 25;
                        if(i1 > 450)
                            i1 = 450;
                        if(super.anInt20 < 4 + i1)
                        {
                            if(anInt863 >= 1)
                            {
                                aStringArray1199[anInt1133] = "Report abuse @whi@" + s;
                                anIntArray1093[anInt1133] = 2606;
                                anInt1133++;
                            }
                            aStringArray1199[anInt1133] = "Add ignore @whi@" + s;
                            anIntArray1093[anInt1133] = 2042;
                            anInt1133++;
                            aStringArray1199[anInt1133] = "Add friend @whi@" + s;
                            anIntArray1093[anInt1133] = 2337;
                            anInt1133++;
                        }
                    }
                    if(++i >= 5)
                        return;
                }
                if((k == 5 || k == 6) && anInt845 < 2 && ++i >= 5)
                    return;
            }

    }

    private final void method130(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        Class30_Sub1 class30_sub1 = null;
        for(Class30_Sub1 class30_sub1_1 = (Class30_Sub1)aClass19_1179.method252(); class30_sub1_1 != null; class30_sub1_1 = (Class30_Sub1)aClass19_1179.method254(false))
        {
            if(class30_sub1_1.anInt1295 != l1 || class30_sub1_1.anInt1297 != i2 || class30_sub1_1.anInt1298 != j1 || class30_sub1_1.anInt1296 != i1)
                continue;
            class30_sub1 = class30_sub1_1;
            break;
        }

        if(class30_sub1 == null)
        {
            class30_sub1 = new Class30_Sub1();
            class30_sub1.anInt1295 = l1;
            class30_sub1.anInt1296 = i1;
            class30_sub1.anInt1297 = i2;
            class30_sub1.anInt1298 = j1;
            method89(false, class30_sub1);
            aClass19_1179.method249(class30_sub1);
        }
        class30_sub1.anInt1291 = k;
        class30_sub1.anInt1293 = k1;
        class30_sub1.anInt1292 = l;
        class30_sub1.anInt1302 = j2;
        class30_sub1.anInt1294 = j;
        if(i > 0);
    }

    public final boolean method131(Class9 class9, boolean flag)
    {
        if(flag)
            anInt883 = -211;
        if(class9.anIntArray245 == null)
            return false;
        for(int i = 0; i < class9.anIntArray245.length; i++)
        {
            int j = method124(341, class9, i);
            int k = class9.anIntArray212[i];
            if(class9.anIntArray245[i] == 2)
            {
                if(j >= k)
                    return false;
            } else
            if(class9.anIntArray245[i] == 3)
            {
                if(j <= k)
                    return false;
            } else
            if(class9.anIntArray245[i] == 4)
            {
                if(j == k)
                    return false;
            } else
            if(j != k)
                return false;
        }

        return true;
    }

    public final DataInputStream method132(String s)
        throws IOException
    {
 //       if(!aBoolean872)
 //           if(signlink.mainapp != null)
 //               return signlink.openurl(s);
 //           else
 //               return new DataInputStream((new URL(getCodeBase(), s)).openStream());
        if(aSocket832 != null)
        {
            try
            {
                aSocket832.close();
            }
            catch(Exception _ex) { }
            aSocket832 = null;
        }
        aSocket832 = method19(43595);
        aSocket832.setSoTimeout(10000);
        java.io.InputStream inputstream = aSocket832.getInputStream();
        OutputStream outputstream = aSocket832.getOutputStream();
        outputstream.write(("JAGGRAB /" + s + "\n\n").getBytes());
        return new DataInputStream(inputstream);
    }

    public final void method133(byte byte0)
    {
        char c = '\u0100';
        if(anInt1040 > 0)
        {
            for(int i = 0; i < 256; i++)
                if(anInt1040 > 768)
                    anIntArray850[i] = method83(true, anIntArray851[i], anIntArray852[i], 1024 - anInt1040);
                else
                if(anInt1040 > 256)
                    anIntArray850[i] = anIntArray852[i];
                else
                    anIntArray850[i] = method83(true, anIntArray852[i], anIntArray851[i], 256 - anInt1040);

        } else
        if(anInt1041 > 0)
        {
            for(int j = 0; j < 256; j++)
                if(anInt1041 > 768)
                    anIntArray850[j] = method83(true, anIntArray851[j], anIntArray853[j], 1024 - anInt1041);
                else
                if(anInt1041 > 256)
                    anIntArray850[j] = anIntArray853[j];
                else
                    anIntArray850[j] = method83(true, anIntArray853[j], anIntArray851[j], 256 - anInt1041);

        } else
        {
            for(int k = 0; k < 256; k++)
                anIntArray850[k] = anIntArray851[k];

        }
        for(int l = 0; l < 33920; l++)
            aClass15_1110.anIntArray315[l] = aClass30_Sub2_Sub1_Sub1_1201.anIntArray1439[l];

        int i1 = 0;
        int j1 = 1152;
        for(int k1 = 1; k1 < c - 1; k1++)
        {
            int l1 = (anIntArray969[k1] * (c - k1)) / c;
            int j2 = 22 + l1;
            if(j2 < 0)
                j2 = 0;
            i1 += j2;
            for(int l2 = j2; l2 < 128; l2++)
            {
                int j3 = anIntArray828[i1++];
                if(j3 != 0)
                {
                    int l3 = j3;
                    int j4 = 256 - j3;
                    j3 = anIntArray850[j3];
                    int l4 = aClass15_1110.anIntArray315[j1];
                    aClass15_1110.anIntArray315[j1++] = ((j3 & 0xff00ff) * l3 + (l4 & 0xff00ff) * j4 & 0xff00ff00) + ((j3 & 0xff00) * l3 + (l4 & 0xff00) * j4 & 0xff0000) >> 8;
                } else
                {
                    j1++;
                }
            }

            j1 += j2;
        }

        aClass15_1110.method238(0, 23680, super.aGraphics12, 0);
        for(int i2 = 0; i2 < 33920; i2++)
            aClass15_1111.anIntArray315[i2] = aClass30_Sub2_Sub1_Sub1_1202.anIntArray1439[i2];

        i1 = 0;
        j1 = 1176;
        for(int k2 = 1; k2 < c - 1; k2++)
        {
            int i3 = (anIntArray969[k2] * (c - k2)) / c;
            int k3 = 103 - i3;
            j1 += i3;
            for(int i4 = 0; i4 < k3; i4++)
            {
                int k4 = anIntArray828[i1++];
                if(k4 != 0)
                {
                    int i5 = k4;
                    int j5 = 256 - k4;
                    k4 = anIntArray850[k4];
                    int k5 = aClass15_1111.anIntArray315[j1];
                    aClass15_1111.anIntArray315[j1++] = ((k4 & 0xff00ff) * i5 + (k5 & 0xff00ff) * j5 & 0xff00ff00) + ((k4 & 0xff00) * i5 + (k5 & 0xff00) * j5 & 0xff0000) >> 8;
                } else
                {
                    j1++;
                }
            }

            i1 += 128 - k3;
            j1 += 128 - k3 - i3;
        }

        aClass15_1111.method238(0, 23680, super.aGraphics12, 637);
        if(byte0 != 9)
            opcode = aClass30_Sub2_Sub2_1083.method408();
    }

    /**
     * Updates other player movements (currently unused by server)
     * @param byte0
     * @param i expected packet size
     * @param class30_sub2_sub2
     */
    private final void method134(byte byte0, int i, Class30_Sub2_Sub2 class30_sub2_sub2) {
        System.out.println("METHOD 134 CALLED");
        // how many other player movements to update
        int j = class30_sub2_sub2.method419(8, 0);
        // i'm not sure if this is in our zone or in the server entirely?
        //System.out.println("There are: " + anInt891 + " other players");

        if(j < anInt891) {
            for(int k = j; k < anInt891; k++)
                anIntArray840[anInt839++] = anIntArray892[k];
        }

        if(j > anInt891) {
            signlink.reporterror(aString1173 + " Too many players");
            throw new RuntimeException("eek");
        }

        // resets anInt891 to check our suggest amount (j) to the actual amount > (anInt891)
        // i think...
        // for now we say 0 player in j, so this will not run thankfully!
        anInt891 = 0;

        for(int l = 0; l < j; l++) {
            System.out.println("Beginning other player movement updates...");
            int i1 = anIntArray892[l];
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i1];
            int j1 = class30_sub2_sub2.method419(1, 0);
            if(j1 == 0) {
                anIntArray892[anInt891++] = i1;
                class30_sub2_sub4_sub1_sub2.anInt1537 = anInt1161;
            } else {
                int k1 = class30_sub2_sub2.method419(2, 0);
                if(k1 == 0)
                {
                    anIntArray892[anInt891++] = i1;
                    class30_sub2_sub4_sub1_sub2.anInt1537 = anInt1161;
                    anIntArray894[anInt893++] = i1;
                } else
                if(k1 == 1)
                {
                    anIntArray892[anInt891++] = i1;
                    class30_sub2_sub4_sub1_sub2.anInt1537 = anInt1161;
                    int l1 = class30_sub2_sub2.method419(3, 0);
                    class30_sub2_sub4_sub1_sub2.method448(false, (byte)20, l1);
                    int j2 = class30_sub2_sub2.method419(1, 0);
                    if(j2 == 1)
                        anIntArray894[anInt893++] = i1;
                } else
                if(k1 == 2)
                {
                    anIntArray892[anInt891++] = i1;
                    class30_sub2_sub4_sub1_sub2.anInt1537 = anInt1161;
                    int i2 = class30_sub2_sub2.method419(3, 0);
                    class30_sub2_sub4_sub1_sub2.method448(true, (byte)20, i2);
                    int k2 = class30_sub2_sub2.method419(3, 0);
                    class30_sub2_sub4_sub1_sub2.method448(true, (byte)20, k2);
                    int l2 = class30_sub2_sub2.method419(1, 0);
                    if(l2 == 1)
                        anIntArray894[anInt893++] = i1;
                } else
                if(k1 == 3)
                    anIntArray840[anInt839++] = i1;
            }
        }

        if(byte0 != 2)
            anInt939 = -80;
    }

    public final void method135(boolean flag, boolean flag1)
    {
        method64(0);
        aClass15_1109.method237(0);
        aClass30_Sub2_Sub1_Sub2_966.method361(0, 16083, 0);
        char c = '\u0168';
        char c1 = '\310';
        if(flag1)
            return;
        if(anInt833 == 0)
        {
            int i = c1 / 2 + 80;
            aClass30_Sub2_Sub1_Sub4_1270.method382(0x75a9a9, c / 2, anInt939, aClass42_Sub1_1068.aString1333, i, true);
            i = c1 / 2 - 20;
            aClass30_Sub2_Sub1_Sub4_1272.method382(0xffff00, c / 2, anInt939, "Welcome to RuneScape", i, true);
            i += 30;
            int l = c / 2 - 80;
            int k1 = c1 / 2 + 20;
            aClass30_Sub2_Sub1_Sub2_967.method361(l - 73, 16083, k1 - 20);
            aClass30_Sub2_Sub1_Sub4_1272.method382(0xffffff, l, anInt939, "New User", k1 + 5, true);
            l = c / 2 + 80;
            aClass30_Sub2_Sub1_Sub2_967.method361(l - 73, 16083, k1 - 20);
            aClass30_Sub2_Sub1_Sub4_1272.method382(0xffffff, l, anInt939, "Existing User", k1 + 5, true);
        }
        if(anInt833 == 2)
        {
            int j = c1 / 2 - 40;
            if(aString1266.length() > 0)
            {
                aClass30_Sub2_Sub1_Sub4_1272.method382(0xffff00, c / 2, anInt939, aString1266, j - 15, true);
                aClass30_Sub2_Sub1_Sub4_1272.method382(0xffff00, c / 2, anInt939, aString1267, j, true);
                j += 30;
            } else
            {
                aClass30_Sub2_Sub1_Sub4_1272.method382(0xffff00, c / 2, anInt939, aString1267, j - 7, true);
                j += 30;
            }
            aClass30_Sub2_Sub1_Sub4_1272.method389(false, true, c / 2 - 90, 0xffffff, "Username: " + aString1173 + ((anInt1216 == 0) & (anInt1161 % 40 < 20) ? "@yel@|" : ""), j);
            j += 15;
            aClass30_Sub2_Sub1_Sub4_1272.method389(false, true, c / 2 - 88, 0xffffff, "Password: " + Class50.method588(aString1174, 0) + ((anInt1216 == 1) & (anInt1161 % 40 < 20) ? "@yel@|" : ""), j);
            j += 15;
            if(!flag)
            {
                int i1 = c / 2 - 80;
                int l1 = c1 / 2 + 50;
                aClass30_Sub2_Sub1_Sub2_967.method361(i1 - 73, 16083, l1 - 20);
                aClass30_Sub2_Sub1_Sub4_1272.method382(0xffffff, i1, anInt939, "Login", l1 + 5, true);
                i1 = c / 2 + 80;
                aClass30_Sub2_Sub1_Sub2_967.method361(i1 - 73, 16083, l1 - 20);
                aClass30_Sub2_Sub1_Sub4_1272.method382(0xffffff, i1, anInt939, "Cancel", l1 + 5, true);
            }
        }
        if(anInt833 == 3)
        {
            aClass30_Sub2_Sub1_Sub4_1272.method382(0xffff00, c / 2, anInt939, "Create a free account", c1 / 2 - 60, true);
            int k = c1 / 2 - 35;
            aClass30_Sub2_Sub1_Sub4_1272.method382(0xffffff, c / 2, anInt939, "To create a new account you need to", k, true);
            k += 15;
            aClass30_Sub2_Sub1_Sub4_1272.method382(0xffffff, c / 2, anInt939, "go back to the main RuneScape webpage", k, true);
            k += 15;
            aClass30_Sub2_Sub1_Sub4_1272.method382(0xffffff, c / 2, anInt939, "and choose the red 'create account'", k, true);
            k += 15;
            aClass30_Sub2_Sub1_Sub4_1272.method382(0xffffff, c / 2, anInt939, "button at the top right of that page.", k, true);
            k += 15;
            int j1 = c / 2;
            int i2 = c1 / 2 + 50;
            aClass30_Sub2_Sub1_Sub2_967.method361(j1 - 73, 16083, i2 - 20);
            aClass30_Sub2_Sub1_Sub4_1272.method382(0xffffff, j1, anInt939, "Cancel", i2 + 5, true);
        }
        aClass15_1109.method238(171, 23680, super.aGraphics12, 202);
        if(aBoolean1255)
        {
            aBoolean1255 = false;
            aClass15_1107.method238(0, 23680, super.aGraphics12, 128);
            aClass15_1108.method238(371, 23680, super.aGraphics12, 202);
            aClass15_1112.method238(265, 23680, super.aGraphics12, 0);
            aClass15_1113.method238(265, 23680, super.aGraphics12, 562);
            aClass15_1114.method238(171, 23680, super.aGraphics12, 128);
            aClass15_1115.method238(171, 23680, super.aGraphics12, 562);
        }
    }

    public final void method136(byte byte0)
    {
        aBoolean962 = true;
        if(byte0 != 59)
            anInt1058 = -186;
        try
        {
            long l = System.currentTimeMillis();
            int i = 0;
            int j = 20;
            while(aBoolean831) 
            {
                anInt1208++;
                method58(25106);
                method58(25106);
                method133((byte)9);
                if(++i > 10)
                {
                    long l1 = System.currentTimeMillis();
                    int k = (int)(l1 - l) / 10 - j;
                    j = 40 - k;
                    if(j < 5)
                        j = 5;
                    i = 0;
                    l = l1;
                }
                try
                {
                    Thread.sleep(j);
                }
                catch(Exception _ex) { }
            }
        }
        catch(Exception _ex) { }
        aBoolean962 = false;
    }

    public final void method10(byte byte0)
    {
        aBoolean1255 = true;
        if(byte0 == 1)
        {
            byte0 = 0;
            return;
        } else
        {
            anInt1218 = aClass17_1000.method246();
            return;
        }
    }

    public final void method137(int i, Class30_Sub2_Sub2 class30_sub2_sub2, int j)
    {
        while(i >= 0) 
            j = -1;
        if(j == 84)
        {
            int k = class30_sub2_sub2.method408();
            int j3 = anInt1268 + (k >> 4 & 7);
            int i6 = anInt1269 + (k & 7);
            int l8 = class30_sub2_sub2.method410();
            int k11 = class30_sub2_sub2.method410();
            int l13 = class30_sub2_sub2.method410();
            if(j3 >= 0 && i6 >= 0 && j3 < 104 && i6 < 104)
            {
                Class19 class19_1 = aClass19ArrayArrayArray827[anInt918][j3][i6];
                if(class19_1 != null)
                {
                    for(Class30_Sub2_Sub4_Sub2 class30_sub2_sub4_sub2_3 = (Class30_Sub2_Sub4_Sub2)class19_1.method252(); class30_sub2_sub4_sub2_3 != null; class30_sub2_sub4_sub2_3 = (Class30_Sub2_Sub4_Sub2)class19_1.method254(false))
                    {
                        if(class30_sub2_sub4_sub2_3.anInt1558 != (l8 & 0x7fff) || class30_sub2_sub4_sub2_3.anInt1559 != k11)
                            continue;
                        class30_sub2_sub4_sub2_3.anInt1559 = l13;
                        break;
                    }

                    method25(j3, i6);
                }
            }
            return;
        }
        if(j == 105)
        {
            int l = class30_sub2_sub2.method408();
            int k3 = anInt1268 + (l >> 4 & 7);
            int j6 = anInt1269 + (l & 7);
            int i9 = class30_sub2_sub2.method410();
            int l11 = class30_sub2_sub2.method408();
            int i14 = l11 >> 4 & 0xf;
            int i16 = l11 & 7;
            if(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0] >= k3 - i14 && ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0] <= k3 + i14 && ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0] >= j6 - i14 && ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0] <= j6 + i14 && aBoolean848 && !aBoolean960 && anInt1062 < 50)
            {
                anIntArray1207[anInt1062] = i9;
                anIntArray1241[anInt1062] = i16;
                anIntArray1250[anInt1062] = Class16.anIntArray326[i9];
                anInt1062++;
            }
        }
        if(j == 215)
        {
            int i1 = class30_sub2_sub2.method435(true);
            int l3 = class30_sub2_sub2.method428(2);
            int k6 = anInt1268 + (l3 >> 4 & 7);
            int j9 = anInt1269 + (l3 & 7);
            int i12 = class30_sub2_sub2.method435(true);
            int j14 = class30_sub2_sub2.method410();
            if(k6 >= 0 && j9 >= 0 && k6 < 104 && j9 < 104 && i12 != anInt884)
            {
                Class30_Sub2_Sub4_Sub2 class30_sub2_sub4_sub2_2 = new Class30_Sub2_Sub4_Sub2();
                class30_sub2_sub4_sub2_2.anInt1558 = i1;
                class30_sub2_sub4_sub2_2.anInt1559 = j14;
                if(aClass19ArrayArrayArray827[anInt918][k6][j9] == null)
                    aClass19ArrayArrayArray827[anInt918][k6][j9] = new Class19(169);
                aClass19ArrayArrayArray827[anInt918][k6][j9].method249(class30_sub2_sub4_sub2_2);
                method25(k6, j9);
            }
            return;
        }
        if(j == 156)
        {
            int j1 = class30_sub2_sub2.method426(0);
            int i4 = anInt1268 + (j1 >> 4 & 7);
            int l6 = anInt1269 + (j1 & 7);
            int k9 = class30_sub2_sub2.method410();
            if(i4 >= 0 && l6 >= 0 && i4 < 104 && l6 < 104)
            {
                Class19 class19 = aClass19ArrayArrayArray827[anInt918][i4][l6];
                if(class19 != null)
                {
                    for(Class30_Sub2_Sub4_Sub2 class30_sub2_sub4_sub2 = (Class30_Sub2_Sub4_Sub2)class19.method252(); class30_sub2_sub4_sub2 != null; class30_sub2_sub4_sub2 = (Class30_Sub2_Sub4_Sub2)class19.method254(false))
                    {
                        if(class30_sub2_sub4_sub2.anInt1558 != (k9 & 0x7fff))
                            continue;
                        class30_sub2_sub4_sub2.method329();
                        break;
                    }

                    if(class19.method252() == null)
                        aClass19ArrayArrayArray827[anInt918][i4][l6] = null;
                    method25(i4, l6);
                }
            }
            return;
        }
        if(j == 160)
        {
            int k1 = class30_sub2_sub2.method428(2);
            int j4 = anInt1268 + (k1 >> 4 & 7);
            int i7 = anInt1269 + (k1 & 7);
            int l9 = class30_sub2_sub2.method428(2);
            int j12 = l9 >> 2;
            int k14 = l9 & 3;
            int j16 = anIntArray1177[j12];
            int j17 = class30_sub2_sub2.method435(true);
            if(j4 >= 0 && i7 >= 0 && j4 < 103 && i7 < 103)
            {
                int j18 = anIntArrayArrayArray1214[anInt918][j4][i7];
                int i19 = anIntArrayArrayArray1214[anInt918][j4 + 1][i7];
                int l19 = anIntArrayArrayArray1214[anInt918][j4 + 1][i7 + 1];
                int k20 = anIntArrayArrayArray1214[anInt918][j4][i7 + 1];
                if(j16 == 0)
                {
                    Class10 class10 = aClass25_946.method296(anInt918, j4, i7, false);
                    if(class10 != null)
                    {
                        int k21 = class10.anInt280 >> 14 & 0x7fff;
                        if(j12 == 2)
                        {
                            class10.aClass30_Sub2_Sub4_278 = new Class30_Sub2_Sub4_Sub5(k21, 4 + k14, 2, i19, (byte)7, l19, j18, k20, j17, false);
                            class10.aClass30_Sub2_Sub4_279 = new Class30_Sub2_Sub4_Sub5(k21, k14 + 1 & 3, 2, i19, (byte)7, l19, j18, k20, j17, false);
                        } else
                        {
                            class10.aClass30_Sub2_Sub4_278 = new Class30_Sub2_Sub4_Sub5(k21, k14, j12, i19, (byte)7, l19, j18, k20, j17, false);
                        }
                    }
                }
                if(j16 == 1)
                {
                    Class26 class26 = aClass25_946.method297(j4, 866, i7, anInt918);
                    if(class26 != null)
                        class26.aClass30_Sub2_Sub4_504 = new Class30_Sub2_Sub4_Sub5(class26.anInt505 >> 14 & 0x7fff, 0, 4, i19, (byte)7, l19, j18, k20, j17, false);
                }
                if(j16 == 2)
                {
                    Class28 class28 = aClass25_946.method298(j4, i7, (byte)4, anInt918);
                    if(j12 == 11)
                        j12 = 10;
                    if(class28 != null)
                        class28.aClass30_Sub2_Sub4_521 = new Class30_Sub2_Sub4_Sub5(class28.anInt529 >> 14 & 0x7fff, k14, j12, i19, (byte)7, l19, j18, k20, j17, false);
                }
                if(j16 == 3)
                {
                    Class49 class49 = aClass25_946.method299(i7, j4, anInt918, 0);
                    if(class49 != null)
                        class49.aClass30_Sub2_Sub4_814 = new Class30_Sub2_Sub4_Sub5(class49.anInt815 >> 14 & 0x7fff, k14, 22, i19, (byte)7, l19, j18, k20, j17, false);
                }
            }
            return;
        }
        if(j == 147)
        {
            int l1 = class30_sub2_sub2.method428(2);
            int k4 = anInt1268 + (l1 >> 4 & 7);
            int j7 = anInt1269 + (l1 & 7);
            int i10 = class30_sub2_sub2.method410();
            byte byte0 = class30_sub2_sub2.method430(0);
            int l14 = class30_sub2_sub2.method434((byte)108);
            byte byte1 = class30_sub2_sub2.method429((byte)-57);
            int k17 = class30_sub2_sub2.method410();
            int k18 = class30_sub2_sub2.method428(2);
            int j19 = k18 >> 2;
            int i20 = k18 & 3;
            int l20 = anIntArray1177[j19];
            byte byte2 = class30_sub2_sub2.method409();
            int l21 = class30_sub2_sub2.method410();
            byte byte3 = class30_sub2_sub2.method429((byte)-57);
            Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2;
            if(i10 == anInt884)
                class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2_1126;
            else
                class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i10];
            if(class30_sub2_sub4_sub1_sub2 != null)
            {
                Class46 class46 = Class46.method572(l21);
                int i22 = anIntArrayArrayArray1214[anInt918][k4][j7];
                int j22 = anIntArrayArrayArray1214[anInt918][k4 + 1][j7];
                int k22 = anIntArrayArrayArray1214[anInt918][k4 + 1][j7 + 1];
                int l22 = anIntArrayArrayArray1214[anInt918][k4][j7 + 1];
                Class30_Sub2_Sub4_Sub6 class30_sub2_sub4_sub6 = class46.method578(j19, i20, i22, j22, k22, l22, -1);
                if(class30_sub2_sub4_sub6 != null)
                {
                    method130(404, k17 + 1, -1, 0, l20, j7, 0, anInt918, k4, l14 + 1);
                    class30_sub2_sub4_sub1_sub2.anInt1707 = l14 + anInt1161;
                    class30_sub2_sub4_sub1_sub2.anInt1708 = k17 + anInt1161;
                    class30_sub2_sub4_sub1_sub2.aClass30_Sub2_Sub4_Sub6_1714 = class30_sub2_sub4_sub6;
                    int i23 = class46.anInt744;
                    int j23 = class46.anInt761;
                    if(i20 == 1 || i20 == 3)
                    {
                        i23 = class46.anInt761;
                        j23 = class46.anInt744;
                    }
                    class30_sub2_sub4_sub1_sub2.anInt1711 = k4 * 128 + i23 * 64;
                    class30_sub2_sub4_sub1_sub2.anInt1713 = j7 * 128 + j23 * 64;
                    class30_sub2_sub4_sub1_sub2.anInt1712 = method42(anInt918, class30_sub2_sub4_sub1_sub2.anInt1713, true, class30_sub2_sub4_sub1_sub2.anInt1711);
                    if(byte2 > byte0)
                    {
                        byte byte4 = byte2;
                        byte2 = byte0;
                        byte0 = byte4;
                    }
                    if(byte3 > byte1)
                    {
                        byte byte5 = byte3;
                        byte3 = byte1;
                        byte1 = byte5;
                    }
                    class30_sub2_sub4_sub1_sub2.anInt1719 = k4 + byte2;
                    class30_sub2_sub4_sub1_sub2.anInt1721 = k4 + byte0;
                    class30_sub2_sub4_sub1_sub2.anInt1720 = j7 + byte3;
                    class30_sub2_sub4_sub1_sub2.anInt1722 = j7 + byte1;
                }
            }
        }
        if(j == 151)
        {
            int i2 = class30_sub2_sub2.method426(0);
            int l4 = anInt1268 + (i2 >> 4 & 7);
            int k7 = anInt1269 + (i2 & 7);
            int j10 = class30_sub2_sub2.method434((byte)108);
            int k12 = class30_sub2_sub2.method428(2);
            int i15 = k12 >> 2;
            int k16 = k12 & 3;
            int l17 = anIntArray1177[i15];
            if(l4 >= 0 && k7 >= 0 && l4 < 104 && k7 < 104)
                method130(404, -1, j10, k16, l17, k7, i15, anInt918, l4, 0);
            return;
        }
        if(j == 4)
        {
            int j2 = class30_sub2_sub2.method408();
            int i5 = anInt1268 + (j2 >> 4 & 7);
            int l7 = anInt1269 + (j2 & 7);
            int k10 = class30_sub2_sub2.method410();
            int l12 = class30_sub2_sub2.method408();
            int j15 = class30_sub2_sub2.method410();
            if(i5 >= 0 && l7 >= 0 && i5 < 104 && l7 < 104)
            {
                i5 = i5 * 128 + 64;
                l7 = l7 * 128 + 64;
                Class30_Sub2_Sub4_Sub3 class30_sub2_sub4_sub3 = new Class30_Sub2_Sub4_Sub3(anInt918, anInt1161, 6, j15, k10, method42(anInt918, l7, true, i5) - l12, l7, i5);
                aClass19_1056.method249(class30_sub2_sub4_sub3);
            }
            return;
        }
        if(j == 44)
        {
            int k2 = class30_sub2_sub2.method436((byte)-74);
            int j5 = class30_sub2_sub2.method410();
            int i8 = class30_sub2_sub2.method408();
            int l10 = anInt1268 + (i8 >> 4 & 7);
            int i13 = anInt1269 + (i8 & 7);
            if(l10 >= 0 && i13 >= 0 && l10 < 104 && i13 < 104)
            {
                Class30_Sub2_Sub4_Sub2 class30_sub2_sub4_sub2_1 = new Class30_Sub2_Sub4_Sub2();
                class30_sub2_sub4_sub2_1.anInt1558 = k2;
                class30_sub2_sub4_sub2_1.anInt1559 = j5;
                if(aClass19ArrayArrayArray827[anInt918][l10][i13] == null)
                    aClass19ArrayArrayArray827[anInt918][l10][i13] = new Class19(169);
                aClass19ArrayArrayArray827[anInt918][l10][i13].method249(class30_sub2_sub4_sub2_1);
                method25(l10, i13);
            }
            return;
        }
        if(j == 101)
        {
            int l2 = class30_sub2_sub2.method427(false);
            int k5 = l2 >> 2;
            int j8 = l2 & 3;
            int i11 = anIntArray1177[k5];
            int j13 = class30_sub2_sub2.method408();
            int k15 = anInt1268 + (j13 >> 4 & 7);
            int l16 = anInt1269 + (j13 & 7);
            if(k15 >= 0 && l16 >= 0 && k15 < 104 && l16 < 104)
                method130(404, -1, -1, j8, i11, l16, k5, anInt918, k15, 0);
            return;
        }
        if(j == 117)
        {
            int i3 = class30_sub2_sub2.method408();
            int l5 = anInt1268 + (i3 >> 4 & 7);
            int k8 = anInt1269 + (i3 & 7);
            int j11 = l5 + class30_sub2_sub2.method409();
            int k13 = k8 + class30_sub2_sub2.method409();
            int l15 = class30_sub2_sub2.method411();
            int i17 = class30_sub2_sub2.method410();
            int i18 = class30_sub2_sub2.method408() * 4;
            int l18 = class30_sub2_sub2.method408() * 4;
            int k19 = class30_sub2_sub2.method410();
            int j20 = class30_sub2_sub2.method410();
            int i21 = class30_sub2_sub2.method408();
            int j21 = class30_sub2_sub2.method408();
            if(l5 >= 0 && k8 >= 0 && l5 < 104 && k8 < 104 && j11 >= 0 && k13 >= 0 && j11 < 104 && k13 < 104 && i17 != 65535)
            {
                l5 = l5 * 128 + 64;
                k8 = k8 * 128 + 64;
                j11 = j11 * 128 + 64;
                k13 = k13 * 128 + 64;
                Class30_Sub2_Sub4_Sub4 class30_sub2_sub4_sub4 = new Class30_Sub2_Sub4_Sub4(i21, l18, 46883, k19 + anInt1161, j20 + anInt1161, j21, anInt918, method42(anInt918, k8, true, l5) - i18, k8, l5, l15, i17);
                class30_sub2_sub4_sub4.method455(k19 + anInt1161, k13, method42(anInt918, k13, true, j11) - l18, j11, (byte)-83);
                aClass19_1013.method249(class30_sub2_sub4_sub4);
            }
        }
    }

    public static final void method138(byte byte0)
    {
        Class25.aBoolean436 = true;
        if(byte0 != aByte823)
        {
            for(int i = 1; i > 0; i++);
        }
        Class30_Sub2_Sub1_Sub3.aBoolean1461 = true;
        aBoolean960 = true;
        Class7.aBoolean151 = true;
        Class46.aBoolean752 = true;
    }

    private final void method139(Class30_Sub2_Sub2 class30_sub2_sub2, int i, int j)
    {
        if(i >= 0)
            anInt1118 = -7;
        class30_sub2_sub2.method418(anInt1118);
        int k = class30_sub2_sub2.method419(8, 0);
        if(k < anInt836)
        {
            for(int l = k; l < anInt836; l++)
                anIntArray840[anInt839++] = anIntArray837[l];

        }
        if(k > anInt836)
        {
            signlink.reporterror(aString1173 + " Too many npcs");
            throw new RuntimeException("eek");
        }
        anInt836 = 0;
        for(int i1 = 0; i1 < k; i1++)
        {
            int j1 = anIntArray837[i1];
            Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[j1];
            int k1 = class30_sub2_sub2.method419(1, 0);
            if(k1 == 0)
            {
                anIntArray837[anInt836++] = j1;
                class30_sub2_sub4_sub1_sub1.anInt1537 = anInt1161;
            } else
            {
                int l1 = class30_sub2_sub2.method419(2, 0);
                if(l1 == 0)
                {
                    anIntArray837[anInt836++] = j1;
                    class30_sub2_sub4_sub1_sub1.anInt1537 = anInt1161;
                    anIntArray894[anInt893++] = j1;
                } else
                if(l1 == 1)
                {
                    anIntArray837[anInt836++] = j1;
                    class30_sub2_sub4_sub1_sub1.anInt1537 = anInt1161;
                    int i2 = class30_sub2_sub2.method419(3, 0);
                    class30_sub2_sub4_sub1_sub1.method448(false, (byte)20, i2);
                    int k2 = class30_sub2_sub2.method419(1, 0);
                    if(k2 == 1)
                        anIntArray894[anInt893++] = j1;
                } else
                if(l1 == 2)
                {
                    anIntArray837[anInt836++] = j1;
                    class30_sub2_sub4_sub1_sub1.anInt1537 = anInt1161;
                    int j2 = class30_sub2_sub2.method419(3, 0);
                    class30_sub2_sub4_sub1_sub1.method448(true, (byte)20, j2);
                    int l2 = class30_sub2_sub2.method419(3, 0);
                    class30_sub2_sub4_sub1_sub1.method448(true, (byte)20, l2);
                    int i3 = class30_sub2_sub2.method419(1, 0);
                    if(i3 == 1)
                        anIntArray894[anInt893++] = j1;
                } else
                if(l1 == 3)
                    anIntArray840[anInt839++] = j1;
            }
        }

    }

    public final void method140(boolean flag)
    {
        if(!flag)
            aClass19ArrayArrayArray827 = null;
        if(anInt833 == 0)
        {
            int i = super.anInt10 / 2 - 80;
            int l = super.anInt11 / 2 + 20;
            l += 20;
            if(super.anInt26 == 1 && super.anInt27 >= i - 75 && super.anInt27 <= i + 75 && super.anInt28 >= l - 20 && super.anInt28 <= l + 20)
            {
                anInt833 = 3;
                anInt1216 = 0;
            }
            i = super.anInt10 / 2 + 80;
            if(super.anInt26 == 1 && super.anInt27 >= i - 75 && super.anInt27 <= i + 75 && super.anInt28 >= l - 20 && super.anInt28 <= l + 20)
            {
                aString1266 = "";
                aString1267 = "Enter your username & password.";
                anInt833 = 2;
                anInt1216 = 0;
                return;
            }
        } else
        {
            if(anInt833 == 2)
            {
                int j = super.anInt11 / 2 - 40;
                j += 30;
                j += 25;
                if(super.anInt26 == 1 && super.anInt28 >= j - 15 && super.anInt28 < j)
                    anInt1216 = 0;
                j += 15;
                if(super.anInt26 == 1 && super.anInt28 >= j - 15 && super.anInt28 < j)
                    anInt1216 = 1;
                j += 15;
                int i1 = super.anInt10 / 2 - 80;
                int k1 = super.anInt11 / 2 + 50;
                k1 += 20;
                if(super.anInt26 == 1 && super.anInt27 >= i1 - 75 && super.anInt27 <= i1 + 75 && super.anInt28 >= k1 - 20 && super.anInt28 <= k1 + 20)
                {
                    anInt1038 = 0;
                    method84(aString1173, aString1174, false);
                    if(aBoolean1157)
                        return;
                }
                i1 = super.anInt10 / 2 + 80;
                if(super.anInt26 == 1 && super.anInt27 >= i1 - 75 && super.anInt27 <= i1 + 75 && super.anInt28 >= k1 - 20 && super.anInt28 <= k1 + 20)
                {
                    anInt833 = 0;
                    aString1173 = "";
                    aString1174 = "";
                }
                do
                {
                    int l1 = method5(-796);
                    if(l1 == -1)
                        break;
                    boolean flag1 = false;
                    for(int i2 = 0; i2 < aString1162.length(); i2++)
                    {
                        if(l1 != aString1162.charAt(i2))
                            continue;
                        flag1 = true;
                        break;
                    }

                    if(anInt1216 == 0)
                    {
                        if(l1 == 8 && aString1173.length() > 0)
                            aString1173 = aString1173.substring(0, aString1173.length() - 1);
                        if(l1 == 9 || l1 == 10 || l1 == 13)
                            anInt1216 = 1;
                        if(flag1)
                            aString1173 += (char)l1;
                        if(aString1173.length() > 12)
                            aString1173 = aString1173.substring(0, 12);
                    } else
                    if(anInt1216 == 1)
                    {
                        if(l1 == 8 && aString1174.length() > 0)
                            aString1174 = aString1174.substring(0, aString1174.length() - 1);
                        if(l1 == 9 || l1 == 10 || l1 == 13)
                            anInt1216 = 0;
                        if(flag1)
                            aString1174 += (char)l1;
                        if(aString1174.length() > 20)
                            aString1174 = aString1174.substring(0, 20);
                    }
                } while(true);
                return;
            }
            if(anInt833 == 3)
            {
                int k = super.anInt10 / 2;
                int j1 = super.anInt11 / 2 + 50;
                j1 += 20;
                if(super.anInt26 == 1 && super.anInt27 >= k - 75 && super.anInt27 <= k + 75 && super.anInt28 >= j1 - 20 && super.anInt28 <= j1 + 20)
                    anInt833 = 0;
            }
        }
    }

    public final void method141(Class30_Sub2_Sub1_Sub1 class30_sub2_sub1_sub1, int i, int j, boolean flag)
    {
        int k = anInt1185 + anInt1209 & 0x7ff;
        int l = i * i + j * j;
        if(flag)
            return;
        if(l > 6400)
            return;
        int i1 = Class30_Sub2_Sub4_Sub6.anIntArray1689[k];
        int j1 = Class30_Sub2_Sub4_Sub6.anIntArray1690[k];
        i1 = (i1 * 256) / (anInt1170 + 256);
        j1 = (j1 * 256) / (anInt1170 + 256);
        int k1 = j * i1 + i * j1 >> 16;
        int l1 = j * j1 - i * i1 >> 16;
        if(l > 2500)
        {
            class30_sub2_sub1_sub1.method354(aClass30_Sub2_Sub1_Sub2_1197, false, 83 - l1 - class30_sub2_sub1_sub1.anInt1445 / 2 - 4, ((94 + k1) - class30_sub2_sub1_sub1.anInt1444 / 2) + 4);
            return;
        } else
        {
            class30_sub2_sub1_sub1.method348(((94 + k1) - class30_sub2_sub1_sub1.anInt1444 / 2) + 4, 16083, 83 - l1 - class30_sub2_sub1_sub1.anInt1445 / 2 - 4);
            return;
        }
    }

    private final void method142(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        if(l1 < 4 || l1 > 4)
            opcode = aClass30_Sub2_Sub2_1083.method408();
        if(i1 >= 1 && i >= 1 && i1 <= 102 && i <= 102)
        {
            if(aBoolean960 && j != anInt918)
                return;
            int i2 = 0;
            byte byte0 = -1;
            boolean flag = false;
            boolean flag1 = false;
            if(j1 == 0)
                i2 = aClass25_946.method300(j, i1, i);
            if(j1 == 1)
                i2 = aClass25_946.method301(j, i1, 0, i);
            if(j1 == 2)
                i2 = aClass25_946.method302(j, i1, i);
            if(j1 == 3)
                i2 = aClass25_946.method303(j, i1, i);
            if(i2 != 0)
            {
                int i3 = aClass25_946.method304(j, i1, i, i2);
                int j2 = i2 >> 14 & 0x7fff;
                int k2 = i3 & 0x1f;
                int l2 = i3 >> 6;
                if(j1 == 0)
                {
                    aClass25_946.method291(i1, j, i, (byte)-119);
                    Class46 class46 = Class46.method572(j2);
                    if(class46.aBoolean767)
                        aClass11Array1230[j].method215(l2, k2, class46.aBoolean757, true, i1, i);
                }
                if(j1 == 1)
                    aClass25_946.method292(0, i, j, i1);
                if(j1 == 2)
                {
                    aClass25_946.method293(j, -978, i1, i);
                    Class46 class46_1 = Class46.method572(j2);
                    if(i1 + class46_1.anInt744 > 103 || i + class46_1.anInt744 > 103 || i1 + class46_1.anInt761 > 103 || i + class46_1.anInt761 > 103)
                        return;
                    if(class46_1.aBoolean767)
                        aClass11Array1230[j].method216(l2, class46_1.anInt744, i1, i, (byte)6, class46_1.anInt761, class46_1.aBoolean757);
                }
                if(j1 == 3)
                {
                    aClass25_946.method294((byte)9, j, i, i1);
                    Class46 class46_2 = Class46.method572(j2);
                    if(class46_2.aBoolean767 && class46_2.aBoolean778)
                        aClass11Array1230[j].method218(360, i, i1);
                }
            }
            if(k1 >= 0)
            {
                int j3 = j;
                if(j3 < 3 && (aByteArrayArrayArray1258[1][i1][i] & 2) == 2)
                    j3++;
                Class7.method188(aClass25_946, k, i, l, j3, aClass11Array1230[j], anIntArrayArrayArray1214, i1, k1, j, (byte)93);
            }
        }
    }

    /**
     * Begins the player initialisation procedure from opcode 81, following a procedure based on
     * 4 steps.
     * @param i no idea
     * @param class30_sub2_sub2 The reading stream for the client
     */
    private final void method143(int i, Class30_Sub2_Sub2 class30_sub2_sub2_1083) {
        System.out.println("\n");
        anInt893 = 0;
        System.out.println("Packet size: " + class30_sub2_sub2_1083.anInt1406);
        // Our player movement updates
        method117(class30_sub2_sub2_1083, i, (byte)5); 
        // Other player movement updates
        method134((byte)2, i, class30_sub2_sub2_1083); 
        // Player list updating - Apperance updating + Location updating
        method91(class30_sub2_sub2_1083, i, (byte)8);  
        // Player update block flag-based updates
        method49(i, (byte)2, class30_sub2_sub2_1083);  

        for(int k = 0; k < anInt839; k++) {
            int l = anIntArray840[k];
            if(((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2Array890[l])).anInt1537 != anInt1161)
                aClass30_Sub2_Sub4_Sub1_Sub2Array890[l] = null;
        }

        System.out.println("Final packet size: " + class30_sub2_sub2_1083.anInt1406 + " should equal: " + i);

        if(class30_sub2_sub2_1083.anInt1406 != i) {
            signlink.reporterror("Error packet size mismatch in getplayer pos: " + class30_sub2_sub2_1083.anInt1406 + " packet size: " + i);
            throw new RuntimeException("eek");
        }
        System.out.println("All good, packet size matches up!");
        
        for(int i1 = 0; i1 < anInt891; i1++) {
            if(aClass30_Sub2_Sub4_Sub1_Sub2Array890[anIntArray892[i1]] == null)
            {
                signlink.reporterror(aString1173 + " null entry in pl list - pos:" + i1 + " size:" + anInt891);
                throw new RuntimeException("eek");
            }
        }
    }

    public final void method144(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = 2048 - k & 0x7ff;
        int i2 = 2048 - j1 & 0x7ff;
        int j2 = 0;
        int k2 = 0;
        int l2 = j;
        if(i != 0)
            method6();
        if(l1 != 0)
        {
            int i3 = Class30_Sub2_Sub4_Sub6.anIntArray1689[l1];
            int k3 = Class30_Sub2_Sub4_Sub6.anIntArray1690[l1];
            int i4 = k2 * k3 - l2 * i3 >> 16;
            l2 = k2 * i3 + l2 * k3 >> 16;
            k2 = i4;
        }
        if(i2 != 0)
        {
            int j3 = Class30_Sub2_Sub4_Sub6.anIntArray1689[i2];
            int l3 = Class30_Sub2_Sub4_Sub6.anIntArray1690[i2];
            int j4 = l2 * j3 + j2 * l3 >> 16;
            l2 = l2 * l3 - j2 * j3 >> 16;
            j2 = j4;
        }
        anInt858 = l - j2;
        anInt859 = i1 - k2;
        anInt860 = k1 - l2;
        anInt861 = k;
        anInt862 = j1;
    }

    public final boolean method145(boolean flag)
    {
        if(!flag)
            aClass19ArrayArrayArray827 = null;
        if(aClass24_1168 == null)
            return false;
        try
        {
            int i = aClass24_1168.method269();
            if(i == 0)
                return false;
            if(opcode == -1)
            {
                aClass24_1168.method270(aClass30_Sub2_Sub2_1083.aByteArray1405, 0, 1);
                opcode = aClass30_Sub2_Sub2_1083.aByteArray1405[0] & 0xff;
                if(aClass17_1000 != null)
                    opcode = opcode - aClass17_1000.method246() & 0xff;
                anInt1007 = Class31.anIntArray553[opcode];
                i--;
            }
            if(anInt1007 == -1)
                if(i > 0)
                {
                    aClass24_1168.method270(aClass30_Sub2_Sub2_1083.aByteArray1405, 0, 1);
                    anInt1007 = aClass30_Sub2_Sub2_1083.aByteArray1405[0] & 0xff;
                    i--;
                } else
                {
                    return false;
                }
            if(anInt1007 == -2)
                if(i > 1)
                {
                    aClass24_1168.method270(aClass30_Sub2_Sub2_1083.aByteArray1405, 0, 2);
                    aClass30_Sub2_Sub2_1083.anInt1406 = 0;
                    anInt1007 = aClass30_Sub2_Sub2_1083.method410();
                    i -= 2;
                } else
                {
                    return false;
                }
            if(i < anInt1007)
                return false;
            aClass30_Sub2_Sub2_1083.anInt1406 = 0;
            aClass24_1168.method270(aClass30_Sub2_Sub2_1083.aByteArray1405, 0, anInt1007);
            anInt1009 = 0;
            anInt843 = anInt842;
            anInt842 = anInt841;
            anInt841 = opcode;

            if(opcode == 81)
            {
                System.out.println("PACKET 81: Updating local player");
                method143(anInt1007, aClass30_Sub2_Sub2_1083);
                aBoolean1080 = false;
                opcode = -1;
                return true;
            }

            if(opcode == 176)
            {
                anInt1167 = aClass30_Sub2_Sub2_1083.method427(false);
                anInt1154 = aClass30_Sub2_Sub2_1083.method435(true);
                anInt1120 = aClass30_Sub2_Sub2_1083.method408();
                anInt1193 = aClass30_Sub2_Sub2_1083.method440(true);
                anInt1006 = aClass30_Sub2_Sub2_1083.method410();
                if(anInt1193 != 0 && anInt857 == -1)
                {
                    signlink.dnslookup(Class50.method586(anInt1193, true));
                    method147(537);
                    char c = '\u028A';
                    if(anInt1167 != 201 || anInt1120 == 1)
                        c = '\u028F';
                    aString881 = "";
                    aBoolean1158 = false;
                    for(int k9 = 0; k9 < Class9.aClass9Array210.length; k9++)
                    {
                        if(Class9.aClass9Array210[k9] == null || Class9.aClass9Array210[k9].anInt214 != c)
                            continue;
                        anInt857 = Class9.aClass9Array210[k9].anInt236;
                        break;
                    }

                }
                opcode = -1;
                return true;
            }
            if(opcode == 64)
            {
                anInt1268 = aClass30_Sub2_Sub2_1083.method427(false);
                anInt1269 = aClass30_Sub2_Sub2_1083.method428(2);
                for(int j = anInt1268; j < anInt1268 + 8; j++)
                {
                    for(int l9 = anInt1269; l9 < anInt1269 + 8; l9++)
                        if(aClass19ArrayArrayArray827[anInt918][j][l9] != null)
                        {
                            aClass19ArrayArrayArray827[anInt918][j][l9] = null;
                            method25(j, l9);
                        }

                }

                for(Class30_Sub1 class30_sub1 = (Class30_Sub1)aClass19_1179.method252(); class30_sub1 != null; class30_sub1 = (Class30_Sub1)aClass19_1179.method254(false))
                    if(class30_sub1.anInt1297 >= anInt1268 && class30_sub1.anInt1297 < anInt1268 + 8 && class30_sub1.anInt1298 >= anInt1269 && class30_sub1.anInt1298 < anInt1269 + 8 && class30_sub1.anInt1295 == anInt918)
                        class30_sub1.anInt1294 = 0;

                opcode = -1;
                return true;
            }
            if(opcode == 185)
            {
                int k = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                Class9.aClass9Array210[k].anInt233 = 3;
                if(aClass30_Sub2_Sub4_Sub1_Sub2_1126.aClass5_1698 == null)
                    Class9.aClass9Array210[k].anInt234 = (aClass30_Sub2_Sub4_Sub1_Sub2_1126.anIntArray1700[0] << 25) + (aClass30_Sub2_Sub4_Sub1_Sub2_1126.anIntArray1700[4] << 20) + (aClass30_Sub2_Sub4_Sub1_Sub2_1126.anIntArray1717[0] << 15) + (aClass30_Sub2_Sub4_Sub1_Sub2_1126.anIntArray1717[8] << 10) + (aClass30_Sub2_Sub4_Sub1_Sub2_1126.anIntArray1717[11] << 5) + aClass30_Sub2_Sub4_Sub1_Sub2_1126.anIntArray1717[1];
                else
                    Class9.aClass9Array210[k].anInt234 = (int)(0x12345678L + aClass30_Sub2_Sub4_Sub1_Sub2_1126.aClass5_1698.aLong78);
                opcode = -1;
                return true;
            }
            if(opcode == 107)
            {
                aBoolean1160 = false;
                for(int l = 0; l < 5; l++)
                    aBooleanArray876[l] = false;

                opcode = -1;
                return true;
            }
            if(opcode == 72)
            {
                int i1 = aClass30_Sub2_Sub2_1083.method434((byte)108);
                Class9 class9 = Class9.aClass9Array210[i1];
                for(int k15 = 0; k15 < class9.anIntArray253.length; k15++)
                {
                    class9.anIntArray253[k15] = -1;
                    class9.anIntArray253[k15] = 0;
                }

                opcode = -1;
                return true;
            }
            if(opcode == 214)
            {
                anInt822 = anInt1007 / 8;
                for(int j1 = 0; j1 < anInt822; j1++)
                    aLongArray925[j1] = aClass30_Sub2_Sub2_1083.method414(-35089);

                opcode = -1;
                return true;
            }
            if(opcode == 166)
            {
                aBoolean1160 = true;
                anInt1098 = aClass30_Sub2_Sub2_1083.method408();
                anInt1099 = aClass30_Sub2_Sub2_1083.method408();
                anInt1100 = aClass30_Sub2_Sub2_1083.method410();
                anInt1101 = aClass30_Sub2_Sub2_1083.method408();
                anInt1102 = aClass30_Sub2_Sub2_1083.method408();
                if(anInt1102 >= 100)
                {
                    anInt858 = anInt1098 * 128 + 64;
                    anInt860 = anInt1099 * 128 + 64;
                    anInt859 = method42(anInt918, anInt860, true, anInt858) - anInt1100;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 134)
            {
                aBoolean1153 = true;
                int k1 = aClass30_Sub2_Sub2_1083.method408();
                int i10 = aClass30_Sub2_Sub2_1083.method439((byte)41);
                int l15 = aClass30_Sub2_Sub2_1083.method408();
                anIntArray864[k1] = i10;
                anIntArray922[k1] = l15;
                anIntArray1044[k1] = 1;
                for(int k20 = 0; k20 < 98; k20++)
                    if(i10 >= anIntArray1019[k20])
                        anIntArray1044[k1] = k20 + 2;

                opcode = -1;
                return true;
            }
            if(opcode == 71)
            {
                int l1 = aClass30_Sub2_Sub2_1083.method410();
                int j10 = aClass30_Sub2_Sub2_1083.method426(0);
                if(l1 == 65535)
                    l1 = -1;
                anIntArray1130[j10] = l1;
                aBoolean1153 = true;
                aBoolean1103 = true;
                opcode = -1;
                return true;
            }
            if(opcode == 74)
            {
                int i2 = aClass30_Sub2_Sub2_1083.method434((byte)108);
                if(i2 == 65535)
                    i2 = -1;
                if(i2 != anInt956 && aBoolean1151 && !aBoolean960 && anInt1259 == 0)
                {
                    anInt1227 = i2;
                    aBoolean1228 = true;
                    aClass42_Sub1_1068.method558(2, anInt1227);
                }
                anInt956 = i2;
                opcode = -1;
                return true;
            }
            if(opcode == 121)
            {
                int j2 = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                int k10 = aClass30_Sub2_Sub2_1083.method435(true);
                if(aBoolean1151 && !aBoolean960)
                {
                    anInt1227 = j2;
                    aBoolean1228 = false;
                    aClass42_Sub1_1068.method558(2, anInt1227);
                    anInt1259 = k10;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 109)
            {
                method44(true);
                opcode = -1;
                return false;
            }
            if(opcode == 70)
            {
                int k2 = aClass30_Sub2_Sub2_1083.method411();
                int l10 = aClass30_Sub2_Sub2_1083.method437(-665);
                int i16 = aClass30_Sub2_Sub2_1083.method434((byte)108);
                Class9 class9_5 = Class9.aClass9Array210[i16];
                class9_5.anInt263 = k2;
                class9_5.anInt265 = l10;
                opcode = -1;
                return true;
            }
            if(opcode == 73 || opcode == 241)
            {
                int l2 = anInt1069;
                int i11 = anInt1070;
                if(opcode == 73)
                {
                    l2 = aClass30_Sub2_Sub2_1083.method435(true);
                    i11 = aClass30_Sub2_Sub2_1083.method410();
                    aBoolean1159 = false;
                }
                if(opcode == 241)
                {
                    i11 = aClass30_Sub2_Sub2_1083.method435(true);
                    aClass30_Sub2_Sub2_1083.method418(anInt1118);
                    for(int j16 = 0; j16 < 4; j16++)
                    {
                        for(int l20 = 0; l20 < 13; l20++)
                        {
                            for(int j23 = 0; j23 < 13; j23++)
                            {
                                int i26 = aClass30_Sub2_Sub2_1083.method419(1, 0);
                                if(i26 == 1)
                                    anIntArrayArrayArray1129[j16][l20][j23] = aClass30_Sub2_Sub2_1083.method419(26, 0);
                                else
                                    anIntArrayArrayArray1129[j16][l20][j23] = -1;
                            }

                        }

                    }

                    aClass30_Sub2_Sub2_1083.method420(true);
                    l2 = aClass30_Sub2_Sub2_1083.method410();
                    aBoolean1159 = true;
                }
                if(anInt1069 == l2 && anInt1070 == i11 && anInt1023 == 2)
                {
                    opcode = -1;
                    return true;
                }
                anInt1069 = l2;
                anInt1070 = i11;
                anInt1034 = (anInt1069 - 6) * 8;
                anInt1035 = (anInt1070 - 6) * 8;
                aBoolean1141 = false;
                if((anInt1069 / 8 == 48 || anInt1069 / 8 == 49) && anInt1070 / 8 == 48)
                    aBoolean1141 = true;
                if(anInt1069 / 8 == 48 && anInt1070 / 8 == 148)
                    aBoolean1141 = true;
                anInt1023 = 1;
                aLong824 = System.currentTimeMillis();
                aClass15_1165.method237(0);
                aClass30_Sub2_Sub1_Sub4_1271.method381(0, "Loading - please wait.", 23693, 151, 257);
                aClass30_Sub2_Sub1_Sub4_1271.method381(0xffffff, "Loading - please wait.", 23693, 150, 256);
                aClass15_1165.method238(4, 23680, super.aGraphics12, 4);
                if(opcode == 73)
                {
                    System.out.println("PACKET 73: Loading map region");
                    int k16 = 0;
                    for(int i21 = (anInt1069 - 6) / 8; i21 <= (anInt1069 + 6) / 8; i21++)
                    {
                        for(int k23 = (anInt1070 - 6) / 8; k23 <= (anInt1070 + 6) / 8; k23++)
                            k16++;

                    }

                    aByteArrayArray1183 = new byte[k16][];
                    aByteArrayArray1247 = new byte[k16][];
                    anIntArray1234 = new int[k16];
                    anIntArray1235 = new int[k16];
                    anIntArray1236 = new int[k16];
                    k16 = 0;
                    for(int l23 = (anInt1069 - 6) / 8; l23 <= (anInt1069 + 6) / 8; l23++)
                    {
                        for(int j26 = (anInt1070 - 6) / 8; j26 <= (anInt1070 + 6) / 8; j26++)
                        {
                            anIntArray1234[k16] = (l23 << 8) + j26;
                            if(aBoolean1141 && (j26 == 49 || j26 == 149 || j26 == 147 || l23 == 50 || l23 == 49 && j26 == 47))
                            {
                                anIntArray1235[k16] = -1;
                                anIntArray1236[k16] = -1;
                                k16++;
                            } else
                            {
                                int k28 = anIntArray1235[k16] = aClass42_Sub1_1068.method562(0, 0, j26, l23);
                                if(k28 != -1)
                                    aClass42_Sub1_1068.method558(3, k28);
                                int j30 = anIntArray1236[k16] = aClass42_Sub1_1068.method562(1, 0, j26, l23);
                                if(j30 != -1)
                                    aClass42_Sub1_1068.method558(3, j30);
                                k16++;
                            }
                        }

                    }

                }
                if(opcode == 241)
                {
                    int l16 = 0;
                    int ai[] = new int[676];
                    for(int i24 = 0; i24 < 4; i24++)
                    {
                        for(int k26 = 0; k26 < 13; k26++)
                        {
                            for(int l28 = 0; l28 < 13; l28++)
                            {
                                int k30 = anIntArrayArrayArray1129[i24][k26][l28];
                                if(k30 != -1)
                                {
                                    int k31 = k30 >> 14 & 0x3ff;
                                    int i32 = k30 >> 3 & 0x7ff;
                                    int k32 = (k31 / 8 << 8) + i32 / 8;
                                    for(int j33 = 0; j33 < l16; j33++)
                                    {
                                        if(ai[j33] != k32)
                                            continue;
                                        k32 = -1;
                                        break;
                                    }

                                    if(k32 != -1)
                                        ai[l16++] = k32;
                                }
                            }

                        }

                    }

                    aByteArrayArray1183 = new byte[l16][];
                    aByteArrayArray1247 = new byte[l16][];
                    anIntArray1234 = new int[l16];
                    anIntArray1235 = new int[l16];
                    anIntArray1236 = new int[l16];
                    for(int l26 = 0; l26 < l16; l26++)
                    {
                        int i29 = anIntArray1234[l26] = ai[l26];
                        int l30 = i29 >> 8 & 0xff;
                        int l31 = i29 & 0xff;
                        int j32 = anIntArray1235[l26] = aClass42_Sub1_1068.method562(0, 0, l31, l30);
                        if(j32 != -1)
                            aClass42_Sub1_1068.method558(3, j32);
                        int i33 = anIntArray1236[l26] = aClass42_Sub1_1068.method562(1, 0, l31, l30);
                        if(i33 != -1)
                            aClass42_Sub1_1068.method558(3, i33);
                    }

                }
                int i17 = anInt1034 - anInt1036;
                int j21 = anInt1035 - anInt1037;
                anInt1036 = anInt1034;
                anInt1037 = anInt1035;
                for(int j24 = 0; j24 < 16384; j24++)
                {
                    Class30_Sub2_Sub4_Sub1_Sub1 class30_sub2_sub4_sub1_sub1 = aClass30_Sub2_Sub4_Sub1_Sub1Array835[j24];
                    if(class30_sub2_sub4_sub1_sub1 != null)
                    {
                        for(int j29 = 0; j29 < 10; j29++)
                        {
                            ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anIntArray1500[j29] -= i17;
                            ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub1)).anIntArray1501[j29] -= j21;
                        }

                        class30_sub2_sub4_sub1_sub1.anInt1550 -= i17 * 128;
                        class30_sub2_sub4_sub1_sub1.anInt1551 -= j21 * 128;
                    }
                }

                for(int i27 = 0; i27 < anInt888; i27++)
                {
                    Class30_Sub2_Sub4_Sub1_Sub2 class30_sub2_sub4_sub1_sub2 = aClass30_Sub2_Sub4_Sub1_Sub2Array890[i27];
                    if(class30_sub2_sub4_sub1_sub2 != null)
                    {
                        for(int i31 = 0; i31 < 10; i31++)
                        {
                            ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anIntArray1500[i31] -= i17;
                            ((Class30_Sub2_Sub4_Sub1) (class30_sub2_sub4_sub1_sub2)).anIntArray1501[i31] -= j21;
                        }

                        class30_sub2_sub4_sub1_sub2.anInt1550 -= i17 * 128;
                        class30_sub2_sub4_sub1_sub2.anInt1551 -= j21 * 128;
                    }
                }

                aBoolean1080 = true;
                byte byte1 = 0;
                byte byte2 = 104;
                byte byte3 = 1;
                if(i17 < 0)
                {
                    byte1 = 103;
                    byte2 = -1;
                    byte3 = -1;
                }
                byte byte4 = 0;
                byte byte5 = 104;
                byte byte6 = 1;
                if(j21 < 0)
                {
                    byte4 = 103;
                    byte5 = -1;
                    byte6 = -1;
                }
                for(int k33 = byte1; k33 != byte2; k33 += byte3)
                {
                    for(int l33 = byte4; l33 != byte5; l33 += byte6)
                    {
                        int i34 = k33 + i17;
                        int j34 = l33 + j21;
                        for(int k34 = 0; k34 < 4; k34++)
                            if(i34 >= 0 && j34 >= 0 && i34 < 104 && j34 < 104)
                                aClass19ArrayArrayArray827[k34][k33][l33] = aClass19ArrayArrayArray827[k34][i34][j34];
                            else
                                aClass19ArrayArrayArray827[k34][k33][l33] = null;

                    }

                }

                for(Class30_Sub1 class30_sub1_1 = (Class30_Sub1)aClass19_1179.method252(); class30_sub1_1 != null; class30_sub1_1 = (Class30_Sub1)aClass19_1179.method254(false))
                {
                    class30_sub1_1.anInt1297 -= i17;
                    class30_sub1_1.anInt1298 -= j21;
                    if(class30_sub1_1.anInt1297 < 0 || class30_sub1_1.anInt1298 < 0 || class30_sub1_1.anInt1297 >= 104 || class30_sub1_1.anInt1298 >= 104)
                        class30_sub1_1.method329();
                }

                if(anInt1261 != 0)
                {
                    anInt1261 -= i17;
                    anInt1262 -= j21;
                }
                aBoolean1160 = false;
                opcode = -1;
                return true;
            }


            if(opcode == 208)
            {
                int i3 = aClass30_Sub2_Sub2_1083.method437(-665);
                if(i3 >= 0)
                    method60(i3, (byte)6);
                anInt1018 = i3;
                opcode = -1;
                return true;
            }
            if(opcode == 99)
            {
                anInt1021 = aClass30_Sub2_Sub2_1083.method408();
                opcode = -1;
                return true;
            }
            if(opcode == 75)
            {
                int j3 = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                int j11 = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                Class9.aClass9Array210[j11].anInt233 = 2;
                Class9.aClass9Array210[j11].anInt234 = j3;
                opcode = -1;
                return true;
            }
            if(opcode == 114)
            {
                anInt1104 = aClass30_Sub2_Sub2_1083.method434((byte)108) * 30;
                opcode = -1;
                return true;
            }
            if(opcode == 60)
            {
                anInt1269 = aClass30_Sub2_Sub2_1083.method408();
                anInt1268 = aClass30_Sub2_Sub2_1083.method427(false);
                while(aClass30_Sub2_Sub2_1083.anInt1406 < anInt1007) 
                {
                    int k3 = aClass30_Sub2_Sub2_1083.method408();
                    method137(anInt1119, aClass30_Sub2_Sub2_1083, k3);
                }
                opcode = -1;
                return true;
            }
            if(opcode == 35)
            {
                int l3 = aClass30_Sub2_Sub2_1083.method408();
                int k11 = aClass30_Sub2_Sub2_1083.method408();
                int j17 = aClass30_Sub2_Sub2_1083.method408();
                int k21 = aClass30_Sub2_Sub2_1083.method408();
                aBooleanArray876[l3] = true;
                anIntArray873[l3] = k11;
                anIntArray1203[l3] = j17;
                anIntArray928[l3] = k21;
                anIntArray1030[l3] = 0;
                opcode = -1;
                return true;
            }
            if(opcode == 174)
            {
                int i4 = aClass30_Sub2_Sub2_1083.method410();
                int l11 = aClass30_Sub2_Sub2_1083.method408();
                int k17 = aClass30_Sub2_Sub2_1083.method410();
                if(aBoolean848 && !aBoolean960 && anInt1062 < 50)
                {
                    anIntArray1207[anInt1062] = i4;
                    anIntArray1241[anInt1062] = l11;
                    anIntArray1250[anInt1062] = k17 + Class16.anIntArray326[i4];
                    anInt1062++;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 104)
            {
                int j4 = aClass30_Sub2_Sub2_1083.method427(false);
                int i12 = aClass30_Sub2_Sub2_1083.method426(0);
                String s6 = aClass30_Sub2_Sub2_1083.method415();
                if(j4 >= 1 && j4 <= 5)
                {
                    if(s6.equalsIgnoreCase("null"))
                        s6 = null;
                    aStringArray1127[j4 - 1] = s6;
                    aBooleanArray1128[j4 - 1] = i12 == 0;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 78)
            {
                anInt1261 = 0;
                opcode = -1;
                return true;
            }
            if(opcode == 253)
            {
                String s = aClass30_Sub2_Sub2_1083.method415();
                if(s.endsWith(":tradereq:"))
                {
                    String s3 = s.substring(0, s.indexOf(":"));
                    long l17 = Class50.method583(s3);
                    boolean flag2 = false;
                    for(int j27 = 0; j27 < anInt822; j27++)
                    {
                        if(aLongArray925[j27] != l17)
                            continue;
                        flag2 = true;
                        break;
                    }

                    if(!flag2 && anInt1251 == 0)
                        method77("wishes to trade with you.", 4, s3, aBoolean991);
                } else
                if(s.endsWith(":duelreq:"))
                {
                    String s4 = s.substring(0, s.indexOf(":"));
                    long l18 = Class50.method583(s4);
                    boolean flag3 = false;
                    for(int k27 = 0; k27 < anInt822; k27++)
                    {
                        if(aLongArray925[k27] != l18)
                            continue;
                        flag3 = true;
                        break;
                    }

                    if(!flag3 && anInt1251 == 0)
                        method77("wishes to duel with you.", 8, s4, aBoolean991);
                } else
                if(s.endsWith(":chalreq:"))
                {
                    String s5 = s.substring(0, s.indexOf(":"));
                    long l19 = Class50.method583(s5);
                    boolean flag4 = false;
                    for(int l27 = 0; l27 < anInt822; l27++)
                    {
                        if(aLongArray925[l27] != l19)
                            continue;
                        flag4 = true;
                        break;
                    }

                    if(!flag4 && anInt1251 == 0)
                    {
                        String s8 = s.substring(s.indexOf(":") + 1, s.length() - 9);
                        method77(s8, 8, s5, aBoolean991);
                    }
                } else
                {
                    method77(s, 0, "", aBoolean991);
                }
                opcode = -1;
                return true;
            }
            if(opcode == 1)
            {
                for(int k4 = 0; k4 < aClass30_Sub2_Sub4_Sub1_Sub2Array890.length; k4++)
                    if(aClass30_Sub2_Sub4_Sub1_Sub2Array890[k4] != null)
                        aClass30_Sub2_Sub4_Sub1_Sub2Array890[k4].anInt1526 = -1;

                for(int j12 = 0; j12 < aClass30_Sub2_Sub4_Sub1_Sub1Array835.length; j12++)
                    if(aClass30_Sub2_Sub4_Sub1_Sub1Array835[j12] != null)
                        aClass30_Sub2_Sub4_Sub1_Sub1Array835[j12].anInt1526 = -1;

                opcode = -1;
                return true;
            }
            if(opcode == 50)
            {
                long l4 = aClass30_Sub2_Sub2_1083.method414(-35089);
                int i18 = aClass30_Sub2_Sub2_1083.method408();
                String s7 = Class50.method587(-45804, Class50.method584(l4, (byte)-99));
                for(int k24 = 0; k24 < anInt899; k24++)
                {
                    if(l4 != aLongArray955[k24])
                        continue;
                    if(anIntArray826[k24] != i18)
                    {
                        anIntArray826[k24] = i18;
                        aBoolean1153 = true;
                        if(i18 > 0)
                            method77(s7 + " has logged in.", 5, "", aBoolean991);
                        if(i18 == 0)
                            method77(s7 + " has logged out.", 5, "", aBoolean991);
                    }
                    s7 = null;
                    break;
                }

                if(s7 != null && anInt899 < 200)
                {
                    aLongArray955[anInt899] = l4;
                    aStringArray1082[anInt899] = s7;
                    anIntArray826[anInt899] = i18;
                    anInt899++;
                    aBoolean1153 = true;
                }
                for(boolean flag6 = false; !flag6;)
                {
                    flag6 = true;
                    for(int k29 = 0; k29 < anInt899 - 1; k29++)
                        if(anIntArray826[k29] != anInt957 && anIntArray826[k29 + 1] == anInt957 || anIntArray826[k29] == 0 && anIntArray826[k29 + 1] != 0)
                        {
                            int j31 = anIntArray826[k29];
                            anIntArray826[k29] = anIntArray826[k29 + 1];
                            anIntArray826[k29 + 1] = j31;
                            String s10 = aStringArray1082[k29];
                            aStringArray1082[k29] = aStringArray1082[k29 + 1];
                            aStringArray1082[k29 + 1] = s10;
                            long l32 = aLongArray955[k29];
                            aLongArray955[k29] = aLongArray955[k29 + 1];
                            aLongArray955[k29 + 1] = l32;
                            aBoolean1153 = true;
                            flag6 = false;
                        }

                }

                opcode = -1;
                return true;
            }
            if(opcode == 110)
            {
                if(anInt1221 == 12)
                    aBoolean1153 = true;
                anInt1148 = aClass30_Sub2_Sub2_1083.method408();
                opcode = -1;
                return true;
            }
            if(opcode == 254)
            {
                anInt855 = aClass30_Sub2_Sub2_1083.method408();
                if(anInt855 == 1)
                    anInt1222 = aClass30_Sub2_Sub2_1083.method410();
                if(anInt855 >= 2 && anInt855 <= 6)
                {
                    if(anInt855 == 2)
                    {
                        anInt937 = 64;
                        anInt938 = 64;
                    }
                    if(anInt855 == 3)
                    {
                        anInt937 = 0;
                        anInt938 = 64;
                    }
                    if(anInt855 == 4)
                    {
                        anInt937 = 128;
                        anInt938 = 64;
                    }
                    if(anInt855 == 5)
                    {
                        anInt937 = 64;
                        anInt938 = 0;
                    }
                    if(anInt855 == 6)
                    {
                        anInt937 = 64;
                        anInt938 = 128;
                    }
                    anInt855 = 2;
                    anInt934 = aClass30_Sub2_Sub2_1083.method410();
                    anInt935 = aClass30_Sub2_Sub2_1083.method410();
                    anInt936 = aClass30_Sub2_Sub2_1083.method408();
                }
                if(anInt855 == 10)
                    anInt933 = aClass30_Sub2_Sub2_1083.method410();
                opcode = -1;
                return true;
            }
            if(opcode == 248)
            {
                int i5 = aClass30_Sub2_Sub2_1083.method435(true);
                int k12 = aClass30_Sub2_Sub2_1083.method410();
                if(anInt1276 != -1)
                {
                    anInt1276 = -1;
                    aBoolean1223 = true;
                }
                if(anInt1225 != 0)
                {
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
                anInt857 = i5;
                anInt1189 = k12;
                aBoolean1153 = true;
                aBoolean1103 = true;
                aBoolean1149 = false;
                opcode = -1;
                return true;
            }
            if(opcode == 79)
            {
                int j5 = aClass30_Sub2_Sub2_1083.method434((byte)108);
                int l12 = aClass30_Sub2_Sub2_1083.method435(true);
                Class9 class9_3 = Class9.aClass9Array210[j5];
                if(class9_3 != null && class9_3.anInt262 == 0)
                {
                    if(l12 < 0)
                        l12 = 0;
                    if(l12 > class9_3.anInt261 - class9_3.anInt267)
                        l12 = class9_3.anInt261 - class9_3.anInt267;
                    class9_3.anInt224 = l12;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 68)
            {
                for(int k5 = 0; k5 < anIntArray971.length; k5++)
                    if(anIntArray971[k5] != anIntArray1045[k5])
                    {
                        anIntArray971[k5] = anIntArray1045[k5];
                        method33(false, k5);
                        aBoolean1153 = true;
                    }

                opcode = -1;
                return true;
            }
            if(opcode == 196)
            {
                long l5 = aClass30_Sub2_Sub2_1083.method414(-35089);
                int j18 = aClass30_Sub2_Sub2_1083.method413();
                int l21 = aClass30_Sub2_Sub2_1083.method408();
                boolean flag5 = false;
                for(int i28 = 0; i28 < 100; i28++)
                {
                    if(anIntArray1240[i28] != j18)
                        continue;
                    flag5 = true;
                    break;
                }

                if(l21 <= 1)
                {
                    for(int l29 = 0; l29 < anInt822; l29++)
                    {
                        if(aLongArray925[l29] != l5)
                            continue;
                        flag5 = true;
                        break;
                    }

                }
                if(!flag5 && anInt1251 == 0)
                    try
                    {
                        anIntArray1240[anInt1169] = j18;
                        anInt1169 = (anInt1169 + 1) % 100;
                        String s9 = Class35.method525(anInt1007 - 13, true, aClass30_Sub2_Sub2_1083);
                        if(l21 != 3)
                            s9 = Class34.method497(s9, 0);
                        if(l21 == 2 || l21 == 3)
                            method77(s9, 7, "@cr2@" + Class50.method587(-45804, Class50.method584(l5, (byte)-99)), aBoolean991);
                        else
                        if(l21 == 1)
                            method77(s9, 7, "@cr1@" + Class50.method587(-45804, Class50.method584(l5, (byte)-99)), aBoolean991);
                        else
                            method77(s9, 3, Class50.method587(-45804, Class50.method584(l5, (byte)-99)), aBoolean991);
                    }
                    catch(Exception exception1)
                    {
                        signlink.reporterror("cde1");
                    }
                opcode = -1;
                return true;
            }
            if(opcode == 85)
            {
                anInt1269 = aClass30_Sub2_Sub2_1083.method427(false);
                anInt1268 = aClass30_Sub2_Sub2_1083.method427(false);
                opcode = -1;
                return true;
            }
            if(opcode == 24)
            {
                anInt1054 = aClass30_Sub2_Sub2_1083.method428(2);
                if(anInt1054 == anInt1221)
                {
                    if(anInt1054 == 3)
                        anInt1221 = 1;
                    else
                        anInt1221 = 3;
                    aBoolean1153 = true;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 246)
            {
                int i6 = aClass30_Sub2_Sub2_1083.method434((byte)108);
                int i13 = aClass30_Sub2_Sub2_1083.method410();
                int k18 = aClass30_Sub2_Sub2_1083.method410();
                if(k18 == 65535)
                {
                    Class9.aClass9Array210[i6].anInt233 = 0;
                    opcode = -1;
                    return true;
                } else
                {
                    Class8 class8 = Class8.method198(k18);
                    Class9.aClass9Array210[i6].anInt233 = 4;
                    Class9.aClass9Array210[i6].anInt234 = k18;
                    Class9.aClass9Array210[i6].anInt270 = class8.anInt190;
                    Class9.aClass9Array210[i6].anInt271 = class8.anInt198;
                    Class9.aClass9Array210[i6].anInt269 = (class8.anInt181 * 100) / i13;
                    opcode = -1;
                    return true;
                }
            }
            if(opcode == 171)
            {
                boolean flag1 = aClass30_Sub2_Sub2_1083.method408() == 1;
                int j13 = aClass30_Sub2_Sub2_1083.method410();
                Class9.aClass9Array210[j13].aBoolean266 = flag1;
                opcode = -1;
                return true;
            }
            if(opcode == 142)
            {
                int j6 = aClass30_Sub2_Sub2_1083.method434((byte)108);
                method60(j6, (byte)6);
                if(anInt1276 != -1)
                {
                    anInt1276 = -1;
                    aBoolean1223 = true;
                }
                if(anInt1225 != 0)
                {
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
                anInt1189 = j6;
                aBoolean1153 = true;
                aBoolean1103 = true;
                anInt857 = -1;
                aBoolean1149 = false;
                opcode = -1;
                return true;
            }
            if(opcode == 126)
            {
                String s1 = aClass30_Sub2_Sub2_1083.method415();
                int k13 = aClass30_Sub2_Sub2_1083.method435(true);
                Class9.aClass9Array210[k13].aString248 = s1;
                if(Class9.aClass9Array210[k13].anInt236 == anIntArray1130[anInt1221])
                    aBoolean1153 = true;
                opcode = -1;
                return true;
            }
            if(opcode == 206)
            {
                anInt1287 = aClass30_Sub2_Sub2_1083.method408();
                anInt845 = aClass30_Sub2_Sub2_1083.method408();
                anInt1248 = aClass30_Sub2_Sub2_1083.method408();
                aBoolean1233 = true;
                aBoolean1223 = true;
                opcode = -1;
                return true;
            }
            if(opcode == 240)
            {
                if(anInt1221 == 12)
                    aBoolean1153 = true;
                anInt878 = aClass30_Sub2_Sub2_1083.method411();
                opcode = -1;
                return true;
            }
            if(opcode == 8)
            {
                int k6 = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                int l13 = aClass30_Sub2_Sub2_1083.method410();
                Class9.aClass9Array210[k6].anInt233 = 1;
                Class9.aClass9Array210[k6].anInt234 = l13;
                opcode = -1;
                return true;
            }
            if(opcode == 122)
            {
                int l6 = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                int i14 = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                int i19 = i14 >> 10 & 0x1f;
                int i22 = i14 >> 5 & 0x1f;
                int l24 = i14 & 0x1f;
                Class9.aClass9Array210[l6].anInt232 = (i19 << 19) + (i22 << 11) + (l24 << 3);
                opcode = -1;
                return true;
            }
            if(opcode == 53)
            {
                aBoolean1153 = true;
                int i7 = aClass30_Sub2_Sub2_1083.method410();
                Class9 class9_1 = Class9.aClass9Array210[i7];
                int j19 = aClass30_Sub2_Sub2_1083.method410();
                for(int j22 = 0; j22 < j19; j22++)
                {
                    int i25 = aClass30_Sub2_Sub2_1083.method408();
                    if(i25 == 255)
                        i25 = aClass30_Sub2_Sub2_1083.method440(true);
                    class9_1.anIntArray253[j22] = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                    class9_1.anIntArray252[j22] = i25;
                }

                for(int j25 = j19; j25 < class9_1.anIntArray253.length; j25++)
                {
                    class9_1.anIntArray253[j25] = 0;
                    class9_1.anIntArray252[j25] = 0;
                }

                opcode = -1;
                return true;
            }
            if(opcode == 230)
            {
                int j7 = aClass30_Sub2_Sub2_1083.method435(true);
                int j14 = aClass30_Sub2_Sub2_1083.method410();
                int k19 = aClass30_Sub2_Sub2_1083.method410();
                int k22 = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                Class9.aClass9Array210[j14].anInt270 = k19;
                Class9.aClass9Array210[j14].anInt271 = k22;
                Class9.aClass9Array210[j14].anInt269 = j7;
                opcode = -1;
                return true;
            }
            if(opcode == 221)
            {
                anInt900 = aClass30_Sub2_Sub2_1083.method408();
                aBoolean1153 = true;
                opcode = -1;
                return true;
            }
            if(opcode == 177)
            {
                aBoolean1160 = true;
                anInt995 = aClass30_Sub2_Sub2_1083.method408();
                anInt996 = aClass30_Sub2_Sub2_1083.method408();
                anInt997 = aClass30_Sub2_Sub2_1083.method410();
                anInt998 = aClass30_Sub2_Sub2_1083.method408();
                anInt999 = aClass30_Sub2_Sub2_1083.method408();
                if(anInt999 >= 100)
                {
                    int k7 = anInt995 * 128 + 64;
                    int k14 = anInt996 * 128 + 64;
                    int i20 = method42(anInt918, k14, true, k7) - anInt997;
                    int l22 = k7 - anInt858;
                    int k25 = i20 - anInt859;
                    int j28 = k14 - anInt860;
                    int i30 = (int)Math.sqrt(l22 * l22 + j28 * j28);
                    anInt861 = (int)(Math.atan2(k25, i30) * 325.94900000000001D) & 0x7ff;
                    anInt862 = (int)(Math.atan2(l22, j28) * -325.94900000000001D) & 0x7ff;
                    if(anInt861 < 128)
                        anInt861 = 128;
                    if(anInt861 > 383)
                        anInt861 = 383;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 249)
            {
                anInt1046 = aClass30_Sub2_Sub2_1083.method426(0);
                anInt884 = aClass30_Sub2_Sub2_1083.method436((byte)-74);
                opcode = -1;
                return true;
            }
            if(opcode == 65)
            {
                method31(aClass30_Sub2_Sub2_1083, anInt1007, 973);
                opcode = -1;
                return true;
            }
            if(opcode == 27)
            {
                aBoolean1256 = false;
                anInt1225 = 1;
                aString1004 = "";
                aBoolean1223 = true;
                opcode = -1;
                return true;
            }
            if(opcode == 187)
            {
                aBoolean1256 = false;
                anInt1225 = 2;
                aString1004 = "";
                aBoolean1223 = true;
                opcode = -1;
                return true;
            }
            if(opcode == 97)
            {
                int l7 = aClass30_Sub2_Sub2_1083.method410();
                method60(l7, (byte)6);
                if(anInt1189 != -1)
                {
                    anInt1189 = -1;
                    aBoolean1153 = true;
                    aBoolean1103 = true;
                }
                if(anInt1276 != -1)
                {
                    anInt1276 = -1;
                    aBoolean1223 = true;
                }
                if(anInt1225 != 0)
                {
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
                anInt857 = l7;
                aBoolean1149 = false;
                opcode = -1;
                return true;
            }
            if(opcode == 218)
            {
                int i8 = aClass30_Sub2_Sub2_1083.method438(false);
                anInt1042 = i8;
                aBoolean1223 = true;
                opcode = -1;
                return true;
            }
            if(opcode == 87)
            {
                int j8 = aClass30_Sub2_Sub2_1083.method434((byte)108);
                int l14 = aClass30_Sub2_Sub2_1083.method439((byte)41);
                anIntArray1045[j8] = l14;
                if(anIntArray971[j8] != l14)
                {
                    anIntArray971[j8] = l14;
                    method33(false, j8);
                    aBoolean1153 = true;
                    if(anInt1042 != -1)
                        aBoolean1223 = true;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 36)
            {
                int k8 = aClass30_Sub2_Sub2_1083.method434((byte)108);
                byte byte0 = aClass30_Sub2_Sub2_1083.method409();
                anIntArray1045[k8] = byte0;
                if(anIntArray971[k8] != byte0)
                {
                    anIntArray971[k8] = byte0;
                    method33(false, k8);
                    aBoolean1153 = true;
                    if(anInt1042 != -1)
                        aBoolean1223 = true;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 61)
            {
                anInt1055 = aClass30_Sub2_Sub2_1083.method408();
                opcode = -1;
                return true;
            }
            if(opcode == 200)
            {
                int l8 = aClass30_Sub2_Sub2_1083.method410();
                int i15 = aClass30_Sub2_Sub2_1083.method411();
                Class9 class9_4 = Class9.aClass9Array210[l8];
                class9_4.anInt257 = i15;
                if(i15 == -1)
                {
                    class9_4.anInt246 = 0;
                    class9_4.anInt208 = 0;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 219)
            {
                if(anInt1189 != -1)
                {
                    anInt1189 = -1;
                    aBoolean1153 = true;
                    aBoolean1103 = true;
                }
                if(anInt1276 != -1)
                {
                    anInt1276 = -1;
                    aBoolean1223 = true;
                }
                if(anInt1225 != 0)
                {
                    anInt1225 = 0;
                    aBoolean1223 = true;
                }
                anInt857 = -1;
                aBoolean1149 = false;
                opcode = -1;
                return true;
            }
            if(opcode == 34)
            {
                aBoolean1153 = true;
                int i9 = aClass30_Sub2_Sub2_1083.method410();
                Class9 class9_2 = Class9.aClass9Array210[i9];
                while(aClass30_Sub2_Sub2_1083.anInt1406 < anInt1007) 
                {
                    int j20 = aClass30_Sub2_Sub2_1083.method422();
                    int i23 = aClass30_Sub2_Sub2_1083.method410();
                    int l25 = aClass30_Sub2_Sub2_1083.method408();
                    if(l25 == 255)
                        l25 = aClass30_Sub2_Sub2_1083.method413();
                    if(j20 >= 0 && j20 < class9_2.anIntArray253.length)
                    {
                        class9_2.anIntArray253[j20] = i23;
                        class9_2.anIntArray252[j20] = l25;
                    }
                }
                opcode = -1;
                return true;
            }
            if(opcode == 105 || opcode == 84 || opcode == 147 || opcode == 215 || opcode == 4 || opcode == 117 || opcode == 156 || opcode == 44 || opcode == 160 || opcode == 101 || opcode == 151)
            {
                method137(anInt1119, aClass30_Sub2_Sub2_1083, opcode);
                opcode = -1;
                return true;
            }
            if(opcode == 106)
            {
                anInt1221 = aClass30_Sub2_Sub2_1083.method427(false);
                aBoolean1153 = true;
                aBoolean1103 = true;
                opcode = -1;
                return true;
            }
            if(opcode == 164)
            {
                int j9 = aClass30_Sub2_Sub2_1083.method434((byte)108);
                method60(j9, (byte)6);
                if(anInt1189 != -1)
                {
                    anInt1189 = -1;
                    aBoolean1153 = true;
                    aBoolean1103 = true;
                }
                anInt1276 = j9;
                aBoolean1223 = true;
                anInt857 = -1;
                aBoolean1149 = false;
                opcode = -1;
                return true;
            }
            signlink.reporterror("T1 - " + opcode + "," + anInt1007 + " - " + anInt842 + "," + anInt843);
            method44(true);
        }
        catch(IOException _ex)
        {
            method68(-670);
        }
        catch(Exception exception)
        {
            String s2 = "T2 - " + opcode + "," + anInt842 + "," + anInt843 + " - " + anInt1007 + "," + (anInt1034 + ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1500[0]) + "," + (anInt1035 + ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anIntArray1501[0]) + " - ";
            for(int j15 = 0; j15 < anInt1007 && j15 < 50; j15++)
                s2 = s2 + aClass30_Sub2_Sub2_1083.aByteArray1405[j15] + ",";

            signlink.reporterror(s2);
            method44(true);
        }
        return true;
    }

    public final void method146(byte byte0)
    {
        anInt1265++;
        method47(0, true);
        method26(true, anInt882);
        method47(0, false);
        method26(false, anInt882);
        method55(-948);
        method104(true);
        if(!aBoolean1160)
        {
            int i = anInt1184;
            if(anInt984 / 256 > i)
                i = anInt984 / 256;
            if(aBooleanArray876[4] && anIntArray1203[4] + 128 > i)
                i = anIntArray1203[4] + 128;
            int k = anInt1185 + anInt896 & 0x7ff;
            method144(0, 600 + i * 3, i, anInt1014, method42(anInt918, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1551, true, ((Class30_Sub2_Sub4_Sub1) (aClass30_Sub2_Sub4_Sub1_Sub2_1126)).anInt1550) - 50, k, anInt1015);
        }
        int j;
        if(!aBoolean1160)
            j = method120(111);
        else
            j = method121(anInt1081);
        int l = anInt858;
        int i1 = anInt859;
        int j1 = anInt860;
        int k1 = anInt861;
        int l1 = anInt862;
        for(int i2 = 0; i2 < 5; i2++)
            if(aBooleanArray876[i2])
            {
                int j2 = (int)((Math.random() * (double)(anIntArray873[i2] * 2 + 1) - (double)anIntArray873[i2]) + Math.sin((double)anIntArray1030[i2] * ((double)anIntArray928[i2] / 100D)) * (double)anIntArray1203[i2]);
                if(i2 == 0)
                    anInt858 += j2;
                if(i2 == 1)
                    anInt859 += j2;
                if(i2 == 2)
                    anInt860 += j2;
                if(i2 == 3)
                    anInt862 = anInt862 + j2 & 0x7ff;
                if(i2 == 4)
                {
                    anInt861 += j2;
                    if(anInt861 < 128)
                        anInt861 = 128;
                    if(anInt861 > 383)
                        anInt861 = 383;
                }
            }

        int k2 = Class30_Sub2_Sub1_Sub3.anInt1481;
        Class30_Sub2_Sub4_Sub6.aBoolean1684 = true;
        if(byte0 != 1)
        {
            return;
        } else
        {
            Class30_Sub2_Sub4_Sub6.anInt1687 = 0;
            Class30_Sub2_Sub4_Sub6.anInt1685 = super.anInt20 - 4;
            Class30_Sub2_Sub4_Sub6.anInt1686 = super.anInt21 - 4;
            Class30_Sub2_Sub1.method334(aBoolean1206);
            aClass25_946.method313(anInt858, anInt860, anInt862, anInt859, j, anInt861, false);
            aClass25_946.method288((byte)104);
            method34(anInt898);
            method61(-252);
            method37(854, k2);
            method112(8);
            aClass15_1165.method238(4, 23680, super.aGraphics12, 4);
            anInt858 = l;
            anInt859 = i1;
            anInt860 = j1;
            anInt861 = k1;
            anInt862 = l1;
            return;
        }
    }

    public final void method147(int i)
    {
        aClass30_Sub2_Sub2_1192.method397((byte)6, 130);
        if(anInt1189 != -1)
        {
            anInt1189 = -1;
            aBoolean1153 = true;
            aBoolean1149 = false;
            aBoolean1103 = true;
        }
        if(anInt1276 != -1)
        {
            anInt1276 = -1;
            aBoolean1223 = true;
            aBoolean1149 = false;
        }
        anInt857 = -1;
        if(i <= 0)
            aClass30_Sub2_Sub2_1192.method398(13);
    }

    public client()
    {
        anIntArrayArray825 = new int[104][104];
        anIntArray826 = new int[200];
        aClass19ArrayArrayArray827 = new Class19[4][104][104];
        aBoolean830 = true;
        aBoolean831 = false;
        aClass30_Sub2_Sub2_834 = new Class30_Sub2_Sub2(new byte[5000], 891);
        aClass30_Sub2_Sub4_Sub1_Sub1Array835 = new Class30_Sub2_Sub4_Sub1_Sub1[16384];
        anIntArray837 = new int[16384];
        anInt838 = 9;
        anIntArray840 = new int[1000];
        aClass30_Sub2_Sub2_847 = Class30_Sub2_Sub2.method396(1, 9);
        aBoolean848 = true;
        anInt857 = -1;
        anIntArray864 = new int[Class45.anInt733];
        aBoolean872 = false;
        anIntArray873 = new int[5];
        anInt874 = -1;
        anInt875 = -680;
        aBooleanArray876 = new boolean[5];
        anInt877 = 1834;
        aBoolean880 = false;
        aString881 = "";
        anInt882 = -30815;
        anInt883 = 533;
        anInt884 = -1;
        aBoolean885 = false;
        aString887 = "";
        anInt888 = 2048;
        anInt889 = 2047;
        aClass30_Sub2_Sub4_Sub1_Sub2Array890 = new Class30_Sub2_Sub4_Sub1_Sub2[anInt888];
        anIntArray892 = new int[anInt888];
        anIntArray894 = new int[anInt888];
        aClass30_Sub2_Sub2Array895 = new Class30_Sub2_Sub2[anInt888];
        anInt897 = 1;
        anIntArrayArray901 = new int[104][104];
        anInt902 = 0x766654;
        aByteArray912 = new byte[16384];
        aByte920 = 14;
        anInt921 = 732;
        anIntArray922 = new int[Class45.anInt733];
        aByte923 = 25;
        aLongArray925 = new long[100];
        aBoolean926 = false;
        anInt927 = 0x332d25;
        anIntArray928 = new int[5];
        anIntArrayArray929 = new int[104][104];
        aCRC32_930 = new CRC32();
        anInt939 = 748;
        anIntArray942 = new int[100];
        aStringArray943 = new String[100];
        aStringArray944 = new String[100];
        aClass30_Sub2_Sub1_Sub2Array947 = new Class30_Sub2_Sub1_Sub2[13];
        aBoolean954 = true;
        aLongArray955 = new long[200];
        anInt956 = -1;
        aBoolean962 = false;
        anInt963 = -1;
        anInt964 = -1;
        anIntArray968 = new int[33];
        anIntArray969 = new int[256];
        aClass14Array970 = new Class14[5];
        anIntArray971 = new int[2000];
        aBoolean972 = false;
        aByte973 = -74;
        anInt975 = 50;
        anIntArray976 = new int[anInt975];
        anIntArray977 = new int[anInt975];
        anIntArray978 = new int[anInt975];
        anIntArray979 = new int[anInt975];
        anIntArray980 = new int[anInt975];
        anIntArray981 = new int[anInt975];
        anIntArray982 = new int[anInt975];
        aStringArray983 = new String[anInt975];
        anInt985 = -1;
        aClass30_Sub2_Sub1_Sub1Array987 = new Class30_Sub2_Sub1_Sub1[20];
        anIntArray990 = new int[5];
        aBoolean991 = false;
        aBoolean994 = false;
        anInt1002 = 0x23201b;
        aString1004 = "";
        aByte1012 = 24;
        aClass19_1013 = new Class19(169);
        aBoolean1017 = false;
        anInt1018 = -1;
        anIntArray1030 = new int[5];
        aBoolean1031 = false;
        aClass30_Sub2_Sub1_Sub1Array1033 = new Class30_Sub2_Sub1_Sub1[100];
        anInt1042 = -1;
        aBoolean1043 = false;
        anIntArray1044 = new int[Class45.anInt733];
        anIntArray1045 = new int[2000];
        aBoolean1047 = true;
        anInt1050 = 111;
        anIntArray1052 = new int[151];
        anInt1054 = -1;
        aClass19_1056 = new Class19(169);
        anIntArray1057 = new int[33];
        anInt1058 = 24869;
        aClass9_1059 = new Class9();
        aClass30_Sub2_Sub1_Sub2Array1060 = new Class30_Sub2_Sub1_Sub2[100];
        anInt1063 = 0x4d4233;
        anIntArray1065 = new int[7];
        anIntArray1072 = new int[1000];
        anIntArray1073 = new int[1000];
        aBoolean1080 = false;
        anInt1081 = -733;
        aStringArray1082 = new String[200];
        aClass30_Sub2_Sub2_1083 = Class30_Sub2_Sub2.method396(1, 9);
        anIntArray1090 = new int[9];
        anIntArray1091 = new int[500];
        anIntArray1092 = new int[500];
        anIntArray1093 = new int[500];
        anIntArray1094 = new int[500];
        aClass30_Sub2_Sub1_Sub1Array1095 = new Class30_Sub2_Sub1_Sub1[20];
        aBoolean1103 = false;
        anInt1105 = 519;
        aBoolean1106 = false;
        anInt1116 = 445;
        anInt1118 = -29508;
        anInt1119 = -77;
        aString1121 = "";
        aStringArray1127 = new String[5];
        aBooleanArray1128 = new boolean[5];
        anIntArrayArrayArray1129 = new int[4][13][13];
        anInt1132 = 2;
        anInt1135 = -12499;
        aClass30_Sub2_Sub1_Sub1Array1140 = new Class30_Sub2_Sub1_Sub1[1000];
        aBoolean1141 = false;
        aBoolean1149 = false;
        aClass30_Sub2_Sub1_Sub1Array1150 = new Class30_Sub2_Sub1_Sub1[8];
        aBoolean1151 = true;
        aBoolean1153 = false;
        aBoolean1157 = false;
        aBoolean1158 = false;
        aBoolean1159 = false;
        aBoolean1160 = false;
        anInt1171 = 1;
        aString1173 = "";
        aString1174 = "";
        aBoolean1176 = false;
        anInt1178 = -1;
        aClass19_1179 = new Class19(169);
        anInt1184 = 128;
        anInt1189 = -1;
        aClass30_Sub2_Sub2_1192 = Class30_Sub2_Sub2.method396(1, 9);
        aByte1194 = 5;
        aStringArray1199 = new String[500];
        anIntArray1203 = new int[5];
        aBoolean1206 = true;
        anIntArray1207 = new int[50];
        anInt1210 = 2;
        anInt1211 = 78;
        aString1212 = "";
        aByte1217 = 6;
        anInt1218 = -589;
        aClass30_Sub2_Sub1_Sub2Array1219 = new Class30_Sub2_Sub1_Sub2[2];
        anInt1221 = 3;
        aBoolean1223 = false;
        aBoolean1228 = true;
        anIntArray1229 = new int[151];
        aClass11Array1230 = new Class11[4];
        aBoolean1233 = false;
        anIntArray1240 = new int[100];
        anIntArray1241 = new int[50];
        aBoolean1242 = false;
        anIntArray1250 = new int[50];
        aBoolean1252 = false;
        aBoolean1255 = false;
        aBoolean1256 = false;
        aString1266 = "";
        aString1267 = "";
        aByte1274 = -13;
        anInt1276 = -1;
        aBoolean1277 = true;
        anInt1279 = 2;
        anIntArray1280 = new int[4000];
        anIntArray1281 = new int[4000];
        anInt1289 = -1;
    }

    private int anInt822;
    private static byte aByte823 = 77;
    private long aLong824;
    private int anIntArrayArray825[][];
    private int anIntArray826[];
    private Class19 aClass19ArrayArrayArray827[][][];
    private int anIntArray828[];
    private int anIntArray829[];
    private boolean aBoolean830;
    private volatile boolean aBoolean831;
    private Socket aSocket832;
    private int anInt833;
    private Class30_Sub2_Sub2 aClass30_Sub2_Sub2_834;
    private Class30_Sub2_Sub4_Sub1_Sub1 aClass30_Sub2_Sub4_Sub1_Sub1Array835[];
    private int anInt836;
    int anIntArray837[];
    private int anInt838;
    private int anInt839;
    int anIntArray840[];
    private int anInt841;
    private int anInt842;
    private int anInt843;
    private String aString844;
    private int anInt845;
    private static int anInt846;
    private Class30_Sub2_Sub2 aClass30_Sub2_Sub2_847;
    private boolean aBoolean848;
    private static int anInt849;
    private int anIntArray850[];
    private int anIntArray851[];
    private int anIntArray852[];
    private int anIntArray853[];
    private static int anInt854;
    private int anInt855;
    private static BigInteger aBigInteger856 = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    private int anInt857;
    private int anInt858;
    private int anInt859;
    private int anInt860;
    private int anInt861;
    private int anInt862;
    private int anInt863;
    private int anIntArray864[];
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_865;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_866;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_867;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_868;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_869;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_870;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_871;
    private boolean aBoolean872;
    private int anIntArray873[];
    private int anInt874;
    private int anInt875;
    private boolean aBooleanArray876[];
    private int anInt877;
    private int anInt878;
    Class48 aClass48_879;
    private volatile boolean aBoolean880;
    private String aString881;
    private int anInt882;
    private int anInt883;
    private int anInt884;
    private boolean aBoolean885;
    private int anInt886;
    private String aString887;
    private int anInt888;
    private int anInt889;
    private Class30_Sub2_Sub4_Sub1_Sub2 aClass30_Sub2_Sub4_Sub1_Sub2Array890[];
    private int anInt891;
    int anIntArray892[];
    private int anInt893;
    private int anIntArray894[];
    private Class30_Sub2_Sub2 aClass30_Sub2_Sub2Array895[];
    private int anInt896;
    private int anInt897;
    private int anInt898;
    private int anInt899;
    private int anInt900;
    private int anIntArrayArray901[][];
    private int anInt902;
    private Class15 aClass15_903;
    private Class15 aClass15_904;
    private Class15 aClass15_905;
    private Class15 aClass15_906;
    private Class15 aClass15_907;
    private Class15 aClass15_908;
    private Class15 aClass15_909;
    private Class15 aClass15_910;
    private Class15 aClass15_911;
    private byte aByteArray912[];
    private int anInt913;
    private int anInt914;
    private int anInt915;
    private int anInt916;
    private int anInt917;
    private int anInt918;
    private static boolean aBoolean919 = true;
    private byte aByte920;
    private int anInt921;
    private int anIntArray922[];
    private byte aByte923;
    private static int anInt924;
    private long aLongArray925[];
    private boolean aBoolean926;
    private int anInt927;
    private int anIntArray928[];
    private int anIntArrayArray929[][];
    private CRC32 aCRC32_930;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_931;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_932;
    private int anInt933;
    private int anInt934;
    private int anInt935;
    private int anInt936;
    private int anInt937;
    private int anInt938;
    private int anInt939;
    private static int anInt940;
    private static int anInt941;
    private int anIntArray942[];
    private String aStringArray943[];
    private String aStringArray944[];
    private int anInt945;
    private Class25 aClass25_946;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2Array947[];
    private int anInt948;
    private int anInt949;
    private int anInt950;
    private int anInt951;
    private int anInt952;
    private long aLong953;
    boolean aBoolean954;
    private long aLongArray955[];
    private int anInt956;
    private static int anInt957 = 10;
    static int anInt958;
    private static boolean aBoolean959 = true;
    private static boolean aBoolean960;
    private int anInt961;
    private volatile boolean aBoolean962;
    private int anInt963;
    private int anInt964;
    private int anIntArray965[] = {
        0xffff00, 0xff0000, 65280, 65535, 0xff00ff, 0xffffff
    };
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_966;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_967;
    private int anIntArray968[];
    private int anIntArray969[];
    Class14 aClass14Array970[];
    public int anIntArray971[];
    private boolean aBoolean972;
    private byte aByte973;
    private int anInt974;
    private int anInt975;
    private int anIntArray976[];
    private int anIntArray977[];
    private int anIntArray978[];
    private int anIntArray979[];
    private int anIntArray980[];
    private int anIntArray981[];
    private int anIntArray982[];
    private String aStringArray983[];
    private int anInt984;
    private int anInt985;
    private static int anInt986;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1Array987[];
    private int anInt988;
    private int anInt989;
    private int anIntArray990[];
    private boolean aBoolean991;
    private int anInt992;
    private static boolean aBoolean993;
    private boolean aBoolean994;
    private int anInt995;
    private int anInt996;
    private int anInt997;
    private int anInt998;
    private int anInt999;
    private Class17 aClass17_1000;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1001;
    private int anInt1002;
    static final int anIntArrayArray1003[][] = {
        {
            6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 
            2983, 54193
        }, {
            8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 
            56621, 4783, 1341, 16578, 35003, 25239
        }, {
            25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 
            10153, 56621, 4783, 1341, 16578, 35003
        }, {
            4626, 11146, 6439, 12, 4758, 10270
        }, {
            4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574
        }
    };
    private String aString1004;
    private static int anInt1005;
    private int anInt1006;
    private int anInt1007;
    private int opcode;
    private int anInt1009;
    private int anInt1010;
    private int anInt1011;
    private byte aByte1012;
    private Class19 aClass19_1013;
    private int anInt1014;
    private int anInt1015;
    private int anInt1016;
    private boolean aBoolean1017;
    private int anInt1018;
    private static int anIntArray1019[];
    private int anInt1020;
    private int anInt1021;
    int anInt1022;
    private int anInt1023;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1024;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1025;
    private int anInt1026;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1027;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1028;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1029;
    private int anIntArray1030[];
    private boolean aBoolean1031;
    private static BigInteger aBigInteger1032 = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1Array1033[];
    private int anInt1034;
    private int anInt1035;
    private int anInt1036;
    private int anInt1037;
    private int anInt1038;
    private int anInt1039;
    private int anInt1040;
    private int anInt1041;
    private int anInt1042;
    private boolean aBoolean1043;
    private int anIntArray1044[];
    private int anIntArray1045[];
    private int anInt1046;
    private boolean aBoolean1047;
    private int anInt1048;
    private String aString1049;
    private int anInt1050;
    private static int anInt1051;
    private int anIntArray1052[];
    private Class44 aClass44_1053;
    private int anInt1054;
    private int anInt1055;
    private Class19 aClass19_1056;
    private int anIntArray1057[];
    private int anInt1058;
    private Class9 aClass9_1059;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2Array1060[];
    static int anInt1061;
    private int anInt1062;
    private int anInt1063;
    private int anInt1064;
    private int anIntArray1065[];
    private int anInt1066;
    private int anInt1067;
    private Class42_Sub1 aClass42_Sub1_1068;
    private int anInt1069;
    private int anInt1070;
    private int anInt1071;
    private int anIntArray1072[];
    private int anIntArray1073[];
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1074;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1075;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1076;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1077;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1078;
    private int anInt1079;
    private boolean aBoolean1080;
    private int anInt1081;
    private String aStringArray1082[];
    private Class30_Sub2_Sub2 aClass30_Sub2_Sub2_1083;
    private int anInt1084;
    private int anInt1085;
    private int anInt1086;
    private int anInt1087;
    private int anInt1088;
    private int anInt1089;
    private int anIntArray1090[];
    private int anIntArray1091[];
    private int anIntArray1092[];
    private int anIntArray1093[];
    private int anIntArray1094[];
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1Array1095[];
    private static int anInt1096 = -192;
    private static int anInt1097;
    private int anInt1098;
    private int anInt1099;
    private int anInt1100;
    private int anInt1101;
    private int anInt1102;
    private boolean aBoolean1103;
    private int anInt1104;
    private int anInt1105;
    private boolean aBoolean1106;
    private Class15 aClass15_1107;
    private Class15 aClass15_1108;
    private Class15 aClass15_1109;
    private Class15 aClass15_1110;
    private Class15 aClass15_1111;
    private Class15 aClass15_1112;
    private Class15 aClass15_1113;
    private Class15 aClass15_1114;
    private Class15 aClass15_1115;
    private int anInt1116;
    private static int anInt1117;
    private int anInt1118;
    private int anInt1119;
    private int anInt1120;
    private String aString1121;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1122;
    private Class15 aClass15_1123;
    private Class15 aClass15_1124;
    private Class15 aClass15_1125;
    static Class30_Sub2_Sub4_Sub1_Sub2 aClass30_Sub2_Sub4_Sub1_Sub2_1126;
    private String aStringArray1127[];
    private boolean aBooleanArray1128[];
    private int anIntArrayArrayArray1129[][][];
    private int anIntArray1130[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1
    };
    private int anInt1131;
    private int anInt1132;
    private int anInt1133;
    private static int anInt1134;
    private int anInt1135;
    private int anInt1136;
    private int anInt1137;
    private int anInt1138;
    String aString1139;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1Array1140[];
    private boolean aBoolean1141;
    private static int anInt1142;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1143;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1144;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1145;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1146;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1147;
    private int anInt1148;
    private boolean aBoolean1149;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1Array1150[];
    private boolean aBoolean1151;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2Array1152[];
    private boolean aBoolean1153;
    private int anInt1154;
    private static int anInt1155;
    static boolean aBoolean1156;
    public boolean aBoolean1157;
    private boolean aBoolean1158;
    private boolean aBoolean1159;
    private boolean aBoolean1160;
    static int anInt1161;
    private static String aString1162 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    private Class15 aClass15_1163;
    private Class15 aClass15_1164;
    private Class15 aClass15_1165;
    private Class15 aClass15_1166;
    private int anInt1167;
    private Class24 aClass24_1168;
    private int anInt1169;
    private int anInt1170;
    private int anInt1171;
    private long aLong1172;
    private String aString1173;
    private String aString1174;
    private static int anInt1175;
    private boolean aBoolean1176;
    private final int anIntArray1177[] = {
        0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 
        2, 2, 3
    };
    private int anInt1178;
    private Class19 aClass19_1179;
    private int anIntArray1180[];
    private int anIntArray1181[];
    private int anIntArray1182[];
    private byte aByteArrayArray1183[][];
    private int anInt1184;
    private int anInt1185;
    private int anInt1186;
    private int anInt1187;
    private static int anInt1188;
    private int anInt1189;
    private int anIntArray1190[];
    private int anIntArray1191[];
    private Class30_Sub2_Sub2 aClass30_Sub2_Sub2_1192;
    private int anInt1193;
    private byte aByte1194;
    private int anInt1195;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1196;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1197;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2_1198;
    private String aStringArray1199[];
    private static byte aByte1200 = 9;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1201;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1202;
    private int anIntArray1203[];
    static final int anIntArray1204[] = {
        9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145, 
        58654, 5027, 1457, 16565, 34991, 25486
    };
    public static boolean aBoolean1205;
    private boolean aBoolean1206;
    private int anIntArray1207[];
    private int anInt1208;
    private int anInt1209;
    private int anInt1210;
    private int anInt1211;
    private String aString1212;
    private int anInt1213;
    private int anIntArrayArrayArray1214[][][];
    private long aLong1215;
    private int anInt1216;
    private byte aByte1217;
    private int anInt1218;
    private Class30_Sub2_Sub1_Sub2 aClass30_Sub2_Sub1_Sub2Array1219[];
    long aLong1220;
    private int anInt1221;
    private int anInt1222;
    private boolean aBoolean1223;
    private static boolean aBoolean1224 = true;
    private int anInt1225;
    private static int anInt1226;
    private int anInt1227;
    private boolean aBoolean1228;
    private int anIntArray1229[];
    private Class11 aClass11Array1230[];
    private static boolean aBoolean1231;
    public static int anIntArray1232[];
    private boolean aBoolean1233;
    private int anIntArray1234[];
    private int anIntArray1235[];
    private int anIntArray1236[];
    int anInt1237;
    int anInt1238;
    private final int anInt1239 = 100;
    private int anIntArray1240[];
    private int anIntArray1241[];
    private boolean aBoolean1242;
    private int anInt1243;
    private int anInt1244;
    private int anInt1245;
    private int anInt1246;
    private byte aByteArrayArray1247[][];
    private int anInt1248;
    private int anInt1249;
    private int anIntArray1250[];
    private int anInt1251;
    private boolean aBoolean1252;
    private int anInt1253;
    private int anInt1254;
    private boolean aBoolean1255;
    private boolean aBoolean1256;
    private int anInt1257;
    private byte aByteArrayArrayArray1258[][][];
    private int anInt1259;
    private static int anInt1260;
    private int anInt1261;
    private int anInt1262;
    private Class30_Sub2_Sub1_Sub1 aClass30_Sub2_Sub1_Sub1_1263;
    private int anInt1264;
    private int anInt1265;
    private String aString1266;
    private String aString1267;
    private int anInt1268;
    private int anInt1269;
    private Class30_Sub2_Sub1_Sub4 aClass30_Sub2_Sub1_Sub4_1270;
    private Class30_Sub2_Sub1_Sub4 aClass30_Sub2_Sub1_Sub4_1271;
    private Class30_Sub2_Sub1_Sub4 aClass30_Sub2_Sub1_Sub4_1272;
    private Class30_Sub2_Sub1_Sub4 aClass30_Sub2_Sub1_Sub4_1273;
    private byte aByte1274;
    private int anInt1275;
    private int anInt1276;
    private boolean aBoolean1277;
    private int anInt1278;
    private int anInt1279;
    private int anIntArray1280[];
    private int anIntArray1281[];
    private int anInt1282;
    private int anInt1283;
    private int anInt1284;
    private int anInt1285;
    String aString1286;
    private int anInt1287;
    private static int anInt1288;
    private int anInt1289;
    public static int anInt1290;

    static 
    {
        anIntArray1019 = new int[99];
        int i = 0;
        for(int j = 0; j < 99; j++)
        {
            int l = j + 1;
            int i1 = (int)((double)l + 300D * Math.pow(2D, (double)l / 7D));
            i += i1;
            anIntArray1019[j] = i / 4;
        }

        anIntArray1232 = new int[32];
        i = 2;
        for(int k = 0; k < 32; k++)
        {
            anIntArray1232[k] = i - 1;
            i += i;
        }

    }
}
