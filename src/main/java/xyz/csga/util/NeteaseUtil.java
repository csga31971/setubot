package xyz.csga.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.dongliu.requests.Requests;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 海外用不了网易云
 */
public class NeteaseUtil {
    private static String Encrypt(String sSrc, String sKey) throws Exception {
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        return new BASE64Encoder().encode(encrypted);
    }

    private static String get_params(String text) throws Exception {
        String first_key = "0CoJUm6Qyw8W8jud";
        String second_key = "FFFFFFFFFFFFFFFF";
        String h_encText = Encrypt(text, first_key);
        h_encText = Encrypt(h_encText, second_key);
        h_encText = URLEncoder.encode(h_encText,"utf-8");
        return h_encText;
    }

    private static String get_encSecKey() {
        String encSecKey = "257348aecb5e556c066de214e531faadd1c55d814f9be95fd06d6bff9f4c7a41f831f6394d5a3fd2e3881736d94a02ca919d952872e7d0a50ebfa1769a7a62d512f5f1ca21aec60bc3819a9c3ffca5eca9a0dba6d6f7249b06f5965ecfff3695b54e1c28f3f624750ed39e7de08fc8493242e26dbc4484a01c76f739e135637c";
        return encSecKey;
    }

    /*
    [
        {
            "no":12,
            "rt":"",
            "copyright":2,
            "fee":0,
            "privilege":{
                "st":0,
                "flag":128,
                "subp":1,
                "fl":320000,
                "fee":0,
                "dl":320000,
                "cp":1,
                "cs":false,
                "toast":false,
                "maxbr":320000,
                "id":22791468,
                "pl":320000,
                "sp":7,
                "payed":0
            },
            "mst":9,
            "pst":0,
            "pop":80.0,
            "dt":269819,
            "rtype":0,
            "s_id":0,
            "rtUrls":[

            ],
            "id":22791468,
            "st":0,
            "cd":"1",
            "publishTime":1319904000007,
            "cf":"",
            "h":{
                "br":320000,
                "fid":0,
                "size":10813496,
                "vd":-1.63
            },
            "mv":0,
            "al":{
                "picUrl":"http://p2.music.126.net/h95DNRsCBJH_7thjsJdlHg==/591537255765786.jpg",
                "name":"Parousia",
                "tns":[

                ],
                "id":2094525,
                "pic":591537255765786
            },
            "l":{
                "br":96000,
                "fid":0,
                "size":3264736,
                "vd":-1.37
            },
            "m":{
                "br":160000,
                "fid":0,
                "size":5421823,
                "vd":-1.27
            },
            "cp":663018,
            "alia":[

            ],
            "djId":0,
            "ar":[
                {
                    "name":"xi",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":15846
                }
            ],
            "ftype":0,
            "t":0,
            "v":6,
            "name":"FREEDOM DIVE↓"
        },
        {
            "no":14,
            "rt":"",
            "copyright":0,
            "fee":0,
            "privilege":{
                "st":0,
                "flag":128,
                "subp":1,
                "fl":320000,
                "fee":0,
                "dl":320000,
                "cp":1,
                "cs":false,
                "toast":false,
                "maxbr":320000,
                "id":1337009050,
                "pl":320000,
                "sp":7,
                "payed":0
            },
            "mst":9,
            "pst":0,
            "pop":25.0,
            "dt":206001,
            "rtype":0,
            "s_id":0,
            "rtUrls":[

            ],
            "id":1337009050,
            "st":0,
            "cd":"1/1",
            "publishTime":0,
            "cf":"",
            "h":{
                "br":320000,
                "fid":0,
                "size":8241154,
                "vd":-5.0
            },
            "mv":0,
            "al":{
                "picUrl":"http://p2.music.126.net/9r1PWT9qwn6c-6zQVzkHKQ==/109951163766512800.jpg",
                "name":"Quietus Ray",
                "tns":[

                ],
                "pic_str":"109951163766512800",
                "id":75025677,
                "pic":109951163766512800
            },
            "l":{
                "br":128000,
                "fid":0,
                "size":3296488,
                "vd":-4.0
            },
            "m":{
                "br":192000,
                "fid":0,
                "size":4944710,
                "vd":-5.0
            },
            "cp":663018,
            "alia":[

            ],
            "djId":0,
            "ar":[
                {
                    "name":"xi",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":15846
                }
            ],
            "ftype":0,
            "t":0,
            "v":1,
            "name":"FREEDOM DiVE[METAL†DIMENSIONS]"
        },
        {
            "no":2,
            "copyright":0,
            "fee":0,
            "privilege":{
                "st":0,
                "flag":130,
                "subp":1,
                "fl":320000,
                "fee":0,
                "dl":320000,
                "cp":1,
                "cs":false,
                "toast":false,
                "maxbr":320000,
                "id":487998296,
                "pl":320000,
                "sp":7,
                "payed":0
            },
            "mst":9,
            "pst":0,
            "pop":20.0,
            "dt":255190,
            "rtype":0,
            "s_id":0,
            "rtUrls":[

            ],
            "id":487998296,
            "st":0,
            "cd":"",
            "publishTime":1459339383596,
            "cf":"",
            "h":{
                "br":320000,
                "fid":0,
                "size":10209742,
                "vd":-2.0
            },
            "mv":0,
            "al":{
                "picUrl":"http://p2.music.126.net/dZ-KlAGtcn73jQxs0wbOHg==/109951162948170535.jpg",
                "name":"xi老爷神曲的钢琴版",
                "tns":[

                ],
                "pic_str":"109951162948170535",
                "id":35607414,
                "pic":109951162948170535
            },
            "l":{
                "br":128000,
                "fid":0,
                "size":4083923,
                "vd":-2.0
            },
            "m":{
                "br":192000,
                "fid":0,
                "size":6125862,
                "vd":-2.0
            },
            "cp":0,
            "alia":[

            ],
            "djId":0,
            "ar":[
                {
                    "name":"初哥来袭",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":12291649
                },
                {
                    "name":"xi",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":15846
                }
            ],
            "ftype":0,
            "t":0,
            "v":12,
            "name":"Freedom dive(钢琴版)"
        },
        {
            "no":6,
            "copyright":2,
            "fee":0,
            "privilege":{
                "st":0,
                "flag":128,
                "subp":1,
                "fl":320000,
                "fee":0,
                "dl":320000,
                "cp":1,
                "cs":false,
                "toast":false,
                "maxbr":320000,
                "id":37091598,
                "pl":320000,
                "sp":7,
                "payed":0
            },
            "mst":9,
            "pst":0,
            "pop":25.0,
            "dt":187297,
            "rtype":0,
            "s_id":0,
            "rtUrls":[

            ],
            "id":37091598,
            "st":0,
            "cd":"1",
            "publishTime":1445702400000,
            "cf":"",
            "h":{
                "br":320000,
                "fid":0,
                "size":7494051,
                "vd":-4.79
            },
            "mv":0,
            "al":{
                "picUrl":"http://p2.music.126.net/VUf_ztanBgzmALgKgoGiYw==/3274345631726738.jpg",
                "name":"Don't waste me! E.P.",
                "tns":[

                ],
                "id":3415264,
                "pic":3274345631726738
            },
            "l":{
                "br":96000,
                "fid":0,
                "size":2248246,
                "vd":-4.52
            },
            "m":{
                "br":160000,
                "fid":0,
                "size":3747048,
                "vd":-4.4
            },
            "cp":663018,
            "alia":[

            ],
            "djId":0,
            "ar":[
                {
                    "name":"xi",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":15846
                }
            ],
            "ftype":0,
            "t":0,
            "v":4,
            "name":"Freedom Dive↓ (tpz Overcute Remix)"
        },
        {
            "no":8,
            "copyright":2,
            "fee":0,
            "privilege":{
                "st":0,
                "flag":128,
                "subp":1,
                "fl":320000,
                "fee":0,
                "dl":320000,
                "cp":1,
                "cs":false,
                "toast":false,
                "maxbr":320000,
                "id":37091661,
                "pl":320000,
                "sp":7,
                "payed":0
            },
            "mst":9,
            "pst":0,
            "pop":20.0,
            "dt":365400,
            "rtype":0,
            "s_id":0,
            "rtUrls":[

            ],
            "id":37091661,
            "st":0,
            "cd":"1",
            "publishTime":1445702400000,
            "cf":"",
            "h":{
                "br":320000,
                "fid":0,
                "size":14618165,
                "vd":-3.98
            },
            "mv":0,
            "al":{
                "picUrl":"http://p2.music.126.net/J6k056FX1jI67hVdfqz_QA==/3276544655254283.jpg",
                "name":"Borderline named the fate",
                "tns":[

                ],
                "id":3415271,
                "pic":3276544655254283
            },
            "l":{
                "br":96000,
                "fid":0,
                "size":4385480,
                "vd":-3.86
            },
            "m":{
                "br":160000,
                "fid":0,
                "size":7309105,
                "vd":-3.63
            },
            "cp":663018,
            "alia":[

            ],
            "djId":0,
            "ar":[
                {
                    "name":"Next Reflection",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":1172007
                }
            ],
            "ftype":0,
            "t":0,
            "v":4,
            "name":"FREEDOM DiVE↓ (nora2r Remix)"
        },
        {
            "no":19,
            "copyright":1,
            "fee":8,
            "privilege":{
                "st":0,
                "flag":0,
                "subp":1,
                "fl":128000,
                "fee":8,
                "dl":0,
                "cp":1,
                "cs":false,
                "toast":false,
                "maxbr":999000,
                "id":544350197,
                "pl":128000,
                "sp":7,
                "payed":0
            },
            "mst":9,
            "pst":0,
            "pop":5.0,
            "dt":197433,
            "rtype":0,
            "s_id":0,
            "rtUrls":[

            ],
            "id":544350197,
            "st":0,
            "cd":"1",
            "publishTime":1483459200007,
            "cf":"",
            "h":{
                "br":320000,
                "fid":0,
                "size":7899472,
                "vd":1.0
            },
            "mv":0,
            "al":{
                "picUrl":"http://p2.music.126.net/8Pt_yUiEw6CXdcE0mVC5hw==/109951163180754923.jpg",
                "name":"Ambient Filter Deep Dive Three",
                "tns":[

                ],
                "pic_str":"109951163180754923",
                "id":37897436,
                "pic":109951163180754923
            },
            "l":{
                "br":128000,
                "fid":0,
                "size":3159815,
                "vd":1.0
            },
            "m":{
                "br":192000,
                "fid":0,
                "size":4739701,
                "vd":1.0
            },
            "cp":456010,
            "alia":[

            ],
            "djId":0,
            "ar":[
                {
                    "name":"Johnny Gadget",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":13519365
                }
            ],
            "ftype":0,
            "t":0,
            "v":3,
            "name":"freedom (ccMixter Mix)"
        },
        {
            "no":3,
            "copyright":1,
            "fee":8,
            "privilege":{
                "st":0,
                "flag":128,
                "subp":1,
                "fl":128000,
                "fee":8,
                "dl":0,
                "cp":1,
                "cs":false,
                "toast":false,
                "maxbr":999000,
                "id":544374845,
                "pl":128000,
                "sp":7,
                "payed":0
            },
            "mst":9,
            "pst":0,
            "pop":5.0,
            "dt":167576,
            "rtype":0,
            "s_id":0,
            "rtUrls":[

            ],
            "id":544374845,
            "st":0,
            "cd":"1",
            "publishTime":1483459200007,
            "cf":"",
            "h":{
                "br":320000,
                "fid":0,
                "size":6706199,
                "vd":0.0
            },
            "mv":0,
            "al":{
                "picUrl":"http://p2.music.126.net/p4NlhnoAauFoioiBnfOIag==/109951163180957903.jpg",
                "name":"Ambient Filter Deep Dive One",
                "tns":[

                ],
                "pic_str":"109951163180957903",
                "id":37897746,
                "pic":109951163180957903
            },
            "l":{
                "br":128000,
                "fid":0,
                "size":2682506,
                "vd":0.0
            },
            "m":{
                "br":192000,
                "fid":0,
                "size":4023737,
                "vd":0.0
            },
            "cp":456010,
            "alia":[

            ],
            "djId":0,
            "ar":[
                {
                    "name":"norelpref",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":13519362
                }
            ],
            "ftype":0,
            "t":0,
            "v":3,
            "name":"Freedom is Me (ccMixter Mix)"
        },
        {
            "no":11,
            "copyright":1,
            "fee":8,
            "privilege":{
                "st":0,
                "flag":128,
                "subp":1,
                "fl":128000,
                "fee":8,
                "dl":0,
                "cp":1,
                "cs":false,
                "toast":false,
                "maxbr":999000,
                "id":1301817955,
                "pl":128000,
                "sp":7,
                "payed":0
            },
            "mst":9,
            "pst":0,
            "pop":5.0,
            "dt":521599,
            "rtype":0,
            "s_id":0,
            "rtUrls":[

            ],
            "id":1301817955,
            "st":0,
            "cd":"1",
            "publishTime":1439481600007,
            "cf":"",
            "h":{
                "br":320000,
                "fid":0,
                "size":20866656,
                "vd":1349.0
            },
            "mv":0,
            "al":{
                "picUrl":"http://p2.music.126.net/X0qri1HVwzZXSTP346a3DQ==/109951163459966401.jpg",
                "name":"Deep in Ibiza 2015: Dive in a Deep House Journey (Compiled by Sandro S)",
                "tns":[

                ],
                "pic_str":"109951163459966401",
                "id":72314670,
                "pic":109951163459966401
            },
            "l":{
                "br":128000,
                "fid":0,
                "size":8346688,
                "vd":0.0
            },
            "m":{
                "br":192000,
                "fid":0,
                "size":12520011,
                "vd":3704.0
            },
            "cp":405025,
            "alia":[

            ],
            "djId":0,
            "ar":[
                {
                    "name":"Drumkraft",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":12883441
                }
            ],
            "ftype":0,
            "t":0,
            "v":3,
            "name":"Freedom"
        },
        {
            "no":9,
            "copyright":1,
            "fee":8,
            "privilege":{
                "st":0,
                "flag":128,
                "subp":1,
                "fl":128000,
                "fee":8,
                "dl":0,
                "cp":1,
                "cs":false,
                "toast":false,
                "maxbr":999000,
                "id":524069476,
                "pl":128000,
                "sp":7,
                "payed":0
            },
            "mst":9,
            "pst":0,
            "pop":5.0,
            "dt":458500,
            "rtype":0,
            "s_id":0,
            "rtUrls":[

            ],
            "id":524069476,
            "st":0,
            "cd":"1",
            "publishTime":1471536000007,
            "cf":"",
            "h":{
                "br":320000,
                "fid":0,
                "size":18342182,
                "vd":0.0
            },
            "mv":0,
            "al":{
                "picUrl":"http://p2.music.126.net/PpF0SkNF3gn61lK45-UHNw==/17962721463242630.jpg",
                "name":"Deep in Ibiza 2016 (Dive in a Deep House Journey)",
                "tns":[

                ],
                "pic_str":"17962721463242630",
                "id":36969281,
                "pic":17962721463242630
            },
            "l":{
                "br":128000,
                "fid":0,
                "size":7336899,
                "vd":0.0
            },
            "m":{
                "br":192000,
                "fid":0,
                "size":11005327,
                "vd":0.0
            },
            "cp":405025,
            "alia":[

            ],
            "djId":0,
            "ar":[
                {
                    "name":"Drumkraft",
                    "tns":[

                    ],
                    "alias":[

                    ],
                    "id":12883441
                }
            ],
            "ftype":0,
            "t":0,
            "v":6,
            "name":"Freedom (Jo fer Remix)"
        }
    ]
     */
    public static JSONArray searchSong(String name){
        try {
            Map map = new HashMap();
            map.put("s",name);
            map.put("type",1);
            String p = JSON.toJSONString(map);
            String params = "params=" + get_params(p) + "&encSecKey=" + get_encSecKey();
            URL url = new URL("http://music.163.com/weapi/cloudsearch/get/web?csrf_token=");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("X-REAL-IP", "140.143.137.169");
            connection.setRequestProperty("User-agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(params);
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int i;
            String result = "{";
            while((i=reader.read())!=-1){
                result+=reader.readLine();
            }
            System.out.println(result);
            JSONObject jsonObject = JSON.parseObject(result);
            JSONArray songs = jsonObject.getJSONObject("result").getJSONArray("songs");
            return songs;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMp3Link(int id) {
        Map map = new HashMap();
        String[] s = {String.valueOf(id)};
        map.put("ids",s);
        map.put("br",128000);
        map.put("csrf_token","");
        String p = JSON.toJSONString(map);
        String params = null;
        try {
            params = "params=" + get_params(p) + "&encSecKey=" + get_encSecKey();
            URL url = new URL("http://music.163.com/weapi/song/enhance/player/url");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("X-REAL-IP", "140.143.137.169");
            connection.setRequestProperty("User-agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(params);
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int i;
            String result = "{";
            while((i=reader.read())!=-1){
                result+=reader.readLine();
            }
            return JSON.parseObject(result)
                    .getJSONArray("data")
                    .getJSONObject(0)
                    .getString("url");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFirstMp3LinkByName(String name){
        JSONArray songs = searchSong(name);
        if(songs.size()>0){
            int id = songs.getJSONObject(0).getIntValue("id");
            return getMp3Link(id);
        }
        return null;
    }
}
