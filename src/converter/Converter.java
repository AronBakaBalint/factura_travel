// 
// Decompiled by Procyon v0.5.36
// 

package converter;

public class Converter
{
    public static String number2String(final int num) {
        String txt = "";
        final int m = num / 1000;
        final int s = num / 100 % 10;
        final int d = num / 10 % 10;
        final int e = num % 10;
        if (m > 0) {
            if (m == 1) {
                txt = String.valueOf(txt) + "unamie";
            }
            else {
                txt = String.valueOf(txt) + digit2String(m) + "mii";
            }
        }
        if (s > 0) {
            if (m == 0 && s == 1) {
                txt = String.valueOf(txt) + "unasuta";
            }
            else if (m != 0 && s == 1) {
                txt = String.valueOf(txt) + "osuta";
            }
            else {
                txt = String.valueOf(txt) + digit2String(s) + "sute";
            }
        }
        if (d > 0) {
            if (d == 1) {
                txt = String.valueOf(txt) + digit2String(d * 10 + e);
            }
            else {
                txt = String.valueOf(txt) + digit2String(d) + "zeci";
                if (e > 0) {
                    txt = String.valueOf(txt) + "si";
                    if (e == 2) {
                        txt = String.valueOf(txt) + "doi";
                    }
                    else {
                        txt = String.valueOf(txt) + digit2String(e);
                    }
                }
            }
        }
        else if (e != 2) {
            txt = String.valueOf(txt) + digit2String(e);
        }
        else {
            txt = String.valueOf(txt) + "doi";
        }
        return txt;
    }
    
    private static String digit2String(final int d) {
        String txt = "";
        if (d < 10) {
            switch (d) {
                case 1: {
                    txt = "unu";
                    break;
                }
                case 2: {
                    txt = "doua";
                    break;
                }
                case 3: {
                    txt = "trei";
                    break;
                }
                case 4: {
                    txt = "patru";
                    break;
                }
                case 5: {
                    txt = "cinci";
                    break;
                }
                case 6: {
                    txt = "sase";
                    break;
                }
                case 7: {
                    txt = "sapte";
                    break;
                }
                case 8: {
                    txt = "opt";
                    break;
                }
                case 9: {
                    txt = "noua";
                    break;
                }
            }
        }
        else if (d >= 10 && d <= 19) {
            switch (d) {
                case 10: {
                    txt = "zece";
                    break;
                }
                case 11: {
                    txt = "unsprezece";
                    break;
                }
                case 12: {
                    txt = "doisprezece";
                    break;
                }
                case 13: {
                    txt = "treisprezece";
                    break;
                }
                case 14: {
                    txt = "paisprezece";
                    break;
                }
                case 15: {
                    txt = "cincisprezece";
                    break;
                }
                case 16: {
                    txt = "saisprezece";
                    break;
                }
                case 17: {
                    txt = "saptesprezece";
                    break;
                }
                case 18: {
                    txt = "optsprezece";
                    break;
                }
                case 19: {
                    txt = "nouasprezece";
                    break;
                }
            }
        }
        return txt;
    }
}
